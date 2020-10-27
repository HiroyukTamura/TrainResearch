package com.google.android.gms.internal.ads;

public abstract class zzvv extends zzgk implements zzvs {
    public zzvv() {
        super("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* JADX WARNING: type inference failed for: r4v1 */
    /* JADX WARNING: type inference failed for: r4v2, types: [com.google.android.gms.internal.ads.zzvm] */
    /* JADX WARNING: type inference failed for: r4v9, types: [com.google.android.gms.internal.ads.zzwn] */
    /* JADX WARNING: type inference failed for: r4v15 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: type inference failed for: r4v18 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            r4 = 0
            switch(r1) {
                case 1: goto L_0x00c9;
                case 2: goto L_0x00ab;
                case 3: goto L_0x009c;
                case 4: goto L_0x0090;
                case 5: goto L_0x0078;
                case 6: goto L_0x006c;
                case 7: goto L_0x004e;
                case 8: goto L_0x003a;
                case 9: goto L_0x002d;
                case 10: goto L_0x0020;
                case 11: goto L_0x0004;
                case 12: goto L_0x0004;
                case 13: goto L_0x0013;
                case 14: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r1 = 0
            return r1
        L_0x0006:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzahu r1 = com.google.android.gms.internal.ads.zzahx.zzab(r1)
            r0.zza((com.google.android.gms.internal.ads.zzahu) r1)
            goto L_0x00a7
        L_0x0013:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzahm> r1 = com.google.android.gms.internal.ads.zzahm.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzahm r1 = (com.google.android.gms.internal.ads.zzahm) r1
            r0.zza((com.google.android.gms.internal.ads.zzahm) r1)
            goto L_0x00a7
        L_0x0020:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzael r1 = com.google.android.gms.internal.ads.zzaek.zzx(r1)
            r0.zza((com.google.android.gms.internal.ads.zzael) r1)
            goto L_0x00a7
        L_0x002d:
            android.os.Parcelable$Creator<com.google.android.gms.ads.formats.PublisherAdViewOptions> r1 = com.google.android.gms.ads.formats.PublisherAdViewOptions.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.ads.formats.PublisherAdViewOptions r1 = (com.google.android.gms.ads.formats.PublisherAdViewOptions) r1
            r0.zza((com.google.android.gms.ads.formats.PublisherAdViewOptions) r1)
            goto L_0x00a7
        L_0x003a:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzaeg r1 = com.google.android.gms.internal.ads.zzaej.zzw(r1)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzum> r4 = com.google.android.gms.internal.ads.zzum.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r2, r4)
            com.google.android.gms.internal.ads.zzum r2 = (com.google.android.gms.internal.ads.zzum) r2
            r0.zza(r1, r2)
            goto L_0x00a7
        L_0x004e:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0055
            goto L_0x0068
        L_0x0055:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzwn
            if (r4 == 0) goto L_0x0063
            r4 = r2
            com.google.android.gms.internal.ads.zzwn r4 = (com.google.android.gms.internal.ads.zzwn) r4
            goto L_0x0068
        L_0x0063:
            com.google.android.gms.internal.ads.zzwm r4 = new com.google.android.gms.internal.ads.zzwm
            r4.<init>(r1)
        L_0x0068:
            r0.zzb((com.google.android.gms.internal.ads.zzwn) r4)
            goto L_0x00a7
        L_0x006c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzaci> r1 = com.google.android.gms.internal.ads.zzaci.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzaci r1 = (com.google.android.gms.internal.ads.zzaci) r1
            r0.zza((com.google.android.gms.internal.ads.zzaci) r1)
            goto L_0x00a7
        L_0x0078:
            java.lang.String r1 = r2.readString()
            android.os.IBinder r4 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzaed r4 = com.google.android.gms.internal.ads.zzaec.zzv(r4)
            android.os.IBinder r2 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzady r2 = com.google.android.gms.internal.ads.zzaeb.zzu(r2)
            r0.zza(r1, r4, r2)
            goto L_0x00a7
        L_0x0090:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzadx r1 = com.google.android.gms.internal.ads.zzadw.zzt(r1)
            r0.zza((com.google.android.gms.internal.ads.zzadx) r1)
            goto L_0x00a7
        L_0x009c:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzads r1 = com.google.android.gms.internal.ads.zzadv.zzs(r1)
            r0.zza((com.google.android.gms.internal.ads.zzads) r1)
        L_0x00a7:
            r3.writeNoException()
            goto L_0x00d3
        L_0x00ab:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x00b2
            goto L_0x00c5
        L_0x00b2:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzvm
            if (r4 == 0) goto L_0x00c0
            r4 = r2
            com.google.android.gms.internal.ads.zzvm r4 = (com.google.android.gms.internal.ads.zzvm) r4
            goto L_0x00c5
        L_0x00c0:
            com.google.android.gms.internal.ads.zzvo r4 = new com.google.android.gms.internal.ads.zzvo
            r4.<init>(r1)
        L_0x00c5:
            r0.zzb((com.google.android.gms.internal.ads.zzvm) r4)
            goto L_0x00a7
        L_0x00c9:
            com.google.android.gms.internal.ads.zzvr r1 = r0.zzqa()
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r3, (android.os.IInterface) r1)
        L_0x00d3:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvv.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
