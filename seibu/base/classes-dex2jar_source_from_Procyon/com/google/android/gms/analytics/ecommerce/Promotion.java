// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics.ecommerce;

import java.util.Iterator;
import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.zzbo;
import java.util.HashMap;
import java.util.Map;

public class Promotion
{
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_VIEW = "view";
    private Map<String, String> zzafu;
    
    public Promotion() {
        this.zzafu = new HashMap<String, String>();
    }
    
    private final void put(final String s, final String s2) {
        zzbo.zzb(s, "Name should be non-null");
        this.zzafu.put(s, s2);
    }
    
    public Promotion setCreative(final String s) {
        this.put("cr", s);
        return this;
    }
    
    public Promotion setId(final String s) {
        this.put("id", s);
        return this;
    }
    
    public Promotion setName(final String s) {
        this.put("nm", s);
        return this;
    }
    
    public Promotion setPosition(final String s) {
        this.put("ps", s);
        return this;
    }
    
    @Override
    public String toString() {
        return zzj.zzk(this.zzafu);
    }
    
    public final Map<String, String> zzbl(final String obj) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        for (final Map.Entry<String, String> entry : this.zzafu.entrySet()) {
            final String value = String.valueOf(obj);
            final String value2 = String.valueOf(entry.getKey());
            String concat;
            if (value2.length() != 0) {
                concat = value.concat(value2);
            }
            else {
                concat = new String(value);
            }
            hashMap.put(concat, entry.getValue());
        }
        return hashMap;
    }
}
