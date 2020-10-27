package com.google.android.gms.internal.ads;

import java.io.OutputStream;

final /* synthetic */ class zzarh implements Runnable {
    private final OutputStream zzdoz;
    private final byte[] zzdpa;

    zzarh(OutputStream outputStream, byte[] bArr) {
        this.zzdoz = outputStream;
        this.zzdpa = bArr;
    }

    public final void run() {
        zzari.zza(this.zzdoz, this.zzdpa);
    }
}
