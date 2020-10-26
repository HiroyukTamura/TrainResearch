// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.remote;

import org.springframework.web.client.RestTemplate;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.master.BaseData;
import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Accept;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.Maintenance;
import com.feilang.mvpproject.remote.errorhandler.AppResponseErrorHandler;
import com.feilang.mvpproject.remote.interceptor.AppRestInterceptor;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.androidannotations.rest.spring.annotations.Rest;
import org.androidannotations.rest.spring.api.RestClientErrorHandling;

@Rest(converters = { FormHttpMessageConverter.class, StringHttpMessageConverter.class, GsonHttpMessageConverter.class }, interceptors = { AppRestInterceptor.class }, responseErrorHandler = AppResponseErrorHandler.class, rootUrl = "https://s3.seibuapp.jp/mobile/app")
public interface AppMasterAAService extends RestClientErrorHandling
{
    String getCookie(final String p0);
    
    String getHeader(final String p0);
    
    @Accept("application/json")
    @Get("/json/seibuappMaintenance002.json")
    Maintenance getMaintenance();
    
    @Accept("application/json")
    @Get("/json/seibuappInitialMaster004.json")
    BaseData getMasterData();
    
    RestTemplate getRestTemplate();
    
    String getRootUrl();
    
    void setCookie(final String p0, final String p1);
    
    void setHeader(final String p0, final String p1);
    
    void setRestTemplate(final RestTemplate p0);
    
    void setRootUrl(final String p0);
}
