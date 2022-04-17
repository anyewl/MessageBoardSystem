package work.liziyun.service;

import work.liziyun.pojo.Comment;
import work.liziyun.pojo.Tag;

import java.util.List;

public interface CommentService {

    public List<Comment> findByAid(Integer aid);

    public void addComment(Comment comment);
}
