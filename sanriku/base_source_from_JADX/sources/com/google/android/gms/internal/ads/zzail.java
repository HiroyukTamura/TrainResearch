package com.google.android.gms.internal.ads;

import android.webkit.JavascriptInterface;
import androidx.annotation.Nullable;

final class zzail {
    private final zzaio zzdbx;

    private zzail(zzaio zzaio) {
        this.zzdbx = zzaio;
    }

    @JavascriptInterface
    public final void notify(@Nullable String str) {
        this.zzdbx.zzde(str);
    }
}
