package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zztc {
    private final byte[] zzbvi;
    private int zzbvj;
    private int zzbvk;
    private final /* synthetic */ zzsy zzbvl;

    private zztc(zzsy zzsy, byte[] bArr) {
        this.zzbvl = zzsy;
        this.zzbvi = bArr;
    }

    public final zztc zzbr(int i) {
        this.zzbvj = i;
        return this;
    }

    public final zztc zzbs(int i) {
        this.zzbvk = i;
        return this;
    }

    public final synchronized void zzdx() {
        try {
            if (this.zzbvl.zzbvg) {
                this.zzbvl.zzbvf.zzc(this.zzbvi);
                this.zzbvl.zzbvf.zzo(this.zzbvj);
                this.zzbvl.zzbvf.zzp(this.zzbvk);
                this.zzbvl.zzbvf.zza((int[]) null);
                this.zzbvl.zzbvf.zzdx();
            }
        } catch (RemoteException e) {
            zzazw.zzb("Clearcut log failed", e);
        }
    }
}
