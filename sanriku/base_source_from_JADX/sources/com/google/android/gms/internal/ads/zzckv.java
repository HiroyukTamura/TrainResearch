package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzq;
import java.io.InputStream;

public final class zzckv extends zzckt {
    public zzckv(Context context) {
        this.zzgbu = new zzaqr(context, zzq.zzlk().zzxx(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        zzbaj<InputStream> zzbaj;
        zzclc zzclc;
        synchronized (this.mLock) {
            if (!this.zzgbs) {
                this.zzgbs = true;
                try {
                    this.zzgbu.zzus().zzb(this.zzgbt, new zzcks(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    zzbaj = this.zzdej;
                    zzclc = new zzclc(0);
                } catch (Throwable th) {
                    zzq.zzla().zza(th, "RemoteSignalsClientTask.onConnected");
                    zzbaj = this.zzdej;
                    zzclc = new zzclc(0);
                }
            }
        }
        zzbaj.setException(zzclc);
    }

    public final zzdri<InputStream> zzh(zzarj zzarj) {
        synchronized (this.mLock) {
            if (this.zzgbr) {
                zzbaj<InputStream> zzbaj = this.zzdej;
                return zzbaj;
            }
            this.zzgbr = true;
            this.zzgbt = zzarj;
            this.zzgbu.checkAvailabilityAndConnect();
            this.zzdej.addListener(new zzcku(this), zzbab.zzdzw);
            zzbaj<InputStream> zzbaj2 = this.zzdej;
            return zzbaj2;
        }
    }
}
