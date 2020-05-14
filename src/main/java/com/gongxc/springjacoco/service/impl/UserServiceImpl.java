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
    public User login(String username, String password) {
        return userRepository.login(username,password);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void update(String username,String password) {
        userRepository.change(password,username);
    }

    @Override
    public User getByName(String username) {
        User user;
        try {
            user = userRepository.findByUserName(username);

        } catch (Exception e) {
            user = userRepository.findsByUserName(username).get(0);

        }
        return user;
    }


}
