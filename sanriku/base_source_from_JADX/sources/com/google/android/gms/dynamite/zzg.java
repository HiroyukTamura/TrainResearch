package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzg implements DynamiteModule.VersionPolicy {
    zzg() {
    }

    public final DynamiteModule.VersionPolicy.zza zza(Context context, String str, DynamiteModule.VersionPolicy.zzb zzb) throws DynamiteModule.LoadingException {
        int i;
        DynamiteModule.VersionPolicy.zza zza = new DynamiteModule.VersionPolicy.zza();
        zza.zzjg = zzb.getLocalVersion(context, str);
        int zza2 = zzb.zza(context, str, true);
        zza.zzjh = zza2;
        if (zza.zzjg == 0 && zza2 == 0) {
            i = 0;
        } else if (zza.zzjh >= zza.zzjg) {
            zza.zzji = 1;
            return zza;
        } else {
            i = -1;
        }
        zza.zzji = i;
        return zza;
    }
}
