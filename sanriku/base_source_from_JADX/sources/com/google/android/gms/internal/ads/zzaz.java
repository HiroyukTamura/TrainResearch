package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

final class zzaz implements zzap {
    private final /* synthetic */ Context val$appContext;
    private File zzco = null;

    zzaz(Context context) {
        this.val$appContext = context;
    }

    public final File zzo() {
        if (this.zzco == null) {
            this.zzco = new File(this.val$appContext.getCacheDir(), "volley");
        }
        return this.zzco;
    }
}
