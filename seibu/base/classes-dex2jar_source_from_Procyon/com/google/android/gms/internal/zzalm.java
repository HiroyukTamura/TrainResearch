// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import com.google.android.gms.analytics.zzj;

public final class zzalm extends zzj<zzalm>
{
    private Map<Integer, String> zzaeR;
    
    public zzalm() {
        this.zzaeR = new HashMap<Integer, String>(4);
    }
    
    @Override
    public final String toString() {
        final HashMap<String, Object> hashMap = new HashMap<String, Object>();
        for (final Map.Entry<Integer, String> entry : this.zzaeR.entrySet()) {
            final String value = String.valueOf(entry.getKey());
            hashMap.put(new StringBuilder(String.valueOf(value).length() + 9).append("dimension").append(value).toString(), entry.getValue());
        }
        return zzj.zzh(hashMap);
    }
    
    public final Map<Integer, String> zzjP() {
        return Collections.unmodifiableMap((Map<? extends Integer, ? extends String>)this.zzaeR);
    }
}
