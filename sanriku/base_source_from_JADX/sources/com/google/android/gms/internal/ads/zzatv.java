package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzatv {
    public static zzatf zzd(Context context, String str, zzalp zzalp) {
        try {
            IBinder zzd = ((zzatl) zzazv.zza(context, "com.google.android.gms.ads.rewarded.ChimeraRewardedAdCreatorImpl", zzaty.zzbvh)).zzd(ObjectWrapper.wrap(context), str, zzalp, 201004000);
            if (zzd == null) {
                return null;
            }
            IInterface queryLocalInterface = zzd.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
            return queryLocalInterface instanceof zzatf ? (zzatf) queryLocalInterface : new zzath(zzd);
        } catch (RemoteException | zzazx e) {
            zzazw.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
