package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.maps.zzaf;
import com.google.android.gms.internal.maps.zzag;

@SafeParcelable.Class(creator = "TileOverlayOptionsCreator")
@SafeParcelable.Reserved({1})
public final class TileOverlayOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TileOverlayOptions> CREATOR = new zzu();
    @SafeParcelable.Field(getter = "getZIndex", mo11969id = 4)
    private float zzcs;
    @SafeParcelable.Field(getter = "isVisible", mo11969id = 3)
    private boolean zzct = true;
    @SafeParcelable.Field(getter = "getTransparency", mo11969id = 6)
    private float zzda = 0.0f;
    /* access modifiers changed from: private */
    @SafeParcelable.Field(getter = "getTileProviderDelegate", mo11969id = 2, type = "android.os.IBinder")
    public zzaf zzei;
    private TileProvider zzej;
    @SafeParcelable.Field(defaultValue = "true", getter = "getFadeIn", mo11969id = 5)
    private boolean zzek = true;

    public TileOverlayOptions() {
    }

    @SafeParcelable.Constructor
    TileOverlayOptions(@SafeParcelable.Param(mo11972id = 2) IBinder iBinder, @SafeParcelable.Param(mo11972id = 3) boolean z, @SafeParcelable.Param(mo11972id = 4) float f, @SafeParcelable.Param(mo11972id = 5) boolean z2, @SafeParcelable.Param(mo11972id = 6) float f2) {
        zzaf zzk = zzag.zzk(iBinder);
        this.zzei = zzk;
        this.zzej = zzk == null ? null : new zzs(this);
        this.zzct = z;
        this.zzcs = f;
        this.zzek = z2;
        this.zzda = f2;
    }

    public final TileOverlayOptions fadeIn(boolean z) {
        this.zzek = z;
        return this;
    }

    public final boolean getFadeIn() {
        return this.zzek;
    }

    public final TileProvider getTileProvider() {
        return this.zzej;
    }

    public final float getTransparency() {
        return this.zzda;
    }

    public final float getZIndex() {
        return this.zzcs;
    }

    public final boolean isVisible() {
        return this.zzct;
    }

    public final TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.zzej = tileProvider;
        this.zzei = tileProvider == null ? null : new zzt(this, tileProvider);
        return this;
    }

    public final TileOverlayOptions transparency(float f) {
        Preconditions.checkArgument(f >= 0.0f && f <= 1.0f, "Transparency must be in the range [0..1]");
        this.zzda = f;
        return this;
    }

    public final TileOverlayOptions visible(boolean z) {
        this.zzct = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzei.asBinder(), false);
        SafeParcelWriter.writeBoolean(parcel, 3, isVisible());
        SafeParcelWriter.writeFloat(parcel, 4, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 5, getFadeIn());
        SafeParcelWriter.writeFloat(parcel, 6, getTransparency());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final TileOverlayOptions zIndex(float f) {
        this.zzcs = f;
        return this;
    }
}
