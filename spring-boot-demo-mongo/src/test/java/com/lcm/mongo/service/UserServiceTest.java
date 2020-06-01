package com.lcm.mongo.service;

import com.lcm.mongo.SpringbootMongoApplicationTest;
import com.lcm.mongo.dao.RoleDao;
import com.lcm.mongo.dao.UserDao;
import com.lcm.mongo.module.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LiuChaomin
 * @Date 2020/5/12  14:57
 */
@Slf4j
public class UserServiceTest extends SpringbootMongoApplicationTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSaveAll(){
        List<User> userList = new ArrayList<>();
        userList.add(User.builder().userName("小丑").build());
        userList.add(User.builder().userName("魔术师").build());
        userList.add(User.builder().userName("狂妄小子").build());
        List<User> all = userDao.saveAll(userList);
        all.stream().forEach(System.out::println);
    }

    @Test
    public void testUpdate(){
        User byUserName = userDao.findByUserName("小丑");
        byUserName.setUserName("被修改的小丑");
        User save = userDao.save(byUserName);
        log.info("user:{}",save);
    }



    @Test
    public void testfind(){
        User user = userDao.findByUserName("小丑");
        log.info("user:{}",user);
    }
    
    @Test
    public void testDelete(){
        long affectCount = userDao.deleteByUserName("魔术师");
        log.info("删除数据文档个数：{}",affectCount);
    }


}
