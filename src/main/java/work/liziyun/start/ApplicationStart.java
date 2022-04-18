package work.liziyun.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import work.liziyun.dao.PictureDao;
import work.liziyun.dao.TagDao;
import work.liziyun.pojo.Tag;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Component

public class ApplicationStart implements ApplicationRunner {

    @Autowired
    PictureDao pictureDao;
    @Autowired
    TagDao tagDao;

    List<Integer> allIds;

    Set<Integer> tagIds;

    Random random = new Random();

    @Override
    public void run(ApplicationArguments args) throws Exception {
        allIds = pictureDao.findAllIds();
        tagIds = new HashSet();
        for (Tag tag : tagDao.findAll()) {
            tagIds.add(tag.getId());
        }
    }

    public boolean safeTag(Integer id){
        if (tagIds.contains(id)){
            return true;
        }else {
            return false;
        }
    }

    public Integer randomId(){
        int index = random.nextInt(allIds.size());
        return allIds.get(index);
    }

}
