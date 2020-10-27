package p043jp.reifrontier.gym.data.train;

import android.annotation.SuppressLint;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.api.RFGRailroadClient;
import p043jp.reifrontier.gym.util.CalendarEx;
import p078g.p079a.C1714r;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p096w.p097b.C1721a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0015J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0016\u001a\u00020\u000fJ\u0014\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aJ&\u0010\u001b\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u001e0\u001d0\u001cH\u0003J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u001cH\u0002J\u0016\u0010!\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R6\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006j\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR6\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u0006j\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010`\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\r¨\u0006\""}, mo21739d2 = {"Ljp/reifrontier/gym/data/train/RFGTrainData;", "", "()V", "changeJsonTime", "", "stationMap", "Ljava/util/LinkedHashMap;", "", "Ljp/reifrontier/gym/data/train/RFGStation;", "Lkotlin/collections/LinkedHashMap;", "getStationMap", "()Ljava/util/LinkedHashMap;", "setStationMap", "(Ljava/util/LinkedHashMap;)V", "trainMap", "", "Ljp/reifrontier/gym/data/train/RFGTrain;", "getTrainMap", "setTrainMap", "findStation", "stationId", "(Ljava/lang/Integer;)Ljp/reifrontier/gym/data/train/RFGStation;", "searchText", "initialize", "", "onCompleted", "Lkotlin/Function0;", "loadStationFromLocal", "Lio/reactivex/Single;", "Lkotlin/Pair;", "", "refreshStations", "", "updateStations", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.RFGTrainData */
public final class RFGTrainData {
    public static final RFGTrainData INSTANCE = new RFGTrainData();
    /* access modifiers changed from: private */
    public static final long changeJsonTime = CalendarEx.getInstance$default(CalendarEx.INSTANCE, 2020, 7, 18, 11, 0, 0, 0, 112, (Object) null).getTimeInMillis();
    private static LinkedHashMap<Integer, RFGStation> stationMap = new LinkedHashMap<>();
    private static LinkedHashMap<String, RFGTrain> trainMap = new LinkedHashMap<>();

    private RFGTrainData() {
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public final C1714r<Pair<List<RFGStation>, List<RFGTrain>>> loadStationFromLocal() {
        C1714r<Pair<List<RFGStation>, List<RFGTrain>>> a = C1714r.m2410a(RFGTrainData$loadStationFromLocal$1.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(a, "Single.create<Pair<List<…onSuccess(data)\n        }");
        return a;
    }

    /* access modifiers changed from: private */
    public final C1714r<Boolean> refreshStations() {
        C1714r<R> b = C1714r.m2411a(RFGRailroadClient.Companion.getINSTANCE().getStations(), RFGRailroadClient.Companion.getINSTANCE().getTrains(), RFGTrainData$refreshStations$1.INSTANCE).mo27434b(C1683a.m2378b()).mo27435b(RFGTrainData$refreshStations$2.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(b, "Single.zip(\n            …          }\n            }");
        return b;
    }

    @SuppressLint({"CheckResult"})
    private final void updateStations(Function0<Unit> function0) {
        C1714r.m2410a(RFGTrainData$updateStations$1.INSTANCE).mo27430a(RFGTrainData$updateStations$2.INSTANCE).mo27430a(RFGTrainData$updateStations$3.INSTANCE).mo27434b(C1683a.m2378b()).mo27429a(C1721a.m2428a()).mo27432a(new RFGTrainData$updateStations$4(function0), new RFGTrainData$updateStations$5(function0));
    }

    public final RFGStation findStation(Integer num) {
        if (num != null) {
            num.intValue();
            if (stationMap.containsKey(num)) {
                return stationMap.get(num);
            }
        }
        return null;
    }

    public final RFGStation findStation(String str) {
        T t;
        Intrinsics.checkParameterIsNotNull(str, "searchText");
        Collection<RFGStation> values = stationMap.values();
        Intrinsics.checkExpressionValueIsNotNull(values, "stationMap.values");
        Iterator<T> it = values.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual((Object) ((RFGStation) t).getName(), (Object) str)) {
                break;
            }
        }
        return (RFGStation) t;
    }

    public final LinkedHashMap<Integer, RFGStation> getStationMap() {
        return stationMap;
    }

    public final LinkedHashMap<String, RFGTrain> getTrainMap() {
        return trainMap;
    }

    public final void initialize(Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, "onCompleted");
        updateStations(function0);
    }

    public final void setStationMap(LinkedHashMap<Integer, RFGStation> linkedHashMap) {
        Intrinsics.checkParameterIsNotNull(linkedHashMap, "<set-?>");
        stationMap = linkedHashMap;
    }

    public final void setTrainMap(LinkedHashMap<String, RFGTrain> linkedHashMap) {
        Intrinsics.checkParameterIsNotNull(linkedHashMap, "<set-?>");
        trainMap = linkedHashMap;
    }
}
