package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzcvy implements zzegz<zzcvw> {
    private final zzehm<Set<String>> zzgma;

    private zzcvy(zzehm<Set<String>> zzehm) {
        this.zzgma = zzehm;
    }

    public static zzcvy zzak(zzehm<Set<String>> zzehm) {
        return new zzcvy(zzehm);
    }

    public static zzcvw zzd(Set<String> set) {
        return new zzcvw(set);
    }

    public final /* synthetic */ Object get() {
        return zzd(this.zzgma.get());
    }
}
