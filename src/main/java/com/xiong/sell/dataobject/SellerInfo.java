package com.xiong.sell.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author Xiong YuSong
 * 2019/1/27 19:42
 */
@Data
@Entity
@DynamicUpdate
public class SellerInfo {

    @Id
    private String sellerId;
    private String username;
    private String password;
    private String openid;
    private Date createTime;
    private Date updateTime;
}
