// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Map;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

abstract class zzbr
{
    private final Set<String> zzbEL;
    private final String zzbEM;
    
    public zzbr(String zzbEM, final String... array) {
        this.zzbEM = zzbEM;
        this.zzbEL = new HashSet<String>(array.length);
        for (int length = array.length, i = 0; i < length; ++i) {
            zzbEM = array[i];
            this.zzbEL.add(zzbEM);
        }
    }
    
    public abstract boolean zzAE();
    
    public String zzBk() {
        return this.zzbEM;
    }
    
    public Set<String> zzBl() {
        return this.zzbEL;
    }
    
    final boolean zzd(final Set<String> set) {
        return set.containsAll(this.zzbEL);
    }
    
    public abstract com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> p0);
}
