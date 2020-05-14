package com.gongxc.springjacoco.controller;

import com.gongxc.springjacoco.common.ResponseResult;
import com.gongxc.springjacoco.entity.User;
import com.gongxc.springjacoco.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * UserContoller
 *
 * @author gongxc
 * @date 2020-05-13
 */
@RestController
@RequestMapping(value = "/user",produces = "application/json")
@Api(value="User",tags = {"精准化测试"}, description = "接口测试覆盖率demo")
public class UserContoller {

    @Autowired
    private UserService userService;

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "使用id查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "int",paramType = "path",required = true,defaultValue = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<Optional<User>> findUserById(@PathVariable("id") Integer id){

        Optional<User> user= userService.findUserById(id);
        return ResponseResult.successWithData(user);
    }

    @GetMapping("/findByName")
    @ApiOperation(value = "使用名字查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "USERNAME",name = "username",dataType = "String",required = true,defaultValue = "gongxc")
    })
    @ApiResponses({
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<User> findByName(String username) {
        User user = userService.getByName(username);
        return ResponseResult.successWithData(user);
    }
    @GetMapping("/delete")
    @ApiOperation(value = "删除用户")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "int",required = true,defaultValue = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<List<User>> deleteById(Integer id){
        userService.deleteById(id);
        List<User> users = userService.findAll();
        return ResponseResult.successWithData(users);
    }

    @GetMapping("/getCount")
    @ApiOperation(value = "获得用户数量")
    public ResponseResult getCount(){
        Long count = userService.getCount();
        return ResponseResult.successWithData(count);
    }

    @PostMapping("/create")
    @ApiOperation(value = "创建用户")
    @ApiResponses({
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<User> createUser(@Validated @RequestBody User user){
        User dbUser = userService.save(user);
        return ResponseResult.successWithData(dbUser);
    }



    @PostMapping("/exist")
    @ApiOperation(value = "查询用户是否存在")
    public ResponseResult<User> existsById(Integer id){
        boolean status = userService.existsById(id);
        return ResponseResult.success();
    }

    @PostMapping("/findAll")
    @ApiOperation(value = "查询所有用户")
    @ApiResponses({
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<List<User>> findAll(){
        List<User> users = userService.findAll();
        return ResponseResult.successWithData(users);
    }


    @PostMapping("/update")
    @ApiOperation(value = "更新用户")
    @ApiResponses({
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<User> updateUser(@Validated @RequestBody User user){
        userService.update(user.getUsername(),user.getPassword());
        User user1 = userService.getByName(user.getUsername());
        return ResponseResult.successWithData(user1);
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "USERNAME",name = "username",dataType = "String",required = true,defaultValue = "gongxc"),
            @ApiImplicitParam(value = "PASSWORD",name = "password",dataType = "String",required = true,defaultValue = "123456")
    })
    @ApiResponses({
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<User> login(String username,String password){
        User dbUser = userService.login(username,password);
        return ResponseResult.successWithData(dbUser);
    }

}
