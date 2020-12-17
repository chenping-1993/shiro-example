package com.example.shiro.shiroexample.service.provider;

/**
 * @Description:
 * @Author: chenping
 * @Date: 2020-12-17
 */
public class SelectDataProvider {

    public String selectRoleNamesSql(String userName) {

        String sql = "SELECT r.code FROM role_shiro r LEFT JOIN user_role_shiro ur ON r.id = ur.role_id " +
                "LEFT JOIN user_shiro u ON u.id = ur.user_id where 1=1";
        sql += " and u.name = #{userName}";
        return sql.toString();
    }

    public String selectPermissionsSql(String userName) {

        String sql = "SELECT DISTINCT s.permission FROM permission_shiro s left join role_permission_shiro rp on s.id = rp.permission_id" +
                " left join role_shiro r on r.id = rp.role_id" +
                " LEFT JOIN user_role_shiro ur ON r.id = ur.role_id " +
                "LEFT JOIN user_shiro u ON u.id = ur.user_id where 1=1";
        sql += " and u.name = #{userName}";
        return sql.toString();
    }
}
