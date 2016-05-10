package com.api;

import com.api.mobile.MobileApi;
import com.kevin.utils.StringUtils;

/**
 * Created by Kevin on 2016/5/10.
 */
public class ApiFactory {
    /**
     * 使用getApi来获取不同的api对象
     */
    public Api getApi(String apiType) {
        if (StringUtils.isEmpty(apiType)) {
            return null;
        }
        if("MOBILE".equals(apiType)){
            return new MobileApi();
        }
        return null;
    }
}
