package com.xiaozhao.base.service.impl;

import com.xiaozhao.base.aop.annotation.MultiDataSource;
import com.xiaozhao.base.config.MultiDataSourceHolder;
import com.xiaozhao.base.domain.UserVO;
import com.xiaozhao.base.mapper.InfoMapper;
import com.xiaozhao.base.mapper.UserMapper;
import com.xiaozhao.base.service.UserService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

/**
 * @Author Carson-Zhao
 * @Description //TODO
 * @Date 2022/3/11 22:28
 * @Version 1.0
 */
@Service
@EnableAspectJAutoProxy(exposeProxy = true)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private InfoMapper infoMapper;


    @Override
    public UserVO creatUser() {
        UserVO userVO = userMapper.getUserInfoMapper();

        return ((UserService) AopContext.currentProxy()).setUserInfo(userVO.getPhone());
    }

    @MultiDataSource(DBName = "dataSource1")
    public UserVO setUserInfo(String phone) {
        System.out.println("======="+MultiDataSourceHolder.getDatasource());
        UserVO userInfo = infoMapper.getUserInfo();

        UserVO user = new UserVO();
        user.setUserName(userInfo.getUserName());
        user.setPassword(userInfo.getPassword());
        user.setAddress(userInfo.getAddress());
        user.setPhone(phone);
        return user;
    }
}
