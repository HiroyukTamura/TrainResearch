package p043jp.reifrontier.gym.activity;

import com.google.android.gms.fitness.result.DataReadResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, mo21739d2 = {"<anonymous>", "", "it", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/android/gms/fitness/result/DataReadResponse;", "kotlin.jvm.PlatformType", "onComplete"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGSettingActivity$accessGoogleFit$3 */
final class RFGSettingActivity$accessGoogleFit$3<TResult> implements OnCompleteListener<DataReadResponse> {
    public static final RFGSettingActivity$accessGoogleFit$3 INSTANCE = new RFGSettingActivity$accessGoogleFit$3();

    RFGSettingActivity$accessGoogleFit$3() {
    }

    public final void onComplete(Task<DataReadResponse> task) {
        Intrinsics.checkParameterIsNotNull(task, "it");
        C1122a.m1600c("[Gym]::Info Fitness.getHistoryClient complete", new Object[0]);
    }
}
