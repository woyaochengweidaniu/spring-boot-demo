package com.lcm.mybatisplus.work.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.lcm.mybatisplus.work.entity.User;
import com.lcm.mybatisplus.work.mapper.UserMapper;
import com.lcm.mybatisplus.work.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lcm
 * @since 2019-07-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<User> selectListByTemp(){
        RowMapper rowMapper = new BeanPropertyRowMapper<User>(User.class);
        return jdbcTemplate.queryForList("select * from user ",User.class);
    }

}
