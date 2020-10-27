package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.base.zab;
import com.google.android.gms.internal.base.zad;
import p009e.p010a.p011a.p012a.C0681a;

public final class zah extends zab implements ISignInButtonCreator {
    zah(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    public final IObjectWrapper newSignInButton(IObjectWrapper iObjectWrapper, int i, int i2) throws RemoteException {
        Parcel zaa = zaa();
        zad.zaa(zaa, (IInterface) iObjectWrapper);
        zaa.writeInt(i);
        zaa.writeInt(i2);
        return C0681a.m306a(zaa(1, zaa));
    }

    public final IObjectWrapper newSignInButtonFromConfig(IObjectWrapper iObjectWrapper, SignInButtonConfig signInButtonConfig) throws RemoteException {
        Parcel zaa = zaa();
        zad.zaa(zaa, (IInterface) iObjectWrapper);
        zad.zaa(zaa, (Parcelable) signInButtonConfig);
        return C0681a.m306a(zaa(2, zaa));
    }
}
