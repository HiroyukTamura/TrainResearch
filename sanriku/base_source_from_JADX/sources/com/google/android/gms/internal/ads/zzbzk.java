package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzbzk extends zzacq {
    private final zzbzx zzfqb;
    private IObjectWrapper zzfqy;

    public zzbzk(zzbzx zzbzx) {
        this.zzfqb = zzbzx;
    }

    private final float zzakq() {
        try {
            return this.zzfqb.getVideoController().getAspectRatio();
        } catch (RemoteException e) {
            zzazw.zzc("Remote exception getting video controller aspect ratio.", e);
            return 0.0f;
        }
    }

    private static float zzar(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
    }

    public final float getAspectRatio() throws RemoteException {
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzctc)).booleanValue()) {
            return 0.0f;
        }
        if (this.zzfqb.getMediaContentAspectRatio() != 0.0f) {
            return this.zzfqb.getMediaContentAspectRatio();
        }
        if (this.zzfqb.getVideoController() != null) {
            return zzakq();
        }
        IObjectWrapper iObjectWrapper = this.zzfqy;
        if (iObjectWrapper != null) {
            return zzar(iObjectWrapper);
        }
        zzacs zzaky = this.zzfqb.zzaky();
        if (zzaky == null) {
            return 0.0f;
        }
        float width = (zzaky.getWidth() == -1 || zzaky.getHeight() == -1) ? 0.0f : ((float) zzaky.getWidth()) / ((float) zzaky.getHeight());
        return width != 0.0f ? width : zzar(zzaky.zzrv());
    }

    public final float getCurrentTime() throws RemoteException {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzctd)).booleanValue() && this.zzfqb.getVideoController() != null) {
            return this.zzfqb.getVideoController().getCurrentTime();
        }
        return 0.0f;
    }

    public final float getDuration() throws RemoteException {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzctd)).booleanValue() && this.zzfqb.getVideoController() != null) {
            return this.zzfqb.getVideoController().getDuration();
        }
        return 0.0f;
    }

    public final zzxl getVideoController() throws RemoteException {
        if (!((Boolean) zzvj.zzpv().zzd(zzzz.zzctd)).booleanValue()) {
            return null;
        }
        return this.zzfqb.getVideoController();
    }

    public final boolean hasVideoContent() throws RemoteException {
        return ((Boolean) zzvj.zzpv().zzd(zzzz.zzctd)).booleanValue() && this.zzfqb.getVideoController() != null;
    }

    public final void zza(zzaee zzaee) {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzctd)).booleanValue() && (this.zzfqb.getVideoController() instanceof zzbfe)) {
            ((zzbfe) this.zzfqb.getVideoController()).zza(zzaee);
        }
    }

    public final void zzo(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzvj.zzpv().zzd(zzzz.zzcow)).booleanValue()) {
            this.zzfqy = iObjectWrapper;
        }
    }

    public final IObjectWrapper zzry() throws RemoteException {
        IObjectWrapper iObjectWrapper = this.zzfqy;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzacs zzaky = this.zzfqb.zzaky();
        if (zzaky == null) {
            return null;
        }
        return zzaky.zzrv();
    }
}
