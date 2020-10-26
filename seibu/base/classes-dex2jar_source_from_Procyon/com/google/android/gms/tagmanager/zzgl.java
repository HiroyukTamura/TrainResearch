// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.HitBuilders;
import java.util.regex.Matcher;
import com.google.android.gms.analytics.ecommerce.Product;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.HashMap;
import java.util.LinkedList;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.analytics.Tracker;
import java.util.HashSet;
import android.content.Context;
import java.util.Arrays;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbf;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.List;
import java.util.Map;

public final class zzgl extends zzgi
{
    private static final String ID;
    private static Map<String, String> zzbHA;
    private static final String zzbHn;
    private static final String zzbHo;
    private static final String zzbHp;
    private static final String zzbHq;
    private static final String zzbHr;
    private static final String zzbHs;
    private static final String zzbHt;
    private static final String zzbHu;
    private static final String zzbHv;
    private static final List<String> zzbHw;
    private static final Pattern zzbHx;
    private static final Pattern zzbHy;
    private static Map<String, String> zzbHz;
    private final DataLayer zzbDx;
    private final Set<String> zzbHB;
    private final zzgg zzbHC;
    
    static {
        ID = zzbf.zzeV.toString();
        zzbHn = zzbg.zzfB.toString();
        zzbHo = zzbg.zzfM.toString();
        zzbHp = zzbg.zzhm.toString();
        zzbHq = zzbg.zzhf.toString();
        zzbHr = zzbg.zzhe.toString();
        zzbHs = zzbg.zzfL.toString();
        zzbHt = zzbg.zzjU.toString();
        zzbHu = zzbg.zzjX.toString();
        zzbHv = zzbg.zzjZ.toString();
        zzbHw = Arrays.asList("detail", "checkout", "checkout_option", "click", "add", "remove", "purchase", "refund");
        zzbHx = Pattern.compile("dimension(\\d+)");
        zzbHy = Pattern.compile("metric(\\d+)");
    }
    
    public zzgl(final Context context, final DataLayer dataLayer) {
        this(context, dataLayer, new zzgg(context));
    }
    
    private zzgl(final Context context, final DataLayer zzbDx, final zzgg zzbHC) {
        super(zzgl.ID, new String[0]);
        this.zzbDx = zzbDx;
        this.zzbHC = zzbHC;
        (this.zzbHB = new HashSet<String>()).add("");
        this.zzbHB.add("0");
        this.zzbHB.add("false");
    }
    
    private static Double zzM(final Object o) {
        if (o instanceof String) {
            try {
                return Double.valueOf((String)o);
            }
            catch (NumberFormatException ex) {
                final String value = String.valueOf(ex.getMessage());
                String concat;
                if (value.length() != 0) {
                    concat = "Cannot convert the object to Double: ".concat(value);
                }
                else {
                    concat = new String("Cannot convert the object to Double: ");
                }
                throw new RuntimeException(concat);
            }
        }
        if (o instanceof Integer) {
            return (double)o;
        }
        if (o instanceof Double) {
            return (Double)o;
        }
        final String value2 = String.valueOf(o.toString());
        String concat2;
        if (value2.length() != 0) {
            concat2 = "Cannot convert the object to Double: ".concat(value2);
        }
        else {
            concat2 = new String("Cannot convert the object to Double: ");
        }
        throw new RuntimeException(concat2);
    }
    
    private static Integer zzN(final Object o) {
        if (o instanceof String) {
            try {
                return Integer.valueOf((String)o);
            }
            catch (NumberFormatException ex) {
                final String value = String.valueOf(ex.getMessage());
                String concat;
                if (value.length() != 0) {
                    concat = "Cannot convert the object to Integer: ".concat(value);
                }
                else {
                    concat = new String("Cannot convert the object to Integer: ");
                }
                throw new RuntimeException(concat);
            }
        }
        if (o instanceof Double) {
            return ((Double)o).intValue();
        }
        if (o instanceof Integer) {
            return (Integer)o;
        }
        final String value2 = String.valueOf(o.toString());
        String concat2;
        if (value2.length() != 0) {
            concat2 = "Cannot convert the object to Integer: ".concat(value2);
        }
        else {
            concat2 = new String("Cannot convert the object to Integer: ");
        }
        throw new RuntimeException(concat2);
    }
    
