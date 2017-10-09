package cn.bravedawn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by 冯晓 on 2017/10/9.
 */
public interface UserChannelRepository extends JpaRepository<UserChannelRepository,
        Integer>, JpaSpecificationExecutor<UserChannelRepository> {
}
