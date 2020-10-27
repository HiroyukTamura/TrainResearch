package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
@KeepForSdk
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new zzb();
    private IBinder zzdl;

    public BinderWrapper() {
        this.zzdl = null;
    }

    @KeepForSdk
    public BinderWrapper(IBinder iBinder) {
        this.zzdl = null;
        this.zzdl = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.zzdl = null;
        this.zzdl = parcel.readStrongBinder();
    }

    /* synthetic */ BinderWrapper(Parcel parcel, zzb zzb) {
        this(parcel);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.zzdl);
    }
}
