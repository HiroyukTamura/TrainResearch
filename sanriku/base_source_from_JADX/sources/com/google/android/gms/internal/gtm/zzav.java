package com.google.android.gms.internal.gtm;

import android.content.ComponentName;
import android.content.ServiceConnection;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public final class zzav implements ServiceConnection {
    final /* synthetic */ zzat zzxe;
    private volatile zzce zzxf;
    private volatile boolean zzxg;

    protected zzav(zzat zzat) {
        this.zzxe = zzat;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:20|21) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:10|11|12|(3:14|(1:16)(1:17)|18)(1:19)|(2:23|24)(3:25|26|(1:28)(1:29))|30|31|32|33) */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        r2.zzxe.zzu("Service connect failed to get IAnalyticsService");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0047 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0080 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onServiceConnected(android.content.ComponentName r3, android.os.IBinder r4) {
        /*
            r2 = this;
            java.lang.String r3 = "AnalyticsServiceConnection.onServiceConnected"
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r3)
            monitor-enter(r2)
            if (r4 != 0) goto L_0x0017
            com.google.android.gms.internal.gtm.zzat r3 = r2.zzxe     // Catch:{ all -> 0x0014 }
            java.lang.String r4 = "Service connected with null binder"
            r3.zzu(r4)     // Catch:{ all -> 0x0014 }
            r2.notifyAll()     // Catch:{ all -> 0x0089 }
            monitor-exit(r2)     // Catch:{ all -> 0x0089 }
            return
        L_0x0014:
            r3 = move-exception
            goto L_0x0085
        L_0x0017:
            r3 = 0
            java.lang.String r0 = r4.getInterfaceDescriptor()     // Catch:{ RemoteException -> 0x0047 }
            java.lang.String r1 = "com.google.android.gms.analytics.internal.IAnalyticsService"
            boolean r1 = r1.equals(r0)     // Catch:{ RemoteException -> 0x0047 }
            if (r1 == 0) goto L_0x003f
            java.lang.String r0 = "com.google.android.gms.analytics.internal.IAnalyticsService"
            android.os.IInterface r0 = r4.queryLocalInterface(r0)     // Catch:{ RemoteException -> 0x0047 }
            boolean r1 = r0 instanceof com.google.android.gms.internal.gtm.zzce     // Catch:{ RemoteException -> 0x0047 }
            if (r1 == 0) goto L_0x0031
            com.google.android.gms.internal.gtm.zzce r0 = (com.google.android.gms.internal.gtm.zzce) r0     // Catch:{ RemoteException -> 0x0047 }
            goto L_0x0036
        L_0x0031:
            com.google.android.gms.internal.gtm.zzcf r0 = new com.google.android.gms.internal.gtm.zzcf     // Catch:{ RemoteException -> 0x0047 }
            r0.<init>(r4)     // Catch:{ RemoteException -> 0x0047 }
        L_0x0036:
            r3 = r0
            com.google.android.gms.internal.gtm.zzat r4 = r2.zzxe     // Catch:{ RemoteException -> 0x0047 }
            java.lang.String r0 = "Bound to IAnalyticsService interface"
            r4.zzq(r0)     // Catch:{ RemoteException -> 0x0047 }
            goto L_0x004e
        L_0x003f:
            com.google.android.gms.internal.gtm.zzat r4 = r2.zzxe     // Catch:{ RemoteException -> 0x0047 }
            java.lang.String r1 = "Got binder with a wrong descriptor"
            r4.zze(r1, r0)     // Catch:{ RemoteException -> 0x0047 }
            goto L_0x004e
        L_0x0047:
            com.google.android.gms.internal.gtm.zzat r4 = r2.zzxe     // Catch:{ all -> 0x0014 }
            java.lang.String r0 = "Service connect failed to get IAnalyticsService"
            r4.zzu(r0)     // Catch:{ all -> 0x0014 }
        L_0x004e:
            if (r3 != 0) goto L_0x0064
            com.google.android.gms.common.stats.ConnectionTracker r3 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()     // Catch:{ IllegalArgumentException -> 0x0080 }
            com.google.android.gms.internal.gtm.zzat r4 = r2.zzxe     // Catch:{ IllegalArgumentException -> 0x0080 }
            android.content.Context r4 = r4.getContext()     // Catch:{ IllegalArgumentException -> 0x0080 }
            com.google.android.gms.internal.gtm.zzat r0 = r2.zzxe     // Catch:{ IllegalArgumentException -> 0x0080 }
            com.google.android.gms.internal.gtm.zzav r0 = r0.zzxa     // Catch:{ IllegalArgumentException -> 0x0080 }
            r3.unbindService(r4, r0)     // Catch:{ IllegalArgumentException -> 0x0080 }
            goto L_0x0080
        L_0x0064:
            boolean r4 = r2.zzxg     // Catch:{ all -> 0x0014 }
            if (r4 != 0) goto L_0x007e
            com.google.android.gms.internal.gtm.zzat r4 = r2.zzxe     // Catch:{ all -> 0x0014 }
            java.lang.String r0 = "onServiceConnected received after the timeout limit"
            r4.zzt(r0)     // Catch:{ all -> 0x0014 }
            com.google.android.gms.internal.gtm.zzat r4 = r2.zzxe     // Catch:{ all -> 0x0014 }
            com.google.android.gms.analytics.zzk r4 = r4.zzcq()     // Catch:{ all -> 0x0014 }
            com.google.android.gms.internal.gtm.zzaw r0 = new com.google.android.gms.internal.gtm.zzaw     // Catch:{ all -> 0x0014 }
            r0.<init>(r2, r3)     // Catch:{ all -> 0x0014 }
            r4.zza((java.lang.Runnable) r0)     // Catch:{ all -> 0x0014 }
            goto L_0x0080
        L_0x007e:
            r2.zzxf = r3     // Catch:{ all -> 0x0014 }
        L_0x0080:
            r2.notifyAll()     // Catch:{ all -> 0x0089 }
            monitor-exit(r2)     // Catch:{ all -> 0x0089 }
            return
        L_0x0085:
            r2.notifyAll()     // Catch:{ all -> 0x0089 }
            throw r3     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0089 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzav.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        Preconditions.checkMainThread("AnalyticsServiceConnection.onServiceDisconnected");
        this.zzxe.zzcq().zza((Runnable) new zzax(this, componentName));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:9|10|11|12|13|(1:15)) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0075, code lost:
        return r0;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x005e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.gtm.zzce zzdq() {
        /*
            r6 = this;
            com.google.android.gms.analytics.zzk.zzav()
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.google.android.gms.analytics.service.START"
            r0.<init>(r1)
            android.content.ComponentName r1 = new android.content.ComponentName
            java.lang.String r2 = "com.google.android.gms"
            java.lang.String r3 = "com.google.android.gms.analytics.service.AnalyticsService"
            r1.<init>(r2, r3)
            r0.setComponent(r1)
            com.google.android.gms.internal.gtm.zzat r1 = r6.zzxe
            android.content.Context r1 = r1.getContext()
            java.lang.String r2 = r1.getPackageName()
            java.lang.String r3 = "app_package_name"
            r0.putExtra(r3, r2)
            com.google.android.gms.common.stats.ConnectionTracker r2 = com.google.android.gms.common.stats.ConnectionTracker.getInstance()
            monitor-enter(r6)
            r3 = 0
            r6.zzxf = r3     // Catch:{ all -> 0x0076 }
            r4 = 1
            r6.zzxg = r4     // Catch:{ all -> 0x0076 }
            com.google.android.gms.internal.gtm.zzat r4 = r6.zzxe     // Catch:{ all -> 0x0076 }
            com.google.android.gms.internal.gtm.zzav r4 = r4.zzxa     // Catch:{ all -> 0x0076 }
            r5 = 129(0x81, float:1.81E-43)
            boolean r0 = r2.bindService(r1, r0, r4, r5)     // Catch:{ all -> 0x0076 }
            com.google.android.gms.internal.gtm.zzat r1 = r6.zzxe     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = "Bind to service requested"
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x0076 }
            r1.zza(r2, r4)     // Catch:{ all -> 0x0076 }
            r1 = 0
            if (r0 != 0) goto L_0x004e
            r6.zzxg = r1     // Catch:{ all -> 0x0076 }
            monitor-exit(r6)     // Catch:{ all -> 0x0076 }
            return r3
        L_0x004e:
            com.google.android.gms.internal.gtm.zzbz<java.lang.Long> r0 = com.google.android.gms.internal.gtm.zzby.zzaak     // Catch:{ InterruptedException -> 0x005e }
            java.lang.Object r0 = r0.get()     // Catch:{ InterruptedException -> 0x005e }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ InterruptedException -> 0x005e }
            long r4 = r0.longValue()     // Catch:{ InterruptedException -> 0x005e }
            r6.wait(r4)     // Catch:{ InterruptedException -> 0x005e }
            goto L_0x0065
        L_0x005e:
            com.google.android.gms.internal.gtm.zzat r0 = r6.zzxe     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = "Wait for service connect was interrupted"
            r0.zzt(r2)     // Catch:{ all -> 0x0076 }
        L_0x0065:
            r6.zzxg = r1     // Catch:{ all -> 0x0076 }
            com.google.android.gms.internal.gtm.zzce r0 = r6.zzxf     // Catch:{ all -> 0x0076 }
            r6.zzxf = r3     // Catch:{ all -> 0x0076 }
            if (r0 != 0) goto L_0x0074
            com.google.android.gms.internal.gtm.zzat r1 = r6.zzxe     // Catch:{ all -> 0x0076 }
            java.lang.String r2 = "Successfully bound to service but never got onServiceConnected callback"
            r1.zzu(r2)     // Catch:{ all -> 0x0076 }
        L_0x0074:
            monitor-exit(r6)     // Catch:{ all -> 0x0076 }
            return r0
        L_0x0076:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0076 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzav.zzdq():com.google.android.gms.internal.gtm.zzce");
    }
}
