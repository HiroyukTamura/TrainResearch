package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.PowerManager;
import android.util.Log;
import androidx.annotation.GuardedBy;
import com.google.firebase.iid.zzao;
import java.io.IOException;
import p009e.p010a.p011a.p012a.C0681a;

final class zzad implements Runnable {
    private static final Object zzf = new Object();
    @GuardedBy("TOPIC_SYNC_TASK_LOCK")
    private static Boolean zzg;
    @GuardedBy("TOPIC_SYNC_TASK_LOCK")
    private static Boolean zzh;
    private final Context zza;
    private final zzao zzb;
    private final PowerManager.WakeLock zzc;
    /* access modifiers changed from: private */
    public final zzab zzd;
    private final long zze;

    zzad(zzab zzab, Context context, zzao zzao, long j) {
        this.zzd = zzab;
        this.zza = context;
        this.zze = j;
        this.zzb = zzao;
        this.zzc = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "wake:com.google.firebase.messaging");
    }

    private static boolean zza(Context context) {
        boolean booleanValue;
        synchronized (zzf) {
            Boolean valueOf = Boolean.valueOf(zzg == null ? zza(context, "android.permission.WAKE_LOCK", zzg) : zzg.booleanValue());
            zzg = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    private static boolean zza(Context context, String str, Boolean bool) {
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = context.checkCallingOrSelfPermission(str) == 0;
        if (!z && Log.isLoggable("FirebaseMessaging", 3)) {
            StringBuilder sb = new StringBuilder(C0681a.m336b(str, 142));
            sb.append("Missing Permission: ");
            sb.append(str);
            sb.append(". This permission should normally be included by the manifest merger, but may needed to be manually added to your manifest");
            Log.d("FirebaseMessaging", sb.toString());
        }
        return z;
    }

    /* access modifiers changed from: private */
    public final synchronized boolean zzb() {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.zza.getSystemService("connectivity");
        activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private static boolean zzb(Context context) {
        boolean booleanValue;
        synchronized (zzf) {
            Boolean valueOf = Boolean.valueOf(zzh == null ? zza(context, "android.permission.ACCESS_NETWORK_STATE", zzh) : zzh.booleanValue());
            zzh = valueOf;
            booleanValue = valueOf.booleanValue();
        }
        return booleanValue;
    }

    /* access modifiers changed from: private */
    public static boolean zzc() {
        if (!Log.isLoggable("FirebaseMessaging", 3)) {
            return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseMessaging", 3);
        }
        return true;
    }

    @SuppressLint({"Wakelock"})
    public final void run() {
        if (zza(this.zza)) {
            this.zzc.acquire(zzd.zza);
        }
        try {
            boolean z = true;
            this.zzd.zza(true);
            if (!this.zzb.zza()) {
                this.zzd.zza(false);
                if (zza(this.zza)) {
                    try {
                        this.zzc.release();
                    } catch (RuntimeException unused) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            } else if (!zzb(this.zza) || zzb()) {
                if (this.zzd.zzb()) {
                    this.zzd.zza(false);
                } else {
                    this.zzd.zza(this.zze);
                }
                if (zza(this.zza)) {
                    try {
                        this.zzc.release();
                    } catch (RuntimeException unused2) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            } else {
                zzac zzac = new zzac(this, this);
                if (!Log.isLoggable("FirebaseMessaging", 3)) {
                    if (Build.VERSION.SDK_INT != 23 || !Log.isLoggable("FirebaseMessaging", 3)) {
                        z = false;
                    }
                }
                if (z) {
                    Log.d("FirebaseMessaging", "Connectivity change received registered");
                }
                zzac.zza.zza.registerReceiver(zzac, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                if (zza(this.zza)) {
                    try {
                        this.zzc.release();
                    } catch (RuntimeException unused3) {
                        Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                    }
                }
            }
        } catch (IOException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.e("FirebaseMessaging", valueOf.length() != 0 ? "Failed to sync topics. Won't retry sync. ".concat(valueOf) : new String("Failed to sync topics. Won't retry sync. "));
            this.zzd.zza(false);
            if (zza(this.zza)) {
                try {
                    this.zzc.release();
                } catch (RuntimeException unused4) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
        } catch (Throwable th) {
            if (zza(this.zza)) {
                try {
                    this.zzc.release();
                } catch (RuntimeException unused5) {
                    Log.i("FirebaseMessaging", "TopicsSyncTask's wakelock was already released due to timeout.");
                }
            }
            throw th;
        }
    }
}
