package work.liziyun.web.impl;


import com.ramostear.captcha.HappyCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;
import work.liziyun.pojo.Article;
import work.liziyun.pojo.Result;
import work.liziyun.service.ArticleService;
import work.liziyun.start.ApplicationStart;
import work.liziyun.web.ArticleController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController()
public class ArticleControllerImpl implements ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    ApplicationStart applicationStart;

    @GetMapping("/article/findByPage.do")
    public Result findByPage(Integer page,Integer tagId){
        List<Article> articles = articleService.findByPage(page,tagId);
        return new Result(true,200,"成功",articles);
    }
    @GetMapping("/article/findById.do")
    public Result findByPage(Integer id){
        Article article = articleService.findById(id);
        return new Result(true,200,"成功",article);
    }


    @Override
    @PostMapping("/article/add.do")
    public Result addArticle(@RequestParam(value = "file", required = false) MultipartFile file, Article article, String code, HttpServletRequest request, HttpServletResponse response) throws IOException {


        boolean flag = HappyCaptcha.verification(request,code,true);
        if (!flag){
            return new Result(false,400,"验证吗错误");
        }else{
            // 清除缓存中验证吗
            HappyCaptcha.remove(request);
        }

        // 今天时间
        Integer count = 0;
        String today = "ARTICLE" + new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
        for (Cookie cookie : request.getCookies()) {
            if (today.equals(cookie.getName())){
                if ( Integer.valueOf(cookie.getValue()) >= 2){
                    return new Result(false,400,"一天最多发布两篇！");
                }else {
                    count = Integer.valueOf(cookie.getValue());
                }
            }
        }

        // 生成图片
        if ( file != null && !article.isRandom() && !file.isEmpty()){
            // 文件名称
            String fileName = file.getOriginalFilename();
            // 检查图片后缀
            int index = fileName.lastIndexOf(".");
            if (index != -1){
                String suffix = fileName.substring(index+1);
                if ( suffix != null && (suffix.contains("jpg")||suffix.contains("png")||suffix.contains("jpeg"))  ) {
                    // 格式正确
                    // 图片名称
                    BASE64Encoder base64Encoder = new BASE64Encoder();
                    String base64img = "data:"+file.getContentType()+";base64,"+base64Encoder.encode(file.getBytes());
                    article.setImgSrc(base64img);
                }else {
                    // 格式错误
                    return new Result(false,400,"格式错误，仅支持png,jpg,jpeg");
                }
            }else {
                // 不存在后缀
                return new Result(false,400,"图片不存在后缀");
            }
        }
        // 非空检查
        if ( article.getContent() != null && article.getName() != null  && (article.getContent().length() < 1 || article.getName().length() < 1)){
            return new Result(false,400,"内容与名称必填");
        }
        // 水文检测
        if (article.getContent()!=null){
            // 非汉字个数
            int powerCharCount = 0;
            // 所有内容
            String allContent = article.getName() + article.getContent();
            for (char c : allContent.toCharArray()) {
                // 普通字符
                if (c < 256){
                    powerCharCount++;
                }
            }
            if (powerCharCount == allContent.length()){
                // 水贴将记录发帖次数！！！
                response.addCookie(new Cookie(today,String.valueOf(count+1)));
                return new Result(false,400,"请勿水贴");
            }
        }

        // 标签合法性检查
        if (article.getTagId()!=null ){
            if (article.getTagId()==1024 || !applicationStart.safeTag(article.getTagId())){
                return new Result(false,400,"标签不合法");
            }
        }else {
            return new Result(false,400,"标签不合法");
        }

        articleService.addArticle(article);
        response.addCookie(new Cookie(today,String.valueOf(count+1)));
        return new Result(true,200,"发布成功!");
    }
}
