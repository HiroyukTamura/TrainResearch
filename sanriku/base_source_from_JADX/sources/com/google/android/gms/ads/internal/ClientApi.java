package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.overlay.zzx;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzacw;
import com.google.android.gms.internal.ads.zzadd;
import com.google.android.gms.internal.ads.zzalp;
import com.google.android.gms.internal.ads.zzapg;
import com.google.android.gms.internal.ads.zzapr;
import com.google.android.gms.internal.ads.zzask;
import com.google.android.gms.internal.ads.zzatf;
import com.google.android.gms.internal.ads.zzazz;
import com.google.android.gms.internal.ads.zzbgy;
import com.google.android.gms.internal.ads.zzcao;
import com.google.android.gms.internal.ads.zzcar;
import com.google.android.gms.internal.ads.zzctg;
import com.google.android.gms.internal.ads.zzcti;
import com.google.android.gms.internal.ads.zzctr;
import com.google.android.gms.internal.ads.zzum;
import com.google.android.gms.internal.ads.zzvs;
import com.google.android.gms.internal.ads.zzvz;
import com.google.android.gms.internal.ads.zzwl;
import com.google.android.gms.internal.ads.zzwp;
import java.util.HashMap;

public class ClientApi extends zzwl {
    public final zzacw zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzcar((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 201004000);
    }

    public final zzadd zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzcao((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    public final zzask zza(IObjectWrapper iObjectWrapper, zzalp zzalp, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbgy.zza(context, zzalp, i).zzadi().zzbw(context).zzaft().zzafr();
    }

    public final zzvs zza(IObjectWrapper iObjectWrapper, String str, zzalp zzalp, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzctg(zzbgy.zza(context, zzalp, i), context, str);
    }

    public final zzvz zza(IObjectWrapper iObjectWrapper, zzum zzum, String str, int i) {
        return new zzl((Context) ObjectWrapper.unwrap(iObjectWrapper), zzum, str, new zzazz(201004000, i, true, false));
    }

    public final zzvz zza(IObjectWrapper iObjectWrapper, zzum zzum, String str, zzalp zzalp, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzcti(zzbgy.zza(context, zzalp, i), context, zzum, str);
    }

    public final zzwp zza(IObjectWrapper iObjectWrapper, int i) {
        return zzbgy.zzf((Context) ObjectWrapper.unwrap(iObjectWrapper), i).zzadb();
    }

    public final zzapg zzb(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zzc = AdOverlayInfoParcel.zzc(activity.getIntent());
        if (zzc == null) {
            return new zzr(activity);
        }
        int i = zzc.zzdky;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? new zzr(activity) : new zzu(activity, zzc) : new zzz(activity) : new zzx(activity) : new zzs(activity);
    }

    public final zzatf zzb(IObjectWrapper iObjectWrapper, String str, zzalp zzalp, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbgy.zza(context, zzalp, i).zzadi().zzbw(context).zzfu(str).zzaft().zzafs();
    }

    public final zzvz zzb(IObjectWrapper iObjectWrapper, zzum zzum, String str, zzalp zzalp, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzctr(zzbgy.zza(context, zzalp, i), context, zzum, str);
    }

    public final zzvz zzc(IObjectWrapper iObjectWrapper, zzum zzum, String str, zzalp zzalp, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbgy.zza(context, zzalp, i).zzade().zzft(str).zzbv(context).zzafd().zzafc();
    }

    public final zzwp zzc(IObjectWrapper iObjectWrapper) {
        return null;
    }

    public final zzapr zzd(IObjectWrapper iObjectWrapper) {
        return null;
    }
}
