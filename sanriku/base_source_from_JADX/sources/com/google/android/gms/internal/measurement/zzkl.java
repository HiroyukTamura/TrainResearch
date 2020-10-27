package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class zzkl implements Iterator<Map.Entry<K, V>> {
    private int zza;
    private boolean zzb;
    private Iterator<Map.Entry<K, V>> zzc;
    private final /* synthetic */ zzkd zzd;

    private zzkl(zzkd zzkd) {
        this.zzd = zzkd;
        this.zza = -1;
    }

    /* synthetic */ zzkl(zzkd zzkd, zzkg zzkg) {
        this(zzkd);
    }

    private final Iterator<Map.Entry<K, V>> zza() {
        if (this.zzc == null) {
            this.zzc = this.zzd.zzc.entrySet().iterator();
        }
        return this.zzc;
    }

    public final boolean hasNext() {
        return this.zza + 1 < this.zzd.zzb.size() || (!this.zzd.zzc.isEmpty() && zza().hasNext());
    }

    public final /* synthetic */ Object next() {
        this.zzb = true;
        int i = this.zza + 1;
        this.zza = i;
        return (Map.Entry) (i < this.zzd.zzb.size() ? this.zzd.zzb.get(this.zza) : zza().next());
    }

    public final void remove() {
        if (this.zzb) {
            this.zzb = false;
            this.zzd.zzf();
            if (this.zza < this.zzd.zzb.size()) {
                zzkd zzkd = this.zzd;
                int i = this.zza;
                this.zza = i - 1;
                Object unused = zzkd.zzc(i);
                return;
            }
            zza().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }
}
