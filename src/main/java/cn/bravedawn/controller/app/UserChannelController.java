package cn.bravedawn.controller.app;

import cn.bravedawn.common.JsonBean;
import cn.bravedawn.service.UserChannelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 冯晓 on 2017/10/9.
 */
@RestController
@RequestMapping("/channel")
public class UserChannelController {

    @Autowired
    private UserChannelService userChannelService;

    @PostMapping()
    @ApiOperation("新增分类")
    public JsonBean add(@RequestParam Integer userId,
                        @RequestParam String title, @RequestParam String desc){
        return userChannelService.add(userId, title, desc);
    }

    @PutMapping("/{id:\\d+}")
    @ApiOperation("修改分类")
    public JsonBean modify(@PathVariable(name = "id", required = true) Integer id,
                           @RequestParam String title, @RequestParam String desc){
        return userChannelService.modify(id, title, desc);
    }

    @GetMapping("/{id:\\d+}")
    @ApiOperation("获取该用户的分类")
    public JsonBean getChannelByUserId(@PathVariable(name = "id", required = true) Integer id){
        return userChannelService.getChannelsByUserId(id);
    }

    @GetMapping("/info/{id:\\d+}")
    @ApiOperation("获取该专栏的信息")
    public JsonBean getChannelByChannelId(@PathVariable(name = "id", required = true) Integer channelId){
        return userChannelService.getChannelsByChannelId(channelId);
    }


    @DeleteMapping("/{id:\\d+}")
    @ApiOperation("删除分类")
    public JsonBean delete(@PathVariable(name = "id", required = true) Integer id){
        return userChannelService.delete(id);
    }

    @GetMapping("detail/{id:\\d+}")
    @ApiOperation("分类详情")
    public JsonBean detail(@PathVariable(name = "id", required = true) Integer id){
        return userChannelService.getChannelDetail(id);
    }
}
