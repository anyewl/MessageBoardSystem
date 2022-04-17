package work.liziyun.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work.liziyun.dao.ArticleDao;
import work.liziyun.dao.CommentDao;
import work.liziyun.pojo.Comment;
import work.liziyun.service.CommentService;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Autowired
    ArticleDao articleDao;


    @Override
    public List<Comment> findByAid(Integer aid) {
        return commentDao.findByAidOrderByDate(aid);
    }


    @Transactional
    @Override
    public void addComment(Comment comment) {
        // 补充当前时间
        comment.setDate(new Date(System.currentTimeMillis()));
        // 新增
        commentDao.save(comment);
        // 添加个数
        articleDao.addComCount(comment.getAid());
    }
}
