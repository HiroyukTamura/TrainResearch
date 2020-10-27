package p043jp.reifrontier.gym.data.api;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import p040i.C0976G;
import p040i.C0980J;
import p040i.C1748C;
import p043jp.reifrontier.gym.domain.api.RFGChallenge;
import p043jp.reifrontier.gym.domain.api.RFGClub;
import p043jp.reifrontier.gym.domain.api.RFGFeed;
import p043jp.reifrontier.gym.domain.api.RFGPointHistory;
import p043jp.reifrontier.gym.domain.api.RFGRankingData;
import p043jp.reifrontier.gym.domain.api.RFGResponse;
import p043jp.reifrontier.gym.domain.api.RFGReward;
import p043jp.reifrontier.gym.domain.api.RFGRewardUserList;
import p043jp.reifrontier.gym.domain.api.RFGRewardUserStatus;
import p043jp.reifrontier.gym.domain.api.RFGSummaryHistory;
import p043jp.reifrontier.gym.domain.api.RFGUpdateResult;
import p043jp.reifrontier.gym.domain.api.RFGUser;
import p043jp.reifrontier.gym.domain.api.RFGUserChallenge;
import p043jp.reifrontier.gym.domain.api.RFGUserChart;
import p043jp.reifrontier.gym.domain.api.RFGUserClub;
import p043jp.reifrontier.gym.domain.api.RFGUserCurrentYearPoint;
import p043jp.reifrontier.gym.domain.api.RFGUserData;
import p043jp.reifrontier.gym.domain.api.RFGUserPersonal;
import p043jp.reifrontier.gym.domain.api.RFGUserPoint;
import p043jp.reifrontier.gym.domain.api.RFGUserReward;
import p078g.p079a.C1714r;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J(\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\b\b\u0001\u0010\u000b\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\bH'J8\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00050\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\u000f\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\bH'JC\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\b\b\u0001\u0010\u0011\u001a\u00020\b2\b\b\u0001\u0010\u0012\u001a\u00020\u00132\u0019\b\u0001\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\t\u0012\u00070\u0016¢\u0006\u0002\b\u00170\u0015H'J(\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u001a\u001a\u00020\bH'J2\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u001a\u001a\u00020\b2\b\b\u0001\u0010\u001c\u001a\u00020\bH'JE\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\b\b\u0001\u0010\u0011\u001a\u00020\b2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0019\b\u0001\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\t\u0012\u00070\u0016¢\u0006\u0002\b\u00170\u0015H'J.\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u001a\u001a\u00020\bH'J$\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J(\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u001a\u001a\u00020\bH'J(\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\bH'J>\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0014\b\u0001\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00152\b\b\u0001\u0010\u001c\u001a\u00020\bH'J(\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010&\u001a\u00020\bH'J.\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00050\u00040\u00032\b\b\u0001\u0010)\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\bH'J(\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u000b\u001a\u00020\bH'J\u001e\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u001e\u0010-\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J8\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000\u00050\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010)\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\bH'JF\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002020\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u00103\u001a\u00020\b2\b\b\u0001\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010)\u001a\u00020\b2\b\b\u0001\u0010\u000f\u001a\u000204H'J.\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002060\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u00107\u001a\u00020\bH'J<\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u00109\u001a\u00020\b2\b\b\u0001\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010:\u001a\u00020\bH'J(\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0\u00040\u00032\b\b\u0001\u00109\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\bH'J2\u0010=\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020>0\u00040\u00032\b\b\u0001\u00109\u001a\u00020\b2\b\b\u0001\u0010\u000e\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\bH'J4\u0010?\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020@0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0014\b\u0001\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0015H'J(\u0010A\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\b\b\u0001\u0010\u0011\u001a\u00020\b2\b\b\u0001\u0010B\u001a\u00020\u0013H'J4\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0014\b\u0001\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0015H'J2\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u001a\u001a\u00020\b2\b\b\u0001\u0010\u001c\u001a\u00020\bH'J$\u0010F\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J\u001e\u0010H\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J(\u0010J\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\u001c\u001a\u00020\bH'J\u001e\u0010K\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J(\u0010M\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020D0\u00040\u00032\b\b\u0001\u0010N\u001a\u00020\b2\b\b\u0001\u0010O\u001a\u00020\bH'J\u001e\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH'J(\u0010R\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u00109\u001a\u00020\bH'¨\u0006T"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGApi;", "", "challenge", "Lio/reactivex/Single;", "Lretrofit2/Response;", "", "Ljp/reifrontier/gym/domain/api/RFGChallenge;", "accessToken", "", "challengeDetail", "Lokhttp3/ResponseBody;", "chid", "chart", "Ljp/reifrontier/gym/domain/api/RFGUserChart;", "type", "count", "clubCreate", "token", "fileParam", "Lokhttp3/MultipartBody$Part;", "params", "", "Lokhttp3/RequestBody;", "Lkotlin/jvm/JvmSuppressWildcards;", "clubDetail", "Ljp/reifrontier/gym/domain/api/RFGClub;", "clubId", "clubRefuse", "gymId", "clubUpdate", "clubUsers", "Ljp/reifrontier/gym/domain/api/RFGUserData;", "clubs", "Ljp/reifrontier/gym/domain/api/RFGUserClub;", "deleteClub", "entryChallenge", "entryClub", "exchangeReward", "rewardid", "feed", "Ljp/reifrontier/gym/domain/api/RFGFeed;", "date", "finishChallenge", "getHistory", "Ljp/reifrontier/gym/domain/api/RFGPointHistory;", "getUserInfo", "Ljp/reifrontier/gym/domain/api/RFGUser;", "history", "Ljp/reifrontier/gym/domain/api/RFGSummaryHistory;", "ranking", "Ljp/reifrontier/gym/domain/api/RFGRankingData;", "kind", "", "reward", "Ljp/reifrontier/gym/domain/api/RFGReward;", "category", "rewardRequest", "year", "list", "rewardStatus", "Ljp/reifrontier/gym/domain/api/RFGRewardUserStatus;", "rewardUserList", "Ljp/reifrontier/gym/domain/api/RFGRewardUserList;", "up", "Ljp/reifrontier/gym/domain/api/RFGUpdateResult;", "upload", "icon", "userAction", "Ljp/reifrontier/gym/domain/api/RFGResponse;", "userAuth", "userChallenge", "Ljp/reifrontier/gym/domain/api/RFGUserChallenge;", "userCurrentYearPoint", "Ljp/reifrontier/gym/domain/api/RFGUserCurrentYearPoint;", "userExist", "userPersonal", "Ljp/reifrontier/gym/domain/api/RFGUserPersonal;", "userResetPass", "mail", "lang", "userValidRewards", "Ljp/reifrontier/gym/domain/api/RFGUserReward;", "userYearPoint", "Ljp/reifrontier/gym/domain/api/RFGUserPoint;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGApi */
public interface RFGApi {
    @GET("challenge")
    C1714r<Response<List<RFGChallenge>>> challenge(@Query("access_token") String str);

    @GET("challenge/detail/{chid}")
    C1714r<Response<C0980J>> challengeDetail(@Path("chid") String str, @Query("access_token") String str2);

    @GET("user/graph/{type}/{count}")
    C1714r<Response<List<RFGUserChart>>> chart(@Path("type") String str, @Path("count") String str2, @Query("access_token") String str3);

    @POST("club/create")
    @Multipart
    C1714r<Response<C0980J>> clubCreate(@Query("access_token") String str, @Part C1748C.C1751c cVar, @PartMap Map<String, C0976G> map);

    @GET("club/detail")
    C1714r<Response<RFGClub>> clubDetail(@Query("access_token") String str, @Query("club_id") String str2);

    @FormUrlEncoded
    @POST("club/refuse")
    C1714r<Response<C0980J>> clubRefuse(@Field("access_token") String str, @Field("club_id") String str2, @Field("sl2_id") String str3);

    @POST("club/update")
    @Multipart
    C1714r<Response<C0980J>> clubUpdate(@Query("access_token") String str, @Part C1748C.C1751c cVar, @PartMap Map<String, C0976G> map);

    @GET("club/users")
    C1714r<Response<List<RFGUserData>>> clubUsers(@Query("access_token") String str, @Query("club_id") String str2);

    @GET("user/club")
    C1714r<Response<List<RFGUserClub>>> clubs(@Query("access_token") String str);

    @FormUrlEncoded
    @POST("club/delete")
    C1714r<Response<C0980J>> deleteClub(@Field("access_token") String str, @Field("club_id") String str2);

    @FormUrlEncoded
    @POST("challenge/entry")
    C1714r<Response<C0980J>> entryChallenge(@Field("access_token") String str, @Field("chid") String str2);

    @FormUrlEncoded
    @POST("club/entry")
    C1714r<Response<C0980J>> entryClub(@Field("access_token") String str, @FieldMap Map<String, String> map, @Field("sl2_id") String str2);

    @FormUrlEncoded
    @POST("reward/exchange")
    C1714r<Response<C0980J>> exchangeReward(@Field("access_token") String str, @Field("rewardid") String str2);

    @GET("feed")
    C1714r<Response<List<RFGFeed>>> feed(@Query("date") String str, @Query("access_token") String str2);

    @FormUrlEncoded
    @POST("challenge/finish")
    C1714r<Response<C0980J>> finishChallenge(@Field("access_token") String str, @Field("chid") String str2);

    @GET("user/point_history")
    C1714r<Response<RFGPointHistory>> getHistory(@Query("access_token") String str);

    @GET("user")
    C1714r<Response<RFGUser>> getUserInfo(@Query("access_token") String str);

    @GET("user/history/{type}/{date}")
    C1714r<Response<List<RFGSummaryHistory>>> history(@Path("type") String str, @Path("date") String str2, @Query("access_token") String str3);

    @GET("ranking")
    C1714r<Response<RFGRankingData>> ranking(@Query("access_token") String str, @Query("kind") String str2, @Query("type") String str3, @Query("date") String str4, @Query("limit") int i);

    @GET("reward")
    C1714r<Response<List<RFGReward>>> reward(@Query("access_token") String str, @Query("category") String str2);

    @FormUrlEncoded
    @POST("reward/u_request")
    C1714r<Response<C0980J>> rewardRequest(@Field("access_token") String str, @Field("year") String str2, @Field("type") String str3, @Field("list") String str4);

    @GET("reward/u_status/{year}")
    C1714r<Response<RFGRewardUserStatus>> rewardStatus(@Path("year") String str, @Query("access_token") String str2);

    @GET("reward/u_list/{year}/{type}")
    C1714r<Response<RFGRewardUserList>> rewardUserList(@Path("year") String str, @Path("type") String str2, @Query("access_token") String str3);

    @FormUrlEncoded
    @POST("user/update")
    /* renamed from: up */
    C1714r<Response<RFGUpdateResult>> mo29439up(@Field("access_token") String str, @FieldMap Map<String, String> map);

    @POST("user/update")
    @Multipart
    C1714r<Response<C0980J>> upload(@Query("access_token") String str, @Part C1748C.C1751c cVar);

    @FormUrlEncoded
    @POST("user/action")
    C1714r<Response<RFGResponse>> userAction(@Field("access_token") String str, @FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("club/auth")
    C1714r<Response<C0980J>> userAuth(@Field("access_token") String str, @Field("club_id") String str2, @Field("join_sl2_id") String str3);

    @GET("user/challenge")
    C1714r<Response<List<RFGUserChallenge>>> userChallenge(@Query("access_token") String str);

    @GET("user/current_year_point")
    C1714r<Response<RFGUserCurrentYearPoint>> userCurrentYearPoint(@Query("access_token") String str);

    @GET("user/exist")
    C1714r<Response<C0980J>> userExist(@Query("access_token") String str, @Query("sl2_id") String str2);

    @GET("user/personal")
    C1714r<Response<RFGUserPersonal>> userPersonal(@Query("access_token") String str);

    @FormUrlEncoded
    @POST("setting/forgotpass")
    C1714r<Response<RFGResponse>> userResetPass(@Field("mailaddress") String str, @Field("lang") String str2);

    @GET("user/reward")
    C1714r<Response<RFGUserReward>> userValidRewards(@Query("access_token") String str);

    @GET("user/point")
    C1714r<Response<RFGUserPoint>> userYearPoint(@Query("access_token") String str, @Query("year") String str2);
}
