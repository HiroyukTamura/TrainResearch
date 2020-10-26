// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import com.google.android.gms.internal.em;
import java.util.Set;
import com.google.android.gms.internal.ei;

final class zzfj
{
    private ei zzbGA;
    private final Set<em> zzbGm;
    private final Map<em, List<ei>> zzbGw;
    private final Map<em, List<ei>> zzbGx;
    private final Map<em, List<String>> zzbGy;
    private final Map<em, List<String>> zzbGz;
    
    public zzfj() {
        this.zzbGm = new HashSet<em>();
        this.zzbGw = new HashMap<em, List<ei>>();
        this.zzbGy = new HashMap<em, List<String>>();
        this.zzbGx = new HashMap<em, List<ei>>();
        this.zzbGz = new HashMap<em, List<String>>();
    }
    
    public final Set<em> zzBO() {
        return this.zzbGm;
    }
    
    public final Map<em, List<ei>> zzBP() {
        return this.zzbGw;
    }
    
    public final Map<em, List<String>> zzBQ() {
        return this.zzbGy;
    }
    
    public final Map<em, List<String>> zzBR() {
        return this.zzbGz;
    }
    
    public final Map<em, List<ei>> zzBS() {
        return this.zzbGx;
    }
    
    public final ei zzBT() {
        return this.zzbGA;
    }
    
    public final void zza(final em em) {
        this.zzbGm.add(em);
    }
    
    public final void zza(final em em, final ei ei) {
        List<ei> list;
        if ((list = this.zzbGw.get(em)) == null) {
            list = new ArrayList<ei>();
            this.zzbGw.put(em, list);
        }
        list.add(ei);
    }
    
    public final void zza(final em em, final String s) {
        List<String> list;
        if ((list = this.zzbGy.get(em)) == null) {
            list = new ArrayList<String>();
            this.zzbGy.put(em, list);
        }
        list.add(s);
    }
    
    public final void zzb(final ei zzbGA) {
        this.zzbGA = zzbGA;
    }
    
    public final void zzb(final em em, final ei ei) {
        List<ei> list;
        if ((list = this.zzbGx.get(em)) == null) {
            list = new ArrayList<ei>();
            this.zzbGx.put(em, list);
        }
        list.add(ei);
    }
    
    public final void zzb(final em em, final String s) {
        List<String> list;
        if ((list = this.zzbGz.get(em)) == null) {
            list = new ArrayList<String>();
            this.zzbGz.put(em, list);
        }
        list.add(s);
    }
}
