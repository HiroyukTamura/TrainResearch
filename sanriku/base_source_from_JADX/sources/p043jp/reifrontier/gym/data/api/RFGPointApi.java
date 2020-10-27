package p043jp.reifrontier.gym.data.api;

import kotlin.Metadata;
import p043jp.reifrontier.gym.domain.api.train.RFGApiPointActionRequest;
import p043jp.reifrontier.gym.domain.api.train.RFGApiPointActionResponse;
import p078g.p079a.C1714r;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'¨\u0006\b"}, mo21739d2 = {"Ljp/reifrontier/gym/data/api/RFGPointApi;", "", "pointAction", "Lio/reactivex/Single;", "Lretrofit2/Response;", "Ljp/reifrontier/gym/domain/api/train/RFGApiPointActionResponse;", "body", "Ljp/reifrontier/gym/domain/api/train/RFGApiPointActionRequest;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGPointApi */
public interface RFGPointApi {
    @POST("point/action")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    C1714r<Response<RFGApiPointActionResponse>> pointAction(@Body RFGApiPointActionRequest rFGApiPointActionRequest);
}
