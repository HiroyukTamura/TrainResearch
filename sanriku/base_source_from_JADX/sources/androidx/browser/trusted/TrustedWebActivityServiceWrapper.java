package androidx.browser.trusted;

import android.app.Notification;
import android.content.ComponentName;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.customtabs.trusted.ITrustedWebActivityService;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import p009e.p010a.p011a.p012a.C0681a;

public class TrustedWebActivityServiceWrapper {
    private static final String KEY_ACTIVE_NOTIFICATIONS = "android.support.customtabs.trusted.ACTIVE_NOTIFICATIONS";
    private static final String KEY_CHANNEL_NAME = "android.support.customtabs.trusted.CHANNEL_NAME";
    private static final String KEY_NOTIFICATION = "android.support.customtabs.trusted.NOTIFICATION";
    private static final String KEY_NOTIFICATION_SUCCESS = "android.support.customtabs.trusted.NOTIFICATION_SUCCESS";
    private static final String KEY_PLATFORM_ID = "android.support.customtabs.trusted.PLATFORM_ID";
    private static final String KEY_PLATFORM_TAG = "android.support.customtabs.trusted.PLATFORM_TAG";
    private static final String REMOTE_EXCEPTION_MESSAGE = "RemoteException while trying to communicate with the TrustedWebActivityService, this is probably because the service died while attempting to respond. Check to see if the service crashed for some reason.";
    private final ComponentName mComponentName;
    private final ITrustedWebActivityService mService;

    static class ActiveNotificationsArgs {
        public final Parcelable[] notifications;

        ActiveNotificationsArgs(Parcelable[] parcelableArr) {
            this.notifications = parcelableArr;
        }

