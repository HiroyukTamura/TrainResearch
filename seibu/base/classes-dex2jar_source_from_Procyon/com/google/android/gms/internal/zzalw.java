// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import com.google.android.gms.analytics.zzj;

public final class zzalw extends zzj<zzalw>
{
    public String mCategory;
    public String zzaeY;
    public String zzafs;
    public long zzaft;
    
    @Override
    public final String toString() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("variableName", this.zzafs);
        hashMap.put("timeInMillis", (String)this.zzaft);
        hashMap.put("category", this.mCategory);
        hashMap.put("label", this.zzaeY);
        return zzj.zzh(hashMap);
    }
}
