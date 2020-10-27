package p043jp.reifrontier.silentlogsdkandroid.data.api;

import java.util.Map;
import kotlin.Metadata;
import p043jp.reifrontier.silentlogsdkandroid.info.RFLPointCalcRequest;
import p078g.p079a.C1714r;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001JH\u0010\u0002\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u00050\u00040\u00032\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u000bH'¨\u0006\f"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/api/RFLApiInfo;", "", "pointCalculation", "Lio/reactivex/Single;", "Lretrofit2/Response;", "", "", "year", "month", "day", "pointCalcRequest", "Ljp/reifrontier/silentlogsdkandroid/info/RFLPointCalcRequest;", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLApiInfo */
public interface RFLApiInfo {
    @POST("point/daily/{year}/{month}/{day}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    C1714r<Response<Map<String, Object>>> pointCalculation(@Path("year") String str, @Path("month") String str2, @Path("day") String str3, @Body RFLPointCalcRequest rFLPointCalcRequest);
}
