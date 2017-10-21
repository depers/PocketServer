package cn.bravedawn.service;

import cn.bravedawn.common.JsonBean;

/**
 * Created by 冯晓 on 2017/10/9.
 */
public interface RecordChannelService {

    JsonBean modify(Integer recordId, Integer channelId);

    JsonBean getCount(Integer channelId);
}
