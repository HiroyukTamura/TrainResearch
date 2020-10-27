package p043jp.reifrontier.gym.activity;

import com.google.android.gms.tasks.OnFailureListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.p044ui.adapter.RFGSettingAdapter;
import p043jp.reifrontier.sanriku.R;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo21739d2 = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "onFailure"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGSettingActivity$accessGoogleFit$2 */
final class RFGSettingActivity$accessGoogleFit$2 implements OnFailureListener {
    final /* synthetic */ RFGSettingActivity this$0;

    RFGSettingActivity$accessGoogleFit$2(RFGSettingActivity rFGSettingActivity) {
        this.this$0 = rFGSettingActivity;
    }

    public final void onFailure(Exception exc) {
        Intrinsics.checkParameterIsNotNull(exc, "it");
        C1122a.m1599b("[Gym]::Error RFGSettingActivity Fitness.getHistoryClient Error " + exc.getLocalizedMessage(), new Object[0]);
        this.this$0.stopLoading();
        RFGSettingAdapter access$getMAdapter$p = this.this$0.mAdapter;
        if (access$getMAdapter$p == null) {
            Intrinsics.throwNpe();
        }
        access$getMAdapter$p.setData(this.this$0.createSetting());
        RFGSettingActivity rFGSettingActivity = this.this$0;
        String string = rFGSettingActivity.getString(R.string.google_fit_error_title);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.google_fit_error_title)");
        String string2 = this.this$0.getString(R.string.google_fit_error_message);
        Intrinsics.checkExpressionValueIsNotNull(string2, "getString(R.string.google_fit_error_message)");
        rFGSettingActivity.errorDialog(string, string2);
    }
}
