package com.google.android.gms.internal.measurement;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzes<E> extends zzeq<E> {
    private final transient zzeq<E> zza;

    zzes(zzeq<E> zzeq) {
        this.zza = zzeq;
    }

    private final int zza(int i) {
        return (size() - 1) - i;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.contains(obj);
    }

    public final E get(int i) {
        zzdq.zza(i, size());
        return this.zza.get(zza(i));
    }

    public final int indexOf(@NullableDecl Object obj) {
        int lastIndexOf = this.zza.lastIndexOf(obj);
        if (lastIndexOf >= 0) {
            return zza(lastIndexOf);
        }
        return -1;
    }

    public final int lastIndexOf(@NullableDecl Object obj) {
        int indexOf = this.zza.indexOf(obj);
        if (indexOf >= 0) {
            return zza(indexOf);
        }
        return -1;
    }

    public final int size() {
        return this.zza.size();
    }

    /* renamed from: zza */
    public final zzeq<E> subList(int i, int i2) {
        zzdq.zza(i, i2, size());
        return ((zzeq) this.zza.subList(size() - i2, size() - i)).zzd();
    }

    public final zzeq<E> zzd() {
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh() {
        return this.zza.zzh();
    }
}
