// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class zzh implements zzw
{
    private final Executor zzr;
    
    public zzh(final Handler handler) {
        this.zzr = new zzi(this, handler);
    }
    
    @Override
    public final void zza(final zzp<?> zzp, final zzaa zzaa) {
        zzp.zzb("post-error");
        this.zzr.execute(new zzj(this, zzp, zzt.zzc(zzaa), null));
    }
    
    @Override
    public final void zza(final zzp<?> zzp, final zzt<?> zzt) {
        this.zza(zzp, zzt, null);
    }
    
    @Override
    public final void zza(final zzp<?> zzp, final zzt<?> zzt, final Runnable runnable) {
        zzp.zzk();
        zzp.zzb("post-response");
        this.zzr.execute(new zzj(this, zzp, zzt, runnable));
    }
}
