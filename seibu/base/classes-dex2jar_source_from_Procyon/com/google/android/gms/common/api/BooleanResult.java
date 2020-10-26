// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzbo;

public class BooleanResult implements Result
{
    private final Status mStatus;
    private final boolean zzaAI;
    
    public BooleanResult(final Status status, final boolean zzaAI) {
        this.mStatus = zzbo.zzb(status, "Status must not be null");
        this.zzaAI = zzaAI;
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o != this) {
            if (!(o instanceof BooleanResult)) {
                return false;
            }
            final BooleanResult booleanResult = (BooleanResult)o;
            if (!this.mStatus.equals(booleanResult.mStatus) || this.zzaAI != booleanResult.zzaAI) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public Status getStatus() {
        return this.mStatus;
    }
    
    public boolean getValue() {
        return this.zzaAI;
    }
    
    @Override
    public final int hashCode() {
        final int hashCode = this.mStatus.hashCode();
        int n;
        if (this.zzaAI) {
            n = 1;
        }
        else {
            n = 0;
        }
        return n + (hashCode + 527) * 31;
    }
}
