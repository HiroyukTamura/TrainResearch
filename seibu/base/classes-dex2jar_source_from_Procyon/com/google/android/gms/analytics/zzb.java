// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.analytics;

import com.google.android.gms.internal.zzanx;
import com.google.android.gms.internal.zzamm;
import com.google.android.gms.internal.zzami;
import com.google.android.gms.internal.zzaos;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.Iterator;
import com.google.android.gms.internal.zzalk;
import com.google.android.gms.internal.zzalp;
import java.util.List;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.zzalq;
import com.google.android.gms.internal.zzaln;
import com.google.android.gms.internal.zzalm;
import com.google.android.gms.internal.zzalw;
import com.google.android.gms.internal.zzalv;
import com.google.android.gms.internal.zzals;
import com.google.android.gms.internal.zzall;
import com.google.android.gms.internal.zzalr;
import com.google.android.gms.internal.zzalu;
import com.google.android.gms.internal.zzalt;
import com.google.android.gms.internal.zzalo;
import java.util.HashMap;
import android.net.Uri$Builder;
import android.text.TextUtils;
import java.util.Map;
import com.google.android.gms.common.internal.zzbo;
import android.net.Uri;
import com.google.android.gms.internal.zzamj;
import java.text.DecimalFormat;
import com.google.android.gms.internal.zzamg;

public final class zzb extends zzamg implements zzo
{
    private static DecimalFormat zzadn;
    private final zzamj zzadj;
    private final String zzado;
    private final Uri zzadp;
    private final boolean zzadq;
    private final boolean zzadr;
    
    public zzb(final zzamj zzamj, final String s) {
        this(zzamj, s, true, false);
    }
    
    private zzb(final zzamj zzadj, final String zzado, final boolean b, final boolean b2) {
        super(zzadj);
        zzbo.zzcF(zzado);
        this.zzadj = zzadj;
        this.zzado = zzado;
        this.zzadq = true;
        this.zzadr = false;
        this.zzadp = zzaZ(this.zzado);
    }
    
    private static void zza(final Map<String, String> map, final String s, final double n) {
        if (n != 0.0) {
            map.put(s, zzb(n));
        }
    }
    
    private static void zza(final Map<String, String> map, final String s, final int i, final int j) {
        if (i > 0 && j > 0) {
            map.put(s, new StringBuilder(23).append(i).append("x").append(j).toString());
        }
    }
    
    private static void zza(final Map<String, String> map, final String s, final String s2) {
        if (!TextUtils.isEmpty((CharSequence)s2)) {
            map.put(s, s2);
        }
    }
    
    private static void zza(final Map<String, String> map, final String s, final boolean b) {
        if (b) {
            map.put(s, "1");
        }
    }
    
    static Uri zzaZ(final String s) {
        zzbo.zzcF(s);
        final Uri$Builder uri$Builder = new Uri$Builder();
        uri$Builder.scheme("uri");
        uri$Builder.authority("google-analytics.com");
        uri$Builder.path(s);
        return uri$Builder.build();
    }
    
    private static String zzb(final double number) {
        if (zzb.zzadn == null) {
            zzb.zzadn = new DecimalFormat("0.######");
        }
        return zzb.zzadn.format(number);
    }
    
