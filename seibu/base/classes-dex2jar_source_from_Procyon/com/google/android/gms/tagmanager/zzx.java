// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.os.Message;
import android.os.Looper;
import android.os.Handler;

final class zzx extends Handler
{
    private final ContainerHolder.ContainerAvailableListener zzbDJ;
    private /* synthetic */ zzv zzbDK;
    
    public zzx(final zzv zzbDK, final ContainerHolder.ContainerAvailableListener zzbDJ, final Looper looper) {
        this.zzbDK = zzbDK;
        super(looper);
        this.zzbDJ = zzbDJ;
    }
    
    public final void handleMessage(final Message message) {
        switch (message.what) {
            default: {
                zzdj.e("Don't know how to handle this message.");
            }
            case 1: {
                this.zzbDJ.onContainerAvailable(this.zzbDK, (String)message.obj);
            }
        }
    }
}
