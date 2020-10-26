// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.ads.identifier;

import java.io.IOException;
import android.util.Log;
import java.net.URL;
import java.net.HttpURLConnection;

final class zza extends Thread
{
    private /* synthetic */ String zzsD;
    
    zza(final AdvertisingIdClient advertisingIdClient, final String zzsD) {
        this.zzsD = zzsD;
    }
    
    @Override
    public final void run() {
        new zzb();
        final String zzsD = this.zzsD;
        try {
            final HttpURLConnection httpURLConnection = (HttpURLConnection)new URL(zzsD).openConnection();
            try {
                final int responseCode = httpURLConnection.getResponseCode();
                if (responseCode < 200 || responseCode >= 300) {
                    Log.w("HttpUrlPinger", new StringBuilder(String.valueOf(zzsD).length() + 65).append("Received non-success response code ").append(responseCode).append(" from pinging URL: ").append(zzsD).toString());
                }
            }
            finally {
                httpURLConnection.disconnect();
            }
        }
        catch (IndexOutOfBoundsException ex) {
            final String value = String.valueOf(ex.getMessage());
            Log.w("HttpUrlPinger", new StringBuilder(String.valueOf(zzsD).length() + 32 + String.valueOf(value).length()).append("Error while parsing ping URL: ").append(zzsD).append(". ").append(value).toString(), (Throwable)ex);
        }
        catch (RuntimeException ex2) {}
        catch (IOException httpURLConnection) {
            goto Label_0172;
        }
    }
}
