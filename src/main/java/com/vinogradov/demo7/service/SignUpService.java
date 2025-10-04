package com.vinogradov.demo7.service;

import com.vinogradov.demo7.dto.UserDto;
import com.vinogradov.demo7.dto.UserRegistrationDto;
import com.vinogradov.demo7.entity.User;

public interface SignUpService {
     boolean signUp(UserRegistrationDto userRegistrationDto);
}
