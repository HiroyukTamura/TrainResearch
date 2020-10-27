package com.google.android.gms.internal.ads;

public abstract class zzbgu extends zzgk implements zzbgr {
    public zzbgu() {
        super("com.google.android.gms.ads.measurement.IAppMeasurementProxy");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0050, code lost:
        r4.writeNoException();
        r4.writeString(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00f9, code lost:
        r4.writeNoException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            switch(r2) {
                case 1: goto L_0x00ee;
                case 2: goto L_0x00db;
                case 3: goto L_0x00c7;
                case 4: goto L_0x00b3;
                case 5: goto L_0x009c;
                case 6: goto L_0x008d;
                case 7: goto L_0x0081;
                case 8: goto L_0x006c;
                case 9: goto L_0x0058;
                case 10: goto L_0x004c;
                case 11: goto L_0x0047;
                case 12: goto L_0x003b;
                case 13: goto L_0x0032;
                case 14: goto L_0x0029;
                case 15: goto L_0x0014;
                case 16: goto L_0x000f;
                case 17: goto L_0x000a;
                case 18: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r2 = 0
            return r2
        L_0x0005:
            java.lang.String r2 = r1.getAppIdOrigin()
            goto L_0x0050
        L_0x000a:
            java.lang.String r2 = r1.getCurrentScreenClass()
            goto L_0x0050
        L_0x000f:
            java.lang.String r2 = r1.getCurrentScreenName()
            goto L_0x0050
        L_0x0014:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            java.lang.String r5 = r3.readString()
            java.lang.String r3 = r3.readString()
            r1.zzb(r2, r5, r3)
            goto L_0x00f9
        L_0x0029:
            java.lang.String r2 = r3.readString()
            r1.endAdUnitExposure(r2)
            goto L_0x00f9
        L_0x0032:
            java.lang.String r2 = r3.readString()
            r1.beginAdUnitExposure(r2)
            goto L_0x00f9
        L_0x003b:
            long r2 = r1.generateEventId()
            r4.writeNoException()
            r4.writeLong(r2)
            goto L_0x00fc
        L_0x0047:
            java.lang.String r2 = r1.getGmpAppId()
            goto L_0x0050
        L_0x004c:
            java.lang.String r2 = r1.getAppInstanceId()
        L_0x0050:
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x00fc
        L_0x0058:
            java.lang.String r2 = r3.readString()
            java.lang.String r3 = r3.readString()
            java.util.List r2 = r1.getConditionalUserProperties(r2, r3)
            r4.writeNoException()
            r4.writeList(r2)
            goto L_0x00fc
        L_0x006c:
            java.lang.String r2 = r3.readString()
            java.lang.String r5 = r3.readString()
            android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r3, r0)
            android.os.Bundle r3 = (android.os.Bundle) r3
            r1.clearConditionalUserProperty(r2, r5, r3)
            goto L_0x00f9
        L_0x0081:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r3, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            r1.setConditionalUserProperty(r2)
            goto L_0x00f9
        L_0x008d:
            java.lang.String r2 = r3.readString()
            int r2 = r1.getMaxUserProperties(r2)
            r4.writeNoException()
            r4.writeInt(r2)
            goto L_0x00fc
        L_0x009c:
            java.lang.String r2 = r3.readString()
            java.lang.String r5 = r3.readString()
            boolean r3 = com.google.android.gms.internal.ads.zzgj.zza(r3)
            java.util.Map r2 = r1.getUserProperties(r2, r5, r3)
            r4.writeNoException()
            r4.writeMap(r2)
            goto L_0x00fc
        L_0x00b3:
            java.lang.String r2 = r3.readString()
            java.lang.String r5 = r3.readString()
            android.os.IBinder r3 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            r1.zza(r2, r5, r3)
            goto L_0x00f9
        L_0x00c7:
            java.lang.String r2 = r3.readString()
            java.lang.String r5 = r3.readString()
            android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r3, r0)
            android.os.Bundle r3 = (android.os.Bundle) r3
            r1.logEvent(r2, r5, r3)
            goto L_0x00f9
        L_0x00db:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r3, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            android.os.Bundle r2 = r1.performActionWithResponse(r2)
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgj.zzb(r4, r2)
            goto L_0x00fc
        L_0x00ee:
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r3, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            r1.performAction(r2)
        L_0x00f9:
            r4.writeNoException()
        L_0x00fc:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgu.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
