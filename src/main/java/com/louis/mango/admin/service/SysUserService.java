package com.louis.mango.admin.service;

import com.louis.mango.admin.entity.SysUser;
import com.mango.mango.core.page.PageRequest;
import com.mango.mango.core.service.CurdService;

import java.io.File;
import java.util.List;

public interface SysUserService extends CurdService<SysUser> {

    /**
     * 查找所有用户
     *
     * @return
     */
    List<SysUser> findAll();

    /**
     * 生产用户信息excel文件
     *
     * @param pageRequest 要导出的分页查询参数
     * @return
     */
    File createUserExcelFile(PageRequest pageRequest);

}
