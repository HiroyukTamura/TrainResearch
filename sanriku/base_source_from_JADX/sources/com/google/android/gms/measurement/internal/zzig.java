package com.google.android.gms.measurement.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.List;
import java.util.Map;

@WorkerThread
final class zzig implements Runnable {
    private final URL zza;
    private final byte[] zzb = null;
    private final zzih zzc;
    private final String zzd;
    private final Map<String, String> zze;
    private final /* synthetic */ zzie zzf;

    public zzig(zzie zzie, String str, URL url, byte[] bArr, Map<String, String> map, zzih zzih) {
        this.zzf = zzie;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(zzih);
        this.zza = url;
        this.zzc = zzih;
        this.zzd = str;
        this.zze = null;
    }

    private final void zzb(int i, Exception exc, byte[] bArr, Map<String, List<String>> map) {
        this.zzf.zzq().zza((Runnable) new zzij(this, i, exc, bArr, map));
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.zzie r0 = r7.zzf
            r0.zzc()
            r0 = 0
            r1 = 0
            com.google.android.gms.measurement.internal.zzie r2 = r7.zzf     // Catch:{ IOException -> 0x006a, all -> 0x005e }
            java.net.URL r3 = r7.zza     // Catch:{ IOException -> 0x006a, all -> 0x005e }
            java.net.HttpURLConnection r2 = r2.zza((java.net.URL) r3)     // Catch:{ IOException -> 0x006a, all -> 0x005e }
            java.util.Map<java.lang.String, java.lang.String> r3 = r7.zze     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            if (r3 == 0) goto L_0x0039
            java.util.Map<java.lang.String, java.lang.String> r3 = r7.zze     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            java.util.Set r3 = r3.entrySet()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
        L_0x001d:
            boolean r4 = r3.hasNext()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            if (r4 == 0) goto L_0x0039
            java.lang.Object r4 = r3.next()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            java.lang.Object r5 = r4.getKey()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            java.lang.Object r4 = r4.getValue()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            r2.addRequestProperty(r5, r4)     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            goto L_0x001d
        L_0x0039:
            int r1 = r2.getResponseCode()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            java.util.Map r3 = r2.getHeaderFields()     // Catch:{ IOException -> 0x005b, all -> 0x0058 }
            com.google.android.gms.measurement.internal.zzie r4 = r7.zzf     // Catch:{ IOException -> 0x0053, all -> 0x004e }
            byte[] r4 = com.google.android.gms.measurement.internal.zzie.zza((java.net.HttpURLConnection) r2)     // Catch:{ IOException -> 0x0053, all -> 0x004e }
            r2.disconnect()
            r7.zzb(r1, r0, r4, r3)
            return
        L_0x004e:
            r4 = move-exception
            r6 = r4
            r4 = r3
            r3 = r6
            goto L_0x0061
        L_0x0053:
            r4 = move-exception
            r6 = r4
            r4 = r3
            r3 = r6
            goto L_0x006d
        L_0x0058:
            r3 = move-exception
            r4 = r0
            goto L_0x0061
        L_0x005b:
            r3 = move-exception
            r4 = r0
            goto L_0x006d
        L_0x005e:
            r3 = move-exception
            r2 = r0
            r4 = r2
        L_0x0061:
            if (r2 == 0) goto L_0x0066
            r2.disconnect()
        L_0x0066:
            r7.zzb(r1, r0, r0, r4)
            throw r3
        L_0x006a:
            r3 = move-exception
            r2 = r0
            r4 = r2
        L_0x006d:
            if (r2 == 0) goto L_0x0072
            r2.disconnect()
        L_0x0072:
            r7.zzb(r1, r3, r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzig.run():void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, Exception exc, byte[] bArr, Map map) {
        this.zzc.zza(this.zzd, i, exc, bArr, map);
    }
}
