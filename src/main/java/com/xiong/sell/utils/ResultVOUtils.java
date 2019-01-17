package com.xiong.sell.utils;

import com.xiong.sell.vo.ResultVO;

/**
 * @author Xiong YuSong
 * 2019/1/17 18:35
 */
public class ResultVOUtils {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setMsg("成功");
        resultVO.setCode(0);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static  ResultVO error(Integer code ,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(code);
        return  resultVO;
    }
}
