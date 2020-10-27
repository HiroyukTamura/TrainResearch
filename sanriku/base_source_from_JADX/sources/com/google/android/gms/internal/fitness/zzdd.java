package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.fitness.result.DataTypeResult;

final class zzdd extends zzbk {
    private final BaseImplementation.ResultHolder<DataTypeResult> zzmv;

    private zzdd(BaseImplementation.ResultHolder<DataTypeResult> resultHolder) {
        this.zzmv = resultHolder;
    }

    /* synthetic */ zzdd(BaseImplementation.ResultHolder resultHolder, zzcy zzcy) {
        this(resultHolder);
    }

    public final void zza(DataTypeResult dataTypeResult) {
        this.zzmv.setResult(dataTypeResult);
    }
}
