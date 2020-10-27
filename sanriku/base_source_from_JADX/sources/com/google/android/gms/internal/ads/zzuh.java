package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zzuh extends RemoteCreator<zzwa> {
    @VisibleForTesting
    public zzuh() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        return queryLocalInterface instanceof zzwa ? (zzwa) queryLocalInterface : new zzwd(iBinder);
    }

    public final zzvz zza(Context context, zzum zzum, String str, zzalp zzalp, int i) {
        try {
            IBinder zza = ((zzwa) getRemoteCreatorInstance(context)).zza(ObjectWrapper.wrap(context), zzum, str, zzalp, 201004000, i);
            if (zza == null) {
                return null;
            }
            IInterface queryLocalInterface = zza.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            return queryLocalInterface instanceof zzvz ? (zzvz) queryLocalInterface : new zzwb(zza);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzazw.zzb("Could not create remote AdManager.", e);
            return null;
        }
    }
}
