package p043jp.reifrontier.gym.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, mo21739d2 = {"triggerRebirth", "", "context", "Landroid/content/Context;", "app_productionRelease"}, mo21740k = 2, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.activity.RFGPhoenixKt */
public final class RFGPhoenixKt {
    public static final void triggerRebirth(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intent intent = new Intent(context, RFGPhoenix.class);
        intent.addFlags(268468224);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
        Runtime.getRuntime().exit(0);
    }
}
