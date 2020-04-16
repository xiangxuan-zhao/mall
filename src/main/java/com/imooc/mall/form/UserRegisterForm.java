package com.imooc.mall.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author Administrator
 * @date 2020/04/13
 */
@Data
public class UserRegisterForm {

    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String email;
}
