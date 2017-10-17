package cn.bravedawn.service;

import cn.bravedawn.common.JsonBean;

/**
 * Created by 冯晓 on 2017/10/9.
 */
public interface UserChannelService {

    JsonBean add(Integer userId, String title, String desc);

    JsonBean modify(Integer channelId, String title, String desc);

    JsonBean getChannelsByUserId(Integer userId);

    JsonBean delete(Integer channelId);

    JsonBean getChannelDetail(Integer channelId);
}
