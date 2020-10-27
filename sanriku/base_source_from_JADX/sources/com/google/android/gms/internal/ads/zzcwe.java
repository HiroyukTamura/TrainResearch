package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzcwe implements zzdah<Bundle> {
    private final zzut zzgmd;

    public zzcwe(zzut zzut) {
        this.zzgmd = zzut;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzut zzut = this.zzgmd;
        if (zzut != null) {
            int i = zzut.orientation;
            if (i == 1) {
                bundle.putString("avo", "p");
            } else if (i == 2) {
                bundle.putString("avo", "l");
            }
        }
    }
}
