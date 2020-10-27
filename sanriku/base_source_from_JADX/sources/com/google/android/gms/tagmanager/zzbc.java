package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

final class zzbc extends zzbq {

    /* renamed from: ID */
    private static final String f961ID = zza.DEVICE_ID.toString();
    private final Context zzrm;

    public zzbc(Context context) {
        super(f961ID, new String[0]);
        this.zzrm = context;
    }

    public final zzl zzb(Map<String, zzl> map) {
        String string = Settings.Secure.getString(this.zzrm.getContentResolver(), "android_id");
        return string == null ? zzgj.zzkc() : zzgj.zzi(string);
    }

    public final boolean zzgw() {
        return true;
    }
}
