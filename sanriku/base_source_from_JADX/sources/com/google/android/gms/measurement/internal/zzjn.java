package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzjn implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    final /* synthetic */ zzis zza;
    /* access modifiers changed from: private */
    public volatile boolean zzb;
    private volatile zzew zzc;

    protected zzjn(zzis zzis) {
        this.zza = zzis;
    }

    @MainThread
    public final void onConnected(@Nullable Bundle bundle) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                this.zza.zzq().zza((Runnable) new zzjo(this, (zzer) this.zzc.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.zzc = null;
                this.zzb = false;
            }
        }
    }

    @MainThread
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionFailed");
        zzez zzd = this.zza.zzy.zzd();
        if (zzd != null) {
            zzd.zzi().zza("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.zzb = false;
            this.zzc = null;
        }
        this.zza.zzq().zza((Runnable) new zzjq(this));
    }

    @MainThread
    public final void onConnectionSuspended(int i) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onConnectionSuspended");
        this.zza.zzr().zzw().zza("Service connection suspended");
        this.zza.zzq().zza((Runnable) new zzjr(this));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:19|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r3.zza.zzr().zzf().zza("Service connect failed to get IMeasurementService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005f */
    @androidx.annotation.MainThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
        /*
            r3 = this;
            java.lang.String r4 = "MeasurementServiceConnection.onServiceConnected"
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r4)
            monitor-enter(r3)
            r4 = 0
            if (r5 != 0) goto L_0x001f
            r3.zzb = r4     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzis r4 = r3.zza     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzez r4 = r4.zzr()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzfb r4 = r4.zzf()     // Catch:{ all -> 0x001c }
            java.lang.String r5 = "Service connected with null binder"
            r4.zza(r5)     // Catch:{ all -> 0x001c }
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x001c:
            r4 = move-exception
            goto L_0x0096
        L_0x001f:
            r0 = 0
            java.lang.String r1 = r5.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x005f }
            java.lang.String r2 = "com.google.android.gms.measurement.internal.IMeasurementService"
            boolean r2 = r2.equals(r1)     // Catch:{ RemoteException -> 0x005f }
            if (r2 == 0) goto L_0x004f
            java.lang.String r1 = "com.google.android.gms.measurement.internal.IMeasurementService"
            android.os.IInterface r1 = r5.queryLocalInterface(r1)     // Catch:{ RemoteException -> 0x005f }
            boolean r2 = r1 instanceof com.google.android.gms.measurement.internal.zzer     // Catch:{ RemoteException -> 0x005f }
            if (r2 == 0) goto L_0x0039
            com.google.android.gms.measurement.internal.zzer r1 = (com.google.android.gms.measurement.internal.zzer) r1     // Catch:{ RemoteException -> 0x005f }
            goto L_0x003e
        L_0x0039:
            com.google.android.gms.measurement.internal.zzet r1 = new com.google.android.gms.measurement.internal.zzet     // Catch:{ RemoteException -> 0x005f }
            r1.<init>(r5)     // Catch:{ RemoteException -> 0x005f }
        L_0x003e:
            r0 = r1
            com.google.android.gms.measurement.internal.zzis r5 = r3.zza     // Catch:{ RemoteException -> 0x005f }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzr()     // Catch:{ RemoteException -> 0x005f }
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzx()     // Catch:{ RemoteException -> 0x005f }
            java.lang.String r1 = "Bound to IMeasurementService interface"
            r5.zza(r1)     // Catch:{ RemoteException -> 0x005f }
            goto L_0x006e
        L_0x004f:
            com.google.android.gms.measurement.internal.zzis r5 = r3.zza     // Catch:{ RemoteException -> 0x005f }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzr()     // Catch:{ RemoteException -> 0x005f }
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzf()     // Catch:{ RemoteException -> 0x005f }
            java.lang.String r2 = "Got binder with a wrong descriptor"
            r5.zza(r2, r1)     // Catch:{ RemoteException -> 0x005f }
            goto L_0x006e
        L_0x005f:
            com.google.android.gms.measurement.internal.zzis r5 = r3.zza     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzez r5 = r5.zzr()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzf()     // Catch:{ all -> 0x001c }
            java.lang.String r1 = "Service connect failed to get IMeasurementService"
            r5.zza(r1)     // Catch:{ all -> 0x001c }
        L_0x006e:
            if (r0 != 0) goto L_0x0086
            r3.zzb = r4     // Catch:{ all -> 0x001c }
            com.google.android.gms.common.stats.ConnectionTracker r4 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ IllegalArgumentException -> 0x0094 }
            com.google.android.gms.measurement.internal.zzis r5 = r3.zza     // Catch:{ IllegalArgumentException -> 0x0094 }
            android.content.Context r5 = r5.zzn()     // Catch:{ IllegalArgumentException -> 0x0094 }
            com.google.android.gms.measurement.internal.zzis r0 = r3.zza     // Catch:{ IllegalArgumentException -> 0x0094 }
            com.google.android.gms.measurement.internal.zzjn r0 = r0.zza     // Catch:{ IllegalArgumentException -> 0x0094 }
            r4.unbindService(r5, r0)     // Catch:{ IllegalArgumentException -> 0x0094 }
            goto L_0x0094
        L_0x0086:
            com.google.android.gms.measurement.internal.zzis r4 = r3.zza     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzfw r4 = r4.zzq()     // Catch:{ all -> 0x001c }
            com.google.android.gms.measurement.internal.zzjm r5 = new com.google.android.gms.measurement.internal.zzjm     // Catch:{ all -> 0x001c }
            r5.<init>(r3, r0)     // Catch:{ all -> 0x001c }
            r4.zza((java.lang.Runnable) r5)     // Catch:{ all -> 0x001c }
        L_0x0094:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            return
        L_0x0096:
            monitor-exit(r3)     // Catch:{ all -> 0x001c }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjn.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    @MainThread
    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("MeasurementServiceConnection.onServiceDisconnected");
        this.zza.zzr().zzw().zza("Service disconnected");
        this.zza.zzq().zza((Runnable) new zzjp(this, componentName));
    }

    @WorkerThread
    public final void zza() {
        if (this.zzc != null && (this.zzc.isConnected() || this.zzc.isConnecting())) {
            this.zzc.disconnect();
        }
        this.zzc = null;
    }

    @WorkerThread
    public final void zza(Intent intent) {
        this.zza.zzd();
        Context zzn = this.zza.zzn();
        ConnectionTracker instance = ConnectionTracker.getInstance();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzr().zzx().zza("Connection attempt already in progress");
                return;
            }
            this.zza.zzr().zzx().zza("Using local app measurement service");
            this.zzb = true;
            instance.bindService(zzn, intent, this.zza.zza, 129);
        }
    }

    @WorkerThread
    public final void zzb() {
        this.zza.zzd();
        Context zzn = this.zza.zzn();
        synchronized (this) {
            if (this.zzb) {
                this.zza.zzr().zzx().zza("Connection attempt already in progress");
            } else if (this.zzc == null || (!this.zzc.isConnecting() && !this.zzc.isConnected())) {
                this.zzc = new zzew(zzn, Looper.getMainLooper(), this, this);
                this.zza.zzr().zzx().zza("Connecting to remote service");
                this.zzb = true;
                this.zzc.checkAvailabilityAndConnect();
            } else {
                this.zza.zzr().zzx().zza("Already awaiting connection attempt");
            }
        }
    }
}
