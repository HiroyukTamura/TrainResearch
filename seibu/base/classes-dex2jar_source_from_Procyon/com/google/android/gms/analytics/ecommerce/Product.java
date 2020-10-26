// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics.ecommerce;

import java.util.Iterator;
import com.google.android.gms.analytics.zzj;
import com.google.android.gms.analytics.zzf;
import com.google.android.gms.common.internal.zzbo;
import java.util.HashMap;
import java.util.Map;

public class Product
{
    private Map<String, String> zzafu;
    
    public Product() {
        this.zzafu = new HashMap<String, String>();
    }
    
    private final void put(final String s, final String s2) {
        zzbo.zzb(s, "Name should be non-null");
        this.zzafu.put(s, s2);
    }
    
    public Product setBrand(final String s) {
        this.put("br", s);
        return this;
    }
    
    public Product setCategory(final String s) {
        this.put("ca", s);
        return this;
    }
    
    public Product setCouponCode(final String s) {
        this.put("cc", s);
        return this;
    }
    
    public Product setCustomDimension(final int n, final String s) {
        this.put(zzf.zzN(n), s);
        return this;
    }
    
    public Product setCustomMetric(final int n, final int i) {
        this.put(zzf.zzO(n), Integer.toString(i));
        return this;
    }
    
    public Product setId(final String s) {
        this.put("id", s);
        return this;
    }
    
    public Product setName(final String s) {
        this.put("nm", s);
        return this;
    }
    
    public Product setPosition(final int i) {
        this.put("ps", Integer.toString(i));
        return this;
    }
    
    public Product setPrice(final double d) {
        this.put("pr", Double.toString(d));
        return this;
    }
    
    public Product setQuantity(final int i) {
        this.put("qt", Integer.toString(i));
        return this;
    }
    
    public Product setVariant(final String s) {
        this.put("va", s);
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
