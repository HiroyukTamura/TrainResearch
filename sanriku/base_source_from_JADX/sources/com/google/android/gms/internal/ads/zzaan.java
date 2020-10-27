package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public final class zzaan {
    private final Map<String, zzaak> zzcuz = new HashMap();
    @Nullable
    private final zzaam zzcva;

    public zzaan(@Nullable zzaam zzaam) {
        this.zzcva = zzaam;
    }

    public final void zza(String str, zzaak zzaak) {
        this.zzcuz.put(str, zzaak);
    }

    public final void zza(String str, String str2, long j) {
        zzaam zzaam = this.zzcva;
        zzaak zzaak = this.zzcuz.get(str2);
        String[] strArr = {str};
        if (!(zzaam == null || zzaak == null)) {
            zzaam.zza(zzaak, j, strArr);
        }
        Map<String, zzaak> map = this.zzcuz;
        zzaam zzaam2 = this.zzcva;
        map.put(str, zzaam2 == null ? null : zzaam2.zzex(j));
    }

    @Nullable
    public final zzaam zzrn() {
        return this.zzcva;
    }
}
