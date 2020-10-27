package com.google.android.gms.internal.ads;

import java.io.InputStream;

final class zzso extends zzbaj<InputStream> {
    private final /* synthetic */ zzsl zzbsw;

    zzso(zzsl zzsl) {
        this.zzbsw = zzsl;
    }

    public final boolean cancel(boolean z) {
        this.zzbsw.disconnect();
        return super.cancel(z);
    }
}
