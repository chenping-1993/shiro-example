package com.example.shiro.shiroexample.shiro;

import com.example.shiro.shiroexample.entity.Role;
import com.example.shiro.shiroexample.entity.User;
import com.example.shiro.shiroexample.mapper.RoleMapper;
import com.example.shiro.shiroexample.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: chenping
 * @Date: 2019/8/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class EntityTest {
    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Test
    public void insertUsers() {
        User user = new User();
        user.setName("tom");
        user.setPassword("123456");
        int result = userMapper.insert(user);
        System.out.println(result);

    }

    @Test
    public void insertRoles() {
        Role role = new Role();
        role.setName("统计分析员");
        role.setCode("tjfx");
        int result = roleMapper.insert(role);
        System.out.println(result);

    }
}
