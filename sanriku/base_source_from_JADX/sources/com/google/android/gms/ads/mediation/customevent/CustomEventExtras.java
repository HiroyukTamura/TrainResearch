package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.C0566f;
import java.util.HashMap;

@Deprecated
public final class CustomEventExtras implements C0566f {
    private final HashMap<String, Object> zzene = new HashMap<>();

    public final Object getExtra(String str) {
        return this.zzene.get(str);
    }

    public final void setExtra(String str, Object obj) {
        this.zzene.put(str, obj);
    }
}
