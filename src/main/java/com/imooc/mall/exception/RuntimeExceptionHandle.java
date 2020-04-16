package com.imooc.mall.exception;

import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.ws.Response;

import static com.imooc.mall.enums.ResponseEnum.ERROR;

/**
 * @author Administrator
 * @date 2020/04/13
 */
@ControllerAdvice
public class RuntimeExceptionHandle {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
//	@ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseVo handle(RuntimeException e) {
        return ResponseVo.error(ERROR, e.getMessage());
    }

    @ExceptionHandler(UserLoginException.class)
    @ResponseBody
    public ResponseVo userLogin(UserLoginException e){
        return ResponseVo.error(ResponseEnum.NEED_LOGIN);
    }
}
