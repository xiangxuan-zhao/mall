package com.imooc.mall.service;

import com.imooc.mall.vo.CategoryVo;
import com.imooc.mall.vo.ResponseVo;

import java.util.List;
import java.util.Set;

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

    /**
     * 查询类目及其子类目id
     * @param id
     * @param resultSet
     */
    void findSubCategoryId(Integer id, Set<Integer> resultSet);
}
