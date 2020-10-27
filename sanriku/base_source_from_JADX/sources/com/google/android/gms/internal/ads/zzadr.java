package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzadr extends zzgk implements zzado {
    public zzadr() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public static zzado zzr(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        return queryLocalInterface instanceof zzado ? (zzado) queryLocalInterface : new zzadq(iBinder);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0050, code lost:
        r3.writeNoException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006c, code lost:
        r3.writeNoException();
        com.google.android.gms.internal.ads.zzgj.zza(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007b, code lost:
        r3.writeNoException();
        r3.writeString(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0030, code lost:
        r3.writeNoException();
        com.google.android.gms.internal.ads.zzgj.writeBoolean(r3, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            switch(r1) {
                case 1: goto L_0x0073;
                case 2: goto L_0x0064;
                case 3: goto L_0x0059;
                case 4: goto L_0x0054;
                case 5: goto L_0x0049;
                case 6: goto L_0x0045;
                case 7: goto L_0x0040;
                case 8: goto L_0x003c;
                case 9: goto L_0x0037;
                case 10: goto L_0x0024;
                case 11: goto L_0x001f;
                case 12: goto L_0x001a;
                case 13: goto L_0x0015;
                case 14: goto L_0x0009;
                case 15: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r1 = 0
            return r1
        L_0x0005:
            r0.zzsh()
            goto L_0x0050
        L_0x0009:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zzq(r1)
            goto L_0x0050
        L_0x0015:
            boolean r1 = r0.zzsg()
            goto L_0x0030
        L_0x001a:
            boolean r1 = r0.zzsf()
            goto L_0x0030
        L_0x001f:
            com.google.android.gms.dynamic.IObjectWrapper r1 = r0.zzrz()
            goto L_0x006c
        L_0x0024:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            boolean r1 = r0.zzp(r1)
        L_0x0030:
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzgj.writeBoolean(r3, r1)
            goto L_0x0081
        L_0x0037:
            com.google.android.gms.dynamic.IObjectWrapper r1 = r0.zzse()
            goto L_0x006c
        L_0x003c:
            r0.destroy()
            goto L_0x0050
        L_0x0040:
            com.google.android.gms.internal.ads.zzxl r1 = r0.getVideoController()
            goto L_0x006c
        L_0x0045:
            r0.recordImpression()
            goto L_0x0050
        L_0x0049:
            java.lang.String r1 = r2.readString()
            r0.performClick(r1)
        L_0x0050:
            r3.writeNoException()
            goto L_0x0081
        L_0x0054:
            java.lang.String r1 = r0.getCustomTemplateId()
            goto L_0x007b
        L_0x0059:
            java.util.List r1 = r0.getAvailableAssetNames()
            r3.writeNoException()
            r3.writeStringList(r1)
            goto L_0x0081
        L_0x0064:
            java.lang.String r1 = r2.readString()
            com.google.android.gms.internal.ads.zzacs r1 = r0.zzcw(r1)
        L_0x006c:
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r3, (android.os.IInterface) r1)
            goto L_0x0081
        L_0x0073:
            java.lang.String r1 = r2.readString()
            java.lang.String r1 = r0.zzcv(r1)
        L_0x007b:
            r3.writeNoException()
            r3.writeString(r1)
        L_0x0081:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadr.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
