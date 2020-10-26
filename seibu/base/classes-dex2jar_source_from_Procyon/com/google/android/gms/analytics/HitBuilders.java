// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import java.util.Iterator;
import android.text.TextUtils;
import com.google.android.gms.internal.zzaob;
import java.util.ArrayList;
import java.util.HashMap;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.ecommerce.Product;
import java.util.List;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.Map;
import com.google.android.gms.internal.zzaos;

public class HitBuilders
{
    @Deprecated
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder>
    {
        public AppViewBuilder() {
            this.set("&t", "screenview");
        }
    }
    
    public static class EventBuilder extends HitBuilder<EventBuilder>
    {
        public EventBuilder() {
            this.set("&t", "event");
        }
        
        public EventBuilder(final String category, final String action) {
            this();
            this.setCategory(category);
            this.setAction(action);
        }
        
        public EventBuilder setAction(final String s) {
            this.set("&ea", s);
            return this;
        }
        
        public EventBuilder setCategory(final String s) {
            this.set("&ec", s);
            return this;
        }
        
        public EventBuilder setLabel(final String s) {
            this.set("&el", s);
            return this;
        }
        
        public EventBuilder setValue(final long i) {
            this.set("&ev", Long.toString(i));
            return this;
        }
    }
    
    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder>
    {
        public ExceptionBuilder() {
            this.set("&t", "exception");
        }
        
        public ExceptionBuilder setDescription(final String s) {
            this.set("&exd", s);
            return this;
        }
        
        public ExceptionBuilder setFatal(final boolean b) {
            this.set("&exf", zzaos.zzI(b));
            return this;
        }
    }
    
    public static class HitBuilder<T extends HitBuilder>
    {
        private Map<String, String> zzadJ;
        private ProductAction zzadK;
        private Map<String, List<Product>> zzadL;
        private List<Promotion> zzadM;
        private List<Product> zzadN;
        
        protected HitBuilder() {
            this.zzadJ = new HashMap<String, String>();
            this.zzadL = new HashMap<String, List<Product>>();
            this.zzadM = new ArrayList<Promotion>();
            this.zzadN = new ArrayList<Product>();
        }
        
        private final T zzk(final String s, final String s2) {
            if (s2 != null) {
                this.zzadJ.put(s, s2);
            }
            return (T)this;
        }
        
        public T addImpression(final Product product, final String s) {
            if (product == null) {
                zzaob.zzaT("product should be non-null");
                return (T)this;
            }
            String s2;
            if ((s2 = s) == null) {
                s2 = "";
            }
            if (!this.zzadL.containsKey(s2)) {
                this.zzadL.put(s2, new ArrayList<Product>());
            }
            this.zzadL.get(s2).add(product);
            return (T)this;
        }
        
        public T addProduct(final Product product) {
            if (product == null) {
                zzaob.zzaT("product should be non-null");
                return (T)this;
            }
            this.zzadN.add(product);
            return (T)this;
        }
        
        public T addPromotion(final Promotion promotion) {
            if (promotion == null) {
                zzaob.zzaT("promotion should be non-null");
                return (T)this;
            }
            this.zzadM.add(promotion);
            return (T)this;
        }
        
        public Map<String, String> build() {
            final HashMap<String, String> hashMap = new HashMap<String, String>(this.zzadJ);
            if (this.zzadK != null) {
                hashMap.putAll((Map<?, ?>)this.zzadK.build());
            }
            final Iterator<Promotion> iterator = this.zzadM.iterator();
            int n = 1;
            while (iterator.hasNext()) {
                hashMap.putAll((Map<?, ?>)iterator.next().zzbl(zzf.zzI(n)));
                ++n;
            }
            final Iterator<Product> iterator2 = this.zzadN.iterator();
            int n2 = 1;
            while (iterator2.hasNext()) {
                hashMap.putAll((Map<?, ?>)iterator2.next().zzbl(zzf.zzG(n2)));
                ++n2;
            }
            final Iterator<Map.Entry<String, List<Product>>> iterator3 = this.zzadL.entrySet().iterator();
            int n3 = 1;
            while (iterator3.hasNext()) {
                final Map.Entry<String, List<Product>> entry = iterator3.next();
                final List<Product> list = entry.getValue();
                final String zzL = zzf.zzL(n3);
                final Iterator<Product> iterator4 = list.iterator();
                int n4 = 1;
                while (iterator4.hasNext()) {
                    final Product product = iterator4.next();
                    final String value = String.valueOf(zzL);
                    final String value2 = String.valueOf(zzf.zzK(n4));
                    String concat;
                    if (value2.length() != 0) {
                        concat = value.concat(value2);
                    }
                    else {
                        concat = new String(value);
                    }
                    hashMap.putAll((Map<?, ?>)product.zzbl(concat));
                    ++n4;
                }
                if (!TextUtils.isEmpty((CharSequence)entry.getKey())) {
                    final String value3 = String.valueOf(zzL);
                    final String value4 = String.valueOf("nm");
                    String concat2;
                    if (value4.length() != 0) {
                        concat2 = value3.concat(value4);
                    }
                    else {
                        concat2 = new String(value3);
                    }
                    hashMap.put(concat2, entry.getKey());
                }
                ++n3;
            }
            return hashMap;
        }
        
        protected String get(final String s) {
            return this.zzadJ.get(s);
        }
        
