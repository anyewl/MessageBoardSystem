package work.liziyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.liziyun.dao.PictureDao;
import work.liziyun.dao.TagDao;
import work.liziyun.pojo.Article;
import work.liziyun.pojo.Picture;
import work.liziyun.pojo.Tag;
import work.liziyun.service.PictureService;
import work.liziyun.service.TagService;

import java.util.Date;
import java.util.List;

@Service
public class PictireServiceImpl implements PictureService {

    @Autowired
    PictureDao pictureDao;


    @Override
    public void addPictires(List<String> datas) {
        for (String data : datas) {
            Picture picture = new Picture();
            picture.setData(data);
            picture.setTime(new Date(System.currentTimeMillis()));
            pictureDao.save(picture);
        }
    }

    @Override
    public List<Picture> findByPage(int page) {
        List<Picture> rs = pictureDao.findByPage((page - 1) * 5, 5);
        return rs;
    }

    @Override
    public void deleteIds(List<Integer> ids) {
        for (Integer id : ids) {
            pictureDao.deleteById(id);
        }
    }

}
