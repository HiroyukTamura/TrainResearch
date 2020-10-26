// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.net.NetworkInfo;
import android.net.ConnectivityManager;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.internal.zzbo;
import java.util.Map;
import java.net.URL;
import android.content.Context;
import android.support.annotation.WorkerThread;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;

public final class zzcfp extends zzchj
{
    public zzcfp(final zzcgl zzcgl) {
        super(zzcgl);
    }
    
    @WorkerThread
    private static byte[] zzc(final HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream2;
        final InputStream inputStream = inputStream2 = null;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream2 = inputStream;
            final InputStream inputStream3 = inputStream2 = httpURLConnection.getInputStream();
            final byte[] array = new byte[1024];
            while (true) {
                inputStream2 = inputStream3;
                final int read = inputStream3.read(array);
                if (read <= 0) {
                    break;
                }
                inputStream2 = inputStream3;
                byteArrayOutputStream.write(array, 0, read);
            }
        }
        finally {
            if (inputStream2 != null) {
                inputStream2.close();
            }
        }
        final byte[] byteArray = byteArrayOutputStream.toByteArray();
        final InputStream inputStream4;
        if (inputStream4 != null) {
            inputStream4.close();
        }
        return byteArray;
    }
    
    @WorkerThread
    public final void zza(final String s, final URL url, final Map<String, String> map, final zzcfr zzcfr) {
        super.zzjC();
        this.zzkD();
        zzbo.zzu(url);
        zzbo.zzu(zzcfr);
        super.zzwE().zzk(new zzcft(s, url, null, map, zzcfr));
    }
    
    @WorkerThread
    public final void zza(final String s, final URL url, final byte[] array, final Map<String, String> map, final zzcfr zzcfr) {
        super.zzjC();
        this.zzkD();
        zzbo.zzu(url);
        zzbo.zzu(array);
        zzbo.zzu(zzcfr);
        super.zzwE().zzk(new zzcft(s, url, array, null, zzcfr));
    }
    
    @Override
    protected final void zzjD() {
    }
    
    public final boolean zzlQ() {
        this.zzkD();
        final ConnectivityManager connectivityManager = (ConnectivityManager)super.getContext().getSystemService("connectivity");
        while (true) {
            try {
                final NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    return true;
                }
            }
            catch (SecurityException ex) {
                final NetworkInfo activeNetworkInfo = null;
                continue;
            }
            break;
        }
        return false;
    }
}
