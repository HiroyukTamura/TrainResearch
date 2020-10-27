package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdqd;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class zzdqi<V, C> extends zzdqd<V, C> {
    private List<zzdod<V>> zzhho;

    zzdqi(zzdot<? extends zzdri<? extends V>> zzdot, boolean z) {
        super(zzdot, true, true);
        this.zzhho = zzdot.isEmpty() ? zzdou.zzavy() : zzdpc.zzej(zzdot.size());
        for (int i = 0; i < zzdot.size(); i++) {
            this.zzhho.add((Object) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzdqd.zza zza) {
        super.zza(zza);
        this.zzhho = null;
    }

    /* access modifiers changed from: package-private */
    public final void zzawj() {
        List<zzdod<V>> list = this.zzhho;
        if (list != null) {
            set(zzi(list));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i, @NullableDecl V v) {
        List<zzdod<V>> list = this.zzhho;
        if (list != null) {
            list.set(i, zzdod.zzz(v));
        }
    }

    /* access modifiers changed from: package-private */
    public abstract C zzi(List<zzdod<V>> list);
}
