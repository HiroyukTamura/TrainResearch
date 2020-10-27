package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

final /* synthetic */ class zzaxt implements DialogInterface.OnClickListener {
    private final zzaxr zzdws;
    private final int zzdwt;
    private final int zzdwu;
    private final int zzdwv;

    zzaxt(zzaxr zzaxr, int i, int i2, int i3) {
        this.zzdws = zzaxr;
        this.zzdwt = i;
        this.zzdwu = i2;
        this.zzdwv = i3;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdws.zza(this.zzdwt, this.zzdwu, this.zzdwv, dialogInterface, i);
    }
}
