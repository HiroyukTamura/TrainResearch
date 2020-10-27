package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;

@SafeParcelable.Class(creator = "NativeAdLayoutInfoParcelCreator")
public final class zzaqh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaqh> CREATOR = new zzaqk();
    @SafeParcelable.Field(getter = "getAdViewAsBinder", mo11969id = 1, type = "android.os.IBinder")
    public final View zzaae;
    @SafeParcelable.Field(getter = "getAssetViewMapAsBinder", mo11969id = 2, type = "android.os.IBinder")
    public final Map<String, WeakReference<View>> zzdli;

    @SafeParcelable.Constructor
    public zzaqh(@SafeParcelable.Param(mo11972id = 1) IBinder iBinder, @SafeParcelable.Param(mo11972id = 2) IBinder iBinder2) {
        this.zzaae = (View) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzdli = (Map) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, ObjectWrapper.wrap(this.zzaae).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 2, ObjectWrapper.wrap(this.zzdli).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
