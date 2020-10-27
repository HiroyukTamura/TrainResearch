package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import java.util.Collections;

final class zzcus implements zzdqx<Uri> {
    private final /* synthetic */ zzapx zzgkz;

    zzcus(zzcuh zzcuh, zzapx zzapx) {
        this.zzgkz = zzapx;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        try {
            this.zzgkz.onSuccess(Collections.singletonList((Uri) obj));
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final void zzb(Throwable th) {
        try {
            zzapx zzapx = this.zzgkz;
            String valueOf = String.valueOf(th.getMessage());
            zzapx.onError(valueOf.length() != 0 ? "Internal error: ".concat(valueOf) : new String("Internal error: "));
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }
}
