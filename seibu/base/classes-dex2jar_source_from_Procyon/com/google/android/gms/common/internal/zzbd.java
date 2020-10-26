// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.content.pm.ApplicationInfo;
import com.google.android.gms.internal.zzbgz;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import com.google.android.gms.internal.zzbha;
import android.content.Context;

public final class zzbd
{
    private static boolean zzRk;
    private static String zzaIf;
    private static int zzaIg;
    private static Object zzuF;
    
    static {
        zzbd.zzuF = new Object();
    }
    
    public static String zzaD(final Context context) {
        zzaF(context);
        return zzbd.zzaIf;
    }
    
    public static int zzaE(final Context context) {
        zzaF(context);
        return zzbd.zzaIg;
    }
    
    private static void zzaF(final Context context) {
        final Object zzuF = zzbd.zzuF;
        // monitorenter(zzuF)
        Label_0053: {
            String packageName;
            zzbgz zzbgz;
            Bundle bundle;
            try {
                if (zzbd.zzRk) {
                    return;
                }
                zzbd.zzRk = true;
                packageName = context.getPackageName();
                final zzbgz zzaP;
                zzbgz = (zzaP = zzbha.zzaP(context));
                final String s = packageName;
                final int n = 128;
                final ApplicationInfo applicationInfo = zzaP.getApplicationInfo(s, n);
                final Bundle metaData = applicationInfo.metaData;
                final Bundle metaData2 = metaData;
                if (metaData2 == null) {
                    return;
                }
                break Label_0053;
            }
            finally {
                final Throwable t;
                bundle = (Bundle)t;
            }
            // monitorexit(zzuF)
            while (true) {
                try {
                    final zzbgz zzaP = zzbgz;
                    final String s = packageName;
                    final int n = 128;
                    final ApplicationInfo applicationInfo = zzaP.getApplicationInfo(s, n);
                    final Bundle metaData2;
                    final Bundle metaData = metaData2 = applicationInfo.metaData;
                    if (metaData2 == null) {
                        return;
                    }
                    zzbd.zzaIf = bundle.getString("com.google.app.id");
                    zzbd.zzaIg = bundle.getInt("com.google.android.gms.version");
                }
                // monitorexit(zzuF)
                catch (PackageManager$NameNotFoundException ex) {
                    Log.wtf("MetadataValueReader", "This should never happen.", (Throwable)ex);
                    continue;
                }
                break;
            }
        }
    }
}
