package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbqh;

public final class zzdel<RequestComponentT extends zzbqh<AdT>, AdT> implements zzdeu<RequestComponentT, AdT> {
    @Nullable
    private RequestComponentT zzgrq;
    private final zzdeu<RequestComponentT, AdT> zzgsd;

    public zzdel(zzdeu<RequestComponentT, AdT> zzdeu) {
        this.zzgsd = zzdeu;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzark */
    public final synchronized RequestComponentT zzarj() {
        return this.zzgrq;
    }

    public final synchronized zzdri<AdT> zza(zzdev zzdev, zzdew<RequestComponentT> zzdew) {
        if (zzdev.zzgsh != null) {
            RequestComponentT requestcomponentt = (zzbqh) zzdew.zzc(zzdev.zzgsi).zzaeg();
            this.zzgrq = requestcomponentt;
            return requestcomponentt.zzaed().zzb(zzdev.zzgsh);
        }
        zzdri<AdT> zza = this.zzgsd.zza(zzdev, zzdew);
        this.zzgrq = (zzbqh) this.zzgsd.zzarj();
        return zza;
    }
}
