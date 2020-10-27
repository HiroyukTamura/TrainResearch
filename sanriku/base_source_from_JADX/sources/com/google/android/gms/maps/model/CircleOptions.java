package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "CircleOptionsCreator")
@SafeParcelable.Reserved({1})
public final class CircleOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CircleOptions> CREATOR = new zzc();
    @SafeParcelable.Field(getter = "getFillColor", mo11969id = 6)
    private int fillColor = 0;
    @SafeParcelable.Field(getter = "getStrokeColor", mo11969id = 5)
    private int strokeColor = ViewCompat.MEASURED_STATE_MASK;
    @SafeParcelable.Field(getter = "getCenter", mo11969id = 2)
    private LatLng zzcp = null;
    @SafeParcelable.Field(getter = "getRadius", mo11969id = 3)
    private double zzcq = 0.0d;
    @SafeParcelable.Field(getter = "getStrokeWidth", mo11969id = 4)
    private float zzcr = 10.0f;
    @SafeParcelable.Field(getter = "getZIndex", mo11969id = 7)
    private float zzcs = 0.0f;
    @SafeParcelable.Field(getter = "isVisible", mo11969id = 8)
    private boolean zzct = true;
    @SafeParcelable.Field(getter = "isClickable", mo11969id = 9)
    private boolean zzcu = false;
    @SafeParcelable.Field(getter = "getStrokePattern", mo11969id = 10)
    @Nullable
    private List<PatternItem> zzcv = null;

    public CircleOptions() {
    }

    @SafeParcelable.Constructor
    CircleOptions(@SafeParcelable.Param(mo11972id = 2) LatLng latLng, @SafeParcelable.Param(mo11972id = 3) double d, @SafeParcelable.Param(mo11972id = 4) float f, @SafeParcelable.Param(mo11972id = 5) int i, @SafeParcelable.Param(mo11972id = 6) int i2, @SafeParcelable.Param(mo11972id = 7) float f2, @SafeParcelable.Param(mo11972id = 8) boolean z, @SafeParcelable.Param(mo11972id = 9) boolean z2, @SafeParcelable.Param(mo11972id = 10) @Nullable List<PatternItem> list) {
        this.zzcp = latLng;
        this.zzcq = d;
        this.zzcr = f;
        this.strokeColor = i;
        this.fillColor = i2;
        this.zzcs = f2;
        this.zzct = z;
        this.zzcu = z2;
        this.zzcv = list;
    }

    public final CircleOptions center(LatLng latLng) {
        this.zzcp = latLng;
        return this;
    }

    public final CircleOptions clickable(boolean z) {
        this.zzcu = z;
        return this;
    }

    public final CircleOptions fillColor(int i) {
        this.fillColor = i;
        return this;
    }

    public final LatLng getCenter() {
        return this.zzcp;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final double getRadius() {
        return this.zzcq;
    }

    public final int getStrokeColor() {
        return this.strokeColor;
    }

    @Nullable
    public final List<PatternItem> getStrokePattern() {
        return this.zzcv;
    }

    public final float getStrokeWidth() {
        return this.zzcr;
    }

    public final float getZIndex() {
        return this.zzcs;
    }

    public final boolean isClickable() {
        return this.zzcu;
    }

    public final boolean isVisible() {
        return this.zzct;
    }

    public final CircleOptions radius(double d) {
        this.zzcq = d;
        return this;
    }

    public final CircleOptions strokeColor(int i) {
        this.strokeColor = i;
        return this;
    }

    public final CircleOptions strokePattern(@Nullable List<PatternItem> list) {
        this.zzcv = list;
        return this;
    }

    public final CircleOptions strokeWidth(float f) {
        this.zzcr = f;
        return this;
    }

    public final CircleOptions visible(boolean z) {
        this.zzct = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, getCenter(), i, false);
        SafeParcelWriter.writeDouble(parcel, 3, getRadius());
        SafeParcelWriter.writeFloat(parcel, 4, getStrokeWidth());
        SafeParcelWriter.writeInt(parcel, 5, getStrokeColor());
        SafeParcelWriter.writeInt(parcel, 6, getFillColor());
        SafeParcelWriter.writeFloat(parcel, 7, getZIndex());
        SafeParcelWriter.writeBoolean(parcel, 8, isVisible());
        SafeParcelWriter.writeBoolean(parcel, 9, isClickable());
        SafeParcelWriter.writeTypedList(parcel, 10, getStrokePattern(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final CircleOptions zIndex(float f) {
        this.zzcs = f;
        return this;
    }
}
