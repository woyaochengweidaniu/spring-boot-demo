package com.lcm.mybatisplus.work.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lcm.mybatisplus.work.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

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


    /**
     * 使用mybatis的注解进行sql语句查询
     * @param age   年龄
     * @return  返回结果集
     */
    @Select("select * from user where age = #{age}")
    @ResultType(User.class)
    List<User> select(@Param("age") int age);



}
