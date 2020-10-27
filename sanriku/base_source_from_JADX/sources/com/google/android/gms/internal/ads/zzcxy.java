package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.Callable;

final /* synthetic */ class zzcxy implements Callable {
    private final zzcxv zzgne;

    zzcxy(zzcxv zzcxv) {
        this.zzgne = zzcxv;
    }

    public final Object call() {
        String str;
        String str2;
        String str3;
        zzq.zzkw();
        zzqp zzwp = zzq.zzla().zzwb().zzwp();
        Bundle bundle = null;
        if (zzwp != null && (!zzq.zzla().zzwb().zzwq() || !zzq.zzla().zzwb().zzws())) {
            if (zzwp.zzml()) {
                zzwp.wakeup();
            }
            zzqj zzmj = zzwp.zzmj();
            if (zzmj != null) {
                str2 = zzmj.zzly();
                str = zzmj.zzlz();
                str3 = zzmj.zzma();
                if (str2 != null) {
                    zzq.zzla().zzwb().zzeh(str2);
                }
                if (str3 != null) {
                    zzq.zzla().zzwb().zzei(str3);
                }
            } else {
                str2 = zzq.zzla().zzwb().zzwr();
                str3 = zzq.zzla().zzwb().zzwt();
                str = null;
            }
            Bundle bundle2 = new Bundle(1);
            if (!zzq.zzla().zzwb().zzws()) {
                if (str3 == null || TextUtils.isEmpty(str3)) {
                    str3 = "no_hash";
                }
                bundle2.putString("v_fp_vertical", str3);
            }
            if (str2 != null && !zzq.zzla().zzwb().zzwq()) {
                bundle2.putString("fingerprint", str2);
                if (!str2.equals(str)) {
                    bundle2.putString("v_fp", str);
                }
            }
            if (!bundle2.isEmpty()) {
                bundle = bundle2;
            }
        }
        return new zzcxw(bundle);
    }
}
