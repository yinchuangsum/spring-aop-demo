package com.ycsum.aopdemo;

import com.ycsum.aopdemo.annotation.EnableLogging;
import com.ycsum.aopdemo.annotation.EnableTiming;
import com.ycsum.aopdemo.annotation.RateLimited;
import com.ycsum.aopdemo.annotation.SensitiveConceal;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserDb userDb;

    public UserServiceImpl(UserDb userDb) {
        this.userDb = userDb;
    }

    @RateLimited(rate = 5, name = "getAllUser")
    @EnableLogging
    @EnableTiming
    @SensitiveConceal
    @Override
    public List<User> getAllUser() {
        return userDb.getAllUser();
    }

    @Override
    public List<User> getAllUserNonAop() {
        return getAllUser();
    }
}
