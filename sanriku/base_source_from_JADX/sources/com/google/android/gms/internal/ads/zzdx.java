package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzdx extends zzck<Integer, Long> {
    public long zzxs;
    public long zzxt;

    public zzdx() {
        this.zzxs = -1;
        this.zzxt = -1;
    }

    public zzdx(String str) {
        this();
        zzal(str);
    }

    /* access modifiers changed from: protected */
    public final void zzal(String str) {
        HashMap zzam = zzck.zzam(str);
        if (zzam != null) {
            this.zzxs = ((Long) zzam.get(0)).longValue();
            this.zzxt = ((Long) zzam.get(1)).longValue();
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzbo() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, Long.valueOf(this.zzxs));
        hashMap.put(1, Long.valueOf(this.zzxt));
        return hashMap;
    }
}
