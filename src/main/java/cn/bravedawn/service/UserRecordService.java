package cn.bravedawn.service;


import cn.bravedawn.bean.UserRecord;
import cn.bravedawn.common.JsonBean;
import org.springframework.data.domain.Pageable;

/**
 * Created by 冯晓 on 2017/10/9.
 */


public interface UserRecordService {

    JsonBean queryAllByPage(Integer userId, Pageable pageable);

    JsonBean add(UserRecord userRecord);

    JsonBean delete(Integer recordId);

    JsonBean addStar(Integer recordId);

    JsonBean deleteStar(Integer recordId);

    JsonBean getStar(Integer userId);
}
