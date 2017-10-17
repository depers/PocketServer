package cn.bravedawn.controller.app;

import cn.bravedawn.common.JsonBean;
import cn.bravedawn.service.UserChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 冯晓 on 2017/10/9.
 */
@RestController
@RequestMapping("/channel/")
public class UserChannelController {

    @Autowired
    private UserChannelService userChannelService;

    @PostMapping("/{id:\\d+}")
    public JsonBean add(@PathVariable(name = "id", required = true) Integer id,
                        @RequestParam String title, @RequestParam String desc){
        return userChannelService.add(id, title, desc);
    }

    @PutMapping("/{id:\\d+}")
    public JsonBean modify(@PathVariable(name = "id", required = true) Integer id,
                           @RequestParam String title, @RequestParam String desc){
        return userChannelService.modify(id, title, desc);
    }

    @GetMapping("/{id:\\d+}")
    public JsonBean getChannelByUserId(@PathVariable(name = "id", required = true) Integer id){
        return userChannelService.getChannelsByUserId(id);
    }

    @DeleteMapping("/{id:\\d+}")
    public JsonBean delete(@PathVariable(name = "id", required = true) Integer id){
        return userChannelService.delete(id);
    }

    @GetMapping("detail/{id:\\d+}")
    public JsonBean detail(@PathVariable(name = "id", required = true) Integer id){
        return userChannelService.getChannelDetail(id);
    }
}
