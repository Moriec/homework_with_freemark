package com.vinogradov.demo7.listener;

import com.vinogradov.demo7.dao.UserDao;
import com.vinogradov.demo7.dao.impl.UserDaoImpl;
import com.vinogradov.demo7.service.CheckLoginService;
import com.vinogradov.demo7.service.LoginService;
import com.vinogradov.demo7.service.SignUpService;
import com.vinogradov.demo7.service.UserService;
import com.vinogradov.demo7.service.impl.CheckLoginServiceImpl;
import com.vinogradov.demo7.service.impl.LoginServiceImpl;
import com.vinogradov.demo7.service.impl.SignUpServiceImpl;
import com.vinogradov.demo7.service.impl.UserServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class AppContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        UserService userService = new UserServiceImpl();
        sce.getServletContext().setAttribute("userService", userService);

        UserDao  userDao = new UserDaoImpl();
        SignUpService signUpService = new SignUpServiceImpl(userDao);
        LoginService loginService = new LoginServiceImpl(userDao);
        CheckLoginService checkLoginService = new CheckLoginServiceImpl(userDao);

        sce.getServletContext().setAttribute("signUpService", signUpService);
        sce.getServletContext().setAttribute("loginService", loginService);
        sce.getServletContext().setAttribute("checkLoginService", checkLoginService);
    }
}