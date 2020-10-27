package p043jp.reifrontier.gym.data.train;

import com.google.gson.Gson;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.Realm;
import p043jp.reifrontier.gym.domain.silentlog.RFGTrainEntity;
import p078g.p079a.C1715s;
import p078g.p079a.C1717u;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012D\u0010\u0002\u001a@\u0012<\u0012:\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0005 \b*\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0005\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\t"}, mo21739d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/SingleEmitter;", "Lkotlin/Pair;", "", "Ljp/reifrontier/gym/data/train/RFGStation;", "Ljp/reifrontier/gym/data/train/RFGTrain;", "kotlin.jvm.PlatformType", "subscribe"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.RFGTrainData$loadStationFromLocal$1 */
final class RFGTrainData$loadStationFromLocal$1<T> implements C1717u<T> {
    public static final RFGTrainData$loadStationFromLocal$1 INSTANCE = new RFGTrainData$loadStationFromLocal$1();

    RFGTrainData$loadStationFromLocal$1() {
    }

    public final void subscribe(C1715s<Pair<List<RFGStation>, List<RFGTrain>>> sVar) {
        Pair pair;
        Intrinsics.checkParameterIsNotNull(sVar, "emitter");
        Realm defaultInstance = Realm.getDefaultInstance();
        RFGTrainEntity rFGTrainEntity = (RFGTrainEntity) defaultInstance.where(RFGTrainEntity.class).findFirst();
        if (rFGTrainEntity == null || !rFGTrainEntity.isValid()) {
            pair = new Pair(CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList());
        } else {
            List list = (List) new Gson().fromJson(rFGTrainEntity.getStations(), new RFGTrainData$loadStationFromLocal$1$data$stationListType$1().getType());
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            List sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new RFGTrainData$loadStationFromLocal$1$$special$$inlined$sortedBy$1());
            List list2 = (List) new Gson().fromJson(rFGTrainEntity.getTrains(), new RFGTrainData$loadStationFromLocal$1$data$trainListType$1().getType());
            if (list2 == null) {
                list2 = CollectionsKt__CollectionsKt.emptyList();
            }
            pair = new Pair(sortedWith, list2);
        }
        defaultInstance.close();
        sVar.onSuccess(pair);
    }
}