    private static Map<String, String> zzc(final zzi zzi) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        final zzalo zzalo = zzi.zza(zzalo.class);
        if (zzalo != null) {
            for (final Map.Entry<String, Object> entry : zzalo.zzjR().entrySet()) {
                final Double value = entry.getValue();
                String s;
                if (value == null) {
                    s = null;
                }
                else if (value instanceof String) {
                    if (TextUtils.isEmpty((CharSequence)(s = (String)value))) {
                        s = null;
                    }
                }
                else if (value instanceof Double) {
                    final Double n = value;
                    if (n != 0.0) {
                        s = zzb(n);
                    }
                    else {
                        s = null;
                    }
                }
                else if (value instanceof Boolean) {
                    if (value != (Boolean.FALSE ? 1 : 0)) {
                        s = "1";
                    }
                    else {
                        s = null;
                    }
                }
                else {
                    s = String.valueOf(value);
                }
                if (s != null) {
                    hashMap.put(entry.getKey(), s);
                }
            }
        }
        final zzalt zzalt = zzi.zza(zzalt.class);
        if (zzalt != null) {
            zza(hashMap, "t", zzalt.zzjW());
            zza(hashMap, "cid", zzalt.zzjX());
            zza(hashMap, "uid", zzalt.getUserId());
            zza(hashMap, "sc", zzalt.zzka());
            zza(hashMap, "sf", zzalt.zzkc());
            zza(hashMap, "ni", zzalt.zzkb());
            zza(hashMap, "adid", zzalt.zzjY());
            zza(hashMap, "ate", zzalt.zzjZ());
        }
        final zzalu zzalu = zzi.zza(zzalu.class);
        if (zzalu != null) {
            zza(hashMap, "cd", zzalu.zzkd());
            zza(hashMap, "a", zzalu.zzke());
            zza(hashMap, "dr", zzalu.zzkf());
        }
        final zzalr zzalr = zzi.zza(zzalr.class);
        if (zzalr != null) {
            zza(hashMap, "ec", zzalr.getCategory());
            zza(hashMap, "ea", zzalr.getAction());
            zza(hashMap, "el", zzalr.getLabel());
            zza(hashMap, "ev", (double)zzalr.getValue());
        }
        final zzall zzall = zzi.zza(zzall.class);
        if (zzall != null) {
            zza(hashMap, "cn", zzall.getName());
            zza(hashMap, "cs", zzall.getSource());
            zza(hashMap, "cm", zzall.zzjJ());
            zza(hashMap, "ck", zzall.zzjK());
            zza(hashMap, "cc", zzall.getContent());
            zza(hashMap, "ci", zzall.getId());
            zza(hashMap, "anid", zzall.zzjL());
            zza(hashMap, "gclid", zzall.zzjM());
            zza(hashMap, "dclid", zzall.zzjN());
            zza(hashMap, "aclid", zzall.zzjO());
        }
        final zzals zzals = zzi.zza(zzals.class);
        if (zzals != null) {
            zza(hashMap, "exd", zzals.zzafa);
            zza(hashMap, "exf", zzals.zzafb);
        }
        final zzalv zzalv = zzi.zza(zzalv.class);
        if (zzalv != null) {
            zza(hashMap, "sn", zzalv.zzafq);
            zza(hashMap, "sa", zzalv.zzaeX);
            zza(hashMap, "st", zzalv.zzafr);
        }
        final zzalw zzalw = zzi.zza(zzalw.class);
        if (zzalw != null) {
            zza(hashMap, "utv", zzalw.zzafs);
            zza(hashMap, "utt", (double)zzalw.zzaft);
            zza(hashMap, "utc", zzalw.mCategory);
            zza(hashMap, "utl", zzalw.zzaeY);
        }
        final zzalm zzalm = zzi.zza(zzalm.class);
        if (zzalm != null) {
            for (final Map.Entry<Integer, String> entry2 : zzalm.zzjP().entrySet()) {
                final String zzD = zzf.zzD(entry2.getKey());
                if (!TextUtils.isEmpty((CharSequence)zzD)) {
                    hashMap.put(zzD, entry2.getValue());
                }
            }
        }
        final zzaln zzaln = zzi.zza(zzaln.class);
        if (zzaln != null) {
            for (final Map.Entry<Integer, Double> entry3 : zzaln.zzjQ().entrySet()) {
                final String zzF = zzf.zzF(entry3.getKey());
                if (!TextUtils.isEmpty((CharSequence)zzF)) {
                    hashMap.put(zzF, zzb(entry3.getValue()));
                }
            }
        }
        final zzalq zzalq = zzi.zza(zzalq.class);
        if (zzalq != null) {
            final ProductAction zzjS = zzalq.zzjS();
            if (zzjS != null) {
                for (final Map.Entry<String, String> entry4 : zzjS.build().entrySet()) {
                    if (entry4.getKey().startsWith("&")) {
                        hashMap.put(entry4.getKey().substring(1), entry4.getValue());
                    }
                    else {
                        hashMap.put(entry4.getKey(), entry4.getValue());
                    }
                }
            }
            final Iterator<Promotion> iterator5 = zzalq.zzjV().iterator();
            int n2 = 1;
            while (iterator5.hasNext()) {
                hashMap.putAll((Map<?, ?>)iterator5.next().zzbl(zzf.zzJ(n2)));
                ++n2;
            }
            final Iterator<Product> iterator6 = zzalq.zzjT().iterator();
            int n3 = 1;
            while (iterator6.hasNext()) {
                hashMap.putAll((Map<?, ?>)iterator6.next().zzbl(zzf.zzH(n3)));
                ++n3;
            }
            final Iterator<Map.Entry<String, List<Product>>> iterator7 = zzalq.zzjU().entrySet().iterator();
            int n4 = 1;
            while (iterator7.hasNext()) {
                final Map.Entry<String, List<Product>> entry5 = iterator7.next();
                final List<Product> list = entry5.getValue();
                final String zzM = zzf.zzM(n4);
                final Iterator<Product> iterator8 = list.iterator();
                int n5 = 1;
                while (iterator8.hasNext()) {
                    final Product product = iterator8.next();
                    final String value2 = String.valueOf(zzM);
                    final String value3 = String.valueOf(zzf.zzK(n5));
                    String concat;
                    if (value3.length() != 0) {
                        concat = value2.concat(value3);
                    }
                    else {
                        concat = new String(value2);
                    }
                    hashMap.putAll((Map<?, ?>)product.zzbl(concat));
                    ++n5;
                }
                if (!TextUtils.isEmpty((CharSequence)entry5.getKey())) {
                    final String value4 = String.valueOf(zzM);
                    final String value5 = String.valueOf("nm");
                    String concat2;
                    if (value5.length() != 0) {
                        concat2 = value4.concat(value5);
                    }
                    else {
                        concat2 = new String(value4);
                    }
                    hashMap.put(concat2, entry5.getKey());
                }
                ++n4;
            }
        }
        final zzalp zzalp = zzi.zza(zzalp.class);
        if (zzalp != null) {
            zza(hashMap, "ul", zzalp.getLanguage());
            zza(hashMap, "sd", zzalp.zzaeU);
            zza(hashMap, "sr", zzalp.zzNY, zzalp.zzNZ);
            zza(hashMap, "vp", zzalp.zzaeV, zzalp.zzaeW);
        }
        final zzalk zzalk = zzi.zza(zzalk.class);
        if (zzalk != null) {
            zza(hashMap, "an", zzalk.zzjG());
            zza(hashMap, "aid", zzalk.zzhl());
            zza(hashMap, "aiid", zzalk.zzjI());
            zza(hashMap, "av", zzalk.zzjH());
        }
        return hashMap;
    }
    
    @Override
    public final void zzb(final zzi zzi) {
        zzbo.zzu(zzi);
        zzbo.zzb(zzi.zzju(), (Object)"Can't deliver not submitted measurement");
        zzbo.zzcG("deliver should be called on worker thread");
        final zzi zzjp = zzi.zzjp();
        final zzalt zzalt = zzjp.zzb(zzalt.class);
        if (TextUtils.isEmpty((CharSequence)zzalt.zzjW())) {
            this.zzkr().zze(zzc(zzjp), "Ignoring measurement without type");
        }
        else {
            if (TextUtils.isEmpty((CharSequence)zzalt.zzjX())) {
                this.zzkr().zze(zzc(zzjp), "Ignoring measurement without client id");
                return;
            }
            if (!this.zzadj.zzkG().getAppOptOut()) {
                final double zzkc = zzalt.zzkc();
                if (zzaos.zza(zzkc, zzalt.zzjX())) {
                    this.zzb("Sampling enabled. Hit sampled out. sampling rate", zzkc);
                    return;
                }
                final Map<String, String> zzc = zzc(zzjp);
                zzc.put("v", "1");
                zzc.put("_v", zzami.zzafL);
                zzc.put("tid", this.zzado);
                if (this.zzadj.zzkG().isDryRunEnabled()) {
                    final StringBuilder sb = new StringBuilder();
                    for (final Map.Entry<String, String> entry : zzc.entrySet()) {
                        if (sb.length() != 0) {
                            sb.append(", ");
                        }
                        sb.append(entry.getKey());
                        sb.append("=");
                        sb.append(entry.getValue());
                    }
                    this.zzc("Dry run is enabled. GoogleAnalytics would have sent", sb.toString());
                    return;
                }
                final HashMap<String, String> hashMap = new HashMap<String, String>();
                zzaos.zzb(hashMap, "uid", zzalt.getUserId());
                final zzalk zzalk = zzi.zza(zzalk.class);
                if (zzalk != null) {
                    zzaos.zzb(hashMap, "an", zzalk.zzjG());
                    zzaos.zzb(hashMap, "aid", zzalk.zzhl());
                    zzaos.zzb(hashMap, "av", zzalk.zzjH());
                    zzaos.zzb(hashMap, "aiid", zzalk.zzjI());
                }
                zzc.put("_s", String.valueOf(this.zzkv().zza(new zzamm(0L, zzalt.zzjX(), this.zzado, !TextUtils.isEmpty((CharSequence)zzalt.zzjY()), 0L, hashMap))));
                this.zzkv().zza(new zzanx(this.zzkr(), zzc, zzi.zzjs(), true));
            }
        }
    }
    
    @Override
    public final Uri zzjl() {
        return this.zzadp;
    }
}
