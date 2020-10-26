// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.remote;

import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseData;
import org.springframework.core.NestedRuntimeException;
import org.springframework.util.MultiValueMap;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import java.util.Collections;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.Maintenance;
import org.springframework.web.client.ResponseErrorHandler;
import com.feilang.mvpproject.remote.errorhandler.AppResponseErrorHandler_;
import com.feilang.mvpproject.remote.interceptor.AppRestInterceptor;
import java.util.List;
import java.util.ArrayList;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import android.content.Context;
import org.springframework.web.client.RestTemplate;
import org.androidannotations.rest.spring.api.RestErrorHandler;
import java.util.HashMap;

public final class AppMasterAAService_ implements AppMasterAAService
{
    private HashMap<String, String> availableCookies;
    private HashMap<String, String> availableHeaders;
    private RestErrorHandler restErrorHandler;
    private RestTemplate restTemplate;
    private String rootUrl;
    
    public AppMasterAAService_(final Context context) {
        this.restTemplate = new RestTemplate();
        this.availableCookies = new HashMap<String, String>();
        this.availableHeaders = new HashMap<String, String>();
        this.rootUrl = "https://s3.seibuapp.jp/mobile/app";
        this.restTemplate.getMessageConverters().clear();
        this.restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        this.restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        this.restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        this.restTemplate.setInterceptors((List)new ArrayList());
        this.restTemplate.getInterceptors().add(new AppRestInterceptor());
        this.restTemplate.setErrorHandler((ResponseErrorHandler)AppResponseErrorHandler_.getInstance_(context));
    }
    
    @Override
    public String getCookie(final String key) {
        return this.availableCookies.get(key);
    }
    
    @Override
    public String getHeader(final String key) {
        return this.availableHeaders.get(key);
    }
    
    @Override
    public Maintenance getMaintenance() {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept((List)Collections.singletonList(MediaType.parseMediaType("application/json")));
            return (Maintenance)this.restTemplate.exchange(this.rootUrl.concat("/json/seibuappMaintenance002.json"), HttpMethod.GET, new HttpEntity((MultiValueMap)httpHeaders), (Class)Maintenance.class, new Object[0]).getBody();
        }
        catch (NestedRuntimeException ex) {
            if (this.restErrorHandler != null) {
                this.restErrorHandler.onRestClientExceptionThrown(ex);
                return null;
            }
            throw ex;
        }
    }
    
    @Override
    public BaseData getMasterData() {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept((List)Collections.singletonList(MediaType.parseMediaType("application/json")));
            return (BaseData)this.restTemplate.exchange(this.rootUrl.concat("/json/seibuappInitialMaster004.json"), HttpMethod.GET, new HttpEntity((MultiValueMap)httpHeaders), (Class)BaseData.class, new Object[0]).getBody();
        }
        catch (NestedRuntimeException ex) {
            if (this.restErrorHandler != null) {
                this.restErrorHandler.onRestClientExceptionThrown(ex);
                return null;
            }
            throw ex;
        }
    }
    
    @Override
    public RestTemplate getRestTemplate() {
        return this.restTemplate;
    }
    
    @Override
    public String getRootUrl() {
        return this.rootUrl;
    }
    
    @Override
    public void setCookie(final String key, final String value) {
        this.availableCookies.put(key, value);
    }
    
    @Override
    public void setHeader(final String key, final String value) {
        this.availableHeaders.put(key, value);
    }
    
    public void setRestErrorHandler(final RestErrorHandler restErrorHandler) {
        this.restErrorHandler = restErrorHandler;
    }
    
    @Override
    public void setRestTemplate(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    @Override
    public void setRootUrl(final String rootUrl) {
        this.rootUrl = rootUrl;
    }
}
