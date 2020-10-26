// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew;

public class APError
{
    private int errorCode;
    private String message;
    
    APError(final String message, final int errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
    
    public String getDescription() {
        return String.format("[errCode]:%s, [description]:%s", this.errorCode, this.message);
    }
    
    public int getErrorCode() {
        return this.errorCode;
    }
    
    public String getMessage() {
        return this.message;
    }
}
