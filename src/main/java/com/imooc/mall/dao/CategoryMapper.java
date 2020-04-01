package com.imooc.mall.dao;

import com.imooc.mall.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 * @date 2020/01/09
 */
public interface CategoryMapper {

    /**
     * 查询商品的分类信息
     *
     * @param id
     * @return
     */
    @Select("select * from mall_category where id = ${id}")
    Category findById(@Param("id") Integer id);

    /**
     * 查询商品的分类信息
     *
     * @param id
     * @return
     */
    Category queryById(Integer id);
}
