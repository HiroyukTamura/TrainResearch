package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

public final class zzatt implements RewardItem {
    private final zzate zzdri;

    public zzatt(zzate zzate) {
        this.zzdri = zzate;
    }

    public final int getAmount() {
        zzate zzate = this.zzdri;
        if (zzate == null) {
            return 0;
        }
        try {
            return zzate.getAmount();
        } catch (RemoteException e) {
            zzazw.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    public final String getType() {
        zzate zzate = this.zzdri;
        if (zzate == null) {
            return null;
        }
        try {
            return zzate.getType();
        } catch (RemoteException e) {
            zzazw.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
