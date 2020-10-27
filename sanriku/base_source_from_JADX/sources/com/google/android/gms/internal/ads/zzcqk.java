package com.google.android.gms.internal.ads;

import java.util.Iterator;

public final class zzcqk {
    private final zzchz zzfiq;
    private final zzcfu zzfxs;
    private final zzdhm zzfyt;

    public zzcqk(zzdhm zzdhm, zzcfu zzcfu, zzchz zzchz) {
        this.zzfyt = zzdhm;
        this.zzfxs = zzcfu;
        this.zzfiq = zzchz;
    }

    public final void zza(zzdgq zzdgq, zzdgo zzdgo, int i, zzcnn zzcnn, long j) {
        zzcfv zzcfv;
        zzchy zzq = this.zzfiq.zzaoa().zza(zzdgq).zzc(zzdgo).zzq("action", "adapter_status").zzq("adapter_l", String.valueOf(j));
        zzq.zzq("sc", Integer.toString(i));
        if (zzcnn != null) {
            zzq.zzq("arec", Integer.toString(zzcnn.zzapd()));
            String zzgs = this.zzfyt.zzgs(zzcnn.getMessage());
            if (zzgs != null) {
                zzq.zzq("areec", zzgs);
            }
        }
        zzcfu zzcfu = this.zzfxs;
        Iterator<String> it = zzdgo.zzgts.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzcfv = null;
                break;
            }
            zzcfv = zzcfu.zzge(it.next());
            if (zzcfv != null) {
                break;
            }
        }
        if (zzcfv != null) {
            zzq.zzq("ancn", zzcfv.zzdbg);
            zzaoj zzaoj = zzcfv.zzfxp;
            if (zzaoj != null) {
                zzq.zzq("adapter_v", zzaoj.toString());
            }
            zzaoj zzaoj2 = zzcfv.zzfxq;
            if (zzaoj2 != null) {
                zzq.zzq("adapter_sv", zzaoj2.toString());
            }
        }
        zzq.zzany();
    }
}
