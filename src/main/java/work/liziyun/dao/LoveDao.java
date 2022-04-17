package work.liziyun.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import work.liziyun.pojo.Article;
import work.liziyun.pojo.Love;

import java.util.Date;
import java.util.List;

@Repository
public interface LoveDao  extends JpaRepository<Love, Integer> {





    @Query(value = "select * from love Order By power Desc limit ?1,?2 ",nativeQuery=true)
    public List<Love> findByPage(Integer start, Integer size);

    @Modifying
    @Query(value = "update love set power = power + ?1 where id = ?2",nativeQuery=true)
    public void addPower(Integer count,Integer id);


    @Modifying
    @Query(value = "update love set help_count = ?1 where id = ?2",nativeQuery=true)
    public void modHelpCount(Integer count,Integer id);


    @Modifying
    @Query(value = "update love set help_count = 0",nativeQuery=true)
    public void initHelpCount();

    @Modifying
    @Query(value = "update love set power = power - 1",nativeQuery=true)
    public void downOnePower();

    @Modifying
    @Query(value = "delete from love where power <= 0",nativeQuery=true)
    public void deleteZeroPower();


    @Modifying
    @Query(value = "update love set last_time = ?1 where id = ?2",nativeQuery=true)
    public void updateLastTime(Date time,Integer id);



}
