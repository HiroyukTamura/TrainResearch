// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.content.Context;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Api;

public final class zzbbo<O extends Api.ApiOptions> extends GoogleApi<O>
{
    private final Api.zza<? extends zzctk, zzctl> zzaBe;
    private final zzq zzaCA;
    private final Api.zze zzaCy;
    private final zzbbi zzaCz;
    
    public zzbbo(@NonNull final Context context, final Api<O> api, final Looper looper, @NonNull final Api.zze zzaCy, @NonNull final zzbbi zzaCz, final zzq zzaCA, final Api.zza<? extends zzctk, zzctl> zzaBe) {
        super(context, api, looper);
        this.zzaCy = zzaCy;
        this.zzaCz = zzaCz;
        this.zzaCA = zzaCA;
        this.zzaBe = zzaBe;
        this.zzaAN.zzb(this);
    }
    
    @Override
    public final Api.zze zza(final Looper looper, final zzbdd<O> zzbdd) {
        this.zzaCz.zza(zzbdd);
        return this.zzaCy;
    }
    
    @Override
    public final zzbej zza(final Context context, final Handler handler) {
        return new zzbej(context, handler, this.zzaCA, this.zzaBe);
    }
    
    public final Api.zze zzpJ() {
        return this.zzaCy;
    }
}
