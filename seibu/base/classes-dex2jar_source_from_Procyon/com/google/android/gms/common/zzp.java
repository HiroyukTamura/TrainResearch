// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common;

import android.content.pm.PackageManager;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.gms.internal.zzbha;
import com.google.android.gms.common.internal.zzbo;
import android.util.Log;
import android.content.pm.PackageInfo;
import android.content.Context;

public class zzp
{
    private static zzp zzaAu;
    private final Context mContext;
    
    private zzp(final Context context) {
        this.mContext = context.getApplicationContext();
    }
    
    static zzg zza(final PackageInfo packageInfo, final zzg... array) {
        int i = 0;
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        final zzh zzh = new zzh(packageInfo.signatures[0].toByteArray());
        while (i < array.length) {
            if (array[i].equals(zzh)) {
                return array[i];
            }
            ++i;
        }
        return null;
    }
    
    private static boolean zza(final PackageInfo packageInfo, final boolean b) {
        if (packageInfo != null && packageInfo.signatures != null) {
            zzg zzg;
            if (b) {
                zzg = zza(packageInfo, zzj.zzaAk);
            }
            else {
                zzg = zza(packageInfo, zzj.zzaAk[0]);
            }
            if (zzg != null) {
                return true;
            }
        }
        return false;
    }
    
    public static zzp zzax(final Context context) {
        zzbo.zzu(context);
        synchronized (zzp.class) {
            if (zzp.zzaAu == null) {
                zzf.zzav(context);
                zzp.zzaAu = new zzp(context);
            }
            return zzp.zzaAu;
        }
    }
    
    private static boolean zzb(final PackageInfo packageInfo, final boolean b) {
        boolean b2 = false;
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
        }
        else {
            final zzh zzh = new zzh(packageInfo.signatures[0].toByteArray());
            final String packageName = packageInfo.packageName;
            boolean b3;
            if (b) {
                b3 = zzf.zzb(packageName, zzh);
            }
            else {
                b3 = zzf.zza(packageName, zzh);
            }
            b2 = b3;
            if (!b3) {
                Log.d("GoogleSignatureVerifier", new StringBuilder(27).append("Cert not in list. atk=").append(b).toString());
                return b3;
            }
        }
        return b2;
    }
    
    private final boolean zzct(final String s) {
        try {
            final PackageInfo packageInfo = zzbha.zzaP(this.mContext).getPackageInfo(s, 64);
            if (packageInfo == null) {
                return false;
            }
            if (zzo.zzaw(this.mContext)) {
                return zzb(packageInfo, true);
            }
            final boolean zzb = zzb(packageInfo, false);
            if (!zzb && zzb(packageInfo, true)) {
                Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
            }
            return zzb;
        }
        catch (PackageManager$NameNotFoundException ex) {
            return false;
        }
    }
    
    @Deprecated
    public final boolean zza(final PackageManager packageManager, int i) {
        final String[] packagesForUid = zzbha.zzaP(this.mContext).getPackagesForUid(i);
        if (packagesForUid != null && packagesForUid.length != 0) {
            int length;
            for (length = packagesForUid.length, i = 0; i < length; ++i) {
                if (this.zzct(packagesForUid[i])) {
                    return true;
                }
            }
        }
        return false;
    }
    
    @Deprecated
    public final boolean zza(final PackageManager packageManager, final PackageInfo packageInfo) {
        if (packageInfo != null) {
            if (!zza(packageInfo, false)) {
                if (!zza(packageInfo, true)) {
                    return false;
                }
                if (!zzo.zzaw(this.mContext)) {
                    Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
