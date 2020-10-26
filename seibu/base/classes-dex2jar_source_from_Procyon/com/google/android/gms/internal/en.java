// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public final class en
{
    private final List<ei> zzbLJ;
    private final List<ei> zzbLK;
    private final List<String> zzbLL;
    private final List<String> zzbLM;
    private final List<String> zzbLN;
    private final List<String> zzbLO;
    private final List<ei> zzbLb;
    private final List<ei> zzbLc;
    private final List<ei> zzbLd;
    private final List<ei> zzbLe;
    
    private en() {
        this.zzbLb = new ArrayList<ei>();
        this.zzbLc = new ArrayList<ei>();
        this.zzbLd = new ArrayList<ei>();
        this.zzbLe = new ArrayList<ei>();
        this.zzbLJ = new ArrayList<ei>();
        this.zzbLK = new ArrayList<ei>();
        this.zzbLL = new ArrayList<String>();
        this.zzbLM = new ArrayList<String>();
        this.zzbLN = new ArrayList<String>();
        this.zzbLO = new ArrayList<String>();
    }
    
    public final em zzDE() {
        return new em(this.zzbLb, this.zzbLc, this.zzbLd, this.zzbLe, this.zzbLJ, this.zzbLK, this.zzbLL, this.zzbLM, this.zzbLN, this.zzbLO, null);
    }
    
    public final en zzd(final ei ei) {
        this.zzbLb.add(ei);
        return this;
    }
    
    public final en zze(final ei ei) {
        this.zzbLc.add(ei);
        return this;
    }
    
    public final en zzf(final ei ei) {
        this.zzbLd.add(ei);
        return this;
    }
    
    public final en zzg(final ei ei) {
        this.zzbLe.add(ei);
        return this;
    }
    
    public final en zzge(final String s) {
        this.zzbLN.add(s);
        return this;
    }
    
    public final en zzgf(final String s) {
        this.zzbLO.add(s);
        return this;
    }
    
    public final en zzgg(final String s) {
        this.zzbLL.add(s);
        return this;
    }
    
    public final en zzgh(final String s) {
        this.zzbLM.add(s);
        return this;
    }
    
    public final en zzh(final ei ei) {
        this.zzbLJ.add(ei);
        return this;
    }
    
    public final en zzi(final ei ei) {
        this.zzbLK.add(ei);
        return this;
    }
}