    private final void zza(final Tracker tracker, final Map<String, com.google.android.gms.internal.zzbr> map) {
        final String zzfA = this.zzfA("transactionId");
        if (zzfA == null) {
            zzdj.e("Cannot find transactionId in data layer.");
        }
        else {
            LinkedList<Map<String, String>> list;
            Map<String, String> zzi;
            while (true) {
                list = new LinkedList<Map<String, String>>();
                while (true) {
                    try {
                        zzi = this.zzi(map.get(zzgl.zzbHs));
                        zzi.put("&t", "transaction");
                        final com.google.android.gms.internal.zzbr zzbr = map.get(zzgl.zzbHu);
                        if (zzbr != null) {
                            final Map<String, String> map2 = zzh(zzbr);
                            for (final Map.Entry<String, String> entry : map2.entrySet()) {
                                zzd(zzi, entry.getValue(), this.zzfA(entry.getKey()));
                            }
                            break;
                        }
                    }
                    catch (IllegalArgumentException ex) {
                        zzdj.zzb("Unable to send transaction", ex);
                        return;
                    }
                    if (zzgl.zzbHz == null) {
                        final HashMap<String, String> zzbHz = new HashMap<String, String>();
                        zzbHz.put("transactionId", "&ti");
                        zzbHz.put("transactionAffiliation", "&ta");
                        zzbHz.put("transactionTax", "&tt");
                        zzbHz.put("transactionShipping", "&ts");
                        zzbHz.put("transactionTotal", "&tr");
                        zzbHz.put("transactionCurrency", "&cu");
                        zzgl.zzbHz = zzbHz;
                    }
                    final Map<String, String> map2 = zzgl.zzbHz;
                    continue;
                }
            }
            list.add(zzi);
            final List<Map<String, String>> zzfB = this.zzfB("transactionProducts");
            if (zzfB != null) {
                for (final Map<String, String> map3 : zzfB) {
                    if (map3.get("name") == null) {
                        zzdj.e("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    final Map<String, String> zzi2 = this.zzi(map.get(zzgl.zzbHs));
                    zzi2.put("&t", "item");
                    zzi2.put("&ti", zzfA);
                    final com.google.android.gms.internal.zzbr zzbr2 = map.get(zzgl.zzbHv);
                    Map<String, String> map4;
                    if (zzbr2 != null) {
                        map4 = zzh(zzbr2);
                    }
                    else {
                        if (zzgl.zzbHA == null) {
                            final HashMap<String, String> zzbHA = new HashMap<String, String>();
                            zzbHA.put("name", "&in");
                            zzbHA.put("sku", "&ic");
                            zzbHA.put("category", "&iv");
                            zzbHA.put("price", "&ip");
                            zzbHA.put("quantity", "&iq");
                            zzbHA.put("currency", "&cu");
                            zzgl.zzbHA = zzbHA;
                        }
                        map4 = zzgl.zzbHA;
                    }
                    for (final Map.Entry<String, String> entry2 : map4.entrySet()) {
                        zzd(zzi2, entry2.getValue(), map3.get(entry2.getKey()));
                    }
                    list.add(zzi2);
                }
            }
            final Iterator<Object> iterator4 = list.iterator();
            while (iterator4.hasNext()) {
                tracker.send(iterator4.next());
            }
        }
    }
    
    private static void zzd(final Map<String, String> map, final String s, final String s2) {
        if (s2 != null) {
            map.put(s, s2);
        }
    }
    
    private final String zzfA(final String s) {
        final Object value = this.zzbDx.get(s);
        if (value == null) {
            return null;
        }
        return value.toString();
    }
    
    private final List<Map<String, String>> zzfB(final String s) {
        final Object value = this.zzbDx.get(s);
        if (value == null) {
            return null;
        }
        if (!(value instanceof List)) {
            throw new IllegalArgumentException("transactionProducts should be of type List.");
        }
        final Iterator<Map<String, String>> iterator = ((List<Map<String, String>>)value).iterator();
        while (iterator.hasNext()) {
            if (!(iterator.next() instanceof Map)) {
                throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
            }
        }
        return (List<Map<String, String>>)value;
    }
    
    private static boolean zzg(final Map<String, com.google.android.gms.internal.zzbr> map, final String s) {
        final com.google.android.gms.internal.zzbr zzbr = map.get(s);
        return zzbr != null && zzgk.zzf(zzbr);
    }
    
    private static Map<String, String> zzh(final com.google.android.gms.internal.zzbr zzbr) {
        final Object zzg = zzgk.zzg(zzbr);
        if (!(zzg instanceof Map)) {
            return null;
        }
        final Map<Object, V> map = (Map<Object, V>)zzg;
        final LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        for (final Map.Entry<Object, V> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }
    
    private final Map<String, String> zzi(final com.google.android.gms.internal.zzbr zzbr) {
        if (zzbr == null) {
            return new HashMap<String, String>();
        }
        final Map<String, String> zzh = zzh(zzbr);
        if (zzh == null) {
            return new HashMap<String, String>();
        }
        final String s = zzh.get("&aip");
        if (s != null && this.zzbHB.contains(s.toLowerCase())) {
            zzh.remove("&aip");
        }
        return zzh;
    }
    
    private static Product zzt(final Map<String, Object> map) {
        final Product product = new Product();
        final Object value = map.get("id");
        if (value != null) {
            product.setId(String.valueOf(value));
        }
        final Object value2 = map.get("name");
        if (value2 != null) {
            product.setName(String.valueOf(value2));
        }
        final Object value3 = map.get("brand");
        if (value3 != null) {
            product.setBrand(String.valueOf(value3));
        }
        final Object value4 = map.get("category");
        if (value4 != null) {
            product.setCategory(String.valueOf(value4));
        }
        final Object value5 = map.get("variant");
        if (value5 != null) {
            product.setVariant(String.valueOf(value5));
        }
        final Object value6 = map.get("coupon");
        if (value6 != null) {
            product.setCouponCode(String.valueOf(value6));
        }
        final Object value7 = map.get("position");
        if (value7 != null) {
            product.setPosition(zzN(value7));
        }
        final Object value8 = map.get("price");
        if (value8 != null) {
            product.setPrice(zzM(value8));
        }
        final Object value9 = map.get("quantity");
        if (value9 != null) {
            product.setQuantity(zzN(value9));
        }
        for (final String s : map.keySet()) {
            final Matcher matcher = zzgl.zzbHx.matcher(s);
            if (matcher.matches()) {
                try {
                    product.setCustomDimension(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(s)));
                    continue;
                }
                catch (NumberFormatException ex) {
                    final String value10 = String.valueOf(s);
                    String concat;
                    if (value10.length() != 0) {
                        concat = "illegal number in custom dimension value: ".concat(value10);
                    }
                    else {
                        concat = new String("illegal number in custom dimension value: ");
                    }
                    zzdj.zzaT(concat);
                    continue;
                }
            }
            final Matcher matcher2 = zzgl.zzbHy.matcher(s);
            if (matcher2.matches()) {
                try {
                    product.setCustomMetric(Integer.parseInt(matcher2.group(1)), zzN(map.get(s)));
                    continue;
                }
                catch (NumberFormatException ex2) {
                    final String value11 = String.valueOf(s);
                    String concat2;
                    if (value11.length() != 0) {
                        concat2 = "illegal number in custom metric value: ".concat(value11);
                    }
                    else {
                        concat2 = new String("illegal number in custom metric value: ");
                    }
                    zzdj.zzaT(concat2);
                    continue;
                }
                break;
            }
        }
        return product;
    }
    
    @Override
    public final void zzq(Map<String, com.google.android.gms.internal.zzbr> map) {
        final Tracker zzfv = this.zzbHC.zzfv("_GTM_DEFAULT_TRACKER_");
        zzfv.enableAdvertisingIdCollection(zzg(map, "collect_adid"));
        if (zzg(map, zzgl.zzbHp)) {
            final HitBuilders.ScreenViewBuilder screenViewBuilder = new HitBuilders.ScreenViewBuilder();
            final Map<String, String> zzi = this.zzi(map.get(zzgl.zzbHs));
            ((HitBuilders.HitBuilder<HitBuilders.ScreenViewBuilder>)screenViewBuilder).setAll(zzi);
            if (zzg(map, zzgl.zzbHq)) {
                final Object value = this.zzbDx.get("ecommerce");
                if (value instanceof Map) {
                    map = (Map<String, com.google.android.gms.internal.zzbr>)value;
                }
                else {
                    map = null;
                }
            }
            else {
                final Object zzg = zzgk.zzg(map.get(zzgl.zzbHr));
                if (zzg instanceof Map) {
                    map = (Map<String, com.google.android.gms.internal.zzbr>)zzg;
                }
                else {
                    map = null;
                }
            }
        Label_1074:
            while (true) {
                if (map != null) {
                    String s;
                    if ((s = zzi.get("&cu")) == null) {
                        s = (String)map.get("currencyCode");
                    }
                    if (s != null) {
                        ((HitBuilders.HitBuilder<HitBuilders.ScreenViewBuilder>)screenViewBuilder).set("&cu", s);
                    }
                    final com.google.android.gms.internal.zzbr value2 = map.get("impressions");
                    if (value2 instanceof List) {
                        final Iterator<Map> iterator = ((List<Map>)value2).iterator();
                        while (iterator.hasNext()) {
                            while (true) {
                                final Map<K, String> map2 = iterator.next();
                                while (true) {
                                    Label_0289: {
                                        try {
                                            ((HitBuilders.HitBuilder<HitBuilders.ScreenViewBuilder>)screenViewBuilder).addImpression(zzt((Map<String, Object>)map2), map2.get("list"));
                                        }
                                        catch (RuntimeException ex) {
                                            final String value3 = String.valueOf(ex.getMessage());
                                            if (value3.length() == 0) {
                                                break Label_0289;
                                            }
                                            final String concat = "Failed to extract a product from DataLayer. ".concat(value3);
                                            zzdj.e(concat);
                                        }
                                        break;
                                    }
                                    final String concat = new String("Failed to extract a product from DataLayer. ");
                                    continue;
                                }
                            }
                        }
                    }
                    Object o;
                    if (map.containsKey("promoClick")) {
                        o = ((Map)map.get("promoClick")).get("promotions");
                    }
                    else if (map.containsKey("promoView")) {
                        o = ((Map)map.get("promoView")).get("promotions");
                    }
                    else {
                        o = null;
                    }
                    while (true) {
                        Label_0780: {
                            if (o == null) {
                                break Label_0780;
                            }
                            final Iterator<Map<K, String>> iterator2 = ((List<Map<K, String>>)o).iterator();
                            while (iterator2.hasNext()) {
                                while (true) {
                                    final Map<K, String> map3 = iterator2.next();
                                    while (true) {
                                        Label_0581: {
                                            try {
                                                final Promotion promotion = new Promotion();
                                                final String obj = map3.get("id");
                                                if (obj != null) {
                                                    promotion.setId(String.valueOf(obj));
                                                }
                                                final String obj2 = map3.get("name");
                                                if (obj2 != null) {
                                                    promotion.setName(String.valueOf(obj2));
                                                }
                                                final String obj3 = map3.get("creative");
                                                if (obj3 != null) {
                                                    promotion.setCreative(String.valueOf(obj3));
                                                }
                                                final String obj4 = map3.get("position");
                                                if (obj4 != null) {
                                                    promotion.setPosition(String.valueOf(obj4));
                                                }
                                                ((HitBuilders.HitBuilder<HitBuilders.ScreenViewBuilder>)screenViewBuilder).addPromotion(promotion);
                                            }
                                            catch (RuntimeException ex2) {
                                                final String value4 = String.valueOf(ex2.getMessage());
                                                if (value4.length() == 0) {
                                                    break Label_0581;
                                                }
                                                final String concat2 = "Failed to extract a promotion from DataLayer. ".concat(value4);
                                                zzdj.e(concat2);
                                            }
                                            break;
                                        }
                                        final String concat2 = new String("Failed to extract a promotion from DataLayer. ");
                                        continue;
                                    }
                                }
                            }
                            if (!map.containsKey("promoClick")) {
                                ((HitBuilders.HitBuilder<HitBuilders.ScreenViewBuilder>)screenViewBuilder).set("&promoa", "view");
                                break Label_0780;
                            }
                            ((HitBuilders.HitBuilder<HitBuilders.ScreenViewBuilder>)screenViewBuilder).set("&promoa", "click");
                            final int n = 0;
                            if (n != 0) {
                                for (final String s2 : zzgl.zzbHw) {
                                    if (map.containsKey(s2)) {
                                        final Map map4 = (Map)map.get(s2);
                                        final List<Map> list = map4.get("products");
                                        if (list != null) {
                                            final Iterator<Map<String, Object>> iterator4 = list.iterator();
                                            while (iterator4.hasNext()) {
                                                while (true) {
                                                    final Map<String, Object> map5 = iterator4.next();
                                                    while (true) {
                                                        Label_0785: {
                                                            try {
                                                                ((HitBuilders.HitBuilder<HitBuilders.ScreenViewBuilder>)screenViewBuilder).addProduct(zzt(map5));
                                                            }
                                                            catch (RuntimeException ex3) {
                                                                final String value5 = String.valueOf(ex3.getMessage());
                                                                if (value5.length() == 0) {
                                                                    break Label_0785;
                                                                }
                                                                final String concat3 = "Failed to extract a product from DataLayer. ".concat(value5);
                                                                zzdj.e(concat3);
                                                            }
                                                            break;
                                                        }
                                                        final String concat3 = new String("Failed to extract a product from DataLayer. ");
                                                        continue;
                                                    }
                                                }
                                            }
                                        }
                                        break Label_1074;
                                    }
                                }
                                break Label_1074;
                            }
                            break Label_1074;
                        }
                        final int n = 1;
                        continue;
                    }
                }
                break Label_1074;
                while (true) {
                    while (true) {
                        Label_1214: {
                            try {
                                final String s2;
                                final Map map4;
                                if (!map4.containsKey("actionField")) {
                                    final ProductAction productAction = new ProductAction(s2);
                                    ((HitBuilders.HitBuilder<HitBuilders.ScreenViewBuilder>)screenViewBuilder).setProductAction(productAction);
                                    zzfv.send(((HitBuilders.HitBuilder)screenViewBuilder).build());
                                    return;
                                }
                                final Map map6 = (Map)map4.get("actionField");
                                final ProductAction productAction = new ProductAction(s2);
                                final Object value6 = map6.get("id");
                                if (value6 != null) {
                                    productAction.setTransactionId(String.valueOf(value6));
                                }
                                final Object value7 = map6.get("affiliation");
                                if (value7 != null) {
                                    productAction.setTransactionAffiliation(String.valueOf(value7));
                                }
                                final Object value8 = map6.get("coupon");
                                if (value8 != null) {
                                    productAction.setTransactionCouponCode(String.valueOf(value8));
                                }
                                final Object value9 = map6.get("list");
                                if (value9 != null) {
                                    productAction.setProductActionList(String.valueOf(value9));
                                }
                                final Object value10 = map6.get("option");
                                if (value10 != null) {
                                    productAction.setCheckoutOptions(String.valueOf(value10));
                                }
                                final Object value11 = map6.get("revenue");
                                if (value11 != null) {
                                    productAction.setTransactionRevenue(zzM(value11));
                                }
                                final Object value12 = map6.get("tax");
                                if (value12 != null) {
                                    productAction.setTransactionTax(zzM(value12));
                                }
                                final Object value13 = map6.get("shipping");
                                if (value13 != null) {
                                    productAction.setTransactionShipping(zzM(value13));
                                }
                                final Object value14 = map6.get("step");
                                if (value14 != null) {
                                    productAction.setCheckoutStep(zzN(value14));
                                    break Label_1214;
                                }
                                break Label_1214;
                            }
                            catch (RuntimeException ex4) {
                                final String value15 = String.valueOf(ex4.getMessage());
                                String concat4;
                                if (value15.length() != 0) {
                                    concat4 = "Failed to extract a product action from DataLayer. ".concat(value15);
                                }
                                else {
                                    concat4 = new String("Failed to extract a product action from DataLayer. ");
                                }
                                zzdj.e(concat4);
                                continue Label_1074;
                            }
                            break;
                        }
                        continue;
                    }
                }
                break;
            }
        }
        if (zzg(map, zzgl.zzbHo)) {
            zzfv.send(this.zzi(map.get(zzgl.zzbHs)));
            return;
        }
        if (zzg(map, zzgl.zzbHt)) {
            this.zza(zzfv, map);
            return;
        }
        zzdj.zzaT("Ignoring unknown tag.");
    }
}
