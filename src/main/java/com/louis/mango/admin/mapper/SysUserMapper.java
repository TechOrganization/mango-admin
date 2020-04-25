package com.louis.mango.admin.mapper;

import com.louis.mango.admin.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 查询全部
     *
     * @return
     */
    List<SysUser> findAll();

    List<SysUser> findPage();

    SysUser selectByUserName(@Param(value = "username") String username);
}
