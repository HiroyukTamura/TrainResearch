package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public class zzcqz extends zzcsb {
    private zzbwd zzggz;

    public zzcqz(zzbqw zzbqw, zzbro zzbro, zzbrx zzbrx, zzbsh zzbsh, zzbre zzbre, zzbtw zzbtw, zzbwi zzbwi, zzbsu zzbsu, zzbwd zzbwd, zzbtp zzbtp) {
        super(zzbqw, zzbro, zzbrx, zzbsh, zzbtw, zzbsu, zzbwi, zzbtp, zzbre);
        this.zzggz = zzbwd;
    }

    public final void onVideoEnd() {
        this.zzggz.zzsn();
    }

    public final void zza(zzate zzate) throws RemoteException {
        super.zza(zzate);
        this.zzggz.zza(new zzatc(zzate.getType(), zzate.getAmount()));
    }

    public final void zzb(zzatc zzatc) {
        super.zzb(zzatc);
        this.zzggz.zza(zzatc);
    }

    public final void zztp() {
        this.zzggz.zzsm();
    }

    public final void zztq() throws RemoteException {
        this.zzggz.zzsn();
    }
}
