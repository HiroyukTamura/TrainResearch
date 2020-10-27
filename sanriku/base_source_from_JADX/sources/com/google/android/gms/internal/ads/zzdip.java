package com.google.android.gms.internal.ads;

import p009e.p010a.p011a.p012a.C0681a;

final class zzdip {
    private final zzdis zzgwj = new zzdis();
    private int zzgwk;
    private int zzgwl;
    private int zzgwm;
    private int zzgwn;
    private int zzgwo;

    zzdip() {
    }

    public final void zzass() {
        this.zzgwm++;
    }

    public final void zzast() {
        this.zzgwn++;
    }

    public final void zzasu() {
        this.zzgwk++;
        this.zzgwj.zzgxd = true;
    }

    public final void zzasv() {
        this.zzgwl++;
        this.zzgwj.zzgxe = true;
    }

    public final void zzasw() {
        this.zzgwo++;
    }

    public final zzdis zzasx() {
        zzdis zzdis = (zzdis) this.zzgwj.clone();
        zzdis zzdis2 = this.zzgwj;
        zzdis2.zzgxd = false;
        zzdis2.zzgxe = false;
        return zzdis;
    }

    public final String zzasy() {
        StringBuilder a = C0681a.m330a("\n\tPool does not exist: ");
        a.append(this.zzgwm);
        a.append("\n\tNew pools created: ");
        a.append(this.zzgwk);
        a.append("\n\tPools removed: ");
        a.append(this.zzgwl);
        a.append("\n\tEntries added: ");
        a.append(this.zzgwo);
        a.append("\n\tNo entries retrieved: ");
        return C0681a.m322a(a, this.zzgwn, "\n");
    }
}
