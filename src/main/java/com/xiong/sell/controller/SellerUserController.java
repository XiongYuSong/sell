package com.xiong.sell.controller;

import com.xiong.sell.config.ProjectUrlConfig;
import com.xiong.sell.constant.CookieConstant;
import com.xiong.sell.constant.RedisConstant;
import com.xiong.sell.dataobject.SellerInfo;
import com.xiong.sell.enums.ResultEnum;
import com.xiong.sell.service.SellerService;
import com.xiong.sell.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Xiong YuSong
 * 2019/1/28 10:13
 */
@Controller
@RequestMapping("/seller")
public class SellerUserController {

    @Autowired
    private SellerService sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/toLogin")
    public ModelAndView toLogin() {
        return new ModelAndView("login/login");
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("openid") String openid,
                              Map<String, Object> map,
                              HttpServletResponse response) {
        //1.openid和数据库匹配
        SellerInfo sellerInfo = sellerService.findSellerInfoByOpenid(openid);
        if (sellerInfo == null) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/sell/seller/toLogin");
            return new ModelAndView("common/error", map);
        }
        //2.设置token到redis中
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPORE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX, token), openid, expire, TimeUnit.SECONDS);
        //3.设置token到cookie
        CookieUtil.set(response, CookieConstant.TOKEN, token, CookieConstant.EXPORE);
        //页面跳转
        return new ModelAndView("redirect:" + projectUrlConfig.getSell() + "/sell/seller/order/list");
    }


    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request,
                               HttpServletResponse response,
                               Map<String, Object> map) {
        //1.从cookie里面查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie != null) {
            //2.清除redis
            redisTemplate.opsForValue().getOperations().delete((String.format(RedisConstant.TOKEN_PREFIX, cookie.getValue())));
            //3.清除cookie,设置过期时间为0
            CookieUtil.set(response, CookieConstant.TOKEN, null, 0);
        }
        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url","/sell/seller/toLogin");
        return new ModelAndView("common/success",map);
    }
}
