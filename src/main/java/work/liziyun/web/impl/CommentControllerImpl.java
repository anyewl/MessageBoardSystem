package work.liziyun.web.impl;

import com.ramostear.captcha.HappyCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import work.liziyun.pojo.Comment;
import work.liziyun.pojo.Result;
import work.liziyun.service.CommentService;
import work.liziyun.service.impl.CaptchaServciceImpl;
import work.liziyun.web.CommentController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
public class CommentControllerImpl implements CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    CaptchaServciceImpl captchaServcice;

    @Override
    @GetMapping("/comment/findByAid.do")
    public Result allComment(Integer aid) {
        return new Result(true,200,"查询成功",commentService.findByAid(aid));
    }

    @Override
    @PostMapping("/comment/add.do")
    public Result addComment( Comment comment, String code, HttpServletRequest request, HttpServletResponse response) {
        System.out.println(code);
        // 获取当天时间
        boolean flag = HappyCaptcha.verification(request,code,true);
        if (!flag){
            return new Result(false,400,"验证吗错误");
        }else{
            // 清除缓存中验证吗
            HappyCaptcha.remove(request);
        }
        // 今天时间
        Integer count = 0;
        String today = "COMMENT" + new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
        for (Cookie cookie : request.getCookies()) {
            if (today.equals(cookie.getName())){
                if ( Integer.valueOf(cookie.getValue()) >= 5){
                    return new Result(false,400,"一天最多评论5条");
                }else {
                    count = Integer.valueOf(cookie.getValue());
                }
            }
        }
        // 内容检查
        if (comment.getName() != null && comment.getContent() != null && ( comment.getName().length() < 2 || comment.getContent().length() < 2 ) ){
            return new Result(false,400,"名称和内容太短");
        }

        // 添加评论
        commentService.addComment(comment);
        response.addCookie(new Cookie(today,String.valueOf(count+1)));
        return new Result(true,200,"成功");
    }
}
