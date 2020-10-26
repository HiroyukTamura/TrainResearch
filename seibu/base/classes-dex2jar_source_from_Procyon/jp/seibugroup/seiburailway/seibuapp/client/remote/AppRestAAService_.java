// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.remote;

import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.TrainList;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.ResultTimeTableTrainWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.ResultTimeTableListStationWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.xml.ResultStationLine;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.DepartureWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.RunStatusHistoryWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.RunStatusDataWrapper;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.OnlineTrains;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationInfoList;
import java.util.Map;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.DestinationsInfo;
import org.springframework.core.NestedRuntimeException;
import jp.seibugroup.seiburailway.seibuapp.client.remote.java.util.List_BaseballModel;
import org.springframework.util.MultiValueMap;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import java.util.Collections;
import org.springframework.http.MediaType;
import org.springframework.http.HttpHeaders;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.BaseballModel;
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

public final class AppRestAAService_ implements AppRestAAService
{
    private HashMap<String, String> availableCookies;
    private HashMap<String, String> availableHeaders;
    private RestErrorHandler restErrorHandler;
    private RestTemplate restTemplate;
    private String rootUrl;
    
    public AppRestAAService_(final Context context) {
        this.restTemplate = new RestTemplate();
        this.availableCookies = new HashMap<String, String>();
        this.availableHeaders = new HashMap<String, String>();
        this.rootUrl = "https://train.seibuapp.jp/trainfo-api/ti/v1.0";
        this.restTemplate.getMessageConverters().clear();
        this.restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        this.restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
        this.restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
        this.restTemplate.setInterceptors((List)new ArrayList());
        this.restTemplate.getInterceptors().add(new AppRestInterceptor());
        this.restTemplate.setErrorHandler((ResponseErrorHandler)AppResponseErrorHandler_.getInstance_(context));
    }
    
