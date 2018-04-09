package com.youxiang.dao;

import com.youxiang.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: Rivers
 * @date: 2018/4/8
 */
public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
