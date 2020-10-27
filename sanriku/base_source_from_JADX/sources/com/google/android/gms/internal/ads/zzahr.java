package com.google.android.gms.internal.ads;

public abstract class zzahr extends zzgk implements zzaho {
    public zzahr() {
        super("com.google.android.gms.ads.internal.instream.client.IInstreamAd");
    }

    /* JADX WARNING: type inference failed for: r5v5, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            r5 = 3
            if (r2 == r5) goto L_0x0051
            r5 = 4
            if (r2 == r5) goto L_0x004a
            r5 = 5
            if (r2 == r5) goto L_0x0022
            r5 = 6
            if (r2 == r5) goto L_0x0016
            r3 = 7
            if (r2 == r3) goto L_0x0011
            r2 = 0
            return r2
        L_0x0011:
            com.google.android.gms.internal.ads.zzacr r2 = r1.zzsl()
            goto L_0x0055
        L_0x0016:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            r1.zzr(r2)
            goto L_0x004d
        L_0x0022:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x0032
            r3 = 0
            goto L_0x0046
        L_0x0032:
            java.lang.String r5 = "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzaht
            if (r0 == 0) goto L_0x0040
            r3 = r5
            com.google.android.gms.internal.ads.zzaht r3 = (com.google.android.gms.internal.ads.zzaht) r3
            goto L_0x0046
        L_0x0040:
            com.google.android.gms.internal.ads.zzahv r5 = new com.google.android.gms.internal.ads.zzahv
            r5.<init>(r3)
            r3 = r5
        L_0x0046:
            r1.zza(r2, r3)
            goto L_0x004d
        L_0x004a:
            r1.destroy()
        L_0x004d:
            r4.writeNoException()
            goto L_0x005b
        L_0x0051:
            com.google.android.gms.internal.ads.zzxl r2 = r1.getVideoController()
        L_0x0055:
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r4, (android.os.IInterface) r2)
        L_0x005b:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahr.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
