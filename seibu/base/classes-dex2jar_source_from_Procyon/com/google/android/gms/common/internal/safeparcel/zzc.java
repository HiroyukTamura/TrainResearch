// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;

public final class zzc extends RuntimeException
{
    public zzc(final String s, final Parcel parcel) {
        super(new StringBuilder(String.valueOf(s).length() + 41).append(s).append(" Parcel: pos=").append(parcel.dataPosition()).append(" size=").append(parcel.dataSize()).toString());
    }
}
