package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

@SafeParcelable.Class(creator = "ConverterWrapperCreator")
public final class zab extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zab> CREATOR = new zaa();
    @SafeParcelable.VersionField(mo11975id = 1)
    private final int zali;
    @SafeParcelable.Field(getter = "getStringToIntConverter", mo11969id = 2)
    private final StringToIntConverter zapz;

    @SafeParcelable.Constructor
    zab(@SafeParcelable.Param(mo11972id = 1) int i, @SafeParcelable.Param(mo11972id = 2) StringToIntConverter stringToIntConverter) {
        this.zali = i;
        this.zapz = stringToIntConverter;
    }

    private zab(StringToIntConverter stringToIntConverter) {
        this.zali = 1;
        this.zapz = stringToIntConverter;
    }

    public static zab zaa(FastJsonResponse.FieldConverter<?, ?> fieldConverter) {
        if (fieldConverter instanceof StringToIntConverter) {
            return new zab((StringToIntConverter) fieldConverter);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zali);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zapz, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final FastJsonResponse.FieldConverter<?, ?> zacg() {
        StringToIntConverter stringToIntConverter = this.zapz;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
}
