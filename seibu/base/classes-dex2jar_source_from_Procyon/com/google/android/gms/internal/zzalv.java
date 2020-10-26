// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import com.google.android.gms.analytics.zzj;

public final class zzalv extends zzj<zzalv>
{
    public String zzaeX;
    public String zzafq;
    public String zzafr;
    
    @Override
    public final String toString() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("network", this.zzafq);
        hashMap.put("action", this.zzaeX);
        hashMap.put("target", this.zzafr);
        return zzj.zzh(hashMap);
    }
}
