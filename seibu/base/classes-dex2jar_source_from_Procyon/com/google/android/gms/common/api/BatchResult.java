// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.internal.zzbo;

public final class BatchResult implements Result
{
    private final Status mStatus;
    private final PendingResult<?>[] zzaAF;
    
    BatchResult(final Status mStatus, final PendingResult<?>[] zzaAF) {
        this.mStatus = mStatus;
        this.zzaAF = zzaAF;
    }
    
    @Override
    public final Status getStatus() {
        return this.mStatus;
    }
    
    public final <R extends Result> R take(final BatchResultToken<R> batchResultToken) {
        zzbo.zzb(batchResultToken.mId < this.zzaAF.length, (Object)"The result token does not belong to this batch");
        return (R)this.zzaAF[batchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
}
