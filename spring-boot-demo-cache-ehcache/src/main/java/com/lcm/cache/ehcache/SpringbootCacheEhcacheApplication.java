package com.lcm.cache.ehcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Author LiuChaomin
 * @Date 2020/5/7  16:07
 */
@EnableCaching
@SpringBootApplication
public class SpringbootCacheEhcacheApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootCacheEhcacheApplication.class,args);
    }
}
