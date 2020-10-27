package com.google.android.gms.internal.ads;

final /* synthetic */ class zzccj implements zzdqj {
    private final zzdri zzfvm;

    zzccj(zzdri zzdri) {
        this.zzfvm = zzdri;
    }

    public final zzdri zzf(Object obj) {
        return obj != null ? this.zzfvm : zzdqw.immediateFailedFuture(new zzcqm("Retrieve required value in native ad response failed.", 0));
    }
}
