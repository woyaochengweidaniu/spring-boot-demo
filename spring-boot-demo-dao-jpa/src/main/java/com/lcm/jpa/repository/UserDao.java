package com.lcm.jpa.repository;

import com.lcm.jpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * User Dao
 * </p>
 JpaRepository<User, Long>  提供增删改查  简单分页
 JpaSpecificationExecutor  提供多条件分页查询
 */
@Repository
public interface UserDao extends JpaRepository<User, Long> {


    Page<User> findAllByNameContaining(String name,Pageable pageable);

}
