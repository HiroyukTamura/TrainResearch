package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.fitness.result.DataSourcesResult;

public final class zzk extends zzbj {
    private final BaseImplementation.ResultHolder<DataSourcesResult> zzmv;

    public zzk(BaseImplementation.ResultHolder<DataSourcesResult> resultHolder) {
        this.zzmv = resultHolder;
    }

    public final void zza(DataSourcesResult dataSourcesResult) {
        this.zzmv.setResult(dataSourcesResult);
    }
}
