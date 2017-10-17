package cn.bravedawn.service;

import cn.bravedawn.common.JsonBean;

/**
 * Created by 冯晓 on 2017/10/9.
 */
public interface ComUserService {

    JsonBean insert(String phone, String password);

    JsonBean signIn(String phone, String password);
}
