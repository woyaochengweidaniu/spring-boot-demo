package com.lcm.mybatisplus.work.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lcm.mybatisplus.work.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lcm
 * @since 2019-07-18
 */
public interface IUserService extends IService<User> {
    List<User> selectListByTemp();

}
