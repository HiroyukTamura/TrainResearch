package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class zzlo extends zzlu {
    public static final Parcelable.Creator<zzlo> CREATOR = new zzlq();
    private final String description;
    private final String mimeType;
    private final int zzbar;
    private final byte[] zzbas;

    zzlo(Parcel parcel) {
        super("APIC");
        this.mimeType = parcel.readString();
        this.description = parcel.readString();
        this.zzbar = parcel.readInt();
        this.zzbas = parcel.createByteArray();
    }

    public zzlo(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.mimeType = str;
        this.description = null;
        this.zzbar = 3;
        this.zzbas = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzlo.class == obj.getClass()) {
            zzlo zzlo = (zzlo) obj;
            return this.zzbar == zzlo.zzbar && zzov.zza(this.mimeType, zzlo.mimeType) && zzov.zza(this.description, zzlo.description) && Arrays.equals(this.zzbas, zzlo.zzbas);
        }
    }

    public final int hashCode() {
        int i = (this.zzbar + 527) * 31;
        String str = this.mimeType;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return Arrays.hashCode(this.zzbas) + ((hashCode + i2) * 31);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.zzbar);
        parcel.writeByteArray(this.zzbas);
    }
}
