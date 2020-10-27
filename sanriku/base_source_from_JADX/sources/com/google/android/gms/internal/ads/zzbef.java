package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsPromptResult;

final class zzbef implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsPromptResult zzehp;

    zzbef(JsPromptResult jsPromptResult) {
        this.zzehp = jsPromptResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzehp.cancel();
    }
}
