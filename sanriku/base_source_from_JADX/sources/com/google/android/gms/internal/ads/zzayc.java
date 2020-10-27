package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzq;

final class zzayc implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaxz zzdxe;

    zzayc(zzaxz zzaxz) {
        this.zzdxe = zzaxz;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        zzq.zzkw();
        zzaxa.zza(this.zzdxe.val$context, Uri.parse("https://support.google.com/dfp_premium/answer/7160685#push"));
    }
}
