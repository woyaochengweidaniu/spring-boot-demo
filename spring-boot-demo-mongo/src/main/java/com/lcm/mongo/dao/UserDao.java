package com.lcm.mongo.dao;

import com.lcm.mongo.module.User;
import org.springframework.data.mongodb.repository.MongoRepository;


/**
 * @Author LiuChaomin
 * @Date 2020/5/12  15:14
 */
public interface UserDao extends MongoRepository<User,String> {

    User findByUserName(String userName);

    long deleteByUserName(String userName);
}
