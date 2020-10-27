package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;

public final class zzdhy implements zzawj, zzbrc {
    private final zzawo zzdtl;
    private final HashSet<zzawc> zzgvp = new HashSet<>();
    private final Context zzvf;

    public zzdhy(Context context, zzawo zzawo) {
        this.zzvf = context;
        this.zzdtl = zzawo;
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (i != 3) {
            this.zzdtl.zzb(this.zzgvp);
        }
    }

    public final synchronized void zza(HashSet<zzawc> hashSet) {
        this.zzgvp.clear();
        this.zzgvp.addAll(hashSet);
    }

    public final Bundle zzash() {
        return this.zzdtl.zza(this.zzvf, (zzawj) this);
    }
}
