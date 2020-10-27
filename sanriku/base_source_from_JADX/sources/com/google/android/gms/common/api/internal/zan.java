package com.google.android.gms.common.api.internal;

import android.app.Dialog;

final class zan extends zabp {
    private final /* synthetic */ Dialog zaec;
    private final /* synthetic */ zal zaed;

    zan(zal zal, Dialog dialog) {
        this.zaed = zal;
        this.zaec = dialog;
    }

    public final void zas() {
        this.zaed.zadl.zao();
        if (this.zaec.isShowing()) {
            this.zaec.dismiss();
        }
    }
}
