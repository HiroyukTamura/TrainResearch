package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.measurement.internal.zzhc;

final class zzbf extends zzag.zzb {
    private final /* synthetic */ zzhc zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbf(zzag zzag, zzhc zzhc) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = zzhc;
    }

    /* access modifiers changed from: package-private */
    public final void zza() throws RemoteException {
        this.zzd.zzm.setEventInterceptor(new zzag.zza(this.zzc));
    }
}
