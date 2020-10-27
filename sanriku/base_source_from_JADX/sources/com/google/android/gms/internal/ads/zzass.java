package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;

public final class zzass implements RewardItem {
    private final zzasd zzdrc;

    public zzass(zzasd zzasd) {
        this.zzdrc = zzasd;
    }

    public final int getAmount() {
        zzasd zzasd = this.zzdrc;
        if (zzasd == null) {
            return 0;
        }
        try {
            return zzasd.getAmount();
        } catch (RemoteException e) {
            zzazw.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    public final String getType() {
        zzasd zzasd = this.zzdrc;
        if (zzasd == null) {
            return null;
        }
        try {
            return zzasd.getType();
        } catch (RemoteException e) {
            zzazw.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
