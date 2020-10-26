// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.IBinder;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.annotation.KeepName;
import android.os.Parcelable;

@KeepName
public final class BinderWrapper implements Parcelable
{
    public static final Parcelable$Creator<BinderWrapper> CREATOR;
    private IBinder zzaHj;
    
    static {
        CREATOR = (Parcelable$Creator)new zzp();
    }
    
    public BinderWrapper() {
        this.zzaHj = null;
    }
    
    public BinderWrapper(final IBinder zzaHj) {
        this.zzaHj = null;
        this.zzaHj = zzaHj;
    }
    
    private BinderWrapper(final Parcel parcel) {
        this.zzaHj = null;
        this.zzaHj = parcel.readStrongBinder();
    }
    
    public final int describeContents() {
        return 0;
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        parcel.writeStrongBinder(this.zzaHj);
    }
}
