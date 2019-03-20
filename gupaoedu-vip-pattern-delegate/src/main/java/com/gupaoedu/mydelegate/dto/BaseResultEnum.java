package com.gupaoedu.mydelegate.dto;

public enum BaseResultEnum {
    SUCCESS("SUCCESS", "成功"), FAIL("FAIL", "失败"), EXCEPTION("EXCEPTION", "异常"), PROCESSING("PROCESSING", "处理中")
    //, NOLOGIN("NOLOGIN", "未登录或者登陆超时")
    ;
    private String code;
    private String message;

    private BaseResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}