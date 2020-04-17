package com.imooc.mall.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Administrator
 * @date 2020/04/17
 */
@Data
public class ProductVo {
    private Integer id;

    private Integer categoryId;

    private String name;

    private String subtitle;

    private String mainImage;

    private Integer status;

    private BigDecimal price;
}
