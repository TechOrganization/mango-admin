package com.louis.mango.admin.service.impl;

import com.louis.mango.admin.entity.SysMenu;
import com.louis.mango.admin.entity.SysUser;
import com.louis.mango.admin.mapper.SysMenuMapper;
import com.louis.mango.admin.mapper.SysUserMapper;
import com.louis.mango.admin.service.SysUserService;
import com.mango.mango.common.utils.DateTimeUtils;
import com.mango.mango.common.utils.PoiUtils;
import com.mango.mango.core.page.MybatisPageHelper;
import com.mango.mango.core.page.PageRequest;
import com.mango.mango.core.page.PageResult;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private SysMenuMapper menuMapper;

    public static File createUserExcelFile(List<?> records) {
        if (records == null) {
            records = new ArrayList<>();
        }
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row row0 = sheet.createRow(0);
        int columnIndex = 0;
        row0.createCell(columnIndex).setCellValue("No");
        row0.createCell(++columnIndex).setCellValue("ID");
        row0.createCell(++columnIndex).setCellValue("用户名");
        row0.createCell(++columnIndex).setCellValue("昵称");
        row0.createCell(++columnIndex).setCellValue("机构");
        row0.createCell(++columnIndex).setCellValue("角色");
        row0.createCell(++columnIndex).setCellValue("邮箱");
        row0.createCell(++columnIndex).setCellValue("手机号");
        row0.createCell(++columnIndex).setCellValue("状态");
        row0.createCell(++columnIndex).setCellValue("头像");
        row0.createCell(++columnIndex).setCellValue("创建人");
        row0.createCell(++columnIndex).setCellValue("创建时间");
        row0.createCell(++columnIndex).setCellValue("最后更新人");
        row0.createCell(++columnIndex).setCellValue("最后更新时间");
        for (int i = 0; i < records.size(); i++) {
            SysUser user = (SysUser) records.get(i);
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < columnIndex + 1; j++) {
                row.createCell(j);
            }
            columnIndex = 0;
            row.getCell(columnIndex).setCellValue(i + 1);
            row.getCell(++columnIndex).setCellValue(user.getId());
            row.getCell(++columnIndex).setCellValue(user.getName());
            row.getCell(++columnIndex).setCellValue(user.getNickName());
            row.getCell(++columnIndex).setCellValue(user.getDeptName());
            row.getCell(++columnIndex).setCellValue(user.getRoleNames());
            row.getCell(++columnIndex).setCellValue(user.getEmail());
            row.getCell(++columnIndex).setCellValue(user.getStatus());
            row.getCell(++columnIndex).setCellValue(user.getAvatar());
            row.getCell(++columnIndex).setCellValue(user.getCreateBy());
            row.getCell(++columnIndex).setCellValue(DateTimeUtils.getDateTime(user.getCreateTime()));
            row.getCell(++columnIndex).setCellValue(user.getLastUpdateBy());
            row.getCell(++columnIndex).setCellValue(DateTimeUtils.getDateTime(user.getLastUpdateTime()));
        }
        return PoiUtils.createExcelFile(workbook, "download_user");
    }

    @Override
    public Set<String> findPermission(String username) {
        List<SysMenu> sysMenus = menuMapper.findByUserName(username);
        Set<String> permissions = sysMenus.stream().map(SysMenu::getPerms).collect(Collectors.toSet());
        return permissions;
    }

    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.findAll();
    }

    @Override
    public File createUserExcelFile(PageRequest pageRequest) {
        PageResult pageResult = findPage(pageRequest);
        return createUserExcelFile(pageResult.getContent());
    }

    /**
     * 名称获取用户
     *
     * @param username
     * @return
     */
    @Override
    public SysUser findByName(String username) {
        SysUser sysUser = sysUserMapper.selectByUserName(username);
        return sysUser;
    }

    @Override
    public boolean save(SysUser record) {
        sysUserMapper.insert(record);
        return true;
    }

    @Override
    public boolean update(SysUser record) {
        sysUserMapper.updateByPrimaryKeySelective(record);
        return true;
    }

    @Override
    public int delete(SysUser record) {
        sysUserMapper.delete(record);
        return 1;
    }

    @Override
    public boolean delete(List<SysUser> records) {
        for (SysUser record : records) {
            delete(record);
        }
        return true;
    }

    @Override
    public SysUser findById(Long id) {
        return null;
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        return MybatisPageHelper.findPage(pageRequest, sysUserMapper, "findPage");
    }
}
