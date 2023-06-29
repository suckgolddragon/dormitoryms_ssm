package com.southwind.entity;

import lombok.Data;

@Data   //注解在类上；提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法
public class SystemAdmin {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String telephone;
}
