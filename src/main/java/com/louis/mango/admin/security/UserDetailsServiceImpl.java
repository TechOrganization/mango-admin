package com.louis.mango.admin.security;

import com.louis.mango.admin.entity.SysUser;
import com.louis.mango.admin.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 实现 UserDetailsService 接口，覆写其中的 loadUserByUsername 方法，查询用户的密码信息和权限信息并封装
 * UserDetails的实体类对象，做为 JwtUserDetails 返回给 DaoAuthenticationProvider
 *
 * @ClassName UserDetailsServiceImpl
 * @Description TODO
 * @Autgor huang
 * @Date 2020-04-05 12:36
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = sysUserService.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("该用户不存在");
        }
        // 用户权限列表，根据权限标识，如 @PreAuthorize("hasAuthority('sys:menu:view')")
        // 标注的接口对比，决定是否可以调用接口
        Set<String> permissions = sysUserService.findPermission(username);
        List<GrantedAuthority> grantedAuthorities = permissions.stream()
                .map(GrantedAuthorityImpl::new).collect(Collectors.toList());

        return new JwtUserDetails(user.getName(), user.getPassword(), user.getSalt(), grantedAuthorities);
    }
}
