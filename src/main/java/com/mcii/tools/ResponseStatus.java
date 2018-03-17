package com.mcii.tools;


/**
 * 响应状态，被响应格式所用
 */
public enum ResponseStatus {
    SUCCESS("SUCCESS"),FAIL("FAIL");

    private String status;

    private ResponseStatus(String status) {
        this.status = status;
    }
}
