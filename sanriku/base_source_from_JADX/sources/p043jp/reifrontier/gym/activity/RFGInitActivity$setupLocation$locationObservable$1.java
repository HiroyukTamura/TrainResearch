package p043jp.reifrontier.gym.activity;

import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.gym.data.analytics.RFGAnalyticsManager;
import p043jp.reifrontier.sanriku.R;
import p078g.p079a.p100z.C1742e;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo21739d2 = {"<anonymous>", "", "it", "", "apply"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGInitActivity$setupLocation$locationObservable$1 */
final class RFGInitActivity$setupLocation$locationObservable$1<T, R> implements C1742e<T, R> {
    final /* synthetic */ RFGInitActivity this$0;

    RFGInitActivity$setupLocation$locationObservable$1(RFGInitActivity rFGInitActivity) {
        this.this$0 = rFGInitActivity;
    }

    public final boolean apply(Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "it");
        this.this$0.request();
        RFGAnalyticsManager.sendEvent$default(RFGAnalyticsManager.INSTANCE, "002", "002a", (String) null, 4, (Object) null);
        ((TextView) this.this$0._$_findCachedViewById(C2092R.C2094id.confirmLocationText)).setText(R.string.confirm_location);
        ((ConstraintLayout) this.this$0._$_findCachedViewById(C2092R.C2094id.confirmLocation)).setBackgroundResource(R.drawable.radius_ok);
        return true;
    }
}
