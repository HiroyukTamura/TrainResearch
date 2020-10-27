package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzel extends zzck<Integer, Long> {
    public Long zzye;
    public Long zzyf;

    public zzel() {
    }

    public zzel(String str) {
        zzal(str);
    }

    /* access modifiers changed from: protected */
    public final void zzal(String str) {
        HashMap zzam = zzck.zzam(str);
        if (zzam != null) {
            this.zzye = (Long) zzam.get(0);
            this.zzyf = (Long) zzam.get(1);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzbo() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzye);
        hashMap.put(1, this.zzyf);
        return hashMap;
    }
}
