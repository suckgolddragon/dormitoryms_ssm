package com.southwind.entity;

import lombok.Data;

@Data
public class Building {
    private Integer id;
    private String name;
    private String introduction;
    private Integer adminId;
    private String adminName;
}
