package p043jp.reifrontier.gym.data.train;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.api.RFGRailroadClient;
import p043jp.reifrontier.gym.data.train.adapter.RFGSpotListAdapter;
import p043jp.reifrontier.gym.data.train.spot.RFGSpot;
import p043jp.reifrontier.gym.domain.api.train.RFGApiSpot;
import p078g.p079a.p100z.C1742e;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00012\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\u0001H\n¢\u0006\u0002\b\u0007"}, mo21739d2 = {"<anonymous>", "Lkotlin/Pair;", "Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;", "", "Ljp/reifrontier/gym/data/train/spot/RFGSpot;", "<name for destructuring parameter 0>", "Ljp/reifrontier/gym/domain/api/train/RFGApiSpot;", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.RFGSpotData$getSpotList$2 */
final class RFGSpotData$getSpotList$2<T, R> implements C1742e<T, R> {
    public static final RFGSpotData$getSpotList$2 INSTANCE = new RFGSpotData$getSpotList$2();

    RFGSpotData$getSpotList$2() {
    }

    public final Pair<RFGRailroadClient.RailroadApiResult, List<RFGSpot>> apply(Pair<? extends RFGRailroadClient.RailroadApiResult, ? extends List<? extends RFGApiSpot>> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "<name for destructuring parameter 0>");
        RFGRailroadClient.RailroadApiResult railroadApiResult = (RFGRailroadClient.RailroadApiResult) pair.component1();
        List list = (List) pair.component2();
        if (railroadApiResult != RFGRailroadClient.RailroadApiResult.SUCCESS) {
            return new Pair<>(railroadApiResult, new RFGSpotListAdapter().fromApi(list));
        }
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object next : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(RFGApiSpot.copy$default((RFGApiSpot) next, 0, 0, (String) null, 0, 0, i2, 31, (Object) null));
            i = i2;
        }
        return new Pair<>(railroadApiResult, new RFGSpotListAdapter().fromApi(arrayList));
    }
}
