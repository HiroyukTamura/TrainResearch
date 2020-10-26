// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.net.Uri;
import android.content.SharedPreferences;
import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class zzcx
{
    private static String zzbEX;
    static Map<String, String> zzbEY;
    
    static {
        zzcx.zzbEY = new HashMap<String, String>();
    }
    
    static void zzK(final Context context, final String s) {
        zzfu.zzd(context, "gtm_install_referrer", "referrer", s);
        zzM(context, s);
    }
    
    public static String zzL(final Context context, final String s) {
        Label_0043: {
            if (zzcx.zzbEX != null) {
                break Label_0043;
            }
            synchronized (zzcx.class) {
                if (zzcx.zzbEX == null) {
                    final SharedPreferences sharedPreferences = context.getSharedPreferences("gtm_install_referrer", 0);
                    if (sharedPreferences != null) {
                        zzcx.zzbEX = sharedPreferences.getString("referrer", "");
                    }
                    else {
                        zzcx.zzbEX = "";
                    }
                }
                // monitorexit(zzcx.class)
                return zzV(zzcx.zzbEX, s);
            }
        }
    }
    
    public static void zzM(final Context context, final String s) {
        final String zzV = zzV(s, "conv");
        if (zzV != null && zzV.length() > 0) {
            zzcx.zzbEY.put(zzV, s);
            zzfu.zzd(context, "gtm_click_referrers", zzV, s);
        }
    }
    
    public static String zzV(String s, final String s2) {
        if (s2 != null) {
            s = String.valueOf(s);
            if (s.length() != 0) {
                s = "http://hostname/?".concat(s);
            }
            else {
                s = new String("http://hostname/?");
            }
            return Uri.parse(s).getQueryParameter(s2);
        }
        if (s.length() > 0) {
            return s;
        }
        return null;
    }
    
    public static void zzfn(final String zzbEX) {
        synchronized (zzcx.class) {
            zzcx.zzbEX = zzbEX;
        }
    }
}
