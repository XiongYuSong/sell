package com.xiong.sell.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Xiong YuSong
 * 2019/1/28 11:16
 */
@Component
@Data
@ConfigurationProperties(prefix = "project.url")
public class ProjectUrlConfig {
    private String sell;
}
