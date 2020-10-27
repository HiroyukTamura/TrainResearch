package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import p009e.p010a.p011a.p012a.C0681a;

final class zzdjm {
    private int zzgym = 0;
    private final long zzgyn;
    private final zzdjl zzgyo = new zzdjl();
    private long zzgyp;
    private int zzgyq = 0;
    private int zzgyr = 0;

    public zzdjm() {
        long currentTimeMillis = zzq.zzld().currentTimeMillis();
        this.zzgyn = currentTimeMillis;
        this.zzgyp = currentTimeMillis;
    }

    public final long getCreationTimeMillis() {
        return this.zzgyn;
    }

    public final long zzasl() {
        return this.zzgyp;
    }

    public final int zzasm() {
        return this.zzgyq;
    }

    public final String zzasy() {
        StringBuilder a = C0681a.m330a("Created: ");
        a.append(this.zzgyn);
        a.append(" Last accessed: ");
        a.append(this.zzgyp);
        a.append(" Accesses: ");
        a.append(this.zzgyq);
        a.append("\nEntries retrieved: Valid: ");
        a.append(this.zzgyr);
        a.append(" Stale: ");
        a.append(this.zzgym);
        return a.toString();
    }

    public final void zzati() {
        this.zzgyp = zzq.zzld().currentTimeMillis();
        this.zzgyq++;
    }

    public final void zzatj() {
        this.zzgyr++;
        this.zzgyo.zzgyl = true;
    }

    public final void zzatk() {
        this.zzgym++;
        this.zzgyo.zzgym++;
    }

    public final zzdjl zzatl() {
        zzdjl zzdjl = (zzdjl) this.zzgyo.clone();
        zzdjl zzdjl2 = this.zzgyo;
        zzdjl2.zzgyl = false;
        zzdjl2.zzgym = 0;
        return zzdjl;
    }
}
