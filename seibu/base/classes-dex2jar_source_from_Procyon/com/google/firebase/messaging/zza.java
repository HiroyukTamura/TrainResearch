// 
// Decompiled by Procyon v0.5.36
// 

package com.google.firebase.messaging;

import java.util.List;
import android.support.v4.app.NotificationCompat;
import android.os.Parcelable;
import android.media.RingtoneManager;
import android.app.ActivityManager$RunningAppProcessInfo;
import android.app.ActivityManager;
import android.os.Process;
import android.app.KeyguardManager;
import android.content.res.Resources;
import java.util.MissingFormatArgumentException;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONArray;
import com.google.android.gms.R;
import android.app.NotificationManager;
import com.google.android.gms.common.util.zzq;
import android.content.res.Resources$NotFoundException;
import android.support.v4.content.ContextCompat;
import android.graphics.Color;
import android.os.Build$VERSION;
import java.util.Iterator;
import android.content.Intent;
import android.annotation.TargetApi;
import java.lang.reflect.InvocationTargetException;
import android.util.Log;
import android.app.Notification$Style;
import android.app.Notification$BigTextStyle;
import android.app.Notification$Builder;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;
import java.lang.reflect.Method;
import android.os.Bundle;
import android.content.Context;

final class zza
{
    private static zza zzckS;
    private final Context mContext;
    private Bundle zzaFE;
    private Method zzckT;
    private Method zzckU;
    private final AtomicInteger zzckV;
    
    private zza(final Context context) {
        this.zzckV = new AtomicInteger((int)SystemClock.elapsedRealtime());
        this.mContext = context.getApplicationContext();
    }
    
    static boolean zzG(final Bundle bundle) {
        return "1".equals(zze(bundle, "gcm.n.e")) || zze(bundle, "gcm.n.icon") != null;
    }
    
    @Nullable
    static Uri zzH(@NonNull final Bundle bundle) {
        String s;
        if (TextUtils.isEmpty((CharSequence)(s = zze(bundle, "gcm.n.link_android")))) {
            s = zze(bundle, "gcm.n.link");
        }
        if (!TextUtils.isEmpty((CharSequence)s)) {
            return Uri.parse(s);
        }
        return null;
    }
    
    static String zzI(final Bundle bundle) {
        String s;
        if (TextUtils.isEmpty((CharSequence)(s = zze(bundle, "gcm.n.sound2")))) {
            s = zze(bundle, "gcm.n.sound");
        }
        return s;
    }
    
