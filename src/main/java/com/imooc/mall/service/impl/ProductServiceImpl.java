package com.imooc.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.imooc.mall.dao.ProductMapper;
import com.imooc.mall.pojo.Product;
import com.imooc.mall.service.ICategoryService;
import com.imooc.mall.service.IProductService;
import com.imooc.mall.vo.ProductDetatilVo;
import com.imooc.mall.vo.ProductVo;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.imooc.mall.enums.ProductStatusEnum.DELETE;
import static com.imooc.mall.enums.ProductStatusEnum.OFF_SALE;
import static com.imooc.mall.enums.ResponseEnum.PRODUCT_OFF_SALE_OR_DELETE;

/**
 * @author Administrator
 * @date 2020/04/17
 */
@Service
public class ProductServiceImpl implements IProductService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ICategoryService categoryService;
    @Override
    public ResponseVo<PageInfo> list(Integer categoryId, Integer pageNum, Integer pageSize) {
        Set<Integer> categoryIdSet = new HashSet<>();
        if(categoryId != null){
            categoryService.findSubCategoryId(categoryId,categoryIdSet);
            categoryIdSet.add(categoryId);
        }
        PageHelper.startPage(pageNum,pageSize);
        List<Product> productList = productMapper.selectByCategoryId(categoryIdSet);
        List<ProductVo> productVoList = productList.stream()
                .map(e ->{
                    ProductVo productVo = new ProductVo();
                    BeanUtils.copyProperties(e,productVo);
                    return productVo;
                })
                .collect(Collectors.toList());
        PageInfo pageInfo = new PageInfo(productVoList);
        return ResponseVo.success(pageInfo);
    }

    @Override
    public ResponseVo<ProductDetatilVo> detail(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        //只对确定的条件判断
        if(product.getStatus().equals(OFF_SALE.getCode())
            || product.getStatus().equals(DELETE.getCode())){
            return ResponseVo.error(PRODUCT_OFF_SALE_OR_DELETE);
        }
        ProductDetatilVo productDetatilVo = new ProductDetatilVo();
        BeanUtils.copyProperties(product,productDetatilVo);
        //敏感数据处理
        productDetatilVo.setStock(product.getStock() > 100 ? 100 : product.getStock());
        return ResponseVo.success(productDetatilVo);
    }
}
