package work.liziyun.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CaptchaService {
    // 生成验证码
    public void happyCaptcha(HttpServletRequest request, HttpServletResponse response);
    //
}
