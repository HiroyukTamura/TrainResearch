// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Releasable;

public class zzbby implements Releasable, Result
{
    private Status mStatus;
    protected final DataHolder zzaCX;
    
    protected zzbby(final DataHolder zzaCX, final Status mStatus) {
        this.mStatus = mStatus;
        this.zzaCX = zzaCX;
    }
    
    @Override
    public Status getStatus() {
        return this.mStatus;
    }
    
    @Override
    public void release() {
        if (this.zzaCX != null) {
            this.zzaCX.close();
        }
    }
}
