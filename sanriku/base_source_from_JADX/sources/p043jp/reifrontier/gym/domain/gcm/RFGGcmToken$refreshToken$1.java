package p043jp.reifrontier.gym.domain.gcm;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.InstanceIdResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, mo21739d2 = {"<anonymous>", "", "task", "Lcom/google/android/gms/tasks/Task;", "Lcom/google/firebase/iid/InstanceIdResult;", "kotlin.jvm.PlatformType", "onComplete"}, mo21740k = 3, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.gcm.RFGGcmToken$refreshToken$1 */
final class RFGGcmToken$refreshToken$1<TResult> implements OnCompleteListener<InstanceIdResult> {
    final /* synthetic */ RFGGcmToken this$0;

    RFGGcmToken$refreshToken$1(RFGGcmToken rFGGcmToken) {
        this.this$0 = rFGGcmToken;
    }

    public final void onComplete(Task<InstanceIdResult> task) {
        InstanceIdResult result;
        String token;
        Intrinsics.checkParameterIsNotNull(task, "task");
        if (task.isSuccessful() && (result = task.getResult()) != null && (token = result.getToken()) != null) {
            RFGGcmToken rFGGcmToken = this.this$0;
            Intrinsics.checkExpressionValueIsNotNull(token, "token");
            rFGGcmToken.refreshToken(token);
        }
    }
}
