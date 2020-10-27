package com.google.android.gms.fitness;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.fitness.result.DataSourcesResult;

final /* synthetic */ class zzo implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzho = new zzo();

    private zzo() {
    }

    public final Object convert(Result result) {
        return ((DataSourcesResult) result).getDataSources();
    }
}
