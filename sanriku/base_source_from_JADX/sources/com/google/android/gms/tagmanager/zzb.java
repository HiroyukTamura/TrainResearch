package com.google.android.gms.tagmanager;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

final class zzb implements zzd {
    private final /* synthetic */ zza zzads;

    zzb(zza zza) {
        this.zzads = zza;
    }

    public final AdvertisingIdClient.Info zzgv() {
        String str;
        try {
            return AdvertisingIdClient.getAdvertisingIdInfo(this.zzads.zzrm);
        } catch (IllegalStateException e) {
            e = e;
            str = "IllegalStateException getting Advertising Id Info";
            zzdi.zzb(str, e);
            return null;
        } catch (GooglePlayServicesRepairableException e2) {
            e = e2;
            str = "GooglePlayServicesRepairableException getting Advertising Id Info";
            zzdi.zzb(str, e);
            return null;
        } catch (IOException e3) {
            e = e3;
            str = "IOException getting Ad Id Info";
            zzdi.zzb(str, e);
            return null;
        } catch (GooglePlayServicesNotAvailableException e4) {
            e = e4;
            this.zzads.close();
            str = "GooglePlayServicesNotAvailableException getting Advertising Id Info";
            zzdi.zzb(str, e);
            return null;
        } catch (Exception e5) {
            e = e5;
            str = "Unknown exception. Could not get the Advertising Id Info.";
            zzdi.zzb(str, e);
            return null;
        }
    }
}
