package com.xiong.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

/**
 * @author Xiong YuSong
 * 2019/1/27 12:46
 */
@Data
public class ProductForm {
    private String productId;

    /** 名字. */
    @NotEmpty(message = "名字必填")
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    @NotEmpty(message = "描述必填")
    private String productDescription;

    /** 小图. */
    @NotEmpty(message = "图片必填")
    private String productIcon;

    /** 类目编号. */
    private Integer categoryType;
}
