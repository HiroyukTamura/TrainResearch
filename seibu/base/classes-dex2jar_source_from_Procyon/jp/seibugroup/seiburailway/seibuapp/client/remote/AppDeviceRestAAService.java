// 
// Decompiled by Procyon v0.5.36
// 

package jp.seibugroup.seiburailway.seibuapp.client.remote;

import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.BeaconLocationInfo;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.BeaconInfo;
import org.androidannotations.rest.spring.annotations.Post;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.AppPotUser;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.view.AppPotGetUserParam;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeThreeMessageWrapper;
import org.springframework.web.client.RestTemplate;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.NoticeMessageWrapper;
import org.androidannotations.rest.spring.annotations.Get;
import java.util.List;
import org.androidannotations.rest.spring.annotations.Delete;
import org.androidannotations.rest.spring.annotations.RequiresHeader;
import org.androidannotations.rest.spring.annotations.Put;
import org.androidannotations.rest.spring.annotations.Header;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInData;
import org.androidannotations.rest.spring.annotations.Body;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.CheckInInfo;
import org.androidannotations.rest.spring.annotations.Path;
import com.feilang.mvpproject.remote.errorhandler.AppResponseErrorHandler;
import jp.seibugroup.seiburailway.seibuapp.client.remote.interceptor.AppDeviceRestInterceptor;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.androidannotations.rest.spring.annotations.Rest;
import org.androidannotations.rest.spring.api.RestClientErrorHandling;

@Rest(converters = { FormHttpMessageConverter.class, StringHttpMessageConverter.class, GsonHttpMessageConverter.class }, interceptors = { AppDeviceRestInterceptor.class }, responseErrorHandler = AppResponseErrorHandler.class, rootUrl = "https://devices.seibuapp.jp")
public interface AppDeviceRestAAService extends RestClientErrorHandling
{
    @Header(name = "Content-Type", value = "application/json")
    @Put("/devices-api/dm/v1.0/checkins/{userId}/{checkinId}")
    @RequiresHeader({ "Accept-Language" })
    CheckInData changeCheckIn(@Path final String p0, @Path final String p1, @Body final CheckInInfo p2);
    
    @Delete("/devices-api/dm/v1.0/detected/beacons/{detectedId}?userId={userId}")
    @Header(name = "Content-Type", value = "application/json")
    @RequiresHeader({ "Accept-Language" })
    Object deleteBeacon(@Path final String p0, @Path final String p1);
    
    @Delete("/devices-api/dm/v1.0/checkins/{userId}/{checkinId}")
    @Header(name = "Content-Type", value = "application/json")
    @RequiresHeader({ "Accept-Language" })
    Object deleteCheckIn(@Path final String p0, @Path final String p1);
    
    @Get("/devices-api/dm/v1.0/checkins/{userId}")
    @RequiresHeader({ "Accept-Language" })
    List<CheckInData> getCheckIn(@Path final String p0);
    
    String getCookie(final String p0);
    
    @Get("/devices-api/dm/v1.0/notices/emerg?userId={userId}")
    @RequiresHeader({ "Accept-Language" })
    NoticeMessageWrapper getEmerg(@Path final String p0);
    
    @Get("/devices-api/dm/v1.0/notices/events?userId={userId}")
    @RequiresHeader({ "Accept-Language" })
    NoticeMessageWrapper getEventMessage(@Path final String p0);
    
    String getHeader(final String p0);
    
    @Get("/devices-api/dm/v1.0/notices/headlines?userId={userId}")
    @RequiresHeader({ "Accept-Language" })
    NoticeMessageWrapper getHeadlines(@Path final String p0);
    
    @Get("/devices-api/dm/v1.0/notices/home?userId={userId}")
    @RequiresHeader({ "Accept-Language" })
    NoticeMessageWrapper getNoticeMessage(@Path final String p0);
    
    RestTemplate getRestTemplate();
    
    String getRootUrl();
    
    @Get("/devices-api/dm/v1.0/checkins/{userId}?cid={cid}")
    @RequiresHeader({ "Accept-Language" })
    List<CheckInData> getSharedCheckIn(@Path final String p0, @Path final String p1);
    
    @Get("/devices-api/dm/v1.0/notices?userId={userId}")
    @RequiresHeader({ "Accept-Language" })
    NoticeThreeMessageWrapper getThreeNoticeMessage(@Path final String p0);
    
    @Header(name = "Content-Type", value = "application/json")
    @Post("https://train.seibuapp.jp/apppot-api/dm/v1.0/users/apppot")
    @RequiresHeader({ "Accept-Language" })
    AppPotUser getUserFromAppPot(@Body final AppPotGetUserParam p0);
    
    @Get("/devices-api/dm/v1.0/notices/wallpapers?userId={userId}")
    @RequiresHeader({ "Accept-Language" })
    NoticeMessageWrapper getWallpapers(@Path final String p0);
    
    @Header(name = "Content-Type", value = "application/json")
    @Post("/devices-api/dm/v1.0/detected/beacons")
    @RequiresHeader({ "Accept-Language" })
    BeaconLocationInfo postBeacon(@Body final BeaconInfo p0);
    
    @Header(name = "Content-Type", value = "application/json")
    @Post("/devices-api/dm/v1.0/checkins/{userId}")
    @RequiresHeader({ "Accept-Language" })
    List<CheckInData> requestCheckIn(@Path final String p0, @Body final List<CheckInInfo> p1);
    
    void setCookie(final String p0, final String p1);
    
    void setHeader(final String p0, final String p1);
    
    void setRestTemplate(final RestTemplate p0);
    
    void setRootUrl(final String p0);
}
