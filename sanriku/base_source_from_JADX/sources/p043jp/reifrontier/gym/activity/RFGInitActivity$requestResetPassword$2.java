package p043jp.reifrontier.gym.activity;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.sanriku.R;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "accept"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGInitActivity$requestResetPassword$2 */
final class RFGInitActivity$requestResetPassword$2<T> implements C1741d<Throwable> {
    final /* synthetic */ RFGInitActivity this$0;

    RFGInitActivity$requestResetPassword$2(RFGInitActivity rFGInitActivity) {
        this.this$0 = rFGInitActivity;
    }

    public final void accept(Throwable th) {
        this.this$0.stopLoading();
        RFGInitActivity rFGInitActivity = this.this$0;
        String string = rFGInitActivity.getResources().getString(R.string.password_reset_error);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.string.password_reset_error)");
        rFGInitActivity.alertWith(string);
    }
}
