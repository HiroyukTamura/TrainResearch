package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbv;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class zzfz implements Callable {
    private final String TAG = getClass().getSimpleName();
    private final String className;
    protected final zzbv.zza.C2654zza zzaam;
    private final String zzaau;
    protected Method zzaaw;
    private final int zzaaz;
    private final int zzaba;
    protected final zzeo zzvp;

    public zzfz(zzeo zzeo, String str, String str2, zzbv.zza.C2654zza zza, int i, int i2) {
        this.zzvp = zzeo;
        this.className = str;
        this.zzaau = str2;
        this.zzaam = zza;
        this.zzaaz = i;
        this.zzaba = i2;
    }

    /* access modifiers changed from: protected */
    public abstract void zzcx() throws IllegalAccessException, InvocationTargetException;

    /* renamed from: zzcz */
    public Void call() throws Exception {
        try {
            long nanoTime = System.nanoTime();
            Method zza = this.zzvp.zza(this.className, this.zzaau);
            this.zzaaw = zza;
            if (zza == null) {
                return null;
            }
            zzcx();
            zzdh zzcm = this.zzvp.zzcm();
            if (!(zzcm == null || this.zzaaz == Integer.MIN_VALUE)) {
                zzcm.zza(this.zzaba, this.zzaaz, (System.nanoTime() - nanoTime) / 1000);
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }
}
