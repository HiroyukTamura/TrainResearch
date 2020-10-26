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
import org.springframework.web.client.RestTemplate;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.OnlineTrains;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.StationInfoList;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.DestinationsInfo;
import org.androidannotations.rest.spring.annotations.Path;
import org.androidannotations.rest.spring.annotations.RequiresHeader;
import org.androidannotations.rest.spring.annotations.Get;
import org.androidannotations.rest.spring.annotations.Accept;
import jp.seibugroup.seiburailway.seibuapp.client.data.models.json.BaseballModel;
import java.util.List;
import com.feilang.mvpproject.remote.errorhandler.AppResponseErrorHandler;
import com.feilang.mvpproject.remote.interceptor.AppRestInterceptor;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.androidannotations.rest.spring.annotations.Rest;
import org.androidannotations.rest.spring.api.RestClientErrorHandling;

@Rest(converters = { FormHttpMessageConverter.class, StringHttpMessageConverter.class, GsonHttpMessageConverter.class }, interceptors = { AppRestInterceptor.class }, responseErrorHandler = AppResponseErrorHandler.class, rootUrl = "https://train.seibuapp.jp/trainfo-api/ti/v1.0")
public interface AppRestAAService extends RestClientErrorHandling
{
    @Accept("application/json")
    @Get("/groups/baseball/games/today")
    @RequiresHeader({ "Accept-Language" })
    List<BaseballModel> getBaseballGames();
    
    String getCookie(final String p0);
    
    @Accept("application/json")
    @Get("/destinations?lineId={lineId}&trainNo={trainNo}&stationId={stationId}")
    @RequiresHeader({ "Accept-Language" })
    DestinationsInfo getDestinationsInfo(@Path final String p0, @Path final String p1, @Path final String p2);
    
    String getHeader(final String p0);
    
    @Accept("application/json")
    @Get("/stations?lat={latitude}&long={longitude}")
    @RequiresHeader({ "Accept-Language" })
    StationInfoList getNearbyStationsApi(@Path final String p0, @Path final String p1);
    
    @Accept("application/json")
    @Get("/trains?lineId={lineId}")
    @RequiresHeader({ "Accept-Language" })
    OnlineTrains getOnlineTrains(@Path final String p0);
    
    @Accept("application/json")
    @Get("/trains?lineId={lineId}&detail={detail}&trainNo={trainNo}")
    @RequiresHeader({ "Accept-Language" })
    OnlineTrains getOnlineTrains(@Path final String p0, @Path final String p1, @Path final String p2);
    
    RestTemplate getRestTemplate();
    
    String getRootUrl();
    
    @Accept("application/json")
    @Get("/lines/all/status?specific={specific}")
    @RequiresHeader({ "Accept-Language" })
    RunStatusDataWrapper getRunStatus(@Path final String p0);
    
    @Accept("application/json")
    @Get("/lines/all/status/text?dt={dt}&offset={offset}&limit={limit}")
    @RequiresHeader({ "Accept-Language" })
    RunStatusHistoryWrapper getRunStatusHistory(@Path final String p0, @Path final String p1, @Path final String p2);
    
    @Accept("application/json")
    @Get("/stations/all/departures?stationId={stationId}")
    @RequiresHeader({ "Accept-Language" })
    DepartureWrapper getStationDepartures(@Path final String p0);
    
    @Accept("application/json")
    @Get("/stations/all?stationId={stationId}")
    @RequiresHeader({ "Accept-Language" })
    StationInfoList getStationInfo(@Path final String p0);
    
    @Accept("application/json")
    @Get("/timetables/{stationId}")
    @RequiresHeader({ "Accept-Language" })
    ResultStationLine getStationTimeTableInfo(@Path final String p0);
    
    @Accept("application/xml")
    @Get("/timetables/{lineStationId}/{directionCode}?lineId={lineId}")
    @RequiresHeader({ "Accept-Language" })
    ResultTimeTableListStationWrapper getTimeTableList(@Path final String p0, @Path final String p1, @Path final String p2);
    
    @Accept("application/xml")
    @Get("/traintimetables/{trainKey}?stationId={stationId}&departureTime={startTime}&weekPatternCode={dayType}&date={date}")
    @RequiresHeader({ "Accept-Language" })
    ResultTimeTableTrainWrapper getTrainTimeTable(@Path final String p0, @Path final String p1, @Path final String p2, @Path final String p3, @Path final String p4);
    
    @Accept("application/json")
    @Get("/cars")
    @RequiresHeader({ "Accept-Language" })
    TrainList getTrainWrappingData();
    
    void setCookie(final String p0, final String p1);
    
    void setHeader(final String p0, final String p1);
    
    void setRestTemplate(final RestTemplate p0);
    
    void setRootUrl(final String p0);
}
