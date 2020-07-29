package com.lcm.task.quartz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author LiuChaomin
 * @Date 2020/7/29  17:40
 */
@MapperScan(basePackages = {"com.lcm.task.quartz.mapper"})
@SpringBootApplication
public class SpringbootTaskQuartzApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTaskQuartzApplication.class,args);
    }
}
