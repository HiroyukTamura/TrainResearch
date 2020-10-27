package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

public final class zzcsq implements zzcsk<zzbws> {
    private final zzbxr zzgfa;
    private final Context zzvf;

    public zzcsq(Context context, zzbxr zzbxr) {
        this.zzvf = context;
        this.zzgfa = zzbxr;
    }

    public final /* synthetic */ Object zza(zzdha zzdha, zzdgo zzdgo, View view, zzcsr zzcsr) {
        zzbwu zza = this.zzgfa.zza(new zzboi(zzdha, zzdgo, (String) null), new zzcss(this, zzcst.zzgio));
        zzcsr.zza(new zzcsv(this, zza));
        return zza.zzafo();
    }
}
