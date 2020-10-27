package p043jp.reifrontier.silentlogsdkandroid.daily;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLActivityPoi;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLPredict;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTag;
import p078g.p079a.C1696b;
import p078g.p079a.p094C.C1683a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLActivityPoiManager;", "", "dataLogger", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;)V", "replace", "Lio/reactivex/Completable;", "poiList", "", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLActivityPoi;", "startTime", "", "endTime", "removePredict", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLActivityPoiManager */
public final class RFLActivityPoiManager {

    /* renamed from: a */
    private final RFLDataLogger f3045a;

    public RFLActivityPoiManager(RFLDataLogger rFLDataLogger) {
        Intrinsics.checkParameterIsNotNull(rFLDataLogger, "dataLogger");
        this.f3045a = rFLDataLogger;
    }

    public final C1696b replace(List<RFLActivityPoi> list, int i, int i2, boolean z) {
        Intrinsics.checkParameterIsNotNull(list, "poiList");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10));
        for (RFLActivityPoi rFLActivityPoi : list) {
            arrayList.add(new RFLTag(rFLActivityPoi.getName(), Intrinsics.areEqual((Object) rFLActivityPoi.getSrc(), (Object) "osm") ? "poi.osm" : rFLActivityPoi.getSrc(), "", (RFLPredict) null, rFLActivityPoi));
        }
        List mutableList = CollectionsKt___CollectionsKt.toMutableList(arrayList);
        if (z) {
            mutableList.add(RFLTag.Companion.createPredictRemoveTag());
        }
        C1696b a = this.f3045a.replaceUserTag(mutableList, i, i2).mo27420a(C1683a.m2378b());
        Intrinsics.checkExpressionValueIsNotNull(a, "dataLogger.replaceUserTa…scribeOn(Schedulers.io())");
        return a;
    }
}
