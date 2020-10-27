package p043jp.reifrontier.gym.fragment.train;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.api.RFGRailroadClient;
import p043jp.reifrontier.gym.domain.api.train.RFGApiOperation;
import p043jp.reifrontier.gym.domain.api.train.RFGApiRealtime;
import p078g.p079a.p100z.C1739b;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000(\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a \u0012\u0004\u0012\u00020\u0002\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00030\u00012\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00050\u00032\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00050\u0003H\n¢\u0006\u0002\b\u000b"}, mo21739d2 = {"<anonymous>", "", "", "Lkotlin/Pair;", "Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;", "", "", "realtimeResponse", "Ljp/reifrontier/gym/domain/api/train/RFGApiRealtime;", "operationResponse", "Ljp/reifrontier/gym/domain/api/train/RFGApiOperation;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment$startRequestRealtime$1 */
final class RFGScheduleMapFragment$startRequestRealtime$1<T1, T2, R> implements C1739b<Pair<? extends RFGRailroadClient.RailroadApiResult, ? extends List<? extends RFGApiRealtime>>, Pair<? extends RFGRailroadClient.RailroadApiResult, ? extends List<? extends RFGApiOperation>>, Map<String, ? extends Object>> {
    public static final RFGScheduleMapFragment$startRequestRealtime$1 INSTANCE = new RFGScheduleMapFragment$startRequestRealtime$1();

    RFGScheduleMapFragment$startRequestRealtime$1() {
    }

    public final Map<String, Pair<RFGRailroadClient.RailroadApiResult, List<Object>>> apply(Pair<? extends RFGRailroadClient.RailroadApiResult, ? extends List<RFGApiRealtime>> pair, Pair<? extends RFGRailroadClient.RailroadApiResult, ? extends List<RFGApiOperation>> pair2) {
        Intrinsics.checkParameterIsNotNull(pair, "realtimeResponse");
        Intrinsics.checkParameterIsNotNull(pair2, "operationResponse");
        return MapsKt__MapsKt.mapOf(TuplesKt.m4300to("realtime", pair), TuplesKt.m4300to("operation", pair2));
    }
}
