package p043jp.reifrontier.gym.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001c\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¨\u0006\u000b"}, mo21739d2 = {"Ljp/reifrontier/gym/service/RFGBootReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onDeviceBoot", "", "context", "Landroid/content/Context;", "onReceive", "p0", "p1", "Landroid/content/Intent;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.service.RFGBootReceiver */
public final class RFGBootReceiver extends BroadcastReceiver {
    private final void onDeviceBoot(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intent intent = new Intent(applicationContext, RFGService.class);
        intent.putExtra("kRFL_TRIGGER", "BOOT");
        if (Build.VERSION.SDK_INT >= 26) {
            applicationContext.startForegroundService(intent);
        } else {
            applicationContext.startService(intent);
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            Intrinsics.throwNpe();
        }
        if (Intrinsics.areEqual((Object) "android.intent.action.BOOT_COMPLETED", (Object) intent.getAction())) {
            if (context == null) {
                Intrinsics.throwNpe();
            }
            onDeviceBoot(context);
        }
    }
}
