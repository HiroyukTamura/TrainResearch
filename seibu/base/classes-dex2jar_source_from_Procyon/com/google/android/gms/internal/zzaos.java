// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.pm.ServiceInfo;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import java.util.Locale;
import java.util.Map;
import java.net.URISyntaxException;
import com.google.android.gms.common.util.zzm;
import java.net.URI;
import java.util.HashMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzbo;

public final class zzaos
{
    private static final char[] zzaiO;
    
    static {
        zzaiO = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    }
    
    public static String zzI(final boolean b) {
        if (b) {
            return "1";
        }
        return "0";
    }
    
    public static double zza(final String s, double double1) {
        if (s == null) {
            return 100.0;
        }
        try {
            double1 = Double.parseDouble(s);
            return double1;
        }
        catch (NumberFormatException ex) {
            return 100.0;
        }
    }
    
    public static zzall zza(zzaoc zzaoc, String str) {
        zzbo.zzu(zzaoc);
        if (TextUtils.isEmpty((CharSequence)str)) {
            return null;
        }
        new HashMap();
        try {
            str = String.valueOf(str);
            if (str.length() != 0) {
                str = "?".concat(str);
            }
            else {
                str = new String("?");
            }
            final Map<String, String> zza = zzm.zza(new URI(str), "UTF-8");
            zzaoc = (zzaoc)new zzall();
            ((zzall)zzaoc).zzbd(zza.get("utm_content"));
            ((zzall)zzaoc).zzbb(zza.get("utm_medium"));
            ((zzall)zzaoc).setName(zza.get("utm_campaign"));
            ((zzall)zzaoc).zzba(zza.get("utm_source"));
            ((zzall)zzaoc).zzbc(zza.get("utm_term"));
            ((zzall)zzaoc).zzbe(zza.get("utm_id"));
            ((zzall)zzaoc).zzbf(zza.get("anid"));
            ((zzall)zzaoc).zzbg(zza.get("gclid"));
            ((zzall)zzaoc).zzbh(zza.get("dclid"));
            ((zzall)zzaoc).zzbi(zza.get("aclid"));
            return (zzall)zzaoc;
        }
        catch (URISyntaxException ex) {
            zzaoc.zzd("No valid campaign data found", ex);
            return null;
        }
    }
    
    public static String zza(final Locale locale) {
        if (locale != null) {
            final String language = locale.getLanguage();
            if (!TextUtils.isEmpty((CharSequence)language)) {
                final StringBuilder sb = new StringBuilder();
                sb.append(language.toLowerCase());
                if (!TextUtils.isEmpty((CharSequence)locale.getCountry())) {
                    sb.append("-").append(locale.getCountry().toLowerCase());
                }
                return sb.toString();
            }
        }
        return null;
    }
    
    public static void zza(final Map<String, String> map, final String s, final Map<String, String> map2) {
        zzb(map, s, map2.get(s));
    }
    
    public static boolean zza(final double n, final String s) {
        boolean b = true;
        if (n <= 0.0 || n >= 100.0) {
            b = false;
        }
        else {
            int n3;
            if (!TextUtils.isEmpty((CharSequence)s)) {
                int index = s.length() - 1;
                int n2 = 0;
                while (true) {
                    n3 = n2;
                    if (index < 0) {
                        break;
                    }
                    final char char1 = s.charAt(index);
                    final int n4 = (n2 << 6 & 0xFFFFFFF) + char1 + (char1 << 14);
                    final int n5 = 0xFE00000 & n4;
                    n2 = n4;
                    if (n5 != 0) {
                        n2 = (n4 ^ n5 >> 21);
                    }
                    --index;
                }
            }
            else {
                n3 = 1;
            }
            if (n3 % 10000 < 100.0 * n) {
                return false;
            }
        }
        return b;
    }
    
    public static boolean zza(final Context context, final String s, final boolean b) {
        try {
            final ActivityInfo receiverInfo = context.getPackageManager().getReceiverInfo(new ComponentName(context, s), 2);
            if (receiverInfo != null && receiverInfo.enabled && (!b || receiverInfo.exported)) {
                return true;
            }
        }
        catch (PackageManager$NameNotFoundException ex) {}
        return false;
    }
    
    public static void zzb(final Map<String, String> map, final String s, final String s2) {
        if (s2 != null && !map.containsKey(s)) {
            map.put(s, s2);
        }
    }
    
