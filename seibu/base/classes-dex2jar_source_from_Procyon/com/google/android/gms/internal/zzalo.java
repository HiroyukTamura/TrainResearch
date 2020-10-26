// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Collections;
import com.google.android.gms.common.internal.zzbo;
import java.util.HashMap;
import java.util.Map;
import com.google.android.gms.analytics.zzj;

public final class zzalo extends zzj<zzalo>
{
    private final Map<String, Object> zzHa;
    
    public zzalo() {
        this.zzHa = new HashMap<String, Object>();
    }
    
    public final void set(final String s, final String s2) {
        zzbo.zzcF(s);
        String substring = s;
        if (s != null) {
            substring = s;
            if (s.startsWith("&")) {
                substring = s.substring(1);
            }
        }
        zzbo.zzh(substring, "Name can not be empty or \"&\"");
        this.zzHa.put(substring, s2);
    }
    
    @Override
    public final String toString() {
        return zzj.zzh(this.zzHa);
    }
    
    public final Map<String, Object> zzjR() {
        return Collections.unmodifiableMap((Map<? extends String, ?>)this.zzHa);
    }
}
