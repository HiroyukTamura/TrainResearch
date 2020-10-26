// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.HashMap;
import com.google.android.gms.analytics.zzj;

public final class zzalp extends zzj<zzalp>
{
    public int zzNY;
    public int zzNZ;
    private String zzaeT;
    public int zzaeU;
    public int zzaeV;
    public int zzaeW;
    
    public final String getLanguage() {
        return this.zzaeT;
    }
    
    public final void setLanguage(final String zzaeT) {
        this.zzaeT = zzaeT;
    }
    
    @Override
    public final String toString() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("language", this.zzaeT);
        hashMap.put("screenColors", (String)this.zzaeU);
        hashMap.put("screenWidth", (String)this.zzNY);
        hashMap.put("screenHeight", (String)this.zzNZ);
        hashMap.put("viewportWidth", (String)this.zzaeV);
        hashMap.put("viewportHeight", (String)this.zzaeW);
        return zzj.zzh(hashMap);
    }
}
