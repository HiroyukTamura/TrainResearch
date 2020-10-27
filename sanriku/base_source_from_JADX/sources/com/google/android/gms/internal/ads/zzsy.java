package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzsy {
    @VisibleForTesting
    zzgn zzbvf;
    @VisibleForTesting
    boolean zzbvg;

    public zzsy() {
    }

    public zzsy(Context context) {
        zzzz.initialize(context);
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcqq)).booleanValue()) {
            try {
                this.zzbvf = (zzgn) zzazv.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzta.zzbvh);
                ObjectWrapper.wrap(context);
                this.zzbvf.zza(ObjectWrapper.wrap(context), "GMA_SDK");
                this.zzbvg = true;
            } catch (RemoteException | zzazx | NullPointerException unused) {
                zzazw.zzed("Cannot dynamite load clearcut");
            }
        }
    }

    public zzsy(Context context, String str, String str2) {
        zzzz.initialize(context);
        try {
            this.zzbvf = (zzgn) zzazv.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zztb.zzbvh);
            ObjectWrapper.wrap(context);
            this.zzbvf.zza(ObjectWrapper.wrap(context), str, (String) null);
            this.zzbvg = true;
        } catch (RemoteException | zzazx | NullPointerException unused) {
            zzazw.zzed("Cannot dynamite load clearcut");
        }
    }

    public final zztc zzf(byte[] bArr) {
        return new zztc(this, bArr);
    }
}
