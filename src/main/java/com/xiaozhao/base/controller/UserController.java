package com.xiaozhao.base.controller;

import com.xiaozhao.base.domain.UserVO;
import com.xiaozhao.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Carson-Zhao
 * @Description //TODO
 * @Date 2022/3/11 22:25
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;



    @GetMapping("/info")
    public UserVO getUser(){
        return userService.creatUser();
    }
}
