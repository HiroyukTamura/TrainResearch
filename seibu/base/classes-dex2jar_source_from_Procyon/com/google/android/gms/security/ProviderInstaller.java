// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.security;

import android.content.Intent;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import android.util.Log;
import com.google.android.gms.common.zzo;
import com.google.android.gms.common.internal.zzbo;
import android.content.Context;
import java.lang.reflect.Method;
import com.google.android.gms.common.zze;

public class ProviderInstaller
{
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static final zze zzbCG;
    private static Method zzbCH;
    private static final Object zzuF;
    
    static {
        zzbCG = zze.zzoW();
        zzuF = new Object();
        ProviderInstaller.zzbCH = null;
    }
    
    public static void installIfNeeded(Context remoteContext) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zzbo.zzb(remoteContext, "Context must not be null");
        zze.zzas(remoteContext);
        remoteContext = zzo.getRemoteContext(remoteContext);
        if (remoteContext == null) {
            Log.e("ProviderInstaller", "Failed to get remote context");
            throw new GooglePlayServicesNotAvailableException(8);
        }
        while (true) {
            final Object zzuF = ProviderInstaller.zzuF;
            // monitorenter(zzuF)
            while (true) {
                try {
                    if (ProviderInstaller.zzbCH == null) {
                        ProviderInstaller.zzbCH = remoteContext.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", Context.class);
                    }
                    ProviderInstaller.zzbCH.invoke(null, remoteContext);
                    return;
                }
                catch (Exception ex) {
                    final String value = String.valueOf(ex.getMessage());
                    if (value.length() != 0) {
                        final String concat = "Failed to install provider: ".concat(value);
                        Log.e("ProviderInstaller", concat);
                        throw new GooglePlayServicesNotAvailableException(8);
                    }
                    try {}
                    finally {
                    }
                    // monitorexit(zzuF)
                }
                final String concat = new String("Failed to install provider: ");
                continue;
            }
        }
    }
    
    public static void installIfNeededAsync(final Context context, final ProviderInstallListener providerInstallListener) {
        zzbo.zzb(context, "Context must not be null");
        zzbo.zzb(providerInstallListener, "Listener must not be null");
        zzbo.zzcz("Must be called on the UI thread");
        new zza(context, providerInstallListener).execute((Object[])new Void[0]);
    }
    
    public interface ProviderInstallListener
    {
        void onProviderInstallFailed(final int p0, final Intent p1);
        
        void onProviderInstalled();
    }
}
