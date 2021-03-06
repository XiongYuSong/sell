package com.xiong.sell.enums;

import lombok.Getter;

/**
 * @author Xiong YuSong
 * 2019/1/18 13:43
 */
@Getter
public enum ResultEnum {
    /**
     * 商品不存在
     */
    SUCCESS(0,"成功"),
    PARAM_ERROR(1,"参数错误"),
    PRODUCT_NOT_EXIST(10,"商品不存在"),
    PRODUCT_STOCK_ERROR(11,"商品库存错误"),
    ORDER_NOT_EXIST(12, "订单不存在"),
    ORDERDETAIL_NOT_EXIST(13, "订单详情不存在"),
    ORDER_STATUS_ERROR(14, "订单状态不正确"),
    ORDER_UPDATE_FAIL(15, "订单更新失败"),
    ORDER_DETAIL_EMPTY(16, "订单详情为空"),
    ORDER_PAY_STATUS_ERROR(17, "订单支付状态不正确"),
    CART_EMPTY(18,"购物车为空"),
    ORDER_OWNER_ERROR(19,"订单主人错误"),
    WECHAT_MP_ERROR(20,"微信公众号错误"),
    ORDER_CANCEL_SUCCESS(21,"订单取消成功"),
    ORDER_FINISH_SUCCESS(22,"订单完结成功"),
    PRODUCT_STATUS_ERROR(23,"商品状态错误"),
    PRODUCT_ON_SALE_SUCCESS(24,"商品上架成功"),
    PRODUCT_OFF_SALE_SUCCESS(25,"商品下架成功"),
    PRODUCT_SAVE_SUCCESS(26,"商品保存成功"),
    CATEGORY_SAVE_SUCCESS(26,"类目保存成功"),
    LOGIN_FAIL(27,"登录失败，openid错误"),
    LOGOUT_SUCCESS(27,"登出成功"),
    ;
    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }}
