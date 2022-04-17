package work.liziyun.service;

import work.liziyun.pojo.Picture;
import work.liziyun.pojo.Result;

import java.util.List;

public interface PictureService {


    public void addPictires(List<String> datas);
    public List<Picture> findByPage(int page);

    public void deleteIds(List<Integer> ids);

}
