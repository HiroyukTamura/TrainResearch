package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;

public final class zzfa extends zzfz {
    private final Activity zzaad;
    private final View zzaae;

    public zzfa(zzeo zzeo, String str, String str2, zzbv.zza.C2654zza zza, int i, int i2, View view, Activity activity) {
        super(zzeo, str, str2, zza, i, 62);
        this.zzaae = view;
        this.zzaad = activity;
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (this.zzaae != null) {
            boolean booleanValue = ((Boolean) zzvj.zzpv().zzd(zzzz.zzcns)).booleanValue();
            Object[] objArr = (Object[]) this.zzaaw.invoke((Object) null, new Object[]{this.zzaae, this.zzaad, Boolean.valueOf(booleanValue)});
            synchronized (this.zzaam) {
                this.zzaam.zzai(((Long) objArr[0]).longValue());
                this.zzaam.zzaj(((Long) objArr[1]).longValue());
                if (booleanValue) {
                    this.zzaam.zzz((String) objArr[2]);
                }
            }
        }
    }
}
