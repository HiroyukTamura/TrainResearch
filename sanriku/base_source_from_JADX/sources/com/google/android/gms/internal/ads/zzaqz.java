package com.google.android.gms.internal.ads;

public abstract class zzaqz extends zzgk implements zzara {
    public zzaqz() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [com.google.android.gms.internal.ads.zzarb] */
    /* JADX WARNING: type inference failed for: r1v6, types: [com.google.android.gms.internal.ads.zzard] */
    /* JADX WARNING: type inference failed for: r1v11, types: [com.google.android.gms.internal.ads.zzard] */
    /* JADX WARNING: type inference failed for: r1v16, types: [com.google.android.gms.internal.ads.zzard] */
    /* JADX WARNING: type inference failed for: r1v21, types: [com.google.android.gms.internal.ads.zzard] */
    /* JADX WARNING: type inference failed for: r1v26 */
    /* JADX WARNING: type inference failed for: r1v27 */
    /* JADX WARNING: type inference failed for: r1v28 */
    /* JADX WARNING: type inference failed for: r1v29 */
    /* JADX WARNING: type inference failed for: r1v30 */
    /* JADX WARNING: type inference failed for: r1v31 */
    /* JADX WARNING: type inference failed for: r1v32 */
    /* JADX WARNING: type inference failed for: r1v33 */
    /* JADX WARNING: type inference failed for: r1v34 */
    /* JADX WARNING: type inference failed for: r1v35 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
        /*
            r3 = this;
            r7 = 1
            if (r4 == r7) goto L_0x00ce
            r0 = 2
            r1 = 0
            if (r4 == r0) goto L_0x00a5
            r0 = 4
            java.lang.String r2 = "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener"
            if (r4 == r0) goto L_0x0081
            r0 = 5
            if (r4 == r0) goto L_0x005d
            r0 = 6
            if (r4 == r0) goto L_0x0038
            r0 = 7
            if (r4 == r0) goto L_0x0017
            r4 = 0
            return r4
        L_0x0017:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0022
            goto L_0x0033
        L_0x0022:
            android.os.IInterface r0 = r5.queryLocalInterface(r2)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzard
            if (r1 == 0) goto L_0x002e
            r1 = r0
            com.google.android.gms.internal.ads.zzard r1 = (com.google.android.gms.internal.ads.zzard) r1
            goto L_0x0033
        L_0x002e:
            com.google.android.gms.internal.ads.zzarf r1 = new com.google.android.gms.internal.ads.zzarf
            r1.<init>(r5)
        L_0x0033:
            r3.zza((java.lang.String) r4, (com.google.android.gms.internal.ads.zzard) r1)
            goto L_0x00ca
        L_0x0038:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzarj> r4 = com.google.android.gms.internal.ads.zzarj.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.ads.zzarj r4 = (com.google.android.gms.internal.ads.zzarj) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0047
            goto L_0x0058
        L_0x0047:
            android.os.IInterface r0 = r5.queryLocalInterface(r2)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzard
            if (r1 == 0) goto L_0x0053
            r1 = r0
            com.google.android.gms.internal.ads.zzard r1 = (com.google.android.gms.internal.ads.zzard) r1
            goto L_0x0058
        L_0x0053:
            com.google.android.gms.internal.ads.zzarf r1 = new com.google.android.gms.internal.ads.zzarf
            r1.<init>(r5)
        L_0x0058:
            r3.zzc(r4, r1)
            goto L_0x00ca
        L_0x005d:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzarj> r4 = com.google.android.gms.internal.ads.zzarj.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.ads.zzarj r4 = (com.google.android.gms.internal.ads.zzarj) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x006c
            goto L_0x007d
        L_0x006c:
            android.os.IInterface r0 = r5.queryLocalInterface(r2)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzard
            if (r1 == 0) goto L_0x0078
            r1 = r0
            com.google.android.gms.internal.ads.zzard r1 = (com.google.android.gms.internal.ads.zzard) r1
            goto L_0x007d
        L_0x0078:
            com.google.android.gms.internal.ads.zzarf r1 = new com.google.android.gms.internal.ads.zzarf
            r1.<init>(r5)
        L_0x007d:
            r3.zzb(r4, r1)
            goto L_0x00ca
        L_0x0081:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzarj> r4 = com.google.android.gms.internal.ads.zzarj.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.ads.zzarj r4 = (com.google.android.gms.internal.ads.zzarj) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0090
            goto L_0x00a1
        L_0x0090:
            android.os.IInterface r0 = r5.queryLocalInterface(r2)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzard
            if (r1 == 0) goto L_0x009c
            r1 = r0
            com.google.android.gms.internal.ads.zzard r1 = (com.google.android.gms.internal.ads.zzard) r1
            goto L_0x00a1
        L_0x009c:
            com.google.android.gms.internal.ads.zzarf r1 = new com.google.android.gms.internal.ads.zzarf
            r1.<init>(r5)
        L_0x00a1:
            r3.zza((com.google.android.gms.internal.ads.zzarj) r4, (com.google.android.gms.internal.ads.zzard) r1)
            goto L_0x00ca
        L_0x00a5:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzaqu> r4 = com.google.android.gms.internal.ads.zzaqu.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.ads.zzaqu r4 = (com.google.android.gms.internal.ads.zzaqu) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x00b4
            goto L_0x00c7
        L_0x00b4:
            java.lang.String r0 = "com.google.android.gms.ads.internal.request.IAdResponseListener"
            android.os.IInterface r0 = r5.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzarb
            if (r1 == 0) goto L_0x00c2
            r1 = r0
            com.google.android.gms.internal.ads.zzarb r1 = (com.google.android.gms.internal.ads.zzarb) r1
            goto L_0x00c7
        L_0x00c2:
            com.google.android.gms.internal.ads.zzare r1 = new com.google.android.gms.internal.ads.zzare
            r1.<init>(r5)
        L_0x00c7:
            r3.zza((com.google.android.gms.internal.ads.zzaqu) r4, (com.google.android.gms.internal.ads.zzarb) r1)
        L_0x00ca:
            r6.writeNoException()
            goto L_0x00e0
        L_0x00ce:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzaqu> r4 = com.google.android.gms.internal.ads.zzaqu.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.ads.zzaqu r4 = (com.google.android.gms.internal.ads.zzaqu) r4
            com.google.android.gms.internal.ads.zzaqw r4 = r3.zza(r4)
            r6.writeNoException()
            com.google.android.gms.internal.ads.zzgj.zzb(r6, r4)
        L_0x00e0:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqz.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
