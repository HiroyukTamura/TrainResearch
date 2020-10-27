package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.InputStream;

@SafeParcelable.Class(creator = "CacheEntryParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzse> CREATOR = new zzsd();
    @SafeParcelable.Field(getter = "getContentFileDescriptor", mo11969id = 2)
    @Nullable
    private ParcelFileDescriptor zzbsl;

    public zzse() {
        this((ParcelFileDescriptor) null);
    }

    @SafeParcelable.Constructor
    public zzse(@SafeParcelable.Param(mo11972id = 2) @Nullable ParcelFileDescriptor parcelFileDescriptor) {
        this.zzbsl = parcelFileDescriptor;
    }

    private final synchronized ParcelFileDescriptor zzmx() {
        return this.zzbsl;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, zzmx(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final synchronized boolean zzmv() {
        return this.zzbsl != null;
    }

    @Nullable
    public final synchronized InputStream zzmw() {
        if (this.zzbsl == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbsl);
        this.zzbsl = null;
        return autoCloseInputStream;
    }
}
