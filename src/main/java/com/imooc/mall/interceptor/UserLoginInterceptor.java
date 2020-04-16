package com.imooc.mall.interceptor;

import com.imooc.mall.consts.MallConst;
import com.imooc.mall.exception.UserLoginException;
import com.imooc.mall.pojo.User;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import static com.imooc.mall.enums.ResponseEnum.NEED_LOGIN;

/**
 * @author Administrator
 * @date 2020/04/13
 */
@Slf4j
public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = (User)request.getSession().getAttribute(MallConst.CURRENT_USER);
        if(user == null){
            throw new UserLoginException();
        }
        return true;
    }
}
