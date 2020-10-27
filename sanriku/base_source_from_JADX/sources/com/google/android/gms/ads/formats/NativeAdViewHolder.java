package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzadd;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzvj;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> zzblg = new WeakHashMap<>();
    private zzadd zzblf;
    private WeakReference<View> zzblh;

    public NativeAdViewHolder(View view, Map<String, View> map, Map<String, View> map2) {
        Preconditions.checkNotNull(view, "ContainerView must not be null");
        if ((view instanceof NativeAdView) || (view instanceof UnifiedNativeAdView)) {
            zzazw.zzfa("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
        } else if (zzblg.get(view) != null) {
            zzazw.zzfa("The provided containerView is already in use with another NativeAdViewHolder.");
        } else {
            zzblg.put(view, this);
            this.zzblh = new WeakReference<>(view);
            this.zzblf = zzvj.zzps().zza(view, zzb(map), zzb(map2));
        }
    }

    private final void zza(IObjectWrapper iObjectWrapper) {
        WeakReference<View> weakReference = this.zzblh;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view == null) {
            zzazw.zzfc("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zzblg.containsKey(view)) {
            zzblg.put(view, this);
        }
        zzadd zzadd = this.zzblf;
        if (zzadd != null) {
            try {
                zzadd.zza(iObjectWrapper);
            } catch (RemoteException e) {
                zzazw.zzc("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    private static HashMap<String, View> zzb(Map<String, View> map) {
        return map == null ? new HashMap<>() : new HashMap<>(map);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzblf.zze(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzazw.zzc("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setNativeAd(NativeAd nativeAd) {
        zza((IObjectWrapper) nativeAd.zzjq());
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        zza((IObjectWrapper) unifiedNativeAd.zzjq());
    }

    public final void unregisterNativeAd() {
        zzadd zzadd = this.zzblf;
        if (zzadd != null) {
            try {
                zzadd.unregisterNativeAd();
            } catch (RemoteException e) {
                zzazw.zzc("Unable to call unregisterNativeAd on delegate", e);
            }
        }
        WeakReference<View> weakReference = this.zzblh;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null) {
            zzblg.remove(view);
        }
    }
}
