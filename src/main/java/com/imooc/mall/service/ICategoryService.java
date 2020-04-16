package com.imooc.mall.service;

import com.imooc.mall.vo.CategoryVo;
import com.imooc.mall.vo.ResponseVo;

import java.util.List;

/**
 * @author Administrator
 * @date 2020/04/16
 */
public interface ICategoryService {
    /**
     * 查询所有商品类目
     * @return
     */
    ResponseVo<List<CategoryVo>> selectAll();
}