        public final T set(final String s, final String s2) {
            if (s != null) {
                this.zzadJ.put(s, s2);
                return (T)this;
            }
            zzaob.zzaT("HitBuilder.set() called with a null paramName.");
            return (T)this;
        }
        
        public final T setAll(final Map<String, String> m) {
            if (m == null) {
                return (T)this;
            }
            this.zzadJ.putAll(new HashMap<String, String>(m));
            return (T)this;
        }
        
        public T setCampaignParamsFromUrl(String zzbD) {
            zzbD = zzaos.zzbD(zzbD);
            if (TextUtils.isEmpty((CharSequence)zzbD)) {
                return (T)this;
            }
            final Map<String, String> zzbB = zzaos.zzbB(zzbD);
            this.zzk("&cc", zzbB.get("utm_content"));
            this.zzk("&cm", zzbB.get("utm_medium"));
            this.zzk("&cn", zzbB.get("utm_campaign"));
            this.zzk("&cs", zzbB.get("utm_source"));
            this.zzk("&ck", zzbB.get("utm_term"));
            this.zzk("&ci", zzbB.get("utm_id"));
            this.zzk("&anid", zzbB.get("anid"));
            this.zzk("&gclid", zzbB.get("gclid"));
            this.zzk("&dclid", zzbB.get("dclid"));
            this.zzk("&aclid", zzbB.get("aclid"));
            this.zzk("&gmob_t", zzbB.get("gmob_t"));
            return (T)this;
        }
        
        public T setCustomDimension(final int n, final String s) {
            this.set(zzf.zzC(n), s);
            return (T)this;
        }
        
        public T setCustomMetric(final int n, final float f) {
            this.set(zzf.zzE(n), Float.toString(f));
            return (T)this;
        }
        
        protected T setHitType(final String s) {
            this.set("&t", s);
            return (T)this;
        }
        
        public T setNewSession() {
            this.set("&sc", "start");
            return (T)this;
        }
        
        public T setNonInteraction(final boolean b) {
            this.set("&ni", zzaos.zzI(b));
            return (T)this;
        }
        
        public T setProductAction(final ProductAction zzadK) {
            this.zzadK = zzadK;
            return (T)this;
        }
        
        public T setPromotionAction(final String s) {
            this.zzadJ.put("&promoa", s);
            return (T)this;
        }
    }
    
    @Deprecated
    public static class ItemBuilder extends HitBuilder<ItemBuilder>
    {
        public ItemBuilder() {
            this.set("&t", "item");
        }
        
        public ItemBuilder setCategory(final String s) {
            this.set("&iv", s);
            return this;
        }
        
        public ItemBuilder setCurrencyCode(final String s) {
            this.set("&cu", s);
            return this;
        }
        
        public ItemBuilder setName(final String s) {
            this.set("&in", s);
            return this;
        }
        
        public ItemBuilder setPrice(final double d) {
            this.set("&ip", Double.toString(d));
            return this;
        }
        
        public ItemBuilder setQuantity(final long i) {
            this.set("&iq", Long.toString(i));
            return this;
        }
        
        public ItemBuilder setSku(final String s) {
            this.set("&ic", s);
            return this;
        }
        
        public ItemBuilder setTransactionId(final String s) {
            this.set("&ti", s);
            return this;
        }
    }
    
    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder>
    {
        public ScreenViewBuilder() {
            this.set("&t", "screenview");
        }
    }
    
    public static class SocialBuilder extends HitBuilder<SocialBuilder>
    {
        public SocialBuilder() {
            this.set("&t", "social");
        }
        
        public SocialBuilder setAction(final String s) {
            this.set("&sa", s);
            return this;
        }
        
        public SocialBuilder setNetwork(final String s) {
            this.set("&sn", s);
            return this;
        }
        
        public SocialBuilder setTarget(final String s) {
            this.set("&st", s);
            return this;
        }
    }
    
    public static class TimingBuilder extends HitBuilder<TimingBuilder>
    {
        public TimingBuilder() {
            this.set("&t", "timing");
        }
        
        public TimingBuilder(final String category, final String variable, final long value) {
            this();
            this.setVariable(variable);
            this.setValue(value);
            this.setCategory(category);
        }
        
        public TimingBuilder setCategory(final String s) {
            this.set("&utc", s);
            return this;
        }
        
        public TimingBuilder setLabel(final String s) {
            this.set("&utl", s);
            return this;
        }
        
        public TimingBuilder setValue(final long i) {
            this.set("&utt", Long.toString(i));
            return this;
        }
        
        public TimingBuilder setVariable(final String s) {
            this.set("&utv", s);
            return this;
        }
    }
    
    @Deprecated
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder>
    {
        public TransactionBuilder() {
            this.set("&t", "transaction");
        }
        
        public TransactionBuilder setAffiliation(final String s) {
            this.set("&ta", s);
            return this;
        }
        
        public TransactionBuilder setCurrencyCode(final String s) {
            this.set("&cu", s);
            return this;
        }
        
        public TransactionBuilder setRevenue(final double d) {
            this.set("&tr", Double.toString(d));
            return this;
        }
        
        public TransactionBuilder setShipping(final double d) {
            this.set("&ts", Double.toString(d));
            return this;
        }
        
        public TransactionBuilder setTax(final double d) {
            this.set("&tt", Double.toString(d));
            return this;
        }
        
        public TransactionBuilder setTransactionId(final String s) {
            this.set("&ti", s);
            return this;
        }
    }
}
