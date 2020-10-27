package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

public final class zzagl implements zzaga<Object> {
    private final zzagk zzday;

    private zzagl(zzagk zzagk) {
        this.zzday = zzagk;
    }

    public static void zza(zzbek zzbek, zzagk zzagk) {
        zzbek.zza("/reward", (zzaga<? super zzbek>) new zzagl(zzagk));
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("action");
        if ("grant".equals(str)) {
            zzatc zzatc = null;
            try {
                int parseInt = Integer.parseInt(map.get("amount"));
                String str2 = map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzatc = new zzatc(str2, parseInt);
                }
            } catch (NumberFormatException e) {
                zzazw.zzd("Unable to parse reward amount.", e);
            }
            this.zzday.zza(zzatc);
        } else if ("video_start".equals(str)) {
            this.zzday.zzsm();
        } else if ("video_complete".equals(str)) {
            this.zzday.zzsn();
        }
    }
}
