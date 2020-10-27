package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p009e.p010a.p011a.p012a.C0681a;

@VisibleForTesting
public final class zzgj {
    private static final Object zzalo = null;
    private static Long zzalp = new Long(0);
    private static Double zzalq = new Double(0.0d);
    private static zzgi zzalr = zzgi.zzm(0);
    private static String zzals = new String("");
    private static Boolean zzalt = new Boolean(false);
    private static List<Object> zzalu = new ArrayList(0);
    private static Map<Object, Object> zzalv = new HashMap();
    private static zzl zzalw = zzi(zzals);

    private static double getDouble(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).doubleValue();
        }
        zzdi.zzav("getDouble received non-Number");
        return 0.0d;
    }

    public static zzl zzbp(String str) {
        zzl zzl = new zzl();
        zzl.type = 5;
        zzl.zzqr = str;
        return zzl;
    }

    private static zzgi zzbq(String str) {
        try {
            return zzgi.zzbo(str);
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder(C0681a.m336b(str, 33));
            sb.append("Failed to convert '");
            sb.append(str);
            sb.append("' to a number.");
            zzdi.zzav(sb.toString());
            return zzalr;
        }
    }

    public static String zzc(zzl zzl) {
        return zzh(zzh(zzl));
    }

    public static zzgi zzd(zzl zzl) {
        Object zzh = zzh(zzl);
        return zzh instanceof zzgi ? (zzgi) zzh : zzk(zzh) ? zzgi.zzm(zzl(zzh)) : zzj(zzh) ? zzgi.zza(Double.valueOf(getDouble(zzh))) : zzbq(zzh(zzh));
    }

    public static Long zze(zzl zzl) {
        long longValue;
        Object zzh = zzh(zzl);
        if (zzk(zzh)) {
            longValue = zzl(zzh);
        } else {
            zzgi zzbq = zzbq(zzh(zzh));
            if (zzbq == zzalr) {
                return zzalp;
            }
            longValue = zzbq.longValue();
        }
        return Long.valueOf(longValue);
    }

    public static Double zzf(zzl zzl) {
        double doubleValue;
        Object zzh = zzh(zzl);
        if (zzj(zzh)) {
            doubleValue = getDouble(zzh);
        } else {
            zzgi zzbq = zzbq(zzh(zzh));
            if (zzbq == zzalr) {
                return zzalq;
            }
            doubleValue = zzbq.doubleValue();
        }
        return Double.valueOf(doubleValue);
    }

    public static Boolean zzg(zzl zzl) {
        Object zzh = zzh(zzl);
        if (zzh instanceof Boolean) {
            return (Boolean) zzh;
        }
        String zzh2 = zzh(zzh);
        return "true".equalsIgnoreCase(zzh2) ? Boolean.TRUE : "false".equalsIgnoreCase(zzh2) ? Boolean.FALSE : zzalt;
    }

    public static Object zzh(zzl zzl) {
        String str;
        if (zzl == null) {
            return null;
        }
        int i = zzl.type;
        int i2 = 0;
        switch (i) {
            case 1:
                return zzl.string;
            case 2:
                ArrayList arrayList = new ArrayList(zzl.zzqn.length);
                zzl[] zzlArr = zzl.zzqn;
                int length = zzlArr.length;
                while (i2 < length) {
                    Object zzh = zzh(zzlArr[i2]);
                    if (zzh == null) {
                        return null;
                    }
                    arrayList.add(zzh);
                    i2++;
                }
                return arrayList;
            case 3:
                if (zzl.zzqo.length != zzl.zzqp.length) {
                    String valueOf = String.valueOf(zzl.toString());
                    zzdi.zzav(valueOf.length() != 0 ? "Converting an invalid value to object: ".concat(valueOf) : new String("Converting an invalid value to object: "));
                    return null;
                }
                HashMap hashMap = new HashMap(zzl.zzqp.length);
                while (true) {
                    zzl[] zzlArr2 = zzl.zzqo;
                    if (i2 >= zzlArr2.length) {
                        return hashMap;
                    }
                    Object zzh2 = zzh(zzlArr2[i2]);
                    Object zzh3 = zzh(zzl.zzqp[i2]);
                    if (zzh2 == null || zzh3 == null) {
                        return null;
                    }
                    hashMap.put(zzh2, zzh3);
                    i2++;
                }
                return null;
            case 4:
                str = "Trying to convert a macro reference to object";
                break;
            case 5:
                str = "Trying to convert a function id to object";
                break;
            case 6:
                return Long.valueOf(zzl.zzqs);
            case 7:
                StringBuilder sb = new StringBuilder();
                zzl[] zzlArr3 = zzl.zzqu;
                int length2 = zzlArr3.length;
                while (i2 < length2) {
                    String zzh4 = zzh(zzh(zzlArr3[i2]));
                    if (zzh4 == zzals) {
                        return null;
                    }
                    sb.append(zzh4);
                    i2++;
                }
                return sb.toString();
            case 8:
                return Boolean.valueOf(zzl.zzqt);
            default:
                StringBuilder sb2 = new StringBuilder(46);
                sb2.append("Failed to convert a value of type: ");
                sb2.append(i);
                str = sb2.toString();
                break;
        }
        zzdi.zzav(str);
        return null;
    }

    private static String zzh(Object obj) {
        return obj == null ? zzals : obj.toString();
    }

    public static zzl zzi(Object obj) {
        String obj2;
        zzl zzl = new zzl();
        if (obj instanceof zzl) {
            return (zzl) obj;
        }
        boolean z = false;
        if (obj instanceof String) {
            zzl.type = 1;
            obj2 = (String) obj;
        } else {
            if (obj instanceof List) {
                zzl.type = 2;
                List<Object> list = (List) obj;
                ArrayList arrayList = new ArrayList(list.size());
                boolean z2 = false;
                for (Object zzi : list) {
                    zzl zzi2 = zzi(zzi);
                    zzl zzl2 = zzalw;
                    if (zzi2 == zzl2) {
                        return zzl2;
                    }
                    z2 = z2 || zzi2.zzqw;
                    arrayList.add(zzi2);
                }
                zzl.zzqn = (zzl[]) arrayList.toArray(new zzl[0]);
                z = z2;
            } else if (obj instanceof Map) {
                zzl.type = 3;
                Set<Map.Entry> entrySet = ((Map) obj).entrySet();
                ArrayList arrayList2 = new ArrayList(entrySet.size());
                ArrayList arrayList3 = new ArrayList(entrySet.size());
                boolean z3 = false;
                for (Map.Entry entry : entrySet) {
                    zzl zzi3 = zzi(entry.getKey());
                    zzl zzi4 = zzi(entry.getValue());
                    zzl zzl3 = zzalw;
                    if (zzi3 == zzl3 || zzi4 == zzl3) {
                        return zzalw;
                    }
                    z3 = z3 || zzi3.zzqw || zzi4.zzqw;
                    arrayList2.add(zzi3);
                    arrayList3.add(zzi4);
                }
                zzl.zzqo = (zzl[]) arrayList2.toArray(new zzl[0]);
                zzl.zzqp = (zzl[]) arrayList3.toArray(new zzl[0]);
                z = z3;
            } else if (zzj(obj)) {
                zzl.type = 1;
                obj2 = obj.toString();
            } else if (zzk(obj)) {
                zzl.type = 6;
                zzl.zzqs = zzl(obj);
            } else if (obj instanceof Boolean) {
                zzl.type = 8;
                zzl.zzqt = ((Boolean) obj).booleanValue();
            } else {
                String valueOf = String.valueOf(obj == null ? "null" : obj.getClass().toString());
                zzdi.zzav(valueOf.length() != 0 ? "Converting to Value from unknown object type: ".concat(valueOf) : new String("Converting to Value from unknown object type: "));
                return zzalw;
            }
            zzl.zzqw = z;
            return zzl;
        }
        zzl.string = obj2;
        zzl.zzqw = z;
        return zzl;
    }

    private static boolean zzj(Object obj) {
        if ((obj instanceof Double) || (obj instanceof Float)) {
            return true;
        }
        return (obj instanceof zzgi) && ((zzgi) obj).zzju();
    }

    public static Object zzjw() {
        return null;
    }

    public static Long zzjx() {
        return zzalp;
    }

    public static Double zzjy() {
        return zzalq;
    }

    public static Boolean zzjz() {
        return zzalt;
    }

    private static boolean zzk(Object obj) {
        if ((obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long)) {
            return true;
        }
        return (obj instanceof zzgi) && ((zzgi) obj).zzjv();
    }

    public static zzgi zzka() {
        return zzalr;
    }

    public static String zzkb() {
        return zzals;
    }

    public static zzl zzkc() {
        return zzalw;
    }

    private static long zzl(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        zzdi.zzav("getInt64 received non-Number");
        return 0;
    }
}
