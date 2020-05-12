package com.lcm.mongo.service;

import com.lcm.mongo.module.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author LiuChaomin
 * @Date 2020/5/12  14:49
 */
@Slf4j
@Service
public class UserService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public User addUser(User user) {
        User insert = mongoTemplate.insert(user);
        log.info("user:{}",insert);
        return insert;
    }

}
