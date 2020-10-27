package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p043jp.reifrontier.gym.RFGDef;

@ShowFirstParty
@VisibleForTesting
public final class zzgk extends zzgh {

    /* renamed from: ID */
    private static final String f990ID = zza.UNIVERSAL_ANALYTICS.toString();
    private static final String zzalx = zzb.ACCOUNT.toString();
    private static final String zzaly = zzb.ANALYTICS_PASS_THROUGH.toString();
    private static final String zzalz = zzb.ENABLE_ECOMMERCE.toString();
    private static final String zzama = zzb.ECOMMERCE_USE_DATA_LAYER.toString();
    private static final String zzamb = zzb.ECOMMERCE_MACRO_DATA.toString();
    private static final String zzamc = zzb.ANALYTICS_FIELDS.toString();
    private static final String zzamd = zzb.TRACK_TRANSACTION.toString();
    private static final String zzame = zzb.TRANSACTION_DATALAYER_MAP.toString();
    private static final String zzamf = zzb.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    private static final List<String> zzamg = Arrays.asList(new String[]{ProductAction.ACTION_DETAIL, ProductAction.ACTION_CHECKOUT, "checkout_option", "click", ProductAction.ACTION_ADD, ProductAction.ACTION_REMOVE, "purchase", "refund"});
    private static final Pattern zzamh = Pattern.compile("dimension(\\d+)");
    private static final Pattern zzami = Pattern.compile("metric(\\d+)");
    private static Map<String, String> zzamj;
    private static Map<String, String> zzamk;
    private final DataLayer zzaed;
    private final Set<String> zzaml;
    private final zzgf zzamm;

    public zzgk(Context context, DataLayer dataLayer) {
        this(context, dataLayer, new zzgf(context));
    }

    @VisibleForTesting
    private zzgk(Context context, DataLayer dataLayer, zzgf zzgf) {
        super(f990ID, new String[0]);
        this.zzaed = dataLayer;
        this.zzamm = zzgf;
        HashSet hashSet = new HashSet();
        this.zzaml = hashSet;
        hashSet.add("");
        this.zzaml.add(RFGDef.DEFAULT_GYM_ID);
        this.zzaml.add("false");
    }

