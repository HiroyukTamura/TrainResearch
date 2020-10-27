package p043jp.reifrontier.gym.data.api;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p078g.p079a.C1715s;
import p078g.p079a.C1717u;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, mo21739d2 = {"<anonymous>", "", "it", "Lio/reactivex/SingleEmitter;", "", "kotlin.jvm.PlatformType", "subscribe"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.data.api.RFGRailroadClient$auth$1 */
final class RFGRailroadClient$auth$1<T> implements C1717u<T> {
    public static final RFGRailroadClient$auth$1 INSTANCE = new RFGRailroadClient$auth$1();

    RFGRailroadClient$auth$1() {
    }

    public final void subscribe(C1715s<Boolean> sVar) {
        Intrinsics.checkParameterIsNotNull(sVar, "it");
        sVar.onSuccess(true);
    }
}
