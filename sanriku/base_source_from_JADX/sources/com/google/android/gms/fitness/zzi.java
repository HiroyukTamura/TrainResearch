package com.google.android.gms.fitness;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.fitness.result.GoalsResult;

final /* synthetic */ class zzi implements PendingResultUtil.ResultConverter {
    static final PendingResultUtil.ResultConverter zzho = new zzi();

    private zzi() {
    }

    public final Object convert(Result result) {
        return ((GoalsResult) result).getGoals();
    }
}
