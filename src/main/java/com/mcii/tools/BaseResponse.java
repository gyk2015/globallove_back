package com.mcii.tools;

/**
 * 响应格式规范
 */
public class BaseResponse {
    //存放响应信息
    private String message="";
    //存放响应结果,SUCCESS or FAIL
    private ResponseStatus status;
    //存放反应对象
    private Object object=null;

    public BaseResponse(String message,ResponseStatus status,Object object){
        this.message = message;
        this.status = status;
        this.object = object;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }
}
