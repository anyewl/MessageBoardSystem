package work.liziyun.web;

import work.liziyun.pojo.Comment;
import work.liziyun.pojo.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommentController {

    public Result allComment(Integer aid);


    public Result addComment(Comment comment, String code, HttpServletRequest request, HttpServletResponse response);

}
