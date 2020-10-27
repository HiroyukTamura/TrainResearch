package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

public final class zzchz {
    /* access modifiers changed from: private */
    public final Executor executor;
    /* access modifiers changed from: private */
    public final zzcie zzfyx;
    /* access modifiers changed from: private */
    public final Map<String, String> zzfzb;

    public zzchz(zzcie zzcie, Executor executor2) {
        this.zzfyx = zzcie;
        this.zzfzb = zzcie.zzaob();
        this.executor = executor2;
    }

    public final zzchy zzaoa() {
        return new zzchy(this).zzanx();
    }
}
