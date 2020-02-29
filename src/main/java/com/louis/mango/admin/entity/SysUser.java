package com.louis.mango.admin.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SysUser {

    private Long id;

    private String name;

    private String nickName;

    private String avatar;

    private String password;

    private String salt;

    private String email;

    private String mobile;

    private Byte status;

    private Long deptId;

    private String createBy;

    private Date createTime;

    private String lastUpdateBy;

    private Date lastUpdateTime;

    private Byte delFlag;

    /**
     * 部门
     */
    private String deptName;

    /**
     * 角色名称
     */
    private String roleNames;

    /**
     * 用户角色
     */
    private List<SysUserRole> userRoles = new ArrayList<>();

}
