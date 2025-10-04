package com.vinogradov.demo7.service.impl;

import com.vinogradov.demo7.dao.UserDao;
import com.vinogradov.demo7.dao.impl.UserDaoImpl;
import com.vinogradov.demo7.dto.UserDto;
import com.vinogradov.demo7.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDao userDao = new UserDaoImpl();

    @Override
    public List<UserDto> getAll() {
        return userDao.getAll().stream().map(
                u -> new UserDto(u.getName(), u.getLastName(), u.getLogin())
        ).toList();
    }
}