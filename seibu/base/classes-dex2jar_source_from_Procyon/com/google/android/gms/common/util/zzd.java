// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.util;

import android.support.annotation.Nullable;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.gms.internal.zzbha;
import android.os.Bundle;
import android.content.pm.PackageInfo;
import android.content.Context;

public final class zzd
{
    public static int zzA(final Context context, final String s) {
        final PackageInfo zzB = zzB(context, s);
        if (zzB != null && zzB.applicationInfo != null) {
            final Bundle metaData = zzB.applicationInfo.metaData;
            if (metaData != null) {
                return metaData.getInt("com.google.android.gms.version", -1);
            }
        }
        return -1;
    }
    
    @Nullable
    private static PackageInfo zzB(final Context context, final String s) {
        try {
            return zzbha.zzaP(context).getPackageInfo(s, 128);
        }
        catch (PackageManager$NameNotFoundException ex) {
            return null;
        }
    }
    
    public static boolean zzC(final Context context, final String anObject) {
        boolean b = false;
        "com.google.android.gms".equals(anObject);
        try {
            if ((zzbha.zzaP(context).getApplicationInfo(anObject, 0).flags & 0x200000) != 0x0) {
                b = true;
            }
            return b;
        }
        catch (PackageManager$NameNotFoundException ex) {
            return false;
        }
    }
}
