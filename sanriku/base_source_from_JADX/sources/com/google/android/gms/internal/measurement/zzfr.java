package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzfr<K> extends zzey<K> {
    private final transient zzeu<K, ?> zza;
    private final transient zzeq<K> zzb;

    zzfr(zzeu<K, ?> zzeu, zzeq<K> zzeq) {
        this.zza = zzeu;
        this.zzb = zzeq;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.get(obj) != null;
    }

    public final int size() {
        return this.zza.size();
    }

    /* access modifiers changed from: package-private */
    public final int zzb(Object[] objArr, int i) {
        return zzc().zzb(objArr, i);
    }

    /* renamed from: zzb */
    public final zzfz<K> iterator() {
        return (zzfz) zzc().iterator();
    }

    public final zzeq<K> zzc() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh() {
        return true;
    }
}
