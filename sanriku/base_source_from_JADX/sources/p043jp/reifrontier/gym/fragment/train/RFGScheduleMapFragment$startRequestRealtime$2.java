package p043jp.reifrontier.gym.fragment.train;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import org.greenrobot.eventbus.C1126c;
import p043jp.reifrontier.gym.data.api.RFGRailroadClient;
import p043jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012&\u0010\u0002\u001a\"\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "", "resultMap", "", "", "", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.fragment.train.RFGScheduleMapFragment$startRequestRealtime$2 */
final class RFGScheduleMapFragment$startRequestRealtime$2<T> implements C1741d<Map<String, ? extends Object>> {
    public static final RFGScheduleMapFragment$startRequestRealtime$2 INSTANCE = new RFGScheduleMapFragment$startRequestRealtime$2();

    RFGScheduleMapFragment$startRequestRealtime$2() {
    }

    public final void accept(Map<String, ? extends Object> map) {
        Object obj = map.get("realtime");
        if (obj != null) {
            Pair pair = (Pair) obj;
            RFGRailroadClient.RailroadApiResult railroadApiResult = (RFGRailroadClient.RailroadApiResult) pair.component1();
            List list = (List) pair.component2();
            Object obj2 = map.get("operation");
            if (obj2 != null) {
                Pair pair2 = (Pair) obj2;
                C1126c.m1638c().mo21903a((Object) new RFGScheduleMapFragment.OnCompletedRealtimeRequest(railroadApiResult, list, (RFGRailroadClient.RailroadApiResult) pair2.component1(), (List) pair2.component2()));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Pair<jp.reifrontier.gym.data.api.RFGRailroadClient.RailroadApiResult, kotlin.collections.List<jp.reifrontier.gym.domain.api.train.RFGApiOperation>>");
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Pair<jp.reifrontier.gym.data.api.RFGRailroadClient.RailroadApiResult, kotlin.collections.List<jp.reifrontier.gym.domain.api.train.RFGApiRealtime>>");
    }
}
