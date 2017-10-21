package cn.bravedawn.controller.app;

import cn.bravedawn.common.JsonBean;
import cn.bravedawn.repository.RecordChannelRepository;
import cn.bravedawn.service.RecordChannelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 冯晓 on 2017/10/9.
 */
@RestController
@RequestMapping("record_channel")
public class RecordChannelController {

    @Autowired
    private RecordChannelService recordChannelService;

    @PutMapping("/{id:\\d+}")
    @ApiOperation("修改用户记录栏目")
    public JsonBean modify(@PathVariable(name = "id", required = true)Integer recordId,
                           @RequestParam Integer channelId){
        return recordChannelService.modify(recordId, channelId);
    }

    @GetMapping("/count/{id:\\d+}")
    @ApiOperation("获取专栏文章数目")
    public JsonBean getCount(@PathVariable(name = "id", required = true)Integer channelId){
        return recordChannelService.getCount(channelId);
    }


}
