package cn.bravedawn.serviceImpl;

import cn.bravedawn.bean.RecordChannel;
import cn.bravedawn.bean.UserChannel;
import cn.bravedawn.bean.UserRecord;
import cn.bravedawn.common.JsonBean;
import cn.bravedawn.common.JsonBeanBuilder;
import cn.bravedawn.common.ResponseCode;
import cn.bravedawn.repository.RecordChannelRepository;
import cn.bravedawn.repository.UserChannelRepository;
import cn.bravedawn.repository.UserRecordRepository;
import cn.bravedawn.service.RecordChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 冯晓 on 2017/10/9.
 */
@Service
public class RecordChannelServiceImpl implements RecordChannelService{

    @Autowired
    private RecordChannelRepository recordChannelRepository;

    @Autowired
    private UserRecordRepository userRecordRepository;

    @Autowired
    private UserChannelRepository userChannelRepository;

    public JsonBean getChannel(Integer recordId){
        RecordChannel recordChannel = recordChannelRepository.findByRecordId(recordId);
        if (recordChannel == null){
            recordChannel = new RecordChannel();
            recordChannel.setChannelId(0);
        }
        UserRecord record = userRecordRepository.findOne(recordId);
        List<UserChannel> userChannelList = userChannelRepository.findAllByUserId(record.getUserId());
        for (UserChannel userChannel :userChannelList){
            if (userChannel.getId() == recordChannel.getChannelId()){
                userChannel.setSelect(true);
            } else{
                userChannel.setSelect(false);
            }
        }

        return JsonBeanBuilder.builder()
                .setTotal(userChannelList.size())
                .setCode(ResponseCode.SUCCESS.getCode())
                .setMsg(ResponseCode.SUCCESS.getDesc())
                .setData(userChannelList)
                .build();
    }

    public JsonBean modify(Integer recordId, Integer channelId){
        UserRecord record = userRecordRepository.findOne(recordId);

        RecordChannel recordChannel = recordChannelRepository.findByRecordId(recordId);
        if (recordChannel != null){
            recordChannel.setChannelId(channelId);
        } else{
            recordChannel = new RecordChannel();
            recordChannel.setRecordId(recordId);
            recordChannel.setChannelId(channelId);
        }
        recordChannelRepository.save(recordChannel);
        return JsonBeanBuilder.builder()
                .setCode(ResponseCode.SUCCESS.getCode())
                .setMsg(ResponseCode.SUCCESS.getDesc())
                .build();
    }
}
