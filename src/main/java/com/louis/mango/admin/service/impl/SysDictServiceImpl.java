package com.louis.mango.admin.service.impl;

import com.louis.mango.admin.entity.SysDict;
import com.louis.mango.admin.mapper.SysDictMapper;
import com.louis.mango.admin.service.SysDictService;
import com.mango.mango.core.page.MybatisPageHelper;
import com.mango.mango.core.page.PageRequest;
import com.mango.mango.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SysDictServiceImpl
 * @Description TODO
 * @Autgor huang
 * @Date 2020-02-23 13:18
 */
@Service
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;

    @Override
    public List<SysDict> findByLabel(String label) {
        return sysDictMapper.findByLabel(label);
    }

    /**
     * 新增或修改
     *
     * @param record
     * @return
     */
    @Override
    public boolean save(SysDict record) {
        if (record.getId() == 0 || record.getId() == null) {
            sysDictMapper.insertSelective(record);
        }
        sysDictMapper.updateByPrimaryKeySelective(record);
        return true;
    }

    @Override
    public boolean update(SysDict record) {
        return false;
    }

    /**
     * 删除
     *
     * @param record
     * @return
     */
    @Override
    public int delete(SysDict record) {
        return sysDictMapper.deleteByPrimaryKey(record);
    }

    @Override
    public boolean delete(List<SysDict> records) {
        for (SysDict record : records) {
            delete(record);
        }
        return true;
    }

    @Override
    public SysDict findById(Long id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParams().get("label");
        if (label != null) {
            return MybatisPageHelper.findPage(pageRequest, sysDictMapper, "findPageByLabel", label);
        }
        return MybatisPageHelper.findPage(pageRequest, sysDictMapper);
    }
}
