package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzaco implements NativeCustomTemplateAd.DisplayOpenMeasurement {
    private final zzado zzcyv;

    public zzaco(zzado zzado) {
        this.zzcyv = zzado;
        try {
            zzado.zzsh();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final void setView(View view) {
        try {
            this.zzcyv.zzq(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzazw.zzc("", e);
        }
    }

    public final boolean start() {
        try {
            return this.zzcyv.zzsg();
        } catch (RemoteException e) {
            zzazw.zzc("", e);
            return false;
        }
    }
}
