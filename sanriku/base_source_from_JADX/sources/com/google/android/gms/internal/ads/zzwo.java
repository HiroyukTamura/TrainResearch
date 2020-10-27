package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public abstract class zzwo extends zzgk implements zzwp {
    public zzwo() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                initialize();
                break;
            case 2:
                setAppVolume(parcel.readFloat());
                break;
            case 3:
                zzcf(parcel.readString());
                break;
            case 4:
                setAppMuted(zzgj.zza(parcel));
                break;
            case 5:
                zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                break;
            case 6:
                zza(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 7:
                float zzqb = zzqb();
                parcel2.writeNoException();
                parcel2.writeFloat(zzqb);
                return true;
            case 8:
                boolean zzqc = zzqc();
                parcel2.writeNoException();
                zzgj.writeBoolean(parcel2, zzqc);
                return true;
            case 9:
                String versionString = getVersionString();
                parcel2.writeNoException();
                parcel2.writeString(versionString);
                return true;
            case 10:
                zzcg(parcel.readString());
                break;
            case 11:
                zza(zzalo.zzac(parcel.readStrongBinder()));
                break;
            case 12:
                zza(zzahg.zzaa(parcel.readStrongBinder()));
                break;
            case 13:
                List<zzaha> zzqd = zzqd();
                parcel2.writeNoException();
                parcel2.writeTypedList(zzqd);
                return true;
            case 14:
                zza((zzyy) zzgj.zza(parcel, zzyy.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
