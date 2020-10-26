// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.data.models;

public class ErrorData
{
    private String code;
    private String detail;
    private String message;
    private Object tag;
    
    public ErrorData(final String code, final String message) {
        this.code = code;
        this.message = message;
    }
    
    public ErrorData(final String code, final String message, final Object tag) {
        this.tag = tag;
        this.code = code;
        this.message = message;
    }
    
    public String getCode() {
        return this.code;
    }
    
    public String getDetail() {
        return this.detail;
    }
    
    public String getMessage() {
        return this.message;
    }
    
    public Object getTag() {
        return this.tag;
    }
    
    public void setCode(final String code) {
        this.code = code;
    }
    
    public void setDetail(final String detail) {
        this.detail = detail;
    }
    
    public void setMessage(final String message) {
        this.message = message;
    }
    
    public void setTag(final Object tag) {
        this.tag = tag;
    }
    
    @Override
    public String toString() {
        return "ErrorData{code='" + this.code + '\'' + ", message='" + this.message + '\'' + ", detail='" + this.detail + '\'' + "\uff0c tag='" + this.tag + '\'' + '}';
    }
}
