package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

final class zzbfc implements zzaga<zzbek> {
    private final /* synthetic */ zzbfa zzekt;

    zzbfc(zzbfa zzbfa) {
        this.zzekt = zzbfa;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbek zzbek = (zzbek) obj;
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zzekt) {
                        if (this.zzekt.zzekk != parseInt) {
                            int unused = this.zzekt.zzekk = parseInt;
                            this.zzekt.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzazw.zzd("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
