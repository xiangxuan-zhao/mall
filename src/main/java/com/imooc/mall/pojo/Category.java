package com.imooc.mall.pojo;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * @author Administrator
 * @date
 */
@Data
public class Category {

    private Integer id;

    private Integer parentId;

    private String name;

    private Boolean status;

    private Integer sortOrder;

    private Date createTime;

    private Date updateTime;
}