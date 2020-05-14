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


    @GetMapping("/getCount")
    public ResponseResult getCount(){
        Long count = userService.getCount();
        return ResponseResult.successWithData(count);
    }


    @PostMapping("/findAll")
    @ApiOperation(value = "所有用户")
    @ApiResponses({
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<User> findAll(){
        List<User> users = userService.findAll();
        return ResponseResult.successWithData(users.get(1));
    }


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
    public ResponseResult<User> existsById(Integer id){
        boolean status = userService.existsById(id);
        return ResponseResult.success();
    }


}
