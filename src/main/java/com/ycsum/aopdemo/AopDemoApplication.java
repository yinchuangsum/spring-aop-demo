package com.ycsum.aopdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AopDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(AopDemoApplication.class, args);
        UserService userService = context.getBean(UserService.class);

        SecurityContext.setCurrentUser(sum());

        userService.getAllUser();
        userService.getAllUserNonAop();
        userService.getAllUserNonAop();
        userService.getAllUserNonAop();
        userService.getAllUserNonAop();
        userService.getAllUserNonAop();
        userService.getAllUserNonAop();
    }

    public static User sum() {
        User sum = new User();
        sum.setName("sum");
        return sum;
    }

}
