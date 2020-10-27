package com.google.android.gms.internal.ads;

final class zzbhy implements zzbyo {
    private zzbqj zzept;
    private zzdha zzepv;
    private zzbyl zzepw;
    private zzdfa zzepx;
    private zzdee zzepy;
    private final /* synthetic */ zzbhw zzewb;
    private zzbuj zzewc;

    private zzbhy(zzbhw zzbhw) {
        this.zzewb = zzbhw;
    }

    public final /* synthetic */ zzbqg zza(zzdee zzdee) {
        this.zzepy = zzdee;
        return this;
    }

    public final /* synthetic */ zzbqg zza(zzdfa zzdfa) {
        this.zzepx = zzdfa;
        return this;
    }

    public final /* synthetic */ zzbqg zza(zzdha zzdha) {
        this.zzepv = zzdha;
        return this;
    }

    public final /* synthetic */ zzbyo zza(zzbqj zzbqj) {
        this.zzept = (zzbqj) zzehf.checkNotNull(zzbqj);
        return this;
    }

    public final /* synthetic */ zzbyo zza(zzbuj zzbuj) {
        this.zzewc = (zzbuj) zzehf.checkNotNull(zzbuj);
        return this;
    }

    public final /* synthetic */ zzbyo zza(zzbyl zzbyl) {
        this.zzepw = (zzbyl) zzehf.checkNotNull(zzbyl);
        return this;
    }

    /* renamed from: zzaef */
    public final zzbyp zzaeg() {
        zzehf.zza(this.zzewc, zzbuj.class);
        zzehf.zza(this.zzept, zzbqj.class);
        zzehf.zza(this.zzepw, zzbyl.class);
        return new zzbhx(this.zzewb, this.zzepw, new zzbox(), new zzdhw(), new zzbpx(), new zzcin(), this.zzewc, this.zzept, new zzdie(), this.zzepv, this.zzepx, this.zzepy);
    }
}
