package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzacx extends NativeAd.Image {
    private final int height;
    private final Uri uri;
    private final int width;
    private final double zzcys;
    private final zzacs zzcyx;
    private final Drawable zzcyy;

    public zzacx(zzacs zzacs) {
        Drawable drawable;
        int i;
        this.zzcyx = zzacs;
        Uri uri2 = null;
        try {
            IObjectWrapper zzrv = zzacs.zzrv();
            if (zzrv != null) {
                drawable = (Drawable) ObjectWrapper.unwrap(zzrv);
                this.zzcyy = drawable;
                uri2 = this.zzcyx.getUri();
                this.uri = uri2;
                double d = 1.0d;
                d = this.zzcyx.getScale();
                this.zzcys = d;
                int i2 = -1;
                i = this.zzcyx.getWidth();
                this.width = i;
                i2 = this.zzcyx.getHeight();
                this.height = i2;
            }
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
        drawable = null;
        this.zzcyy = drawable;
        try {
            uri2 = this.zzcyx.getUri();
        } catch (RemoteException e2) {
            zzazw.zzc("", e2);
        }
        this.uri = uri2;
        double d2 = 1.0d;
        try {
            d2 = this.zzcyx.getScale();
        } catch (RemoteException e3) {
            zzazw.zzc("", e3);
        }
        this.zzcys = d2;
        int i22 = -1;
        try {
            i = this.zzcyx.getWidth();
        } catch (RemoteException e4) {
            zzazw.zzc("", e4);
            i = -1;
        }
        this.width = i;
        try {
            i22 = this.zzcyx.getHeight();
        } catch (RemoteException e5) {
            zzazw.zzc("", e5);
        }
        this.height = i22;
    }

    public final Drawable getDrawable() {
        return this.zzcyy;
    }

    public final int getHeight() {
        return this.height;
    }

    public final double getScale() {
        return this.zzcys;
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final int getWidth() {
        return this.width;
    }
}
