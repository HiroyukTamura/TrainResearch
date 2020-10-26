// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class zzj
{
    private static Boolean zzaJJ;
    private static Boolean zzaJK;
    private static Boolean zzaJL;
    private static Boolean zzaJM;
    private static Boolean zzaJN;
    
    public static boolean zza(final Resources resources) {
        final boolean b = false;
        if (resources == null) {
            return false;
        }
        if (zzj.zzaJJ == null) {
            int n;
            if ((resources.getConfiguration().screenLayout & 0xF) > 3) {
                n = 1;
            }
            else {
                n = 0;
            }
            boolean b2 = false;
            Label_0088: {
                if (n == 0) {
                    if (zzj.zzaJK == null) {
                        final Configuration configuration = resources.getConfiguration();
                        zzj.zzaJK = ((configuration.screenLayout & 0xF) <= 3 && configuration.smallestScreenWidthDp >= 600);
                    }
                    b2 = b;
                    if (!zzj.zzaJK) {
                        break Label_0088;
                    }
                }
                b2 = true;
            }
            zzj.zzaJJ = b2;
        }
        return zzj.zzaJJ;
    }
    
    @TargetApi(20)
    public static boolean zzaG(final Context context) {
        if (zzj.zzaJL == null) {
            zzj.zzaJL = (zzq.zzsd() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return zzj.zzaJL;
    }
    
    @TargetApi(24)
    public static boolean zzaH(final Context context) {
        return (!zzq.isAtLeastN() || zzaI(context)) && zzaG(context);
    }
    
    @TargetApi(21)
    public static boolean zzaI(final Context context) {
        if (zzj.zzaJM == null) {
            zzj.zzaJM = (zzq.zzse() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return zzj.zzaJM;
    }
    
    public static boolean zzaJ(final Context context) {
        if (zzj.zzaJN == null) {
            zzj.zzaJN = (context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return zzj.zzaJN;
    }
}
