// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

final class zzo implements Runnable
{
    private /* synthetic */ Callable zzZo;
    private /* synthetic */ zzn zzbMk;
    
    zzo(final zzn zzbMk, final Callable zzZo) {
        this.zzbMk = zzbMk;
        this.zzZo = zzZo;
    }
    
    @Override
    public final void run() {
        try {
            this.zzbMk.setResult(this.zzZo.call());
        }
        catch (Exception exception) {
            this.zzbMk.setException(exception);
        }
    }
}
