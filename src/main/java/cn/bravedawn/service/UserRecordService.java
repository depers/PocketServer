package cn.bravedawn.service;


import cn.bravedawn.jo.JsonBean;
import org.springframework.data.domain.Pageable;

/**
 * Created by 冯晓 on 2017/10/9.
 */


public interface UserRecordService {

    JsonBean queryAllByPage(Integer userId, Pageable pageable);
}
