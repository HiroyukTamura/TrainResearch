package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.zzq;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;
import p043jp.reifrontier.gym.RFGDef;

public final class zzaad {
    private String zzbnd = null;
    private String zzcul;
    private Map<String, String> zzcuo;
    private Context zzvf = null;

    public zzaad(Context context, String str) {
        this.zzvf = context;
        this.zzbnd = str;
        this.zzcul = zzabg.zzcvz.get();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzcuo = linkedHashMap;
        linkedHashMap.put("s", "gmob_sdk");
        this.zzcuo.put("v", ExifInterface.GPS_MEASUREMENT_3D);
        this.zzcuo.put("os", Build.VERSION.RELEASE);
        this.zzcuo.put("api_v", Build.VERSION.SDK);
        Map<String, String> map = this.zzcuo;
        zzq.zzkw();
        map.put("device", zzaxa.zzxh());
        this.zzcuo.put("app", context.getApplicationContext() != null ? context.getApplicationContext().getPackageName() : context.getPackageName());
        Map<String, String> map2 = this.zzcuo;
        zzq.zzkw();
        map2.put("is_lite_sdk", zzaxa.zzay(context) ? "1" : RFGDef.DEFAULT_GYM_ID);
        Future<zzars> zzx = zzq.zzlh().zzx(this.zzvf);
        try {
            this.zzcuo.put("network_coarse", Integer.toString(zzx.get().zzdpy));
            this.zzcuo.put("network_fine", Integer.toString(zzx.get().zzdpz));
        } catch (Exception e) {
            zzq.zzla().zza(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* access modifiers changed from: package-private */
    public final Context getContext() {
        return this.zzvf;
    }

    /* access modifiers changed from: package-private */
    public final String zzkr() {
        return this.zzbnd;
    }

    /* access modifiers changed from: package-private */
    public final String zzrh() {
        return this.zzcul;
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zzri() {
        return this.zzcuo;
    }
}
