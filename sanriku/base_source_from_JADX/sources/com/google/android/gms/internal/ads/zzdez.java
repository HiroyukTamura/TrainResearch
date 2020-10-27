package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.concurrent.atomic.AtomicReference;

public final class zzdez extends AdMetadataListener implements zzbqx, zzbrc, zzbrl, zzbsm, zzbtb, zzder {
    private final zzdih zzgqx;
    private final AtomicReference<AdMetadataListener> zzgsj = new AtomicReference<>();
    private final AtomicReference<zzatn> zzgsk = new AtomicReference<>();
    private final AtomicReference<zzatk> zzgsl = new AtomicReference<>();
    private final AtomicReference<zzasn> zzgsm = new AtomicReference<>();
    private final AtomicReference<zzats> zzgsn = new AtomicReference<>();
    private final AtomicReference<zzasi> zzgso = new AtomicReference<>();
    private final AtomicReference<zzxf> zzgsp = new AtomicReference<>();
    private zzdez zzgsq = null;

    public zzdez(zzdih zzdih) {
        this.zzgqx = zzdih;
    }

    public static zzdez zza(zzdez zzdez) {
        zzdez zzdez2 = new zzdez(zzdez.zzgqx);
        zzdez2.zzb((zzder) zzdez);
        return zzdez2;
    }

    public final void onAdClosed() {
        zzdez zzdez = this;
        while (true) {
            zzdez zzdez2 = zzdez.zzgsq;
            if (zzdez2 != null) {
                zzdez = zzdez2;
            } else {
                zzdez.zzgqx.onAdClosed();
                zzdek.zza(zzdez.zzgsl, zzdfq.zzgrd);
                zzdek.zza(zzdez.zzgsm, zzdfp.zzgrd);
                return;
            }
        }
    }

    public final void onAdFailedToLoad(int i) {
        zzdez zzdez = this;
        while (true) {
            zzdez zzdez2 = zzdez.zzgsq;
            if (zzdez2 != null) {
                zzdez = zzdez2;
            } else {
                zzdek.zza(zzdez.zzgsk, new zzdfm(i));
                zzdek.zza(zzdez.zzgsm, new zzdfl(i));
                return;
            }
        }
    }

    public final void onAdLeftApplication() {
        zzdez zzdez = this;
        while (true) {
            zzdez zzdez2 = zzdez.zzgsq;
            if (zzdez2 != null) {
                zzdez = zzdez2;
            } else {
                zzdek.zza(zzdez.zzgsm, zzdfs.zzgrd);
                return;
            }
        }
    }

    public final void onAdLoaded() {
        zzdez zzdez = this;
        while (true) {
            zzdez zzdez2 = zzdez.zzgsq;
            if (zzdez2 != null) {
                zzdez = zzdez2;
            } else {
                zzdek.zza(zzdez.zzgsk, zzdfc.zzgrd);
                zzdek.zza(zzdez.zzgsm, zzdfb.zzgrd);
                return;
            }
        }
    }

    public final void onAdMetadataChanged() {
        zzdez zzdez = this.zzgsq;
        if (zzdez != null) {
            zzdez.onAdMetadataChanged();
        } else {
            zzdek.zza(this.zzgsj, zzdfk.zzgrd);
        }
    }

    public final void onAdOpened() {
        zzdez zzdez = this;
        while (true) {
            zzdez zzdez2 = zzdez.zzgsq;
            if (zzdez2 != null) {
                zzdez = zzdez2;
            } else {
                zzdek.zza(zzdez.zzgsl, zzdfo.zzgrd);
                zzdek.zza(zzdez.zzgsm, zzdfn.zzgrd);
                return;
            }
        }
    }

    public final void onRewardedVideoCompleted() {
        zzdez zzdez = this;
        while (true) {
            zzdez zzdez2 = zzdez.zzgsq;
            if (zzdez2 != null) {
                zzdez = zzdez2;
            } else {
                zzdek.zza(zzdez.zzgsm, zzdfi.zzgrd);
                return;
            }
        }
    }

    public final void onRewardedVideoStarted() {
        zzdez zzdez = this;
        while (true) {
            zzdez zzdez2 = zzdez.zzgsq;
            if (zzdez2 != null) {
                zzdez = zzdez2;
            } else {
                zzdek.zza(zzdez.zzgsm, zzdfr.zzgrd);
                return;
            }
        }
    }

    public final void zza(AdMetadataListener adMetadataListener) {
        this.zzgsj.set(adMetadataListener);
    }

    public final void zzb(zzasd zzasd, String str, String str2) {
        zzdez zzdez = this;
        while (true) {
            zzdez zzdez2 = zzdez.zzgsq;
            if (zzdez2 != null) {
                zzdez = zzdez2;
            } else {
                zzdek.zza(zzdez.zzgsl, new zzdfe(zzasd));
                zzdek.zza(zzdez.zzgsn, new zzdfd(zzasd, str, str2));
                zzdek.zza(zzdez.zzgsm, new zzdfg(zzasd));
                zzdek.zza(zzdez.zzgso, new zzdff(zzasd, str, str2));
                return;
            }
        }
    }

    @Deprecated
    public final void zzb(zzasi zzasi) {
        this.zzgso.set(zzasi);
    }

    @Deprecated
    public final void zzb(zzasn zzasn) {
        this.zzgsm.set(zzasn);
    }

    public final void zzb(zzatk zzatk) {
        this.zzgsl.set(zzatk);
    }

    public final void zzb(zzatn zzatn) {
        this.zzgsk.set(zzatn);
    }

    public final void zzb(zzats zzats) {
        this.zzgsn.set(zzats);
    }

    public final void zzb(zzder zzder) {
        this.zzgsq = (zzdez) zzder;
    }

    public final void zzb(@NonNull zzuo zzuo) {
        zzdez zzdez = this;
        while (true) {
            zzdez zzdez2 = zzdez.zzgsq;
            if (zzdez2 != null) {
                zzdez = zzdez2;
            } else {
                zzdek.zza(zzdez.zzgsp, new zzdfj(zzuo));
                return;
            }
        }
    }

    public final void zzc(zzxf zzxf) {
        this.zzgsp.set(zzxf);
    }

    public final void zzcx(int i) {
        zzdez zzdez = this;
        while (true) {
            zzdez zzdez2 = zzdez.zzgsq;
            if (zzdez2 != null) {
                zzdez = zzdez2;
            } else {
                zzdek.zza(zzdez.zzgsl, new zzdfh(i));
                return;
            }
        }
    }
}
