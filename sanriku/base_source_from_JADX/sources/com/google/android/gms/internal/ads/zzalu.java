package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzalu extends zzgk implements zzalv {
    public zzalu() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzalv zzad(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        return queryLocalInterface instanceof zzalv ? (zzalv) queryLocalInterface : new zzalx(iBinder);
    }

    /* JADX WARNING: type inference failed for: r2v2, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            switch(r1) {
                case 1: goto L_0x00c3;
                case 2: goto L_0x00bf;
                case 3: goto L_0x00b7;
                case 4: goto L_0x00b3;
                case 5: goto L_0x00af;
                case 6: goto L_0x00ab;
                case 7: goto L_0x008b;
                case 8: goto L_0x0087;
                case 9: goto L_0x007b;
                case 10: goto L_0x006b;
                case 11: goto L_0x0067;
                case 12: goto L_0x005f;
                case 13: goto L_0x005a;
                case 14: goto L_0x004d;
                case 15: goto L_0x0048;
                case 16: goto L_0x003b;
                case 17: goto L_0x0032;
                case 18: goto L_0x002d;
                case 19: goto L_0x0020;
                case 20: goto L_0x001b;
                case 21: goto L_0x0012;
                case 22: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r1 = 0
            return r1
        L_0x0005:
            int r1 = r2.readInt()
            java.lang.String r2 = r2.readString()
            r0.zzc(r1, r2)
            goto L_0x00c6
        L_0x0012:
            java.lang.String r1 = r2.readString()
            r0.zzdm(r1)
            goto L_0x00c6
        L_0x001b:
            r0.onVideoPlay()
            goto L_0x00c6
        L_0x0020:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r2, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            r0.zzb((android.os.Bundle) r1)
            goto L_0x00c6
        L_0x002d:
            r0.zztq()
            goto L_0x00c6
        L_0x0032:
            int r1 = r2.readInt()
            r0.zzcx(r1)
            goto L_0x00c6
        L_0x003b:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzate r1 = com.google.android.gms.internal.ads.zzatd.zzao(r1)
            r0.zza((com.google.android.gms.internal.ads.zzate) r1)
            goto L_0x00c6
        L_0x0048:
            r0.onVideoPause()
            goto L_0x00c6
        L_0x004d:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzatc> r1 = com.google.android.gms.internal.ads.zzatc.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r2, r1)
            com.google.android.gms.internal.ads.zzatc r1 = (com.google.android.gms.internal.ads.zzatc) r1
            r0.zzb((com.google.android.gms.internal.ads.zzatc) r1)
            goto L_0x00c6
        L_0x005a:
            r0.zztp()
            goto L_0x00c6
        L_0x005f:
            java.lang.String r1 = r2.readString()
            r0.zzdl(r1)
            goto L_0x00c6
        L_0x0067:
            r0.onVideoEnd()
            goto L_0x00c6
        L_0x006b:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.internal.ads.zzado r1 = com.google.android.gms.internal.ads.zzadr.zzr(r1)
            java.lang.String r2 = r2.readString()
            r0.zza(r1, r2)
            goto L_0x00c6
        L_0x007b:
            java.lang.String r1 = r2.readString()
            java.lang.String r2 = r2.readString()
            r0.onAppEvent(r1, r2)
            goto L_0x00c6
        L_0x0087:
            r0.onAdImpression()
            goto L_0x00c6
        L_0x008b:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x0093
            r1 = 0
            goto L_0x00a7
        L_0x0093:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzalw
            if (r4 == 0) goto L_0x00a1
            r1 = r2
            com.google.android.gms.internal.ads.zzalw r1 = (com.google.android.gms.internal.ads.zzalw) r1
            goto L_0x00a7
        L_0x00a1:
            com.google.android.gms.internal.ads.zzalz r2 = new com.google.android.gms.internal.ads.zzalz
            r2.<init>(r1)
            r1 = r2
        L_0x00a7:
            r0.zza((com.google.android.gms.internal.ads.zzalw) r1)
            goto L_0x00c6
        L_0x00ab:
            r0.onAdLoaded()
            goto L_0x00c6
        L_0x00af:
            r0.onAdOpened()
            goto L_0x00c6
        L_0x00b3:
            r0.onAdLeftApplication()
            goto L_0x00c6
        L_0x00b7:
            int r1 = r2.readInt()
            r0.onAdFailedToLoad(r1)
            goto L_0x00c6
        L_0x00bf:
            r0.onAdClosed()
            goto L_0x00c6
        L_0x00c3:
            r0.onAdClicked()
        L_0x00c6:
            r3.writeNoException()
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalu.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
