package p043jp.reifrontier.gym.data.api;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.domain.api.train.RFGApiSpot;
import p078g.p079a.C1714r;
import p078g.p079a.C1715s;
import p078g.p079a.C1717u;
import p078g.p079a.C1718v;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p100z.C1742e;
import retrofit2.Response;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a(\u0012$\u0012\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003 \u0005*\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00020\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lretrofit2/Response;", "", "Ljp/reifrontier/gym/domain/api/train/RFGApiSpot;", "kotlin.jvm.PlatformType", "authResult", "", "apply", "(Ljava/lang/Boolean;)Lio/reactivex/Single;"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGRailroadClient$getSpotList$1 */
final class RFGRailroadClient$getSpotList$1<T, R> implements C1742e<T, C1718v<? extends R>> {
    final /* synthetic */ Double $lat;
    final /* synthetic */ Integer $limit;
    final /* synthetic */ Double $lon;
    final /* synthetic */ Integer $page;
    final /* synthetic */ Integer $stationId;
    final /* synthetic */ RFGRailroadClient this$0;

    RFGRailroadClient$getSpotList$1(RFGRailroadClient rFGRailroadClient, Integer num, Integer num2, Integer num3, Double d, Double d2) {
        this.this$0 = rFGRailroadClient;
        this.$page = num;
        this.$limit = num2;
        this.$stationId = num3;
        this.$lat = d;
        this.$lon = d2;
    }

    public final C1714r<Response<List<RFGApiSpot>>> apply(Boolean bool) {
        Intrinsics.checkParameterIsNotNull(bool, "authResult");
        return bool.booleanValue() ? RFGRailroadClient.access$getRailroadApi$p(this.this$0).getSpotList(this.$page, this.$limit, this.$stationId, this.$lat, this.$lon).mo27434b(C1683a.m2378b()) : C1714r.m2410a(new C1717u<T>(this) {
            final /* synthetic */ RFGRailroadClient$getSpotList$1 this$0;

            {
                this.this$0 = r1;
            }

            public final void subscribe(C1715s<Response<List<RFGApiSpot>>> sVar) {
                Intrinsics.checkParameterIsNotNull(sVar, "it");
                sVar.onSuccess(RFGRailroadClient.getErrorResponse$default(this.this$0.this$0, 0, 1, (Object) null));
            }
        });
    }
}
