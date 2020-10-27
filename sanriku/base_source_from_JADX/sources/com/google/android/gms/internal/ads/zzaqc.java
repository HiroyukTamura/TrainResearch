package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzaqc {
    @Nullable
    private final zzxt zzacc;
    private final AdFormat zzdlh;
    private final Context zzvf;

    public zzaqc(Context context, AdFormat adFormat, @Nullable zzxt zzxt) {
        this.zzvf = context;
        this.zzdlh = adFormat;
        this.zzacc = zzxt;
    }

    @Nullable
    public static zzavn zzr(Context context) {
        try {
            return ((zzavs) zzazv.zza(context, "com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl", zzaqb.zzbvh)).zzf(ObjectWrapper.wrap(context), 201004000);
        } catch (RemoteException | zzazx | NullPointerException unused) {
            return null;
        }
    }

    public final void zza(QueryInfoGenerationCallback queryInfoGenerationCallback) {
        zzavn zzr = zzr(this.zzvf);
        if (zzr == null) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
            return;
        }
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzvf);
        zzxt zzxt = this.zzacc;
        try {
            zzr.zza(wrap, new zzavt((String) null, this.zzdlh.name(), (zzum) null, zzxt == null ? new zzui().zzpg() : zzuk.zza(this.zzvf, zzxt)), (zzavm) new zzaqe(this, queryInfoGenerationCallback));
        } catch (RemoteException unused) {
            queryInfoGenerationCallback.onFailure("Internal Error.");
        }
    }
}
