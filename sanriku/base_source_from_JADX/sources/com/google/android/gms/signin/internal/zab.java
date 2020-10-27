package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AuthAccountResultCreator")
public final class zab extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zab> CREATOR = new zaa();
    @SafeParcelable.VersionField(mo11975id = 1)
    private final int versionCode;
    @SafeParcelable.Field(getter = "getConnectionResultCode", mo11969id = 2)
    private int zasv;
    @SafeParcelable.Field(getter = "getRawAuthResolutionIntent", mo11969id = 3)
    @Nullable
    private Intent zasw;

    public zab() {
        this(0, (Intent) null);
    }

    @SafeParcelable.Constructor
    zab(@SafeParcelable.Param(mo11972id = 1) int i, @SafeParcelable.Param(mo11972id = 2) int i2, @SafeParcelable.Param(mo11972id = 3) @Nullable Intent intent) {
        this.versionCode = i;
        this.zasv = i2;
        this.zasw = intent;
    }

    private zab(int i, @Nullable Intent intent) {
        this(2, 0, (Intent) null);
    }

    public final Status getStatus() {
        return this.zasv == 0 ? Status.RESULT_SUCCESS : Status.RESULT_CANCELED;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeInt(parcel, 2, this.zasv);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zasw, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
