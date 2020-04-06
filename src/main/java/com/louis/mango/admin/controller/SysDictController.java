package com.louis.mango.admin.controller;

import com.louis.mango.admin.entity.SysDict;
import com.louis.mango.admin.service.SysDictService;
import com.mango.mango.core.http.HttpResult;
import com.mango.mango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName SysDictController
 * @Description TODO
 * @Autgor admin
 * @Date 2020-02-23 13:46
 */
@RestController
@RequestMapping(value = "dict")
public class SysDictController {

    @Autowired
    private SysDictService sysDictService;

    @PreAuthorize("hasAuthority('sys:dict:add')")
    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysDict record) {
        return HttpResult.ok(sysDictService.save(record));
    }

    @PreAuthorize("hasAuthority('sts:dict:delete')")
    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody SysDict record) {
        return HttpResult.ok(sysDictService.delete(record));
    }

    @PreAuthorize("hasAuthority('sys:dict:view')")
    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysDictService.findPage(pageRequest));
    }

    @PreAuthorize("hasAuthority('sys:dict:view')")
    @PostMapping(value = "/findByLabel")
    public HttpResult findByLabel(@RequestParam String label) {
        return HttpResult.ok(sysDictService.findByLabel(label));
    }


}
