// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.Set;
import java.util.Iterator;
import java.util.HashMap;
import java.util.ArrayList;
import com.google.android.gms.internal.zzbr;
import java.util.Map;
import java.util.List;

public final class zzgk
{
    private static final Object zzbHe;
    private static Long zzbHf;
    private static Double zzbHg;
    private static zzgj zzbHh;
    private static String zzbHi;
    private static Boolean zzbHj;
    private static List<Object> zzbHk;
    private static Map<Object, Object> zzbHl;
    private static zzbr zzbHm;
    
    static {
        zzbHe = null;
        zzgk.zzbHf = new Long(0L);
        zzgk.zzbHg = new Double(0.0);
        zzgk.zzbHh = zzgj.zzai(0L);
        zzgk.zzbHi = new String("");
        zzgk.zzbHj = new Boolean(false);
        zzgk.zzbHk = new ArrayList<Object>(0);
        zzgk.zzbHl = new HashMap<Object, Object>();
        zzgk.zzbHm = zzI(zzgk.zzbHi);
    }
    
    private static double getDouble(final Object o) {
        if (o instanceof Number) {
            return ((Number)o).doubleValue();
        }
        zzdj.e("getDouble received non-Number");
        return 0.0;
    }
    
    public static Object zzCb() {
        return null;
    }
    
    public static Long zzCc() {
        return zzgk.zzbHf;
    }
    
    public static Double zzCd() {
        return zzgk.zzbHg;
    }
    
    public static Boolean zzCe() {
        return zzgk.zzbHj;
    }
    
    public static zzgj zzCf() {
        return zzgk.zzbHh;
    }
    
    public static String zzCg() {
        return zzgk.zzbHi;
    }
    
    public static zzbr zzCh() {
        return zzgk.zzbHm;
    }
    
    private static String zzH(final Object o) {
        if (o == null) {
            return zzgk.zzbHi;
        }
        return o.toString();
    }
    
    public static zzbr zzI(final Object o) {
        boolean zzlN = false;
        final zzbr zzbr = new zzbr();
        if (o instanceof zzbr) {
            return (zzbr)o;
        }
        if (o instanceof String) {
            zzbr.type = 1;
            zzbr.string = (String)o;
        }
        else if (o instanceof List) {
            zzbr.type = 2;
            final List list = (List)o;
            final ArrayList list2 = new ArrayList<zzbr>(list.size());
            final Iterator<Object> iterator = list.iterator();
            zzlN = false;
            while (iterator.hasNext()) {
                final zzbr zzI = zzI(iterator.next());
                if (zzI == zzgk.zzbHm) {
                    return zzgk.zzbHm;
                }
                zzlN = (zzlN || zzI.zzlN);
                list2.add(zzI);
            }
            zzbr.zzlE = list2.toArray(new zzbr[0]);
        }
        else if (o instanceof Map) {
            zzbr.type = 3;
            final Set entrySet = ((Map)o).entrySet();
            final ArrayList list3 = new ArrayList<zzbr>(entrySet.size());
            final ArrayList list4 = new ArrayList<zzbr>(entrySet.size());
            final Iterator<Map.Entry<Object, V>> iterator2 = entrySet.iterator();
            zzlN = false;
            while (iterator2.hasNext()) {
                final Map.Entry<Object, V> entry = iterator2.next();
                final zzbr zzI2 = zzI(entry.getKey());
                final zzbr zzI3 = zzI(entry.getValue());
                if (zzI2 == zzgk.zzbHm || zzI3 == zzgk.zzbHm) {
                    return zzgk.zzbHm;
                }
                zzlN = (zzlN || zzI2.zzlN || zzI3.zzlN);
                list3.add(zzI2);
                list4.add(zzI3);
            }
            zzbr.zzlF = list3.toArray(new zzbr[0]);
            zzbr.zzlG = list4.toArray(new zzbr[0]);
        }
        else if (zzJ(o)) {
            zzbr.type = 1;
            zzbr.string = o.toString();
        }
        else if (zzK(o)) {
            zzbr.type = 6;
            zzbr.zzlJ = zzL(o);
        }
        else {
            if (!(o instanceof Boolean)) {
                String string;
                if (o == null) {
                    string = "null";
                }
                else {
                    string = o.getClass().toString();
                }
                final String value = String.valueOf(string);
                String concat;
                if (value.length() != 0) {
                    concat = "Converting to Value from unknown object type: ".concat(value);
                }
                else {
                    concat = new String("Converting to Value from unknown object type: ");
                }
                zzdj.e(concat);
                return zzgk.zzbHm;
            }
            zzbr.type = 8;
            zzbr.zzlK = (boolean)o;
        }
        zzbr.zzlN = zzlN;
        return zzbr;
    }
    
    private static boolean zzJ(final Object o) {
        return o instanceof Double || o instanceof Float || (o instanceof zzgj && ((zzgj)o).zzBZ());
    }
    
