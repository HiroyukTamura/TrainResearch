package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzakp {
    @VisibleForTesting
    private static final zzayf<zzais> zzddx = new zzako();
    @VisibleForTesting
    private static final zzayf<zzais> zzddy = new zzakr();
    private final zzajf zzddz;

    public zzakp(Context context, zzazz zzazz, String str) {
        this.zzddz = new zzajf(context, zzazz, str, zzddx, zzddy);
    }

    public final <I, O> zzakh<I, O> zza(String str, zzaki<I> zzaki, zzakj<O> zzakj) {
        return new zzakq(this.zzddz, str, zzaki, zzakj);
    }

    public final zzaku zztc() {
        return new zzaku(this.zzddz);
    }
}
