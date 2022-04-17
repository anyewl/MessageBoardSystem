package work.liziyun.web;

import org.springframework.http.HttpRequest;
import work.liziyun.pojo.Love;
import work.liziyun.pojo.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface LoveController {

    public Result findByPage(Integer page);

    public Result addLove(Love love,String code, HttpServletRequest request, HttpServletResponse response);

    public Result helpLove(Integer id, String code, HttpServletRequest request, HttpServletResponse response);

    public Result renewLove(Integer id,String code,String password, HttpServletRequest request, HttpServletResponse response);

}
