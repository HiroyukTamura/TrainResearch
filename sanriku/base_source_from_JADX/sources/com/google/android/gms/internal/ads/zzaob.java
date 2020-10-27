package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;

public class zzaob {
    public static zzanv zzds(String str) throws RemoteException {
        try {
            return new zzaoa((RtbAdapter) Class.forName(str, false, zzaob.class.getClassLoader()).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Throwable unused) {
            throw new RemoteException();
        }
    }
}
