package p043jp.reifrontier.gym.data.train;

import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012>\u0010\u0002\u001a:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0004 \u0007*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\b"}, mo21739d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "Ljp/reifrontier/gym/data/train/RFGStation;", "Ljp/reifrontier/gym/data/train/RFGTrain;", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.RFGTrainData$updateStations$4 */
final class RFGTrainData$updateStations$4<T> implements C1741d<Pair<? extends List<? extends RFGStation>, ? extends List<? extends RFGTrain>>> {
    final /* synthetic */ Function0 $onCompleted;

    RFGTrainData$updateStations$4(Function0 function0) {
        this.$onCompleted = function0;
    }

    public final void accept(Pair<? extends List<RFGStation>, ? extends List<RFGTrain>> pair) {
        List list = (List) pair.component2();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (RFGStation rFGStation : (List) pair.component1()) {
            linkedHashMap.put(Integer.valueOf(rFGStation.getStationId()), rFGStation);
        }
        RFGTrainData.INSTANCE.setStationMap(linkedHashMap);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        int i = 0;
        for (Object next : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            RFGTrain rFGTrain = (RFGTrain) next;
            rFGTrain.setTrainIndex(i2);
            linkedHashMap2.put(rFGTrain.getTrainNo(), rFGTrain);
            i = i2;
        }
        RFGTrainData.INSTANCE.setTrainMap(linkedHashMap2);
        this.$onCompleted.invoke();
    }
}
