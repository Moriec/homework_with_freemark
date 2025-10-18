package com.vinogradov.demo7.service.impl;

import com.vinogradov.demo7.dao.UserDao;
import com.vinogradov.demo7.dto.UserRegistrationDto;
import com.vinogradov.demo7.entity.User;
import com.vinogradov.demo7.service.SignUpService;
import com.vinogradov.demo7.util.PasswordUtil;

public class SignUpServiceImpl implements SignUpService {

    UserDao userDao;

    public SignUpServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean signUp(UserRegistrationDto userRegistrationDto) {
        if(userDao.getByLogin(userRegistrationDto.getLogin()) == null) {
            userDao.save(
                    new User(
                            userRegistrationDto.getName(),
                            userRegistrationDto.getLastName(),
                            userRegistrationDto.getLogin(),
                            PasswordUtil.encrypt(userRegistrationDto.getPassword()),
                            userRegistrationDto.getFileParth()
                    )
            );
            return true;
        }
        return false;
    }
}
