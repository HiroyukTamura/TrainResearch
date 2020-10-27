package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

final /* synthetic */ class zzaiw implements Predicate {
    private final zzaga zzdcf;

    zzaiw(zzaga zzaga) {
        this.zzdcf = zzaga;
    }

    public final boolean apply(Object obj) {
        zzaga zzaga = (zzaga) obj;
        return (zzaga instanceof zzajd) && zzajd.zza((zzajd) zzaga).equals(this.zzdcf);
    }
}
