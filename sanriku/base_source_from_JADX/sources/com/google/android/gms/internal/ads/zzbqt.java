package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

public final class zzbqt implements zzegz<zzaun> {
    private final zzehm<Context> zzenp;
    private final zzehm<zzdgo> zzfia;
    private final zzbqu zzfnc;
    private final zzehm<zzazz> zzfnd;
    private final zzehm<zzaup> zzfne;

    private zzbqt(zzbqu zzbqu, zzehm<Context> zzehm, zzehm<zzazz> zzehm2, zzehm<zzdgo> zzehm3, zzehm<zzaup> zzehm4) {
        this.zzfnc = zzbqu;
        this.zzenp = zzehm;
        this.zzfnd = zzehm2;
        this.zzfia = zzehm3;
        this.zzfne = zzehm4;
    }

    public static zzbqt zza(zzbqu zzbqu, zzehm<Context> zzehm, zzehm<zzazz> zzehm2, zzehm<zzdgo> zzehm3, zzehm<zzaup> zzehm4) {
        return new zzbqt(zzbqu, zzehm, zzehm2, zzehm3, zzehm4);
    }

    @Nullable
    public final /* synthetic */ Object get() {
        Context context = this.zzenp.get();
        zzazz zzazz = this.zzfnd.get();
        zzdgo zzdgo = this.zzfia.get();
        zzaup zzaup = this.zzfne.get();
        if (zzdgo.zzgtv != null) {
            return new zzaue(context, zzazz, zzdgo.zzgtv, zzdgo.zzgtr.zzdku, zzaup);
        }
        return null;
    }
}
