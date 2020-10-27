package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

final class zzdx extends zzce {
    private final BaseImplementation.ResultHolder<ListSubscriptionsResult> zzmv;

    private zzdx(BaseImplementation.ResultHolder<ListSubscriptionsResult> resultHolder) {
        this.zzmv = resultHolder;
    }

    /* synthetic */ zzdx(BaseImplementation.ResultHolder resultHolder, zzdq zzdq) {
        this(resultHolder);
    }

    public final void zza(ListSubscriptionsResult listSubscriptionsResult) {
        this.zzmv.setResult(listSubscriptionsResult);
    }
}
