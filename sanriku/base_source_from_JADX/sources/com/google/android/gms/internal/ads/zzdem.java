package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbqh;

public final class zzdem<RequestComponentT extends zzbqh<AdT>, AdT> implements zzdeu<RequestComponentT, AdT> {
    @Nullable
    private RequestComponentT zzgrq;

    /* access modifiers changed from: private */
    /* renamed from: zzark */
    public final synchronized RequestComponentT zzarj() {
        return this.zzgrq;
    }

    public final synchronized zzdri<AdT> zza(zzdev zzdev, zzdew<RequestComponentT> zzdew) {
        RequestComponentT requestcomponentt;
        requestcomponentt = (zzbqh) zzdew.zzc(zzdev.zzgsi).zzaeg();
        this.zzgrq = requestcomponentt;
        return requestcomponentt.zzaed().zzaii();
    }
}
