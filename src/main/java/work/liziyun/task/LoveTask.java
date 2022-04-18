package work.liziyun.task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import work.liziyun.dao.LoveDao;

@Component
public class LoveTask {

    @Autowired
    LoveDao loveDao;

    @Scheduled(cron = "0 0 0 * * ?")
    @Transactional
    public void downLovewPower(){
        System.out.println("执行定时任务");
        // 所有爱意减少一
        loveDao.downOnePower();
        // 删除无爱意
        loveDao.deleteZeroPower();
        // 初始化每天助力
        loveDao.initHelpCount();
    }

}
