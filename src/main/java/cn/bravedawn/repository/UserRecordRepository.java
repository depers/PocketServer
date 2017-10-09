package cn.bravedawn.repository;

import cn.bravedawn.bean.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by 冯晓 on 2017/10/9.
 */
public interface UserRecordRepository extends
        JpaRepository<UserRecord, Integer> , JpaSpecificationExecutor<UserRecord>{

    public List<UserRecord> findByTitleStartingWithAndUserIdLessThan(String title, Integer userId);

    @Query("select o from UserRecord o where id = (select max(id) from UserRecord)")
    public UserRecord getUserRecordByMaxId();

    // 使用占位符
    /*@Query("select o from UserRecord o where o.id = ?1 and o.userId = ?2")
    public UserRecord getUserRecordByParam(Integer id, Integer userId);*/

    // 使用命名参数
    @Query("select o from UserRecord o where o.id=:id and o.userId=:userId")
    public UserRecord getUserRecordByParam(@Param("id") Integer id, @Param("userId") Integer userId);

    // 使用占位符
    /*@Query("select o from UserRecord o where o.title like %?1%")
    public List<UserRecord> getUserRecordLikeByTitle(String title);*/

    // 使用命名参数
    @Query("select o from UserRecord o where o.title like %:title%")
    public List<UserRecord> getUserRecordLikeByTitle(@Param("title") String title);


    @Query(nativeQuery = true, value = "SELECT count(1) FROM user_record")
    public Integer getCount();

    // 修改操作
    @Modifying
    @Query("update UserRecord o set o.userId = :userId where o.id = :id")
    public void update(@Param("id")Integer id, @Param("userId") Integer userId);


}
