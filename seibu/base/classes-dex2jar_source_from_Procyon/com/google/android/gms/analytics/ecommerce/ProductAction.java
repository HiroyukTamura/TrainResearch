// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics.ecommerce;

import java.util.Iterator;
import com.google.android.gms.analytics.zzj;
import com.google.android.gms.common.internal.zzbo;
import java.util.HashMap;
import java.util.Map;

public class ProductAction
{
    public static final String ACTION_ADD = "add";
    public static final String ACTION_CHECKOUT = "checkout";
    public static final String ACTION_CHECKOUT_OPTION = "checkout_option";
    @Deprecated
    public static final String ACTION_CHECKOUT_OPTIONS = "checkout_options";
    public static final String ACTION_CLICK = "click";
    public static final String ACTION_DETAIL = "detail";
    public static final String ACTION_PURCHASE = "purchase";
    public static final String ACTION_REFUND = "refund";
    public static final String ACTION_REMOVE = "remove";
    private Map<String, String> zzafu;
    
    public ProductAction(final String s) {
        this.zzafu = new HashMap<String, String>();
        this.put("&pa", s);
    }
    
    private final void put(final String s, final String s2) {
        zzbo.zzb(s, "Name should be non-null");
        this.zzafu.put(s, s2);
    }
    
    public final Map<String, String> build() {
        return new HashMap<String, String>(this.zzafu);
    }
    
    public ProductAction setCheckoutOptions(final String s) {
        this.put("&col", s);
        return this;
    }
    
    public ProductAction setCheckoutStep(final int i) {
        this.put("&cos", Integer.toString(i));
        return this;
    }
    
    public ProductAction setProductActionList(final String s) {
        this.put("&pal", s);
        return this;
    }
    
    public ProductAction setProductListSource(final String s) {
        this.put("&pls", s);
        return this;
    }
    
    public ProductAction setTransactionAffiliation(final String s) {
        this.put("&ta", s);
        return this;
    }
    
    public ProductAction setTransactionCouponCode(final String s) {
        this.put("&tcc", s);
        return this;
    }
    
    public ProductAction setTransactionId(final String s) {
        this.put("&ti", s);
        return this;
    }
    
    public ProductAction setTransactionRevenue(final double d) {
        this.put("&tr", Double.toString(d));
        return this;
    }
    
    public ProductAction setTransactionShipping(final double d) {
        this.put("&ts", Double.toString(d));
        return this;
    }
    
    public ProductAction setTransactionTax(final double d) {
        this.put("&tt", Double.toString(d));
        return this;
    }
    
    @Override
    public String toString() {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        for (final Map.Entry<String, String> entry : this.zzafu.entrySet()) {
            if (entry.getKey().startsWith("&")) {
                hashMap.put(entry.getKey().substring(1), entry.getValue());
            }
            else {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return zzj.zzk(hashMap);
    }
}
