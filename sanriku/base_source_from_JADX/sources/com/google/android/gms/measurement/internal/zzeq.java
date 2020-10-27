package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzc;

public abstract class zzeq extends zzc implements zzer {
    public zzeq() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x00f1, code lost:
        r9.writeNoException();
        r9.writeTypedList(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x014b, code lost:
        r9.writeNoException();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r7, android.os.Parcel r8, android.os.Parcel r9, int r10) throws android.os.RemoteException {
        /*
            r6 = this;
            switch(r7) {
                case 1: goto L_0x0138;
                case 2: goto L_0x0124;
                case 3: goto L_0x0003;
                case 4: goto L_0x0118;
                case 5: goto L_0x0104;
                case 6: goto L_0x00f8;
                case 7: goto L_0x00e1;
                case 8: goto L_0x0003;
                case 9: goto L_0x00ca;
                case 10: goto L_0x00b4;
                case 11: goto L_0x00a0;
                case 12: goto L_0x008b;
                case 13: goto L_0x007e;
                case 14: goto L_0x0065;
                case 15: goto L_0x004f;
                case 16: goto L_0x0039;
                case 17: goto L_0x0027;
                case 18: goto L_0x001a;
                case 19: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r7 = 0
            return r7
        L_0x0005:
            android.os.Parcelable$Creator r7 = android.os.Bundle.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            android.os.Bundle r7 = (android.os.Bundle) r7
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r10 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r10)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            r6.zza((android.os.Bundle) r7, (com.google.android.gms.measurement.internal.zzn) r8)
            goto L_0x014b
        L_0x001a:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r7 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzn r7 = (com.google.android.gms.measurement.internal.zzn) r7
            r6.zzd(r7)
            goto L_0x014b
        L_0x0027:
            java.lang.String r7 = r8.readString()
            java.lang.String r10 = r8.readString()
            java.lang.String r8 = r8.readString()
            java.util.List r7 = r6.zza((java.lang.String) r7, (java.lang.String) r10, (java.lang.String) r8)
            goto L_0x00f1
        L_0x0039:
            java.lang.String r7 = r8.readString()
            java.lang.String r10 = r8.readString()
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r0 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r0)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            java.util.List r7 = r6.zza((java.lang.String) r7, (java.lang.String) r10, (com.google.android.gms.measurement.internal.zzn) r8)
            goto L_0x00f1
        L_0x004f:
            java.lang.String r7 = r8.readString()
            java.lang.String r10 = r8.readString()
            java.lang.String r0 = r8.readString()
            boolean r8 = com.google.android.gms.internal.measurement.zzb.zza(r8)
            java.util.List r7 = r6.zza((java.lang.String) r7, (java.lang.String) r10, (java.lang.String) r0, (boolean) r8)
            goto L_0x00f1
        L_0x0065:
            java.lang.String r7 = r8.readString()
            java.lang.String r10 = r8.readString()
            boolean r0 = com.google.android.gms.internal.measurement.zzb.zza(r8)
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r1 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r1)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            java.util.List r7 = r6.zza((java.lang.String) r7, (java.lang.String) r10, (boolean) r0, (com.google.android.gms.measurement.internal.zzn) r8)
            goto L_0x00f1
        L_0x007e:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzw> r7 = com.google.android.gms.measurement.internal.zzw.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzw r7 = (com.google.android.gms.measurement.internal.zzw) r7
            r6.zza((com.google.android.gms.measurement.internal.zzw) r7)
            goto L_0x014b
        L_0x008b:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzw> r7 = com.google.android.gms.measurement.internal.zzw.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzw r7 = (com.google.android.gms.measurement.internal.zzw) r7
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r10 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r10)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            r6.zza((com.google.android.gms.measurement.internal.zzw) r7, (com.google.android.gms.measurement.internal.zzn) r8)
            goto L_0x014b
        L_0x00a0:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r7 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzn r7 = (com.google.android.gms.measurement.internal.zzn) r7
            java.lang.String r7 = r6.zzc(r7)
            r9.writeNoException()
            r9.writeString(r7)
            goto L_0x014e
        L_0x00b4:
            long r1 = r8.readLong()
            java.lang.String r3 = r8.readString()
            java.lang.String r4 = r8.readString()
            java.lang.String r5 = r8.readString()
            r0 = r6
            r0.zza((long) r1, (java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5)
            goto L_0x014b
        L_0x00ca:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzao> r7 = com.google.android.gms.measurement.internal.zzao.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzao r7 = (com.google.android.gms.measurement.internal.zzao) r7
            java.lang.String r8 = r8.readString()
            byte[] r7 = r6.zza((com.google.android.gms.measurement.internal.zzao) r7, (java.lang.String) r8)
            r9.writeNoException()
            r9.writeByteArray(r7)
            goto L_0x014e
        L_0x00e1:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r7 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzn r7 = (com.google.android.gms.measurement.internal.zzn) r7
            boolean r8 = com.google.android.gms.internal.measurement.zzb.zza(r8)
            java.util.List r7 = r6.zza((com.google.android.gms.measurement.internal.zzn) r7, (boolean) r8)
        L_0x00f1:
            r9.writeNoException()
            r9.writeTypedList(r7)
            goto L_0x014e
        L_0x00f8:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r7 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzn r7 = (com.google.android.gms.measurement.internal.zzn) r7
            r6.zzb(r7)
            goto L_0x014b
        L_0x0104:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzao> r7 = com.google.android.gms.measurement.internal.zzao.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzao r7 = (com.google.android.gms.measurement.internal.zzao) r7
            java.lang.String r10 = r8.readString()
            java.lang.String r8 = r8.readString()
            r6.zza((com.google.android.gms.measurement.internal.zzao) r7, (java.lang.String) r10, (java.lang.String) r8)
            goto L_0x014b
        L_0x0118:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r7 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzn r7 = (com.google.android.gms.measurement.internal.zzn) r7
            r6.zza((com.google.android.gms.measurement.internal.zzn) r7)
            goto L_0x014b
        L_0x0124:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzkr> r7 = com.google.android.gms.measurement.internal.zzkr.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzkr r7 = (com.google.android.gms.measurement.internal.zzkr) r7
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r10 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r10)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            r6.zza((com.google.android.gms.measurement.internal.zzkr) r7, (com.google.android.gms.measurement.internal.zzn) r8)
            goto L_0x014b
        L_0x0138:
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzao> r7 = com.google.android.gms.measurement.internal.zzao.CREATOR
            android.os.Parcelable r7 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r7)
            com.google.android.gms.measurement.internal.zzao r7 = (com.google.android.gms.measurement.internal.zzao) r7
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzn> r10 = com.google.android.gms.measurement.internal.zzn.CREATOR
            android.os.Parcelable r8 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r8, r10)
            com.google.android.gms.measurement.internal.zzn r8 = (com.google.android.gms.measurement.internal.zzn) r8
            r6.zza((com.google.android.gms.measurement.internal.zzao) r7, (com.google.android.gms.measurement.internal.zzn) r8)
        L_0x014b:
            r9.writeNoException()
        L_0x014e:
            r7 = 1
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeq.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
