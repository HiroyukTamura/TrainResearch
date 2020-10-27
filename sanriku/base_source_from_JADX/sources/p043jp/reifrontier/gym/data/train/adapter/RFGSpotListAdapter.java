package p043jp.reifrontier.gym.data.train.adapter;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.train.spot.RFGSpot;
import p043jp.reifrontier.gym.domain.api.train.RFGApiSpot;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b¨\u0006\n"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/adapter/RFGSpotListAdapter;", "", "()V", "convertSpot", "Ljp/reifrontier/gym/data/train/spot/RFGSpot;", "realmSpot", "Ljp/reifrontier/gym/domain/api/train/RFGApiSpot;", "fromApi", "", "realmSpotList", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.adapter.RFGSpotListAdapter */
public final class RFGSpotListAdapter {
    private final RFGSpot convertSpot(RFGApiSpot rFGApiSpot) {
        return new RFGSpot(rFGApiSpot.getId(), rFGApiSpot.getDate(), rFGApiSpot.getTitle(), rFGApiSpot.getStationId(), rFGApiSpot.getUpdateAt());
    }

    public final List<RFGSpot> fromApi(List<? extends RFGApiSpot> list) {
        Intrinsics.checkParameterIsNotNull(list, "realmSpotList");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (RFGApiSpot convertSpot : list) {
            arrayList.add(convertSpot(convertSpot));
        }
        return arrayList;
    }
}
