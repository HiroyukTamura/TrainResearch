// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew.dto;

import android.util.Log;

public class APLogging
{
    public long createDate;
    public int logLevel;
    public String message;
    public String userToken;
    
    public APLogging() {
    }
    
    public APLogging(final int logLevel, final String message, final String userToken) {
        this.logLevel = logLevel;
        this.message = message;
        this.userToken = userToken;
        this.createDate = System.currentTimeMillis();
    }
    
    public static String createQuery() {
        final String format = String.format("CREATE TABLE %s (%s INTEGER, %s TEXT, %s TEXT, %s NUMERIC);", APLogging.class.getSimpleName(), "logLevel", "message", "userToken", "createDate");
        Log.d("APLogging", format);
        return format;
    }
}
