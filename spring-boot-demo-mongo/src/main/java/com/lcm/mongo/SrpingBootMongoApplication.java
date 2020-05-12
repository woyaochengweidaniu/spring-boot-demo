package com.lcm.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author LiuChaomin
 * @Date 2020/5/12  14:39
 */
@SpringBootApplication
public class SrpingBootMongoApplication {
    public static void main(String[] args) {
        SpringApplication.run(SrpingBootMongoApplication.class,args);
    }


}
