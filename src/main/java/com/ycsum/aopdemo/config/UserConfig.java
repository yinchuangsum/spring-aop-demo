package com.ycsum.aopdemo.config;

import com.ycsum.aopdemo.User;
import com.ycsum.aopdemo.UserDb;
import com.ycsum.aopdemo.UserService;
import com.ycsum.aopdemo.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    public UserDb userDb() {
        List<User> userList = Arrays.asList(
                new User("sum", "123"),
                new User("tuck weng", "hahah"),
                new User("william", "willy"),
                new User("kok wai", "dabian"));
        return new UserDb(userList);
    }

    @Bean
    public UserService userService(UserDb db) {
        return new UserServiceImpl(db);
    }


}
