// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.tagmanager.zzgk;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public final class el
{
    private String zzaxs;
    private final List<em> zzbKW;
    private final Map<String, List<ei>> zzbKX;
    private int zzbKY;
    
    private el() {
        this.zzbKW = new ArrayList<em>();
        this.zzbKX = new HashMap<String, List<ei>>();
        this.zzaxs = "";
        this.zzbKY = 0;
    }
    
    public final ek zzDB() {
        return new ek(this.zzbKW, this.zzbKX, this.zzaxs, this.zzbKY, null);
    }
    
    public final el zzb(final em em) {
        this.zzbKW.add(em);
        return this;
    }
    
    public final el zzbJ(final int zzbKY) {
        this.zzbKY = zzbKY;
        return this;
    }
    
    public final el zzc(final ei ei) {
        final String zzb = zzgk.zzb(ei.zzCZ().get(zzbg.zzhS.toString()));
        List<ei> list;
        if ((list = this.zzbKX.get(zzb)) == null) {
            list = new ArrayList<ei>();
            this.zzbKX.put(zzb, list);
        }
        list.add(ei);
        return this;
    }
    
    public final el zzgd(final String zzaxs) {
        this.zzaxs = zzaxs;
        return this;
    }
}
