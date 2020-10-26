// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.security;

import com.google.android.gms.common.zze;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import android.content.Context;
import android.os.AsyncTask;

final class zza extends AsyncTask<Void, Void, Integer>
{
    private /* synthetic */ ProviderInstaller.ProviderInstallListener zzbCI;
    private /* synthetic */ Context zztF;
    
    zza(final Context zztF, final ProviderInstaller.ProviderInstallListener zzbCI) {
        this.zztF = zztF;
        this.zzbCI = zzbCI;
    }
    
    private final Integer zzb(final Void... array) {
        try {
            ProviderInstaller.installIfNeeded(this.zztF);
            return 0;
        }
        catch (GooglePlayServicesRepairableException ex) {
            return ex.getConnectionStatusCode();
        }
        catch (GooglePlayServicesNotAvailableException ex2) {
            return ex2.errorCode;
        }
    }
}
