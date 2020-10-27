package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

@VisibleForTesting
public final class zzov {
    private final String version;
    private final List<zzox> zzatq;
    private final Map<String, List<zzot>> zzatr;
    private final int zzpw;

    private zzov(List<zzox> list, Map<String, List<zzot>> map, String str, int i) {
        this.zzatq = Collections.unmodifiableList(list);
        this.zzatr = Collections.unmodifiableMap(map);
        this.version = str;
        this.zzpw = i;
    }

    public static zzow zzmn() {
        return new zzow();
    }

    public final String getVersion() {
        return this.version;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzatq);
        String valueOf2 = String.valueOf(this.zzatr);
        return C0681a.m314a(valueOf2.length() + valueOf.length() + 17, "Rules: ", valueOf, "  Macros: ", valueOf2);
    }

    public final List<zzox> zzls() {
        return this.zzatq;
    }

    public final Map<String, List<zzot>> zzmo() {
        return this.zzatr;
    }
}
