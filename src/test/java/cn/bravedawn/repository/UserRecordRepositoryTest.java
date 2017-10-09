package cn.bravedawn.repository;

import cn.bravedawn.bean.UserRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


/**
 * Created by 冯晓 on 2017/10/9.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRecordRepositoryTest {

    @Autowired
    private UserRecordRepository userRecordRepository;


    @Test
    public void findOne(){
        UserRecord record = userRecordRepository.findOne(1);
        System.out.println(record.toString());
    }

    @Test
    public void insertOne(){
        UserRecord record = new UserRecord();
        record.setTitle("Spring Data JPA 学习");
        record.setResource("mp.weixin.com");
        record.setColorAvatar("#323232");
        record.setStar("b");
        record.setUserId(1);
        record.setUpdateDate(new Date());
        record.setUrl("http://www.bravedawn.cn");
        userRecordRepository.save(record);
    }

    @Test
    public void testFindByTitleStartingWithAndUserIdLessThan(){
        List<UserRecord> userRecordList =
                userRecordRepository.findByTitleStartingWithAndUserIdLessThan("python", 5);

        for (UserRecord record : userRecordList){
            System.out.println(record.toString());
        }
    }

    @Test
    public void testGetUserRecordByMaxId(){
        UserRecord record = userRecordRepository.getUserRecordByMaxId();

        System.out.println(record.toString());
    }

    @Test
    public void testGetUserRecordByParam(){
        UserRecord record = userRecordRepository.getUserRecordByParam(10, 8);

        System.out.println(record.toString());
    }

    @Test
    public void testGetUserRecordLikeByTitle(){
        List<UserRecord> userRecordList =
                userRecordRepository.getUserRecordLikeByTitle("python");

        for (UserRecord record : userRecordList){
            System.out.println(record.toString());
        }
    }

    @Test
    public void testGetCount(){
        Integer count = userRecordRepository.getCount();

        System.out.println(count);
    }


}