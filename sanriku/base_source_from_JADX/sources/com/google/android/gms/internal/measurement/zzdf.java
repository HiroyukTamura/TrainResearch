package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;

public final class zzdf {
    final String zza;
    final Uri zzb;
    final String zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final boolean zzh;
    final zzdp<Context, Boolean> zzi;

    public zzdf(Uri uri) {
        this((String) null, uri, "", "", false, false, false, false, (zzdp<Context, Boolean>) null);
    }

    private zzdf(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, zzdp<Context, Boolean> zzdp) {
        this.zza = null;
        this.zzb = uri;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = false;
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = null;
    }

    public final zzcw<Double> zza(String str, double d) {
        return zzcw.zzb(this, str, -3.0d, true);
    }

    public final zzcw<Long> zza(String str, long j) {
        return zzcw.zzb(this, str, j, true);
    }

    public final zzcw<String> zza(String str, String str2) {
        return zzcw.zzb(this, str, str2, true);
    }

    public final zzcw<Boolean> zza(String str, boolean z) {
        return zzcw.zzb(this, str, z, true);
    }
}
