package com.imooc.mall.controller;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.service.IProductService;
import com.imooc.mall.vo.ProductDetatilVo;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;
    @GetMapping("/products")
    public ResponseVo<PageInfo> list(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        return productService.list(categoryId,pageNum,pageSize);
    }

    @GetMapping("/products/{productId}")
    public ResponseVo<ProductDetatilVo> detail(@PathVariable Integer productId){
        return productService.detail(productId);
    }

}
