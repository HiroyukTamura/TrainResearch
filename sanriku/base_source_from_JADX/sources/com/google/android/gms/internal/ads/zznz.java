package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

public final class zznz extends zzoa {
    private final int responseCode;
    private final Map<String, List<String>> zzbgn;

    public zznz(int i, Map<String, List<String>> map, zznv zznv) {
        super(C0681a.m309a(26, "Response code: ", i), zznv, 1);
        this.responseCode = i;
        this.zzbgn = map;
    }
}
