package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

final class zzaw extends FilterInputStream {
    private final HttpURLConnection zzcm;

    zzaw(HttpURLConnection httpURLConnection) {
        super(zzat.zza(httpURLConnection));
        this.zzcm = httpURLConnection;
    }

    public final void close() throws IOException {
        super.close();
        this.zzcm.disconnect();
    }
}
