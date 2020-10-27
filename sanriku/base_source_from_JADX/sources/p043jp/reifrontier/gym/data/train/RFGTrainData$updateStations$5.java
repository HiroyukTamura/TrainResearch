package p043jp.reifrontier.gym.data.train;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import p009e.p010a.p011a.p012a.C0681a;
import p048l.p049a.C1122a;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.RFGTrainData$updateStations$5 */
final class RFGTrainData$updateStations$5<T> implements C1741d<Throwable> {
    final /* synthetic */ Function0 $onCompleted;

    RFGTrainData$updateStations$5(Function0 function0) {
        this.$onCompleted = function0;
    }

    public final void accept(Throwable th) {
        C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("[Gym]::Error refreshStations error, ", th, "it")), new Object[0]);
        this.$onCompleted.invoke();
    }
}
