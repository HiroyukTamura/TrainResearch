package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;

final class zzqu implements ValueCallback<String> {
    private final /* synthetic */ zzqr zzbrg;

    zzqu(zzqr zzqr) {
        this.zzbrg = zzqr;
    }

    public final /* synthetic */ void onReceiveValue(Object obj) {
        zzqr zzqr = this.zzbrg;
        zzqr.zzbrc.zza(zzqr.zzbqz, zzqr.zzbra, (String) obj, zzqr.zzbrb);
    }
}
