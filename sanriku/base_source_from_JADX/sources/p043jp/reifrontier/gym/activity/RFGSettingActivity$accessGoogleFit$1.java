package p043jp.reifrontier.gym.activity;

import com.google.android.gms.fitness.result.DataReadResponse;
import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.Metadata;
import p043jp.reifrontier.gym.data.shared.RFGShared;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo21739d2 = {"<anonymous>", "", "it", "Lcom/google/android/gms/fitness/result/DataReadResponse;", "kotlin.jvm.PlatformType", "onSuccess"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGSettingActivity$accessGoogleFit$1 */
final class RFGSettingActivity$accessGoogleFit$1<TResult> implements OnSuccessListener<DataReadResponse> {
    final /* synthetic */ RFGSettingActivity this$0;

    RFGSettingActivity$accessGoogleFit$1(RFGSettingActivity rFGSettingActivity) {
        this.this$0 = rFGSettingActivity;
    }

    public final void onSuccess(DataReadResponse dataReadResponse) {
        C1122a.m1600c("[Gym]::Info RFGSettingActivity Fitness.getHistoryClient success", new Object[0]);
        RFGShared.INSTANCE.setIsUseGoogleFit(true);
        this.this$0.openGoogleFitDialog();
    }
}
