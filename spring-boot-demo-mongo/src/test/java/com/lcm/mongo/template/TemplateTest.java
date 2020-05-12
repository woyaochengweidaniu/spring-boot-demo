package com.lcm.mongo.template;

import com.lcm.mongo.SpringbootMongoApplicationTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * @Author LiuChaomin
 * @Date 2020/5/12  15:49
 */
public class TemplateTest extends SpringbootMongoApplicationTest {
    @Autowired
    private MongoTemplate mongoTemplate;




}
