package com.xiong.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * 商品详细
 * @author Xiong YuSong
 * 2019/1/17 14:12
 */
@Entity
@Data
@Table(name = "product_info")
public class ProductInfo {

    @Id
    private String productId;
    /** 名字 */
    private String productName;
    /** 单价 */
    private BigDecimal productPrice;
    /** 库存 */
    private Integer productStock;
    /** 描述 */
    private String productDescription;
    /** 小图 */
    private String productIcon;
    /** 状态, 0正常1下架 */
    private Integer productStatus;
    /** 类目编号 */
    private Integer categoryType;
}
