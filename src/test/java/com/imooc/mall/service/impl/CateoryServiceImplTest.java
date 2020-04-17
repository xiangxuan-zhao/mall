package com.imooc.mall.service.impl;

import com.imooc.mall.MallApplicationTest;
import com.imooc.mall.enums.ResponseEnum;
import com.imooc.mall.vo.CategoryVo;
import com.imooc.mall.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Administrator
 * @date 2020/04/16
 */
@Slf4j
public class CateoryServiceImplTest extends MallApplicationTest {
    @Autowired
    private CategoryServiceImpl cateoryService;
    @Test
    public void selectAll() {
        ResponseVo<List<CategoryVo>> responseVo = cateoryService.selectAll();
        log.info("" + responseVo.getData());
    }

    @Test
    public void findSubCategoryId(){
        Set<Integer> result = new HashSet<>();
        cateoryService.findSubCategoryId(100001,result);
        log.info("result = " + result);
    }
}