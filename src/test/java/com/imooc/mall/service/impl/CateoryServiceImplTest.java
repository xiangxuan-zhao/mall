package com.imooc.mall.service.impl;

import com.imooc.mall.MallApplicationTest;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.vo.CategoryVo;
import com.imooc.mall.vo.ResponseVo;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Administrator
 * @date 2020/04/16
 */
public class CateoryServiceImplTest extends MallApplicationTest {
    @Autowired
    private CategoryServiceImpl cateoryService;
    @Test
    public void selectAll() {
        ResponseVo<List<CategoryVo>> responseVo = cateoryService.selectAll();
        Assert.assertEquals(ResponseEnum.SUCCESS.getCode(),responseVo.getStatus());
    }
}