package com.google.android.gms.internal.measurement;

import p009e.p010a.p011a.p012a.C0681a;

final class zzfu<E> extends zzey<E> {
    private final transient E zza;
    private transient int zzb;

    zzfu(E e) {
        this.zza = zzdq.zza(e);
    }

    zzfu(E e, int i) {
        this.zza = e;
        this.zzb = i;
    }

    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int hashCode = this.zza.hashCode();
        this.zzb = hashCode;
        return hashCode;
    }

    public final int size() {
        return 1;
    }

    public final String toString() {
        String obj = this.zza.toString();
        StringBuilder sb = new StringBuilder(C0681a.m336b(obj, 2));
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final boolean zza() {
        return this.zzb != 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzb(Object[] objArr, int i) {
        objArr[i] = this.zza;
        return i + 1;
    }

    /* renamed from: zzb */
    public final zzfz<E> iterator() {
        return new zzfh(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final zzeq<E> zzd() {
        return zzeq.zza(this.zza);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh() {
        return false;
    }
}
