package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Callable;

final /* synthetic */ class zzcui implements Callable {
    private final Uri zzdwc;
    private final zzcuh zzgkn;
    private final IObjectWrapper zzgkp;

    zzcui(zzcuh zzcuh, Uri uri, IObjectWrapper iObjectWrapper) {
        this.zzgkn = zzcuh;
        this.zzdwc = uri;
        this.zzgkp = iObjectWrapper;
    }

    public final Object call() {
        return this.zzgkn.zzb(this.zzdwc, this.zzgkp);
    }
}
