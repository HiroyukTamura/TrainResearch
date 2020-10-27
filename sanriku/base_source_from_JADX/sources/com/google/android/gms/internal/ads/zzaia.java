package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;

public final class zzaia {
    private final zzuk zzaca;
    private final zzvr zzacb;
    private final Context zzvf;

    zzaia(Context context, zzvr zzvr) {
        this(context, zzvr, zzuk.zzcev);
    }

    private zzaia(Context context, zzvr zzvr, zzuk zzuk) {
        this.zzvf = context;
        this.zzacb = zzvr;
        this.zzaca = zzuk;
    }

    private final void zza(zzxt zzxt) {
        try {
            this.zzacb.zzb(zzuk.zza(this.zzvf, zzxt));
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(AdRequest adRequest) {
        zza(adRequest.zzdq());
    }

    @RequiresPermission("android.permission.INTERNET")
    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzdq());
    }
}
