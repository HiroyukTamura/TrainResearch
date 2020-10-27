package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.VisibleForTesting;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

final class zzfl extends zzgw {
    @VisibleForTesting
    static final Pair<String, Long> zza = new Pair<>("", 0L);
    private String zzaa;
    private boolean zzab;
    private long zzac;
    public zzfo zzb;
    public final zzfp zzc = new zzfp(this, "last_upload", 0);
    public final zzfp zzd = new zzfp(this, "last_upload_attempt", 0);
    public final zzfp zze = new zzfp(this, "backoff", 0);
    public final zzfp zzf = new zzfp(this, "last_delete_stale", 0);
    public final zzfp zzg = new zzfp(this, "midnight_offset", 0);
    public final zzfp zzh = new zzfp(this, "first_open_time", 0);
    public final zzfp zzi = new zzfp(this, "app_install_time", 0);
    public final zzfr zzj = new zzfr(this, "app_instance_id", (String) null);
    public final zzfp zzk = new zzfp(this, "time_before_start", 10000);
    public final zzfp zzl = new zzfp(this, "session_timeout", 1800000);
    public final zzfn zzm = new zzfn(this, "start_new_session", true);
    public final zzfr zzn = new zzfr(this, "non_personalized_ads", (String) null);
    public final zzfn zzo = new zzfn(this, "allow_remote_dynamite", false);
    public final zzfp zzp = new zzfp(this, "last_pause_time", 0);
    public boolean zzq;
    public zzfn zzr = new zzfn(this, "app_backgrounded", false);
    public zzfn zzs = new zzfn(this, "deep_link_retrieval_complete", false);
    public zzfp zzt = new zzfp(this, "deep_link_retrieval_attempts", 0);
    public final zzfr zzu = new zzfr(this, "firebase_feature_rollouts", (String) null);
    public final zzfr zzv = new zzfr(this, "deferred_attribution_cache", (String) null);
    public final zzfp zzw = new zzfp(this, "deferred_attribution_cache_timestamp", 0);
    public final zzfm zzx = new zzfm(this, "default_event_parameters", (Bundle) null);
    private SharedPreferences zzz;

    zzfl(zzgd zzgd) {
        super(zzgd);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    /* renamed from: f_ */
    public final void mo24447f_() {
        SharedPreferences sharedPreferences = zzn().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzz = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzq = z;
        if (!z) {
            SharedPreferences.Editor edit = this.zzz.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzb = new zzfo(this, "health_monitor", Math.max(0, zzaq.zzb.zza(null).longValue()));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @NonNull
    public final Pair<String, Boolean> zza(String str) {
        zzd();
        long elapsedRealtime = zzm().elapsedRealtime();
        if (this.zzaa != null && elapsedRealtime < this.zzac) {
            return new Pair<>(this.zzaa, Boolean.valueOf(this.zzab));
        }
        this.zzac = zzt().zza(str, zzaq.zza) + elapsedRealtime;
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zzn());
            if (advertisingIdInfo != null) {
                this.zzaa = advertisingIdInfo.getId();
                this.zzab = advertisingIdInfo.isLimitAdTrackingEnabled();
            }
            if (this.zzaa == null) {
                this.zzaa = "";
            }
        } catch (Exception e) {
            zzr().zzw().zza("Unable to get advertising id", e);
            this.zzaa = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzaa, Boolean.valueOf(this.zzab));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(boolean z) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(long j) {
        return j - this.zzl.zza() > this.zzp.zza();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzb(String str) {
        zzd();
        String str2 = (String) zza(str).first;
        MessageDigest zzi2 = zzkw.zzi();
        if (zzi2 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzi2.digest(str2.getBytes()))});
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(boolean z) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(String str) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzc(boolean z) {
        zzd();
        zzr().zzx().zza("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzg().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzd(String str) {
        zzd();
        SharedPreferences.Editor edit = zzg().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final SharedPreferences zzg() {
        zzd();
        zzaa();
        return this.zzz;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzh() {
        zzd();
        return zzg().getString("gmp_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final String zzi() {
        zzd();
        return zzg().getString("admob_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final Boolean zzj() {
        zzd();
        if (!zzg().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(zzg().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzk() {
        zzd();
        Boolean zzv2 = zzv();
        SharedPreferences.Editor edit = zzg().edit();
        edit.clear();
        edit.apply();
        if (zzv2 != null) {
            zzb(zzv2.booleanValue());
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final Boolean zzv() {
        zzd();
        if (zzg().contains("measurement_enabled")) {
            return Boolean.valueOf(zzg().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final String zzw() {
        zzd();
        String string = zzg().getString("previous_os_version", (String) null);
        zzl().zzaa();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = zzg().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zzx() {
        return this.zzz.contains("deferred_analytics_collection");
    }
}
