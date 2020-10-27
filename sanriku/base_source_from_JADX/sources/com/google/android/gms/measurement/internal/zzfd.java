package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzfd {
    @NonNull
    public String zza;
    @NonNull
    public Bundle zzb;
    @NonNull
    private String zzc;
    private long zzd;

    private zzfd(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle, long j) {
        this.zza = str;
        this.zzc = str2;
        this.zzb = bundle == null ? new Bundle() : bundle;
        this.zzd = j;
    }

    public static zzfd zza(zzao zzao) {
        return new zzfd(zzao.zza, zzao.zzc, zzao.zzb.zzb(), zzao.zzd);
    }

    public final String toString() {
        String str = this.zzc;
        String str2 = this.zza;
        String valueOf = String.valueOf(this.zzb);
        return C0681a.m324a(C0681a.m337b(valueOf.length() + C0681a.m336b(str2, C0681a.m336b(str, 21)), "origin=", str, ",name=", str2), ",params=", valueOf);
    }

    public final zzao zza() {
        return new zzao(this.zza, new zzan(new Bundle(this.zzb)), this.zzc, this.zzd);
    }
}