    private final String zzbr(String str) {
        Object obj = this.zzaed.get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    private static boolean zzc(Map<String, zzl> map, String str) {
        zzl zzl = map.get(str);
        if (zzl == null) {
            return false;
        }
        return zzgj.zzg(zzl).booleanValue();
    }

    private static void zzd(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private static Product zzf(Map<String, Object> map) {
        String str;
        String valueOf;
        String str2;
        Product product = new Product();
        Object obj = map.get("id");
        if (obj != null) {
            product.setId(String.valueOf(obj));
        }
        Object obj2 = map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
        if (obj2 != null) {
            product.setName(String.valueOf(obj2));
        }
        Object obj3 = map.get("brand");
        if (obj3 != null) {
            product.setBrand(String.valueOf(obj3));
        }
        Object obj4 = map.get("category");
        if (obj4 != null) {
            product.setCategory(String.valueOf(obj4));
        }
        Object obj5 = map.get("variant");
        if (obj5 != null) {
            product.setVariant(String.valueOf(obj5));
        }
        Object obj6 = map.get(FirebaseAnalytics.Param.COUPON);
        if (obj6 != null) {
            product.setCouponCode(String.valueOf(obj6));
        }
        Object obj7 = map.get("position");
        if (obj7 != null) {
            product.setPosition(zzn(obj7).intValue());
        }
        Object obj8 = map.get(FirebaseAnalytics.Param.PRICE);
        if (obj8 != null) {
            product.setPrice(zzm(obj8).doubleValue());
        }
        Object obj9 = map.get(FirebaseAnalytics.Param.QUANTITY);
        if (obj9 != null) {
            product.setQuantity(zzn(obj9).intValue());
        }
        for (String next : map.keySet()) {
            Matcher matcher = zzamh.matcher(next);
            if (matcher.matches()) {
                try {
                    product.setCustomDimension(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(next)));
                } catch (NumberFormatException unused) {
                    str = "illegal number in custom dimension value: ";
                    valueOf = String.valueOf(next);
                    if (valueOf.length() == 0) {
                        str2 = new String(str);
                        zzdi.zzac(str2);
                    }
                    str2 = str.concat(valueOf);
                    zzdi.zzac(str2);
                }
            } else {
                Matcher matcher2 = zzami.matcher(next);
                if (matcher2.matches()) {
                    try {
                        product.setCustomMetric(Integer.parseInt(matcher2.group(1)), zzn(map.get(next)).intValue());
                    } catch (NumberFormatException unused2) {
                        str = "illegal number in custom metric value: ";
                        valueOf = String.valueOf(next);
                        if (valueOf.length() == 0) {
                            str2 = new String(str);
                            zzdi.zzac(str2);
                        }
                        str2 = str.concat(valueOf);
                        zzdi.zzac(str2);
                    }
                }
            }
        }
        return product;
    }

    private static Map<String, String> zzi(zzl zzl) {
        Object zzh = zzgj.zzh(zzl);
        if (!(zzh instanceof Map)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : ((Map) zzh).entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private final Map<String, String> zzj(zzl zzl) {
        if (zzl == null) {
            return new HashMap();
        }
        Map<String, String> zzi = zzi(zzl);
        if (zzi == null) {
            return new HashMap();
        }
        String str = zzi.get("&aip");
        if (str != null && this.zzaml.contains(str.toLowerCase())) {
            zzi.remove("&aip");
        }
        return zzi;
    }

    private static Double zzm(Object obj) {
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e) {
                String valueOf = String.valueOf(e.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? "Cannot convert the object to Double: ".concat(valueOf) : new String("Cannot convert the object to Double: "));
            }
        } else if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        } else {
            if (obj instanceof Double) {
                return (Double) obj;
            }
            String valueOf2 = String.valueOf(obj.toString());
            throw new RuntimeException(valueOf2.length() != 0 ? "Cannot convert the object to Double: ".concat(valueOf2) : new String("Cannot convert the object to Double: "));
        }
    }

