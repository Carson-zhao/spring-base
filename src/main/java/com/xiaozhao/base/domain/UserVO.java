package com.xiaozhao.base.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Carson-Zhao
 * @Description //TODO
 * @Date 2022/3/11 22:23
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    private String userName;

    private String password;

    private String address;

    private String phone;
}
