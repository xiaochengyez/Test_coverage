package com.gongxc.springjacoco.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import javax.persistence.*;
import javax.validation.constraints.Null;

/**
 * User
 *
 * @author gongxc
 * @date 2020-05-13
 */
@Data
@Entity(name = "users")
@Table(name = "users")
@ApiModel(description = "用户Model")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "id必须为空")
    @Column(name = "id")
    @ApiModelProperty(value = "用户ID", name = "id")
    private Integer id;

    @Column(name = "username")
    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(value = "用户名", name = "username", required = true, example = "gongxc")
    private String username;

    @Column(name = "password")
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", name = "password", required = true, example = "123456")
    private String password;
}
