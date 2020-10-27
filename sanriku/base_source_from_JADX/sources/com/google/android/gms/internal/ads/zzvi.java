package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

public class zzvi extends AdListener {
    private final Object lock = new Object();
    private AdListener zzcfy;

    public void onAdClosed() {
        synchronized (this.lock) {
            if (this.zzcfy != null) {
                this.zzcfy.onAdClosed();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.lock) {
            if (this.zzcfy != null) {
                this.zzcfy.onAdFailedToLoad(i);
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.lock) {
            if (this.zzcfy != null) {
                this.zzcfy.onAdLeftApplication();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.lock) {
            if (this.zzcfy != null) {
                this.zzcfy.onAdLoaded();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.lock) {
            if (this.zzcfy != null) {
                this.zzcfy.onAdOpened();
            }
        }
    }

    public final void zza(AdListener adListener) {
        synchronized (this.lock) {
            this.zzcfy = adListener;
        }
    }
}
