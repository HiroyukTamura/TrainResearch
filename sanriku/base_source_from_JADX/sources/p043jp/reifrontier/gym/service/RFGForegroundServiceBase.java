package p043jp.reifrontier.gym.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import p043jp.reifrontier.gym.domain.RFGNotification;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¤\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¤\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\bX¤\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0012\u0010\r\u001a\u00020\bX¤\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\n¨\u0006\u0019"}, mo21739d2 = {"Ljp/reifrontier/gym/service/RFGForegroundServiceBase;", "Landroid/app/Service;", "()V", "foregroundNotificationId", "", "getForegroundNotificationId", "()I", "notificationChannelId", "", "getNotificationChannelId", "()Ljava/lang/String;", "notificationChannelName", "getNotificationChannelName", "notificationContentTitle", "getNotificationContentTitle", "createNotification", "Landroid/app/Notification;", "onCreate", "", "onStartCommand", "intent", "Landroid/content/Intent;", "flags", "startId", "startForeground", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.service.RFGForegroundServiceBase */
public abstract class RFGForegroundServiceBase extends Service {
    @RequiresApi(26)
    private final Notification createNotification() {
        return new RFGNotification.Builder(this, getNotificationChannelId(), getNotificationChannelName()).setSmallIcon(R.mipmap.ic_notification).setContentTitle(getNotificationContentTitle()).setContentText("").setAutoCancel(true).setOngoing(true).setImportance(0).setLightColor(-16776961).build().getNotification();
    }

    private final void startForeground() {
        if (Build.VERSION.SDK_INT >= 26) {
            startForeground(getForegroundNotificationId(), createNotification());
        }
    }

    /* access modifiers changed from: protected */
    public abstract int getForegroundNotificationId();

    /* access modifiers changed from: protected */
    public abstract String getNotificationChannelId();

    /* access modifiers changed from: protected */
    public abstract String getNotificationChannelName();

    /* access modifiers changed from: protected */
    public abstract String getNotificationContentTitle();

    public void onCreate() {
        super.onCreate();
        startForeground();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return 1;
    }
}
