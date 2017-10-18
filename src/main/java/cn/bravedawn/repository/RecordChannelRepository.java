package cn.bravedawn.repository;

import cn.bravedawn.bean.RecordChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by 冯晓 on 2017/10/9.
 */
public interface RecordChannelRepository extends JpaRepository<RecordChannel, Integer>,
        JpaSpecificationExecutor<RecordChannel>{

    List<RecordChannel> findAllByChannelId(Integer channelId);

    RecordChannel findByRecordId(Integer recordId);
}
