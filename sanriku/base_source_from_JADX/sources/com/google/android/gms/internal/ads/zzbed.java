package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

final class zzbed implements DialogInterface.OnClickListener {
    private final /* synthetic */ JsResult zzeho;

    zzbed(JsResult jsResult) {
        this.zzeho = jsResult;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.zzeho.confirm();
    }
}
