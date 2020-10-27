package p043jp.reifrontier.silentlogsdkandroid.daily;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.silentlogsdkandroid.domain.daily.RFLTrackPoint;
import p078g.p079a.C1696b;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLAdjustTrackPointManager;", "", "dataLogger", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;)V", "replace", "Lio/reactivex/Completable;", "adjustTrackPoints", "", "Ljp/reifrontier/silentlogsdkandroid/domain/daily/RFLTrackPoint;", "fromDate", "", "toDate", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLAdjustTrackPointManager */
public final class RFLAdjustTrackPointManager {

    /* renamed from: a */
    private final RFLDataLogger f3050a;

    public RFLAdjustTrackPointManager(RFLDataLogger rFLDataLogger) {
        Intrinsics.checkParameterIsNotNull(rFLDataLogger, "dataLogger");
        this.f3050a = rFLDataLogger;
    }

    public final C1696b replace(List<RFLTrackPoint> list, int i, int i2) {
        Intrinsics.checkParameterIsNotNull(list, "adjustTrackPoints");
        return this.f3050a.replaceAdjustTrackPoints(list, i, i2);
    }
}
