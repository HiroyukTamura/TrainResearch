package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzrx {
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final Runnable zzbsf = new zzsa(this);
    /* access modifiers changed from: private */
    @Nullable
    public zzsg zzbsg;
    /* access modifiers changed from: private */
    @Nullable
    public zzsk zzbsh;
    @Nullable
    private Context zzvf;

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void connect() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            android.content.Context r1 = r3.zzvf     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0021
            com.google.android.gms.internal.ads.zzsg r1 = r3.zzbsg     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x000c
            goto L_0x0021
        L_0x000c:
            com.google.android.gms.internal.ads.zzsc r1 = new com.google.android.gms.internal.ads.zzsc     // Catch:{ all -> 0x0023 }
            r1.<init>(r3)     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zzsb r2 = new com.google.android.gms.internal.ads.zzsb     // Catch:{ all -> 0x0023 }
            r2.<init>(r3)     // Catch:{ all -> 0x0023 }
            com.google.android.gms.internal.ads.zzsg r1 = r3.zza((com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks) r1, (com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener) r2)     // Catch:{ all -> 0x0023 }
            r3.zzbsg = r1     // Catch:{ all -> 0x0023 }
            r1.checkAvailabilityAndConnect()     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            return
        L_0x0023:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0023 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrx.connect():void");
    }

    /* access modifiers changed from: private */
    public final void disconnect() {
        synchronized (this.lock) {
            if (this.zzbsg != null) {
                if (this.zzbsg.isConnected() || this.zzbsg.isConnecting()) {
                    this.zzbsg.disconnect();
                }
                this.zzbsg = null;
                this.zzbsh = null;
                Binder.flushPendingCommands();
            }
        }
    }

    @VisibleForTesting
    private final synchronized zzsg zza(BaseGmsClient.BaseConnectionCallbacks baseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        return new zzsg(this.zzvf, zzq.zzlk().zzxx(), baseConnectionCallbacks, baseOnConnectionFailedListener);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0047, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initialize(android.content.Context r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = r2.lock
            monitor-enter(r0)
            android.content.Context r1 = r2.zzvf     // Catch:{ all -> 0x0048 }
            if (r1 == 0) goto L_0x000c
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x000c:
            android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0048 }
            r2.zzvf = r3     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzzz.zzcpt     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzzv r1 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzd(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0028
            r2.connect()     // Catch:{ all -> 0x0048 }
            goto L_0x0046
        L_0x0028:
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzzz.zzcps     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzzv r1 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ all -> 0x0048 }
            java.lang.Object r3 = r1.zzd(r3)     // Catch:{ all -> 0x0048 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ all -> 0x0048 }
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0048 }
            if (r3 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzrz r3 = new com.google.android.gms.internal.ads.zzrz     // Catch:{ all -> 0x0048 }
            r3.<init>(r2)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.internal.ads.zzql r1 = com.google.android.gms.ads.internal.zzq.zzkz()     // Catch:{ all -> 0x0048 }
            r1.zza(r3)     // Catch:{ all -> 0x0048 }
        L_0x0046:
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0048 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrx.initialize(android.content.Context):void");
    }

    public final zzse zza(zzsf zzsf) {
        synchronized (this.lock) {
            if (this.zzbsh == null) {
                zzse zzse = new zzse();
                return zzse;
            }
            try {
                zzse zza = this.zzbsh.zza(zzsf);
                return zza;
            } catch (RemoteException e) {
                zzazw.zzc("Unable to call into cache service.", e);
                return new zzse();
            }
        }
    }

    public final void zzmu() {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcpu)).booleanValue()) {
            synchronized (this.lock) {
                connect();
                zzq.zzkw();
                zzaxa.zzdwf.removeCallbacks(this.zzbsf);
                zzq.zzkw();
                zzaxa.zzdwf.postDelayed(this.zzbsf, ((Long) zzvj.zzpv().zzd(zzzz.zzcpv)).longValue());
            }
        }
    }
}
