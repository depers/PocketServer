package cn.bravedawn.serviceImpl;

import cn.bravedawn.bean.ComUser;
import cn.bravedawn.bean.RecordChannel;
import cn.bravedawn.bean.UserChannel;
import cn.bravedawn.bean.UserRecord;
import cn.bravedawn.common.JsonBean;
import cn.bravedawn.common.JsonBeanBuilder;
import cn.bravedawn.common.ResponseCode;
import cn.bravedawn.repository.ComUserRepository;
import cn.bravedawn.repository.RecordChannelRepository;
import cn.bravedawn.repository.UserChannelRepository;
import cn.bravedawn.repository.UserRecordRepository;
import cn.bravedawn.service.UserChannelService;
import cn.bravedawn.service.UserRecordService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by 冯晓 on 2017/10/9.
 */
@Service
public class UserChannelServiceImpl implements UserChannelService {

    private static String[] imageUrl = {
            "http://oxut2e6if.bkt.clouddn.com/channel_1.jpg",
            "http://oxut2e6if.bkt.clouddn.com/channel_2.jpg",
            "http://oxut2e6if.bkt.clouddn.com/channel_3.jpg",
            "http://oxut2e6if.bkt.clouddn.com/channel_4.jpg",
            "http://oxut2e6if.bkt.clouddn.com/channel_5.jpg",
    };

    @Autowired
    private UserChannelRepository userChannelRepository;

    @Autowired
    private ComUserRepository comUserRepository;

    @Autowired
    private RecordChannelRepository recordChannelRepository;

    @Autowired
    private UserRecordRepository userRecordRepository;

    public JsonBean add(Integer userId, String title, String desc){
        ComUser user = comUserRepository.findOne(userId);
        if (user == null){
            return JsonBeanBuilder.builder()
                    .setCode(ResponseCode.ILLEGAL_ARGUMENT.getCode())
                    .setMsg("该用户不存在")
                    .build();
        }

        UserChannel channel = new UserChannel();
        channel.setChannel(title);
        channel.setDescText(desc);
        channel.setUserId(userId);
        channel.setImageUrl(imageUrl[new Random().nextInt(imageUrl.length)]);
        channel.setUpdateDate(new Date());
        System.out.println(channel.toString());
        userChannelRepository.save(channel);

        return JsonBeanBuilder.builder()
                .setCode(ResponseCode.SUCCESS.getCode())
                .setMsg("添加成功")
                .build();
    }


    public JsonBean modify(Integer channelId, String title, String desc){
        UserChannel channel = userChannelRepository.findOne(channelId);
        if (channel == null){
            return JsonBeanBuilder.builder()
                    .setCode(ResponseCode.ILLEGAL_ARGUMENT.getCode())
                    .setMsg("该栏目不存在")
                    .build();
        }
        channel.setChannel(title);
        channel.setDescText(desc);
        channel.setUpdateDate(new Date());
        userChannelRepository.save(channel);

        return JsonBeanBuilder.builder()
                .setCode(ResponseCode.SUCCESS.getCode())
                .setMsg(ResponseCode.SUCCESS.getDesc())
                .build();
    }


    public JsonBean getChannelsByUserId(Integer userId){
        ComUser user = comUserRepository.findOne(userId);
        if (user == null){
            return JsonBeanBuilder.builder()
                    .setCode(ResponseCode.ILLEGAL_ARGUMENT.getCode())
                    .setMsg("该用户不存在")
                    .build();
        }
        List<UserChannel> channelList = userChannelRepository.findAllByUserId(userId);
        return JsonBeanBuilder.builder()
                .setCode(ResponseCode.SUCCESS.getCode())
                .setMsg(ResponseCode.SUCCESS.getDesc())
                .setData(channelList)
                .build();
    }

    public JsonBean delete(Integer channelId){
        UserChannel channel = userChannelRepository.findOne(channelId);
        if (channel == null){
            return JsonBeanBuilder.builder()
                    .setCode(ResponseCode.ILLEGAL_ARGUMENT.getCode())
                    .setMsg("该栏目不存在")
                    .build();
        }
        userChannelRepository.delete(channelId);
        return JsonBeanBuilder.builder()
                .setCode(ResponseCode.SUCCESS.getCode())
                .setMsg("删除成功")
                .build();
    }

    public JsonBean getChannelDetail(Integer channelId){
        UserChannel channel = userChannelRepository.findOne(channelId);
        if (channel == null){
            return JsonBeanBuilder.builder()
                    .setCode(ResponseCode.ILLEGAL_ARGUMENT.getCode())
                    .setMsg("该栏目不存在")
                    .build();
        }
        List<RecordChannel> recordChannels = recordChannelRepository.findAllByChannelId(channelId);
        List<Integer> ids = new ArrayList<>();
        for (RecordChannel recordChannel : recordChannels){
            ids.add(recordChannel.getRecordId());
        }

        List<UserRecord> records = userRecordRepository.findByIdIn(ids);
        return JsonBeanBuilder.builder()
                .setCode(ResponseCode.SUCCESS.getCode())
                .setMsg(ResponseCode.SUCCESS.getDesc())
                .setTitle(channel.getChannel())
                .setImageUrl(channel.getImageUrl())
                .setDesc(channel.getDescText())
                .setTotal(recordChannels.size())
                .setData(records)
                .build();

    }
}
