package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zzasr extends RemoteCreator<zzasl> {
    public zzasr() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        return queryLocalInterface instanceof zzasl ? (zzasl) queryLocalInterface : new zzaso(iBinder);
    }

    public final zzask zza(Context context, zzalp zzalp) {
        try {
            IBinder zzb = ((zzasl) getRemoteCreatorInstance(context)).zzb(ObjectWrapper.wrap(context), zzalp, 201004000);
            if (zzb == null) {
                return null;
            }
            IInterface queryLocalInterface = zzb.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
            return queryLocalInterface instanceof zzask ? (zzask) queryLocalInterface : new zzasm(zzb);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzazw.zzd("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }
}
