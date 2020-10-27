package com.google.android.gms.internal.ads;

public final class zzdjr implements zzegz<zzdrh> {
    public static zzdjr zzatp() {
        return zzdju.zzgyu;
    }

    public final /* synthetic */ Object get() {
        zzdrh zzdrh;
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcrx)).booleanValue()) {
            zzdrh = zzbab.zzdzt;
        } else {
            zzdrh = ((Boolean) zzvj.zzpv().zzd(zzzz.zzcrw)).booleanValue() ? zzbab.zzdzr : zzbab.zzdzv;
        }
        return (zzdrh) zzehf.zza(zzdrh, "Cannot return null from a non-@Nullable @Provides method");
    }
}
