package work.liziyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.liziyun.dao.PictureDao;
import work.liziyun.pojo.Article;
import work.liziyun.dao.ArticleDao;
import work.liziyun.pojo.Picture;
import work.liziyun.service.ArticleService;
import work.liziyun.start.ApplicationStart;

import java.util.Date;
import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;
    @Autowired
    ApplicationStart applicationStart;
    @Autowired
    PictureDao pictureDao;

    @Override
    public Article findById(Integer id) {
        return articleDao.findById(id).get();
    }

    @Override
    public void addArticle(Article article) {
        article.setTime(new Date(System.currentTimeMillis()));
        article.setComCount(0);
        if (article.isRandom()){
            Integer imgId = applicationStart.randomId();
            Picture picture = pictureDao.findById(imgId).get();
            // 设置图片内容
            article.setImgSrc(picture.getData());
        }
        articleDao.save(article);
    }




    @Override
    public List<Article> findByPage(Integer page, Integer tagId) {
        // 存在Tag
        if (tagId != null){
            List<Article> rs = articleDao.findByPageAndTag((page - 1) * 5, 5,tagId);
            return rs;
        }else {// 不存在Tag
            List<Article> rs = articleDao.findByPage((page - 1) * 5, 5);
            if (page == 1){
                // 添加一条官方消息
                List<Article> list = articleDao.findByTagId(1024);
                if (list.size() > 0){
                    rs.add(0,list.get(0));
                }

            }
            return rs;
        }
    }


}
