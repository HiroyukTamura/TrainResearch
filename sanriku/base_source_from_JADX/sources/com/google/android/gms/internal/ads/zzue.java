package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zzue extends RemoteCreator<zzvx> {
    public zzue() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilderCreator");
        return queryLocalInterface instanceof zzvx ? (zzvx) queryLocalInterface : new zzvw(iBinder);
    }

    public final zzvs zza(Context context, String str, zzalp zzalp) {
        try {
            IBinder zzc = ((zzvx) getRemoteCreatorInstance(context)).zzc(ObjectWrapper.wrap(context), str, zzalp, 201004000);
            if (zzc == null) {
                return null;
            }
            IInterface queryLocalInterface = zzc.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            return queryLocalInterface instanceof zzvs ? (zzvs) queryLocalInterface : new zzvu(zzc);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzazw.zzd("Could not create remote builder for AdLoader.", e);
            return null;
        }
    }
}
