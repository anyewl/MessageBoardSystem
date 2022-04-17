package work.liziyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.liziyun.dao.TagDao;
import work.liziyun.pojo.Tag;
import work.liziyun.service.TagService;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagDao tagDao;


    @Override
    public List<Tag> allTags() {
        return tagDao.findAll();
    }
}
