package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzel extends AbstractSet<K> {
    private final /* synthetic */ zzef zza;

    zzel(zzef zzef) {
        this.zza = zzef;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(Object obj) {
        return this.zza.containsKey(obj);
    }

    public final Iterator<K> iterator() {
        return this.zza.zze();
    }

    public final boolean remove(@NullableDecl Object obj) {
        Map zzb = this.zza.zzb();
        return zzb != null ? zzb.keySet().remove(obj) : this.zza.zzb(obj) != zzef.zzd;
    }

    public final int size() {
        return this.zza.size();
    }
}
