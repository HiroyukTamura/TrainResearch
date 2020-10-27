package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.internal.ads.zzbqj;
import com.google.android.gms.internal.ads.zzbuj;
import java.util.concurrent.Executor;

public final class zzdfw implements zzctx<zzcel> {
    private final Executor zzfhi;
    private final zzdgz zzfmx;
    private final zzdhg zzgja;
    private final zzbgy zzgku;
    private final Context zzgqc;
    /* access modifiers changed from: private */
    public final zzdeu<zzceo, zzcel> zzgqe;
    /* access modifiers changed from: private */
    public final zzdez zzgst;
    private zzdri<zzcel> zzgsu;

    public zzdfw(Context context, Executor executor, zzbgy zzbgy, zzdeu<zzceo, zzcel> zzdeu, zzdez zzdez, zzdhg zzdhg, zzdgz zzdgz) {
        this.zzgqc = context;
        this.zzfhi = executor;
        this.zzgku = zzbgy;
        this.zzgqe = zzdeu;
        this.zzgst = zzdez;
        this.zzgja = zzdhg;
        this.zzfmx = zzdgz;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzcer zze(zzdet zzdet) {
        zzdga zzdga = (zzdga) zzdet;
        zzdez zza = zzdez.zza(this.zzgst);
        return this.zzgku.zzadh().zze(new zzbqj.zza().zzcb(this.zzgqc).zza(zzdga.zzfll).zzfv(zzdga.zzgsr).zza(this.zzfmx).zzair()).zze(new zzbuj.zza().zza((zzbqx) zza, this.zzfhi).zza((zzbsm) zza, this.zzfhi).zza((zzbrc) zza, this.zzfhi).zza((AdMetadataListener) zza, this.zzfhi).zza((zzbrl) zza, this.zzfhi).zza((zzbtb) zza, this.zzfhi).zza((zzder) zza).zzajm());
    }

    public final boolean isLoading() {
        zzdri<zzcel> zzdri = this.zzgsu;
        return zzdri != null && !zzdri.isDone();
    }

    public final boolean zza(zzuj zzuj, String str, zzctw zzctw, zzctz<? super zzcel> zzctz) throws RemoteException {
        zzast zzast = new zzast(zzuj, str);
        String str2 = zzctw instanceof zzdft ? ((zzdft) zzctw).zzgsr : null;
        if (zzast.zzbsc == null) {
            zzazw.zzfa("Ad unit ID should not be null for rewarded video ad.");
            this.zzfhi.execute(new zzdfv(this));
            return false;
        }
        zzdri<zzcel> zzdri = this.zzgsu;
        if (zzdri != null && !zzdri.isDone()) {
            return false;
        }
        zzdhn.zze(this.zzgqc, zzast.zzdlx.zzcej);
        zzdhe zzasc = this.zzgja.zzgr(zzast.zzbsc).zzd(zzum.zzpi()).zzh(zzast.zzdlx).zzasc();
        zzdga zzdga = new zzdga((zzdfx) null);
        zzdga.zzfll = zzasc;
        zzdga.zzgsr = str2;
        zzdri<zzcel> zza = this.zzgqe.zza(new zzdev(zzdga), new zzdfy(this));
        this.zzgsu = zza;
        zzdqw.zza(zza, new zzdfx(this, zzctz, zzdga), this.zzfhi);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzarq() {
        this.zzgst.onAdFailedToLoad(1);
    }

    /* access modifiers changed from: package-private */
    public final void zzdt(int i) {
        this.zzgja.zzasb().zzdu(i);
    }
}
