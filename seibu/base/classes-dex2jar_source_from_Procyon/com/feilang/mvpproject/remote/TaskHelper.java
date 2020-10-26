// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.remote;

import org.springframework.web.client.RestClientException;
import org.springframework.http.HttpRequest;
import java.io.IOException;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.http.HttpMethod;
import java.net.URI;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;
import com.feilang.mvpproject.util.LogUtils;
import android.text.TextUtils;
import java.util.Iterator;
import com.feilang.mvpproject.data.datasource.DataCallWrapper;
import android.support.annotation.NonNull;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskHelper
{
    private static ConcurrentHashMap<String, TaskHelper> mExcludeCounter;
    private static ConcurrentHashMap<String, TaskHelper> mNormalCounter;
    private Map<String, Long> mApiSet;
    private boolean mExcludeFlag;
    private Restable mRest;
    
    static {
        TaskHelper.mExcludeCounter = new ConcurrentHashMap<String, TaskHelper>();
        TaskHelper.mNormalCounter = new ConcurrentHashMap<String, TaskHelper>();
    }
    
    private TaskHelper(final boolean mExcludeFlag) {
        this.mApiSet = (Map<String, Long>)Maps.newConcurrentMap();
        this.mExcludeFlag = mExcludeFlag;
    }
    
    public static TaskHelper exclude() {
        return exclude("_default");
    }
    
    public static TaskHelper exclude(@NonNull final String s) {
        Label_0042: {
            if (TaskHelper.mExcludeCounter.containsKey(s)) {
                break Label_0042;
            }
            synchronized (TaskHelper.class) {
                if (!TaskHelper.mExcludeCounter.containsKey(s)) {
                    TaskHelper.mExcludeCounter.put(s, new TaskHelper(true));
                }
                // monitorexit(TaskHelper.class)
                return TaskHelper.mExcludeCounter.get(s);
            }
        }
    }
    
    public static DataCallWrapper excludeCallback() {
        DataCallWrapper dataCallWrapper = null;
        final Iterator<TaskHelper> iterator = TaskHelper.mExcludeCounter.values().iterator();
        while (iterator.hasNext()) {
            final DataCallWrapper callback = iterator.next().callback();
            if ((dataCallWrapper = callback) != null) {
                dataCallWrapper = callback;
                break;
            }
        }
        return dataCallWrapper;
    }
    
    private boolean isExist(final DataCallWrapper dataCallWrapper) {
        if (!this.mExcludeFlag) {
            return false;
        }
        final String name = dataCallWrapper.identifier.name();
        final long serialIdentifier = dataCallWrapper.serialIdentifier;
        if (!TextUtils.isEmpty((CharSequence)name)) {
            if (this.mApiSet.containsKey(name)) {
                if (serialIdentifier != 0L && serialIdentifier == this.mApiSet.get(name)) {
                    return false;
                }
                LogUtils.outputLog(5, "Task " + name + " existed. IGNORING ...");
                return true;
            }
            else {
                this.mApiSet.put(name, serialIdentifier);
            }
        }
        return false;
    }
    
    public static TaskHelper normal() {
        return normal("_default");
    }
    
    public static TaskHelper normal(@NonNull final String s) {
        Label_0042: {
            if (TaskHelper.mNormalCounter.containsKey(s)) {
                break Label_0042;
            }
            synchronized (TaskHelper.class) {
                if (!TaskHelper.mNormalCounter.containsKey(s)) {
                    TaskHelper.mNormalCounter.put(s, new TaskHelper(false));
                }
                // monitorexit(TaskHelper.class)
                return TaskHelper.mNormalCounter.get(s);
            }
        }
    }
    
    public static DataCallWrapper normalCallback() {
        DataCallWrapper dataCallWrapper = null;
        final Iterator<TaskHelper> iterator = TaskHelper.mNormalCounter.values().iterator();
        while (iterator.hasNext()) {
            final DataCallWrapper callback = iterator.next().callback();
            if ((dataCallWrapper = callback) != null) {
                dataCallWrapper = callback;
                break;
            }
        }
        return dataCallWrapper;
    }
    
    public DataCallWrapper callback() {
        return ((CallbackRestTemplate)this.mRest.getRestTemplate()).getCallback();
    }
    
    public void done(final DataCallWrapper dataCallWrapper) {
        this.mApiSet.remove(dataCallWrapper.identifier.name());
        ((CallbackRestTemplate)this.mRest.getRestTemplate()).removeCallback(dataCallWrapper);
        this.mRest.completeExecute(dataCallWrapper);
    }
    
    public TaskHelper rest(@NonNull final Restable mRest) {
        this.mRest = mRest;
        return this;
    }
    
    public boolean run(final DataCallWrapper currCallback) {
        if (this.isExist(currCallback)) {
            return true;
        }
        this.mRest.beforeExecuting(currCallback);
        ((CallbackRestTemplate)this.mRest.getRestTemplate()).setCurrCallback(currCallback);
        return false;
    }
    
    public interface Api<T, R>
    {
        R run(final T p0);
    }
    
    public static class CallbackRestTemplate extends RestTemplate implements RequestCallback
    {
        private ThreadLocal<ClientHttpRequest> mHttpRequest;
        private ThreadLocal<DataCallWrapper> mLocalDataCallback;
        
        public CallbackRestTemplate(final RestTemplate restTemplate) {
            this.mLocalDataCallback = new InheritableThreadLocal<DataCallWrapper>();
            this.mHttpRequest = new InheritableThreadLocal<ClientHttpRequest>();
            this.getMessageConverters().clear();
            this.getMessageConverters().addAll(restTemplate.getMessageConverters());
            this.setInterceptors((List)new ArrayList());
            this.getInterceptors().addAll(restTemplate.getInterceptors());
            this.setErrorHandler(restTemplate.getErrorHandler());
        }
        
        protected <T> T doExecute(final URI uri, final HttpMethod httpMethod, final RequestCallback requestCallback, final ResponseExtractor<T> responseExtractor) throws RestClientException {
            try {
                return (T)super.doExecute(uri, httpMethod, (RequestCallback)new RequestCallback() {
                    public void doWithRequest(final ClientHttpRequest clientHttpRequest) throws IOException {
                        if (CallbackRestTemplate.this.mLocalDataCallback.get() != null) {
                            CallbackRestTemplate.this.doWithRequest(clientHttpRequest);
                        }
                        if (requestCallback != null) {
                            requestCallback.doWithRequest(clientHttpRequest);
                        }
                    }
                }, (ResponseExtractor)responseExtractor);
            }
            catch (RestClientException ex) {
                throw new URLRestClientException(ex.getMessage(), ex.getCause(), (HttpRequest)this.mHttpRequest.get());
            }
        }
        
        public void doWithRequest(final ClientHttpRequest value) throws IOException {
            this.mHttpRequest.set(value);
        }
        
        public DataCallWrapper getCallback() {
            if (this.mLocalDataCallback.get() == null) {
                return null;
            }
            return this.mLocalDataCallback.get();
        }
        
        public void removeCallback(final DataCallWrapper dataCallWrapper) {
            if (this.mLocalDataCallback != null) {
                this.mLocalDataCallback.remove();
            }
        }
        
        public void setCurrCallback(final DataCallWrapper value) {
            this.mLocalDataCallback.set(value);
        }
        
        public class URLRestClientException extends RestClientException
        {
            private HttpRequest mRequest;
            
            public URLRestClientException(final String s, final Throwable t, final HttpRequest mRequest) {
                super(s, t);
                this.mRequest = mRequest;
            }
            
            public HttpRequest getRequest() {
                return this.mRequest;
            }
        }
    }
    
    public interface NoParamApi<T, R>
    {
        R run();
    }
    
    public interface ParamApi2<T, R>
    {
        R run(final T p0, final T p1);
    }
    
    public interface ParamApi3<T, R>
    {
        R run(final T p0, final T p1, final T p2);
    }
    
    public interface ParamApi4<T, R>
    {
        R run(final T p0, final T p1, final T p2, final T p3);
    }
    
    public interface ParamApi5<T, R>
    {
        R run(final T p0, final T p1, final T p2, final T p3, final T p4);
    }
    
    public interface ParamApi6<T, R>
    {
        R run(final T p0, final T p1, final T p2, final T p3, final T p4, final T p5);
    }
}
