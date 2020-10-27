package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.fitness.result.SessionStopResult;

final class zzei extends zzck {
    private final BaseImplementation.ResultHolder<SessionStopResult> zzmv;

    private zzei(BaseImplementation.ResultHolder<SessionStopResult> resultHolder) {
        this.zzmv = resultHolder;
    }

    /* synthetic */ zzei(BaseImplementation.ResultHolder resultHolder, zzed zzed) {
        this(resultHolder);
    }

    public final void zza(SessionStopResult sessionStopResult) {
        this.zzmv.setResult(sessionStopResult);
    }
}
