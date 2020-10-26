// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;

public final class zzane implements Parcelable
{
    @Deprecated
    public static final Parcelable$Creator<zzane> CREATOR;
    private String mValue;
    private String zzIi;
    private String zzagP;
    
    static {
        CREATOR = (Parcelable$Creator)new zzanf();
    }
    
    @Deprecated
    public zzane() {
    }
    
    @Deprecated
    zzane(final Parcel parcel) {
        this.zzIi = parcel.readString();
        this.zzagP = parcel.readString();
        this.mValue = parcel.readString();
    }
    
    @Deprecated
    public final int describeContents() {
        return 0;
    }
    
    public final String getId() {
        return this.zzIi;
    }
    
    public final String getValue() {
        return this.mValue;
    }
    
    @Deprecated
    public final void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeString(this.zzIi);
        parcel.writeString(this.zzagP);
        parcel.writeString(this.mValue);
    }
}
