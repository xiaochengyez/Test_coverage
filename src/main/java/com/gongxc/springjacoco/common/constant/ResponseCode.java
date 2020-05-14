package com.gongxc.springjacoco.common.constant;


import static com.gongxc.springjacoco.common.ResponseResult.ResponseParam;
import static com.gongxc.springjacoco.common.ResponseResult.ResponseParam.buildParam;

/**
 * ResponseCode
 *
 * @author gongxc
 * @date 2020-05-13
 */
public enum ResponseCode {

    SUCCESS(buildParam(0, "成功"));
    public final  ResponseParam PARAM;
    ResponseCode(ResponseParam param){
        this.PARAM = param;
    }

}
