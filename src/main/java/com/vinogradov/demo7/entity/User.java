package com.vinogradov.demo7.entity;

public class User {

    private Integer id;
    private String name;
    private String lastName;
    private String login;
    private String password;
    private String photoPath;

    public User(String name, String lastName, String login, String password, String photoPath) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.photoPath = photoPath;
    }

    public User(Integer id, String name, String lastName, String login, String password, String photoPath) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.photoPath = photoPath;
    }

    public User(Integer id, String name, String lastName, String login, String password) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public User(String name, String lastName, String login, String password) {
        this.name = name;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public Integer getId() {
        return id;
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

    public String getPhoto() {return photoPath;}
}
