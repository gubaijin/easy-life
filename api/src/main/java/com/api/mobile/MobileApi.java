package com.api.mobile;

import com.api.Api;

/**
 * Created by Kevin on 2016/5/10.
 */
public class MobileApi implements Api {
    @Override
    public void init() {

    }
/*    //应用APPKEY(应用详细页查询)
    private static final String APP_KEY_MOBILE = "";
    //检测手机号码是否能充值
    private static final String MOBILE_API_TEL_CHECK = "http://op.juhe.cn/ofpay/mobile/telcheck";
    //根据手机号和面值查询商品
    private static final String MOBILE_API_TEL_QUERY = "http://op.juhe.cn/ofpay/mobile/telquery";
    //手机直充接口
    private static final String MOBILE_API_ONLINE_ORDER = "http://op.juhe.cn/ofpay/mobile/onlineorder";

    *//**
     * 检测手机号码是否能充值
     *
     * @param phoneno 手机号码
     * @param cardnum 充值金额,目前可选：10、20、30、50、100、300
     * @return
     *//*
    public Response telcheck(String phoneno, String cardnum) {
        return null;
    }

    *//**
     * 根据手机号和面值查询商品
     * @param phoneno 	手机号码
     * @param cardnum 充值金额,目前可选：10、20、30、50、100、300
     * @return
     *//*
    public Response telquery(String phoneno, String cardnum) {
        return null;
    }

    public Response onlineOrder(String phoneno, String cardnum){

    }*/
}
