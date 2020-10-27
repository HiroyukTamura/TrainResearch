package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

final class zzj extends zzbq {

    /* renamed from: ID */
    private static final String f994ID = zza.APP_NAME.toString();
    private final Context zzrm;

    public zzj(Context context) {
        super(f994ID, new String[0]);
        this.zzrm = context;
    }

    public final zzl zzb(Map<String, zzl> map) {
        try {
            PackageManager packageManager = this.zzrm.getPackageManager();
            return zzgj.zzi(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.zzrm.getPackageName(), 0)).toString());
        } catch (PackageManager.NameNotFoundException e) {
            zzdi.zza("App name is not found.", e);
            return zzgj.zzkc();
        }
    }

    public final boolean zzgw() {
        return true;
    }
}
