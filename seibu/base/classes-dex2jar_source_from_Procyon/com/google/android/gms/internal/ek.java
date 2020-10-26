// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Map;
import java.util.List;

public final class ek
{
    private final String zzaxs;
    private final List<em> zzbKW;
    private final Map<String, List<ei>> zzbKX;
    private final int zzbKY;
    
    private ek(final List<em> list, final Map<String, List<ei>> m, final String zzaxs, final int zzbKY) {
        this.zzbKW = Collections.unmodifiableList((List<? extends em>)list);
        this.zzbKX = Collections.unmodifiableMap((Map<? extends String, ? extends List<ei>>)m);
        this.zzaxs = zzaxs;
        this.zzbKY = zzbKY;
    }
    
    public static el zzDz() {
        return new el(null);
    }
    
    public final String getVersion() {
        return this.zzaxs;
    }
    
    @Override
    public final String toString() {
        final String value = String.valueOf(this.zzbKW);
        final String value2 = String.valueOf(this.zzbKX);
        return new StringBuilder(String.valueOf(value).length() + 17 + String.valueOf(value2).length()).append("Rules: ").append(value).append("  Macros: ").append(value2).toString();
    }
    
    public final List<em> zzCX() {
        return this.zzbKW;
    }
    
    public final Map<String, List<ei>> zzDA() {
        return this.zzbKX;
    }
}
