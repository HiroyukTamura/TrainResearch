package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzace extends zzacv {
    private final int height;
    private final Uri uri;
    private final int width;
    private final Drawable zzcyr;
    private final double zzcys;

    public zzace(Drawable drawable, Uri uri2, double d, int i, int i2) {
        this.zzcyr = drawable;
        this.uri = uri2;
        this.zzcys = d;
        this.width = i;
        this.height = i2;
    }

    public final int getHeight() {
        return this.height;
    }

    public final double getScale() {
        return this.zzcys;
    }

    public final Uri getUri() throws RemoteException {
        return this.uri;
    }

    public final int getWidth() {
        return this.width;
    }

    public final IObjectWrapper zzrv() throws RemoteException {
        return ObjectWrapper.wrap(this.zzcyr);
    }
}
