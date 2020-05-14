package com.gongxc.springjacoco;


import com.gongxc.springjacoco.service.UserService;
import com.gongxc.springjacoco.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringJacocoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void createUser() {
        UserService userService = new UserServiceImpl();
        System.out.println(userService.findAll());
    }

}
