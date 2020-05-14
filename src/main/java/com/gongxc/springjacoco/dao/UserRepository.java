package com.gongxc.springjacoco.dao;
import com.gongxc.springjacoco.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * UserRepository
 *
 * @author gongxc
 * @date 2020-05-13
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

    @Query("from users where username=?1")
    List<User> findsByUserName(String username);

    @Query("from users where username=?1")
    User findByUserName(String username);

    @Modifying
    @Transactional
    @Query("update users set password=?1 where username=?2")
    public void change(String password,String username);

    @Query(value = "select * from users where users.username=:username and users.password=:password",nativeQuery = true)
    User login(@Param("username") String username,@Param("password") String password);

    }
