package com.google.android.gms.internal.gtm;

import com.google.android.gms.tagmanager.zzdi;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import p009e.p010a.p011a.p012a.C0681a;

final class zzpb implements zzpc {
    private HttpURLConnection zzatk;
    private InputStream zzatl = null;

    zzpb() {
    }

    public final void close() {
        HttpURLConnection httpURLConnection = this.zzatk;
        try {
            if (this.zzatl != null) {
                this.zzatl.close();
            }
        } catch (IOException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzdi.zza(valueOf.length() != 0 ? "HttpUrlConnectionNetworkClient: Error when closing http input stream: ".concat(valueOf) : new String("HttpUrlConnectionNetworkClient: Error when closing http input stream: "), e);
        }
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }

    public final InputStream zzcj(String str) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(20000);
        this.zzatk = httpURLConnection;
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode == 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            this.zzatl = inputStream;
            return inputStream;
        }
        String a = C0681a.m309a(25, "Bad response: ", responseCode);
        if (responseCode == 404) {
            throw new FileNotFoundException(a);
        } else if (responseCode == 503) {
            throw new zzpe(a);
        } else {
            throw new IOException(a);
        }
    }
}
