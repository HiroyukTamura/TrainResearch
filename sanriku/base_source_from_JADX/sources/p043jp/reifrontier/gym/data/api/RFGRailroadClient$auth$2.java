package p043jp.reifrontier.gym.data.api;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.domain.api.train.RFGApiAuthResponse;
import p078g.p079a.p100z.C1742e;
import retrofit2.Response;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "response", "Lretrofit2/Response;", "Ljp/reifrontier/gym/domain/api/train/RFGApiAuthResponse;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGRailroadClient$auth$2 */
final class RFGRailroadClient$auth$2<T, R> implements C1742e<T, R> {
    final /* synthetic */ RFGRailroadClient this$0;

    RFGRailroadClient$auth$2(RFGRailroadClient rFGRailroadClient) {
        this.this$0 = rFGRailroadClient;
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Boolean.valueOf(apply((Response<RFGApiAuthResponse>) (Response) obj));
    }

    public final boolean apply(Response<RFGApiAuthResponse> response) {
        Intrinsics.checkParameterIsNotNull(response, "response");
        if (response.code() == 200) {
            RFGApiAuthResponse body = response.body();
            if (Intrinsics.areEqual((Object) body != null ? body.getResult() : null, (Object) FirebaseAnalytics.Param.SUCCESS)) {
                this.this$0.accessToken = body.getToken();
            }
        }
        this.this$0.oAuthInterceptor.setToken(this.this$0.accessToken);
        String access$getAccessToken$p = this.this$0.accessToken;
        return !(access$getAccessToken$p == null || access$getAccessToken$p.length() == 0);
    }
}
