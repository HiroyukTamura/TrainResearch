package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzb implements DynamiteModule.VersionPolicy {
    zzb() {
    }

    public final DynamiteModule.VersionPolicy.zza zza(Context context, String str, DynamiteModule.VersionPolicy.zzb zzb) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.zza zza = new DynamiteModule.VersionPolicy.zza();
        int localVersion = zzb.getLocalVersion(context, str);
        zza.zzjg = localVersion;
        if (localVersion != 0) {
            zza.zzji = -1;
        } else {
            int zza2 = zzb.zza(context, str, true);
            zza.zzjh = zza2;
            if (zza2 != 0) {
                zza.zzji = 1;
            }
        }
        return zza;
    }
}