    @Override
    public List<BaseballModel> getBaseballGames() {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept((List)Collections.singletonList(MediaType.parseMediaType("application/json")));
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            return (List<BaseballModel>)this.restTemplate.exchange(this.rootUrl.concat("/groups/baseball/games/today"), HttpMethod.GET, new HttpEntity((MultiValueMap)httpHeaders), (Class)List_BaseballModel.class, new Object[0]).getBody();
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
    public DestinationsInfo getDestinationsInfo(final String value, final String value2, final String value3) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept((List)Collections.singletonList(MediaType.parseMediaType("application/json")));
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("lineId", value2);
            hashMap.put("trainNo", value3);
            hashMap.put("stationId", value);
            return (DestinationsInfo)this.restTemplate.exchange(this.rootUrl.concat("/destinations?lineId={lineId}&trainNo={trainNo}&stationId={stationId}"), HttpMethod.GET, httpEntity, (Class)DestinationsInfo.class, (Map)hashMap).getBody();
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
    public StationInfoList getNearbyStationsApi(final String value, final String value2) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept((List)Collections.singletonList(MediaType.parseMediaType("application/json")));
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("latitude", value);
            hashMap.put("longitude", value2);
            return (StationInfoList)this.restTemplate.exchange(this.rootUrl.concat("/stations?lat={latitude}&long={longitude}"), HttpMethod.GET, httpEntity, (Class)StationInfoList.class, (Map)hashMap).getBody();
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
    public OnlineTrains getOnlineTrains(final String value) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept((List)Collections.singletonList(MediaType.parseMediaType("application/json")));
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("lineId", value);
            return (OnlineTrains)this.restTemplate.exchange(this.rootUrl.concat("/trains?lineId={lineId}"), HttpMethod.GET, httpEntity, (Class)OnlineTrains.class, (Map)hashMap).getBody();
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
    public OnlineTrains getOnlineTrains(final String value, final String value2, final String value3) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept((List)Collections.singletonList(MediaType.parseMediaType("application/json")));
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("lineId", value);
            hashMap.put("trainNo", value3);
            hashMap.put("detail", value2);
            return (OnlineTrains)this.restTemplate.exchange(this.rootUrl.concat("/trains?lineId={lineId}&detail={detail}&trainNo={trainNo}"), HttpMethod.GET, httpEntity, (Class)OnlineTrains.class, (Map)hashMap).getBody();
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
    public RunStatusDataWrapper getRunStatus(final String value) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept((List)Collections.singletonList(MediaType.parseMediaType("application/json")));
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("specific", value);
            return (RunStatusDataWrapper)this.restTemplate.exchange(this.rootUrl.concat("/lines/all/status?specific={specific}"), HttpMethod.GET, httpEntity, (Class)RunStatusDataWrapper.class, (Map)hashMap).getBody();
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
    public RunStatusHistoryWrapper getRunStatusHistory(final String value, final String value2, final String value3) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept((List)Collections.singletonList(MediaType.parseMediaType("application/json")));
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("dt", value);
            hashMap.put("offset", value2);
            hashMap.put("limit", value3);
            return (RunStatusHistoryWrapper)this.restTemplate.exchange(this.rootUrl.concat("/lines/all/status/text?dt={dt}&offset={offset}&limit={limit}"), HttpMethod.GET, httpEntity, (Class)RunStatusHistoryWrapper.class, (Map)hashMap).getBody();
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
    public DepartureWrapper getStationDepartures(final String value) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept((List)Collections.singletonList(MediaType.parseMediaType("application/json")));
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("stationId", value);
            return (DepartureWrapper)this.restTemplate.exchange(this.rootUrl.concat("/stations/all/departures?stationId={stationId}"), HttpMethod.GET, httpEntity, (Class)DepartureWrapper.class, (Map)hashMap).getBody();
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
    public StationInfoList getStationInfo(final String value) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept((List)Collections.singletonList(MediaType.parseMediaType("application/json")));
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("stationId", value);
            return (StationInfoList)this.restTemplate.exchange(this.rootUrl.concat("/stations/all?stationId={stationId}"), HttpMethod.GET, httpEntity, (Class)StationInfoList.class, (Map)hashMap).getBody();
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
    public ResultStationLine getStationTimeTableInfo(final String value) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept((List)Collections.singletonList(MediaType.parseMediaType("application/json")));
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("stationId", value);
            return (ResultStationLine)this.restTemplate.exchange(this.rootUrl.concat("/timetables/{stationId}"), HttpMethod.GET, httpEntity, (Class)ResultStationLine.class, (Map)hashMap).getBody();
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
    public ResultTimeTableListStationWrapper getTimeTableList(final String value, final String value2, final String value3) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept((List)Collections.singletonList(MediaType.parseMediaType("application/xml")));
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("lineId", value3);
            hashMap.put("directionCode", value2);
            hashMap.put("lineStationId", value);
            return (ResultTimeTableListStationWrapper)this.restTemplate.exchange(this.rootUrl.concat("/timetables/{lineStationId}/{directionCode}?lineId={lineId}"), HttpMethod.GET, httpEntity, (Class)ResultTimeTableListStationWrapper.class, (Map)hashMap).getBody();
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
    public ResultTimeTableTrainWrapper getTrainTimeTable(final String value, final String value2, final String value3, final String value4, final String value5) {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept((List)Collections.singletonList(MediaType.parseMediaType("application/xml")));
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            final HttpEntity httpEntity = new HttpEntity((MultiValueMap)httpHeaders);
            final HashMap<String, String> hashMap = new HashMap<String, String>();
            hashMap.put("dayType", value3);
            hashMap.put("date", value5);
            hashMap.put("trainKey", value);
            hashMap.put("startTime", value4);
            hashMap.put("stationId", value2);
            return (ResultTimeTableTrainWrapper)this.restTemplate.exchange(this.rootUrl.concat("/traintimetables/{trainKey}?stationId={stationId}&departureTime={startTime}&weekPatternCode={dayType}&date={date}"), HttpMethod.GET, httpEntity, (Class)ResultTimeTableTrainWrapper.class, (Map)hashMap).getBody();
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
    public TrainList getTrainWrappingData() {
        try {
            final HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setAccept((List)Collections.singletonList(MediaType.parseMediaType("application/json")));
            httpHeaders.set("Accept-Language", (String)this.availableHeaders.get("Accept-Language"));
            return (TrainList)this.restTemplate.exchange(this.rootUrl.concat("/cars"), HttpMethod.GET, new HttpEntity((MultiValueMap)httpHeaders), (Class)TrainList.class, new Object[0]).getBody();
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
