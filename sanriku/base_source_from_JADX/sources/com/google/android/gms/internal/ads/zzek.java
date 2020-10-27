package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzek extends zzck<Integer, Object> {
    public Long zzyb;
    public Boolean zzyc;
    public Boolean zzyd;

    public zzek() {
    }

    public zzek(String str) {
        zzal(str);
    }

    /* access modifiers changed from: protected */
    public final void zzal(String str) {
        HashMap zzam = zzck.zzam(str);
        if (zzam != null) {
            this.zzyb = (Long) zzam.get(0);
            this.zzyc = (Boolean) zzam.get(1);
            this.zzyd = (Boolean) zzam.get(2);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Object> zzbo() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzyb);
        hashMap.put(1, this.zzyc);
        hashMap.put(2, this.zzyd);
        return hashMap;
    }
}
