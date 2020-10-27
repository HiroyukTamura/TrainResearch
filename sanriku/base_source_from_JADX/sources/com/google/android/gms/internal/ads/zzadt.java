package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;
import java.util.WeakHashMap;

public final class zzadt implements NativeCustomTemplateAd {
    private static WeakHashMap<IBinder, zzadt> zzczf = new WeakHashMap<>();
    private final VideoController zzcgy = new VideoController();
    private final zzado zzczg;
    private final MediaView zzczh;
    private NativeCustomTemplateAd.DisplayOpenMeasurement zzczi;

    @VisibleForTesting
    private zzadt(zzado zzado) {
        Context context;
        this.zzczg = zzado;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.unwrap(zzado.zzse());
        } catch (RemoteException | NullPointerException e) {
            zzazw.zzc("", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (this.zzczg.zzp(ObjectWrapper.wrap(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e2) {
                zzazw.zzc("", e2);
            }
        }
        this.zzczh = mediaView;
    }

    public static zzadt zza(zzado zzado) {
        synchronized (zzczf) {
            zzadt zzadt = zzczf.get(zzado.asBinder());
            if (zzadt != null) {
                return zzadt;
            }
            zzadt zzadt2 = new zzadt(zzado);
            zzczf.put(zzado.asBinder(), zzadt2);
            return zzadt2;
        }
    }

    public final void destroy() {
        try {
            this.zzczg.destroy();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final List<String> getAvailableAssetNames() {
        try {
            return this.zzczg.getAvailableAssetNames();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final String getCustomTemplateId() {
        try {
            return this.zzczg.getCustomTemplateId();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final NativeCustomTemplateAd.DisplayOpenMeasurement getDisplayOpenMeasurement() {
        try {
            if (this.zzczi == null && this.zzczg.zzsf()) {
                this.zzczi = new zzaco(this.zzczg);
            }
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
        return this.zzczi;
    }

    public final NativeAd.Image getImage(String str) {
        try {
            zzacs zzcw = this.zzczg.zzcw(str);
            if (zzcw != null) {
                return new zzacx(zzcw);
            }
            return null;
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final CharSequence getText(String str) {
        try {
            return this.zzczg.zzcv(str);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            zzxl videoController = this.zzczg.getVideoController();
            if (videoController != null) {
                this.zzcgy.zza(videoController);
            }
        } catch (RemoteException e) {
            zzazw.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcgy;
    }

    public final MediaView getVideoMediaView() {
        return this.zzczh;
    }

    public final void performClick(String str) {
        try {
            this.zzczg.performClick(str);
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final void recordImpression() {
        try {
            this.zzczg.recordImpression();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final zzado zzsi() {
        return this.zzczg;
    }
}
