package com.ycsum.aopdemo;

import java.util.List;

public interface UserService {

    List<User> getAllUser();

    List<User> getAllUserNonAop();


}
