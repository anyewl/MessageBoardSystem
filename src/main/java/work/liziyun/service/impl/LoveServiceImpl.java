package work.liziyun.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import work.liziyun.dao.LoveDao;
import work.liziyun.exception.MyException;
import work.liziyun.pojo.Love;
import work.liziyun.service.LoveService;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class LoveServiceImpl implements LoveService {

    @Autowired
    LoveDao loveDao;

    @Override
    public List<Love> findByPage(Integer page) {
        return loveDao.findByPage( 10*(page-1),10 );
    }

    @Override
    public void addLove(Love love) {
        love.setHelpCount(0);
        love.setPower(45);
        loveDao.save(love);
    }


    @Transactional
    @Override
    public void helpLovePower( Integer id) {
        Love love = loveDao.findById(id).get();
        if (love.getHelpCount() >= 5){
            throw new MyException("助力失败,每天只能5人帮忙助力!");
        }
        loveDao.addPower(1,id);
        Integer helpCount = love.getHelpCount();
        if (helpCount == null){
            helpCount = 0;
        }
        loveDao.modHelpCount(helpCount+1,id);
    }

    @Override
    @Transactional
    public void renewLovePower(Integer id, String password) {
        Love love = loveDao.findById(id).get();
        // 密码校验
        if (!love.getPassword().equals(password)){
            throw new RuntimeException("密码错误");
        }
        // 一月一次校验
        if (love.getLastTime() != null){
            // 上一次
            Date lastDate = love.getLastTime();
            Calendar c1 = Calendar.getInstance();
            c1.setTime(lastDate);
            // 当前
            Date curDate = new Date(System.currentTimeMillis());
            Calendar c2 = Calendar.getInstance();
            c2.setTime(curDate);
            // 年
            int lastYear = c1.get(Calendar.YEAR);
            int curYear = c2.get(Calendar.YEAR);
            int lastMon = c1.get(Calendar.MONTH);
            int curMon = c2.get(Calendar.MONTH);
            if (lastYear == curYear && lastMon == curMon){
                throw new RuntimeException("本月已经续约");
            }
        }
        // 开始续约
        loveDao.addPower(30,id);
        // 更新上次续约时间
        loveDao.updateLastTime(new Date(System.currentTimeMillis()),id);
    }
}
