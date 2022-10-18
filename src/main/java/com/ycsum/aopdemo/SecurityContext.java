package com.ycsum.aopdemo;

public class SecurityContext {
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        SecurityContext.currentUser = currentUser;
    }
}
