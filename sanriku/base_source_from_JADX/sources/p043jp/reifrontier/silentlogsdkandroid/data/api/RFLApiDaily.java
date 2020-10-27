package p043jp.reifrontier.silentlogsdkandroid.data.api;

import java.util.Map;
import kotlin.Metadata;
import p040i.C0980J;
import p043jp.reifrontier.silentlogsdkandroid.data.shared.RFLSharedHolder;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLDaily;
import p078g.p079a.C1714r;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J>\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\u0014\b\u0003\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\nH'JH\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u00072\u0014\b\u0003\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\nH'¨\u0006\u000e"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/api/RFLApiDaily;", "", "get", "Lio/reactivex/Single;", "Lretrofit2/Response;", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLDaily;", "requestDate", "", "accessToken", "extra_params", "", "post", "Lokhttp3/ResponseBody;", "storyline", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLApiDaily */
public interface RFLApiDaily {

    @Metadata(mo21737bv = {1, 0, 3}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLApiDaily$DefaultImpls */
    public static final class DefaultImpls {
        public static /* synthetic */ C1714r get$default(RFLApiDaily rFLApiDaily, String str, String str2, Map<String, String> map, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    map = RFLSharedHolder.INSTANCE.extraParameter();
                }
                return rFLApiDaily.get(str, str2, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: get");
        }

        public static /* synthetic */ C1714r post$default(RFLApiDaily rFLApiDaily, String str, String str2, String str3, Map<String, String> map, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    map = RFLSharedHolder.INSTANCE.extraParameter();
                }
                return rFLApiDaily.post(str, str2, str3, map);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: post");
        }
    }

    @GET("user/storyline/daily/{requestDate}")
    C1714r<Response<RFLDaily>> get(@Path("requestDate") String str, @Query("access_token") String str2, @QueryMap(encoded = true) Map<String, String> map);

    @FormUrlEncoded
    @POST("user/storyline/daily/{requestDate}")
    C1714r<Response<C0980J>> post(@Path("requestDate") String str, @Query("access_token") String str2, @Field("storyline") String str3, @FieldMap(encoded = true) Map<String, String> map);
}
