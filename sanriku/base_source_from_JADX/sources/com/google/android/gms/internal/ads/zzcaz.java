package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Map;

final /* synthetic */ class zzcaz implements zzaga {
    private final zzcaw zzfua;
    private final zzaer zzfub;

    zzcaz(zzcaw zzcaw, zzaer zzaer) {
        this.zzfua = zzcaw;
        this.zzfub = zzaer;
    }

    public final void zza(Object obj, Map map) {
        zzcaw zzcaw = this.zzfua;
        zzaer zzaer = this.zzfub;
        try {
            zzcaw.zzfty = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
        } catch (NumberFormatException unused) {
            zzazw.zzfa("Failed to call parse unconfirmedClickTimestamp.");
        }
        zzcaw.zzftx = (String) map.get("id");
        String str = (String) map.get("asset_id");
        if (zzaer == null) {
            zzazw.zzed("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzaer.onUnconfirmedClickReceived(str);
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }
}
