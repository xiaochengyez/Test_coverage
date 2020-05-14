package com.gongxc.springjacoco.service;

import com.gongxc.springjacoco.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * UserService
 *
 * @author gongxc
 * @date 2020-05-13
 */
public interface UserService {

    long getCount();

    boolean existsById(Integer id);

    List<User> findAll();

    Optional<User> findUserById(Integer id);

    User save(User user);

    void update(String username,String password);

    User getByName(String username);

    User login(String username,String password);

    void deleteById(Integer id);

}
