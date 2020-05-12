package com.lcm.mongo.service;

import com.lcm.mongo.SpringbootMongoApplicationTest;
import com.lcm.mongo.module.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author LiuChaomin
 * @Date 2020/5/12  14:57
 */
public class UserServiceTest extends SpringbootMongoApplicationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = User.builder().userName("小丑").build();
        userService.addUser(user);
    }
}
