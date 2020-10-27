package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zzbvs extends zzbui<zzpz> implements zzpz {
    private final zzdgo zzfkd;
    private Map<View, zzpv> zzfol = new WeakHashMap(1);
    private final Context zzvf;

    public zzbvs(Context context, Set<zzbvt<zzpz>> set, zzdgo zzdgo) {
        super(set);
        this.zzvf = context;
        this.zzfkd = zzdgo;
    }

    public final synchronized void zza(zzqa zzqa) {
        zza(new zzbvv(zzqa));
    }

    public final synchronized void zzu(View view) {
        zzpv zzpv = this.zzfol.get(view);
        if (zzpv == null) {
            zzpv = new zzpv(this.zzvf, view);
            zzpv.zza((zzpz) this);
            this.zzfol.put(view, zzpv);
        }
        if (this.zzfkd != null && this.zzfkd.zzdow) {
            if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcmw)).booleanValue()) {
                zzpv.zzen(((Long) zzvj.zzpv().zzd(zzzz.zzcmv)).longValue());
                return;
            }
        }
        zzpv.zzlv();
    }

    public final synchronized void zzv(View view) {
        if (this.zzfol.containsKey(view)) {
            this.zzfol.get(view).zzb(this);
            this.zzfol.remove(view);
        }
    }
}