    private static boolean zzK(final Object o) {
        return o instanceof Byte || o instanceof Short || o instanceof Integer || o instanceof Long || (o instanceof zzgj && ((zzgj)o).zzCa());
    }
    
    private static long zzL(final Object o) {
        if (o instanceof Number) {
            return ((Number)o).longValue();
        }
        zzdj.e("getInt64 received non-Number");
        return 0L;
    }
    
    public static String zzb(final zzbr zzbr) {
        return zzH(zzg(zzbr));
    }
    
    public static zzgj zzc(final zzbr zzbr) {
        final Object zzg = zzg(zzbr);
        if (zzg instanceof zzgj) {
            return (zzgj)zzg;
        }
        if (zzK(zzg)) {
            return zzgj.zzai(zzL(zzg));
        }
        if (zzJ(zzg)) {
            return zzgj.zza(getDouble(zzg));
        }
        return zzfz(zzH(zzg));
    }
    
    public static Long zzd(final zzbr zzbr) {
        final Object zzg = zzg(zzbr);
        if (zzK(zzg)) {
            return zzL(zzg);
        }
        final zzgj zzfz = zzfz(zzH(zzg));
        if (zzfz == zzgk.zzbHh) {
            return zzgk.zzbHf;
        }
        return zzfz.longValue();
    }
    
    public static Double zze(final zzbr zzbr) {
        final Object zzg = zzg(zzbr);
        if (zzJ(zzg)) {
            return getDouble(zzg);
        }
        final zzgj zzfz = zzfz(zzH(zzg));
        if (zzfz == zzgk.zzbHh) {
            return zzgk.zzbHg;
        }
        return zzfz.doubleValue();
    }
    
    public static Boolean zzf(final zzbr zzbr) {
        final Object zzg = zzg(zzbr);
        if (zzg instanceof Boolean) {
            return (Boolean)zzg;
        }
        final String zzH = zzH(zzg);
        if ("true".equalsIgnoreCase(zzH)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(zzH)) {
            return Boolean.FALSE;
        }
        return zzgk.zzbHj;
    }
    
    public static zzbr zzfy(final String zzlI) {
        final zzbr zzbr = new zzbr();
        zzbr.type = 5;
        zzbr.zzlI = zzlI;
        return zzbr;
    }
    
    private static zzgj zzfz(final String s) {
        try {
            return zzgj.zzfx(s);
        }
        catch (NumberFormatException ex) {
            zzdj.e(new StringBuilder(String.valueOf(s).length() + 33).append("Failed to convert '").append(s).append("' to a number.").toString());
            return zzgk.zzbHh;
        }
    }
    
    public static Object zzg(final zzbr zzbr) {
        final int n = 0;
        final int n2 = 0;
        int i = 0;
        if (zzbr == null) {
            return null;
        }
        switch (zzbr.type) {
            default: {
                zzdj.e(new StringBuilder(46).append("Failed to convert a value of type: ").append(zzbr.type).toString());
                return null;
            }
            case 1: {
                return zzbr.string;
            }
            case 2: {
                final ArrayList<Object> list = new ArrayList<Object>(zzbr.zzlE.length);
                for (zzbr[] zzlE = zzbr.zzlE; i < zzlE.length; ++i) {
                    final Object zzg = zzg(zzlE[i]);
                    if (zzg == null) {
                        return null;
                    }
                    list.add(zzg);
                }
                return list;
            }
            case 3: {
                if (zzbr.zzlF.length != zzbr.zzlG.length) {
                    final String value = String.valueOf(zzbr.toString());
                    String concat;
                    if (value.length() != 0) {
                        concat = "Converting an invalid value to object: ".concat(value);
                    }
                    else {
                        concat = new String("Converting an invalid value to object: ");
                    }
                    zzdj.e(concat);
                    return null;
                }
                final HashMap<Object, Object> hashMap = new HashMap<Object, Object>(zzbr.zzlG.length);
                for (int j = n; j < zzbr.zzlF.length; ++j) {
                    final Object zzg2 = zzg(zzbr.zzlF[j]);
                    final Object zzg3 = zzg(zzbr.zzlG[j]);
                    if (zzg2 == null || zzg3 == null) {
                        return null;
                    }
                    hashMap.put(zzg2, zzg3);
                }
                return hashMap;
            }
            case 4: {
                zzdj.e("Trying to convert a macro reference to object");
                return null;
            }
            case 5: {
                zzdj.e("Trying to convert a function id to object");
                return null;
            }
            case 6: {
                return zzbr.zzlJ;
            }
            case 7: {
                final StringBuffer sb = new StringBuffer();
                final zzbr[] zzlL = zzbr.zzlL;
                for (int length = zzlL.length, k = n2; k < length; ++k) {
                    final String zzb = zzb(zzlL[k]);
                    if (zzb == zzgk.zzbHi) {
                        return null;
                    }
                    sb.append(zzb);
                }
                return sb.toString();
            }
            case 8: {
                return zzbr.zzlK;
            }
        }
    }
}
