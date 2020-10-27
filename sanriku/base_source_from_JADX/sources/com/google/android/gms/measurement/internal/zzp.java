package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.firebase.analytics.FirebaseAnalytics;

public final class zzp {
    private final zzgd zza;

    public zzp(zzgd zzgd) {
        this.zza = zzgd;
    }

    private final boolean zzc() {
        return zzd() && this.zza.zzm().currentTimeMillis() - this.zza.zzc().zzw.zza() > this.zza.zzb().zza((String) null, zzaq.zzcr);
    }

    private final boolean zzd() {
        return this.zza.zzc().zzw.zza() > 0;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza() {
        this.zza.zzq().zzd();
        if (zzd()) {
            if (zzc()) {
                this.zza.zzc().zzv.zza((String) null);
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.SOURCE, "(not set)");
                bundle.putString(FirebaseAnalytics.Param.MEDIUM, "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1);
                this.zza.zzh().zza("auto", "_cmpx", bundle);
            } else {
                String zza2 = this.zza.zzc().zzv.zza();
                if (TextUtils.isEmpty(zza2)) {
                    this.zza.zzr().zzg().zza("Cache still valid but referrer not found");
                } else {
                    long zza3 = ((this.zza.zzc().zzw.zza() / 3600000) - 1) * 3600000;
                    Uri parse = Uri.parse(zza2);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(parse.getPath(), bundle2);
                    for (String next : parse.getQueryParameterNames()) {
                        bundle2.putString(next, parse.getQueryParameter(next));
                    }
                    ((Bundle) pair.second).putLong("_cc", zza3);
                    this.zza.zzh().zza((String) pair.first, "_cmp", (Bundle) pair.second);
                }
                this.zza.zzc().zzv.zza((String) null);
            }
            this.zza.zzc().zzw.zza(0);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(String str, Bundle bundle) {
        String str2;
        this.zza.zzq().zzd();
        if (!this.zza.zzab()) {
            if (bundle == null || bundle.isEmpty()) {
                str2 = null;
            } else {
                if (str == null || str.isEmpty()) {
                    str = "auto";
                }
                Uri.Builder builder = new Uri.Builder();
                builder.path(str);
                for (String str3 : bundle.keySet()) {
                    builder.appendQueryParameter(str3, bundle.getString(str3));
                }
                str2 = builder.build().toString();
            }
            if (!TextUtils.isEmpty(str2)) {
                this.zza.zzc().zzv.zza(str2);
                this.zza.zzc().zzw.zza(this.zza.zzm().currentTimeMillis());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb() {
        if (zzd() && zzc()) {
            this.zza.zzc().zzv.zza((String) null);
        }
    }
}
