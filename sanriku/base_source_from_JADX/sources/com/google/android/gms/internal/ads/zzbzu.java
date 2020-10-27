package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzbzu extends zzxk {
    private final Object lock = new Object();
    private zzxl zzfrv;
    private final zzame zzfrw;

    public zzbzu(zzxl zzxl, zzame zzame) {
        this.zzfrv = zzxl;
        this.zzfrw = zzame;
    }

    public final float getAspectRatio() throws RemoteException {
        throw new RemoteException();
    }

    public final float getCurrentTime() throws RemoteException {
        zzame zzame = this.zzfrw;
        if (zzame != null) {
            return zzame.getVideoCurrentTime();
        }
        return 0.0f;
    }

    public final float getDuration() throws RemoteException {
        zzame zzame = this.zzfrw;
        if (zzame != null) {
            return zzame.getVideoDuration();
        }
        return 0.0f;
    }

    public final int getPlaybackState() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean isClickToExpandEnabled() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean isCustomControlsEnabled() throws RemoteException {
        throw new RemoteException();
    }

    public final boolean isMuted() throws RemoteException {
        throw new RemoteException();
    }

    public final void mute(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    public final void play() throws RemoteException {
        throw new RemoteException();
    }

    public final void stop() throws RemoteException {
        throw new RemoteException();
    }

    public final void zza(zzxm zzxm) throws RemoteException {
        synchronized (this.lock) {
            if (this.zzfrv != null) {
                this.zzfrv.zza(zzxm);
            }
        }
    }

    public final zzxm zzqg() throws RemoteException {
        synchronized (this.lock) {
            if (this.zzfrv == null) {
                return null;
            }
            zzxm zzqg = this.zzfrv.zzqg();
            return zzqg;
        }
    }
}
