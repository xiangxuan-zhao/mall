package com.imooc.mall.service.impl;

import com.imooc.mall.MallApplicationTest;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.enums.RoleEnum;
import com.imooc.mall.pojo.User;
import com.imooc.mall.service.IUserService;
import com.imooc.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

/**
 * @author Administrator
 * @date 2020/04/13
 */
@Transactional
public class UserServiceImplTest extends MallApplicationTest {

    @Autowired
    private IUserService userService;
    @Test
    public void register() {
        User user = new User("test1","abc@123","237791620@qq.com", RoleEnum.ADMIN.getCode());
        ResponseVo<User> responseVo = userService.register(user);
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
}