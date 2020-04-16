package com.imooc.mall.controller;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.imooc.mall.consts.MallConst;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.form.UserLoginForm;
import com.imooc.mall.form.UserRegisterForm;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import static com.imooc.mall.enums.ResponseEnum.*;

/**
 * @author Administrator
 * @date 2020/04/13
 */
@RestController
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/user/register")
    public ResponseVo<User> register(@Valid @RequestBody UserRegisterForm userRegisterForm, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return ResponseVo.error(PARAM_ERROR,bindingResult);
        }
        User user = new User();
        BeanUtils.copyProperties(userRegisterForm,user);
        return userService.register(user);
    }

    @PostMapping("/user/login")
    public ResponseVo<User> userLogin(@Valid @RequestBody UserLoginForm userLoginForm,
                                      BindingResult bindingResult,
                                      HttpSession session){
        if(bindingResult.hasFieldErrors()){
            return ResponseVo.error(PARAM_ERROR,bindingResult);
        }
        ResponseVo<User> userResponseVo = userService.login(userLoginForm.getUsername(), userLoginForm.getPassword());
        session.setAttribute(MallConst.CURRENT_USER,userResponseVo.getData());
        return userResponseVo;
    }

    @GetMapping("/user")
    public ResponseVo<User> userInfo(HttpSession session){
        User user = (User)session.getAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success(user);
    }

    @PostMapping("/user/logout")
    /**
     * {@link org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory} getSessionTimeOutInMinutes
     */
    public ResponseVo logout(HttpSession session) {
        session.removeAttribute(MallConst.CURRENT_USER);
        return ResponseVo.success();
    }
}
