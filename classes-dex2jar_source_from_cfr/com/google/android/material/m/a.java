/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$ClassLoaderCreator
 *  android.os.Parcelable$Creator
 */
package com.google.android.material.m;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.c.g;

public class a
extends androidx.e.a.a {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.ClassLoaderCreator<a>(){

        public a a(Parcel parcel) {
            return new a(parcel, null);
        }

        public a a(Parcel parcel, ClassLoader classLoader) {
            return new a(parcel, classLoader);
        }

        public a[] a(int n2) {
            return new a[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return this.a(parcel, classLoader);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    public final g<String, Bundle> a;

    private a(Parcel parcel, ClassLoader arrstring) {
        super(parcel, (ClassLoader)arrstring);
        int n2 = parcel.readInt();
        arrstring = new String[n2];
        parcel.readStringArray(arrstring);
        Object[] arrobject = new Bundle[n2];
        parcel.readTypedArray(arrobject, Bundle.CREATOR);
        this.a = new g(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a.put(arrstring[i2], (Bundle)arrobject[i2]);
        }
    }

    public a(Parcelable parcelable) {
        super(parcelable);
        this.a = new g();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ExtendableSavedState{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" states=");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
        int n3 = this.a.size();
        parcel.writeInt(n3);
        String[] arrstring = new String[n3];
        Bundle[] arrbundle = new Bundle[n3];
        for (n2 = 0; n2 < n3; ++n2) {
            arrstring[n2] = this.a.b(n2);
            arrbundle[n2] = this.a.c(n2);
        }
        parcel.writeStringArray(arrstring);
        parcel.writeTypedArray((Parcelable[])arrbundle, 0);
    }

}

