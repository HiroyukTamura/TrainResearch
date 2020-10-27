package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zzyj extends RemoteCreator<zzwq> {
    public zzyj() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        return queryLocalInterface instanceof zzwq ? (zzwq) queryLocalInterface : new zzwt(iBinder);
    }

    public final zzwp zzh(Context context) {
        try {
            IBinder zzb = ((zzwq) getRemoteCreatorInstance(context)).zzb(ObjectWrapper.wrap(context), 201004000);
            if (zzb == null) {
                return null;
            }
            IInterface queryLocalInterface = zzb.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            return queryLocalInterface instanceof zzwp ? (zzwp) queryLocalInterface : new zzwr(zzb);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e) {
            zzazw.zzd("Could not get remote MobileAdsSettingManager.", e);
            return null;
        }
    }
}
