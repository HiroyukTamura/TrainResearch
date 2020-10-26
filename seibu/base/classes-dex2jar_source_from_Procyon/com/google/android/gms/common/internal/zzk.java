// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.support.annotation.BinderThread;
import android.util.Log;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.annotation.NonNull;

public final class zzk extends zzav
{
    private zzd zzaHg;
    private final int zzaHh;
    
    public zzk(@NonNull final zzd zzaHg, final int zzaHh) {
        this.zzaHg = zzaHg;
        this.zzaHh = zzaHh;
    }
    
    @BinderThread
    @Override
    public final void zza(final int n, @Nullable final Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", (Throwable)new Exception());
    }
    
    @BinderThread
    @Override
    public final void zza(final int n, @NonNull final IBinder binder, @Nullable final Bundle bundle) {
        zzbo.zzb(this.zzaHg, "onPostInitComplete can be called only once per call to getRemoteService");
        this.zzaHg.zza(n, binder, bundle, this.zzaHh);
        this.zzaHg = null;
    }
}
