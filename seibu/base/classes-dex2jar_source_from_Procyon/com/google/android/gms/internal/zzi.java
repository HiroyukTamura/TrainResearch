// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

final class zzi implements Executor
{
    private /* synthetic */ Handler zzs;
    
    zzi(final zzh zzh, final Handler zzs) {
        this.zzs = zzs;
    }
    
    @Override
    public final void execute(final Runnable runnable) {
        this.zzs.post(runnable);
    }
}
