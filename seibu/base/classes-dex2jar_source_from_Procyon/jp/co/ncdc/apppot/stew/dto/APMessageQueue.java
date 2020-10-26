// 
// Decompiled by Procyon v0.5.36
// 

package jp.co.ncdc.apppot.stew.dto;

import android.util.Log;

public class APMessageQueue
{
    public long createDate;
    public int messageType;
    public String serverUpdateTime;
    public String targetObjectId;
    public String targetTableName;
    
    public APMessageQueue() {
    }
    
    public APMessageQueue(final String targetTableName, final String targetObjectId, final int messageType, final String serverUpdateTime) {
        this.targetTableName = targetTableName;
        this.targetObjectId = targetObjectId;
        this.messageType = messageType;
        this.serverUpdateTime = serverUpdateTime;
        this.createDate = System.currentTimeMillis();
    }
    
    public static String createQuery() {
        final String format = String.format("CREATE TABLE %s (%s TEXT, %s TEXT, %s INTEGER, %s TEXT, %s NUMERIC);", APMessageQueue.class.getSimpleName(), "targetTableName", "targetObjectId", "messageType", "serverUpdateTime", "createDate");
        Log.d("APMessageQueue", format);
        return format;
    }
}
