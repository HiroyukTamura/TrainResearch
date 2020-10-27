package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdru<V> implements Runnable {
    @NullableDecl
    private zzdrs<V> zzhip;

    zzdru(zzdrs<V> zzdrs) {
        this.zzhip = zzdrs;
    }

    public final void run() {
        zzdri zza;
        String str;
        zzdrs<V> zzdrs = this.zzhip;
        if (zzdrs != null && (zza = zzdrs.zzhin) != null) {
            this.zzhip = null;
            if (zza.isDone()) {
                zzdrs.setFuture(zza);
                return;
            }
            try {
                ScheduledFuture zzb = zzdrs.zzhio;
                ScheduledFuture unused = zzdrs.zzhio = null;
                str = "Timed out";
                if (zzb != null) {
                    long abs = Math.abs(zzb.getDelay(TimeUnit.MILLISECONDS));
                    if (abs > 10) {
                        StringBuilder sb = new StringBuilder(str.length() + 66);
                        sb.append(str);
                        sb.append(" (timeout delayed by ");
                        sb.append(abs);
                        sb.append(" ms after scheduled time)");
                        str = sb.toString();
                    }
                }
                String valueOf = String.valueOf(str);
                String valueOf2 = String.valueOf(zza);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 2 + valueOf2.length());
                sb2.append(valueOf);
                sb2.append(": ");
                sb2.append(valueOf2);
                zzdrs.setException(new zzdrt(sb2.toString()));
                zza.cancel(true);
            } catch (Throwable th) {
                zza.cancel(true);
                throw th;
            }
        }
    }
}
