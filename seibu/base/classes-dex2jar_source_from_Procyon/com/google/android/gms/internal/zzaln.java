// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import com.google.android.gms.analytics.zzj;

public final class zzaln extends zzj<zzaln>
{
    private Map<Integer, Double> zzaeS;
    
    public zzaln() {
        this.zzaeS = new HashMap<Integer, Double>(4);
    }
    
    @Override
    public final String toString() {
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (final Map.Entry<Integer, Double> entry : this.zzaeS.entrySet()) {
            final String value = String.valueOf(entry.getKey());
            hashMap.put(new StringBuilder(String.valueOf(value).length() + 6).append("metric").append(value).toString(), entry.getValue());
        }
        return zzj.zzh(hashMap);
    }
    
    public final Map<Integer, Double> zzjQ() {
        return Collections.unmodifiableMap((Map<? extends Integer, ? extends Double>)this.zzaeS);
    }
}
