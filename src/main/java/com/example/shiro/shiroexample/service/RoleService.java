package com.example.shiro.shiroexample.service;

import com.example.shiro.shiroexample.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @Description: 角色service
 * @Author: chenping
 * @Date: 2020-12-17
 */
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;


    /** 
     * @Description:  查询用户的角色编码
     * @param: userName 
     * @return: java.util.List<java.lang.String> 
     * @Author: chenping
     * @Date: 2020/12/17 16:32
     */
    public List<String> selectRoleNames(String userName) {
        List<String> list = roleMapper.selectRoleNames(userName);
        return list;
    }

    /** 
     * @Description:  查询用户的所有的权限
     * @param: userName 
     * @return: java.util.Set<java.lang.String> 
     * @Author: chenping
     * @Date: 2020/12/17 16:34
     */
    public Set<String> selectPermissions(String userName) {
        Set<String> sets = roleMapper.selectPermissions(userName);
        return sets;
    }
}
