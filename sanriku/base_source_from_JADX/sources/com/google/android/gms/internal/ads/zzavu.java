package com.google.android.gms.internal.ads;

import android.os.IBinder;

public final class zzavu extends zzgi implements zzavs {
    zzavu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGeneratorCreator");
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzavn zzf(com.google.android.gms.dynamic.IObjectWrapper r3, int r4) throws android.os.RemoteException {
        /*
            r2 = this;
            android.os.Parcel r0 = r2.obtainAndWriteInterfaceToken()
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r0, (android.os.IInterface) r3)
            r0.writeInt(r4)
            r3 = 1
            android.os.Parcel r3 = r2.transactAndReadException(r3, r0)
            android.os.IBinder r4 = r3.readStrongBinder()
            if (r4 != 0) goto L_0x0017
            r4 = 0
            goto L_0x002b
        L_0x0017:
            java.lang.String r0 = "com.google.android.gms.ads.internal.signals.ISignalGenerator"
            android.os.IInterface r0 = r4.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzavn
            if (r1 == 0) goto L_0x0025
            r4 = r0
            com.google.android.gms.internal.ads.zzavn r4 = (com.google.android.gms.internal.ads.zzavn) r4
            goto L_0x002b
        L_0x0025:
            com.google.android.gms.internal.ads.zzavp r0 = new com.google.android.gms.internal.ads.zzavp
            r0.<init>(r4)
            r4 = r0
        L_0x002b:
            r3.recycle()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzavu.zzf(com.google.android.gms.dynamic.IObjectWrapper, int):com.google.android.gms.internal.ads.zzavn");
    }
}
