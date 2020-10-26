// 
// Decompiled by Procyon v0.5.36
// 

package com.bumptech.glide.request;

public interface RequestCoordinator
{
    boolean canNotifyStatusChanged(final Request p0);
    
    boolean canSetImage(final Request p0);
    
    boolean isAnyResourceSet();
    
    void onRequestSuccess(final Request p0);
}
