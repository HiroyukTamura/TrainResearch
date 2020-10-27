package com.google.android.gms.internal.ads;

final class zzauh implements zzdqx<Void> {
    private final /* synthetic */ zzdri zzdsb;

    zzauh(zzaue zzaue, zzdri zzdri) {
        this.zzdsb = zzdri;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        Void voidR = (Void) obj;
        zzaue.zzdro.remove(this.zzdsb);
    }

    public final void zzb(Throwable th) {
        zzaue.zzdro.remove(this.zzdsb);
    }
}
