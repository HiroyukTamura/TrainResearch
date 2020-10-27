package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;

final class zzctl implements zzdqx<zzblx> {
    private final /* synthetic */ zzbmt zzgjo;
    private final /* synthetic */ zzcti zzgjp;

    zzctl(zzcti zzcti, zzbmt zzbmt) {
        this.zzgjp = zzcti;
        this.zzgjo = zzbmt;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzblx zzblx = (zzblx) obj;
        synchronized (this.zzgjp) {
            zzdri unused = this.zzgjp.zzgjl = null;
            if (this.zzgjp.zzgiu != null) {
                this.zzgjp.zzgiu.destroy();
            }
            zzblx unused2 = this.zzgjp.zzgiu = zzblx;
            this.zzgjp.zzfiv.removeAllViews();
            if (zzblx.zzahe() != null) {
                ViewParent parent = zzblx.zzahe().getParent();
                if (parent instanceof ViewGroup) {
                    String mediationAdapterClassName = this.zzgjp.getMediationAdapterClassName();
                    StringBuilder sb = new StringBuilder(String.valueOf(mediationAdapterClassName).length() + 78);
                    sb.append("Banner view provided from ");
                    sb.append(mediationAdapterClassName);
                    sb.append(" already has a parent view. Removing its old parent.");
                    zzazw.zzfc(sb.toString());
                    ((ViewGroup) parent).removeView(zzblx.zzahe());
                }
            }
            this.zzgjp.zzfiv.addView(zzblx.zzahe());
            zzblx.zzahk();
            this.zzgjp.zzgji.zzdp(zzblx.zzahj());
        }
    }

    public final void zzb(Throwable th) {
        synchronized (this.zzgjp) {
            zzdri unused = this.zzgjp.zzgjl = null;
            this.zzgjo.zzaee().onAdFailedToLoad(zzcjk.zzd(th));
            this.zzgjp.zzgji.zzdp(60);
            zzdhn.zzc(th, "BannerAdManagerShim.onFailure");
        }
    }
}
