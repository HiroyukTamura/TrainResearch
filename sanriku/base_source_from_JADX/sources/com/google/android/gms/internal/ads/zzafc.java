package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzafc extends zzaej {
    /* access modifiers changed from: private */
    public final OnPublisherAdViewLoadedListener zzczo;

    public zzafc(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.zzczo = onPublisherAdViewLoadedListener;
    }

    public final void zza(zzvz zzvz, IObjectWrapper iObjectWrapper) {
        if (zzvz != null && iObjectWrapper != null) {
            PublisherAdView publisherAdView = new PublisherAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
            AppEventListener appEventListener = null;
            try {
                if (zzvz.zzkk() instanceof zzuf) {
                    zzuf zzuf = (zzuf) zzvz.zzkk();
                    publisherAdView.setAdListener(zzuf != null ? zzuf.getAdListener() : null);
                }
            } catch (RemoteException e) {
                zzazw.zzc("", e);
            }
            try {
                if (zzvz.zzkj() instanceof zzuq) {
                    zzuq zzuq = (zzuq) zzvz.zzkj();
                    if (zzuq != null) {
                        appEventListener = zzuq.getAppEventListener();
                    }
                    publisherAdView.setAppEventListener(appEventListener);
                }
            } catch (RemoteException e2) {
                zzazw.zzc("", e2);
            }
            zzazm.zzzn.post(new zzaff(this, publisherAdView, zzvz));
        }
    }
}
