package com.vinogradov.demo7.dto;

public class UserDto {

    private String name;
    private String lastName;
    private String login;

    public UserDto(String name, String lastName, String login) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getLastName() {
        return lastName;
    }
}