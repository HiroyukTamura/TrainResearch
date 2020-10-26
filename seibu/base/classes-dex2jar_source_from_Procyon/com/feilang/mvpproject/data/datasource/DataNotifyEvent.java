// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.data.datasource;

import com.feilang.mvpproject.data.models.ErrorData;

public class DataNotifyEvent
{
    private Object[] mApiParams;
    private Object mCaller;
    private Object[] mData;
    private ErrorData mErrorData;
    private boolean mResult;
    private ApiEventType mType;
    
    public DataNotifyEvent(final ApiEventType mType, final Object... mData) {
        this.mResult = false;
        this.mType = mType;
        this.mResult = true;
        this.mData = mData;
        this.mErrorData = null;
    }
    
    public DataNotifyEvent(final Object mCaller, final ApiEventType mType, final ErrorData mErrorData) {
        this.mResult = false;
        this.mCaller = mCaller;
        this.mType = mType;
        this.mResult = false;
        this.mData = null;
        this.mErrorData = mErrorData;
    }
    
    public Object[] getApiParams() {
        return this.mApiParams;
    }
    
    public Object[] getData() {
        return this.mData;
    }
    
    public ErrorData getErrorData() {
        return this.mErrorData;
    }
    
    public ApiEventType getType() {
        return this.mType;
    }
    
    public boolean isSameCaller(final Object o) {
        return this.mCaller != null && o == this.mCaller;
    }
    
    public boolean isSucceed() {
        return this.mResult;
    }
    
    public void setApiParams(final Object... mApiParams) {
        this.mApiParams = mApiParams;
    }
    
    public enum ApiEventType
    {
        API_APP_POT_ACCOUNT, 
        API_APP_POT_DONE, 
        API_BASEBALL_GAMES, 
        API_CHANGE_CHECK_IN, 
        API_CHECK_MAINTENANCE, 
        API_DELETE_BEACON, 
        API_DELETE_CHECK_IN, 
        API_DESTINATIONSINfO, 
        API_EMERG, 
        API_EVENT_MESSAGE, 
        API_GET_CHECK_IN, 
        API_GET_SHARED_CHECK_IN, 
        API_HEADLINES, 
        API_MASTER_DATA, 
        API_MY_STATION_ADD, 
        API_MY_STATION_UPDATE, 
        API_NONE, 
        API_NOTICE_MESSAGE, 
        API_NOTICE_MESSAGE_UNREAD, 
        API_REGISTER_BEACON, 
        API_REQUEST_CHECK_IN, 
        API_RUN_STATUS_HISTORY, 
        API_RUN_STATUS_MESSAGE, 
        API_STATION_DEPARTURES, 
        API_STATION_DEPARTURES_HOME, 
        API_STATION_DEPARTURES_MY, 
        API_STATION_DETAIL_INFO, 
        API_STATION_INFO, 
        API_STATION_LINE_DIRECTION, 
        API_STATION_NEARBY, 
        API_STATION_TIME_TABLE, 
        API_THREE_NOTICE, 
        API_TRAIN_INFO, 
        API_TRAIN_LIST, 
        API_TRAIN_TIME_TABLE, 
        API_TRAIN_USAGE_MESSAGE, 
        API_TRAIN_WRAPPING_MESSAGE, 
        API_WALLPAPERS;
    }
}
