package work.liziyun.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import work.liziyun.pojo.Tag;




@Repository
public interface TagDao extends JpaRepository<Tag, Integer> {

}
