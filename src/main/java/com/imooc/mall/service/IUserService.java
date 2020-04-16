package com.imooc.mall.service;

import com.imooc.mall.pojo.User;
import com.imooc.mall.vo.ResponseVo;

/**
 * @author Administrator
 * @date 2020/04/13
 */
public interface IUserService {
    /**
     * 注册
     * @param user
     * @return
     */
    ResponseVo<User> register(User user);

    /**
     * 登录校验
     * @param username
     * @param password
     * @return
     */
    ResponseVo<User> login(String username,String password);
}
