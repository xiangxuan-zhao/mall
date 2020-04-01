package com.imooc.mall.pojo;


import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 * @date
 */
@Data
public class Cart {

    private Integer productId;

    private Integer quantity;

    private Boolean productSelected;

    public Cart() {
    }

    public Cart(Integer productId, Integer quantity, Boolean productSelected) {
        this.productId = productId;
        this.quantity = quantity;
        this.productSelected = productSelected;
    }
}
