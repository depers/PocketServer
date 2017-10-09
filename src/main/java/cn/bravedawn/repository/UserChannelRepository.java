package cn.bravedawn.repository;

import cn.bravedawn.bean.UserChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by 冯晓 on 2017/10/9.
 */
public interface UserChannelRepository extends JpaRepository<UserChannel,
        Integer>, JpaSpecificationExecutor<UserChannel> {
}
