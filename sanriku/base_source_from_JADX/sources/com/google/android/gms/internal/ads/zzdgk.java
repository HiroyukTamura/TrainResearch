package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;

final class zzdgk extends AdMetadataListener {
    private final /* synthetic */ zzdgi zzgtc;
    private final /* synthetic */ zzwc zzgtd;

    zzdgk(zzdgi zzdgi, zzwc zzwc) {
        this.zzgtc = zzdgi;
        this.zzgtd = zzwc;
    }

    public final void onAdMetadataChanged() {
        if (this.zzgtc.zzgtb != null) {
            try {
                this.zzgtd.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzazw.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
