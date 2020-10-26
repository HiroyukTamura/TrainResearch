/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package android.support.v4.a;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public interface a
extends IInterface {
    public void a(int var1, Bundle var2);

    public static abstract class android.support.v4.a.a$a
    extends Binder
    implements android.support.v4.a.a {
        public android.support.v4.a.a$a() {
            this.attachInterface((IInterface)this, "android.support.v4.os.IResultReceiver");
        }

        public static android.support.v4.a.a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (iInterface != null && iInterface instanceof android.support.v4.a.a) {
                return (android.support.v4.a.a)iInterface;
            }
            return new a(iBinder);
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) {
            if (n2 != 1) {
                if (n2 != 1598968902) {
                    return super.onTransact(n2, object, parcel, n3);
                }
                parcel.writeString("android.support.v4.os.IResultReceiver");
                return true;
            }
            object.enforceInterface("android.support.v4.os.IResultReceiver");
            n2 = object.readInt();
            object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
            this.a(n2, (Bundle)object);
            return true;
        }

        private static class a
        implements android.support.v4.a.a {
            private IBinder a;

            a(IBinder iBinder) {
                this.a = iBinder;
            }

            @Override
            public void a(int n2, Bundle bundle) {
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("android.support.v4.os.IResultReceiver");
                    parcel.writeInt(n2);
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.a.transact(1, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            public IBinder asBinder() {
                return this.a;
            }
        }

    }

}

