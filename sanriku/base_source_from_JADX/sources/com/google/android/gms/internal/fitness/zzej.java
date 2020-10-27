package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.fitness.result.SessionReadResult;

final class zzej extends zzcj {
    private final BaseImplementation.ResultHolder<SessionReadResult> zzmv;

    private zzej(BaseImplementation.ResultHolder<SessionReadResult> resultHolder) {
        this.zzmv = resultHolder;
    }

    /* synthetic */ zzej(BaseImplementation.ResultHolder resultHolder, zzed zzed) {
        this(resultHolder);
    }

    public final void zza(SessionReadResult sessionReadResult) {
        this.zzmv.setResult(sessionReadResult);
    }
}
