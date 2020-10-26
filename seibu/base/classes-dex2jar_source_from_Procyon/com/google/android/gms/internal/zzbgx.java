// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Process;

final class zzbgx implements Runnable
{
    private final int mPriority;
    private final Runnable zzv;
    
    public zzbgx(final Runnable zzv, final int mPriority) {
        this.zzv = zzv;
        this.mPriority = mPriority;
    }
    
    @Override
    public final void run() {
        Process.setThreadPriority(this.mPriority);
        this.zzv.run();
    }
}
