package p043jp.reifrontier.gym.domain.gcm;

import com.google.firebase.iid.FirebaseInstanceId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.data.shared.RFGShared;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/gcm/RFGGcmToken;", "", "()V", "refreshToken", "", "token", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.gcm.RFGGcmToken */
public final class RFGGcmToken {
    public final void refreshToken() {
        FirebaseInstanceId instance = FirebaseInstanceId.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "FirebaseInstanceId.getInstance()");
        instance.getInstanceId().addOnCompleteListener(new RFGGcmToken$refreshToken$1(this));
    }

    public final void refreshToken(String str) {
        Intrinsics.checkParameterIsNotNull(str, "token");
        if (!Intrinsics.areEqual((Object) str, (Object) RFGShared.INSTANCE.token())) {
            RFGShared.INSTANCE.setGCMToken(str);
        }
    }
}
