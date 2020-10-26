// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.support.annotation.Nullable;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager$NameNotFoundException;
import android.util.Log;
import com.google.android.gms.internal.zzbha;
import android.os.WorkSource;
import android.content.Context;
import java.lang.reflect.Method;

public final class zzx
{
    private static final Method zzaJZ;
    private static final Method zzaKa;
    private static final Method zzaKb;
    private static final Method zzaKc;
    private static final Method zzaKd;
    
    static {
        zzaJZ = zzsg();
        zzaKa = zzsh();
        zzaKb = zzsi();
        zzaKc = zzsj();
        zzaKd = zzsk();
    }
    
    @Nullable
    public static WorkSource zzD(final Context context, final String s) {
        if (context == null || context.getPackageManager() == null) {
            return null;
        }
        ApplicationInfo applicationInfo;
        while (true) {
            while (true) {
                try {
                    applicationInfo = zzbha.zzaP(context).getApplicationInfo(s, 0);
                    if (applicationInfo != null) {
                        break;
                    }
                    final String value = String.valueOf(s);
                    if (value.length() != 0) {
                        final String concat = "Could not get applicationInfo from package: ".concat(value);
                        Log.e("WorkSourceUtil", concat);
                        return null;
                    }
                }
                catch (PackageManager$NameNotFoundException ex) {
                    final String value2 = String.valueOf(s);
                    String concat2;
                    if (value2.length() != 0) {
                        concat2 = "Could not find package: ".concat(value2);
                    }
                    else {
                        concat2 = new String("Could not find package: ");
                    }
                    Log.e("WorkSourceUtil", concat2);
                    return null;
                }
                final String concat = new String("Could not get applicationInfo from package: ");
                continue;
            }
        }
        return zze(applicationInfo.uid, s);
    }
    
    private static int zza(final WorkSource obj) {
        if (zzx.zzaKb != null) {
            try {
                return (int)zzx.zzaKb.invoke(obj, new Object[0]);
            }
            catch (Exception ex) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", (Throwable)ex);
            }
        }
        return 0;
    }
    
    @Nullable
    private static String zza(final WorkSource obj, final int i) {
        if (zzx.zzaKd != null) {
            try {
                return (String)zzx.zzaKd.invoke(obj, i);
            }
            catch (Exception ex) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", (Throwable)ex);
            }
        }
        return null;
    }
    
    public static boolean zzaM(final Context context) {
        return context != null && context.getPackageManager() != null && zzbha.zzaP(context).checkPermission("android.permission.UPDATE_DEVICE_STATS", context.getPackageName()) == 0;
    }
    
    public static List<String> zzb(@Nullable final WorkSource workSource) {
        int n = 0;
        int zza;
        if (workSource == null) {
            zza = 0;
        }
        else {
            zza = zza(workSource);
        }
        List<String> emptyList;
        if (zza == 0) {
            emptyList = Collections.emptyList();
        }
        else {
            final ArrayList<String> list = new ArrayList<String>();
            while (true) {
                emptyList = list;
                if (n >= zza) {
                    break;
                }
                final String zza2 = zza(workSource, n);
                if (!zzt.zzcL(zza2)) {
                    list.add(zza2);
                }
                ++n;
            }
        }
        return emptyList;
    }
    
    private static WorkSource zze(final int n, final String s) {
        final WorkSource workSource = new WorkSource();
        Label_0060: {
            if (zzx.zzaKa == null) {
                break Label_0060;
            }
            String s2;
            if ((s2 = s) == null) {
                s2 = "";
            }
            try {
                zzx.zzaKa.invoke(workSource, n, s2);
                return workSource;
            }
            catch (Exception ex) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", (Throwable)ex);
                return workSource;
            }
        }
        if (zzx.zzaJZ == null) {
            return workSource;
        }
        try {
            zzx.zzaJZ.invoke(workSource, n);
            return workSource;
        }
        catch (Exception ex2) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", (Throwable)ex2);
            return workSource;
        }
    }
    
    private static Method zzsg() {
        try {
            return WorkSource.class.getMethod("add", Integer.TYPE);
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    private static Method zzsh() {
        Method method = null;
        if (!zzq.zzsb()) {
            return method;
        }
        try {
            method = WorkSource.class.getMethod("add", Integer.TYPE, String.class);
            return method;
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    private static Method zzsi() {
        try {
            return WorkSource.class.getMethod("size", (Class<?>[])new Class[0]);
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    private static Method zzsj() {
        try {
            return WorkSource.class.getMethod("get", Integer.TYPE);
        }
        catch (Exception ex) {
            return null;
        }
    }
    
    private static Method zzsk() {
        Method method = null;
        if (!zzq.zzsb()) {
            return method;
        }
        try {
            method = WorkSource.class.getMethod("getName", Integer.TYPE);
            return method;
        }
        catch (Exception ex) {
            return null;
        }
    }
}
