// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.content.pm.PackageManager$NameNotFoundException;
import org.apache.http.client.HttpClient;
import android.net.http.AndroidHttpClient;
import android.os.Build$VERSION;
import java.io.File;
import android.content.Context;

public final class zzas
{
    public static zzs zza(final Context context, zzan zzan) {
        final File file = new File(context.getCacheDir(), "volley");
        zzan = (zzan)"volley/0";
        while (true) {
            try {
                final String packageName = context.getPackageName();
                final Object string = new StringBuilder(String.valueOf(packageName).length() + 12).append(packageName).append("/").append(context.getPackageManager().getPackageInfo(packageName, 0).versionCode).toString();
                zzan zzan2;
                if (Build$VERSION.SDK_INT >= 9) {
                    zzan2 = new zzao();
                }
                else {
                    zzan2 = new zzak((HttpClient)AndroidHttpClient.newInstance((String)string));
                }
                final zzs zzs = new zzs(new zzag(file), new zzad(zzan2));
                zzs.start();
                return zzs;
            }
            catch (PackageManager$NameNotFoundException ex) {
                final Object string = zzan;
                continue;
            }
            break;
        }
    }
}
