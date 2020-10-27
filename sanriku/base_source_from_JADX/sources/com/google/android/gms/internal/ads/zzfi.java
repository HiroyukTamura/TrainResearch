package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.ads.zzbv;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public final class zzfi extends zzfz {
    public zzfi(zzeo zzeo, String str, String str2, zzbv.zza.C2654zza zza, int i, int i2) {
        super(zzeo, str, str2, zza, i, 24);
    }

    private final void zzda() {
        AdvertisingIdClient zzct = this.zzvp.zzct();
        if (zzct != null) {
            try {
                AdvertisingIdClient.Info info = zzct.getInfo();
                String zzap = zzet.zzap(info.getId());
                if (zzap != null) {
                    synchronized (this.zzaam) {
                        this.zzaam.zzaa(zzap);
                        this.zzaam.zza(info.isLimitAdTrackingEnabled());
                        this.zzaam.zza(zzbv.zza.zzc.DEVICE_IDENTIFIER_ANDROID_AD_ID);
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zzcx() throws IllegalAccessException, InvocationTargetException {
        if (this.zzvp.zzcl()) {
            zzda();
            return;
        }
        synchronized (this.zzaam) {
            this.zzaam.zzaa((String) this.zzaaw.invoke((Object) null, new Object[]{this.zzvp.getContext()}));
        }
    }

    /* renamed from: zzcz */
    public final Void call() throws Exception {
        if (this.zzvp.isInitialized()) {
            return super.call();
        }
        if (!this.zzvp.zzcl()) {
            return null;
        }
        zzda();
        return null;
    }
}
