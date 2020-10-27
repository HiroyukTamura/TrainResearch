package p043jp.reifrontier.gym.service;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import com.google.android.gms.common.internal.BaseGmsClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.RFGDef;
import p043jp.reifrontier.gym.activity.RFGMainActivity;
import p043jp.reifrontier.gym.domain.RFGNotification;
import p043jp.reifrontier.sanriku.R;
import p043jp.reifrontier.silentlogsdkandroid.SilentLogOperation;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, mo21739d2 = {"Ljp/reifrontier/gym/service/RFGLocalPush;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "sendNotification", "", "title", "", "message", "showNotification", "triggerGeofenceId", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.service.RFGLocalPush */
public final class RFGLocalPush {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String NOTIFICATION_CHANNEL_ID = "RFGLocalPush";
    private static final String NOTIFICATION_CHANNEL_NAME = "GeoFenceEnter";
    private static final String NOTIFICATION_CONTENT_MESSAGE = "チェックイン場所に近づきました！";
    private static final int NOTIFICATION_ID = 0;
    private final Context context;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/gym/service/RFGLocalPush$Companion;", "", "()V", "NOTIFICATION_CHANNEL_ID", "", "NOTIFICATION_CHANNEL_NAME", "NOTIFICATION_CONTENT_MESSAGE", "NOTIFICATION_ID", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.service.RFGLocalPush$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RFGLocalPush(Context context2) {
        Intrinsics.checkParameterIsNotNull(context2, "context");
        this.context = context2;
    }

    private final void sendNotification(String str, String str2) {
        Intent intent = new Intent(this.context, RFGMainActivity.class);
        intent.addFlags(67108864);
        PendingIntent activity = PendingIntent.getActivity(this.context, 0, intent, 1073741824);
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        RFGNotification.Builder autoCancel = new RFGNotification.Builder(this.context, NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_NAME).setSmallIcon(R.mipmap.ic_notification).setContentTitle(str).setContentText(str2).setVibrate(new long[]{0, 1000, 1000, 1000, 1000}).setAutoCancel(true);
        Intrinsics.checkExpressionValueIsNotNull(defaultUri, "notificationSound");
        RFGNotification.Builder sound = autoCancel.setSound(defaultUri);
        Intrinsics.checkExpressionValueIsNotNull(activity, BaseGmsClient.KEY_PENDING_INTENT);
        sound.setContentIntent(activity).build().showNotification(0);
    }

    public final void showNotification(String str) {
        Intrinsics.checkParameterIsNotNull(str, "triggerGeofenceId");
        if (RFGDef.C2097T.INSTANCE.walkTime()) {
            sendNotification(str, NOTIFICATION_CONTENT_MESSAGE);
        } else {
            SilentLogOperation.Companion.getInstance().stopGeofence();
        }
    }
}
