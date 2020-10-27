package p043jp.reifrontier.gym.service;

import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\"\u0010\u0015\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006H\u0016R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0019"}, mo21739d2 = {"Ljp/reifrontier/gym/service/RFGForegroundService;", "Ljp/reifrontier/gym/service/RFGForegroundServiceBase;", "()V", "binder", "Ljp/reifrontier/gym/service/RFGForegroundService$RFGServiceBinder;", "foregroundNotificationId", "", "getForegroundNotificationId", "()I", "notificationChannelId", "", "getNotificationChannelId", "()Ljava/lang/String;", "notificationChannelName", "getNotificationChannelName", "notificationContentTitle", "getNotificationContentTitle", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "flags", "startId", "RFGServiceBinder", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.service.RFGForegroundService */
public final class RFGForegroundService extends RFGForegroundServiceBase {
    private final RFGServiceBinder binder = new RFGServiceBinder();
    private final int foregroundNotificationId = 1231;
    private final String notificationChannelId = "RFLForegroundService";
    private final String notificationChannelName = "LocationUpdate";
    private final String notificationContentTitle = "活動を記録中です";

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/gym/service/RFGForegroundService$RFGServiceBinder;", "Landroid/os/Binder;", "(Ljp/reifrontier/gym/service/RFGForegroundService;)V", "service", "Ljp/reifrontier/gym/service/RFGForegroundService;", "getService", "()Ljp/reifrontier/gym/service/RFGForegroundService;", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.service.RFGForegroundService$RFGServiceBinder */
    public final class RFGServiceBinder extends Binder {
        public RFGServiceBinder() {
        }

        public final RFGForegroundService getService() {
            return RFGForegroundService.this;
        }
    }

    /* access modifiers changed from: protected */
    public int getForegroundNotificationId() {
        return this.foregroundNotificationId;
    }

    /* access modifiers changed from: protected */
    public String getNotificationChannelId() {
        return this.notificationChannelId;
    }

    /* access modifiers changed from: protected */
    public String getNotificationChannelName() {
        return this.notificationChannelName;
    }

    /* access modifiers changed from: protected */
    public String getNotificationContentTitle() {
        return this.notificationContentTitle;
    }

    public IBinder onBind(Intent intent) {
        return this.binder;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return 1;
    }
}
