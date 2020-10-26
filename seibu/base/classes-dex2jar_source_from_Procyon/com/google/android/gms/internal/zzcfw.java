// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.text.TextUtils;
import android.os.Build$VERSION;
import java.security.MessageDigest;
import java.math.BigInteger;
import java.util.Locale;
import android.support.annotation.NonNull;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import android.content.SharedPreferences$Editor;
import android.support.annotation.WorkerThread;
import android.content.SharedPreferences;
import android.util.Pair;

final class zzcfw extends zzchj
{
    static final Pair<String, Long> zzbri;
    private SharedPreferences zzaix;
    public final zzcfz zzbrA;
    public final zzcfz zzbrB;
    public boolean zzbrC;
    public final zzcga zzbrj;
    public final zzcfz zzbrk;
    public final zzcfz zzbrl;
    public final zzcfz zzbrm;
    public final zzcfz zzbrn;
    public final zzcfz zzbro;
    public final zzcfz zzbrp;
    public final zzcgb zzbrq;
    private String zzbrr;
    private boolean zzbrs;
    private long zzbrt;
    private String zzbru;
    private long zzbrv;
    private final Object zzbrw;
    public final zzcfz zzbrx;
    public final zzcfz zzbry;
    public final zzcfy zzbrz;
    
    static {
        zzbri = new Pair((Object)"", (Object)0L);
    }
    
    zzcfw(final zzcgl zzcgl) {
        super(zzcgl);
        this.zzbrj = new zzcga(this, "health_monitor", zzcem.zzxK(), null);
        this.zzbrk = new zzcfz(this, "last_upload", 0L);
        this.zzbrl = new zzcfz(this, "last_upload_attempt", 0L);
        this.zzbrm = new zzcfz(this, "backoff", 0L);
        this.zzbrn = new zzcfz(this, "last_delete_stale", 0L);
        this.zzbrx = new zzcfz(this, "time_before_start", 10000L);
        this.zzbry = new zzcfz(this, "session_timeout", 1800000L);
        this.zzbrz = new zzcfy(this, "start_new_session", true);
        this.zzbrA = new zzcfz(this, "last_pause_time", 0L);
        this.zzbrB = new zzcfz(this, "time_active", 0L);
        this.zzbro = new zzcfz(this, "midnight_offset", 0L);
        this.zzbrp = new zzcfz(this, "first_open_time", 0L);
        this.zzbrq = new zzcgb(this, "app_instance_id", null);
        this.zzbrw = new Object();
    }
    
    @WorkerThread
    private final SharedPreferences zzyF() {
        this.zzjC();
        this.zzkD();
        return this.zzaix;
    }
    
    @WorkerThread
    final void setMeasurementEnabled(final boolean b) {
        this.zzjC();
        this.zzwF().zzyD().zzj("Setting measurementEnabled", b);
        final SharedPreferences$Editor edit = this.zzyF().edit();
        edit.putBoolean("measurement_enabled", b);
        edit.apply();
    }
    
    @WorkerThread
    final void zzak(final boolean b) {
        this.zzjC();
        this.zzwF().zzyD().zzj("Setting useService", b);
        final SharedPreferences$Editor edit = this.zzyF().edit();
        edit.putBoolean("use_service", b);
        edit.apply();
    }
    
    @WorkerThread
    final boolean zzal(final boolean b) {
        this.zzjC();
        return this.zzyF().getBoolean("measurement_enabled", b);
    }
    
    @NonNull
    @WorkerThread
    final Pair<String, Boolean> zzeb(final String s) {
        this.zzjC();
        final long elapsedRealtime = this.zzkq().elapsedRealtime();
        if (this.zzbrr != null && elapsedRealtime < this.zzbrt) {
            return (Pair<String, Boolean>)new Pair((Object)this.zzbrr, (Object)this.zzbrs);
        }
        this.zzbrt = elapsedRealtime + this.zzwH().zza(s, zzcfb.zzbpW);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        while (true) {
            try {
                final AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.getContext());
                if (advertisingIdInfo != null) {
                    this.zzbrr = advertisingIdInfo.getId();
                    this.zzbrs = advertisingIdInfo.isLimitAdTrackingEnabled();
                }
                if (this.zzbrr == null) {
                    this.zzbrr = "";
                }
                AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
                return (Pair<String, Boolean>)new Pair((Object)this.zzbrr, (Object)this.zzbrs);
            }
            catch (Throwable t) {
                this.zzwF().zzyC().zzj("Unable to get advertising id", t);
                this.zzbrr = "";
                continue;
            }
            break;
        }
    }
    
    @WorkerThread
    final String zzec(String s) {
        this.zzjC();
        s = (String)this.zzeb(s).first;
        final MessageDigest zzbE = zzcjl.zzbE("MD5");
        if (zzbE == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, zzbE.digest(s.getBytes())));
    }
    
    @WorkerThread
    final void zzed(final String s) {
        this.zzjC();
        final SharedPreferences$Editor edit = this.zzyF().edit();
        edit.putString("gmp_app_id", s);
        edit.apply();
    }
    
    final void zzee(final String zzbru) {
        synchronized (this.zzbrw) {
            this.zzbru = zzbru;
            this.zzbrv = this.zzkq().elapsedRealtime();
        }
    }
    
    @Override
    protected final void zzjD() {
        this.zzaix = this.getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        if (!(this.zzbrC = this.zzaix.getBoolean("has_been_opened", false))) {
            final SharedPreferences$Editor edit = this.zzaix.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
    }
    
    @WorkerThread
    final String zzyG() {
        this.zzjC();
        return this.zzyF().getString("gmp_app_id", (String)null);
    }
    
    final String zzyH() {
        synchronized (this.zzbrw) {
            if (Math.abs(this.zzkq().elapsedRealtime() - this.zzbrv) < 1000L) {
                return this.zzbru;
            }
            return null;
        }
    }
    
    @WorkerThread
    final Boolean zzyI() {
        this.zzjC();
        if (!this.zzyF().contains("use_service")) {
            return null;
        }
        return this.zzyF().getBoolean("use_service", false);
    }
    
    @WorkerThread
    final void zzyJ() {
        boolean zzal = true;
        this.zzjC();
        this.zzwF().zzyD().log("Clearing collection preferences.");
        final boolean contains = this.zzyF().contains("measurement_enabled");
        if (contains) {
            zzal = this.zzal(true);
        }
        final SharedPreferences$Editor edit = this.zzyF().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            this.setMeasurementEnabled(zzal);
        }
    }
    
    @WorkerThread
    protected final String zzyK() {
        this.zzjC();
        final String string = this.zzyF().getString("previous_os_version", (String)null);
        this.zzwv().zzkD();
        final String release = Build$VERSION.RELEASE;
        if (!TextUtils.isEmpty((CharSequence)release) && !release.equals(string)) {
            final SharedPreferences$Editor edit = this.zzyF().edit();
            edit.putString("previous_os_version", release);
            edit.apply();
        }
        return string;
    }
}
