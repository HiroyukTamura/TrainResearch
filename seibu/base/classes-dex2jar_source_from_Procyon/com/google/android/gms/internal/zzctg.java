// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Api;

public final class zzctg
{
    public static final Api<zzctl> API;
    private static Api<zzctj> zzaMc;
    private static Api.zzf<zzctu> zzajR;
    public static final Api.zza<zzctu, zzctl> zzajS;
    private static Scope zzalV;
    private static Scope zzalW;
    private static Api.zzf<zzctu> zzbCJ;
    private static Api.zza<zzctu, zzctj> zzbCK;
    
    static {
        zzctg.zzajR = (Api.zzf<zzctu>)new Api.zzf();
        zzctg.zzbCJ = (Api.zzf<zzctu>)new Api.zzf();
        zzajS = new zzcth();
        zzctg.zzbCK = new zzcti();
        zzctg.zzalV = new Scope("profile");
        zzctg.zzalW = new Scope("email");
        API = new Api<zzctl>("SignIn.API", (Api.zza<C, zzctl>)zzctg.zzajS, (Api.zzf<C>)zzctg.zzajR);
        zzctg.zzaMc = new Api<zzctj>("SignIn.INTERNAL_API", (Api.zza<C, zzctj>)zzctg.zzbCK, (Api.zzf<C>)zzctg.zzbCJ);
    }
}
