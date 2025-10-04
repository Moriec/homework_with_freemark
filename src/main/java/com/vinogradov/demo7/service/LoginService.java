package com.vinogradov.demo7.service;

import com.vinogradov.demo7.dto.UserDto;
import com.vinogradov.demo7.dto.UserLoginDto;

public interface LoginService {
    UserDto getUserByLoginAndPassword(UserLoginDto userLoginDto);
}
