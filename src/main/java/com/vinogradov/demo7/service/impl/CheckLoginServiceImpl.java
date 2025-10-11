package com.vinogradov.demo7.service.impl;

import com.vinogradov.demo7.dao.UserDao;
import com.vinogradov.demo7.service.CheckLoginService;

public class CheckLoginServiceImpl implements CheckLoginService {

    UserDao userDao;

    public CheckLoginServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean checkLogin(String login) {
        return userDao.getByLogin(login) != null;
    }
}
