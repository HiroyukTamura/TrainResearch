package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzamj extends zzxk {
    private final Object lock = new Object();
    private volatile zzxm zzdgn;

    public final float getAspectRatio() throws RemoteException {
        throw new RemoteException();
    }

    public final float getCurrentTime() throws RemoteException {
        throw new RemoteException();
    }

    public final float getDuration() throws RemoteException {
        throw new RemoteException();
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
            this.zzdgn = zzxm;
        }
    }

    public final zzxm zzqg() throws RemoteException {
        zzxm zzxm;
        synchronized (this.lock) {
            zzxm = this.zzdgn;
        }
        return zzxm;
    }
}
