package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzaxa;
import com.google.android.gms.internal.ads.zzub;

public final class zzn {
    public static void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.zzdky == 4 && adOverlayInfoParcel.zzdkt == null) {
            zzub zzub = adOverlayInfoParcel.zzceb;
            if (zzub != null) {
                zzub.onAdClicked();
            }
            zzq.zzku();
            zzb.zza(context, adOverlayInfoParcel.zzdks, adOverlayInfoParcel.zzdkx);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzbmo.zzdzp);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.zza(intent, adOverlayInfoParcel);
        if (!PlatformVersion.isAtLeastLollipop()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        zzq.zzkw();
        zzaxa.zza(context, intent);
    }
}
