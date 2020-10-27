package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdeq implements zzdnx<zzclc, zzdes> {
    private final /* synthetic */ zzdeo zzgsg;

    zzdeq(zzdeo zzdeo) {
        this.zzgsg = zzdeo;
    }

    @NullableDecl
    public final /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzazw.zzc("", (zzclc) obj);
        zzawr.zzeg("Failed to get a cache key, reverting to legacy flow.");
        zzdeo zzdeo = this.zzgsg;
        zzdes unused = zzdeo.zzgsf = new zzdes((zzarj) null, zzdeo.zzarp(), (zzdeq) null);
        return this.zzgsg.zzgsf;
    }
}
