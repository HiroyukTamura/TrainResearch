// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.pm.PackageManager$NameNotFoundException;
import com.google.android.gms.internal.zzbha;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzai;
import com.google.android.gms.common.util.zzj;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.content.Context;

public class zze
{
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE;
    private static final zze zzaAc;
    
    static {
        GOOGLE_PLAY_SERVICES_VERSION_CODE = zzo.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        zzaAc = new zze();
    }
    
    zze() {
    }
    
    @Nullable
    public static Intent zza(final Context context, final int n, @Nullable final String s) {
        switch (n) {
            default: {
                return null;
            }
            case 1:
            case 2: {
                if (context != null && zzj.zzaH(context)) {
                    return zzai.zzrD();
                }
                return zzai.zzw("com.google.android.gms", zzx(context, s));
            }
            case 3: {
                return zzai.zzcD("com.google.android.gms");
            }
        }
    }
    
    public static void zzas(final Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zzo.zzah(context);
    }
    
    public static void zzat(final Context context) {
        zzo.zzat(context);
    }
    
    public static int zzau(final Context context) {
        return zzo.zzau(context);
    }
    
    public static boolean zze(final Context context, final int n) {
        return zzo.zze(context, n);
    }
    
    public static zze zzoW() {
        return zze.zzaAc;
    }
    
    private static String zzx(@Nullable final Context context, @Nullable final String str) {
        final StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(zze.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        sb.append("-");
        if (!TextUtils.isEmpty((CharSequence)str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        Label_0094: {
            if (context == null) {
                break Label_0094;
            }
            try {
                sb.append(zzbha.zzaP(context).getPackageInfo(context.getPackageName(), 0).versionCode);
                return sb.toString();
            }
            catch (PackageManager$NameNotFoundException ex) {
                return sb.toString();
            }
        }
    }
    
    @Nullable
    public PendingIntent getErrorResolutionPendingIntent(final Context context, final int n, final int n2) {
        return this.zza(context, n, n2, null);
    }
    
    public String getErrorString(final int n) {
        return zzo.getErrorString(n);
    }
    
    @Deprecated
    @Nullable
    public String getOpenSourceSoftwareLicenseInfo(final Context context) {
        return zzo.getOpenSourceSoftwareLicenseInfo(context);
    }
    
    public int isGooglePlayServicesAvailable(final Context context) {
        int googlePlayServicesAvailable;
        if (zzo.zze(context, googlePlayServicesAvailable = zzo.isGooglePlayServicesAvailable(context))) {
            googlePlayServicesAvailable = 18;
        }
        return googlePlayServicesAvailable;
    }
    
    public boolean isUserResolvableError(final int n) {
        return zzo.isUserRecoverableError(n);
    }
    
    @Nullable
    public final PendingIntent zza(final Context context, final int n, final int n2, @Nullable final String s) {
        final Intent zza = zza(context, n, s);
        if (zza == null) {
            return null;
        }
        return PendingIntent.getActivity(context, n2, zza, 268435456);
    }
    
    @Deprecated
    @Nullable
    public final Intent zzak(final int n) {
        return zza(null, n, null);
    }
}
