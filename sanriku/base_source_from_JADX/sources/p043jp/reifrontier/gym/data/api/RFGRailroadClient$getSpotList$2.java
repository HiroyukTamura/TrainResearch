package p043jp.reifrontier.gym.data.api;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.api.RFGRailroadClient;
import p043jp.reifrontier.gym.domain.api.train.RFGApiSpot;
import p078g.p079a.p100z.C1742e;
import retrofit2.Response;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0006H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "Lkotlin/Pair;", "Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;", "", "Ljp/reifrontier/gym/domain/api/train/RFGApiSpot;", "it", "Lretrofit2/Response;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGRailroadClient$getSpotList$2 */
final class RFGRailroadClient$getSpotList$2<T, R> implements C1742e<T, R> {
    public static final RFGRailroadClient$getSpotList$2 INSTANCE = new RFGRailroadClient$getSpotList$2();

    RFGRailroadClient$getSpotList$2() {
    }

    public final Pair<RFGRailroadClient.RailroadApiResult, List<RFGApiSpot>> apply(Response<List<RFGApiSpot>> response) {
        Intrinsics.checkParameterIsNotNull(response, "it");
        List body = response.body();
        RFGRailroadClient.RailroadApiResult railroadApiResult = response.code() == -1 ? RFGRailroadClient.RailroadApiResult.AUTH_ERROR : (response.code() != 200 || body == null) ? RFGRailroadClient.RailroadApiResult.RESPONSE_ERROR : RFGRailroadClient.RailroadApiResult.SUCCESS;
        if (body == null) {
            Intrinsics.throwNpe();
        }
        return new Pair<>(railroadApiResult, body);
    }
}
