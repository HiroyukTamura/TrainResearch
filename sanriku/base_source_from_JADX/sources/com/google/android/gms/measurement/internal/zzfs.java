package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzng;
import com.google.firebase.analytics.FirebaseAnalytics;

final class zzfs implements Runnable {
    private final /* synthetic */ zzd zza;
    private final /* synthetic */ ServiceConnection zzb;
    private final /* synthetic */ zzft zzc;

    zzfs(zzft zzft, zzd zzd, ServiceConnection serviceConnection) {
        this.zzc = zzft;
        this.zza = zzd;
        this.zzb = serviceConnection;
    }

    public final void run() {
        zzfb zzf;
        String str;
        zzft zzft = this.zzc;
        zzfq zzfq = zzft.zza;
        String zza2 = zzft.zzb;
        zzd zzd = this.zza;
        ServiceConnection serviceConnection = this.zzb;
        Bundle zza3 = zzfq.zza(zza2, zzd);
        zzfq.zza.zzq().zzd();
        if (zza3 != null) {
            long j = zza3.getLong("install_begin_timestamp_seconds", 0) * 1000;
            if (j == 0) {
                zzf = zzfq.zza.zzr().zzi();
                str = "Service response is missing Install Referrer install timestamp";
            } else {
                String string = zza3.getString("install_referrer");
                if (string == null || string.isEmpty()) {
                    zzf = zzfq.zza.zzr().zzf();
                    str = "No referrer defined in Install Referrer response";
                } else {
                    zzfq.zza.zzr().zzx().zza("InstallReferrer API result", string);
                    Bundle zza4 = zzfq.zza.zzi().zza(Uri.parse(string.length() != 0 ? "?".concat(string) : new String("?")));
                    if (zza4 == null) {
                        zzf = zzfq.zza.zzr().zzf();
                        str = "No campaign params defined in Install Referrer result";
                    } else {
                        String string2 = zza4.getString(FirebaseAnalytics.Param.MEDIUM);
                        if (string2 != null && !"(not set)".equalsIgnoreCase(string2) && !"organic".equalsIgnoreCase(string2)) {
                            long j2 = zza3.getLong("referrer_click_timestamp_seconds", 0) * 1000;
                            if (j2 == 0) {
                                zzf = zzfq.zza.zzr().zzf();
                                str = "Install Referrer is missing click timestamp for ad campaign";
                            } else {
                                zza4.putLong("click_timestamp", j2);
                            }
                        }
                        if (j == zzfq.zza.zzc().zzi.zza()) {
                            zzfq.zza.zzu();
                            zzf = zzfq.zza.zzr().zzx();
                            str = "Install Referrer campaign has already been logged";
                        } else if (!zzng.zzb() || !zzfq.zza.zzb().zza(zzaq.zzca) || zzfq.zza.zzab()) {
                            zzfq.zza.zzc().zzi.zza(j);
                            zzfq.zza.zzu();
                            zzfq.zza.zzr().zzx().zza("Logging Install Referrer campaign from sdk with ", "referrer API");
                            zza4.putString("_cis", "referrer API");
                            zzfq.zza.zzh().zza("auto", "_cmp", zza4);
                        }
                    }
                }
            }
            zzf.zza(str);
        }
        if (serviceConnection != null) {
            ConnectionTracker.getInstance().unbindService(zzfq.zza.zzn(), serviceConnection);
        }
    }
}
