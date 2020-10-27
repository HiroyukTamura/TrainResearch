package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

public class zzbns {
    protected final zzdha zzfgj;
    protected final zzdgo zzfkd;
    private final zzbrr zzfkq;
    private final zzbsh zzfkr;
    @Nullable
    private final zzder zzfks;
    private final zzbqs zzfkt;

    protected zzbns(zzbnv zzbnv) {
        this.zzfgj = zzbnv.zzfgj;
        this.zzfkd = zzbnv.zzfkd;
        this.zzfkq = zzbnv.zzfkq;
        this.zzfkr = zzbnv.zzfkr;
        this.zzfks = zzbnv.zzfks;
        this.zzfkt = zzbnv.zzfkt;
    }

    public void destroy() {
        this.zzfkq.zzbz((Context) null);
    }

    public void zzahk() {
        this.zzfkr.onAdLoaded();
    }

    public final zzbrr zzahz() {
        return this.zzfkq;
    }

    public final zzbqs zzaia() {
        return this.zzfkt;
    }

    @Nullable
    public final zzder zzaib() {
        return this.zzfks;
    }
}
