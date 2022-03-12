package com.xiaozhao.base.service;

import com.xiaozhao.base.domain.UserVO;

/**
 * @Author Carson-Zhao
 * @Description //TODO
 * @Date 2022/3/11 22:27
 * @Version 1.0
 */
public interface UserService {
    UserVO creatUser();

    UserVO setUserInfo(String phone);
}
