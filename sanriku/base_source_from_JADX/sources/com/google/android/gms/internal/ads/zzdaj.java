package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzdaj<T> {
    private final Executor executor;
    private final Set<zzdak<? extends zzdah<T>>> zzgoo;

    public zzdaj(Executor executor2, Set<zzdak<? extends zzdah<T>>> set) {
        this.executor = executor2;
        this.zzgoo = set;
    }

    public final zzdri<T> zzt(T t) {
        ArrayList arrayList = new ArrayList(this.zzgoo.size());
        for (zzdak next : this.zzgoo) {
            zzdri zzaqa = next.zzaqa();
            if (zzabn.zzcxb.get().booleanValue()) {
                zzaqa.addListener(new zzdam(next, zzq.zzld().elapsedRealtime()), zzbab.zzdzw);
            }
            arrayList.add(zzaqa);
        }
        return zzdqw.zzk(arrayList).zza(new zzdal(arrayList, t), this.executor);
    }
}
