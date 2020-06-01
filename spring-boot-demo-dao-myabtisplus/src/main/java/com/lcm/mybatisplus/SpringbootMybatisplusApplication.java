package com.lcm.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author LiuChaomin
 * @Date 2020/6/1  17:45
 */
@MapperScan("com.lcm.mybatisplus.work.mapper")
@SpringBootApplication
public class SpringbootMybatisplusApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisplusApplication.class,args);
    }
}
