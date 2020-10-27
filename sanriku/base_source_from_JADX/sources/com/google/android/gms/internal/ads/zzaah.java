package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;

public final class zzaah {
    public static boolean zza(@Nullable zzaam zzaam, @Nullable zzaak zzaak, String... strArr) {
        if (zzaam == null || zzaak == null || !zzaam.zzcuv) {
            return false;
        }
        return zzaam.zza(zzaak, zzq.zzld().elapsedRealtime(), strArr);
    }

    @Nullable
    public static zzaak zzb(@Nullable zzaam zzaam) {
        if (zzaam == null) {
            return null;
        }
        return zzaam.zzex(zzq.zzld().elapsedRealtime());
    }
}
