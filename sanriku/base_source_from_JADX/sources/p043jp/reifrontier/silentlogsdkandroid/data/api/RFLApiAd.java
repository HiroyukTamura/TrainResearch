package p043jp.reifrontier.silentlogsdkandroid.data.api;

import java.util.List;
import kotlin.Metadata;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdCampaign;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdResult;
import p043jp.reifrontier.silentlogsdkandroid.domain.p120ad.RFLAdTrigger;
import p078g.p079a.C1714r;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J8\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\fH'J<\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\fH'JF\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0013\u001a\u00020\u00112\b\b\u0001\u0010\u0014\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\fH'J<\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u0016\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\r\u001a\u00020\fH'¨\u0006\u0017"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/api/RFLApiAd;", "", "getCampaign", "Lio/reactivex/Single;", "Lretrofit2/Response;", "", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdCampaign;", "accessToken", "", "getTrigger", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdTrigger;", "lat", "", "lon", "postCover", "Ljp/reifrontier/silentlogsdkandroid/domain/ad/RFLAdResult;", "coverId", "", "postResponse", "campId", "resType", "postTracking", "trackingType", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLApiAd */
public interface RFLApiAd {
    @GET("ad/campaign")
    C1714r<Response<List<RFLAdCampaign>>> getCampaign(@Query("access_token") String str);

    @GET("ad/trigger")
    C1714r<Response<List<RFLAdTrigger>>> getTrigger(@Query("access_token") String str, @Query("lat") double d, @Query("lon") double d2);

    @FormUrlEncoded
    @POST("ad/cover")
    C1714r<Response<RFLAdResult>> postCover(@Field("access_token") String str, @Field("cover_id") int i, @Field("lat") double d, @Field("lon") double d2);

    @FormUrlEncoded
    @POST("ad/response")
    C1714r<Response<RFLAdResult>> postResponse(@Field("access_token") String str, @Field("camp_id") int i, @Field("res_type") String str2, @Field("lat") double d, @Field("lon") double d2);

    @FormUrlEncoded
    @POST("ad/tracking")
    C1714r<Response<RFLAdResult>> postTracking(@Field("access_token") String str, @Field("tracking_type") String str2, @Field("lat") double d, @Field("lon") double d2);
}
