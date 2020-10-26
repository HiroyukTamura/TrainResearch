// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.remote;

import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.BeaconLocationInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.BeaconInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.AppPotUser;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.AppPotGetUserParam;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeThreeMessageWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeMessageWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.remote.java.util.List_CheckInData;
import org.springframework.core.NestedRuntimeException;
import java.util.Map;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInData;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInInfo;
import org.springframework.web.client.ResponseErrorHandler;
import com.feilang.mvpproject.remote.errorhandler.AppResponseErrorHandler_;
import jp.seibugroup.seiburailway.seibuapp.client.remote.interceptor.AppDeviceRestInterceptor;
import java.util.List;
import java.util.ArrayList;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import android.content.Context;
import org.springframework.web.client.RestTemplate;
import org.androidannotations.rest.spring.api.RestErrorHandler;
import java.util.HashMap;

public final class AppDeviceRestAAService_ implements AppDeviceRestAAService
{
    private HashMap<String, String> availableCookies;
    private HashMap<String, String> availableHeaders;
    private RestErrorHandler restErrorHandler;
    private RestTemplate restTemplate;
    private String rootUrl;
    
    public AppDeviceRestAAService_(final Context context) {
        this.restTemplate = new RestTemplate();
        this.availableCookies = new HashMap<String, String>();
        this.availableHeaders = new HashMap<String, String>();
        this.rootUrl = "https://devices.seibuapp.jp";
        this.restTemplate.getMessageConverters().clear();
        this.restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        this.restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        this.restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        this.restTemplate.setInterceptors((List)new ArrayList());
        this.restTemplate.getInterceptors().add(new AppDeviceRestInterceptor());
        this.restTemplate.setErrorHandler((ResponseErrorHandler)AppResponseErrorHandler_.getInstance_(context));
    }
    
    @Override
    public CheckInData changeCheckIn(final String value, final String value2, final CheckInInfo checkInInfo) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((Object)checkInInfo, (MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("checkinId", value2);
            hashMap.put("userId", value);
            return (CheckInData)this.restTemplate.exchange(this.rootUrl.concat("/devices-api/dm/v1.0/checkins/{userId}/{checkinId}"), HttpMethod.PUT, httpEntity, (Class)CheckInData.class, (Map)hashMap).getBody();
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
    public Object deleteBeacon(final String value, final String value2) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("detectedId", value);
            hashMap.put("userId", value2);
            return this.restTemplate.exchange(this.rootUrl.concat("/devices-api/dm/v1.0/detected/beacons/{detectedId}?userId={userId}"), HttpMethod.DELETE, httpEntity, (Class)Object.class, (Map)hashMap).getBody();
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
    public Object deleteCheckIn(final String value, final String value2) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("checkinId", value2);
            hashMap.put("userId", value);
            return this.restTemplate.exchange(this.rootUrl.concat("/devices-api/dm/v1.0/checkins/{userId}/{checkinId}"), HttpMethod.DELETE, httpEntity, (Class)Object.class, (Map)hashMap).getBody();
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
    public List<CheckInData> getCheckIn(final String value) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("userId", value);
            return (List<CheckInData>)this.restTemplate.exchange(this.rootUrl.concat("/devices-api/dm/v1.0/checkins/{userId}"), HttpMethod.GET, httpEntity, (Class)List_CheckInData.class, (Map)hashMap).getBody();
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
    public String getCookie(final String key) {
        return this.availableCookies.get(key);
    }
    
    @Override
    public NoticeMessageWrapper getEmerg(final String value) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("userId", value);
            return (NoticeMessageWrapper)this.restTemplate.exchange(this.rootUrl.concat("/devices-api/dm/v1.0/notices/emerg?userId={userId}"), HttpMethod.GET, httpEntity, (Class)NoticeMessageWrapper.class, (Map)hashMap).getBody();
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
    public NoticeMessageWrapper getEventMessage(final String value) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("userId", value);
            return (NoticeMessageWrapper)this.restTemplate.exchange(this.rootUrl.concat("/devices-api/dm/v1.0/notices/events?userId={userId}"), HttpMethod.GET, httpEntity, (Class)NoticeMessageWrapper.class, (Map)hashMap).getBody();
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
    public String getHeader(final String key) {
        return this.availableHeaders.get(key);
    }
    
    @Override
    public NoticeMessageWrapper getHeadlines(final String value) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("userId", value);
            return (NoticeMessageWrapper)this.restTemplate.exchange(this.rootUrl.concat("/devices-api/dm/v1.0/notices/headlines?userId={userId}"), HttpMethod.GET, httpEntity, (Class)NoticeMessageWrapper.class, (Map)hashMap).getBody();
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
    public NoticeMessageWrapper getNoticeMessage(final String value) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("userId", value);
            return (NoticeMessageWrapper)this.restTemplate.exchange(this.rootUrl.concat("/devices-api/dm/v1.0/notices/home?userId={userId}"), HttpMethod.GET, httpEntity, (Class)NoticeMessageWrapper.class, (Map)hashMap).getBody();
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
    public List<CheckInData> getSharedCheckIn(final String value, final String value2) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("userId", value);
            hashMap.put("cid", value2);
            return (List<CheckInData>)this.restTemplate.exchange(this.rootUrl.concat("/devices-api/dm/v1.0/checkins/{userId}?cid={cid}"), HttpMethod.GET, httpEntity, (Class)List_CheckInData.class, (Map)hashMap).getBody();
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
    public NoticeThreeMessageWrapper getThreeNoticeMessage(final String value) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("userId", value);
            return (NoticeThreeMessageWrapper)this.restTemplate.exchange(this.rootUrl.concat("/devices-api/dm/v1.0/notices?userId={userId}"), HttpMethod.GET, httpEntity, (Class)NoticeThreeMessageWrapper.class, (Map)hashMap).getBody();
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
    public AppPotUser getUserFromAppPot(final AppPotGetUserParam appPotGetUserParam) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            return (AppPotUser)this.restTemplate.exchange("https://train.seibuapp.jp/apppot-api/dm/v1.0/users/apppot", HttpMethod.POST, new HttpEntity((Object)appPotGetUserParam, (MultiValueMap)httpHeaders), (Class)AppPotUser.class, new Object[0]).getBody();
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
    public NoticeMessageWrapper getWallpapers(final String value) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("userId", value);
            return (NoticeMessageWrapper)this.restTemplate.exchange(this.rootUrl.concat("/devices-api/dm/v1.0/notices/wallpapers?userId={userId}"), HttpMethod.GET, httpEntity, (Class)NoticeMessageWrapper.class, (Map)hashMap).getBody();
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
    public BeaconLocationInfo postBeacon(final BeaconInfo beaconInfo) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            return (BeaconLocationInfo)this.restTemplate.exchange(this.rootUrl.concat("/devices-api/dm/v1.0/detected/beacons"), HttpMethod.POST, new HttpEntity((Object)beaconInfo, (MultiValueMap)httpHeaders), (Class)BeaconLocationInfo.class, new Object[0]).getBody();
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
    public List<CheckInData> requestCheckIn(final String value, final List<CheckInInfo> list) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.set("Content-Type", "application/json");
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((Object)list, (MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("userId", value);
            return (List<CheckInData>)this.restTemplate.exchange(this.rootUrl.concat("/devices-api/dm/v1.0/checkins/{userId}"), HttpMethod.POST, httpEntity, (Class)List_CheckInData.class, (Map)hashMap).getBody();
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
