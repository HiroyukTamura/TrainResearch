package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.fitness.FitnessStatusCodes;
import com.google.android.gms.internal.ads.zzbm;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
final class zzdlv implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final long startTime;
    private final HandlerThread zzdyf;
    @VisibleForTesting
    private zzdmr zzhbh;
    private final LinkedBlockingQueue<zzdng> zzhbj;
    private final String zzhbk;
    private final String zzhbl;
    private final int zzhbm = 1;
    private final zzdlk zzvj;
    private final zzgb zzvl;

    public zzdlv(Context context, int i, zzgb zzgb, String str, String str2, String str3, zzdlk zzdlk) {
        this.zzhbk = str;
        this.zzvl = zzgb;
        this.zzhbl = str2;
        this.zzvj = zzdlk;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zzdyf = handlerThread;
        handlerThread.start();
        this.startTime = System.currentTimeMillis();
        this.zzhbh = new zzdmr(context, this.zzdyf.getLooper(), this, this, 19621000);
        this.zzhbj = new LinkedBlockingQueue<>();
        this.zzhbh.checkAvailabilityAndConnect();
    }

    private final void zzaot() {
        zzdmr zzdmr = this.zzhbh;
        if (zzdmr == null) {
            return;
        }
        if (zzdmr.isConnected() || this.zzhbh.isConnecting()) {
            this.zzhbh.disconnect();
        }
    }

    private final zzdmy zzaui() {
        try {
            return this.zzhbh.zzaux();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }

    @VisibleForTesting
    private static zzdng zzauk() {
        return new zzdng((byte[]) null, 1);
    }

    private final void zzb(int i, long j, Exception exc) {
        zzdlk zzdlk = this.zzvj;
        if (zzdlk != null) {
            zzdlk.zza(i, System.currentTimeMillis() - j, exc);
        }
    }

    public final void onConnected(Bundle bundle) {
        zzdmy zzaui = zzaui();
        if (zzaui != null) {
            try {
                zzdng zza = zzaui.zza(new zzdne(this.zzhbm, this.zzvl, this.zzhbk, this.zzhbl));
                zzb(FitnessStatusCodes.API_EXCEPTION, this.startTime, (Exception) null);
                this.zzhbj.put(zza);
            } catch (Throwable th) {
                zzaot();
                this.zzdyf.quit();
                throw th;
            }
            zzaot();
            this.zzdyf.quit();
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zzb(4012, this.startTime, (Exception) null);
            this.zzhbj.put(zzauk());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            zzb(4011, this.startTime, (Exception) null);
            this.zzhbj.put(zzauk());
        } catch (InterruptedException unused) {
        }
    }

    public final zzdng zzdy(int i) {
        zzdng zzdng;
        try {
            zzdng = this.zzhbj.poll(50000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zzb(2009, this.startTime, e);
            zzdng = null;
        }
        zzb(AuthApiStatusCodes.AUTH_TOKEN_ERROR, this.startTime, (Exception) null);
        if (zzdng != null) {
            zzdlk.zzb(zzdng.status == 7 ? zzbm.zza.zzc.DISABLED : zzbm.zza.zzc.ENABLED);
        }
        return zzdng == null ? zzauk() : zzdng;
    }
}
