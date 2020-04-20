package com.imooc.mall.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.vo.ProductDetatilVo;
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
    ResponseVo<PageInfo> list(Integer category, Integer pageNum, Integer pageSize);

    /**
     * 商品详情
     * @param productId
     * @return
     */
    ResponseVo<ProductDetatilVo> detail(Integer productId);
}
