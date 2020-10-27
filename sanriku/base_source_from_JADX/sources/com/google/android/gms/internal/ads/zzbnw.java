package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Map;

public final class zzbnw<AdT> implements zzbnx<AdT> {
    private final Map<String, zzcnj<AdT>> zzfku;

    zzbnw(Map<String, zzcnj<AdT>> map) {
        this.zzfku = map;
    }

    @Nullable
    public final zzcnj<AdT> zze(int i, String str) {
        return this.zzfku.get(str);
    }
}
