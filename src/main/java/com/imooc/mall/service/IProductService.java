package com.imooc.mall.service;

import com.imooc.mall.vo.ProductVo;
import com.imooc.mall.vo.ResponseVo;

import java.util.List;

/**
 * @author Administrator
 * @date 2020/04/17
 */
public interface IProductService {
    /**
     * 商品列表
     * @param category
     * @param pageNum
     * @param pageSize
     * @return
     */
    ResponseVo<List<ProductVo>> list(Integer category,Integer pageNum,Integer pageSize);
}
