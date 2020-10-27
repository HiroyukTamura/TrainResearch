package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzq;

@TargetApi(26)
public class zzaxn extends zzaxo {
    public final zztp zza(Context context, TelephonyManager telephonyManager) {
        zzq.zzkw();
        return zzaxa.zzq(context, "android.permission.ACCESS_NETWORK_STATE") ? telephonyManager.isDataEnabled() ? zztp.ENUM_TRUE : zztp.ENUM_FALSE : zztp.ENUM_FALSE;
    }
}
