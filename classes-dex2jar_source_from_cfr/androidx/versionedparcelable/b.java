/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.util.SparseIntArray
 */
package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseIntArray;
import androidx.versionedparcelable.a;

class b
extends a {
    private final SparseIntArray a = new SparseIntArray();
    private final Parcel b;
    private final int c;
    private final int d;
    private final String e;
    private int f = -1;
    private int g = 0;

    b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "");
    }

    b(Parcel parcel, int n2, int n3, String string2) {
        this.b = parcel;
        this.c = n2;
        this.d = n3;
        this.g = this.c;
        this.e = string2;
    }

    private int d(int n2) {
        while (this.g < this.d) {
            this.b.setDataPosition(this.g);
            int n3 = this.b.readInt();
            int n4 = this.b.readInt();
            this.g += n3;
            if (n4 != n2) continue;
            return this.b.dataPosition();
        }
        return -1;
    }

    @Override
    public void a(int n2) {
        this.b.writeInt(n2);
    }

    @Override
    public void a(Parcelable parcelable) {
        this.b.writeParcelable(parcelable, 0);
    }

    @Override
    public void a(String string2) {
        this.b.writeString(string2);
    }

    @Override
    public void a(byte[] arrby) {
        if (arrby != null) {
            this.b.writeInt(arrby.length);
            this.b.writeByteArray(arrby);
            return;
        }
        this.b.writeInt(-1);
    }

    @Override
    public void b() {
        if (this.f >= 0) {
            int n2 = this.a.get(this.f);
            int n3 = this.b.dataPosition();
            this.b.setDataPosition(n2);
            this.b.writeInt(n3 - n2);
            this.b.setDataPosition(n3);
        }
    }

    @Override
    public boolean b(int n2) {
        if ((n2 = this.d(n2)) == -1) {
            return false;
        }
        this.b.setDataPosition(n2);
        return true;
    }

    @Override
    protected a c() {
        Parcel parcel = this.b;
        int n2 = this.b.dataPosition();
        int n3 = this.g == this.c ? this.d : this.g;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.e);
        stringBuilder.append("  ");
        return new b(parcel, n2, n3, stringBuilder.toString());
    }

    @Override
    public void c(int n2) {
        this.b();
        this.f = n2;
        this.a.put(n2, this.b.dataPosition());
        this.a(0);
        this.a(n2);
    }

    @Override
    public int d() {
        return this.b.readInt();
    }

    @Override
    public String e() {
        return this.b.readString();
    }

    @Override
    public byte[] f() {
        int n2 = this.b.readInt();
        if (n2 < 0) {
            return null;
        }
        byte[] arrby = new byte[n2];
        this.b.readByteArray(arrby);
        return arrby;
    }

    @Override
    public <T extends Parcelable> T g() {
        return (T)this.b.readParcelable(this.getClass().getClassLoader());
    }
}

