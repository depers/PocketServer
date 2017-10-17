package cn.bravedawn.controller.app;

import cn.bravedawn.common.JsonBean;
import cn.bravedawn.service.ComUserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 冯晓 on 2017/10/9.
 */
@RestController
@Slf4j
public class ComUserController {

    @Autowired
    private ComUserService comUserService;

    @PostMapping("sign_in")
    @ApiOperation("用户登录")
    public JsonBean signIn(@ApiParam("手机号") @RequestParam String phone, @ApiParam("密码") @RequestParam String password){
        return comUserService.signIn(phone, password);
    }

    @PostMapping("sign_up")
    @ApiOperation("用户注册")
    public JsonBean signUp(@ApiParam("手机号") @RequestParam String phone, @ApiParam("密码") @RequestParam String password){
        return comUserService.insert(phone, password);
    }
}
