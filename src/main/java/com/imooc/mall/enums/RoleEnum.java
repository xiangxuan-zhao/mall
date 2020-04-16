package com.imooc.mall.enums;

import lombok.Getter;

/**
 * @author Administrator
 * @date 2020/04/13
 */
@Getter
public enum  RoleEnum {
    /**
     * 角色0-管理员,1-普通用户
     */
    ADMIN(0),

    CUSTOMER(1),

    ;
    Integer code;

    RoleEnum(Integer code) {
        this.code = code;
    }
}
