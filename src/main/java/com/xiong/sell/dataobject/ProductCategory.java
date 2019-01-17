package com.xiong.sell.dataobject;

import lombok.Data;

import javax.persistence.*;

/**
 * 类目表
 *
 * @author Xiong YuSong
 * 2019/1/17 9:33
 */
@Data
@Entity
@Table(name = "product_category")
public class ProductCategory {
    /**
     * 类目ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;
    /**
     * 类目名字
     */
    private String categoryName;
    /**
     * 类目编号
     */
    private Integer categoryType;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
