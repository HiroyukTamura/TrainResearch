package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzyg implements MediaContent {
    private final VideoController zzcgy = new VideoController();
    private final zzacr zzchr;

    public zzyg(zzacr zzacr) {
        this.zzchr = zzacr;
    }

    public final float getAspectRatio() {
        try {
            return this.zzchr.getAspectRatio();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return 0.0f;
        }
    }

    public final float getCurrentTime() {
        try {
            return this.zzchr.getCurrentTime();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return 0.0f;
        }
    }

    public final float getDuration() {
        try {
            return this.zzchr.getDuration();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return 0.0f;
        }
    }

    public final Drawable getMainImage() {
        try {
            IObjectWrapper zzry = this.zzchr.zzry();
            if (zzry != null) {
                return (Drawable) ObjectWrapper.unwrap(zzry);
            }
            return null;
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zzchr.getVideoController() != null) {
                this.zzcgy.zza(this.zzchr.getVideoController());
            }
        } catch (RemoteException e) {
            zzazw.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcgy;
    }

    public final boolean hasVideoContent() {
        try {
            return this.zzchr.hasVideoContent();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return false;
        }
    }

    public final void setMainImage(Drawable drawable) {
        try {
            this.zzchr.zzo(ObjectWrapper.wrap(drawable));
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final zzacr zzqr() {
        return this.zzchr;
    }
}
