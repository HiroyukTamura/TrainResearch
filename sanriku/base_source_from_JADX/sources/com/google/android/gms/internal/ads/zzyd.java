package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import java.util.List;

final class zzyd extends zzahg {
    private final OnInitializationCompleteListener zzcho;
    private final /* synthetic */ zzxw zzchp;

    private zzyd(zzxw zzxw, OnInitializationCompleteListener onInitializationCompleteListener) {
        this.zzchp = zzxw;
        this.zzcho = onInitializationCompleteListener;
    }

    /* synthetic */ zzyd(zzxw zzxw, OnInitializationCompleteListener onInitializationCompleteListener, zzya zzya) {
        this(zzxw, onInitializationCompleteListener);
    }

    public final void zzd(List<zzaha> list) throws RemoteException {
        this.zzcho.onInitializationComplete(zzxw.zzc(list));
    }
}
