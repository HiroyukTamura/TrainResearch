package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzdfz implements zzegz<zzdfw> {
    private final zzehm<zzbgy> zzenk;
    private final zzehm<zzdgz> zzfek;
    private final zzehm<Executor> zzfjj;
    private final zzehm<Context> zzgqo;
    private final zzehm<zzdeu<zzceo, zzcel>> zzgqp;
    private final zzehm<zzdez> zzgqq;
    private final zzehm<zzdhg> zzgqr;

    public zzdfz(zzehm<Context> zzehm, zzehm<Executor> zzehm2, zzehm<zzbgy> zzehm3, zzehm<zzdeu<zzceo, zzcel>> zzehm4, zzehm<zzdez> zzehm5, zzehm<zzdhg> zzehm6, zzehm<zzdgz> zzehm7) {
        this.zzgqo = zzehm;
        this.zzfjj = zzehm2;
        this.zzenk = zzehm3;
        this.zzgqp = zzehm4;
        this.zzgqq = zzehm5;
        this.zzgqr = zzehm6;
        this.zzfek = zzehm7;
    }

    public final /* synthetic */ Object get() {
        return new zzdfw(this.zzgqo.get(), this.zzfjj.get(), this.zzenk.get(), this.zzgqp.get(), this.zzgqq.get(), this.zzgqr.get(), this.zzfek.get());
    }
}
