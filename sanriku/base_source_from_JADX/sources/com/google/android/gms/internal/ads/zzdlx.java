package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzdlx implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final Object lock = new Object();
    private boolean zzgbr = false;
    private boolean zzgbs = false;
    private final zzdmr zzhbn;
    private final zzdmm zzhbo;

    zzdlx(@NonNull Context context, @NonNull Looper looper, @NonNull zzdmm zzdmm) {
        this.zzhbo = zzdmm;
        this.zzhbn = new zzdmr(context, looper, this, this, 12800000);
    }

    private final void zzaot() {
        synchronized (this.lock) {
            if (this.zzhbn.isConnected() || this.zzhbn.isConnecting()) {
                this.zzhbn.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnected(@androidx.annotation.Nullable android.os.Bundle r4) {
        /*
            r3 = this;
            java.lang.Object r4 = r3.lock
            monitor-enter(r4)
            boolean r0 = r3.zzgbs     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r4)     // Catch:{ all -> 0x002b }
            return
        L_0x0009:
            r0 = 1
            r3.zzgbs = r0     // Catch:{ all -> 0x002b }
            com.google.android.gms.internal.ads.zzdmr r0 = r3.zzhbn     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            com.google.android.gms.internal.ads.zzdmy r0 = r0.zzaux()     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            com.google.android.gms.internal.ads.zzdmp r1 = new com.google.android.gms.internal.ads.zzdmp     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            com.google.android.gms.internal.ads.zzdmm r2 = r3.zzhbo     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            byte[] r2 = r2.toByteArray()     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            r0.zza((com.google.android.gms.internal.ads.zzdmp) r1)     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
        L_0x0020:
            r3.zzaot()     // Catch:{ all -> 0x002b }
            goto L_0x0029
        L_0x0024:
            r0 = move-exception
            r3.zzaot()     // Catch:{ all -> 0x002b }
            throw r0     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r4)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x002b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdlx.onConnected(android.os.Bundle):void");
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    public final void onConnectionSuspended(int i) {
    }

    /* access modifiers changed from: package-private */
    public final void zzaul() {
        synchronized (this.lock) {
            if (!this.zzgbr) {
                this.zzgbr = true;
                this.zzhbn.checkAvailabilityAndConnect();
            }
        }
    }
}
