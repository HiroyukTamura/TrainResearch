package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.instream.InstreamAd;
import com.google.android.gms.common.internal.Preconditions;

public final class zzaid {
    private final zzvs zzabz;
    private final Context zzvf;

    private zzaid(Context context, zzvs zzvs) {
        this.zzvf = context;
        this.zzabz = zzvs;
    }

    public zzaid(Context context, String str) {
        this((Context) Preconditions.checkNotNull(context, "context cannot be null"), zzvj.zzps().zzb(context, str, new zzalm()));
    }

    public final zzaid zza(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        try {
            this.zzabz.zza((zzahu) new zzaib(instreamAdLoadCallback));
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
        return this;
    }

    public final zzaid zza(zzahy zzahy) {
        try {
            this.zzabz.zza(new zzahm(zzahy));
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
        }
        return this;
    }

    public final zzaia zzst() {
        try {
            return new zzaia(this.zzvf, this.zzabz.zzqa());
        } catch (RemoteException e) {
            zzazw.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
