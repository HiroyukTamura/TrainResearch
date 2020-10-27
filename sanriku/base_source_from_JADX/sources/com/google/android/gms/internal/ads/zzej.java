package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;

final class zzej implements zzdnm {
    private final zzev zzwf;
    private final zzdlo zzxy;
    private final zzdma zzxz;
    private final zzem zzya;

    zzej(@NonNull zzdlo zzdlo, @NonNull zzdma zzdma, @NonNull zzev zzev, @NonNull zzem zzem) {
        this.zzxy = zzdlo;
        this.zzxz = zzdma;
        this.zzwf = zzev;
        this.zzya = zzem;
    }

    private final Map<String, Object> zzcc() {
        HashMap hashMap = new HashMap();
        hashMap.put("v", this.zzxy.zzauf());
        hashMap.put("gms", Boolean.valueOf(this.zzxy.zzcn()));
        hashMap.put("int", this.zzxz.zzag());
        hashMap.put("up", Boolean.valueOf(this.zzya.zzcg()));
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(View view) {
        this.zzwf.zze(view);
    }

    public final Map<String, Object> zzcd() {
        Map<String, Object> zzcc = zzcc();
        zzcc.put("gai", Boolean.valueOf(this.zzxy.zzaug()));
        zzcc.put("did", this.zzxz.zzam());
        zzcc.put("dst", Integer.valueOf(this.zzxz.zzaun()));
        zzcc.put("doo", Boolean.valueOf(this.zzxz.zzao()));
        return zzcc;
    }

    public final Map<String, Object> zzce() {
        return zzcc();
    }

    public final Map<String, Object> zzcf() {
        Map<String, Object> zzcc = zzcc();
        zzcc.put("lts", Long.valueOf(this.zzwf.zzcv()));
        return zzcc;
    }
}
