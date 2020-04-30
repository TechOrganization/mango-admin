package com.louis.mango.admin.controller;

import com.louis.mango.admin.service.SysUserService;
import com.mango.mango.common.utils.FileUtils;
import com.mango.mango.core.http.HttpResult;
import com.mango.mango.core.page.PageRequest;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@RestController
@RequestMapping("user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private RestTemplate restTemplate;



    @GetMapping(value = "/findAll")
    public Object findAll() {
        return sysUserService.findAll();
    }

    @PostMapping("/findPage")
    public HttpResult findPage(@RequestBody PageRequest pageRequest) {
        return HttpResult.ok(sysUserService.findPage(pageRequest));
    }

    @PostMapping("/createExcelUser")
    public HttpResult createExcelUser(@RequestBody PageRequest pageRequest, HttpServletResponse res) {
        File file = sysUserService.createUserExcelFile(pageRequest);
        FileUtils.downloadFile(res, file, file.getName());
        return HttpResult.ok(sysUserService.findPage(pageRequest));
    }

    @GetMapping("info")
    public String info() {
        InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("MANGO-AMDIN", false);
        String userUrl = instanceInfo.getHomePageUrl();
        return instanceInfo.getHomePageUrl();
    }

}
