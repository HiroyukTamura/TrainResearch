package com.google.android.gms.internal.ads;

import android.content.DialogInterface;

final class zzaoo implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaom zzdii;

    zzaoo(zzaom zzaom) {
        this.zzdii = zzaom;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzdii.zzdv("Operation denied by user.");
    }
}
