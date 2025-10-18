package com.vinogradov.demo7.dto;

public class UserRegistrationDto {
    private String name;
    private String lastName;
    private String login;
    private String password;
    private String fileParth;

    public UserRegistrationDto(String name, String lastName, String login, String password, String fileParth) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.fileParth = fileParth;
    }

    public UserRegistrationDto(String name, String lastName, String login, String password) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFileParth() {
        return fileParth;
    }
}
