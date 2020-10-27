package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzvy extends zzgk implements zzvz {
    public zzvy() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    public static zzvz zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
        return queryLocalInterface instanceof zzvz ? (zzvz) queryLocalInterface : new zzwb(iBinder);
    }

    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v2, types: [com.google.android.gms.internal.ads.zzvm] */
    /* JADX WARNING: type inference failed for: r4v7, types: [com.google.android.gms.internal.ads.zzwh] */
    /* JADX WARNING: type inference failed for: r4v12, types: [com.google.android.gms.internal.ads.zzvl] */
    /* JADX WARNING: type inference failed for: r4v17, types: [com.google.android.gms.internal.ads.zzwn] */
    /* JADX WARNING: type inference failed for: r4v22, types: [com.google.android.gms.internal.ads.zzwc] */
    /* JADX WARNING: type inference failed for: r4v27, types: [com.google.android.gms.internal.ads.zzxf] */
    /* JADX WARNING: type inference failed for: r4v32 */
    /* JADX WARNING: type inference failed for: r4v33 */
    /* JADX WARNING: type inference failed for: r4v34 */
    /* JADX WARNING: type inference failed for: r4v35 */
    /* JADX WARNING: type inference failed for: r4v36 */
    /* JADX WARNING: type inference failed for: r4v37 */
    /* JADX WARNING: type inference failed for: r4v38 */
    /* JADX WARNING: type inference failed for: r4v39 */
    /* JADX WARNING: type inference failed for: r4v40 */
    /* JADX WARNING: type inference failed for: r4v41 */
    /* JADX WARNING: type inference failed for: r4v42 */
    /* JADX WARNING: type inference failed for: r4v43 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0128, code lost:
        r3.writeNoException();
        r3.writeString(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x015f, code lost:
        r3.writeNoException();
        com.google.android.gms.internal.ads.zzgj.zzb(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01ca, code lost:
        r3.writeNoException();
        com.google.android.gms.internal.ads.zzgj.writeBoolean(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01d4, code lost:
        r3.writeNoException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01dc, code lost:
        r3.writeNoException();
        com.google.android.gms.internal.ads.zzgj.zza(r3, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            r4 = 0
            switch(r1) {
                case 1: goto L_0x01d8;
                case 2: goto L_0x01d1;
                case 3: goto L_0x01c6;
                case 4: goto L_0x01b9;
                case 5: goto L_0x01b5;
                case 6: goto L_0x01b1;
                case 7: goto L_0x0193;
                case 8: goto L_0x0175;
                case 9: goto L_0x0171;
                case 10: goto L_0x016c;
                case 11: goto L_0x0167;
                case 12: goto L_0x015b;
                case 13: goto L_0x014e;
                case 14: goto L_0x0141;
                case 15: goto L_0x0130;
                case 16: goto L_0x0004;
                case 17: goto L_0x0004;
                case 18: goto L_0x0124;
                case 19: goto L_0x0117;
                case 20: goto L_0x00f8;
                case 21: goto L_0x00d9;
                case 22: goto L_0x00d0;
                case 23: goto L_0x00ca;
                case 24: goto L_0x00bd;
                case 25: goto L_0x00b4;
                case 26: goto L_0x00ae;
                case 27: goto L_0x0004;
                case 28: goto L_0x0004;
                case 29: goto L_0x00a1;
                case 30: goto L_0x0094;
                case 31: goto L_0x008e;
                case 32: goto L_0x0088;
                case 33: goto L_0x0082;
                case 34: goto L_0x0079;
                case 35: goto L_0x0073;
                case 36: goto L_0x0054;
                case 37: goto L_0x004e;
                case 38: goto L_0x0045;
                case 39: goto L_0x0038;
                case 40: goto L_0x002b;
                case 41: goto L_0x0025;
                case 42: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r1 = 0
            return r1
        L_0x0006:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x000d
            goto L_0x0020
        L_0x000d:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IOnPaidEventListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzxf
            if (r4 == 0) goto L_0x001b
            r4 = r2
            com.google.android.gms.internal.ads.zzxf r4 = (com.google.android.gms.internal.ads.zzxf) r4
            goto L_0x0020
        L_0x001b:
            com.google.android.gms.internal.ads.zzxh r4 = new com.google.android.gms.internal.ads.zzxh
            r4.<init>(r1)
        L_0x0020:
            r0.zza((com.google.android.gms.internal.ads.zzxf) r4)
            goto L_0x01d4
        L_0x0025:
            com.google.android.gms.internal.ads.zzxg r1 = r0.zzki()
            goto L_0x01dc
        L_0x002b:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzrn r1 = com.google.android.gms.internal.ads.zzrq.zzb(r1)
            r0.zza((com.google.android.gms.internal.ads.zzrn) r1)
            goto L_0x01d4
        L_0x0038:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzut> r1 = com.google.android.gms.internal.ads.zzut.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzut r1 = (com.google.android.gms.internal.ads.zzut) r1
            r0.zza((com.google.android.gms.internal.ads.zzut) r1)
            goto L_0x01d4
        L_0x0045:
            java.lang.String r1 = r2.readString()
            r0.zzbn(r1)
            goto L_0x01d4
        L_0x004e:
            android.os.Bundle r1 = r0.getAdMetadata()
            goto L_0x015f
        L_0x0054:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x005b
            goto L_0x006e
        L_0x005b:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdMetadataListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzwc
            if (r4 == 0) goto L_0x0069
            r4 = r2
            com.google.android.gms.internal.ads.zzwc r4 = (com.google.android.gms.internal.ads.zzwc) r4
            goto L_0x006e
        L_0x0069:
            com.google.android.gms.internal.ads.zzwe r4 = new com.google.android.gms.internal.ads.zzwe
            r4.<init>(r1)
        L_0x006e:
            r0.zza((com.google.android.gms.internal.ads.zzwc) r4)
            goto L_0x01d4
        L_0x0073:
            java.lang.String r1 = r0.zzkh()
            goto L_0x0128
        L_0x0079:
            boolean r1 = com.google.android.gms.internal.ads.zzgj.zza(r2)
            r0.setImmersiveMode(r1)
            goto L_0x01d4
        L_0x0082:
            com.google.android.gms.internal.ads.zzvm r1 = r0.zzkk()
            goto L_0x01dc
        L_0x0088:
            com.google.android.gms.internal.ads.zzwh r1 = r0.zzkj()
            goto L_0x01dc
        L_0x008e:
            java.lang.String r1 = r0.getAdUnitId()
            goto L_0x0128
        L_0x0094:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzxr> r1 = com.google.android.gms.internal.ads.zzxr.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzxr r1 = (com.google.android.gms.internal.ads.zzxr) r1
            r0.zza((com.google.android.gms.internal.ads.zzxr) r1)
            goto L_0x01d4
        L_0x00a1:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzze> r1 = com.google.android.gms.internal.ads.zzze.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzze r1 = (com.google.android.gms.internal.ads.zzze) r1
            r0.zza((com.google.android.gms.internal.ads.zzze) r1)
            goto L_0x01d4
        L_0x00ae:
            com.google.android.gms.internal.ads.zzxl r1 = r0.getVideoController()
            goto L_0x01dc
        L_0x00b4:
            java.lang.String r1 = r2.readString()
            r0.setUserId(r1)
            goto L_0x01d4
        L_0x00bd:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzasn r1 = com.google.android.gms.internal.ads.zzasq.zzam(r1)
            r0.zza((com.google.android.gms.internal.ads.zzasn) r1)
            goto L_0x01d4
        L_0x00ca:
            boolean r1 = r0.isLoading()
            goto L_0x01ca
        L_0x00d0:
            boolean r1 = com.google.android.gms.internal.ads.zzgj.zza(r2)
            r0.setManualImpressionsEnabled(r1)
            goto L_0x01d4
        L_0x00d9:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x00e0
            goto L_0x00f3
        L_0x00e0:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzwn
            if (r4 == 0) goto L_0x00ee
            r4 = r2
            com.google.android.gms.internal.ads.zzwn r4 = (com.google.android.gms.internal.ads.zzwn) r4
            goto L_0x00f3
        L_0x00ee:
            com.google.android.gms.internal.ads.zzwm r4 = new com.google.android.gms.internal.ads.zzwm
            r4.<init>(r1)
        L_0x00f3:
            r0.zza((com.google.android.gms.internal.ads.zzwn) r4)
            goto L_0x01d4
        L_0x00f8:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x00ff
            goto L_0x0112
        L_0x00ff:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdClickListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzvl
            if (r4 == 0) goto L_0x010d
            r4 = r2
            com.google.android.gms.internal.ads.zzvl r4 = (com.google.android.gms.internal.ads.zzvl) r4
            goto L_0x0112
        L_0x010d:
            com.google.android.gms.internal.ads.zzvn r4 = new com.google.android.gms.internal.ads.zzvn
            r4.<init>(r1)
        L_0x0112:
            r0.zza((com.google.android.gms.internal.ads.zzvl) r4)
            goto L_0x01d4
        L_0x0117:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzaas r1 = com.google.android.gms.internal.ads.zzaav.zzl(r1)
            r0.zza((com.google.android.gms.internal.ads.zzaas) r1)
            goto L_0x01d4
        L_0x0124:
            java.lang.String r1 = r0.getMediationAdapterClassName()
        L_0x0128:
            r3.writeNoException()
            r3.writeString(r1)
            goto L_0x01e2
        L_0x0130:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzapw r1 = com.google.android.gms.internal.ads.zzapv.zzaj(r1)
            java.lang.String r2 = r2.readString()
            r0.zza(r1, r2)
            goto L_0x01d4
        L_0x0141:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzapq r1 = com.google.android.gms.internal.ads.zzapp.zzah(r1)
            r0.zza((com.google.android.gms.internal.ads.zzapq) r1)
            goto L_0x01d4
        L_0x014e:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzum> r1 = com.google.android.gms.internal.ads.zzum.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzum r1 = (com.google.android.gms.internal.ads.zzum) r1
            r0.zza((com.google.android.gms.internal.ads.zzum) r1)
            goto L_0x01d4
        L_0x015b:
            com.google.android.gms.internal.ads.zzum r1 = r0.zzkg()
        L_0x015f:
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzgj.zzb(r3, r1)
            goto L_0x01e2
        L_0x0167:
            r0.zzkf()
            goto L_0x01d4
        L_0x016c:
            r0.stopLoading()
            goto L_0x01d4
        L_0x0171:
            r0.showInterstitial()
            goto L_0x01d4
        L_0x0175:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x017c
            goto L_0x018f
        L_0x017c:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzwh
            if (r4 == 0) goto L_0x018a
            r4 = r2
            com.google.android.gms.internal.ads.zzwh r4 = (com.google.android.gms.internal.ads.zzwh) r4
            goto L_0x018f
        L_0x018a:
            com.google.android.gms.internal.ads.zzwj r4 = new com.google.android.gms.internal.ads.zzwj
            r4.<init>(r1)
        L_0x018f:
            r0.zza((com.google.android.gms.internal.ads.zzwh) r4)
            goto L_0x01d4
        L_0x0193:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x019a
            goto L_0x01ad
        L_0x019a:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzvm
            if (r4 == 0) goto L_0x01a8
            r4 = r2
            com.google.android.gms.internal.ads.zzvm r4 = (com.google.android.gms.internal.ads.zzvm) r4
            goto L_0x01ad
        L_0x01a8:
            com.google.android.gms.internal.ads.zzvo r4 = new com.google.android.gms.internal.ads.zzvo
            r4.<init>(r1)
        L_0x01ad:
            r0.zza((com.google.android.gms.internal.ads.zzvm) r4)
            goto L_0x01d4
        L_0x01b1:
            r0.resume()
            goto L_0x01d4
        L_0x01b5:
            r0.pause()
            goto L_0x01d4
        L_0x01b9:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzuj> r1 = com.google.android.gms.internal.ads.zzuj.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzuj r1 = (com.google.android.gms.internal.ads.zzuj) r1
            boolean r1 = r0.zza((com.google.android.gms.internal.ads.zzuj) r1)
            goto L_0x01ca
        L_0x01c6:
            boolean r1 = r0.isReady()
        L_0x01ca:
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzgj.writeBoolean(r3, r1)
            goto L_0x01e2
        L_0x01d1:
            r0.destroy()
        L_0x01d4:
            r3.writeNoException()
            goto L_0x01e2
        L_0x01d8:
            com.google.android.gms.dynamic.IObjectWrapper r1 = r0.zzke()
        L_0x01dc:
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r3, (android.os.IInterface) r1)
        L_0x01e2:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvy.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
