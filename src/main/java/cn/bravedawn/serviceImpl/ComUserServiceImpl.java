package cn.bravedawn.serviceImpl;

import cn.bravedawn.bean.ComUser;
import cn.bravedawn.common.JsonBean;
import cn.bravedawn.common.JsonBeanBuilder;
import cn.bravedawn.common.ResponseCode;
import cn.bravedawn.repository.ComUserRepository;
import cn.bravedawn.service.ComUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by 冯晓 on 2017/10/9.
 */
@Service
public class ComUserServiceImpl implements ComUserService {

    private static final String defaultAvatar = "http://oxut2e6if.bkt.clouddn.com/person.png";

    @Autowired
    private ComUserRepository comUserRepository;


    public JsonBean insert(String phone, String password){
        ComUser signUpedUser = comUserRepository.findComUserByPhone(phone);
        if (signUpedUser != null){
            return JsonBeanBuilder.builder()
                    .setCode(ResponseCode.ERROR.getCode())
                    .setMsg("该用户已注册")
                    .build();
        }

        ComUser user = new ComUser();
        user.setPhone(phone);
        user.setPwd(password);
        user.setName("口袋用户");
        user.setAvatar(defaultAvatar);
        user.setUpdateDate(new Date());
        comUserRepository.save(user);
        return JsonBeanBuilder.builder()
                .setCode(ResponseCode.SUCCESS.getCode())
                .setMsg(ResponseCode.SUCCESS.getDesc())
                .setData(user)
                .build();
    }

    public JsonBean signIn(String phone, String password){
        ComUser user = comUserRepository.findComUserByPhone(phone);
        if (user == null){
            return JsonBeanBuilder.builder()
                    .setCode(ResponseCode.ERROR.getCode())
                    .setMsg("该用户尚未注册")
                    .build();
        }

        if (!user.getPwd().equals(password)){
            return JsonBeanBuilder.builder()
                    .setCode(ResponseCode.ILLEGAL_ARGUMENT.getCode())
                    .setMsg("用户名或密码错误")
                    .build();
        }

        return JsonBeanBuilder.builder()
                .setCode(ResponseCode.SUCCESS.getCode())
                .setMsg(ResponseCode.SUCCESS.getDesc())
                .setData(user)
                .build();
    }
}
