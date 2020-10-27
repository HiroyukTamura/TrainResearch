package com.google.android.gms.internal.ads;

import p009e.p010a.p011a.p012a.C0681a;

final class zzayo implements zzy {
    private final /* synthetic */ String zzdxx;
    private final /* synthetic */ zzayp zzdxy;

    zzayo(zzaym zzaym, String str, zzayp zzayp) {
        this.zzdxx = str;
        this.zzdxy = zzayp;
    }

    public final void zzc(zzae zzae) {
        String str = this.zzdxx;
        String exc = zzae.toString();
        StringBuilder sb = new StringBuilder(C0681a.m336b(exc, C0681a.m336b(str, 21)));
        sb.append("Failed to load URL: ");
        sb.append(str);
        sb.append("\n");
        sb.append(exc);
        zzazw.zzfc(sb.toString());
        this.zzdxy.zzb(null);
    }
}
