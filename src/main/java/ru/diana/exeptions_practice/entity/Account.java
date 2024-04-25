package ru.diana.exeptions_practice.entity;

import ru.diana.exeptions_practice.service.WrongLoginException;

import java.util.HashMap;

public class Account {
    public String login;
    public String password;
    public HashMap<String, String> loginPasswordMap;

    public void checkLogin (String login) throws WrongLoginException {
        if (login != null && login.length() > 5 && login.length() < 20) {
            this.login = login;
        }
        else {
            throw new WrongLoginException();
        }
    }

    public void checkPassword (String password, String confirmation) throws WrongLoginException {
        if (password != null && password.length() > 8 && password.length() < 20 && password.equals(confirmation)) {
            this.password = password;
        }
        else {
            throw new WrongLoginException();
        }
    }

    public void setLoginPasswordMap(HashMap<String, String> loginPasswordMap) {
        this.loginPasswordMap = loginPasswordMap;
    }

    public void checkLoginAndPassword (String login, String password) throws WrongLoginException {
        String storedPassword = loginPasswordMap.get(login);
        if (storedPassword == null || !storedPassword.equals(password)) {
            throw new WrongLoginException();
        }
    }
}
