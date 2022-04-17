package work.liziyun.service;

import work.liziyun.pojo.Love;

import java.util.List;

public interface LoveService {

    public List<Love> findByPage(Integer page);

    public void addLove(Love love);

    public void helpLovePower(Integer id);
    public void renewLovePower(Integer id,String password);
}
