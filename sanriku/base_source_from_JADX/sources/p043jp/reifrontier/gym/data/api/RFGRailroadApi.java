package p043jp.reifrontier.gym.data.api;

import java.util.List;
import kotlin.Metadata;
import p043jp.reifrontier.gym.data.train.RFGStation;
import p043jp.reifrontier.gym.data.train.RFGTrain;
import p043jp.reifrontier.gym.domain.api.train.RFGApiAuthRequest;
import p043jp.reifrontier.gym.domain.api.train.RFGApiAuthResponse;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContent;
import p043jp.reifrontier.gym.domain.api.train.RFGApiOperation;
import p043jp.reifrontier.gym.domain.api.train.RFGApiRealtime;
import p043jp.reifrontier.gym.domain.api.train.RFGApiSpot;
import p078g.p079a.C1714r;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u001a\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00040\u0003H'J\u001a\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\u00040\u0003H'J\u001e\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00040\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u0010H'J[\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\t0\u00040\u00032\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u00102\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u00102\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u00102\n\b\u0001\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0017H'¢\u0006\u0002\u0010\u0019J\u001a\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\t0\u00040\u0003H'J\u001a\u0010\u001c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\t0\u00040\u0003H'¨\u0006\u001e"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGRailroadApi;", "", "auth", "Lio/reactivex/Single;", "Lretrofit2/Response;", "Ljp/reifrontier/gym/domain/api/train/RFGApiAuthResponse;", "body", "Ljp/reifrontier/gym/domain/api/train/RFGApiAuthRequest;", "getOperation", "", "Ljp/reifrontier/gym/domain/api/train/RFGApiOperation;", "getRealtime", "Ljp/reifrontier/gym/domain/api/train/RFGApiRealtime;", "getSpotDetail", "Ljp/reifrontier/gym/domain/api/train/RFGApiContent;", "spotId", "", "getSpotList", "Ljp/reifrontier/gym/domain/api/train/RFGApiSpot;", "page", "limit", "stationId", "lat", "", "lon", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Double;Ljava/lang/Double;)Lio/reactivex/Single;", "getStations", "Ljp/reifrontier/gym/data/train/RFGStation;", "getTrains", "Ljp/reifrontier/gym/data/train/RFGTrain;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGRailroadApi */
public interface RFGRailroadApi {
    @POST("auth")
    C1714r<Response<RFGApiAuthResponse>> auth(@Body RFGApiAuthRequest rFGApiAuthRequest);

    @GET("operation")
    C1714r<Response<List<RFGApiOperation>>> getOperation();

    @GET("realtime")
    C1714r<Response<List<RFGApiRealtime>>> getRealtime();

    @GET("spot/{spot_id}")
    C1714r<Response<RFGApiContent>> getSpotDetail(@Path("spot_id") int i);

    @GET("spots")
    C1714r<Response<List<RFGApiSpot>>> getSpotList(@Query("page") Integer num, @Query("limit") Integer num2, @Query("station_id") Integer num3, @Query("lat") Double d, @Query("lon") Double d2);

    @GET("stations")
    C1714r<Response<List<RFGStation>>> getStations();

    @GET("trains")
    C1714r<Response<List<RFGTrain>>> getTrains();
}
