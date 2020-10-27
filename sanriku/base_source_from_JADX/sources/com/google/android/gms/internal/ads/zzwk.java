package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzwk extends zzgi implements zzwi {
    zzwk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    public final zzacw zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper2);
        Parcel transactAndReadException = transactAndReadException(5, obtainAndWriteInterfaceToken);
        zzacw zzp = zzacz.zzp(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzp;
    }

    public final zzadd zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper2);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper3);
        Parcel transactAndReadException = transactAndReadException(11, obtainAndWriteInterfaceToken);
        zzadd zzq = zzadc.zzq(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzq;
    }

    public final zzask zza(IObjectWrapper iObjectWrapper, zzalp zzalp, int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzalp);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(6, obtainAndWriteInterfaceToken);
        zzask zzal = zzasj.zzal(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzal;
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzvs zza(com.google.android.gms.dynamic.IObjectWrapper r2, java.lang.String r3, com.google.android.gms.internal.ads.zzalp r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.obtainAndWriteInterfaceToken()
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r0, (android.os.IInterface) r2)
            r0.writeString(r3)
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r0, (android.os.IInterface) r4)
            r0.writeInt(r5)
            r2 = 3
            android.os.Parcel r2 = r1.transactAndReadException(r2, r0)
            android.os.IBinder r3 = r2.readStrongBinder()
            if (r3 != 0) goto L_0x001d
            r3 = 0
            goto L_0x0031
        L_0x001d:
            java.lang.String r4 = "com.google.android.gms.ads.internal.client.IAdLoaderBuilder"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzvs
            if (r5 == 0) goto L_0x002b
            r3 = r4
            com.google.android.gms.internal.ads.zzvs r3 = (com.google.android.gms.internal.ads.zzvs) r3
            goto L_0x0031
        L_0x002b:
            com.google.android.gms.internal.ads.zzvu r4 = new com.google.android.gms.internal.ads.zzvu
            r4.<init>(r3)
            r3 = r4
        L_0x0031:
            r2.recycle()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwk.zza(com.google.android.gms.dynamic.IObjectWrapper, java.lang.String, com.google.android.gms.internal.ads.zzalp, int):com.google.android.gms.internal.ads.zzvs");
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzvz zza(com.google.android.gms.dynamic.IObjectWrapper r2, com.google.android.gms.internal.ads.zzum r3, java.lang.String r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.obtainAndWriteInterfaceToken()
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r0, (android.os.IInterface) r2)
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r0, (android.os.Parcelable) r3)
            r0.writeString(r4)
            r0.writeInt(r5)
            r2 = 10
            android.os.Parcel r2 = r1.transactAndReadException(r2, r0)
            android.os.IBinder r3 = r2.readStrongBinder()
            if (r3 != 0) goto L_0x001e
            r3 = 0
            goto L_0x0032
        L_0x001e:
            java.lang.String r4 = "com.google.android.gms.ads.internal.client.IAdManager"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzvz
            if (r5 == 0) goto L_0x002c
            r3 = r4
            com.google.android.gms.internal.ads.zzvz r3 = (com.google.android.gms.internal.ads.zzvz) r3
            goto L_0x0032
        L_0x002c:
            com.google.android.gms.internal.ads.zzwb r4 = new com.google.android.gms.internal.ads.zzwb
            r4.<init>(r3)
            r3 = r4
        L_0x0032:
            r2.recycle()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwk.zza(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzum, java.lang.String, int):com.google.android.gms.internal.ads.zzvz");
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzvz zza(com.google.android.gms.dynamic.IObjectWrapper r2, com.google.android.gms.internal.ads.zzum r3, java.lang.String r4, com.google.android.gms.internal.ads.zzalp r5, int r6) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.obtainAndWriteInterfaceToken()
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r0, (android.os.IInterface) r2)
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r0, (android.os.Parcelable) r3)
            r0.writeString(r4)
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r0, (android.os.IInterface) r5)
            r0.writeInt(r6)
            r2 = 1
            android.os.Parcel r2 = r1.transactAndReadException(r2, r0)
            android.os.IBinder r3 = r2.readStrongBinder()
            if (r3 != 0) goto L_0x0020
            r3 = 0
            goto L_0x0034
        L_0x0020:
            java.lang.String r4 = "com.google.android.gms.ads.internal.client.IAdManager"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzvz
            if (r5 == 0) goto L_0x002e
            r3 = r4
            com.google.android.gms.internal.ads.zzvz r3 = (com.google.android.gms.internal.ads.zzvz) r3
            goto L_0x0034
        L_0x002e:
            com.google.android.gms.internal.ads.zzwb r4 = new com.google.android.gms.internal.ads.zzwb
            r4.<init>(r3)
            r3 = r4
        L_0x0034:
            r2.recycle()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwk.zza(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzum, java.lang.String, com.google.android.gms.internal.ads.zzalp, int):com.google.android.gms.internal.ads.zzvz");
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzwp zza(com.google.android.gms.dynamic.IObjectWrapper r3, int r4) throws android.os.RemoteException {
        /*
            r2 = this;
            android.os.Parcel r0 = r2.obtainAndWriteInterfaceToken()
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r0, (android.os.IInterface) r3)
            r0.writeInt(r4)
            r3 = 9
            android.os.Parcel r3 = r2.transactAndReadException(r3, r0)
            android.os.IBinder r4 = r3.readStrongBinder()
            if (r4 != 0) goto L_0x0018
            r4 = 0
            goto L_0x002c
        L_0x0018:
            java.lang.String r0 = "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager"
            android.os.IInterface r0 = r4.queryLocalInterface(r0)
            boolean r1 = r0 instanceof com.google.android.gms.internal.ads.zzwp
            if (r1 == 0) goto L_0x0026
            r4 = r0
            com.google.android.gms.internal.ads.zzwp r4 = (com.google.android.gms.internal.ads.zzwp) r4
            goto L_0x002c
        L_0x0026:
            com.google.android.gms.internal.ads.zzwr r0 = new com.google.android.gms.internal.ads.zzwr
            r0.<init>(r4)
            r4 = r0
        L_0x002c:
            r3.recycle()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwk.zza(com.google.android.gms.dynamic.IObjectWrapper, int):com.google.android.gms.internal.ads.zzwp");
    }

    public final zzapg zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(8, obtainAndWriteInterfaceToken);
        zzapg zzag = zzapf.zzag(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzag;
    }

    public final zzatf zzb(IObjectWrapper iObjectWrapper, String str, zzalp zzalp, int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        obtainAndWriteInterfaceToken.writeString(str);
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) zzalp);
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel transactAndReadException = transactAndReadException(12, obtainAndWriteInterfaceToken);
        zzatf zzap = zzati.zzap(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzap;
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzvz zzb(com.google.android.gms.dynamic.IObjectWrapper r2, com.google.android.gms.internal.ads.zzum r3, java.lang.String r4, com.google.android.gms.internal.ads.zzalp r5, int r6) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.obtainAndWriteInterfaceToken()
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r0, (android.os.IInterface) r2)
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r0, (android.os.Parcelable) r3)
            r0.writeString(r4)
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r0, (android.os.IInterface) r5)
            r0.writeInt(r6)
            r2 = 2
            android.os.Parcel r2 = r1.transactAndReadException(r2, r0)
            android.os.IBinder r3 = r2.readStrongBinder()
            if (r3 != 0) goto L_0x0020
            r3 = 0
            goto L_0x0034
        L_0x0020:
            java.lang.String r4 = "com.google.android.gms.ads.internal.client.IAdManager"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzvz
            if (r5 == 0) goto L_0x002e
            r3 = r4
            com.google.android.gms.internal.ads.zzvz r3 = (com.google.android.gms.internal.ads.zzvz) r3
            goto L_0x0034
        L_0x002e:
            com.google.android.gms.internal.ads.zzwb r4 = new com.google.android.gms.internal.ads.zzwb
            r4.<init>(r3)
            r3 = r4
        L_0x0034:
            r2.recycle()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwk.zzb(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzum, java.lang.String, com.google.android.gms.internal.ads.zzalp, int):com.google.android.gms.internal.ads.zzvz");
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzvz zzc(com.google.android.gms.dynamic.IObjectWrapper r2, com.google.android.gms.internal.ads.zzum r3, java.lang.String r4, com.google.android.gms.internal.ads.zzalp r5, int r6) throws android.os.RemoteException {
        /*
            r1 = this;
            android.os.Parcel r0 = r1.obtainAndWriteInterfaceToken()
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r0, (android.os.IInterface) r2)
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r0, (android.os.Parcelable) r3)
            r0.writeString(r4)
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r0, (android.os.IInterface) r5)
            r0.writeInt(r6)
            r2 = 13
            android.os.Parcel r2 = r1.transactAndReadException(r2, r0)
            android.os.IBinder r3 = r2.readStrongBinder()
            if (r3 != 0) goto L_0x0021
            r3 = 0
            goto L_0x0035
        L_0x0021:
            java.lang.String r4 = "com.google.android.gms.ads.internal.client.IAdManager"
            android.os.IInterface r4 = r3.queryLocalInterface(r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.ads.zzvz
            if (r5 == 0) goto L_0x002f
            r3 = r4
            com.google.android.gms.internal.ads.zzvz r3 = (com.google.android.gms.internal.ads.zzvz) r3
            goto L_0x0035
        L_0x002f:
            com.google.android.gms.internal.ads.zzwb r4 = new com.google.android.gms.internal.ads.zzwb
            r4.<init>(r3)
            r3 = r4
        L_0x0035:
            r2.recycle()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwk.zzc(com.google.android.gms.dynamic.IObjectWrapper, com.google.android.gms.internal.ads.zzum, java.lang.String, com.google.android.gms.internal.ads.zzalp, int):com.google.android.gms.internal.ads.zzvz");
    }

    /* JADX WARNING: type inference failed for: r1v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzwp zzc(com.google.android.gms.dynamic.IObjectWrapper r4) throws android.os.RemoteException {
        /*
            r3 = this;
            android.os.Parcel r0 = r3.obtainAndWriteInterfaceToken()
            com.google.android.gms.internal.ads.zzgj.zza((android.os.Parcel) r0, (android.os.IInterface) r4)
            r4 = 4
            android.os.Parcel r4 = r3.transactAndReadException(r4, r0)
            android.os.IBinder r0 = r4.readStrongBinder()
            if (r0 != 0) goto L_0x0014
            r0 = 0
            goto L_0x0028
        L_0x0014:
            java.lang.String r1 = "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.ads.zzwp
            if (r2 == 0) goto L_0x0022
            r0 = r1
            com.google.android.gms.internal.ads.zzwp r0 = (com.google.android.gms.internal.ads.zzwp) r0
            goto L_0x0028
        L_0x0022:
            com.google.android.gms.internal.ads.zzwr r1 = new com.google.android.gms.internal.ads.zzwr
            r1.<init>(r0)
            r0 = r1
        L_0x0028:
            r4.recycle()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwk.zzc(com.google.android.gms.dynamic.IObjectWrapper):com.google.android.gms.internal.ads.zzwp");
    }

    public final zzapr zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgj.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        Parcel transactAndReadException = transactAndReadException(7, obtainAndWriteInterfaceToken);
        zzapr zzai = zzapu.zzai(transactAndReadException.readStrongBinder());
        transactAndReadException.recycle();
        return zzai;
    }
}
