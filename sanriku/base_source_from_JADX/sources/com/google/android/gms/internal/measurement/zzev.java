package com.google.android.gms.internal.measurement;

final class zzev extends zzeq<E> {
    private final transient int zza;
    private final transient int zzb;
    private final /* synthetic */ zzeq zzc;

    zzev(zzeq zzeq, int i, int i2) {
        this.zzc = zzeq;
        this.zza = i;
        this.zzb = i2;
    }

    public final E get(int i) {
        zzdq.zza(i, this.zzb);
        return this.zzc.get(i + this.zza);
    }

    public final int size() {
        return this.zzb;
    }

    /* renamed from: zza */
    public final zzeq<E> subList(int i, int i2) {
        zzdq.zza(i, i2, this.zzb);
        zzeq zzeq = this.zzc;
        int i3 = this.zza;
        return (zzeq) zzeq.subList(i + i3, i2 + i3);
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzc.zze();
    }

    /* access modifiers changed from: package-private */
    public final int zzf() {
        return this.zzc.zzf() + this.zza;
    }

    /* access modifiers changed from: package-private */
    public final int zzg() {
        return this.zzc.zzf() + this.zza + this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzh() {
        return true;
    }
}
