package p043jp.reifrontier.gym.domain;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0003J\b\u0010\t\u001a\u00020\u0006H\u0003J\u0006\u0010\n\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/RFGNotification;", "", "builder", "Ljp/reifrontier/gym/domain/RFGNotification$Builder;", "(Ljp/reifrontier/gym/domain/RFGNotification$Builder;)V", "createNotification", "Landroid/app/Notification;", "createNotificationChannel", "Landroid/app/NotificationChannel;", "createNotificationOreo", "getNotification", "showNotification", "", "notificationId", "", "Builder", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.gym.domain.RFGNotification */
public final class RFGNotification {
    private final Builder builder;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\tJ\u000e\u00104\u001a\u00020\u00002\u0006\u00105\u001a\u00020%J\u000e\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u0011J\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u0011J\u0010\u0010:\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0019H\u0007J\u000e\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u0019J\u000e\u0010=\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\tJ\u000e\u0010>\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010*\u001a\u00020)J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020-R$\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u000e¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\"\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00112\b\u0010\b\u001a\u0004\u0018\u00010\u0011@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\b\u001a\u0004\u0018\u00010\u0019@BX\u000e¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR \u0010\u001e\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u00198\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010\b\u001a\u0004\u0018\u00010\u0019@BX\u000e¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\"\u0010\u001cR$\u0010#\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\t@BX\u000e¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b$\u0010\fR\"\u0010&\u001a\u0004\u0018\u00010%2\b\u0010\b\u001a\u0004\u0018\u00010%@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\"\u0010*\u001a\u0004\u0018\u00010)2\b\u0010\b\u001a\u0004\u0018\u00010)@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\"\u0010.\u001a\u0004\u0018\u00010-2\b\u0010\b\u001a\u0004\u0018\u00010-@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006B"}, mo21739d2 = {"Ljp/reifrontier/gym/domain/RFGNotification$Builder;", "", "context", "Landroid/content/Context;", "channelId", "", "channelName", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "<set-?>", "", "autoCancel", "getAutoCancel", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getChannelId", "()Ljava/lang/String;", "getChannelName", "", "contentText", "getContentText", "()Ljava/lang/CharSequence;", "contentTitle", "getContentTitle", "getContext", "()Landroid/content/Context;", "", "icon", "getIcon", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "importance", "getImportance", "()I", "lightColor", "getLightColor", "ongoing", "getOngoing", "Landroid/app/PendingIntent;", "pendingIntent", "getPendingIntent", "()Landroid/app/PendingIntent;", "Landroid/net/Uri;", "sound", "getSound", "()Landroid/net/Uri;", "", "vibrate", "getVibrate", "()[J", "build", "Ljp/reifrontier/gym/domain/RFGNotification;", "setAutoCancel", "setContentIntent", "intent", "setContentText", "text", "setContentTitle", "title", "setImportance", "setLightColor", "argb", "setOngoing", "setSmallIcon", "setSound", "setVibrate", "pattern", "app_productionRelease"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.gym.domain.RFGNotification$Builder */
    public static final class Builder {
        private Boolean autoCancel;
        private final String channelId;
        private final String channelName;
        private CharSequence contentText;
        private CharSequence contentTitle;
        private final Context context;
        private Integer icon;
        @RequiresApi(26)
        private int importance = 3;
        private Integer lightColor;
        private Boolean ongoing;
        private PendingIntent pendingIntent;
        private Uri sound;
        private long[] vibrate;

        public Builder(Context context2, String str, String str2) {
            Intrinsics.checkParameterIsNotNull(context2, "context");
            Intrinsics.checkParameterIsNotNull(str, "channelId");
            Intrinsics.checkParameterIsNotNull(str2, "channelName");
            this.context = context2;
            this.channelId = str;
            this.channelName = str2;
        }

        public final RFGNotification build() {
            return new RFGNotification(this);
        }

        public final Boolean getAutoCancel() {
            return this.autoCancel;
        }

        public final String getChannelId() {
            return this.channelId;
        }

        public final String getChannelName() {
            return this.channelName;
        }

        public final CharSequence getContentText() {
            return this.contentText;
        }

        public final CharSequence getContentTitle() {
            return this.contentTitle;
        }

        public final Context getContext() {
            return this.context;
        }

        public final Integer getIcon() {
            return this.icon;
        }

        public final int getImportance() {
            return this.importance;
        }

        public final Integer getLightColor() {
            return this.lightColor;
        }

        public final Boolean getOngoing() {
            return this.ongoing;
        }

        public final PendingIntent getPendingIntent() {
            return this.pendingIntent;
        }

        public final Uri getSound() {
            return this.sound;
        }

        public final long[] getVibrate() {
            return this.vibrate;
        }

        public final Builder setAutoCancel(boolean z) {
            this.autoCancel = Boolean.valueOf(z);
            return this;
        }

        public final Builder setContentIntent(PendingIntent pendingIntent2) {
            Intrinsics.checkParameterIsNotNull(pendingIntent2, "intent");
            this.pendingIntent = pendingIntent2;
            return this;
        }

        public final Builder setContentText(CharSequence charSequence) {
            Intrinsics.checkParameterIsNotNull(charSequence, "text");
            this.contentText = charSequence;
            return this;
        }

        public final Builder setContentTitle(CharSequence charSequence) {
            Intrinsics.checkParameterIsNotNull(charSequence, "title");
            this.contentTitle = charSequence;
            return this;
        }

        @RequiresApi(26)
        public final Builder setImportance(int i) {
            this.importance = i;
            return this;
        }

        public final Builder setLightColor(int i) {
            this.lightColor = Integer.valueOf(i);
            return this;
        }

        public final Builder setOngoing(boolean z) {
            this.ongoing = Boolean.valueOf(z);
            return this;
        }

        public final Builder setSmallIcon(int i) {
            this.icon = Integer.valueOf(i);
            return this;
        }

        public final Builder setSound(Uri uri) {
            Intrinsics.checkParameterIsNotNull(uri, "sound");
            this.sound = uri;
            return this;
        }

        public final Builder setVibrate(long[] jArr) {
            Intrinsics.checkParameterIsNotNull(jArr, "pattern");
            this.vibrate = jArr;
            return this;
        }
    }

    public RFGNotification(Builder builder2) {
        Intrinsics.checkParameterIsNotNull(builder2, "builder");
        this.builder = builder2;
    }

    private final Notification createNotification() {
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this.builder.getContext(), this.builder.getContext().getPackageName());
        Integer icon = this.builder.getIcon();
        if (icon != null) {
            builder2.setSmallIcon(icon.intValue());
        }
        CharSequence contentTitle = this.builder.getContentTitle();
        if (contentTitle != null) {
            builder2.setContentTitle(contentTitle);
        }
        CharSequence contentText = this.builder.getContentText();
        if (contentText != null) {
            builder2.setContentText(contentText);
        }
        Boolean autoCancel = this.builder.getAutoCancel();
        if (autoCancel != null) {
            builder2.setAutoCancel(autoCancel.booleanValue());
        }
        PendingIntent pendingIntent = this.builder.getPendingIntent();
        if (pendingIntent != null) {
            builder2.setContentIntent(pendingIntent);
        }
        Boolean ongoing = this.builder.getOngoing();
        if (ongoing != null) {
            builder2.setOngoing(ongoing.booleanValue());
        }
        long[] vibrate = this.builder.getVibrate();
        if (vibrate != null) {
            builder2.setVibrate(vibrate);
        }
        Uri sound = this.builder.getSound();
        if (sound != null) {
            builder2.setSound(sound);
        }
        Integer lightColor = this.builder.getLightColor();
        if (lightColor != null) {
            builder2.setLights(lightColor.intValue(), 1000, 500);
        }
        Notification build = builder2.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "notificationBuilder.build()");
        return build;
    }

    @RequiresApi(26)
    private final NotificationChannel createNotificationChannel() {
        NotificationChannel notificationChannel = new NotificationChannel(this.builder.getChannelId(), this.builder.getChannelName(), this.builder.getImportance());
        notificationChannel.setLockscreenVisibility(0);
        Uri sound = this.builder.getSound();
        if (sound != null) {
            notificationChannel.setSound(sound, new AudioAttributes.Builder().setContentType(4).setUsage(6).build());
        }
        Integer lightColor = this.builder.getLightColor();
        if (lightColor != null) {
            notificationChannel.setLightColor(lightColor.intValue());
        }
        long[] vibrate = this.builder.getVibrate();
        if (vibrate != null) {
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(vibrate);
        }
        Object systemService = this.builder.getContext().getSystemService("notification");
        if (systemService != null) {
            ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
            return notificationChannel;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
    }

    @RequiresApi(26)
    private final Notification createNotificationOreo() {
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this.builder.getContext(), createNotificationChannel().getId());
        Integer icon = this.builder.getIcon();
        if (icon != null) {
            builder2.setSmallIcon(icon.intValue());
        }
        CharSequence contentTitle = this.builder.getContentTitle();
        if (contentTitle != null) {
            builder2.setContentTitle(contentTitle);
        }
        CharSequence contentText = this.builder.getContentText();
        if (contentText != null) {
            builder2.setContentText(contentText);
        }
        Boolean autoCancel = this.builder.getAutoCancel();
        if (autoCancel != null) {
            builder2.setAutoCancel(autoCancel.booleanValue());
        }
        PendingIntent pendingIntent = this.builder.getPendingIntent();
        if (pendingIntent != null) {
            builder2.setContentIntent(pendingIntent);
        }
        Boolean ongoing = this.builder.getOngoing();
        if (ongoing != null) {
            builder2.setOngoing(ongoing.booleanValue());
        }
        Notification build = builder2.build();
        Intrinsics.checkExpressionValueIsNotNull(build, "notificationBuilder.build()");
        return build;
    }

    public final Notification getNotification() {
        return Build.VERSION.SDK_INT < 26 ? createNotification() : createNotificationOreo();
    }

    public final void showNotification(int i) {
        Object systemService = this.builder.getContext().getSystemService("notification");
        if (systemService != null) {
            ((NotificationManager) systemService).notify(i, getNotification());
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
    }
}
