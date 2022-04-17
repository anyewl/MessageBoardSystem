package work.liziyun.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import work.liziyun.pojo.Picture;

import java.util.List;


@Repository
public interface PictureDao extends JpaRepository<Picture, Integer> {
    @Query(value = "select * from picture Order By time Desc limit ?1,?2",nativeQuery=true)
    public List<Picture> findByPage(int start,int size);


    @Query(value = "select id from picture",nativeQuery=true)
    public List<Integer> findAllIds();

}
