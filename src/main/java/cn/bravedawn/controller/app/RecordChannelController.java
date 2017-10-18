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


    @GetMapping()
    @ApiOperation("/{id:\\d+}")
    public JsonBean get(@PathVariable(name = "id", required = true)Integer recordId){
        return recordChannelService.getChannel(recordId);
    }

    @PutMapping("/{id:\\d+}")
    @ApiOperation("修改用户记录栏目")
    public JsonBean modify(@PathVariable(name = "id", required = true)Integer recordId,
                           @RequestParam Integer channelId){
        return recordChannelService.modify(recordId, channelId);
    }


}
