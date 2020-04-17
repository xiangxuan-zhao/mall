package com.imooc.mall.service.impl;

import com.imooc.mall.MallApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @author Administrator
 * @date 2020/04/17
 */
public class ProductServiceImplTest extends MallApplicationTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ProductServiceImpl productService;
    @Test
    public void list() {
        productService.list(100001,1,10);
    }
}