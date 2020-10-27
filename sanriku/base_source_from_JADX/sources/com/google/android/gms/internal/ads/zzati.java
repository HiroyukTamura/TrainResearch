package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzati extends zzgk implements zzatf {
    public zzati() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public static zzatf zzap(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
        return queryLocalInterface instanceof zzatf ? (zzatf) queryLocalInterface : new zzath(iBinder);
    }

    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzatn] */
    /* JADX WARNING: type inference failed for: r0v6, types: [com.google.android.gms.internal.ads.zzatk] */
    /* JADX WARNING: type inference failed for: r0v10, types: [com.google.android.gms.internal.ads.zzats] */
    /* JADX WARNING: type inference failed for: r0v14, types: [com.google.android.gms.internal.ads.zzatn] */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* JADX WARNING: type inference failed for: r0v24 */
    /* JADX WARNING: type inference failed for: r0v25 */
    /* JADX WARNING: type inference failed for: r0v26 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        r4.writeNoException();
        com.google.android.gms.internal.ads.zzgj.zza(r4, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a8, code lost:
        r4.writeNoException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            java.lang.String r5 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback"
            r0 = 0
            switch(r2) {
                case 1: goto L_0x00e0;
                case 2: goto L_0x00c2;
                case 3: goto L_0x00b7;
                case 4: goto L_0x00ac;
                case 5: goto L_0x009d;
                case 6: goto L_0x007f;
                case 7: goto L_0x0073;
                case 8: goto L_0x0067;
                case 9: goto L_0x005b;
                case 10: goto L_0x004b;
                case 11: goto L_0x003f;
                case 12: goto L_0x003a;
                case 13: goto L_0x002d;
                case 14: goto L_0x0008;
                default: goto L_0x0006;
            }
        L_0x0006:
            r2 = 0
            return r2
        L_0x0008:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzuj> r2 = com.google.android.gms.internal.ads.zzuj.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzuj r2 = (com.google.android.gms.internal.ads.zzuj) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x0017
            goto L_0x0028
        L_0x0017:
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzatn
            if (r0 == 0) goto L_0x0023
            r0 = r5
            com.google.android.gms.internal.ads.zzatn r0 = (com.google.android.gms.internal.ads.zzatn) r0
            goto L_0x0028
        L_0x0023:
            com.google.android.gms.internal.ads.zzatp r0 = new com.google.android.gms.internal.ads.zzatp
            r0.<init>(r3)
        L_0x0028:
            r1.zzb(r2, r0)
            goto L_0x00a8
        L_0x002d:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzxf r2 = com.google.android.gms.internal.ads.zzxe.zzi(r2)
            r1.zza((com.google.android.gms.internal.ads.zzxf) r2)
            goto L_0x00a8
        L_0x003a:
            com.google.android.gms.internal.ads.zzxg r2 = r1.zzki()
            goto L_0x0043
        L_0x003f:
            com.google.android.gms.internal.ads.zzate r2 = r1.zzqt()
        L_0x0043:
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r4, (android.os.IInterface) r2)
            goto L_0x0104
        L_0x004b:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            boolean r3 = com.google.android.gms.internal.ads.zzgj.zza(r3)
            r1.zza((com.google.android.gms.dynamic.IObjectWrapper) r2, (boolean) r3)
            goto L_0x00a8
        L_0x005b:
            android.os.Bundle r2 = r1.getAdMetadata()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgj.zzb(r4, r2)
            goto L_0x0104
        L_0x0067:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzxa r2 = com.google.android.gms.internal.ads.zzxd.zzh(r2)
            r1.zza((com.google.android.gms.internal.ads.zzxa) r2)
            goto L_0x00a8
        L_0x0073:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzaua> r2 = com.google.android.gms.internal.ads.zzaua.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzaua r2 = (com.google.android.gms.internal.ads.zzaua) r2
            r1.zza((com.google.android.gms.internal.ads.zzaua) r2)
            goto L_0x00a8
        L_0x007f:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0086
            goto L_0x0099
        L_0x0086:
            java.lang.String r3 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzats
            if (r5 == 0) goto L_0x0094
            r0 = r3
            com.google.android.gms.internal.ads.zzats r0 = (com.google.android.gms.internal.ads.zzats) r0
            goto L_0x0099
        L_0x0094:
            com.google.android.gms.internal.ads.zzatr r0 = new com.google.android.gms.internal.ads.zzatr
            r0.<init>(r2)
        L_0x0099:
            r1.zza((com.google.android.gms.internal.ads.zzats) r0)
            goto L_0x00a8
        L_0x009d:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            r1.zzh(r2)
        L_0x00a8:
            r4.writeNoException()
            goto L_0x0104
        L_0x00ac:
            java.lang.String r2 = r1.getMediationAdapterClassName()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x0104
        L_0x00b7:
            boolean r2 = r1.isLoaded()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzgj.writeBoolean(r4, r2)
            goto L_0x0104
        L_0x00c2:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x00c9
            goto L_0x00dc
        L_0x00c9:
            java.lang.String r3 = "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzatk
            if (r5 == 0) goto L_0x00d7
            r0 = r3
            com.google.android.gms.internal.ads.zzatk r0 = (com.google.android.gms.internal.ads.zzatk) r0
            goto L_0x00dc
        L_0x00d7:
            com.google.android.gms.internal.ads.zzatm r0 = new com.google.android.gms.internal.ads.zzatm
            r0.<init>(r2)
        L_0x00dc:
            r1.zza((com.google.android.gms.internal.ads.zzatk) r0)
            goto L_0x00a8
        L_0x00e0:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzuj> r2 = com.google.android.gms.internal.ads.zzuj.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r3, r2)
            com.google.android.gms.internal.ads.zzuj r2 = (com.google.android.gms.internal.ads.zzuj) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x00ef
            goto L_0x0100
        L_0x00ef:
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzatn
            if (r0 == 0) goto L_0x00fb
            r0 = r5
            com.google.android.gms.internal.ads.zzatn r0 = (com.google.android.gms.internal.ads.zzatn) r0
            goto L_0x0100
        L_0x00fb:
            com.google.android.gms.internal.ads.zzatp r0 = new com.google.android.gms.internal.ads.zzatp
            r0.<init>(r3)
        L_0x0100:
            r1.zza((com.google.android.gms.internal.ads.zzuj) r2, (com.google.android.gms.internal.ads.zzatn) r0)
            goto L_0x00a8
        L_0x0104:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzati.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
