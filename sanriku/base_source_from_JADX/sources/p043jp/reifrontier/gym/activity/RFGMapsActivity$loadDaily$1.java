package p043jp.reifrontier.gym.activity;

import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p048l.p049a.C1122a;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo21739d2 = {"<anonymous>", "", "dailyResult", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Boolean;)V"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGMapsActivity$loadDaily$1 */
final class RFGMapsActivity$loadDaily$1<T> implements C1741d<Boolean> {
    final /* synthetic */ Date $updateDate;
    final /* synthetic */ RFGMapsActivity this$0;

    RFGMapsActivity$loadDaily$1(RFGMapsActivity rFGMapsActivity, Date date) {
        this.this$0 = rFGMapsActivity;
        this.$updateDate = date;
    }

    public final void accept(Boolean bool) {
        Intrinsics.checkExpressionValueIsNotNull(bool, "dailyResult");
        if (bool.booleanValue()) {
            C1122a.m1596a("[Gym]::Debug updateLocalDaily()", new Object[0]);
            this.this$0.updateLocalDaily(this.$updateDate);
        }
    }
}
