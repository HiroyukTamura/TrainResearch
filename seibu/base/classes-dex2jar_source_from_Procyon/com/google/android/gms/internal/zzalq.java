// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.util.Collections;
import java.util.Iterator;
import java.util.Collection;
import java.util.HashMap;
import java.util.ArrayList;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.ecommerce.Product;
import java.util.List;
import java.util.Map;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.zzj;

public final class zzalq extends zzj<zzalq>
{
    private ProductAction zzadK;
    private final Map<String, List<Product>> zzadL;
    private final List<Promotion> zzadM;
    private final List<Product> zzadN;
    
    public zzalq() {
        this.zzadN = new ArrayList<Product>();
        this.zzadM = new ArrayList<Promotion>();
        this.zzadL = new HashMap<String, List<Product>>();
    }
    
    @Override
    public final String toString() {
        final HashMap<String, List<Product>> hashMap = new HashMap<String, List<Product>>();
        if (!this.zzadN.isEmpty()) {
            hashMap.put("products", this.zzadN);
        }
        if (!this.zzadM.isEmpty()) {
            hashMap.put("promotions", (List<Product>)this.zzadM);
        }
        if (!this.zzadL.isEmpty()) {
            hashMap.put("impressions", (List<Product>)this.zzadL);
        }
        hashMap.put("productAction", (List<Product>)this.zzadK);
        return zzj.zzh(hashMap);
    }
    
    public final ProductAction zzjS() {
        return this.zzadK;
    }
    
    public final List<Product> zzjT() {
        return Collections.unmodifiableList((List<? extends Product>)this.zzadN);
    }
    
    public final Map<String, List<Product>> zzjU() {
        return this.zzadL;
    }
    
    public final List<Promotion> zzjV() {
        return Collections.unmodifiableList((List<? extends Promotion>)this.zzadM);
    }
}
