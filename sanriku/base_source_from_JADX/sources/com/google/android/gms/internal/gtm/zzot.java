package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.Map;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzot {
    private final zzl zzakg;
    private final Map<String, zzl> zzats;

    private zzot(Map<String, zzl> map, zzl zzl) {
        this.zzats = map;
        this.zzakg = zzl;
    }

    public static zzou zzml() {
        return new zzou();
    }

    public final String toString() {
        String valueOf = String.valueOf(Collections.unmodifiableMap(this.zzats));
        String valueOf2 = String.valueOf(this.zzakg);
        return C0681a.m314a(valueOf2.length() + valueOf.length() + 32, "Properties: ", valueOf, " pushAfterEvaluate: ", valueOf2);
    }

    public final void zza(String str, zzl zzl) {
        this.zzats.put(str, zzl);
    }

    public final zzl zzji() {
        return this.zzakg;
    }

    public final Map<String, zzl> zzlu() {
        return Collections.unmodifiableMap(this.zzats);
    }
}
