// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tasks;

final class zzd implements Runnable
{
    private /* synthetic */ Task zzbLT;
    private /* synthetic */ zzc zzbLV;
    
    zzd(final zzc zzbLV, final Task zzbLT) {
        this.zzbLV = zzbLV;
        this.zzbLT = zzbLT;
    }
    
    @Override
    public final void run() {
        Task task;
        try {
            task = this.zzbLV.zzbLR.then(this.zzbLT);
            if (task == null) {
                this.zzbLV.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
        }
        catch (RuntimeExecutionException exception) {
            if (exception.getCause() instanceof Exception) {
                this.zzbLV.zzbLS.setException((Exception)exception.getCause());
                return;
            }
            this.zzbLV.zzbLS.setException(exception);
            return;
        }
        catch (Exception exception2) {
            this.zzbLV.zzbLS.setException(exception2);
            return;
        }
        task.addOnSuccessListener(TaskExecutors.zzbMf, this.zzbLV);
        task.addOnFailureListener(TaskExecutors.zzbMf, this.zzbLV);
    }
}
