package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import android.support.p001v4.media.session.PlaybackStateCompat;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbv;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
final class zzdlt implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final String packageName;
    private final HandlerThread zzdyf;
    @VisibleForTesting
    private zzdmr zzhbh;
    private final String zzhbi;
    private final LinkedBlockingQueue<zzbv.zza> zzhbj = new LinkedBlockingQueue<>();

    public zzdlt(Context context, String str, String str2) {
        this.packageName = str;
        this.zzhbi = str2;
        HandlerThread handlerThread = new HandlerThread("GassClient");
        this.zzdyf = handlerThread;
        handlerThread.start();
        this.zzhbh = new zzdmr(context, this.zzdyf.getLooper(), this, this, 9200000);
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
    private static zzbv.zza zzauj() {
        return (zzbv.zza) ((zzecd) zzbv.zza.zzar().zzn(PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID).zzbet());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        zzaot();
        r3.zzdyf.quit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r3.zzhbj.put(zzauj());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnected(android.os.Bundle r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzdmy r4 = r3.zzaui()
            if (r4 == 0) goto L_0x0039
            com.google.android.gms.internal.ads.zzdmu r0 = new com.google.android.gms.internal.ads.zzdmu     // Catch:{ all -> 0x0025 }
            java.lang.String r1 = r3.packageName     // Catch:{ all -> 0x0025 }
            java.lang.String r2 = r3.zzhbi     // Catch:{ all -> 0x0025 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzdmw r4 = r4.zza((com.google.android.gms.internal.ads.zzdmu) r0)     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzbv$zza r4 = r4.zzauy()     // Catch:{ all -> 0x0025 }
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzbv$zza> r0 = r3.zzhbj     // Catch:{ all -> 0x0025 }
            r0.put(r4)     // Catch:{ all -> 0x0025 }
        L_0x001c:
            r3.zzaot()
            android.os.HandlerThread r4 = r3.zzdyf
            r4.quit()
            return
        L_0x0025:
            java.util.concurrent.LinkedBlockingQueue<com.google.android.gms.internal.ads.zzbv$zza> r4 = r3.zzhbj     // Catch:{ InterruptedException -> 0x001c, all -> 0x002f }
            com.google.android.gms.internal.ads.zzbv$zza r0 = zzauj()     // Catch:{ InterruptedException -> 0x001c, all -> 0x002f }
            r4.put(r0)     // Catch:{ InterruptedException -> 0x001c, all -> 0x002f }
            goto L_0x001c
        L_0x002f:
            r4 = move-exception
            r3.zzaot()
            android.os.HandlerThread r0 = r3.zzdyf
            r0.quit()
            throw r4
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdlt.onConnected(android.os.Bundle):void");
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            this.zzhbj.put(zzauj());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            this.zzhbj.put(zzauj());
        } catch (InterruptedException unused) {
        }
    }

    public final zzbv.zza zzdx(int i) {
        zzbv.zza zza;
        try {
            zza = this.zzhbj.poll(5000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            zza = null;
        }
        return zza == null ? zzauj() : zza;
    }
}
