/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.b;
import androidx.versionedparcelable.c;

public class ParcelImpl
implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new Parcelable.Creator<ParcelImpl>(){

        public ParcelImpl a(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        public ParcelImpl[] a(int n2) {
            return new ParcelImpl[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private final c a;

    protected ParcelImpl(Parcel parcel) {
        this.a = new b(parcel).h();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        new b(parcel).a(this.a);
    }

}

