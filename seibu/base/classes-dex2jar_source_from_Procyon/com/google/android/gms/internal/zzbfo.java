// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;

public final class zzbfo
{
    public static final Api<Api.ApiOptions.NoOptions> API;
    public static final zzbfq zzaIy;
    public static final Api.zzf<zzbfw> zzajR;
    private static final Api.zza<zzbfw, Api.ApiOptions.NoOptions> zzajS;
    
    static {
        zzajR = new Api.zzf();
        zzajS = new zzbfp();
        API = new Api<Api.ApiOptions.NoOptions>("Common.API", (Api.zza<C, Api.ApiOptions.NoOptions>)zzbfo.zzajS, (Api.zzf<C>)zzbfo.zzajR);
        zzaIy = new zzbfr();
    }
}
