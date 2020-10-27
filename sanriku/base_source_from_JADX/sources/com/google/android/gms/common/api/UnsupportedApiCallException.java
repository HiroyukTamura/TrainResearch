package com.google.android.gms.common.api;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.annotation.KeepForSdk;
import p009e.p010a.p011a.p012a.C0681a;

public final class UnsupportedApiCallException extends UnsupportedOperationException {
    private final Feature zzbj;

    @KeepForSdk
    public UnsupportedApiCallException(Feature feature) {
        this.zzbj = feature;
    }

    public final String getMessage() {
        String valueOf = String.valueOf(this.zzbj);
        return C0681a.m312a(valueOf.length() + 8, "Missing ", valueOf);
    }
}