    public static void zzb(final Map<String, String> map, final String s, final boolean b) {
        if (!map.containsKey(s)) {
            String s2;
            if (b) {
                s2 = "1";
            }
            else {
                s2 = "0";
            }
            map.put(s, s2);
        }
    }
    
    public static Map<String, String> zzbB(String s) {
        final HashMap<String, String> hashMap = new HashMap<String, String>();
        final String[] split = s.split("&");
        for (int length = split.length, i = 0; i < length; ++i) {
            final String[] split2 = split[i].split("=", 3);
            if (split2.length > 1) {
                final String s2 = split2[0];
                if (TextUtils.isEmpty((CharSequence)split2[1])) {
                    s = null;
                }
                else {
                    s = split2[1];
                }
                hashMap.put(s2, s);
                if (split2.length == 3 && !TextUtils.isEmpty((CharSequence)split2[1]) && !hashMap.containsKey(split2[1])) {
                    final String s3 = split2[1];
                    if (TextUtils.isEmpty((CharSequence)split2[2])) {
                        s = null;
                    }
                    else {
                        s = split2[2];
                    }
                    hashMap.put(s3, s);
                }
            }
            else if (split2.length == 1 && split2[0].length() != 0) {
                hashMap.put(split2[0], null);
            }
        }
        return hashMap;
    }
    
    public static long zzbC(final String s) {
        if (s == null) {
            return 0L;
        }
        try {
            return Long.parseLong(s);
        }
        catch (NumberFormatException ex) {
            return 0L;
        }
    }
    
    public static String zzbD(String decode) {
        int i = 0;
        if (TextUtils.isEmpty((CharSequence)decode)) {
            return null;
        }
        String s = decode;
        if (decode.contains("?")) {
            final String[] split = decode.split("[\\?]");
            s = decode;
            if (split.length > 1) {
                s = split[1];
            }
        }
        Label_0212: {
            if (!s.contains("%3D")) {
                break Label_0212;
            }
            try {
                decode = URLDecoder.decode(s, "UTF-8");
                final Map<String, String> zzbB;
                Label_0059: {
                    zzbB = zzbB(decode);
                }
                final String[] array = { "dclid", "utm_source", "gclid", "aclid", "utm_campaign", "utm_medium", "utm_term", "utm_content", "utm_id", "anid", "gmob_t" };
                final StringBuilder sb = new StringBuilder();
                while (i < 11) {
                    if (!TextUtils.isEmpty((CharSequence)zzbB.get(array[i]))) {
                        if (sb.length() > 0) {
                            sb.append("&");
                        }
                        sb.append(array[i]).append("=").append(zzbB.get(array[i]));
                    }
                    ++i;
                }
                return sb.toString();
                decode = s;
                // iftrue(Label_0059:, s.contains((CharSequence)"="))
                return null;
            }
            catch (UnsupportedEncodingException ex) {
                return null;
            }
        }
    }
    
    public static MessageDigest zzbE(final String algorithm) {
        for (int i = 0; i < 2; ++i) {
            try {
                final MessageDigest instance = MessageDigest.getInstance(algorithm);
                if (instance != null) {
                    return instance;
                }
            }
            catch (NoSuchAlgorithmException ex) {}
        }
        return null;
    }
    
    public static boolean zzbF(final String s) {
        return TextUtils.isEmpty((CharSequence)s) || !s.startsWith("http:");
    }
    
    public static void zzc(final Map<String, String> map, final String s, final String s2) {
        if (s2 != null && TextUtils.isEmpty((CharSequence)map.get(s))) {
            map.put(s, s2);
        }
    }
    
    public static boolean zzf(final String s, final boolean b) {
        return s == null || s.equalsIgnoreCase("true") || s.equalsIgnoreCase("yes") || s.equalsIgnoreCase("1") || (!s.equalsIgnoreCase("false") && !s.equalsIgnoreCase("no") && !s.equalsIgnoreCase("0"));
    }
    
    public static boolean zzw(final Context context, final String s) {
        try {
            final ServiceInfo serviceInfo = context.getPackageManager().getServiceInfo(new ComponentName(context, s), 4);
            if (serviceInfo != null && serviceInfo.enabled) {
                return true;
            }
        }
        catch (PackageManager$NameNotFoundException ex) {}
        return false;
    }
}
