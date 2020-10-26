/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.f.a;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.f.a.b;
import androidx.f.a.n;

final class l
implements Parcelable {
    public static final Parcelable.Creator<l> CREATOR = new Parcelable.Creator<l>(){

        public l a(Parcel parcel) {
            return new l(parcel);
        }

        public l[] a(int n2) {
            return new l[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    n[] a;
    int[] b;
    b[] c;
    int d = -1;
    int e;

    public l() {
    }

    public l(Parcel parcel) {
        this.a = (n[])parcel.createTypedArray(n.CREATOR);
        this.b = parcel.createIntArray();
        this.c = (b[])parcel.createTypedArray(b.CREATOR);
        this.d = parcel.readInt();
        this.e = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeTypedArray((Parcelable[])this.a, n2);
        parcel.writeIntArray(this.b);
        parcel.writeTypedArray((Parcelable[])this.c, n2);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
    }

}

