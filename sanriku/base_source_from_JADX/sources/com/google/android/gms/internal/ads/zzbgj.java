package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

final class zzbgj implements zzaga<zzbek> {
    private final /* synthetic */ zzbgh zzelp;

    zzbgj(zzbgh zzbgh) {
        this.zzelp = zzbgh;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zzbek zzbek = (zzbek) obj;
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zzelp) {
                        if (this.zzelp.zzekk != parseInt) {
                            int unused = this.zzelp.zzekk = parseInt;
                            this.zzelp.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzazw.zzd("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
