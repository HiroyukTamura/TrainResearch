package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.rewarded.RewardItem;

public final class zzaub extends zzatd {
    private final String type;
    private final int zzdqy;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzaub(@Nullable RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzaub(@Nullable zzatc zzatc) {
        this(zzatc != null ? zzatc.type : "", zzatc != null ? zzatc.zzdqy : 1);
    }

    public zzaub(String str, int i) {
        this.type = str;
        this.zzdqy = i;
    }

    public final int getAmount() throws RemoteException {
        return this.zzdqy;
    }

    public final String getType() throws RemoteException {
        return this.type;
    }
}