    private final Bundle zzKb() {
        if (this.zzaFE != null) {
            return this.zzaFE;
        }
        ApplicationInfo applicationInfo = null;
        while (true) {
            try {
                applicationInfo = this.mContext.getPackageManager().getApplicationInfo(this.mContext.getPackageName(), 128);
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    return this.zzaFE = applicationInfo.metaData;
                }
                return Bundle.EMPTY;
            }
            catch (PackageManager$NameNotFoundException ex) {
                continue;
            }
            break;
        }
    }
    
    @TargetApi(26)
    private final Notification zza(final CharSequence contentTitle, final String contentText, final int smallIcon, final Integer n, final Uri sound, final PendingIntent contentIntent, final PendingIntent deleteIntent, final String s) {
        final Notification$Builder setSmallIcon = new Notification$Builder(this.mContext).setAutoCancel(true).setSmallIcon(smallIcon);
        if (!TextUtils.isEmpty(contentTitle)) {
            setSmallIcon.setContentTitle(contentTitle);
        }
        if (!TextUtils.isEmpty((CharSequence)contentText)) {
            setSmallIcon.setContentText((CharSequence)contentText);
            setSmallIcon.setStyle((Notification$Style)new Notification$BigTextStyle().bigText((CharSequence)contentText));
        }
        if (n != null) {
            setSmallIcon.setColor((int)n);
        }
        if (sound != null) {
            setSmallIcon.setSound(sound);
        }
        if (contentIntent != null) {
            setSmallIcon.setContentIntent(contentIntent);
        }
        if (deleteIntent != null) {
            setSmallIcon.setDeleteIntent(deleteIntent);
        }
        Label_0175: {
            if (s == null) {
                break Label_0175;
            }
            try {
                if (this.zzckT == null) {
                    this.zzckT = setSmallIcon.getClass().getMethod("setChannel", String.class);
                }
                this.zzckT.invoke(setSmallIcon, s);
                return setSmallIcon.build();
            }
            catch (NoSuchMethodException ex) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", (Throwable)ex);
                return setSmallIcon.build();
            }
            catch (IllegalAccessException ex2) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", (Throwable)ex2);
                return setSmallIcon.build();
            }
            catch (InvocationTargetException ex3) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", (Throwable)ex3);
                return setSmallIcon.build();
            }
            catch (SecurityException ex4) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", (Throwable)ex4);
                return setSmallIcon.build();
            }
            catch (IllegalArgumentException ex5) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", (Throwable)ex5);
                return setSmallIcon.build();
            }
            catch (LinkageError linkageError) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", (Throwable)linkageError);
                return setSmallIcon.build();
            }
        }
    }
    
    private static void zza(final Intent intent, final Bundle bundle) {
        for (final String s : bundle.keySet()) {
            if (s.startsWith("google.c.a.") || s.equals("from")) {
                intent.putExtra(s, bundle.getString(s));
            }
        }
    }
    
    static zza zzbM(final Context context) {
        synchronized (zza.class) {
            if (zza.zzckS == null) {
                zza.zzckS = new zza(context);
            }
            return zza.zzckS;
        }
    }
    
    static String zze(final Bundle bundle, final String s) {
        String s2;
        if ((s2 = bundle.getString(s)) == null) {
            s2 = bundle.getString(s.replace("gcm.n.", "gcm.notification."));
        }
        return s2;
    }
    
    static String zzh(final Bundle bundle, String s) {
        s = String.valueOf(s);
        final String value = String.valueOf("_loc_key");
        if (value.length() != 0) {
            s = s.concat(value);
        }
        else {
            s = new String(s);
        }
        return zze(bundle, s);
    }
    
    private final Integer zzhr(final String s) {
        if (Build$VERSION.SDK_INT >= 21) {
            if (!TextUtils.isEmpty((CharSequence)s)) {
                try {
                    return Color.parseColor(s);
                }
                catch (IllegalArgumentException ex) {
                    Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(s).length() + 54).append("Color ").append(s).append(" not valid. Notification will use default color.").toString());
                }
            }
            final int int1 = this.zzKb().getInt("com.google.firebase.messaging.default_notification_color", 0);
            if (int1 != 0) {
                try {
                    return ContextCompat.getColor(this.mContext, int1);
                }
                catch (Resources$NotFoundException ex2) {
                    Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
                    return null;
                }
            }
        }
        return null;
    }
    
    @TargetApi(26)
    private final String zzhs(String string) {
        if (zzq.isAtLeastO()) {
            final NotificationManager notificationManager = (NotificationManager)this.mContext.getSystemService((Class)NotificationManager.class);
            try {
                if (this.zzckU == null) {
                    this.zzckU = notificationManager.getClass().getMethod("getNotificationChannel", String.class);
                }
                if (!TextUtils.isEmpty((CharSequence)string)) {
                    final String s = string;
                    if (this.zzckU.invoke(notificationManager, string) != null) {
                        return s;
                    }
                    Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(string).length() + 122).append("Notification Channel requested (").append(string).append(") has not been created by the app. Manifest configuration, or default, value will be used.").toString());
                }
                string = this.zzKb().getString("com.google.firebase.messaging.default_notification_channel_id");
                if (!TextUtils.isEmpty((CharSequence)string)) {
                    final String s = string;
                    if (this.zzckU.invoke(notificationManager, string) != null) {
                        return s;
                    }
                    Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                }
                else {
                    Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                }
                if (this.zzckU.invoke(notificationManager, "fcm_fallback_notification_channel") == null) {
                    final Class<?> forName = Class.forName("android.app.NotificationChannel");
                    notificationManager.getClass().getMethod("createNotificationChannel", forName).invoke(notificationManager, forName.getConstructor(String.class, CharSequence.class, Integer.TYPE).newInstance("fcm_fallback_notification_channel", this.mContext.getString(R.string.fcm_fallback_notification_channel_label), 3));
                }
            }
            catch (InstantiationException ex) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", (Throwable)ex);
            }
            catch (InvocationTargetException ex2) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", (Throwable)ex2);
                goto Label_0315;
            }
            catch (NoSuchMethodException ex3) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", (Throwable)ex3);
                goto Label_0315;
            }
            catch (IllegalAccessException ex4) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", (Throwable)ex4);
                goto Label_0315;
            }
            catch (ClassNotFoundException ex5) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", (Throwable)ex5);
                goto Label_0315;
            }
            catch (SecurityException ex6) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", (Throwable)ex6);
                goto Label_0315;
            }
            catch (IllegalArgumentException ex7) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", (Throwable)ex7);
                goto Label_0315;
            }
            catch (LinkageError linkageError) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel", (Throwable)linkageError);
                goto Label_0315;
            }
            return "fcm_fallback_notification_channel";
        }
        return null;
    }
    
    static Object[] zzi(final Bundle bundle, String value) {
        final String value2 = String.valueOf(value);
        final String value3 = String.valueOf("_loc_args");
        String concat;
        if (value3.length() != 0) {
            concat = value2.concat(value3);
        }
        else {
            concat = new String(value2);
        }
        final String zze = zze(bundle, concat);
        Object[] array;
        if (TextUtils.isEmpty((CharSequence)zze)) {
            array = null;
        }
        else {
            try {
                final JSONArray jsonArray = new JSONArray(zze);
                final String[] array2 = new String[jsonArray.length()];
                int n = 0;
                while (true) {
                    array = array2;
                    if (n >= array2.length) {
                        break;
                    }
                    array2[n] = (String)jsonArray.opt(n);
                    ++n;
                }
            }
            catch (JSONException ex) {
                final String value4 = String.valueOf(value);
                value = String.valueOf("_loc_args");
                String concat2;
                if (value.length() != 0) {
                    concat2 = value4.concat(value);
                }
                else {
                    concat2 = new String(value4);
                }
                final String value5 = String.valueOf(concat2.substring(6));
                Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(value5).length() + 41 + String.valueOf(zze).length()).append("Malformed ").append(value5).append(": ").append(zze).append("  Default value will be used.").toString());
                return null;
            }
        }
        return array;
    }
    
    private final String zzj(Bundle zzi, String s) {
        final String zze = zze(zzi, s);
        if (!TextUtils.isEmpty((CharSequence)zze)) {
            return zze;
        }
        final String zzh = zzh(zzi, s);
        if (TextUtils.isEmpty((CharSequence)zzh)) {
            return null;
        }
        final Resources resources = this.mContext.getResources();
        final int identifier = resources.getIdentifier(zzh, "string", this.mContext.getPackageName());
        if (identifier == 0) {
            final String value = String.valueOf(s);
            s = String.valueOf("_loc_key");
            String concat;
            if (s.length() != 0) {
                concat = value.concat(s);
            }
            else {
                concat = new String(value);
            }
            final String value2 = String.valueOf(concat.substring(6));
            Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(value2).length() + 49 + String.valueOf(zzh).length()).append(value2).append(" resource not found: ").append(zzh).append(" Default value will be used.").toString());
            return null;
        }
        zzi = (Bundle)zzi(zzi, s);
        if (zzi == null) {
            return resources.getString(identifier);
        }
        try {
            s = resources.getString(identifier, (Object[])(Object)zzi);
            return s;
        }
        catch (MissingFormatArgumentException ex) {
            final String value3 = String.valueOf(Arrays.toString((Object[])(Object)zzi));
            Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(zzh).length() + 58 + String.valueOf(value3).length()).append("Missing format argument for ").append(zzh).append(": ").append(value3).append(" Default value will be used.").toString(), (Throwable)ex);
            return null;
        }
    }
    
    private final PendingIntent zzw(final Bundle bundle) {
        final String zze = zze(bundle, "gcm.n.click_action");
        Intent launchIntentForPackage;
        if (!TextUtils.isEmpty((CharSequence)zze)) {
            launchIntentForPackage = new Intent(zze);
            launchIntentForPackage.setPackage(this.mContext.getPackageName());
            launchIntentForPackage.setFlags(268435456);
        }
        else {
            final Uri zzH = zzH(bundle);
            if (zzH != null) {
                launchIntentForPackage = new Intent("android.intent.action.VIEW");
                launchIntentForPackage.setPackage(this.mContext.getPackageName());
                launchIntentForPackage.setData(zzH);
            }
            else {
                launchIntentForPackage = this.mContext.getPackageManager().getLaunchIntentForPackage(this.mContext.getPackageName());
                if (launchIntentForPackage == null) {
                    Log.w("FirebaseMessaging", "No activity found to launch app");
                }
            }
        }
        if (launchIntentForPackage == null) {
            return null;
        }
        launchIntentForPackage.addFlags(67108864);
        final Bundle bundle2 = new Bundle(bundle);
        FirebaseMessagingService.zzt(bundle2);
        launchIntentForPackage.putExtras(bundle2);
        for (final String s : bundle2.keySet()) {
            if (s.startsWith("gcm.n.") || s.startsWith("gcm.notification.")) {
                launchIntentForPackage.removeExtra(s);
            }
        }
        return PendingIntent.getActivity(this.mContext, this.zzckV.incrementAndGet(), launchIntentForPackage, 1073741824);
    }
    
    final boolean zzv(final Bundle bundle) {
        if ("1".equals(zze(bundle, "gcm.n.noui"))) {
            return true;
        }
    Label_0127:
        while (true) {
            Label_0138: {
                if (((KeyguardManager)this.mContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
                    break Label_0138;
                }
                if (!zzq.zzse()) {
                    SystemClock.sleep(10L);
                }
                final int myPid = Process.myPid();
                final List runningAppProcesses = ((ActivityManager)this.mContext.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    for (final ActivityManager$RunningAppProcessInfo activityManager$RunningAppProcessInfo : runningAppProcesses) {
                        if (activityManager$RunningAppProcessInfo.pid == myPid) {
                            if (activityManager$RunningAppProcessInfo.importance == 100) {
                                final int n = 1;
                                break Label_0127;
                            }
                            final int n = 0;
                            break Label_0127;
                        }
                    }
                }
                break Label_0138;
                int n = 0;
                if (n != 0) {
                    return false;
                }
                CharSequence contentTitle;
                if (TextUtils.isEmpty(contentTitle = this.zzj(bundle, "gcm.n.title"))) {
                    contentTitle = this.mContext.getApplicationInfo().loadLabel(this.mContext.getPackageManager());
                }
                final String zzj = this.zzj(bundle, "gcm.n.body");
                final String zze = zze(bundle, "gcm.n.icon");
                while (true) {
                    Label_0586: {
                        if (TextUtils.isEmpty((CharSequence)zze)) {
                            break Label_0586;
                        }
                        final Resources resources = this.mContext.getResources();
                        int smallIcon = resources.getIdentifier(zze, "drawable", this.mContext.getPackageName());
                        if (smallIcon == 0 && (smallIcon = resources.getIdentifier(zze, "mipmap", this.mContext.getPackageName())) == 0) {
                            Log.w("FirebaseMessaging", new StringBuilder(String.valueOf(zze).length() + 61).append("Icon resource ").append(zze).append(" not found. Notification will use default icon.").toString());
                            break Label_0586;
                        }
                        final Integer zzhr = this.zzhr(zze(bundle, "gcm.n.color"));
                        final String zzI = zzI(bundle);
                        Uri sound;
                        if (TextUtils.isEmpty((CharSequence)zzI)) {
                            sound = null;
                        }
                        else if (!"default".equals(zzI) && this.mContext.getResources().getIdentifier(zzI, "raw", this.mContext.getPackageName()) != 0) {
                            final String value = String.valueOf("android.resource://");
                            final String value2 = String.valueOf(this.mContext.getPackageName());
                            sound = Uri.parse(new StringBuilder(String.valueOf(value).length() + 5 + String.valueOf(value2).length() + String.valueOf(zzI).length()).append(value).append(value2).append("/raw/").append(zzI).toString());
                        }
                        else {
                            sound = RingtoneManager.getDefaultUri(2);
                        }
                        PendingIntent contentIntent = this.zzw(bundle);
                        PendingIntent zzb;
                        if (FirebaseMessagingService.zzJ(bundle)) {
                            final Intent intent = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
                            zza(intent, bundle);
                            intent.putExtra("pending_intent", (Parcelable)contentIntent);
                            contentIntent = com.google.firebase.iid.zzq.zzb(this.mContext, this.zzckV.incrementAndGet(), intent, 1073741824);
                            final Intent intent2 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
                            zza(intent2, bundle);
                            zzb = com.google.firebase.iid.zzq.zzb(this.mContext, this.zzckV.incrementAndGet(), intent2, 1073741824);
                        }
                        else {
                            zzb = null;
                        }
                        Notification notification;
                        if (zzq.isAtLeastO() && this.mContext.getApplicationInfo().targetSdkVersion > 25) {
                            notification = this.zza(contentTitle, zzj, smallIcon, zzhr, sound, contentIntent, zzb, this.zzhs(zze(bundle, "gcm.n.android_channel_id")));
                        }
                        else {
                            final NotificationCompat.Builder setSmallIcon = new NotificationCompat.Builder(this.mContext).setAutoCancel(true).setSmallIcon(smallIcon);
                            if (!TextUtils.isEmpty(contentTitle)) {
                                setSmallIcon.setContentTitle(contentTitle);
                            }
                            if (!TextUtils.isEmpty((CharSequence)zzj)) {
                                setSmallIcon.setContentText(zzj);
                                setSmallIcon.setStyle(new NotificationCompat.BigTextStyle().bigText(zzj));
                            }
                            if (zzhr != null) {
                                setSmallIcon.setColor(zzhr);
                            }
                            if (sound != null) {
                                setSmallIcon.setSound(sound);
                            }
                            if (contentIntent != null) {
                                setSmallIcon.setContentIntent(contentIntent);
                            }
                            if (zzb != null) {
                                setSmallIcon.setDeleteIntent(zzb);
                            }
                            notification = setSmallIcon.build();
                        }
                        final String zze2 = zze(bundle, "gcm.n.tag");
                        if (Log.isLoggable("FirebaseMessaging", 3)) {
                            Log.d("FirebaseMessaging", "Showing notification");
                        }
                        final NotificationManager notificationManager = (NotificationManager)this.mContext.getSystemService("notification");
                        String string = zze2;
                        if (TextUtils.isEmpty((CharSequence)zze2)) {
                            string = new StringBuilder(37).append("FCM-Notification:").append(SystemClock.uptimeMillis()).toString();
                        }
                        notificationManager.notify(string, 0, notification);
                        return true;
                    }
                    int n2;
                    if ((n2 = this.zzKb().getInt("com.google.firebase.messaging.default_notification_icon", 0)) == 0) {
                        n2 = this.mContext.getApplicationInfo().icon;
                    }
                    int n3;
                    if ((n3 = n2) == 0) {
                        n3 = 17301651;
                    }
                    int smallIcon = n3;
                    continue;
                }
            }
            final int n = 0;
            continue Label_0127;
        }
    }
}
