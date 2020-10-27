package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public class zzew<K, V> extends zzed<K, V> implements Serializable {
    private final transient zzeu<K, ? extends zzer<V>> zza;
    private final transient int zzb;

    zzew(zzeu<K, ? extends zzer<V>> zzeu, int i) {
        this.zza = zzeu;
        this.zzb = i;
    }

    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public final /* synthetic */ Map zza() {
        return this.zza;
    }

    public final boolean zza(@NullableDecl Object obj) {
        return obj != null && super.zza(obj);
    }

    /* access modifiers changed from: package-private */
    public final Map<K, Collection<V>> zzb() {
        throw new AssertionError("should never be called");
    }
}
