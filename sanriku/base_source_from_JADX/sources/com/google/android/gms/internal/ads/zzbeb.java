package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.webkit.JsResult;

final class zzbeb implements DialogInterface.OnCancelListener {
    private final /* synthetic */ JsResult zzeho;

    zzbeb(JsResult jsResult) {
        this.zzeho = jsResult;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.zzeho.cancel();
    }
}
