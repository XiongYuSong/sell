package com.xiong.sell.service.impl;

import com.xiong.sell.dto.OrderDTO;
import com.xiong.sell.service.PushMessage;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xiong YuSong
 * 2019/1/28 17:02
 */
@Service
@Slf4j
public class PushMessageImpl implements PushMessage {

    @Autowired
    private WxMpService wxMpService;

    @Override
    public void orderStatus(OrderDTO orderDTO) {
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        templateMessage.setTemplateId("sBkdCQcYxaVaIlhQ2wGuejjr_K1I0Rv2HVCZHIaNXdg");
        templateMessage.setToUser("oIe231KOhNAGPWEIsE52bdPBA910");
        List<WxMpTemplateData> data = new ArrayList<>();
        data.add(new WxMpTemplateData("first","这是标题"));
        data.add(new WxMpTemplateData("keyword1",String.valueOf(orderDTO.getBuyerOpenid())));
        data.add(new WxMpTemplateData("remark","这是结尾"));
        templateMessage.setData(data);
        try{
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        }catch (WxErrorException e){
            log.info("【微信模板消息】发送失败，{}",e);
        }
    }
}
