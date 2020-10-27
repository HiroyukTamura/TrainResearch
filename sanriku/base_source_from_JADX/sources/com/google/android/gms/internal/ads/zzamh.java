package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzamh extends zzgk implements zzame {
    public zzamh() {
        super("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    public static zzame zzae(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
        return queryLocalInterface instanceof zzame ? (zzame) queryLocalInterface : new zzamg(iBinder);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0052, code lost:
        r3.writeNoException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0060, code lost:
        r3.writeNoException();
        com.google.android.gms.internal.ads.zzgj.writeBoolean(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00af, code lost:
        r3.writeNoException();
        com.google.android.gms.internal.ads.zzgj.zza(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ca, code lost:
        r3.writeNoException();
        r3.writeString(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        r3.writeNoException();
        r3.writeFloat(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            switch(r1) {
                case 2: goto L_0x00c6;
                case 3: goto L_0x00bb;
                case 4: goto L_0x00b6;
                case 5: goto L_0x00ab;
                case 6: goto L_0x00a6;
                case 7: goto L_0x00a1;
                case 8: goto L_0x0096;
                case 9: goto L_0x0091;
                case 10: goto L_0x008c;
                case 11: goto L_0x0087;
                case 12: goto L_0x0082;
                case 13: goto L_0x007d;
                case 14: goto L_0x0078;
                case 15: goto L_0x0073;
                case 16: goto L_0x0068;
                case 17: goto L_0x005c;
                case 18: goto L_0x0057;
                case 19: goto L_0x004f;
                case 20: goto L_0x0043;
                case 21: goto L_0x0027;
                case 22: goto L_0x001b;
                case 23: goto L_0x000f;
                case 24: goto L_0x000a;
                case 25: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r1 = 0
            return r1
        L_0x0005:
            float r1 = r0.getVideoCurrentTime()
            goto L_0x0013
        L_0x000a:
            float r1 = r0.getVideoDuration()
            goto L_0x0013
        L_0x000f:
            float r1 = r0.getMediaContentAspectRatio()
        L_0x0013:
            r3.writeNoException()
            r3.writeFloat(r1)
            goto L_0x00d0
        L_0x001b:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zzw(r1)
            goto L_0x0052
        L_0x0027:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.IBinder r4 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r4)
            android.os.IBinder r2 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            r0.zzc(r1, r4, r2)
            goto L_0x0052
        L_0x0043:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zzu(r1)
            goto L_0x0052
        L_0x004f:
            r0.recordImpression()
        L_0x0052:
            r3.writeNoException()
            goto L_0x00d0
        L_0x0057:
            boolean r1 = r0.getOverrideClickHandling()
            goto L_0x0060
        L_0x005c:
            boolean r1 = r0.getOverrideImpressionRecording()
        L_0x0060:
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzgj.writeBoolean(r3, r1)
            goto L_0x00d0
        L_0x0068:
            android.os.Bundle r1 = r0.getExtras()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzgj.zzb(r3, r1)
            goto L_0x00d0
        L_0x0073:
            com.google.android.gms.dynamic.IObjectWrapper r1 = r0.zzsc()
            goto L_0x00af
        L_0x0078:
            com.google.android.gms.dynamic.IObjectWrapper r1 = r0.zzts()
            goto L_0x00af
        L_0x007d:
            com.google.android.gms.dynamic.IObjectWrapper r1 = r0.zztr()
            goto L_0x00af
        L_0x0082:
            com.google.android.gms.internal.ads.zzack r1 = r0.zzsb()
            goto L_0x00af
        L_0x0087:
            com.google.android.gms.internal.ads.zzxl r1 = r0.getVideoController()
            goto L_0x00af
        L_0x008c:
            java.lang.String r1 = r0.getPrice()
            goto L_0x00ca
        L_0x0091:
            java.lang.String r1 = r0.getStore()
            goto L_0x00ca
        L_0x0096:
            double r1 = r0.getStarRating()
            r3.writeNoException()
            r3.writeDouble(r1)
            goto L_0x00d0
        L_0x00a1:
            java.lang.String r1 = r0.getAdvertiser()
            goto L_0x00ca
        L_0x00a6:
            java.lang.String r1 = r0.getCallToAction()
            goto L_0x00ca
        L_0x00ab:
            com.google.android.gms.internal.ads.zzacs r1 = r0.zzsa()
        L_0x00af:
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r3, (android.os.IInterface) r1)
            goto L_0x00d0
        L_0x00b6:
            java.lang.String r1 = r0.getBody()
            goto L_0x00ca
        L_0x00bb:
            java.util.List r1 = r0.getImages()
            r3.writeNoException()
            r3.writeList(r1)
            goto L_0x00d0
        L_0x00c6:
            java.lang.String r1 = r0.getHeadline()
        L_0x00ca:
            r3.writeNoException()
            r3.writeString(r1)
        L_0x00d0:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzamh.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
