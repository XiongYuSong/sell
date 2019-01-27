package com.xiong.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author Xiong YuSong
 * 2019/1/27 13:47
 */
@Data
public class CategoryForm {

    private Integer categoryId;
    /**
     * 类目名字
     */
    @NotEmpty(message = "类目名称不能为空")
    private String categoryName;
    /**
     * 类目编号
     */
    private Integer categoryType;

}
