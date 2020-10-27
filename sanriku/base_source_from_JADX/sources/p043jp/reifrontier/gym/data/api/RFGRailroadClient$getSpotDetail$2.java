package p043jp.reifrontier.gym.data.api;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.api.RFGRailroadClient;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContent;
import p078g.p079a.p100z.C1742e;
import retrofit2.Response;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0006"}, mo21739d2 = {"<anonymous>", "Lkotlin/Pair;", "Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;", "Ljp/reifrontier/gym/domain/api/train/RFGApiContent;", "it", "Lretrofit2/Response;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGRailroadClient$getSpotDetail$2 */
final class RFGRailroadClient$getSpotDetail$2<T, R> implements C1742e<T, R> {
    public static final RFGRailroadClient$getSpotDetail$2 INSTANCE = new RFGRailroadClient$getSpotDetail$2();

    RFGRailroadClient$getSpotDetail$2() {
    }

    public final Pair<RFGRailroadClient.RailroadApiResult, RFGApiContent> apply(Response<RFGApiContent> response) {
        Intrinsics.checkParameterIsNotNull(response, "it");
        RFGApiContent body = response.body();
        RFGRailroadClient.RailroadApiResult railroadApiResult = response.code() == -1 ? RFGRailroadClient.RailroadApiResult.AUTH_ERROR : (response.code() != 200 || body == null) ? RFGRailroadClient.RailroadApiResult.RESPONSE_ERROR : RFGRailroadClient.RailroadApiResult.SUCCESS;
        if (body == null) {
            Intrinsics.throwNpe();
        }
        return new Pair<>(railroadApiResult, body);
    }
}
