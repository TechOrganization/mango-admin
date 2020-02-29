package com.louis.mango.admin.mapper;

import com.louis.mango.admin.entity.SysDict;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface SysDictMapper extends BaseMapper<SysDict> {

    /**
     * 分页查询
     *
     * @return
     */
    List<SysDict> findPage();

    /**
     * 标签名称查询
     *
     * @param label
     * @return
     */
    List<SysDict> findByLabel(@Param(value = "label") String label);

    /**
     * 标签名称分页查询
     *
     * @param label
     * @return
     */
    List<SysDict> findPageByLabel(@Param(value = "label") String label);

}
