package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzasj extends zzgk implements zzask {
    public zzasj() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
    }

    public static zzask zzal(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAd");
        return queryLocalInterface instanceof zzask ? (zzask) queryLocalInterface : new zzasm(iBinder);
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzasn] */
    /* JADX WARNING: type inference failed for: r1v5, types: [com.google.android.gms.internal.ads.zzasi] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00c5, code lost:
        r5.writeNoException();
        com.google.android.gms.internal.ads.zzgj.writeBoolean(r5, r3);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r3, android.os.Parcel r4, android.os.Parcel r5, int r6) throws android.os.RemoteException {
        /*
            r2 = this;
            r6 = 1
            if (r3 == r6) goto L_0x00f6
            r0 = 2
            if (r3 == r0) goto L_0x00f2
            r0 = 3
            r1 = 0
            if (r3 == r0) goto L_0x00d4
            r0 = 34
            if (r3 == r0) goto L_0x00cc
            switch(r3) {
                case 5: goto L_0x00c1;
                case 6: goto L_0x00bd;
                case 7: goto L_0x00b9;
                case 8: goto L_0x00b5;
                case 9: goto L_0x00a9;
                case 10: goto L_0x009d;
                case 11: goto L_0x0091;
                case 12: goto L_0x0085;
                case 13: goto L_0x007c;
                case 14: goto L_0x006f;
                case 15: goto L_0x0063;
                case 16: goto L_0x0044;
                case 17: goto L_0x003b;
                case 18: goto L_0x002e;
                case 19: goto L_0x0025;
                case 20: goto L_0x001f;
                case 21: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            r3 = 0
            return r3
        L_0x0013:
            com.google.android.gms.internal.ads.zzxg r3 = r2.zzki()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r5, (android.os.IInterface) r3)
            goto L_0x0104
        L_0x001f:
            boolean r3 = r2.zzqu()
            goto L_0x00c5
        L_0x0025:
            java.lang.String r3 = r4.readString()
            r2.setCustomData(r3)
            goto L_0x0101
        L_0x002e:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            r2.zzi(r3)
            goto L_0x0101
        L_0x003b:
            java.lang.String r3 = r4.readString()
            r2.setAppPackageName(r3)
            goto L_0x0101
        L_0x0044:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x004b
            goto L_0x005e
        L_0x004b:
            java.lang.String r4 = "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r0 = r4 instanceof com.google.android.gms.internal.ads.zzasi
            if (r0 == 0) goto L_0x0059
            r1 = r4
            com.google.android.gms.internal.ads.zzasi r1 = (com.google.android.gms.internal.ads.zzasi) r1
            goto L_0x005e
        L_0x0059:
            com.google.android.gms.internal.ads.zzash r1 = new com.google.android.gms.internal.ads.zzash
            r1.<init>(r3)
        L_0x005e:
            r2.zza((com.google.android.gms.internal.ads.zzasi) r1)
            goto L_0x0101
        L_0x0063:
            android.os.Bundle r3 = r2.getAdMetadata()
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzgj.zzb(r5, r3)
            goto L_0x0104
        L_0x006f:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.internal.ads.zzwc r3 = com.google.android.gms.internal.ads.zzwf.zzd(r3)
            r2.zza((com.google.android.gms.internal.ads.zzwc) r3)
            goto L_0x0101
        L_0x007c:
            java.lang.String r3 = r4.readString()
            r2.setUserId(r3)
            goto L_0x0101
        L_0x0085:
            java.lang.String r3 = r2.getMediationAdapterClassName()
            r5.writeNoException()
            r5.writeString(r3)
            goto L_0x0104
        L_0x0091:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            r2.zzl(r3)
            goto L_0x0101
        L_0x009d:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            r2.zzk(r3)
            goto L_0x0101
        L_0x00a9:
            android.os.IBinder r3 = r4.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            r2.zzj(r3)
            goto L_0x0101
        L_0x00b5:
            r2.destroy()
            goto L_0x0101
        L_0x00b9:
            r2.resume()
            goto L_0x0101
        L_0x00bd:
            r2.pause()
            goto L_0x0101
        L_0x00c1:
            boolean r3 = r2.isLoaded()
        L_0x00c5:
            r5.writeNoException()
            com.google.android.gms.internal.ads.zzgj.writeBoolean(r5, r3)
            goto L_0x0104
        L_0x00cc:
            boolean r3 = com.google.android.gms.internal.ads.zzgj.zza(r4)
            r2.setImmersiveMode(r3)
            goto L_0x0101
        L_0x00d4:
            android.os.IBinder r3 = r4.readStrongBinder()
            if (r3 != 0) goto L_0x00db
            goto L_0x00ee
        L_0x00db:
            java.lang.String r4 = "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r0 = r4 instanceof com.google.android.gms.internal.ads.zzasn
            if (r0 == 0) goto L_0x00e9
            r1 = r4
            com.google.android.gms.internal.ads.zzasn r1 = (com.google.android.gms.internal.ads.zzasn) r1
            goto L_0x00ee
        L_0x00e9:
            com.google.android.gms.internal.ads.zzasp r1 = new com.google.android.gms.internal.ads.zzasp
            r1.<init>(r3)
        L_0x00ee:
            r2.zza((com.google.android.gms.internal.ads.zzasn) r1)
            goto L_0x0101
        L_0x00f2:
            r2.show()
            goto L_0x0101
        L_0x00f6:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzast> r3 = com.google.android.gms.internal.ads.zzast.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r4, r3)
            com.google.android.gms.internal.ads.zzast r3 = (com.google.android.gms.internal.ads.zzast) r3
            r2.zza((com.google.android.gms.internal.ads.zzast) r3)
        L_0x0101:
            r5.writeNoException()
        L_0x0104:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasj.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
