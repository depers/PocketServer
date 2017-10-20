package cn.bravedawn.repository;

import cn.bravedawn.bean.UserChannel;
import cn.bravedawn.common.JsonBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by 冯晓 on 2017/10/9.
 */
public interface UserChannelRepository extends JpaRepository<UserChannel,
        Integer>, JpaSpecificationExecutor<UserChannel> {

    List<UserChannel> findAllByUserIdOrderByUpdateDateDesc(Integer userId);

}
