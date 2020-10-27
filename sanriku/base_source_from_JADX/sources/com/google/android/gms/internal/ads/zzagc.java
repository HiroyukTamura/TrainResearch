package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;
import java.util.Map;

public final class zzagc implements zzaga<Object> {
    private final Context zzvf;

    public zzagc(Context context) {
        this.zzvf = context;
    }

    public final void zza(Object obj, Map<String, String> map) {
        if (zzq.zzlu().zzab(this.zzvf)) {
            String str = map.get("eventName");
            String str2 = map.get("eventId");
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != 94399) {
                if (hashCode != 94401) {
                    if (hashCode == 94407 && str.equals("_ai")) {
                        c = 1;
                    }
                } else if (str.equals("_ac")) {
                    c = 0;
                }
            } else if (str.equals("_aa")) {
                c = 2;
            }
            if (c == 0) {
                zzq.zzlu().zzh(this.zzvf, str2);
            } else if (c == 1) {
                zzq.zzlu().zzi(this.zzvf, str2);
            } else if (c != 2) {
                zzazw.zzfa("logScionEvent gmsg contained unsupported eventName");
            } else {
                zzq.zzlu().zzk(this.zzvf, str2);
            }
        }
    }
}
