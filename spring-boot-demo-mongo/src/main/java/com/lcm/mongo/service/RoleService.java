package com.lcm.mongo.service;

import com.lcm.mongo.module.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author LiuChaomin
 * @Date 2020/5/12  14:52
 */
@Slf4j
@Service
public class RoleService {


    @Autowired
    private MongoTemplate mongoTemplate;


    public Role addRole(Role role){
        Role rol = mongoTemplate.insert(role);
        log.info("role:{}",rol);
        return rol;
    }
}
