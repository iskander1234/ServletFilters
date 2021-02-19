package com.example.ServletFilters;

public class AccountModel {
    public boolean login(String username, String password){

        return username.equalsIgnoreCase("iska") && password.equalsIgnoreCase("123");
    }
}