        public static ActiveNotificationsArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceWrapper.ensureBundleContains(bundle, TrustedWebActivityServiceWrapper.KEY_ACTIVE_NOTIFICATIONS);
            return new ActiveNotificationsArgs(bundle.getParcelableArray(TrustedWebActivityServiceWrapper.KEY_ACTIVE_NOTIFICATIONS));
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray(TrustedWebActivityServiceWrapper.KEY_ACTIVE_NOTIFICATIONS, this.notifications);
            return bundle;
        }
    }

    static class CancelNotificationArgs {
        public final int platformId;
        public final String platformTag;

        CancelNotificationArgs(String str, int i) {
            this.platformTag = str;
            this.platformId = i;
        }

        public static CancelNotificationArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceWrapper.ensureBundleContains(bundle, TrustedWebActivityServiceWrapper.KEY_PLATFORM_TAG);
            TrustedWebActivityServiceWrapper.ensureBundleContains(bundle, TrustedWebActivityServiceWrapper.KEY_PLATFORM_ID);
            return new CancelNotificationArgs(bundle.getString(TrustedWebActivityServiceWrapper.KEY_PLATFORM_TAG), bundle.getInt(TrustedWebActivityServiceWrapper.KEY_PLATFORM_ID));
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString(TrustedWebActivityServiceWrapper.KEY_PLATFORM_TAG, this.platformTag);
            bundle.putInt(TrustedWebActivityServiceWrapper.KEY_PLATFORM_ID, this.platformId);
            return bundle;
        }
    }

    static class NotificationsEnabledArgs {
        public final String channelName;

        NotificationsEnabledArgs(String str) {
            this.channelName = str;
        }

        public static NotificationsEnabledArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceWrapper.ensureBundleContains(bundle, TrustedWebActivityServiceWrapper.KEY_CHANNEL_NAME);
            return new NotificationsEnabledArgs(bundle.getString(TrustedWebActivityServiceWrapper.KEY_CHANNEL_NAME));
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString(TrustedWebActivityServiceWrapper.KEY_CHANNEL_NAME, this.channelName);
            return bundle;
        }
    }

    static class NotifyNotificationArgs {
        public final String channelName;
        public final Notification notification;
        public final int platformId;
        public final String platformTag;

        NotifyNotificationArgs(String str, int i, Notification notification2, String str2) {
            this.platformTag = str;
            this.platformId = i;
            this.notification = notification2;
            this.channelName = str2;
        }

        public static NotifyNotificationArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceWrapper.ensureBundleContains(bundle, TrustedWebActivityServiceWrapper.KEY_PLATFORM_TAG);
            TrustedWebActivityServiceWrapper.ensureBundleContains(bundle, TrustedWebActivityServiceWrapper.KEY_PLATFORM_ID);
            TrustedWebActivityServiceWrapper.ensureBundleContains(bundle, TrustedWebActivityServiceWrapper.KEY_NOTIFICATION);
            TrustedWebActivityServiceWrapper.ensureBundleContains(bundle, TrustedWebActivityServiceWrapper.KEY_CHANNEL_NAME);
            return new NotifyNotificationArgs(bundle.getString(TrustedWebActivityServiceWrapper.KEY_PLATFORM_TAG), bundle.getInt(TrustedWebActivityServiceWrapper.KEY_PLATFORM_ID), (Notification) bundle.getParcelable(TrustedWebActivityServiceWrapper.KEY_NOTIFICATION), bundle.getString(TrustedWebActivityServiceWrapper.KEY_CHANNEL_NAME));
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString(TrustedWebActivityServiceWrapper.KEY_PLATFORM_TAG, this.platformTag);
            bundle.putInt(TrustedWebActivityServiceWrapper.KEY_PLATFORM_ID, this.platformId);
            bundle.putParcelable(TrustedWebActivityServiceWrapper.KEY_NOTIFICATION, this.notification);
            bundle.putString(TrustedWebActivityServiceWrapper.KEY_CHANNEL_NAME, this.channelName);
            return bundle;
        }
    }

    static class ResultArgs {
        public final boolean success;

        ResultArgs(boolean z) {
            this.success = z;
        }

        public static ResultArgs fromBundle(Bundle bundle) {
            TrustedWebActivityServiceWrapper.ensureBundleContains(bundle, TrustedWebActivityServiceWrapper.KEY_NOTIFICATION_SUCCESS);
            return new ResultArgs(bundle.getBoolean(TrustedWebActivityServiceWrapper.KEY_NOTIFICATION_SUCCESS));
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBoolean(TrustedWebActivityServiceWrapper.KEY_NOTIFICATION_SUCCESS, this.success);
            return bundle;
        }
    }

    TrustedWebActivityServiceWrapper(@NonNull ITrustedWebActivityService iTrustedWebActivityService, @NonNull ComponentName componentName) {
        this.mService = iTrustedWebActivityService;
        this.mComponentName = componentName;
    }

    static void ensureBundleContains(Bundle bundle, String str) {
        if (!bundle.containsKey(str)) {
            throw new IllegalArgumentException(C0681a.m320a("Bundle must contain ", str));
        }
    }

    public boolean areNotificationsEnabled(@NonNull String str) {
        try {
            return ResultArgs.fromBundle(this.mService.areNotificationsEnabled(new NotificationsEnabledArgs(str).toBundle())).success;
        } catch (RemoteException e) {
            throw new RuntimeException("Failure when connecting to TrustedWebActivityService", e);
        }
    }

    public void cancel(@NonNull String str, int i) {
        try {
            this.mService.cancelNotification(new CancelNotificationArgs(str, i).toBundle());
        } catch (RemoteException e) {
            throw new RuntimeException(REMOTE_EXCEPTION_MESSAGE, e);
        }
    }

    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Parcelable[] getActiveNotifications() {
        try {
            return ActiveNotificationsArgs.fromBundle(this.mService.getActiveNotifications()).notifications;
        } catch (RemoteException e) {
            throw new RuntimeException(REMOTE_EXCEPTION_MESSAGE, e);
        }
    }

    @NonNull
    public ComponentName getComponentName() {
        return this.mComponentName;
    }

    @Nullable
    public Bitmap getSmallIconBitmap() {
        try {
            return (Bitmap) this.mService.getSmallIconBitmap().getParcelable(TrustedWebActivityService.KEY_SMALL_ICON_BITMAP);
        } catch (RemoteException e) {
            throw new RuntimeException(REMOTE_EXCEPTION_MESSAGE, e);
        }
    }

    public int getSmallIconId() {
        try {
            return this.mService.getSmallIconId();
        } catch (RemoteException e) {
            throw new RuntimeException(REMOTE_EXCEPTION_MESSAGE, e);
        }
    }

    public boolean notify(@NonNull String str, int i, @NonNull Notification notification, @NonNull String str2) {
        try {
            return ResultArgs.fromBundle(this.mService.notifyNotificationWithChannel(new NotifyNotificationArgs(str, i, notification, str2).toBundle())).success;
        } catch (RemoteException e) {
            throw new RuntimeException(REMOTE_EXCEPTION_MESSAGE, e);
        }
    }
}
