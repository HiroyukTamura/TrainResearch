package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

public final class zzlt extends zzlu {
    public static final Parcelable.Creator<zzlt> CREATOR = new zzlw();
    private final String description;
    private final String value;

    zzlt(Parcel parcel) {
        super(parcel.readString());
        this.description = parcel.readString();
        this.value = parcel.readString();
    }

    public zzlt(String str, String str2, String str3) {
        super(str);
        this.description = null;
        this.value = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzlt.class == obj.getClass()) {
            zzlt zzlt = (zzlt) obj;
            return this.zzagd.equals(zzlt.zzagd) && zzov.zza(this.description, zzlt.description) && zzov.zza(this.value, zzlt.value);
        }
    }

    public final int hashCode() {
        int hashCode = (this.zzagd.hashCode() + 527) * 31;
        String str = this.description;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzagd);
        parcel.writeString(this.description);
        parcel.writeString(this.value);
    }
}
