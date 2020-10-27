package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.io.IOException;

final /* synthetic */ class zzsq implements Runnable {
    private final zzsn zzbsz;
    private final zzsg zzbta;
    private final zzsf zzbtb;
    private final zzbaj zzbtc;

    zzsq(zzsn zzsn, zzsg zzsg, zzsf zzsf, zzbaj zzbaj) {
        this.zzbsz = zzsn;
        this.zzbta = zzsg;
        this.zzbtb = zzsf;
        this.zzbtc = zzbaj;
    }

    public final void run() {
        zzsn zzsn = this.zzbsz;
        zzsg zzsg = this.zzbta;
        zzsf zzsf = this.zzbtb;
        zzbaj zzbaj = this.zzbtc;
        try {
            zzse zza = zzsg.zzmy().zza(zzsf);
            if (!zza.zzmv()) {
                zzbaj.setException(new RuntimeException("No entry contents."));
                zzsn.zzbsw.disconnect();
                return;
            }
            zzss zzss = new zzss(zzsn, zza.zzmw(), 1);
            int read = zzss.read();
            if (read != -1) {
                zzss.unread(read);
                zzbaj.set(zzss);
                return;
            }
            throw new IOException("Unable to read from cache.");
        } catch (RemoteException | IOException e) {
            zzazw.zzc("Unable to obtain a cache service instance.", e);
            zzbaj.setException(e);
            zzsn.zzbsw.disconnect();
        }
    }
}
