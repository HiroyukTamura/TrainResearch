package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.Map;

public final class zzaym {
    private static zzu zzdxr;
    private static final Object zzdxs = new Object();
    @Deprecated
    private static final zzayq<Void> zzdxt = new zzayl();

    public zzaym(Context context) {
        zzbj(context.getApplicationContext() != null ? context.getApplicationContext() : context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzu zzbj(android.content.Context r3) {
        /*
            java.lang.Object r0 = zzdxs
            monitor-enter(r0)
            com.google.android.gms.internal.ads.zzu r1 = zzdxr     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzzz.initialize(r3)     // Catch:{ all -> 0x0036 }
            boolean r1 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()     // Catch:{ all -> 0x0036 }
            if (r1 != 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzzk<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzzz.zzcqa     // Catch:{ all -> 0x0036 }
            com.google.android.gms.internal.ads.zzzv r2 = com.google.android.gms.internal.ads.zzvj.zzpv()     // Catch:{ all -> 0x0036 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ all -> 0x0036 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x0036 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x0024
            r1 = 1
            goto L_0x0025
        L_0x0024:
            r1 = 0
        L_0x0025:
            if (r1 == 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzu r3 = com.google.android.gms.internal.ads.zzayb.zzbi(r3)     // Catch:{ all -> 0x0036 }
            goto L_0x0030
        L_0x002c:
            com.google.android.gms.internal.ads.zzu r3 = com.google.android.gms.internal.ads.zzba.zza(r3)     // Catch:{ all -> 0x0036 }
        L_0x0030:
            zzdxr = r3     // Catch:{ all -> 0x0036 }
        L_0x0032:
            com.google.android.gms.internal.ads.zzu r3 = zzdxr     // Catch:{ all -> 0x0036 }
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            return r3
        L_0x0036:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0036 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaym.zzbj(android.content.Context):com.google.android.gms.internal.ads.zzu");
    }

    public static zzdri<zzo> zzet(String str) {
        zzbaj zzbaj = new zzbaj();
        zzdxr.zze(new zzays(str, zzbaj));
        return zzbaj;
    }

    public final zzdri<String> zza(int i, String str, @Nullable Map<String, String> map, @Nullable byte[] bArr) {
        String str2 = str;
        zzayp zzayp = new zzayp((zzayl) null);
        zzayo zzayo = new zzayo(this, str2, zzayp);
        zzazq zzazq = new zzazq((String) null);
        zzayn zzayn = new zzayn(this, i, str, zzayp, zzayo, bArr, map, zzazq);
        if (zzazq.isEnabled()) {
            try {
                zzazq.zza(str2, "GET", zzayn.getHeaders(), zzayn.zzg());
            } catch (zzb e) {
                zzazw.zzfc(e.getMessage());
            }
        }
        zzdxr.zze(zzayn);
        return zzayp;
    }

    public final zzdri<String> zzc(String str, Map<String, String> map) {
        return zza(0, str, map, (byte[]) null);
    }
}
