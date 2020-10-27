package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdbs implements zzdak<zzdbp> {
    private zzdrh zzfur;
    zzsh zzgpo;
    Context zzvf;

    public zzdbs(zzsh zzsh, zzdrh zzdrh, Context context) {
        this.zzgpo = zzsh;
        this.zzfur = zzdrh;
        this.zzvf = context;
    }

    public final zzdri<zzdbp> zzaqa() {
        return this.zzfur.zzd(new zzdbr(this));
    }
}
