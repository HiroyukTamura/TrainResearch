package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

public class zzbwx {
    @Nullable
    private final zzbek zzdce;
    private final zzbxz zzfoz;

    public zzbwx(zzbxz zzbxz) {
        this(zzbxz, (zzbek) null);
    }

    public zzbwx(zzbxz zzbxz, @Nullable zzbek zzbek) {
        this.zzfoz = zzbxz;
        this.zzdce = zzbek;
    }

    public Set<zzbvt<zzbqx>> zza(zzbyd zzbyd) {
        return Collections.singleton(zzbvt.zzb(zzbyd, zzbab.zzdzw));
    }

    @Nullable
    public final zzbek zzags() {
        return this.zzdce;
    }

    public final zzbxz zzajv() {
        return this.zzfoz;
    }

    @Nullable
    public final View zzajw() {
        zzbek zzbek = this.zzdce;
        if (zzbek != null) {
            return zzbek.getWebView();
        }
        return null;
    }

    @Nullable
    public final View zzajx() {
        zzbek zzbek = this.zzdce;
        if (zzbek == null) {
            return null;
        }
        return zzbek.getWebView();
    }

    public final zzbvt<zzbtq> zzb(Executor executor) {
        return new zzbvt<>(new zzbwz(this.zzdce), executor);
    }
}
