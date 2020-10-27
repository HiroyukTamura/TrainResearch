package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzsv;
import com.google.android.gms.internal.ads.zztf;

public final class zzcgs implements zzbrc, zzbrp, zzbsm, zzbtm, zzbuf, zzub {
    private final zzst zzfyd;
    private boolean zzfye = false;
    private boolean zzfyf = false;

    public zzcgs(zzst zzst, zzdfa zzdfa) {
        this.zzfyd = zzst;
        zzst.zza(zzsv.zza.C2668zza.AD_REQUEST);
        if (zzdfa != null) {
            zzst.zza(zzsv.zza.C2668zza.REQUEST_IS_PREFETCH);
        }
    }

    public final synchronized void onAdClicked() {
        if (!this.zzfyf) {
            this.zzfyd.zza(zzsv.zza.C2668zza.AD_FIRST_CLICK);
            this.zzfyf = true;
            return;
        }
        this.zzfyd.zza(zzsv.zza.C2668zza.AD_SUBSEQUENT_CLICK);
    }

    public final void onAdFailedToLoad(int i) {
        zzst zzst;
        zzsv.zza.C2668zza zza;
        switch (i) {
            case 1:
                zzst = this.zzfyd;
                zza = zzsv.zza.C2668zza.AD_FAILED_TO_LOAD_INVALID_REQUEST;
                break;
            case 2:
                zzst = this.zzfyd;
                zza = zzsv.zza.C2668zza.AD_FAILED_TO_LOAD_NETWORK_ERROR;
                break;
            case 3:
                zzst = this.zzfyd;
                zza = zzsv.zza.C2668zza.AD_FAILED_TO_LOAD_NO_FILL;
                break;
            case 4:
                zzst = this.zzfyd;
                zza = zzsv.zza.C2668zza.AD_FAILED_TO_LOAD_TIMEOUT;
                break;
            case 5:
                zzst = this.zzfyd;
                zza = zzsv.zza.C2668zza.AD_FAILED_TO_LOAD_CANCELLED;
                break;
            case 6:
                zzst = this.zzfyd;
                zza = zzsv.zza.C2668zza.AD_FAILED_TO_LOAD_NO_ERROR;
                break;
            case 7:
                zzst = this.zzfyd;
                zza = zzsv.zza.C2668zza.AD_FAILED_TO_LOAD_NOT_FOUND;
                break;
            default:
                zzst = this.zzfyd;
                zza = zzsv.zza.C2668zza.AD_FAILED_TO_LOAD;
                break;
        }
        zzst.zza(zza);
    }

    public final synchronized void onAdImpression() {
        this.zzfyd.zza(zzsv.zza.C2668zza.AD_IMPRESSION);
    }

    public final void onAdLoaded() {
        this.zzfyd.zza(zzsv.zza.C2668zza.AD_LOADED);
    }

    public final void zzaja() {
        this.zzfyd.zza(zzsv.zza.C2668zza.REQUEST_FAILED_TO_LOAD_FROM_CACHE);
    }

    public final void zzb(zzdha zzdha) {
        this.zzfyd.zza((zzsw) new zzcgv(zzdha));
    }

    public final void zzbg(boolean z) {
        this.zzfyd.zza(z ? zzsv.zza.C2668zza.REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED : zzsv.zza.C2668zza.REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED);
    }

    public final void zzbh(boolean z) {
        this.zzfyd.zza(z ? zzsv.zza.C2668zza.NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED : zzsv.zza.C2668zza.NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED);
    }

    public final void zzc(zztf.zzb zzb) {
        this.zzfyd.zza((zzsw) new zzcgu(zzb));
        this.zzfyd.zza(zzsv.zza.C2668zza.REQUEST_LOADED_FROM_CACHE);
    }

    public final void zzd(zzarj zzarj) {
    }

    public final void zzd(zztf.zzb zzb) {
        this.zzfyd.zza((zzsw) new zzcgx(zzb));
        this.zzfyd.zza(zzsv.zza.C2668zza.REQUEST_SAVED_TO_CACHE);
    }

    public final void zze(zztf.zzb zzb) {
        this.zzfyd.zza((zzsw) new zzcgw(zzb));
        this.zzfyd.zza(zzsv.zza.C2668zza.REQUEST_PREFETCH_INTERCEPTED);
    }
}
