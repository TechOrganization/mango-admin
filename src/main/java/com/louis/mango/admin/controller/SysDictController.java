package com.louis.mango.admin.controller;

import com.louis.mango.admin.entity.SysDict;
import com.louis.mango.admin.service.SysDictService;
import com.mango.mango.core.http.HttpResult;
import com.mango.mango.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = "/save")
    public HttpResult save(@RequestBody SysDict record) {
        return HttpResult.ok(sysDictService.save(record));
    }

    @PostMapping(value = "/delete")
    public HttpResult delete(@RequestBody SysDict record) {
        return HttpResult.ok(sysDictService.delete(record));
    }

    @PostMapping(value = "/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysDictService.findPage(pageRequest));
    }

    @PostMapping(value = "/findByLabel")
    public HttpResult findByLabel(@RequestParam String label) {
        return HttpResult.ok(sysDictService.findByLabel(label));
    }


}
