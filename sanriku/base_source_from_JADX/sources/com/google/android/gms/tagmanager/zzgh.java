package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

abstract class zzgh extends zzbq {
    public zzgh(String str, String... strArr) {
        super(str, strArr);
    }

    public zzl zzb(Map<String, zzl> map) {
        zzd(map);
        return zzgj.zzkc();
    }

    public abstract void zzd(Map<String, zzl> map);

    public boolean zzgw() {
        return false;
    }
}
