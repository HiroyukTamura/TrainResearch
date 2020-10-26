// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import java.util.concurrent.TimeUnit;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.common.api.PendingResult;

final class zzbj implements zza
{
    private /* synthetic */ PendingResult zzaIj;
    private /* synthetic */ TaskCompletionSource zzaIk;
    private /* synthetic */ zzbm zzaIl;
    private /* synthetic */ zzbn zzaIm;
    
    zzbj(final PendingResult zzaIj, final TaskCompletionSource zzaIk, final zzbm zzaIl, final zzbn zzaIm) {
        this.zzaIj = zzaIj;
        this.zzaIk = zzaIk;
        this.zzaIl = zzaIl;
        this.zzaIm = zzaIm;
    }
    
    @Override
    public final void zzo(final Status status) {
        if (status.isSuccess()) {
            this.zzaIk.setResult(this.zzaIl.zzd(this.zzaIj.await(0L, TimeUnit.MILLISECONDS)));
            return;
        }
        this.zzaIk.setException(this.zzaIm.zzy(status));
    }
}
