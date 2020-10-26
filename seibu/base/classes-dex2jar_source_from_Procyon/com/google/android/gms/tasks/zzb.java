// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tasks;

final class zzb implements Runnable
{
    private /* synthetic */ Task zzbLT;
    private /* synthetic */ zza zzbLU;
    
    zzb(final zza zzbLU, final Task zzbLT) {
        this.zzbLU = zzbLU;
        this.zzbLT = zzbLT;
    }
    
    @Override
    public final void run() {
        try {
            this.zzbLU.zzbLS.setResult(this.zzbLU.zzbLR.then(this.zzbLT));
        }
        catch (RuntimeExecutionException exception) {
            if (exception.getCause() instanceof Exception) {
                this.zzbLU.zzbLS.setException((Exception)exception.getCause());
                return;
            }
            this.zzbLU.zzbLS.setException(exception);
        }
        catch (Exception exception2) {
            this.zzbLU.zzbLS.setException(exception2);
        }
    }
}
