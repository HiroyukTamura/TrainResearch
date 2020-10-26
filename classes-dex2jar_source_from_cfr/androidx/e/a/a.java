/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$ClassLoaderCreator
 *  android.os.Parcelable$Creator
 */
package androidx.e.a;

import android.os.Parcel;
import android.os.Parcelable;

public abstract class a
implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR;
    public static final a c;
    private final Parcelable a;

    static {
        c = new a(){};
        CREATOR = new Parcelable.ClassLoaderCreator<a>(){

            public a a(Parcel parcel) {
                return this.a(parcel, null);
            }

            public a a(Parcel parcel, ClassLoader classLoader) {
                if (parcel.readParcelable(classLoader) == null) {
                    return a.c;
                }
                throw new IllegalStateException("superState must be null");
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
    }

    private a() {
        this.a = null;
    }

    protected a(Parcel object, ClassLoader classLoader) {
        object = object.readParcelable(classLoader);
        if (object == null) {
            object = c;
        }
        this.a = object;
    }

    protected a(Parcelable parcelable) {
        if (parcelable != null) {
            if (parcelable == c) {
                parcelable = null;
            }
            this.a = parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public final Parcelable a() {
        return this.a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeParcelable(this.a, n2);
    }

}

