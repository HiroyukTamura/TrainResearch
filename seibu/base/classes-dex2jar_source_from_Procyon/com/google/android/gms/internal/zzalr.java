// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import com.google.android.gms.analytics.zzj;

public final class zzalr extends zzj<zzalr>
{
    private String mCategory;
    private String zzaeX;
    private String zzaeY;
    private long zzaeZ;
    
    public final String getAction() {
        return this.zzaeX;
    }
    
    public final String getCategory() {
        return this.mCategory;
    }
    
    public final String getLabel() {
        return this.zzaeY;
    }
    
    public final long getValue() {
        return this.zzaeZ;
    }
    
    @Override
    public final String toString() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("category", this.mCategory);
        hashMap.put("action", this.zzaeX);
        hashMap.put("label", this.zzaeY);
        hashMap.put("value", (String)this.zzaeZ);
        return zzj.zzh(hashMap);
    }
}
