// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import java.io.FileNotFoundException;
import java.net.URL;
import java.io.IOException;
import com.google.android.gms.tagmanager.zzdj;
import java.io.InputStream;
import java.net.HttpURLConnection;

final class eq implements er
{
    private HttpURLConnection zzbKR;
    private InputStream zzbKS;
    
    eq() {
        this.zzbKS = null;
    }
    
    @Override
    public final void close() {
        final HttpURLConnection zzbKR = this.zzbKR;
        while (true) {
            try {
                if (this.zzbKS != null) {
                    this.zzbKS.close();
                }
                if (zzbKR != null) {
                    zzbKR.disconnect();
                }
            }
            catch (IOException ex) {
                final String value = String.valueOf(ex.getMessage());
                String concat;
                if (value.length() != 0) {
                    concat = "HttpUrlConnectionNetworkClient: Error when closing http input stream: ".concat(value);
                }
                else {
                    concat = new String("HttpUrlConnectionNetworkClient: Error when closing http input stream: ");
                }
                zzdj.zzb(concat, ex);
                continue;
            }
            break;
        }
    }
    
    @Override
    public final InputStream zzfU(String string) throws IOException {
        final HttpURLConnection zzbKR = (HttpURLConnection)new URL(string).openConnection();
        zzbKR.setReadTimeout(20000);
        zzbKR.setConnectTimeout(20000);
        this.zzbKR = zzbKR;
        final HttpURLConnection zzbKR2 = this.zzbKR;
        final int responseCode = zzbKR2.getResponseCode();
        if (responseCode == 200) {
            return this.zzbKS = zzbKR2.getInputStream();
        }
        string = new StringBuilder(25).append("Bad response: ").append(responseCode).toString();
        if (responseCode == 404) {
            throw new FileNotFoundException(string);
        }
        if (responseCode == 503) {
            throw new et(string);
        }
        throw new IOException(string);
    }
}
