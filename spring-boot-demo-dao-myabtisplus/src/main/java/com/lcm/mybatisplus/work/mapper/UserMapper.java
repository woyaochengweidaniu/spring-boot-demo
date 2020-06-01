package com.lcm.mybatisplus.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcm.mybatisplus.work.entity.User;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lcm
 * @since 2019-07-18
 */
public interface UserMapper extends BaseMapper<User> {


    List<User> select(int age);

}
