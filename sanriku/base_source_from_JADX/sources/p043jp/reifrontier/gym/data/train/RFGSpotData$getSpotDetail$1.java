package p043jp.reifrontier.gym.data.train;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.api.RFGRailroadClient;
import p043jp.reifrontier.gym.data.train.adapter.RFGContentAdapter;
import p043jp.reifrontier.gym.data.train.spot.RFGContent;
import p043jp.reifrontier.gym.domain.api.train.RFGApiContent;
import p048l.p049a.C1122a;
import p078g.p079a.p100z.C1742e;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, mo21739d2 = {"<anonymous>", "Lkotlin/Pair;", "Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;", "Ljp/reifrontier/gym/data/train/spot/RFGContent;", "<name for destructuring parameter 0>", "Ljp/reifrontier/gym/domain/api/train/RFGApiContent;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.RFGSpotData$getSpotDetail$1 */
final class RFGSpotData$getSpotDetail$1<T, R> implements C1742e<T, R> {
    public static final RFGSpotData$getSpotDetail$1 INSTANCE = new RFGSpotData$getSpotDetail$1();

    RFGSpotData$getSpotDetail$1() {
    }

    public final Pair<RFGRailroadClient.RailroadApiResult, RFGContent> apply(Pair<? extends RFGRailroadClient.RailroadApiResult, ? extends RFGApiContent> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "<name for destructuring parameter 0>");
        RFGRailroadClient.RailroadApiResult railroadApiResult = (RFGRailroadClient.RailroadApiResult) pair.component1();
        RFGApiContent rFGApiContent = (RFGApiContent) pair.component2();
        C1122a.m1596a("[Sanriku]::Debug content get from server (" + railroadApiResult + ", " + rFGApiContent + ')', new Object[0]);
        return railroadApiResult == RFGRailroadClient.RailroadApiResult.SUCCESS ? new Pair<>(railroadApiResult, new RFGContentAdapter().fromApi(rFGApiContent)) : new Pair<>(railroadApiResult, null);
    }
}
