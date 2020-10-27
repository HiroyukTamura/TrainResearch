package com.google.firebase.iid;

import java.util.concurrent.Executor;

final /* synthetic */ class zzg implements Executor {
    static final Executor zza = new zzg();

    private zzg() {
    }

    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
