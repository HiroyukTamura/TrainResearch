package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzd implements DynamiteModule.VersionPolicy {
    zzd() {
    }

    public final DynamiteModule.VersionPolicy.zza zza(Context context, String str, DynamiteModule.VersionPolicy.zzb zzb) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.zza zza = new DynamiteModule.VersionPolicy.zza();
        int localVersion = zzb.getLocalVersion(context, str);
        zza.zzjg = localVersion;
        zza.zzjh = localVersion != 0 ? zzb.zza(context, str, false) : zzb.zza(context, str, true);
        if (zza.zzjg == 0 && zza.zzjh == 0) {
            zza.zzji = 0;
        } else if (zza.zzjg >= zza.zzjh) {
            zza.zzji = -1;
        } else {
            zza.zzji = 1;
        }
        return zza;
    }
}
