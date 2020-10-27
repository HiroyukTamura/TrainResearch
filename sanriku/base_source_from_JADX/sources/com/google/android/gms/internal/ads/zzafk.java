package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import p043jp.reifrontier.gym.p044ui.dialog.RFGAddMemberDialog;

public final class zzafk implements zzaga<zzbek> {
    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbek zzbek = (zzbek) obj;
        String str = (String) map.get("action");
        if ("tick".equals(str)) {
            String str2 = (String) map.get(RFGAddMemberDialog.ARG_LABEL);
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzazw.zzfc("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzazw.zzfc("No timestamp given for CSI tick.");
            } else {
                try {
                    long parseLong = (Long.parseLong(str4) - zzq.zzld().currentTimeMillis()) + zzq.zzld().elapsedRealtime();
                    if (TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzbek.zzzj().zza(str2, str3, parseLong);
                } catch (NumberFormatException e) {
                    zzazw.zzd("Malformed timestamp for CSI tick.", e);
                }
            }
        } else if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzazw.zzfc("No value given for CSI experiment.");
                return;
            }
            zzaam zzrn = zzbek.zzzj().zzrn();
            if (zzrn == null) {
                zzazw.zzfc("No ticker for WebView, dropping experiment ID.");
            } else {
                zzrn.zzh("e", str5);
            }
        } else if ("extra".equals(str)) {
            String str6 = (String) map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzazw.zzfc("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                zzazw.zzfc("No name given for CSI extra.");
            } else {
                zzaam zzrn2 = zzbek.zzzj().zzrn();
                if (zzrn2 == null) {
                    zzazw.zzfc("No ticker for WebView, dropping extra parameter.");
                } else {
                    zzrn2.zzh(str6, str7);
                }
            }
        }
    }
}
