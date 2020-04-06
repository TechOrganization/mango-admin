package com.louis.mango.admin.mapper;

import com.louis.mango.admin.entity.SysMenu;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface SysMenuMapper extends BaseMapper<SysMenu> {

    SysMenu selectByPrimaryKey(Long id);


    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> findByUserName(String username);
}
