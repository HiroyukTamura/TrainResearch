package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

public final class zzmg implements zzmj, zzmk {
    private final Uri uri;
    private final zzdns zzadv;
    private final zzhr zzadz;
    private zzhp zzaeg;
    private final int zzbav;
    private final zzmf zzbaw;
    private zzmj zzbax;
    private final String zzbaz = null;
    private final zznt zzbcd;
    private final zzjn zzbce;
    private final int zzbcf;
    private boolean zzbcg;

    public zzmg(Uri uri2, zznt zznt, zzjn zzjn, int i, zzdns zzdns, zzmf zzmf, String str, int i2) {
        this.uri = uri2;
        this.zzbcd = zznt;
        this.zzbce = zzjn;
        this.zzbav = i;
        this.zzadv = zzdns;
        this.zzbaw = zzmf;
        this.zzbcf = i2;
        this.zzadz = new zzhr();
    }

    public final zzmi zza(int i, zzns zzns) {
        zzoh.checkArgument(i == 0);
        return new zzly(this.uri, this.zzbcd.zzio(), this.zzbce.zzgq(), this.zzbav, this.zzadv, this.zzbaw, this, zzns, (String) null, this.zzbcf);
    }

    public final void zza(zzgt zzgt, boolean z, zzmj zzmj) {
        this.zzbax = zzmj;
        zzmy zzmy = new zzmy(-9223372036854775807L, false);
        this.zzaeg = zzmy;
        zzmj.zzb(zzmy, (Object) null);
    }

    public final void zzb(zzhp zzhp, Object obj) {
        boolean z = false;
        if (zzhp.zza(0, this.zzadz, false).zzaht != -9223372036854775807L) {
            z = true;
        }
        if (!this.zzbcg || z) {
            this.zzaeg = zzhp;
            this.zzbcg = z;
            this.zzbax.zzb(zzhp, (Object) null);
        }
    }

    public final void zzb(zzmi zzmi) {
        ((zzly) zzmi).release();
    }

    public final void zzhy() throws IOException {
    }

    public final void zzhz() {
        this.zzbax = null;
    }
}
