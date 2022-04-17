package work.liziyun.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import work.liziyun.pojo.Article;

import java.util.List;


@Repository
public interface ArticleDao extends JpaRepository<Article, Integer> {

    @Query(value = "select * from article where tag_id != 1024 Order By time Desc limit ?1,?2",nativeQuery=true)
    public List<Article> findByPage(int start,int size);

    @Query(value = "select * from article where tag_id = ?3 Order By time Desc limit ?1,?2",nativeQuery=true)
    public List<Article> findByPageAndTag(int start,int size,int tagId);

    public List<Article> findByTagId(int tadId);


    @Modifying
    @Query(value = "update article set com_count = com_count + 1  where id = ?1",nativeQuery=true)
    public void addComCount(Integer id);
}
