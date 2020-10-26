/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package android.support.v4.a;

import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.a.a;

public class b
implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>(){

        public b a(Parcel parcel) {
            return new b(parcel);
        }

        public b[] a(int n2) {
            return new b[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    final boolean a = false;
    final Handler b = null;
    android.support.v4.a.a c;

    b(Parcel parcel) {
        this.c = a.a.a(parcel.readStrongBinder());
    }

    protected void a(int n2, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void writeToParcel(Parcel parcel, int n2) {
        synchronized (this) {
            if (this.c == null) {
                this.c = new a();
            }
            parcel.writeStrongBinder(this.c.asBinder());
            return;
        }
    }

    class a
    extends a.a {
        a() {
        }

        @Override
        public void a(int n2, Bundle bundle) {
            if (b.this.b != null) {
                b.this.b.post((Runnable)new b(n2, bundle));
                return;
            }
            b.this.a(n2, bundle);
        }
    }

    class b
    implements Runnable {
        final int a;
        final Bundle b;

        b(int n2, Bundle bundle) {
            this.a = n2;
            this.b = bundle;
        }

        @Override
        public void run() {
            b.this.a(this.a, this.b);
        }
    }

}

