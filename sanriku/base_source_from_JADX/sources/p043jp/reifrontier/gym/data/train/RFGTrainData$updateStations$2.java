package p043jp.reifrontier.gym.data.train;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p078g.p079a.C1714r;
import p078g.p079a.C1718v;
import p078g.p079a.p100z.C1742e;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, mo21739d2 = {"<anonymous>", "Lio/reactivex/Single;", "", "needUpdate", "apply", "(Ljava/lang/Boolean;)Lio/reactivex/Single;"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.train.RFGTrainData$updateStations$2 */
final class RFGTrainData$updateStations$2<T, R> implements C1742e<T, C1718v<? extends R>> {
    public static final RFGTrainData$updateStations$2 INSTANCE = new RFGTrainData$updateStations$2();

    RFGTrainData$updateStations$2() {
    }

    public final C1714r<Boolean> apply(Boolean bool) {
        Intrinsics.checkParameterIsNotNull(bool, "needUpdate");
        if (bool.booleanValue()) {
            return RFGTrainData.INSTANCE.refreshStations();
        }
        C1714r<Boolean> a = C1714r.m2413a(C21061.INSTANCE);
        Intrinsics.checkExpressionValueIsNotNull(a, "Single.fromCallable { true }");
        return a;
    }
}
