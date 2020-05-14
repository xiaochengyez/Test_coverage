package com.gongxc.springjacoco.dao;
import com.gongxc.springjacoco.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * UserRepository
 *
 * @author gongxc
 * @date 2020-05-13
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

//    User findUserById(Integer id);

//    @Query("from users where users.username=:username and users.password=:password")
//    User login(@Param("username") String username,@Param("password") String password);

    }
