package com.louis.mango.admin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class SysDict {
    private Long id;

    private String value;

    private String label;

    private String type;

    private String description;

    private Long sort;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private String remarks;

    private Byte delFlag;

}
