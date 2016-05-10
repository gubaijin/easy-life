package com.api.mobile.model;

/**
 * Created by Kevin on 2016/5/10.
 */
public class Response {
    /**
     *返回码
     */
    private int error_code;
    /**
     *	返回说明
     */
    private String reason;
    /**
     *	返回结果集
     */
    private String result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
