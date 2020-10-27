package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;

public final class zzarr {
    private float zzbpk;
    private int zzdji;
    private int zzdjj;
    private int zzdpr;
    private boolean zzdps;
    private boolean zzdpt;
    private int zzdpu;
    private int zzdpv;
    private int zzdpw;
    private String zzdpx;
    private int zzdpy;
    private int zzdpz;
    private int zzdqa;
    private boolean zzdqb;
    private int zzdqc;
    private double zzdqd;
    private boolean zzdqe;
    private String zzdqf;
    private String zzdqg;
    private boolean zzdqh;
    private boolean zzdqi;
    private String zzdqj;
    private boolean zzdqk;
    private final boolean zzdql;
    private boolean zzdqm;
    private String zzdqn;
    private String zzdqo;
    private String zzdqp;
    private boolean zzdqq;

    public zzarr(Context context) {
        DisplayMetrics displayMetrics;
        PackageManager packageManager = context.getPackageManager();
        zzt(context);
        zzu(context);
        zzv(context);
        Locale locale = Locale.getDefault();
        boolean z = true;
        this.zzdqh = zza(packageManager, "geo:0,0?q=donuts") != null;
        this.zzdqi = zza(packageManager, "http://www.google.com") == null ? false : z;
        this.zzdqj = locale.getCountry();
        zzvj.zzpr();
        this.zzdqk = zzazm.zzyd();
        this.zzdql = DeviceProperties.isLatchsky(context);
        this.zzdqm = DeviceProperties.isSidewinder(context);
        this.zzdqn = locale.getLanguage();
        this.zzdqo = zza(context, packageManager);
        this.zzdqp = zzw(context);
        Resources resources = context.getResources();
        if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            this.zzbpk = displayMetrics.density;
            this.zzdji = displayMetrics.widthPixels;
            this.zzdjj = displayMetrics.heightPixels;
        }
    }

    public zzarr(Context context, zzars zzars) {
        zzt(context);
        zzu(context);
        zzv(context);
        this.zzdqf = Build.FINGERPRINT;
        this.zzdqg = Build.DEVICE;
        this.zzdqq = PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzaaw.zzj(context);
        this.zzdqh = zzars.zzdqh;
        this.zzdqi = zzars.zzdqi;
        this.zzdqj = zzars.zzdqj;
        this.zzdqk = zzars.zzdqk;
        this.zzdql = zzars.zzdql;
        this.zzdqm = zzars.zzdqm;
        this.zzdqn = zzars.zzdqn;
        this.zzdqo = zzars.zzdqo;
        this.zzdqp = zzars.zzdqp;
        this.zzbpk = zzars.zzbpk;
        this.zzdji = zzars.zzdji;
        this.zzdjj = zzars.zzdjj;
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            zzq.zzla().zza(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    private static String zza(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza == null || (activityInfo = zza.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = activityInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private final void zzt(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.zzdpr = audioManager.getMode();
                this.zzdps = audioManager.isMusicActive();
                this.zzdpt = audioManager.isSpeakerphoneOn();
                this.zzdpu = audioManager.getStreamVolume(3);
                this.zzdpv = audioManager.getRingerMode();
                this.zzdpw = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                zzq.zzla().zza(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.zzdpr = -2;
        this.zzdps = false;
        this.zzdpt = false;
        this.zzdpu = 0;
        this.zzdpv = 2;
        this.zzdpw = 0;
    }

    @TargetApi(16)
    private final void zzu(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.zzdpx = telephonyManager.getNetworkOperator();
        this.zzdpz = telephonyManager.getNetworkType();
        this.zzdqa = telephonyManager.getPhoneType();
        this.zzdpy = -2;
        this.zzdqb = false;
        this.zzdqc = -1;
        zzq.zzkw();
        if (zzaxa.zzq(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.zzdpy = activeNetworkInfo.getType();
                this.zzdqc = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                this.zzdpy = -1;
            }
            this.zzdqb = connectivityManager.isActiveNetworkMetered();
        }
    }

    private final void zzv(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
            this.zzdqd = (double) (((float) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
            this.zzdqe = z;
            return;
        }
        this.zzdqd = -1.0d;
        this.zzdqe = false;
    }

    private static String zzw(Context context) {
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.vending", 128);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = packageInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final zzars zzvb() {
        return new zzars(this.zzdpr, this.zzdqh, this.zzdqi, this.zzdpx, this.zzdqj, this.zzdqk, this.zzdql, this.zzdqm, this.zzdps, this.zzdpt, this.zzdqn, this.zzdqo, this.zzdqp, this.zzdpu, this.zzdpy, this.zzdpz, this.zzdqa, this.zzdpv, this.zzdpw, this.zzbpk, this.zzdji, this.zzdjj, this.zzdqd, this.zzdqe, this.zzdqb, this.zzdqc, this.zzdqf, this.zzdqq, this.zzdqg);
    }
}
