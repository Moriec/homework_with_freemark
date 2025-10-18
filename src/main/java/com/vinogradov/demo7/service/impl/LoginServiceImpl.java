package com.vinogradov.demo7.service.impl;

import com.vinogradov.demo7.dao.UserDao;
import com.vinogradov.demo7.dao.impl.UserDaoImpl;
import com.vinogradov.demo7.dto.UserDto;
import com.vinogradov.demo7.dto.UserLoginDto;
import com.vinogradov.demo7.entity.User;
import com.vinogradov.demo7.service.LoginService;
import com.vinogradov.demo7.util.PasswordUtil;

public class LoginServiceImpl implements LoginService {

    UserDao userDao;

    public LoginServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDto getUserByLoginAndPassword(UserLoginDto userLoginDto) {
        String hashedPassword = PasswordUtil.encrypt(userLoginDto.getPassword());
        User user = userDao.getByLogin(userLoginDto.getLogin());
        if (user != null && user.getPassword().equals(hashedPassword)) {
            String ls = user.getLastName();
            return new UserDto(
                    user.getName(),
                    user.getLastName(),
                    user.getLogin(),
                    user.getPhoto()
            );
        }
        return null;
    }
}
