// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.support.annotation.WorkerThread;
import java.util.Iterator;
import com.google.android.gms.common.internal.zzj;
import android.app.PendingIntent;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.Map;

final class zzbcg extends zzbcn
{
    final /* synthetic */ zzbcd zzaDp;
    private final Map<Api.zze, zzbcf> zzaDr;
    
    public zzbcg(final zzbcd zzaDp, final Map<Api.zze, zzbcf> zzaDr) {
        this.zzaDp = zzaDp;
        super(zzaDp, null);
        this.zzaDr = zzaDr;
    }
    
    @WorkerThread
    public final void zzpV() {
        final int n = 1;
        int googlePlayServicesAvailable = 0;
        final Iterator<Api.zze> iterator = this.zzaDr.keySet().iterator();
        int n2 = 1;
        int n3 = 0;
        while (true) {
            while (iterator.hasNext()) {
                final Api.zze zze = iterator.next();
                int n6;
                int n7;
                if (zze.zzpe()) {
                    if (!this.zzaDr.get(zze).zzaCj) {
                        final int n4 = 1;
                        final int n5 = n;
                        if (n5 != 0) {
                            googlePlayServicesAvailable = this.zzaDp.zzaCF.isGooglePlayServicesAvailable(this.zzaDp.mContext);
                        }
                        if (googlePlayServicesAvailable != 0 && (n4 != 0 || n2 != 0)) {
                            this.zzaDp.zzaCZ.zza(new zzbch(this, this.zzaDp, new ConnectionResult(googlePlayServicesAvailable, null)));
                        }
                        else {
                            if (this.zzaDp.zzaDj) {
                                this.zzaDp.zzaDh.connect();
                            }
                            for (final Api.zze zze2 : this.zzaDr.keySet()) {
                                final zzbcf zzbcf = this.zzaDr.get(zze2);
                                if (zze2.zzpe() && googlePlayServicesAvailable != 0) {
                                    this.zzaDp.zzaCZ.zza(new zzbci(this, this.zzaDp, zzbcf));
                                }
                                else {
                                    zze2.zza(zzbcf);
                                }
                            }
                        }
                        return;
                    }
                    n6 = n2;
                    n7 = 1;
                }
                else {
                    final int n8 = 0;
                    n7 = n3;
                    n6 = n8;
                }
                final int n9 = n7;
                n2 = n6;
                n3 = n9;
            }
            final int n5 = n3;
            final int n4 = 0;
            continue;
        }
    }
}
