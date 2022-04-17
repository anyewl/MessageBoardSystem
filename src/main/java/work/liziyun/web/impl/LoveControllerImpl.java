package work.liziyun.web.impl;

import com.ramostear.captcha.HappyCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import work.liziyun.pojo.Love;
import work.liziyun.pojo.Result;
import work.liziyun.service.LoveService;
import work.liziyun.web.LoveController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;


@RestController()
public class LoveControllerImpl implements LoveController {

    @Autowired
    LoveService loveService;

    @Override
    @GetMapping("/love/findByPage.do")
    public Result findByPage(Integer page) {
        if (page == null || page <= 0){
            return new Result(true,400,"非法参数");
        }
        return new Result(true,200,"查询成功",loveService.findByPage(page));
    }

    @Override
    @PostMapping("/love/add.do")
    public Result addLove(Love love,String code, HttpServletRequest request, HttpServletResponse response) {
        boolean flag = HappyCaptcha.verification(request,code,true);
        if (!flag){
            return new Result(false,400,"验证吗错误");
        }else{
            // 清除缓存中验证吗
            HappyCaptcha.remove(request);
        }
        // 限制一天一次
        Integer count = 0;
        String today = "ADDLOVE" + new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
        for (Cookie cookie : request.getCookies()) {
            if (today.equals(cookie.getName())){
                if ( Integer.valueOf(cookie.getValue()) >= 1){
                    return new Result(false,400,"每人只能上榜一次");
                }else {
                    count = Integer.valueOf(cookie.getValue());
                }
            }
        }
        // 密码校验
        if (love.getPassword() == null || love.getPassword().length() < 6){
            return new Result(false,400,"密码至少6位数!");
        }
        // 名称校验
        if ( love.getName1() != null && love.getName2() != null && !love.getName1().equals("") && !love.getName2().equals("") ){
            String str = love.getName1() + love.getName2();
            int wordCount = 0;
            for (char c : str.toCharArray()) {
                if ( c > 250 ){
                    wordCount++;
                }
            }
            // 名称中包含字母或数字
            if ( wordCount != str.length() ){
                return new Result(false,400,"名字不合法,请输入真实姓名!");
            }
        }else {
            return new Result(false,400,"名称不能为空!");
        }
        loveService.addLove(love);
        response.addCookie(new Cookie(today,String.valueOf(count+1)));
        return new Result(true,400,"上榜成功");
    }

    @Override
    @GetMapping("/love/helpLove.do")
    public Result helpLove(Integer id, String code, HttpServletRequest request, HttpServletResponse response) {
        boolean flag = HappyCaptcha.verification(request,code,true);
        if (!flag){
            return new Result(false,400,"验证吗错误");
        }else{
            // 清除缓存中验证吗
            HappyCaptcha.remove(request);
        }
        Integer count = 0;
        String today = "HELPLOVE" + new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
        for (Cookie cookie : request.getCookies()) {
            if (today.equals(cookie.getName())){
                if ( Integer.valueOf(cookie.getValue()) >= 1){
                    return new Result(false,400,"每天只能助力一次");
                }else {
                    count = Integer.valueOf(cookie.getValue());
                }
            }
        }
        // 参数校验
        if (id == null){
            return new Result(false,400,"非法参数");
        }
        loveService.helpLovePower(id);
        response.addCookie(new Cookie(today,String.valueOf(count+1)));
        return new Result(true,200,"助力成功!");
    }

    @Override
    @GetMapping("/love/renewLove.do")
    public Result renewLove(Integer id, String code, String password, HttpServletRequest request, HttpServletResponse response) {
        boolean flag = HappyCaptcha.verification(request,code,true);
        if (!flag){
            return new Result(false,400,"验证吗错误");
        }else{
            // 清除缓存中验证吗
            HappyCaptcha.remove(request);
        }
        // 参数校验
        if (id == null){
            return new Result(false,400,"非法参数");
        }
        loveService.renewLovePower(id,password);
        return new Result(true,400,"续约成功");
    }
}
