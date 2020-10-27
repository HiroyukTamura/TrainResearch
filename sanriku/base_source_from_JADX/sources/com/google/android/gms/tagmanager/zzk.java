package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

final class zzk extends zzbq {

    /* renamed from: ID */
    private static final String f995ID = zza.APP_VERSION.toString();
    private final Context zzrm;

    public zzk(Context context) {
        super(f995ID, new String[0]);
        this.zzrm = context;
    }

    public final zzl zzb(Map<String, zzl> map) {
        try {
            return zzgj.zzi(Integer.valueOf(this.zzrm.getPackageManager().getPackageInfo(this.zzrm.getPackageName(), 0).versionCode));
        } catch (PackageManager.NameNotFoundException e) {
            String packageName = this.zzrm.getPackageName();
            String message = e.getMessage();
            StringBuilder sb = new StringBuilder(C0681a.m336b(message, C0681a.m336b(packageName, 25)));
            sb.append("Package name ");
            sb.append(packageName);
            sb.append(" not found. ");
            sb.append(message);
            zzdi.zzav(sb.toString());
            return zzgj.zzkc();
        }
    }

    public final boolean zzgw() {
        return true;
    }
}
