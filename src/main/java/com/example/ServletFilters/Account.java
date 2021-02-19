package com.example.ServletFilters;

public class Account {
    private String username;
    private String password;


    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
