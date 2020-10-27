package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzacz extends zzgk implements zzacw {
    public zzacz() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public static zzacw zzp(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        return queryLocalInterface instanceof zzacw ? (zzacw) queryLocalInterface : new zzacy(iBinder);
    }

    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            switch(r1) {
                case 1: goto L_0x0079;
                case 2: goto L_0x006a;
                case 3: goto L_0x005e;
                case 4: goto L_0x005a;
                case 5: goto L_0x004a;
                case 6: goto L_0x003e;
                case 7: goto L_0x0032;
                case 8: goto L_0x0012;
                case 9: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r1 = 0
            return r1
        L_0x0005:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zzg(r1)
            goto L_0x0088
        L_0x0012:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x001a
            r1 = 0
            goto L_0x002e
        L_0x001a:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.IMediaContent"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzacr
            if (r4 == 0) goto L_0x0028
            r1 = r2
            com.google.android.gms.internal.ads.zzacr r1 = (com.google.android.gms.internal.ads.zzacr) r1
            goto L_0x002e
        L_0x0028:
            com.google.android.gms.internal.ads.zzact r2 = new com.google.android.gms.internal.ads.zzact
            r2.<init>(r1)
            r1 = r2
        L_0x002e:
            r0.zza((com.google.android.gms.internal.ads.zzacr) r1)
            goto L_0x0088
        L_0x0032:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zzf(r1)
            goto L_0x0088
        L_0x003e:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zze(r1)
            goto L_0x0088
        L_0x004a:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            int r2 = r2.readInt()
            r0.zzc(r1, r2)
            goto L_0x0088
        L_0x005a:
            r0.destroy()
            goto L_0x0088
        L_0x005e:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zza((com.google.android.gms.dynamic.IObjectWrapper) r1)
            goto L_0x0088
        L_0x006a:
            java.lang.String r1 = r2.readString()
            com.google.android.gms.dynamic.IObjectWrapper r1 = r0.zzcq(r1)
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r3, (android.os.IInterface) r1)
            goto L_0x008b
        L_0x0079:
            java.lang.String r1 = r2.readString()
            android.os.IBinder r2 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            r0.zzb(r1, r2)
        L_0x0088:
            r3.writeNoException()
        L_0x008b:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacz.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
