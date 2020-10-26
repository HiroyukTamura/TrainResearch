// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import com.google.android.gms.analytics.zzj;

public final class zzals extends zzj<zzals>
{
    public String zzafa;
    public boolean zzafb;
    
    @Override
    public final String toString() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("description", this.zzafa);
        hashMap.put("fatal", (String)this.zzafb);
        return zzj.zzh(hashMap);
    }
}
