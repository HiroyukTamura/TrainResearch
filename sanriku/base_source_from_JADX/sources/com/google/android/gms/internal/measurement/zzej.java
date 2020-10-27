package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzej extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzef zza;

    zzej(zzef zzef) {
        this.zza = zzef;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(@NullableDecl Object obj) {
        Map zzb = this.zza.zzb();
        if (zzb != null) {
            return zzb.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int zzb2 = this.zza.zza(entry.getKey());
            return zzb2 != -1 && zzdo.zza(this.zza.zzc[zzb2], entry.getValue());
        }
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return this.zza.zzf();
    }

    public final boolean remove(@NullableDecl Object obj) {
        Map zzb = this.zza.zzb();
        if (zzb != null) {
            return zzb.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (this.zza.zza()) {
            return false;
        }
        int zzb2 = this.zza.zzi();
        Object key = entry.getKey();
        Object value = entry.getValue();
        Object zzc = this.zza.zze;
        zzef zzef = this.zza;
        int zza2 = zzem.zza(key, value, zzb2, zzc, zzef.zza, zzef.zzb, zzef.zzc);
        if (zza2 == -1) {
            return false;
        }
        this.zza.zza(zza2, zzb2);
        zzef.zzd(this.zza);
        this.zza.zzc();
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
