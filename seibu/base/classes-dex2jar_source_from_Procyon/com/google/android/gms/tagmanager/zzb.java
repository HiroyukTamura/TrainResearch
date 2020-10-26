// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

final class zzb implements zzd
{
    private /* synthetic */ zza zzbDm;
    
    zzb(final zza zzbDm) {
        this.zzbDm = zzbDm;
    }
    
    @Override
    public final AdvertisingIdClient.Info zzAD() {
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(this.zzbDm.mContext);
        }
        catch (IllegalStateException ex) {
            zzdj.zzc("IllegalStateException getting Advertising Id Info", ex);
            return null;
        }
        catch (GooglePlayServicesRepairableException ex2) {
            zzdj.zzc("GooglePlayServicesRepairableException getting Advertising Id Info", ex2);
            return null;
        }
        catch (IOException ex3) {
            zzdj.zzc("IOException getting Ad Id Info", ex3);
            return null;
        }
        catch (GooglePlayServicesNotAvailableException ex4) {
            zzdj.zzc("GooglePlayServicesNotAvailableException getting Advertising Id Info", ex4);
            return null;
        }
        catch (Exception ex5) {
            zzdj.zzc("Unknown exception. Could not get the Advertising Id Info.", ex5);
            return null;
        }
    }
}
