package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

public final class zzafa extends zzaeb {
    private final NativeCustomTemplateAd.OnCustomClickListener zzczm;

    public zzafa(NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzczm = onCustomClickListener;
    }

    public final void zza(zzado zzado, String str) {
        this.zzczm.onCustomClick(zzadt.zza(zzado), str);
    }
}
