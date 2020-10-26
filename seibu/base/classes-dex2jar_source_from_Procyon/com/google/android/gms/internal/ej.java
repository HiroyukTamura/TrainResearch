// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.HashMap;
import java.util.Map;

public final class ej
{
    private zzbr zzbGv;
    private final Map<String, zzbr> zzbKZ;
    
    private ej() {
        this.zzbKZ = new HashMap<String, zzbr>();
    }
    
    public final ei zzDy() {
        return new ei(this.zzbKZ, this.zzbGv, null);
    }
    
    public final ej zzb(final String s, final zzbr zzbr) {
        this.zzbKZ.put(s, zzbr);
        return this;
    }
    
    public final ej zzl(final zzbr zzbGv) {
        this.zzbGv = zzbGv;
        return this;
    }
}
