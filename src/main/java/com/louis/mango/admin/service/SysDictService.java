package com.louis.mango.admin.service;

import com.louis.mango.admin.entity.SysDict;
import com.mango.mango.core.service.CurdService;

import java.util.List;

public interface SysDictService extends CurdService<SysDict> {

    List<SysDict> findByLabel(String label);
}
