// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.api;

import android.support.annotation.Nullable;
import android.support.annotation.NonNull;

public class ApiException extends Exception
{
    protected final Status mStatus;
    
    public ApiException(@NonNull final Status mStatus) {
        super(mStatus.getStatusMessage());
        this.mStatus = mStatus;
    }
    
    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }
    
    @Nullable
    public String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }
}
