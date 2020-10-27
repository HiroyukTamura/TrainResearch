package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.LinkedList;

final class zzdil {
    private final int maxEntries;
    private final LinkedList<zzdiv<?>> zzgwc = new LinkedList<>();
    private final int zzgwd;
    private final zzdjm zzgwe;

    public zzdil(int i, int i2) {
        this.maxEntries = i;
        this.zzgwd = i2;
        this.zzgwe = new zzdjm();
    }

    private final void zzasp() {
        while (!this.zzgwc.isEmpty()) {
            if (zzq.zzld().currentTimeMillis() - this.zzgwc.getFirst().zzgxv >= ((long) this.zzgwd)) {
                this.zzgwe.zzatk();
                this.zzgwc.remove();
            } else {
                return;
            }
        }
    }

    public final long getCreationTimeMillis() {
        return this.zzgwe.getCreationTimeMillis();
    }

    public final int size() {
        zzasp();
        return this.zzgwc.size();
    }

    public final zzdiv<?> zzask() {
        this.zzgwe.zzati();
        zzasp();
        if (this.zzgwc.isEmpty()) {
            return null;
        }
        zzdiv<?> remove = this.zzgwc.remove();
        if (remove != null) {
            this.zzgwe.zzatj();
        }
        return remove;
    }

    public final long zzasl() {
        return this.zzgwe.zzasl();
    }

    public final int zzasm() {
        return this.zzgwe.zzasm();
    }

    public final String zzasn() {
        return this.zzgwe.zzasy();
    }

    public final zzdjl zzaso() {
        return this.zzgwe.zzatl();
    }

    public final boolean zzb(zzdiv<?> zzdiv) {
        this.zzgwe.zzati();
        zzasp();
        if (this.zzgwc.size() == this.maxEntries) {
            return false;
        }
        this.zzgwc.add(zzdiv);
        return true;
    }
}
