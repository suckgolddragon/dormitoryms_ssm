package com.southwind.dto;

import lombok.Data;

@Data
public class AccountDto<T> {
    /**
     * -1 用户名错误
     * -2 密码错误
     * 0 登录成功
     */
    private Integer code;
    private T admin;
}
