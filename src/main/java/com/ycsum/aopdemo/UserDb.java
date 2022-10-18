package com.ycsum.aopdemo;

import java.util.ArrayList;
import java.util.List;

public class UserDb {
    private final List<User> userList;

    public UserDb(List<User> userList) {
        this.userList = new ArrayList<>(userList);
    }


    public List<User> getAllUser() {
        return new ArrayList<>(userList);
    }
}
