package com.xiaozhao.base.mapper;

import com.xiaozhao.base.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

/**
 * @Author Carson-Zhao
 * @Description //TODO
 * @Date 2022/3/11 22:36
 * @Version 1.0
 */
@Mapper
public interface InfoMapper {

    @Select("select id,user_name as userName,password,phone,address from test_user")
    UserVO getUserInfo();
}
