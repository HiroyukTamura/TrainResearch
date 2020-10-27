package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

final class zzawa implements Runnable {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzbaj zzdth;

    zzawa(zzavx zzavx, Context context, zzbaj zzbaj) {
        this.val$context = context;
        this.zzdth = zzbaj;
    }

    public final void run() {
        try {
            this.zzdth.set(AdvertisingIdClient.getAdvertisingIdInfo(this.val$context));
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            this.zzdth.setException(e);
            zzazw.zzc("Exception while getting advertising Id info", e);
        }
    }
}
