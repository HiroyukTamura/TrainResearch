package p043jp.reifrontier.silentlogsdkandroid.data.api;

import kotlin.Metadata;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiCurrentWeather;
import p043jp.reifrontier.silentlogsdkandroid.domain.weather.RFLApiForecastWeather;
import p078g.p079a.C1714r;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001JF\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\rH'JF\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\n2\b\b\u0001\u0010\f\u001a\u00020\rH'¨\u0006\u0010"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/api/RFLApiWeather;", "", "getCurrent", "Lio/reactivex/Single;", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiCurrentWeather;", "lat", "", "lon", "appId", "", "units", "count", "", "getForecast", "Ljp/reifrontier/silentlogsdkandroid/domain/weather/RFLApiForecastWeather;", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLApiWeather */
public interface RFLApiWeather {
    @GET("weather")
    C1714r<Response<RFLApiCurrentWeather>> getCurrent(@Query("lat") double d, @Query("lon") double d2, @Query("appid") String str, @Query("units") String str2, @Query("cnt") int i);

    @GET("forecast/daily")
    C1714r<Response<RFLApiForecastWeather>> getForecast(@Query("lat") double d, @Query("lon") double d2, @Query("appid") String str, @Query("units") String str2, @Query("cnt") int i);
}
