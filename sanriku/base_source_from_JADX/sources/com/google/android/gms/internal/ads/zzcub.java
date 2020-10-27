package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzbqj;
import com.google.android.gms.internal.ads.zzbuj;
import java.util.concurrent.Executor;

public final class zzcub implements zzctx<zzbns> {
    private final zzbgy zzggh;
    private final Context zzgiz;
    private final zzdhg zzgja;
    private final zzctv zzgki;
    @Nullable
    private zzbod zzgkj;

    public zzcub(zzbgy zzbgy, Context context, zzctv zzctv, zzdhg zzdhg) {
        this.zzggh = zzbgy;
        this.zzgiz = context;
        this.zzgki = zzctv;
        this.zzgja = zzdhg;
    }

    public final boolean isLoading() {
        zzbod zzbod = this.zzgkj;
        return zzbod != null && zzbod.isLoading();
    }

    public final boolean zza(zzuj zzuj, String str, zzctw zzctw, zzctz<? super zzbns> zzctz) throws RemoteException {
        Executor zzacv;
        Runnable zzcud;
        zzq.zzkw();
        if (zzaxa.zzbd(this.zzgiz) && zzuj.zzceu == null) {
            zzazw.zzfa("Failed to load the ad because app ID is missing.");
            zzacv = this.zzggh.zzacv();
            zzcud = new zzcua(this);
        } else if (str == null) {
            zzazw.zzfa("Ad unit ID should not be null for NativeAdLoader.");
            zzacv = this.zzggh.zzacv();
            zzcud = new zzcud(this);
        } else {
            zzdhn.zze(this.zzgiz, zzuj.zzcej);
            zzdhe zzasc = this.zzgja.zzh(zzuj).zzdv(zzctw instanceof zzcty ? ((zzcty) zzctw).zzgkg : 1).zzasc();
            zzbyp zzaef = this.zzggh.zzadg().zza(new zzbqj.zza().zzcb(this.zzgiz).zza(zzasc).zzair()).zza(new zzbuj.zza().zza(this.zzgki.zzapq(), this.zzggh.zzacv()).zza(this.zzgki.zzapr(), this.zzggh.zzacv()).zza(this.zzgki.zzaps(), this.zzggh.zzacv()).zza(this.zzgki.zzapt(), this.zzggh.zzacv()).zza(this.zzgki.zzapp(), this.zzggh.zzacv()).zza(zzasc.zzgvc, this.zzggh.zzacv()).zzajm()).zza(this.zzgki.zzapo()).zzaef();
            this.zzggh.zzadk().zzdw(1);
            zzbod zzbod = new zzbod(this.zzggh.zzacx(), this.zzggh.zzacw(), zzaef.zzaed().zzaii());
            this.zzgkj = zzbod;
            zzbod.zza((zzdqx<zzbns>) new zzcuc(this, zzctz, zzaef));
            return true;
        }
        zzacv.execute(zzcud);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzapu() {
        this.zzgki.zzapr().onAdFailedToLoad(1);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzapv() {
        this.zzgki.zzapr().onAdFailedToLoad(8);
    }
}
