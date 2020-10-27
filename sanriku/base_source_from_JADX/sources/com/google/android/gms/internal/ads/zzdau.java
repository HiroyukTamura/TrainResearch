package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzq;

public final class zzdau implements zzdak<zzdar> {
    private final zzdrh zzfur;
    private final Context zzvf;

    public zzdau(zzdrh zzdrh, Context context) {
        this.zzfur = zzdrh;
        this.zzvf = context;
    }

    public final zzdri<zzdar> zzaqa() {
        return this.zzfur.zzd(new zzdat(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdar zzaqs() throws Exception {
        int i;
        boolean z;
        int i2;
        int i3;
        TelephonyManager telephonyManager = (TelephonyManager) this.zzvf.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        int networkType = telephonyManager.getNetworkType();
        int phoneType = telephonyManager.getPhoneType();
        zzq.zzkw();
        int i4 = -1;
        if (zzaxa.zzq(this.zzvf, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.zzvf.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                i4 = activeNetworkInfo.getType();
                i3 = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                i3 = -1;
            }
            z = connectivityManager.isActiveNetworkMetered();
            i = i3;
            i2 = i4;
        } else {
            i2 = -2;
            z = false;
            i = -1;
        }
        return new zzdar(networkOperator, i2, networkType, phoneType, z, i);
    }
}