    private static Integer zzn(Object obj) {
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e) {
                String valueOf = String.valueOf(e.getMessage());
                throw new RuntimeException(valueOf.length() != 0 ? "Cannot convert the object to Integer: ".concat(valueOf) : new String("Cannot convert the object to Integer: "));
            }
        } else if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        } else {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            String valueOf2 = String.valueOf(obj.toString());
            throw new RuntimeException(valueOf2.length() != 0 ? "Cannot convert the object to Integer: ".concat(valueOf2) : new String("Cannot convert the object to Integer: "));
        }
    }

    public final /* bridge */ /* synthetic */ zzl zzb(Map map) {
        return super.zzb(map);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0049, code lost:
        if ((r15 instanceof java.util.Map) != false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x005a, code lost:
        if ((r15 instanceof java.util.Map) != false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x005f, code lost:
        r15 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0168  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(java.util.Map<java.lang.String, com.google.android.gms.internal.gtm.zzl> r15) {
        /*
            r14 = this;
            java.lang.String r0 = "actionField"
            java.lang.String r1 = "&t"
            com.google.android.gms.tagmanager.zzgf r2 = r14.zzamm
            java.lang.String r3 = "_GTM_DEFAULT_TRACKER_"
            com.google.android.gms.analytics.Tracker r2 = r2.zzbm(r3)
            java.lang.String r3 = "collect_adid"
            boolean r3 = zzc(r15, r3)
            r2.enableAdvertisingIdCollection(r3)
            java.lang.String r3 = zzalz
            boolean r3 = zzc(r15, r3)
            r4 = 0
            java.lang.String r5 = "name"
            r6 = 0
            java.lang.String r7 = "&cu"
            if (r3 == 0) goto L_0x0299
            com.google.android.gms.analytics.HitBuilders$ScreenViewBuilder r1 = new com.google.android.gms.analytics.HitBuilders$ScreenViewBuilder
            r1.<init>()
            java.lang.String r3 = zzamc
            java.lang.Object r3 = r15.get(r3)
            com.google.android.gms.internal.gtm.zzl r3 = (com.google.android.gms.internal.gtm.zzl) r3
            java.util.Map r3 = r14.zzj(r3)
            r1.setAll(r3)
            java.lang.String r8 = zzama
            boolean r8 = zzc(r15, r8)
            if (r8 == 0) goto L_0x004c
            com.google.android.gms.tagmanager.DataLayer r15 = r14.zzaed
            java.lang.String r8 = "ecommerce"
            java.lang.Object r15 = r15.get(r8)
            boolean r8 = r15 instanceof java.util.Map
            if (r8 == 0) goto L_0x005f
            goto L_0x005c
        L_0x004c:
            java.lang.String r8 = zzamb
            java.lang.Object r15 = r15.get(r8)
            com.google.android.gms.internal.gtm.zzl r15 = (com.google.android.gms.internal.gtm.zzl) r15
            java.lang.Object r15 = com.google.android.gms.tagmanager.zzgj.zzh((com.google.android.gms.internal.gtm.zzl) r15)
            boolean r8 = r15 instanceof java.util.Map
            if (r8 == 0) goto L_0x005f
        L_0x005c:
            java.util.Map r15 = (java.util.Map) r15
            goto L_0x0060
        L_0x005f:
            r15 = r6
        L_0x0060:
            if (r15 == 0) goto L_0x0291
            java.lang.Object r3 = r3.get(r7)
            java.lang.String r3 = (java.lang.String) r3
            if (r3 != 0) goto L_0x0072
            java.lang.String r3 = "currencyCode"
            java.lang.Object r3 = r15.get(r3)
            java.lang.String r3 = (java.lang.String) r3
        L_0x0072:
            if (r3 == 0) goto L_0x0077
            r1.set(r7, r3)
        L_0x0077:
            java.lang.String r3 = "impressions"
            java.lang.Object r3 = r15.get(r3)
            boolean r7 = r3 instanceof java.util.List
            java.lang.String r8 = "Failed to extract a product from DataLayer. "
            java.lang.String r9 = "list"
            if (r7 == 0) goto L_0x00c2
            java.util.List r3 = (java.util.List) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x008b:
            boolean r7 = r3.hasNext()
            if (r7 == 0) goto L_0x00c2
            java.lang.Object r7 = r3.next()
            java.util.Map r7 = (java.util.Map) r7
            com.google.android.gms.analytics.ecommerce.Product r10 = zzf(r7)     // Catch:{ RuntimeException -> 0x00a5 }
            java.lang.Object r7 = r7.get(r9)     // Catch:{ RuntimeException -> 0x00a5 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ RuntimeException -> 0x00a5 }
            r1.addImpression(r10, r7)     // Catch:{ RuntimeException -> 0x00a5 }
            goto L_0x008b
        L_0x00a5:
            r7 = move-exception
            java.lang.String r7 = r7.getMessage()
            java.lang.String r7 = java.lang.String.valueOf(r7)
            int r10 = r7.length()
            if (r10 == 0) goto L_0x00b9
            java.lang.String r7 = r8.concat(r7)
            goto L_0x00be
        L_0x00b9:
            java.lang.String r7 = new java.lang.String
            r7.<init>(r8)
        L_0x00be:
            com.google.android.gms.tagmanager.zzdi.zzav(r7)
            goto L_0x008b
        L_0x00c2:
            java.lang.String r3 = "promoClick"
            boolean r7 = r15.containsKey(r3)
            java.lang.String r10 = "promotions"
            if (r7 == 0) goto L_0x00d9
            java.lang.Object r6 = r15.get(r3)
        L_0x00d0:
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r6 = r6.get(r10)
            java.util.List r6 = (java.util.List) r6
            goto L_0x00e6
        L_0x00d9:
            java.lang.String r7 = "promoView"
            boolean r11 = r15.containsKey(r7)
            if (r11 == 0) goto L_0x00e6
            java.lang.Object r6 = r15.get(r7)
            goto L_0x00d0
        L_0x00e6:
            java.lang.String r7 = "id"
            if (r6 == 0) goto L_0x0165
            java.util.Iterator r6 = r6.iterator()
        L_0x00ee:
            boolean r10 = r6.hasNext()
            if (r10 == 0) goto L_0x0152
            java.lang.Object r10 = r6.next()
            java.util.Map r10 = (java.util.Map) r10
            com.google.android.gms.analytics.ecommerce.Promotion r11 = new com.google.android.gms.analytics.ecommerce.Promotion     // Catch:{ RuntimeException -> 0x0133 }
            r11.<init>()     // Catch:{ RuntimeException -> 0x0133 }
            java.lang.Object r12 = r10.get(r7)     // Catch:{ RuntimeException -> 0x0133 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ RuntimeException -> 0x0133 }
            if (r12 == 0) goto L_0x010a
            r11.setId(r12)     // Catch:{ RuntimeException -> 0x0133 }
        L_0x010a:
            java.lang.Object r12 = r10.get(r5)     // Catch:{ RuntimeException -> 0x0133 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ RuntimeException -> 0x0133 }
            if (r12 == 0) goto L_0x0115
            r11.setName(r12)     // Catch:{ RuntimeException -> 0x0133 }
        L_0x0115:
            java.lang.String r12 = "creative"
            java.lang.Object r12 = r10.get(r12)     // Catch:{ RuntimeException -> 0x0133 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ RuntimeException -> 0x0133 }
            if (r12 == 0) goto L_0x0122
            r11.setCreative(r12)     // Catch:{ RuntimeException -> 0x0133 }
        L_0x0122:
            java.lang.String r12 = "position"
            java.lang.Object r10 = r10.get(r12)     // Catch:{ RuntimeException -> 0x0133 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ RuntimeException -> 0x0133 }
            if (r10 == 0) goto L_0x012f
            r11.setPosition(r10)     // Catch:{ RuntimeException -> 0x0133 }
        L_0x012f:
            r1.addPromotion(r11)     // Catch:{ RuntimeException -> 0x0133 }
            goto L_0x00ee
        L_0x0133:
            r10 = move-exception
            java.lang.String r11 = "Failed to extract a promotion from DataLayer. "
            java.lang.String r10 = r10.getMessage()
            java.lang.String r10 = java.lang.String.valueOf(r10)
            int r12 = r10.length()
            if (r12 == 0) goto L_0x0149
            java.lang.String r10 = r11.concat(r10)
            goto L_0x014e
        L_0x0149:
            java.lang.String r10 = new java.lang.String
            r10.<init>(r11)
        L_0x014e:
            com.google.android.gms.tagmanager.zzdi.zzav(r10)
            goto L_0x00ee
        L_0x0152:
            boolean r3 = r15.containsKey(r3)
            java.lang.String r5 = "&promoa"
            if (r3 == 0) goto L_0x0160
            java.lang.String r3 = "click"
            r1.set(r5, r3)
            goto L_0x0166
        L_0x0160:
            java.lang.String r3 = "view"
            r1.set(r5, r3)
        L_0x0165:
            r4 = 1
        L_0x0166:
            if (r4 == 0) goto L_0x0291
            java.util.List<java.lang.String> r3 = zzamg
            java.util.Iterator r3 = r3.iterator()
        L_0x016e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0291
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = r15.containsKey(r4)
            if (r5 == 0) goto L_0x016e
            java.lang.Object r15 = r15.get(r4)
            java.util.Map r15 = (java.util.Map) r15
            java.lang.String r3 = "products"
            java.lang.Object r3 = r15.get(r3)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x01c5
            java.util.Iterator r3 = r3.iterator()
        L_0x0194:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x01c5
            java.lang.Object r5 = r3.next()
            java.util.Map r5 = (java.util.Map) r5
            com.google.android.gms.analytics.ecommerce.Product r5 = zzf(r5)     // Catch:{ RuntimeException -> 0x01a8 }
            r1.addProduct(r5)     // Catch:{ RuntimeException -> 0x01a8 }
            goto L_0x0194
        L_0x01a8:
            r5 = move-exception
            java.lang.String r5 = r5.getMessage()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x01bc
            java.lang.String r5 = r8.concat(r5)
            goto L_0x01c1
        L_0x01bc:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r8)
        L_0x01c1:
            com.google.android.gms.tagmanager.zzdi.zzav(r5)
            goto L_0x0194
        L_0x01c5:
            boolean r3 = r15.containsKey(r0)     // Catch:{ RuntimeException -> 0x0273 }
            if (r3 == 0) goto L_0x026a
            java.lang.Object r15 = r15.get(r0)     // Catch:{ RuntimeException -> 0x0273 }
            java.util.Map r15 = (java.util.Map) r15     // Catch:{ RuntimeException -> 0x0273 }
            com.google.android.gms.analytics.ecommerce.ProductAction r0 = new com.google.android.gms.analytics.ecommerce.ProductAction     // Catch:{ RuntimeException -> 0x0273 }
            r0.<init>(r4)     // Catch:{ RuntimeException -> 0x0273 }
            java.lang.Object r3 = r15.get(r7)     // Catch:{ RuntimeException -> 0x0273 }
            if (r3 == 0) goto L_0x01e3
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ RuntimeException -> 0x0273 }
            r0.setTransactionId(r3)     // Catch:{ RuntimeException -> 0x0273 }
        L_0x01e3:
            java.lang.String r3 = "affiliation"
            java.lang.Object r3 = r15.get(r3)     // Catch:{ RuntimeException -> 0x0273 }
            if (r3 == 0) goto L_0x01f2
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ RuntimeException -> 0x0273 }
            r0.setTransactionAffiliation(r3)     // Catch:{ RuntimeException -> 0x0273 }
        L_0x01f2:
            java.lang.String r3 = "coupon"
            java.lang.Object r3 = r15.get(r3)     // Catch:{ RuntimeException -> 0x0273 }
            if (r3 == 0) goto L_0x0201
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ RuntimeException -> 0x0273 }
            r0.setTransactionCouponCode(r3)     // Catch:{ RuntimeException -> 0x0273 }
        L_0x0201:
            java.lang.Object r3 = r15.get(r9)     // Catch:{ RuntimeException -> 0x0273 }
            if (r3 == 0) goto L_0x020e
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ RuntimeException -> 0x0273 }
            r0.setProductActionList(r3)     // Catch:{ RuntimeException -> 0x0273 }
        L_0x020e:
            java.lang.String r3 = "option"
            java.lang.Object r3 = r15.get(r3)     // Catch:{ RuntimeException -> 0x0273 }
            if (r3 == 0) goto L_0x021d
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ RuntimeException -> 0x0273 }
            r0.setCheckoutOptions(r3)     // Catch:{ RuntimeException -> 0x0273 }
        L_0x021d:
            java.lang.String r3 = "revenue"
            java.lang.Object r3 = r15.get(r3)     // Catch:{ RuntimeException -> 0x0273 }
            if (r3 == 0) goto L_0x0230
            java.lang.Double r3 = zzm(r3)     // Catch:{ RuntimeException -> 0x0273 }
            double r3 = r3.doubleValue()     // Catch:{ RuntimeException -> 0x0273 }
            r0.setTransactionRevenue(r3)     // Catch:{ RuntimeException -> 0x0273 }
        L_0x0230:
            java.lang.String r3 = "tax"
            java.lang.Object r3 = r15.get(r3)     // Catch:{ RuntimeException -> 0x0273 }
            if (r3 == 0) goto L_0x0243
            java.lang.Double r3 = zzm(r3)     // Catch:{ RuntimeException -> 0x0273 }
            double r3 = r3.doubleValue()     // Catch:{ RuntimeException -> 0x0273 }
            r0.setTransactionTax(r3)     // Catch:{ RuntimeException -> 0x0273 }
        L_0x0243:
            java.lang.String r3 = "shipping"
            java.lang.Object r3 = r15.get(r3)     // Catch:{ RuntimeException -> 0x0273 }
            if (r3 == 0) goto L_0x0256
            java.lang.Double r3 = zzm(r3)     // Catch:{ RuntimeException -> 0x0273 }
            double r3 = r3.doubleValue()     // Catch:{ RuntimeException -> 0x0273 }
            r0.setTransactionShipping(r3)     // Catch:{ RuntimeException -> 0x0273 }
        L_0x0256:
            java.lang.String r3 = "step"
            java.lang.Object r15 = r15.get(r3)     // Catch:{ RuntimeException -> 0x0273 }
            if (r15 == 0) goto L_0x026f
            java.lang.Integer r15 = zzn(r15)     // Catch:{ RuntimeException -> 0x0273 }
            int r15 = r15.intValue()     // Catch:{ RuntimeException -> 0x0273 }
            r0.setCheckoutStep(r15)     // Catch:{ RuntimeException -> 0x0273 }
            goto L_0x026f
        L_0x026a:
            com.google.android.gms.analytics.ecommerce.ProductAction r0 = new com.google.android.gms.analytics.ecommerce.ProductAction     // Catch:{ RuntimeException -> 0x0273 }
            r0.<init>(r4)     // Catch:{ RuntimeException -> 0x0273 }
        L_0x026f:
            r1.setProductAction(r0)     // Catch:{ RuntimeException -> 0x0273 }
            goto L_0x0291
        L_0x0273:
            r15 = move-exception
            java.lang.String r0 = "Failed to extract a product action from DataLayer. "
            java.lang.String r15 = r15.getMessage()
            java.lang.String r15 = java.lang.String.valueOf(r15)
            int r3 = r15.length()
            if (r3 == 0) goto L_0x0289
            java.lang.String r15 = r0.concat(r15)
            goto L_0x028e
        L_0x0289:
            java.lang.String r15 = new java.lang.String
            r15.<init>(r0)
        L_0x028e:
            com.google.android.gms.tagmanager.zzdi.zzav(r15)
        L_0x0291:
            java.util.Map r15 = r1.build()
            r2.send(r15)
            return
        L_0x0299:
            java.lang.String r0 = zzaly
            boolean r0 = zzc(r15, r0)
            if (r0 == 0) goto L_0x02b1
            java.lang.String r0 = zzamc
            java.lang.Object r15 = r15.get(r0)
            com.google.android.gms.internal.gtm.zzl r15 = (com.google.android.gms.internal.gtm.zzl) r15
            java.util.Map r15 = r14.zzj(r15)
            r2.send(r15)
            return
        L_0x02b1:
            java.lang.String r0 = zzamd
            boolean r0 = zzc(r15, r0)
            if (r0 == 0) goto L_0x043d
            java.lang.String r0 = "transactionId"
            java.lang.String r3 = r14.zzbr(r0)
            if (r3 != 0) goto L_0x02c7
            java.lang.String r15 = "Cannot find transactionId in data layer."
            com.google.android.gms.tagmanager.zzdi.zzav(r15)
            return
        L_0x02c7:
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.lang.String r9 = zzamc     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.Object r9 = r15.get(r9)     // Catch:{ IllegalArgumentException -> 0x0436 }
            com.google.android.gms.internal.gtm.zzl r9 = (com.google.android.gms.internal.gtm.zzl) r9     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.util.Map r9 = r14.zzj(r9)     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r10 = "transaction"
            r9.put(r1, r10)     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r10 = zzame     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.Object r10 = r15.get(r10)     // Catch:{ IllegalArgumentException -> 0x0436 }
            com.google.android.gms.internal.gtm.zzl r10 = (com.google.android.gms.internal.gtm.zzl) r10     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r11 = "&ti"
            if (r10 == 0) goto L_0x02ee
            java.util.Map r0 = zzi(r10)     // Catch:{ IllegalArgumentException -> 0x0436 }
            goto L_0x031f
        L_0x02ee:
            java.util.Map<java.lang.String, java.lang.String> r10 = zzamj     // Catch:{ IllegalArgumentException -> 0x0436 }
            if (r10 != 0) goto L_0x031d
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ IllegalArgumentException -> 0x0436 }
            r10.<init>()     // Catch:{ IllegalArgumentException -> 0x0436 }
            r10.put(r0, r11)     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r0 = "transactionAffiliation"
            java.lang.String r12 = "&ta"
            r10.put(r0, r12)     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r0 = "transactionTax"
            java.lang.String r12 = "&tt"
            r10.put(r0, r12)     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r0 = "transactionShipping"
            java.lang.String r12 = "&ts"
            r10.put(r0, r12)     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r0 = "transactionTotal"
            java.lang.String r12 = "&tr"
            r10.put(r0, r12)     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r0 = "transactionCurrency"
            r10.put(r0, r7)     // Catch:{ IllegalArgumentException -> 0x0436 }
            zzamj = r10     // Catch:{ IllegalArgumentException -> 0x0436 }
        L_0x031d:
            java.util.Map<java.lang.String, java.lang.String> r0 = zzamj     // Catch:{ IllegalArgumentException -> 0x0436 }
        L_0x031f:
            java.util.Set r0 = r0.entrySet()     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ IllegalArgumentException -> 0x0436 }
        L_0x0327:
            boolean r10 = r0.hasNext()     // Catch:{ IllegalArgumentException -> 0x0436 }
            if (r10 == 0) goto L_0x0347
            java.lang.Object r10 = r0.next()     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.Object r12 = r10.getValue()     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.Object r10 = r10.getKey()     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r10 = r14.zzbr(r10)     // Catch:{ IllegalArgumentException -> 0x0436 }
            zzd(r9, r12, r10)     // Catch:{ IllegalArgumentException -> 0x0436 }
            goto L_0x0327
        L_0x0347:
            r8.add(r9)     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r0 = "transactionProducts"
            com.google.android.gms.tagmanager.DataLayer r9 = r14.zzaed     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.Object r0 = r9.get(r0)     // Catch:{ IllegalArgumentException -> 0x0436 }
            if (r0 != 0) goto L_0x0355
            goto L_0x037a
        L_0x0355:
            boolean r6 = r0 instanceof java.util.List     // Catch:{ IllegalArgumentException -> 0x0436 }
            if (r6 == 0) goto L_0x042e
            r6 = r0
            java.util.List r6 = (java.util.List) r6     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ IllegalArgumentException -> 0x0436 }
        L_0x0360:
            boolean r9 = r6.hasNext()     // Catch:{ IllegalArgumentException -> 0x0436 }
            if (r9 == 0) goto L_0x0377
            java.lang.Object r9 = r6.next()     // Catch:{ IllegalArgumentException -> 0x0436 }
            boolean r9 = r9 instanceof java.util.Map     // Catch:{ IllegalArgumentException -> 0x0436 }
            if (r9 == 0) goto L_0x036f
            goto L_0x0360
        L_0x036f:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r0 = "Each element of transactionProducts should be of type Map."
            r15.<init>(r0)     // Catch:{ IllegalArgumentException -> 0x0436 }
            throw r15     // Catch:{ IllegalArgumentException -> 0x0436 }
        L_0x0377:
            r6 = r0
            java.util.List r6 = (java.util.List) r6     // Catch:{ IllegalArgumentException -> 0x0436 }
        L_0x037a:
            if (r6 == 0) goto L_0x041b
            java.util.Iterator r0 = r6.iterator()     // Catch:{ IllegalArgumentException -> 0x0436 }
        L_0x0380:
            boolean r6 = r0.hasNext()     // Catch:{ IllegalArgumentException -> 0x0436 }
            if (r6 == 0) goto L_0x041b
            java.lang.Object r6 = r0.next()     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.util.Map r6 = (java.util.Map) r6     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.Object r9 = r6.get(r5)     // Catch:{ IllegalArgumentException -> 0x0436 }
            if (r9 != 0) goto L_0x0398
            java.lang.String r15 = "Unable to send transaction item hit due to missing 'name' field."
            com.google.android.gms.tagmanager.zzdi.zzav(r15)     // Catch:{ IllegalArgumentException -> 0x0436 }
            return
        L_0x0398:
            java.lang.String r9 = zzamc     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.Object r9 = r15.get(r9)     // Catch:{ IllegalArgumentException -> 0x0436 }
            com.google.android.gms.internal.gtm.zzl r9 = (com.google.android.gms.internal.gtm.zzl) r9     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.util.Map r9 = r14.zzj(r9)     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r10 = "item"
            r9.put(r1, r10)     // Catch:{ IllegalArgumentException -> 0x0436 }
            r9.put(r11, r3)     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r10 = zzamf     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.Object r10 = r15.get(r10)     // Catch:{ IllegalArgumentException -> 0x0436 }
            com.google.android.gms.internal.gtm.zzl r10 = (com.google.android.gms.internal.gtm.zzl) r10     // Catch:{ IllegalArgumentException -> 0x0436 }
            if (r10 == 0) goto L_0x03bb
            java.util.Map r10 = zzi(r10)     // Catch:{ IllegalArgumentException -> 0x0436 }
            goto L_0x03ee
        L_0x03bb:
            java.util.Map<java.lang.String, java.lang.String> r10 = zzamk     // Catch:{ IllegalArgumentException -> 0x0436 }
            if (r10 != 0) goto L_0x03ec
            java.util.HashMap r10 = new java.util.HashMap     // Catch:{ IllegalArgumentException -> 0x0436 }
            r10.<init>()     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r12 = "&in"
            r10.put(r5, r12)     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r12 = "sku"
            java.lang.String r13 = "&ic"
            r10.put(r12, r13)     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r12 = "category"
            java.lang.String r13 = "&iv"
            r10.put(r12, r13)     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r12 = "price"
            java.lang.String r13 = "&ip"
            r10.put(r12, r13)     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r12 = "quantity"
            java.lang.String r13 = "&iq"
            r10.put(r12, r13)     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r12 = "currency"
            r10.put(r12, r7)     // Catch:{ IllegalArgumentException -> 0x0436 }
            zzamk = r10     // Catch:{ IllegalArgumentException -> 0x0436 }
        L_0x03ec:
            java.util.Map<java.lang.String, java.lang.String> r10 = zzamk     // Catch:{ IllegalArgumentException -> 0x0436 }
        L_0x03ee:
            java.util.Set r10 = r10.entrySet()     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ IllegalArgumentException -> 0x0436 }
        L_0x03f6:
            boolean r12 = r10.hasNext()     // Catch:{ IllegalArgumentException -> 0x0436 }
            if (r12 == 0) goto L_0x0416
            java.lang.Object r12 = r10.next()     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.Object r13 = r12.getValue()     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r13 = (java.lang.String) r13     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.Object r12 = r12.getKey()     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.Object r12 = r6.get(r12)     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ IllegalArgumentException -> 0x0436 }
            zzd(r9, r13, r12)     // Catch:{ IllegalArgumentException -> 0x0436 }
            goto L_0x03f6
        L_0x0416:
            r8.add(r9)     // Catch:{ IllegalArgumentException -> 0x0436 }
            goto L_0x0380
        L_0x041b:
            int r15 = r8.size()     // Catch:{ IllegalArgumentException -> 0x0436 }
        L_0x041f:
            if (r4 >= r15) goto L_0x042d
            java.lang.Object r0 = r8.get(r4)     // Catch:{ IllegalArgumentException -> 0x0436 }
            int r4 = r4 + 1
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ IllegalArgumentException -> 0x0436 }
            r2.send(r0)     // Catch:{ IllegalArgumentException -> 0x0436 }
            goto L_0x041f
        L_0x042d:
            return
        L_0x042e:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException     // Catch:{ IllegalArgumentException -> 0x0436 }
            java.lang.String r0 = "transactionProducts should be of type List."
            r15.<init>(r0)     // Catch:{ IllegalArgumentException -> 0x0436 }
            throw r15     // Catch:{ IllegalArgumentException -> 0x0436 }
        L_0x0436:
            r15 = move-exception
            java.lang.String r0 = "Unable to send transaction"
            com.google.android.gms.tagmanager.zzdi.zza(r0, r15)
            return
        L_0x043d:
            java.lang.String r15 = "Ignoring unknown tag."
            com.google.android.gms.tagmanager.zzdi.zzac(r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzgk.zzd(java.util.Map):void");
    }

    public final /* bridge */ /* synthetic */ boolean zzgw() {
        return super.zzgw();
    }

    public final /* bridge */ /* synthetic */ String zzif() {
        return super.zzif();
    }

    public final /* bridge */ /* synthetic */ Set zzig() {
        return super.zzig();
    }
}
