package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;

public final class zzblr extends zzbns {
    private final View view;
    @Nullable
    private final zzbek zzdce;
    private final zzdgn zzfik;
    private final int zzfil;
    private final boolean zzfim;
    private final boolean zzfin;
    @Nullable
    private zzrs zzfit;
    private final zzbli zzfiu;

    zzblr(zzbnv zzbnv, View view2, @Nullable zzbek zzbek, zzdgn zzdgn, int i, boolean z, boolean z2, zzbli zzbli) {
        super(zzbnv);
        this.view = view2;
        this.zzdce = zzbek;
        this.zzfik = zzdgn;
        this.zzfil = i;
        this.zzfim = z;
        this.zzfin = z2;
        this.zzfiu = zzbli;
    }

    public final void zza(zzrh zzrh) {
        zzbek zzbek = this.zzdce;
        if (zzbek != null) {
            zzbek.zza(zzrh);
        }
    }

    public final void zza(zzrs zzrs) {
        this.zzfit = zzrs;
    }

    public final boolean zzaap() {
        zzbek zzbek = this.zzdce;
        return (zzbek == null || zzbek.zzabj() == null || !this.zzdce.zzabj().zzaap()) ? false : true;
    }

    public final int zzagv() {
        return this.zzfil;
    }

    public final boolean zzagw() {
        return this.zzfim;
    }

    public final boolean zzagx() {
        return this.zzfin;
    }

    public final zzdgn zzahd() {
        return zzdhh.zza(this.zzfkd.zzgtq, this.zzfik);
    }

    public final View zzahe() {
        return this.view;
    }

    public final boolean zzahf() {
        zzbek zzbek = this.zzdce;
        return zzbek != null && zzbek.zzabl();
    }

    @Nullable
    public final zzrs zzahg() {
        return this.zzfit;
    }

    public final void zzfd(long j) {
        this.zzfiu.zzfd(j);
    }
}
