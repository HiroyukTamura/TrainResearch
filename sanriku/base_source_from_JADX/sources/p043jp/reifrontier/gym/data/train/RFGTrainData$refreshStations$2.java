package p043jp.reifrontier.gym.data.train;

import com.google.gson.Gson;
import java.util.Calendar;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import p041io.realm.ImportFlag;
import p041io.realm.Realm;
import p043jp.reifrontier.gym.data.api.RFGRailroadClient;
import p043jp.reifrontier.gym.domain.silentlog.RFGTrainEntity;
import p078g.p079a.p100z.C1742e;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, mo21739d2 = {"<anonymous>", "", "it", "", "", "", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.RFGTrainData$refreshStations$2 */
final class RFGTrainData$refreshStations$2<T, R> implements C1742e<T, R> {
    public static final RFGTrainData$refreshStations$2 INSTANCE = new RFGTrainData$refreshStations$2();

    RFGTrainData$refreshStations$2() {
    }

    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return Boolean.valueOf(apply((Map<String, ? extends Object>) (Map) obj));
    }

    public final boolean apply(Map<String, ? extends Object> map) {
        Intrinsics.checkParameterIsNotNull(map, "it");
        Object obj = map.get("stationResponse");
        Pair pair = null;
        if (!(obj instanceof Pair)) {
            obj = null;
        }
        Pair pair2 = (Pair) obj;
        if (pair2 == null) {
            pair2 = new Pair(RFGRailroadClient.RailroadApiResult.RESPONSE_ERROR, CollectionsKt__CollectionsKt.emptyList());
        }
        Object obj2 = map.get("trainResponse");
        if (obj2 instanceof Pair) {
            pair = obj2;
        }
        Pair pair3 = pair;
        if (pair3 == null) {
            pair3 = new Pair(RFGRailroadClient.RailroadApiResult.RESPONSE_ERROR, CollectionsKt__CollectionsKt.emptyList());
        }
        Realm defaultInstance = Realm.getDefaultInstance();
        if (((RFGRailroadClient.RailroadApiResult) pair2.getFirst()) != RFGRailroadClient.RailroadApiResult.SUCCESS || ((RFGRailroadClient.RailroadApiResult) pair3.getFirst()) != RFGRailroadClient.RailroadApiResult.SUCCESS) {
            return false;
        }
        defaultInstance.beginTransaction();
        RFGTrainEntity rFGTrainEntity = (RFGTrainEntity) defaultInstance.where(RFGTrainEntity.class).findFirst();
        if (rFGTrainEntity == null) {
            rFGTrainEntity = new RFGTrainEntity();
        }
        Intrinsics.checkExpressionValueIsNotNull(rFGTrainEntity, "realm\n                  …rst() ?: RFGTrainEntity()");
        if (!rFGTrainEntity.isValid()) {
            rFGTrainEntity = new RFGTrainEntity();
        }
        String json = new Gson().toJson(pair2.getSecond());
        Intrinsics.checkExpressionValueIsNotNull(json, "Gson().toJson(stationResponse.second)");
        rFGTrainEntity.setStations(json);
        String json2 = new Gson().toJson(pair3.getSecond());
        Intrinsics.checkExpressionValueIsNotNull(json2, "Gson().toJson(trainResponse.second)");
        rFGTrainEntity.setTrains(json2);
        Calendar instance = Calendar.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "Calendar.getInstance()");
        rFGTrainEntity.setUpdateTime(instance.getTimeInMillis());
        defaultInstance.copyToRealmOrUpdate(rFGTrainEntity, new ImportFlag[0]);
        defaultInstance.commitTransaction();
        defaultInstance.close();
        return true;
    }
}
