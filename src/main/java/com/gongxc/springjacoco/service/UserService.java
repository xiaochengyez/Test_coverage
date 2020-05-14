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

    User getOne(Integer id);

    long getCount();

    List<User> findAll();

    Optional<User> findUserById(Integer id);

    User save(User user);

    User update(User user);

    public boolean existsById(Integer id);

}
