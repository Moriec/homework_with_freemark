package com.vinogradov.demo7.service;

import com.vinogradov.demo7.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAll();
}