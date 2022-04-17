package work.liziyun.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import work.liziyun.pojo.Comment;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<Comment, Integer> {



    public List<Comment> findByAidOrderByDate(Integer aid);

}
