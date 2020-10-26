// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.api;

import java.util.ArrayList;
import java.util.List;
import com.google.android.gms.internal.zzbbe;

public final class Batch extends zzbbe<BatchResult>
{
    private final Object mLock;
    private int zzaAC;
    private boolean zzaAD;
    private boolean zzaAE;
    private final PendingResult<?>[] zzaAF;
    
    private Batch(final List<PendingResult<?>> list, final GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.mLock = new Object();
        this.zzaAC = list.size();
        this.zzaAF = (PendingResult<?>[])new PendingResult[this.zzaAC];
        if (list.isEmpty()) {
            this.setResult(new BatchResult(Status.zzaBm, this.zzaAF));
        }
        else {
            for (int i = 0; i < list.size(); ++i) {
                (this.zzaAF[i] = list.get(i)).zza((zza)new zzb(this));
            }
        }
    }
    
    @Override
    public final void cancel() {
        super.cancel();
        final PendingResult<?>[] zzaAF = this.zzaAF;
        for (int length = zzaAF.length, i = 0; i < length; ++i) {
            zzaAF[i].cancel();
        }
    }
    
    public final BatchResult createFailedResult(final Status status) {
        return new BatchResult(status, this.zzaAF);
    }
    
    public static final class Builder
    {
        private List<PendingResult<?>> zzaAH;
        private GoogleApiClient zzapu;
        
        public Builder(final GoogleApiClient zzapu) {
            this.zzaAH = new ArrayList<PendingResult<?>>();
            this.zzapu = zzapu;
        }
        
        public final <R extends Result> BatchResultToken<R> add(final PendingResult<R> pendingResult) {
            final BatchResultToken<R> batchResultToken = new BatchResultToken<R>(this.zzaAH.size());
            this.zzaAH.add(pendingResult);
            return batchResultToken;
        }
        
        public final Batch build() {
            return new Batch(this.zzaAH, this.zzapu, null);
        }
    }
}
