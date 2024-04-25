package ru.diana.exeptions_practice.main;

import ru.diana.exeptions_practice.entity.Account;
import ru.diana.exeptions_practice.service.WrongLoginException;

import java.util.HashMap;

public class Main {
    public static void main(String[] arg) {
        Account account = new Account();
        HashMap<String, String> loginPasswordMap = new HashMap<>();
        loginPasswordMap.put("Di", "ITGirls");
        loginPasswordMap.put("example", "password");
        account.setLoginPasswordMap(loginPasswordMap);
        try {
            account.checkLogin("Di");
            account.checkPassword("ITGirls", "ITgirls");
            account.checkLoginAndPassword("Di", "ITgirls");
            System.out.println("Password are correct.");
        }catch (WrongLoginException e) {
            System.out.println("Исключение: " + e);
        }
    }
}
