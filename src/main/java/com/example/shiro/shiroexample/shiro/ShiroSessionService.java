package com.example.shiro.shiroexample.shiro;

import com.example.shiro.shiroexample.enums.SessionConst;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

/**
 * @Author: chenping
 * @Date: 2019/8/21
 */
@Service
public class ShiroSessionService {

    public Session getSession() {
        // 当前用户
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser.getSession();
    }

    public Integer getUserId() {
        Session session = getSession();
        Integer userId = (Integer) session.getAttribute(SessionConst.SESSION_USER_ID);
        return userId;
    }

    public Integer getRoleId() {
        Session session = getSession();
        Integer roleId = (Integer) session.getAttribute(SessionConst.SESSION_ROLE_ID);
        return roleId;
    }

    public String getUserName() {
        Session session = getSession();
        String userName = (String) session.getAttribute(SessionConst.SESSION_USER_NAME);
        return userName;
    }

}
