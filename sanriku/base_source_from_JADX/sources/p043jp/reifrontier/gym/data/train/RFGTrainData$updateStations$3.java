package p043jp.reifrontier.gym.data.train;

import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import p078g.p079a.C1714r;
import p078g.p079a.C1718v;
import p078g.p079a.p100z.C1742e;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00030\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "Lkotlin/Pair;", "", "Ljp/reifrontier/gym/data/train/RFGStation;", "Ljp/reifrontier/gym/data/train/RFGTrain;", "it", "", "apply", "(Ljava/lang/Boolean;)Lio/reactivex/Single;"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.RFGTrainData$updateStations$3 */
final class RFGTrainData$updateStations$3<T, R> implements C1742e<T, C1718v<? extends R>> {
    public static final RFGTrainData$updateStations$3 INSTANCE = new RFGTrainData$updateStations$3();

    RFGTrainData$updateStations$3() {
    }

    public final C1714r<Pair<List<RFGStation>, List<RFGTrain>>> apply(Boolean bool) {
        Intrinsics.checkParameterIsNotNull(bool, "it");
        return RFGTrainData.INSTANCE.loadStationFromLocal();
    }
}
