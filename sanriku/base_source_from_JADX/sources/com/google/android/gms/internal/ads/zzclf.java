package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.zzq;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class zzclf {
    private final zzdrh zzfur;
    private final zzegt<zzclo> zzgax;
    private final zzckw zzgcd;

    public zzclf(zzdrh zzdrh, zzckw zzckw, zzegt<zzclo> zzegt) {
        this.zzfur = zzdrh;
        this.zzgcd = zzckw;
        this.zzgax = zzegt;
    }

    private final <RetT> zzdri<RetT> zza(zzarj zzarj, zzclm<InputStream> zzclm, zzclm<InputStream> zzclm2, zzdqj<InputStream, RetT> zzdqj) {
        String str = zzarj.packageName;
        zzq.zzkw();
        return (zzdqr) zzdqw.zzb(zzdqr.zzg(zzaxa.zzep(str) ? zzdqw.immediateFailedFuture(new zzclc(0)) : zzdqw.zzb(zzclm.zzo(zzarj), ExecutionException.class, zzcle.zzbly, this.zzfur)).zzb(zzdqj, this.zzfur), zzclc.class, new zzclh(this, zzclm2, zzarj, zzdqj), this.zzfur);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zza(zzclm zzclm, zzarj zzarj, zzdqj zzdqj, zzclc zzclc) throws Exception {
        return zzdqw.zzb(zzclm.zzo(zzarj), zzdqj, (Executor) this.zzfur);
    }

    public final zzdri<zzarj> zzj(zzarj zzarj) {
        zzclg zzclg = new zzclg(zzarj);
        zzckw zzckw = this.zzgcd;
        zzckw.getClass();
        return zza(zzarj, (zzclm<InputStream>) zzclj.zza(zzckw), (zzclm<InputStream>) new zzcli(this), zzclg);
    }

    public final zzdri<Void> zzk(zzarj zzarj) {
        if (zzet.zzaq(zzarj.zzdpi)) {
            return zzdqw.immediateFailedFuture(new zzclp("Pool key missing from removeUrl call.", 1));
        }
        return zza(zzarj, (zzclm<InputStream>) new zzclk(this), (zzclm<InputStream>) new zzcln(this), zzcll.zzbly);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zzl(zzarj zzarj) {
        return this.zzgax.get().zzgl(zzarj.zzdpi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zzm(zzarj zzarj) {
        return this.zzgcd.zzgk(zzarj.zzdpi);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdri zzn(zzarj zzarj) {
        return this.zzgax.get().zzc(zzarj, Binder.getCallingUid());
    }
}
