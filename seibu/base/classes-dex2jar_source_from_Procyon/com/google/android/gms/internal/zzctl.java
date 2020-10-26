// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api;

public final class zzctl implements Optional
{
    public static final zzctl zzbCM;
    private final boolean zzalh;
    private final String zzali;
    private final boolean zzama;
    private final String zzamb;
    private final boolean zzbCN;
    private final boolean zzbCO;
    private final Long zzbCP;
    private final Long zzbCQ;
    
    static {
        new zzctm();
        zzbCM = new zzctl(false, false, null, false, null, false, null, null);
    }
    
    private zzctl(final boolean b, final boolean b2, final String s, final boolean b3, final String s2, final boolean b4, final Long n, final Long n2) {
        this.zzbCN = false;
        this.zzalh = false;
        this.zzali = null;
        this.zzama = false;
        this.zzbCO = false;
        this.zzamb = null;
        this.zzbCP = null;
        this.zzbCQ = null;
    }
    
    public final String getServerClientId() {
        return this.zzali;
    }
    
    public final boolean isIdTokenRequested() {
        return this.zzalh;
    }
    
    public final boolean zzAr() {
        return this.zzbCN;
    }
    
    public final boolean zzAs() {
        return this.zzama;
    }
    
    @Nullable
    public final String zzAt() {
        return this.zzamb;
    }
    
    public final boolean zzAu() {
        return this.zzbCO;
    }
    
    @Nullable
    public final Long zzAv() {
        return this.zzbCP;
    }
    
    @Nullable
    public final Long zzAw() {
        return this.zzbCQ;
    }
}
