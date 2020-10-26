// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Map;

public final class ei
{
    private final zzbr zzbGv;
    private final Map<String, zzbr> zzbKZ;
    
    private ei(final Map<String, zzbr> zzbKZ, final zzbr zzbGv) {
        this.zzbKZ = zzbKZ;
        this.zzbGv = zzbGv;
    }
    
    public static ej zzDx() {
        return new ej(null);
    }
    
    @Override
    public final String toString() {
        final String value = String.valueOf(Collections.unmodifiableMap((Map<?, ?>)this.zzbKZ));
        final String value2 = String.valueOf(this.zzbGv);
        return new StringBuilder(String.valueOf(value).length() + 32 + String.valueOf(value2).length()).append("Properties: ").append(value).append(" pushAfterEvaluate: ").append(value2).toString();
    }
    
    public final zzbr zzBN() {
        return this.zzbGv;
    }
    
    public final Map<String, zzbr> zzCZ() {
        return Collections.unmodifiableMap((Map<? extends String, ? extends zzbr>)this.zzbKZ);
    }
    
    public final void zza(final String s, final zzbr zzbr) {
        this.zzbKZ.put(s, zzbr);
    }
}
