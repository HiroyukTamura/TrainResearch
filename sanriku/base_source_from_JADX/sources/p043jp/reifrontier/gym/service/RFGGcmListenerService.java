package p043jp.reifrontier.gym.service;

import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.gym.activity.RFGMainActivity;
import p043jp.reifrontier.gym.domain.RFGNotification;
import p043jp.reifrontier.gym.domain.gcm.RFGGcmToken;
import p043jp.reifrontier.sanriku.R;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0002¨\u0006\u000e"}, mo21739d2 = {"Ljp/reifrontier/gym/service/RFGGcmListenerService;", "Lcom/google/firebase/messaging/FirebaseMessagingService;", "()V", "onMessageReceived", "", "remoteMessage", "Lcom/google/firebase/messaging/RemoteMessage;", "onNewToken", "token", "", "sendNotification", "title", "message", "Companion", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.service.RFGGcmListenerService */
public final class RFGGcmListenerService extends FirebaseMessagingService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String NOTIFICATION_CHANNEL_ID = "RFGGcmListenerService";
    private static final String NOTIFICATION_CHANNEL_NAME = "MessageReceived";
    private static final int NOTIFICATION_ID = 0;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo21739d2 = {"Ljp/reifrontier/gym/service/RFGGcmListenerService$Companion;", "", "()V", "NOTIFICATION_CHANNEL_ID", "", "NOTIFICATION_CHANNEL_NAME", "NOTIFICATION_ID", "", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.service.RFGGcmListenerService$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void sendNotification(String str, String str2) {
        Intent intent = new Intent(this, RFGMainActivity.class);
        intent.addFlags(67108864);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 1073741824);
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        RFGNotification.Builder autoCancel = new RFGNotification.Builder(this, NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_NAME).setSmallIcon(R.mipmap.ic_notification).setContentTitle(str).setContentText(str2).setVibrate(new long[]{0, 1000, 1000, 1000, 1000}).setAutoCancel(true);
        Intrinsics.checkExpressionValueIsNotNull(defaultUri, "defaultSoundUri");
        RFGNotification.Builder sound = autoCancel.setSound(defaultUri);
        Intrinsics.checkExpressionValueIsNotNull(activity, BaseGmsClient.KEY_PENDING_INTENT);
        sound.setContentIntent(activity).build().showNotification(0);
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Intrinsics.checkParameterIsNotNull(remoteMessage, "remoteMessage");
        String str = remoteMessage.getData().get("title");
        if (str == null) {
            str = "TITLE";
        }
        String str2 = remoteMessage.getData().get("message");
        if (str2 == null) {
            str2 = "";
        }
        sendNotification(str, str2);
    }

    public void onNewToken(String str) {
        Intrinsics.checkParameterIsNotNull(str, "token");
        new RFGGcmToken().refreshToken(str);
    }
}
