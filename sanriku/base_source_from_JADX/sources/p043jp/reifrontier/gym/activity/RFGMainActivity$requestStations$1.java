package p043jp.reifrontier.gym.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo21739d2 = {"<anonymous>", "", "invoke"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMainActivity$requestStations$1 */
final class RFGMainActivity$requestStations$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ RFGMainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RFGMainActivity$requestStations$1(RFGMainActivity rFGMainActivity) {
        super(0);
        this.this$0 = rFGMainActivity;
    }

    public final void invoke() {
        this.this$0.requestSummary();
        this.this$0.requestUser();
    }
}
