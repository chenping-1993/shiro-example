package com.example.shiro.shiroexample.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shiro.shiroexample.entity.Role;
import com.example.shiro.shiroexample.service.provider.SelectDataProvider;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Set;

/**
 * @Author: chenping
 * @Date: 2019/6/12
 */
//@Repository
public interface RoleMapper extends BaseMapper<Role> {

    @SelectProvider(type = SelectDataProvider.class, method = "selectRoleNamesSql")
    List<String> selectRoleNames(String userName);

    @SelectProvider(type = SelectDataProvider.class, method = "selectPermissionsSql")
    Set<String> selectPermissions(String userName);

}
