package com.gupaoedu.mydelegate.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseRespDto<T> extends BaseDto {

    /**
     *
     */
    private static final long serialVersionUID = 5250304724334997704L;

    /**
     * 执行结果是否为终态SUCCESS/FAIL/PROCESSING(需要重试)
     */
    private String resultStatus;

    /**
     * 业务应答码,每个接口实现自己定义
     */
    private String resultCode;

    /**
     * 业务应答信息,每个接口实现自己定义
     */
    private String resultMessage;

    private T content;

    //默认成功
    public BaseRespDto() {
        this.setResultSuccess();
    }


    public BaseRespDto(BaseResultEnum resultStatus, String code, String message) {
        this.resultStatus = resultStatus.getCode();
        this.resultCode = code;
        this.resultMessage = message;
    }

    /**
     * 是否成功
     *
     * @return
     */
//    @JsonIgnore
    public boolean isSuccess() {
        return BaseResultEnum.SUCCESS.getCode().equals(this.resultStatus);
    }

    @JsonIgnore
    public boolean isFail() {
        return BaseResultEnum.FAIL.getCode().equals(this.resultStatus);
    }

    @JsonIgnore
    public boolean isProcessing() {
        return BaseResultEnum.PROCESSING.getCode().equals(this.resultStatus);
    }

    @JsonIgnore
    public boolean isUnknown() {
        return !isSuccess() && !isFail() && !isProcessing();
    }

    @SuppressWarnings("rawtypes")
    public BaseRespDto setResult(String status, String code, String message) {
        this.resultStatus = status;
        this.resultCode = code;
        this.resultMessage = message;
        return this;
    }

    /**
     * 设置失败的返回值，用于透传接口返回值
     *
     * @param errorCode
     */
    @SuppressWarnings("rawtypes")
    public BaseRespDto setResultFail(String errorCode, String message) {
        this.resultStatus = BaseResultEnum.FAIL.getCode();
        this.resultCode = errorCode;
        this.resultMessage = message;
        return this;
    }

    /**
     * 设置成功返回值，默认为终态
     */
    @SuppressWarnings("rawtypes")
    public BaseRespDto setResultSuccess() {
        this.resultStatus = BaseResultEnum.SUCCESS.getCode();
        this.resultCode = BaseResultEnum.SUCCESS.getCode();
        this.resultMessage = BaseResultEnum.SUCCESS.getMessage();
        return this;
    }

    public void setResultSuccess(String errorCode, String message) {
        this.resultStatus = BaseResultEnum.SUCCESS.getCode();
        this.resultCode = errorCode;
        this.resultMessage = message;
    }

    /**
     * 设置成功返回值，根据是否为终态来设置
     */
    @SuppressWarnings("rawtypes")
    public BaseRespDto setResultProcessing(String errorCode, String message) {
        this.resultStatus = BaseResultEnum.PROCESSING.getCode();
        this.resultCode = errorCode;
        this.resultMessage = message;
        return this;
    }

    @SuppressWarnings("rawtypes")
    public BaseRespDto setResultProcessing() {
        this.resultStatus = BaseResultEnum.PROCESSING.getCode();
        this.resultCode = BaseResultEnum.PROCESSING.getCode();
        this.resultMessage = BaseResultEnum.PROCESSING.getMessage();
        return this;
    }

    @SuppressWarnings("rawtypes")
    public BaseRespDto setResult(BaseRespDto res, Object ext) {
        this.resultStatus = res.resultStatus;
        this.resultCode = res.resultCode;
        if (ext == null) {
            this.resultMessage = res.resultMessage + ", detail message:=" + ext;
        } else {
            this.resultMessage = res.resultMessage;
        }
        return this;
    }
}

