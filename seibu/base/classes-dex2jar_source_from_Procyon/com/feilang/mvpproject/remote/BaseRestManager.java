// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.remote;

import org.androidannotations.api.UiThreadExecutor;
import org.springframework.http.HttpStatus;
import com.feilang.mvpproject.util.AppEventBus;
import org.springframework.web.client.RestTemplate;
import android.support.annotation.NonNull;
import com.feilang.mvpproject.data.datasource.DataCallWrapper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class BaseRestManager implements Restable
{
    private static ReentrantLock lock;
    private static AtomicInteger mProgressTaskCount;
    protected TaskHelper mTaskHelper;
    
    static {
        BaseRestManager.mProgressTaskCount = new AtomicInteger(0);
        BaseRestManager.lock = new ReentrantLock();
    }
    
    @Override
    public void beforeExecuting(final DataCallWrapper dataCallWrapper) {
        if (dataCallWrapper.needProgress) {
            this.showProgress();
            BaseRestManager.mProgressTaskCount.incrementAndGet();
        }
    }
    
    @Override
    public void completeExecute(final DataCallWrapper dataCallWrapper) {
        if (dataCallWrapper.needProgress) {
            BaseRestManager.lock.lock();
            if (BaseRestManager.mProgressTaskCount.get() > 0) {
                BaseRestManager.mProgressTaskCount.decrementAndGet();
                this.hideProgress();
            }
            BaseRestManager.lock.unlock();
        }
    }
    
    public <T, R> R exclusiveRun(final RestApi<T, R> restApi, @NonNull final DataCallWrapper dataCallWrapper, final T... array) {
        dataCallWrapper.callStart();
        if (this.mTaskHelper.run(dataCallWrapper)) {
            return null;
        }
        final R run = restApi.run(dataCallWrapper, array);
        this.runOnSuccess(dataCallWrapper, run);
        this.mTaskHelper.done(dataCallWrapper);
        return run;
    }
    
    protected <T, R> void exclusiveRun(final TaskHelper.Api<T, R> api, @NonNull final DataCallWrapper<R> dataCallWrapper, final T t) {
        dataCallWrapper.callStart();
        if (this.mTaskHelper.run(dataCallWrapper)) {
            return;
        }
        this.runOnSuccess(dataCallWrapper, api.run(t));
        this.mTaskHelper.done(dataCallWrapper);
    }
    
    protected <T, R> void exclusiveRun(final TaskHelper.NoParamApi<T, R> noParamApi, @NonNull final DataCallWrapper dataCallWrapper) {
        dataCallWrapper.callStart();
        if (this.mTaskHelper.run(dataCallWrapper)) {
            return;
        }
        this.runOnSuccess(dataCallWrapper, noParamApi.run());
        this.mTaskHelper.done(dataCallWrapper);
    }
    
    protected <T, R> void exclusiveRun(final TaskHelper.ParamApi2<T, R> paramApi2, @NonNull final DataCallWrapper<R> dataCallWrapper, final T t, final T t2) {
        dataCallWrapper.callStart();
        if (this.mTaskHelper.run(dataCallWrapper)) {
            return;
        }
        this.runOnSuccess(dataCallWrapper, paramApi2.run(t, t2));
        this.mTaskHelper.done(dataCallWrapper);
    }
    
    protected <T, R> void exclusiveRun(final TaskHelper.ParamApi3<T, R> paramApi3, @NonNull final DataCallWrapper<R> dataCallWrapper, final T t, final T t2, final T t3) {
        dataCallWrapper.callStart();
        if (this.mTaskHelper.run(dataCallWrapper)) {
            return;
        }
        this.runOnSuccess(dataCallWrapper, paramApi3.run(t, t2, t3));
        this.mTaskHelper.done(dataCallWrapper);
    }
    
    protected <T, R> void exclusiveRun(final TaskHelper.ParamApi4<T, R> paramApi4, @NonNull final DataCallWrapper<R> dataCallWrapper, final T t, final T t2, final T t3, final T t4) {
        dataCallWrapper.callStart();
        if (this.mTaskHelper.run(dataCallWrapper)) {
            return;
        }
        this.runOnSuccess(dataCallWrapper, paramApi4.run(t, t2, t3, t4));
        this.mTaskHelper.done(dataCallWrapper);
    }
    
    protected <T, R> void exclusiveRun(final TaskHelper.ParamApi5<T, R> paramApi5, @NonNull final DataCallWrapper<R> dataCallWrapper, final T t, final T t2, final T t3, final T t4, final T t5) {
        dataCallWrapper.callStart();
        if (this.mTaskHelper.run(dataCallWrapper)) {
            return;
        }
        this.runOnSuccess(dataCallWrapper, paramApi5.run(t, t2, t3, t4, t5));
        this.mTaskHelper.done(dataCallWrapper);
    }
    
    protected <T, R> void exclusiveRun(final TaskHelper.ParamApi6<T, R> paramApi6, @NonNull final DataCallWrapper<R> dataCallWrapper, final T t, final T t2, final T t3, final T t4, final T t5, final T t6) {
        dataCallWrapper.callStart();
        if (this.mTaskHelper.run(dataCallWrapper)) {
            return;
        }
        this.runOnSuccess(dataCallWrapper, paramApi6.run(t, t2, t3, t4, t5, t6));
        this.mTaskHelper.done(dataCallWrapper);
    }
    
    @Override
    public RestTemplate getRestTemplate() {
        return null;
    }
    
    @Override
    public Object getService() {
        return null;
    }
    
    protected void hideProgress() {
        AppEventBus.hideProgress();
    }
    
    protected void init() {
        this.mTaskHelper = TaskHelper.exclude().rest(this);
    }
    
    protected <T> void runOnSuccess(final DataCallWrapper<T> dataCallWrapper, final T t) {
        if (dataCallWrapper.getHttpStatus() != null && (t != null || dataCallWrapper.getHttpStatus().value() <= HttpStatus.BAD_REQUEST.value())) {
            UiThreadExecutor.runTask("", BaseRestManager$$Lambda$1.lambdaFactory$(dataCallWrapper, t), 0L);
        }
    }
    
    protected void showProgress() {
        AppEventBus.showProgress();
    }
    
    public interface RestApi<T, R>
    {
        R run(@NonNull final DataCallWrapper p0, final T... p1);
    }
}
