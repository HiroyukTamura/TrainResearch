package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzctp implements zzbqx, zzbrc, zzbrp, zzbsm, zzub {
    private zzvm zzgjt;

    public final synchronized void onAdClicked() {
        if (this.zzgjt != null) {
            try {
                this.zzgjt.onAdClicked();
            } catch (RemoteException e) {
                zzazw.zzd("Remote Exception at onAdClicked.", e);
            }
        }
    }

    public final synchronized void onAdClosed() {
        if (this.zzgjt != null) {
            try {
                this.zzgjt.onAdClosed();
            } catch (RemoteException e) {
                zzazw.zzd("Remote Exception at onAdClosed.", e);
            }
        }
    }

    public final synchronized void onAdFailedToLoad(int i) {
        if (this.zzgjt != null) {
            try {
                this.zzgjt.onAdFailedToLoad(i);
            } catch (RemoteException e) {
                zzazw.zzd("Remote Exception at onAdFailedToLoad.", e);
            }
        }
    }

    public final synchronized void onAdImpression() {
        if (this.zzgjt != null) {
            try {
                this.zzgjt.onAdImpression();
            } catch (RemoteException e) {
                zzazw.zzd("Remote Exception at onAdImpression.", e);
            }
        }
    }

    public final synchronized void onAdLeftApplication() {
        if (this.zzgjt != null) {
            try {
                this.zzgjt.onAdLeftApplication();
            } catch (RemoteException e) {
                zzazw.zzd("Remote Exception at onAdLeftApplication.", e);
            }
        }
    }

    public final synchronized void onAdLoaded() {
        if (this.zzgjt != null) {
            try {
                this.zzgjt.onAdLoaded();
            } catch (RemoteException e) {
                zzazw.zzd("Remote Exception at onAdLoaded.", e);
            }
        }
    }

    public final synchronized void onAdOpened() {
        if (this.zzgjt != null) {
            try {
                this.zzgjt.onAdOpened();
            } catch (RemoteException e) {
                zzazw.zzd("Remote Exception at onAdOpened.", e);
            }
        }
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final synchronized zzvm zzapl() {
        return this.zzgjt;
    }

    public final void zzb(zzasd zzasd, String str, String str2) {
    }

    public final synchronized void zzc(zzvm zzvm) {
        this.zzgjt = zzvm;
    }
}
