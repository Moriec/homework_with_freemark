package com.vinogradov.demo7.dao;

import com.vinogradov.demo7.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> getAll();

    void save(User user);

    User getById(Integer id);

    User getByLogin(String name);
}
