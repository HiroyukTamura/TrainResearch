// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.OnCompleteListener;

final class zzbbv implements OnCompleteListener<Object>
{
    private /* synthetic */ zzbbt zzaCU;
    private /* synthetic */ TaskCompletionSource zzaCV;
    
    zzbbv(final zzbbt zzaCU, final TaskCompletionSource zzaCV) {
        this.zzaCU = zzaCU;
        this.zzaCV = zzaCV;
    }
    
    @Override
    public final void onComplete(@NonNull final Task<Object> task) {
        this.zzaCU.zzaCS.remove(this.zzaCV);
    }
}
