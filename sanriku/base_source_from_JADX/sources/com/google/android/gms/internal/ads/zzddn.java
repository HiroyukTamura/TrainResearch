package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

public final class zzddn implements zzbrc, zzbsr, zzder {
    private final zzdih zzgqx;
    private final AtomicReference<zzrn> zzgqy = new AtomicReference<>();
    private final AtomicReference<zzrs> zzgqz = new AtomicReference<>();
    private final AtomicReference<zzbsr> zzgra = new AtomicReference<>();
    private zzddn zzgrb = null;

    public zzddn(zzdih zzdih) {
        this.zzgqx = zzdih;
    }

    public static zzddn zza(zzddn zzddn) {
        zzddn zzddn2 = new zzddn(zzddn.zzgqx);
        zzddn2.zzb((zzder) zzddn);
        return zzddn2;
    }

    public final void onAdClosed() {
        zzddn zzddn = this;
        while (true) {
            zzddn zzddn2 = zzddn.zzgrb;
            if (zzddn2 != null) {
                zzddn = zzddn2;
            } else {
                zzddn.zzgqx.onAdClosed();
                zzdek.zza(zzddn.zzgqz, zzdds.zzgrd);
                return;
            }
        }
    }

    public final void onAdFailedToLoad(int i) {
        zzddn zzddn = this;
        while (true) {
            zzddn zzddn2 = zzddn.zzgrb;
            if (zzddn2 != null) {
                zzddn = zzddn2;
            } else {
                zzdek.zza(zzddn.zzgqy, new zzddp(i));
                return;
            }
        }
    }

    public final void zza(zzbsr zzbsr) {
        this.zzgra.set(zzbsr);
    }

    public final void zzait() {
        zzddn zzddn = this;
        while (true) {
            zzddn zzddn2 = zzddn.zzgrb;
            if (zzddn2 != null) {
                zzddn = zzddn2;
            } else {
                zzdek.zza(zzddn.zzgra, zzddr.zzgrd);
                return;
            }
        }
    }

    public final void zzb(zzder zzder) {
        this.zzgrb = (zzddn) zzder;
    }

    public final void zzb(zzrm zzrm) {
        zzddn zzddn = this;
        while (true) {
            zzddn zzddn2 = zzddn.zzgrb;
            if (zzddn2 != null) {
                zzddn = zzddn2;
            } else {
                zzdek.zza(zzddn.zzgqy, new zzddq(zzrm));
                return;
            }
        }
    }

    public final void zzb(zzrn zzrn) {
        this.zzgqy.set(zzrn);
    }

    public final void zzb(zzrs zzrs) {
        this.zzgqz.set(zzrs);
    }
}
