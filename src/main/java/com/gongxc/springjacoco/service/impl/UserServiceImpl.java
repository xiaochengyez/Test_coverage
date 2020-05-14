package com.gongxc.springjacoco.service.impl;

import com.gongxc.springjacoco.dao.UserRepository;
import com.gongxc.springjacoco.entity.User;
import com.gongxc.springjacoco.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

/**
 * UserServiceImpl
 *
 * @author gongxc
 * @date 2020-05-13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User getOne(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public long getCount() {
        return userRepository.count();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean existsById(Integer id) {
        return userRepository.existsById(id);
    }

    @Override
    public User update(User user) {
        return null;
    }
}
