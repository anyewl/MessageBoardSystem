package work.liziyun.service;

import work.liziyun.pojo.Article;

import java.util.List;

public interface ArticleService {

    public Article findById(Integer id);

    public void addArticle(Article article);

    public List<Article> findByPage(Integer page,Integer tagId);
}
