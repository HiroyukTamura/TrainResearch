package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.wrappers.Wrappers;

@ShowFirstParty
@KeepForSdk
public class GoogleSignatureVerifier {
    private static GoogleSignatureVerifier zzat;
    private final Context mContext;
    private volatile String zzau;

    private GoogleSignatureVerifier(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @KeepForSdk
    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (zzat == null) {
                zzc.zza(context);
                zzat = new GoogleSignatureVerifier(context);
            }
        }
        return zzat;
    }

    private static zzd zza(PackageInfo packageInfo, zzd... zzdArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzg zzg = new zzg(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzdArr.length; i++) {
            if (zzdArr[i].equals(zzg)) {
                return zzdArr[i];
            }
        }
        return null;
    }

    private final zzl zza(String str, int i) {
        try {
            PackageInfo zza = Wrappers.packageManager(this.mContext).zza(str, 64, i);
            boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext);
            if (zza == null) {
                return zzl.zzb("null pkg");
            }
            if (zza.signatures != null) {
                if (zza.signatures.length == 1) {
                    zzg zzg = new zzg(zza.signatures[0].toByteArray());
                    String str2 = zza.packageName;
                    zzl zza2 = zzc.zza(str2, zzg, honorsDebugCertificates, false);
                    return (!zza2.zzap || zza.applicationInfo == null || (zza.applicationInfo.flags & 2) == 0 || !zzc.zza(str2, zzg, false, true).zzap) ? zza2 : zzl.zzb("debuggable release cert app rejected");
                }
            }
            return zzl.zzb("single cert required");
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return zzl.zzb(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }

    public static boolean zza(PackageInfo packageInfo, boolean z) {
        zzd zzd;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                zzd = zza(packageInfo, zzi.zzaj);
            } else {
                zzd = zza(packageInfo, zzi.zzaj[0]);
            }
            if (zzd != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.common.zzl zzc(java.lang.String r8) {
        /*
            r7 = this;
            java.lang.String r0 = "null pkg"
            if (r8 != 0) goto L_0x0009
            com.google.android.gms.common.zzl r8 = com.google.android.gms.common.zzl.zzb(r0)
            return r8
        L_0x0009:
            java.lang.String r1 = r7.zzau
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L_0x0016
            com.google.android.gms.common.zzl r8 = com.google.android.gms.common.zzl.zze()
            return r8
        L_0x0016:
            android.content.Context r1 = r7.mContext     // Catch:{ NameNotFoundException -> 0x0071 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r1 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r1)     // Catch:{ NameNotFoundException -> 0x0071 }
            r2 = 64
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r8, r2)     // Catch:{ NameNotFoundException -> 0x0071 }
            android.content.Context r2 = r7.mContext
            boolean r2 = com.google.android.gms.common.GooglePlayServicesUtilLight.honorsDebugCertificates(r2)
            if (r1 != 0) goto L_0x002f
        L_0x002a:
            com.google.android.gms.common.zzl r0 = com.google.android.gms.common.zzl.zzb(r0)
            goto L_0x006a
        L_0x002f:
            android.content.pm.Signature[] r0 = r1.signatures
            if (r0 == 0) goto L_0x0067
            int r0 = r0.length
            r3 = 1
            if (r0 == r3) goto L_0x0038
            goto L_0x0067
        L_0x0038:
            com.google.android.gms.common.zzg r0 = new com.google.android.gms.common.zzg
            android.content.pm.Signature[] r4 = r1.signatures
            r5 = 0
            r4 = r4[r5]
            byte[] r4 = r4.toByteArray()
            r0.<init>(r4)
            java.lang.String r4 = r1.packageName
            com.google.android.gms.common.zzl r2 = com.google.android.gms.common.zzc.zza(r4, r0, r2, r5)
            boolean r6 = r2.zzap
            if (r6 == 0) goto L_0x0065
            android.content.pm.ApplicationInfo r1 = r1.applicationInfo
            if (r1 == 0) goto L_0x0065
            int r1 = r1.flags
            r1 = r1 & 2
            if (r1 == 0) goto L_0x0065
            com.google.android.gms.common.zzl r0 = com.google.android.gms.common.zzc.zza(r4, r0, r5, r3)
            boolean r0 = r0.zzap
            if (r0 == 0) goto L_0x0065
            java.lang.String r0 = "debuggable release cert app rejected"
            goto L_0x002a
        L_0x0065:
            r0 = r2
            goto L_0x006a
        L_0x0067:
            java.lang.String r0 = "single cert required"
            goto L_0x002a
        L_0x006a:
            boolean r1 = r0.zzap
            if (r1 == 0) goto L_0x0070
            r7.zzau = r8
        L_0x0070:
            return r0
        L_0x0071:
            java.lang.String r0 = "no pkg "
            int r1 = r8.length()
            if (r1 == 0) goto L_0x007f
            java.lang.String r8 = r0.concat(r8)
            goto L_0x0084
        L_0x007f:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r0)
        L_0x0084:
            com.google.android.gms.common.zzl r8 = com.google.android.gms.common.zzl.zzb(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.zzc(java.lang.String):com.google.android.gms.common.zzl");
    }

    @KeepForSdk
    public boolean isGooglePublicSignedPackage(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (zza(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.mContext)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isPackageGoogleSigned(String str) {
        zzl zzc = zzc(str);
        zzc.zzf();
        return zzc.zzap;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean isUidGoogleSigned(int i) {
        zzl zzl;
        String[] packagesForUid = Wrappers.packageManager(this.mContext).getPackagesForUid(i);
        if (packagesForUid != null && packagesForUid.length != 0) {
            zzl = null;
            for (String zza : packagesForUid) {
                zzl = zza(zza, i);
                if (zzl.zzap) {
                    break;
                }
            }
        } else {
            zzl = zzl.zzb("no pkgs");
        }
        zzl.zzf();
        return zzl.zzap;
    }
}
