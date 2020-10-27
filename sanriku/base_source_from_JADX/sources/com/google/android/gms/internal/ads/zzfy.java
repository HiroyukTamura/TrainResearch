package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

public final class zzfy extends zzfz {
    private final View zzaae;

    public zzfy(zzeo zzeo, String str, String str2, zzbv.zza.C2654zza zza, int i, int i2, View view) {
        super(zzeo, str, str2, zza, i, 57);
        this.zzaae = view;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (this.zzaae != null) {
            Boolean bool = (Boolean) zzvj.zzpv().zzd(zzzz.zzcoi);
            DisplayMetrics displayMetrics = this.zzvp.getContext().getResources().getDisplayMetrics();
            zzew zzew = new zzew((String) this.zzaaw.invoke((Object) null, new Object[]{this.zzaae, displayMetrics, bool}));
            zzbv.zza.zzf.C2656zza zzay = zzbv.zza.zzf.zzay();
            zzay.zzcy(zzew.zzzy.longValue()).zzcz(zzew.zzzz.longValue()).zzda(zzew.zzaaa.longValue());
            if (bool.booleanValue()) {
                zzay.zzdb(zzew.zzaab.longValue());
            }
            this.zzaam.zza((zzbv.zza.zzf) ((zzecd) zzay.zzbet()));
        }
    }
}
