// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.data.datasource;

import com.feilang.mvpproject.util.ApiEventDispatchUtils;
import com.feilang.mvpproject.data.models.ResultData;
import android.support.annotation.NonNull;
import java.util.Calendar;
import android.support.annotation.UiThread;
import org.springframework.http.HttpStatus;
import java.lang.ref.WeakReference;

public abstract class DataCallWrapper<T>
{
    public String apiName;
    public DataNotifyEvent.ApiEventType identifier;
    public boolean ignoreError;
    private WeakReference<Object> mCaller;
    private HttpStatus mHttpStatus;
    private Object[] mParams;
    public boolean needProgress;
    public long serialIdentifier;
    public Object tag;
    
    public DataCallWrapper(final Object referent, final DataNotifyEvent.ApiEventType identifier) {
        this.serialIdentifier = 0L;
        this.mParams = null;
        this.mCaller = new WeakReference<Object>(referent);
        this.identifier = identifier;
        this.needProgress = true;
    }
    
    public DataCallWrapper(final Object referent, final DataNotifyEvent.ApiEventType identifier, final boolean needProgress) {
        this.serialIdentifier = 0L;
        this.mParams = null;
        this.mCaller = new WeakReference<Object>(referent);
        this.identifier = identifier;
        this.needProgress = needProgress;
    }
    
    public DataCallWrapper(final Object referent, final DataNotifyEvent.ApiEventType identifier, final boolean needProgress, final boolean ignoreError) {
        this.serialIdentifier = 0L;
        this.mParams = null;
        this.mCaller = new WeakReference<Object>(referent);
        this.identifier = identifier;
        this.needProgress = needProgress;
        this.ignoreError = ignoreError;
    }
    
    public DataCallWrapper(final Object referent, final DataNotifyEvent.ApiEventType identifier, final boolean needProgress, final boolean ignoreError, final Object... mParams) {
        this.serialIdentifier = 0L;
        this.mParams = null;
        this.mCaller = new WeakReference<Object>(referent);
        this.identifier = identifier;
        this.needProgress = needProgress;
        this.ignoreError = ignoreError;
        this.mParams = mParams;
    }
    
    @UiThread
    private void notifyViews(final Object... array) {
        final DataNotifyEvent dataNotifyEvent = new DataNotifyEvent(this.identifier, array);
        if (this.mParams != null) {
            dataNotifyEvent.setApiParams(this.mParams);
        }
        DataNotifyEventBus.getInstance().post(dataNotifyEvent);
    }
    
    public void callStart() {
        this.serialIdentifier = Calendar.getInstance().getTimeInMillis();
    }
    
    @NonNull
    public ResultType checkBusinessError(final T t) {
        return ResultType.UN_KNOW;
    }
    
    public Object getCaller() {
        if (this.mCaller == null) {
            return null;
        }
        return this.mCaller.get();
    }
    
    public HttpStatus getHttpStatus() {
        return this.mHttpStatus;
    }
    
    @NonNull
    public abstract ResultData handleData(final T p0);
    
    public void onSucceedCallback(final T t) {
        if (!this.ignoreError && ResultType.NO_RESULT == this.checkBusinessError(t)) {
            ApiEventDispatchUtils.dispatchNoResultEvent(this.getCaller(), this.identifier);
        }
        else {
            final ResultData handleData = this.handleData(t);
            if (handleData != null) {
                this.notifyViews(handleData.getData());
            }
        }
    }
    
    public void setHttpStatus(final HttpStatus mHttpStatus) {
        this.mHttpStatus = mHttpStatus;
    }
    
    public enum ResultType
    {
        NO_RESULT, 
        UN_KNOW;
    }
}
