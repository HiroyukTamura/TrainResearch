package p043jp.reifrontier.gym.data.api;

import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.api.RFGH2Client;
import p078g.p079a.C1714r;
import p078g.p079a.C1718v;
import p078g.p079a.p100z.C1742e;
import retrofit2.Response;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Ljp/reifrontier/gym/data/api/RFGH2Client$H2APIResponse;", "kotlin.jvm.PlatformType", "T", "it", "Lretrofit2/Response;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGH2Client$response$1 */
final class RFGH2Client$response$1<T, R> implements C1742e<T, C1718v<? extends R>> {
    final /* synthetic */ String $path;
    final /* synthetic */ RFGH2Client this$0;

    RFGH2Client$response$1(RFGH2Client rFGH2Client, String str) {
        this.this$0 = rFGH2Client;
        this.$path = str;
    }

    public final C1714r<RFGH2Client.H2APIResponse> apply(final Response<T> response) {
        Intrinsics.checkParameterIsNotNull(response, "it");
        return C1714r.m2413a(new Callable<T>(this) {
            final /* synthetic */ RFGH2Client$response$1 this$0;

            {
                this.this$0 = r1;
            }

            public final RFGH2Client.H2APIResponse call() {
                RFGH2Client$response$1 rFGH2Client$response$1 = this.this$0;
                return rFGH2Client$response$1.this$0.handleResponse(rFGH2Client$response$1.$path, response.code(), response.errorBody(), response.body());
            }
        });
    }
}
