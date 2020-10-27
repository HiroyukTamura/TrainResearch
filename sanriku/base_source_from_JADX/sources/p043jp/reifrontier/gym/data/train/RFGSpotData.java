package p043jp.reifrontier.gym.data.train;

import android.location.Location;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.api.RFGRailroadClient;
import p043jp.reifrontier.gym.data.train.spot.RFGContent;
import p043jp.reifrontier.gym.data.train.spot.RFGSpot;
import p043jp.reifrontier.gym.p044ui.viewModel.RFGSpotOrderType;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation;
import p048l.p049a.C1122a;
import p078g.p079a.C1714r;
import p078g.p079a.p094C.C1683a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u00042\u0006\u0010\b\u001a\u00020\tJ?\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u00050\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\t¢\u0006\u0002\u0010\u0011¨\u0006\u0013"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/RFGSpotData;", "", "()V", "getSpotDetail", "Lio/reactivex/Single;", "Lkotlin/Pair;", "Ljp/reifrontier/gym/data/api/RFGRailroadClient$RailroadApiResult;", "Ljp/reifrontier/gym/data/train/spot/RFGContent;", "spotId", "", "getSpotList", "", "Ljp/reifrontier/gym/data/train/spot/RFGSpot;", "order", "Ljp/reifrontier/gym/ui/viewModel/RFGSpotOrderType;", "stationId", "page", "(Ljp/reifrontier/gym/ui/viewModel/RFGSpotOrderType;Ljava/lang/Integer;I)Lio/reactivex/Single;", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.RFGSpotData */
public final class RFGSpotData {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int PAGE_LIMIT = 10;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/RFGSpotData$Companion;", "", "()V", "PAGE_LIMIT", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.data.train.RFGSpotData$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final C1714r<Pair<RFGRailroadClient.RailroadApiResult, RFGContent>> getSpotDetail(int i) {
        C1714r<R> b = RFGRailroadClient.Companion.getINSTANCE().getSpotDetail(i).mo27434b(C1683a.m2378b()).mo27435b(RFGSpotData$getSpotDetail$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(b, "RFGRailroadClient.INSTAN…          }\n            }");
        return b;
    }

    public final C1714r<Pair<RFGRailroadClient.RailroadApiResult, List<RFGSpot>>> getSpotList(RFGSpotOrderType rFGSpotOrderType, Integer num, int i) {
        Double d;
        Double d2;
        Location loadLocation;
        if (rFGSpotOrderType != RFGSpotOrderType.NEAREST || (loadLocation = SilentLogOperation.Companion.getInstance().loadLocation()) == null) {
            d2 = null;
            d = null;
        } else {
            Double valueOf = Double.valueOf(loadLocation.getLatitude());
            d = Double.valueOf(loadLocation.getLongitude());
            d2 = valueOf;
        }
        C1122a.m1596a("[Sanriku]::Debug lat=" + d2 + ", lon=" + d + ", stationId=" + num, new Object[0]);
        C1714r<R> b = RFGRailroadClient.Companion.getINSTANCE().getSpotList(Integer.valueOf(i), 10, num, d2, d).mo27434b(C1683a.m2378b()).mo27435b(RFGSpotData$getSpotList$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(b, "RFGRailroadClient.INSTAN…          }\n            }");
        return b;
    }
}
