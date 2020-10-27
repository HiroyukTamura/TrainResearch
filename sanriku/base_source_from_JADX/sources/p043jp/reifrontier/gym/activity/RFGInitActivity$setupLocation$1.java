package p043jp.reifrontier.gym.activity;

import android.graphics.Color;
import android.widget.Button;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.C2092R;
import p043jp.reifrontier.sanriku.R;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, mo21739d2 = {"<anonymous>", "", "valid", "", "kotlin.jvm.PlatformType", "accept", "(Ljava/lang/Boolean;)V"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGInitActivity$setupLocation$1 */
final class RFGInitActivity$setupLocation$1<T> implements C1741d<Boolean> {
    final /* synthetic */ RFGInitActivity this$0;

    RFGInitActivity$setupLocation$1(RFGInitActivity rFGInitActivity) {
        this.this$0 = rFGInitActivity;
    }

    public final void accept(Boolean bool) {
        Button button = (Button) this.this$0._$_findCachedViewById(C2092R.C2094id.buttonLocationNext);
        Intrinsics.checkExpressionValueIsNotNull(button, "buttonLocationNext");
        Intrinsics.checkExpressionValueIsNotNull(bool, "valid");
        button.setEnabled(bool.booleanValue());
        ((Button) this.this$0._$_findCachedViewById(C2092R.C2094id.buttonLocationNext)).setTextColor(Color.parseColor("#333333"));
        ((Button) this.this$0._$_findCachedViewById(C2092R.C2094id.buttonLocationNext)).setBackgroundResource(R.drawable.button_main);
    }
}
