// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Result;
import android.support.annotation.NonNull;
import android.os.Looper;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Api;

public final class zzbdj<O extends Api.ApiOptions> extends zzbbz
{
    private final GoogleApi<O> zzaEz;
    
    public zzbdj(final GoogleApi<O> zzaEz) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.zzaEz = zzaEz;
    }
    
    @Override
    public final Context getContext() {
        return this.zzaEz.getApplicationContext();
    }
    
    @Override
    public final Looper getLooper() {
        return this.zzaEz.getLooper();
    }
    
    @Override
    public final void zza(final zzbes zzbes) {
    }
    
    @Override
    public final void zzb(final zzbes zzbes) {
    }
    
    @Override
    public final <A extends Api.zzb, R extends Result, T extends zzbay<R, A>> T zzd(@NonNull final T t) {
        return this.zzaEz.zza(t);
    }
    
    @Override
    public final <A extends Api.zzb, T extends zzbay<? extends Result, A>> T zze(@NonNull final T t) {
        return this.zzaEz.zzb(t);
    }
}
