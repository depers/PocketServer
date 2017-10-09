package cn.bravedawn.serviceImpl;

import cn.bravedawn.repository.UserRecordRepository;
import cn.bravedawn.service.UserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by 冯晓 on 2017/10/9.
 */

@Service
public class UserRecordServiceImpl implements UserRecordService{

    @Autowired
    private UserRecordRepository userRecordRepository;

    @Transactional
    public void update(Integer id, Integer userId){
        userRecordRepository.update(id, userId);
    }
}
