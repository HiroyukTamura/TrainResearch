package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbqj;
import com.google.android.gms.internal.ads.zzbuj;
import java.util.concurrent.Executor;

public final class zzdcz implements zzctx<zzblr> {
    private final Executor zzfhi;
    private final ViewGroup zzfiv;
    private final zzdhg zzgja;
    /* access modifiers changed from: private */
    public zzdri<zzblr> zzgjl;
    private final zzbgy zzgku;
    private final Context zzgqc;
    /* access modifiers changed from: private */
    public final zzddn zzgqd;
    /* access modifiers changed from: private */
    public final zzdeu<zzbll, zzblr> zzgqe;

    public zzdcz(Context context, Executor executor, zzbgy zzbgy, zzdeu<zzbll, zzblr> zzdeu, zzddn zzddn, zzdhg zzdhg) {
        this.zzgqc = context;
        this.zzfhi = executor;
        this.zzgku = zzbgy;
        this.zzgqe = zzdeu;
        this.zzgqd = zzddn;
        this.zzgja = zzdhg;
        this.zzfiv = new FrameLayout(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final synchronized zzblk zzb(zzdet zzdet) {
        zzbuj.zza zza;
        zzddn zza2 = zzddn.zza(this.zzgqd);
        zza = new zzbuj.zza();
        zza.zza((zzbrc) zza2, this.zzfhi);
        zza.zza((zzbsr) zza2, this.zzfhi);
        zza.zza((zzder) zza2);
        return this.zzgku.zzadd().zza(new zzbls(this.zzfiv)).zzb(new zzbqj.zza().zzcb(this.zzgqc).zza(((zzddd) zzdet).zzfll).zzair()).zzb(zza.zzajm());
    }

    public final boolean isLoading() {
        zzdri<zzblr> zzdri = this.zzgjl;
        return zzdri != null && !zzdri.isDone();
    }

    public final void zza(zzut zzut) {
        this.zzgja.zzb(zzut);
    }

    public final synchronized boolean zza(zzuj zzuj, String str, zzctw zzctw, zzctz<? super zzblr> zzctz) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (str == null) {
            zzazw.zzfa("Ad unit ID should not be null for app open ad.");
            this.zzfhi.execute(new zzddc(this));
            return false;
        } else if (this.zzgjl != null) {
            return false;
        } else {
            zzdhn.zze(this.zzgqc, zzuj.zzcej);
            zzdhe zzasc = this.zzgja.zzgr(str).zzd(zzum.zzpj()).zzh(zzuj).zzasc();
            zzddd zzddd = new zzddd((zzdde) null);
            zzddd.zzfll = zzasc;
            zzdri<zzblr> zza = this.zzgqe.zza(new zzdev(zzddd), new zzddb(this));
            this.zzgjl = zza;
            zzdqw.zza(zza, new zzdde(this, zzctz, zzddd), this.zzfhi);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzare() {
        this.zzgqd.onAdFailedToLoad(1);
    }
}
