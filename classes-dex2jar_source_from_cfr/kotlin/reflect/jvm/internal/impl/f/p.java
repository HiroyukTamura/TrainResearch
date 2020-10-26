/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.f.d;
import kotlin.reflect.jvm.internal.impl.f.e;
import kotlin.reflect.jvm.internal.impl.f.u;
import kotlin.reflect.jvm.internal.impl.f.y;

class p
extends d {
    protected final byte[] c;
    private int d = 0;

    p(byte[] arrby) {
        this.c = arrby;
    }

    static int a(int n2, byte[] arrby, int n3, int n4) {
        int n5 = n2;
        for (n2 = n3; n2 < n3 + n4; ++n2) {
            n5 = n5 * 31 + arrby[n2];
        }
        return n5;
    }

    public byte a(int n2) {
        return this.c[n2];
    }

    @Override
    public int a() {
        return this.c.length;
    }

    @Override
    protected int a(int n2, int n3, int n4) {
        n3 = this.b() + n3;
        return y.a(n2, this.c, n3, n4 + n3);
    }

    @Override
    protected void a(byte[] arrby, int n2, int n3, int n4) {
        System.arraycopy(this.c, n2, arrby, n3, n4);
    }

    boolean a(p object, int n2, int n3) {
        if (n3 <= ((p)object).a()) {
            if (n2 + n3 <= ((p)object).a()) {
                byte[] arrby = this.c;
                byte[] arrby2 = ((p)object).c;
                int n4 = this.b();
                int n5 = this.b();
                n2 = ((p)object).b() + n2;
                while (n5 < n4 + n3) {
                    if (arrby[n5] != arrby2[n2]) {
                        return false;
                    }
                    ++n5;
                    ++n2;
                }
                return true;
            }
            int n6 = ((p)object).a();
            object = new StringBuilder(59);
            ((StringBuilder)object).append("Ran off end of other: ");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append(", ");
            ((StringBuilder)object).append(n3);
            ((StringBuilder)object).append(", ");
            ((StringBuilder)object).append(n6);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        n2 = this.a();
        object = new StringBuilder(40);
        ((StringBuilder)object).append("Length too large: ");
        ((StringBuilder)object).append(n3);
        ((StringBuilder)object).append(n2);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    protected int b() {
        return 0;
    }

    @Override
    protected int b(int n2, int n3, int n4) {
        return p.a(n2, this.c, this.b() + n3, n4);
    }

    @Override
    public String b(String string2) {
        return new String(this.c, this.b(), this.a(), string2);
    }

    @Override
    void b(OutputStream outputStream, int n2, int n3) {
        outputStream.write(this.c, this.b() + n2, n3);
    }

    @Override
    public d.a c() {
        return new a();
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof d)) {
            return false;
        }
        if (this.a() != ((d)object).a()) {
            return false;
        }
        if (this.a() == 0) {
            return true;
        }
        if (object instanceof p) {
            return this.a((p)object, 0, this.a());
        }
        if (object instanceof u) {
            return object.equals(this);
        }
        object = String.valueOf(String.valueOf(object.getClass()));
        StringBuilder stringBuilder = new StringBuilder(((String)object).length() + 49);
        stringBuilder.append("Has a new type of ByteString been created? Found ");
        stringBuilder.append((String)object);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @Override
    public boolean g() {
        int n2 = this.b();
        return y.a(this.c, n2, this.a() + n2);
    }

    @Override
    public e h() {
        return e.a(this);
    }

    public int hashCode() {
        int n2;
        int n3 = n2 = this.d;
        if (n2 == 0) {
            n3 = this.a();
            n3 = n2 = this.b(n3, 0, n3);
            if (n2 == 0) {
                n3 = 1;
            }
            this.d = n3;
        }
        return n3;
    }

    @Override
    public /* synthetic */ Iterator iterator() {
        return this.c();
    }

    @Override
    protected int j() {
        return 0;
    }

    @Override
    protected boolean k() {
        return true;
    }

    @Override
    protected int l() {
        return this.d;
    }

    private class a
    implements d.a {
        private int b = 0;
        private final int c;

        private a() {
            this.c = p.this.a();
        }

        public Byte a() {
            return this.b();
        }

        @Override
        public byte b() {
            byte[] arrby;
            int n2;
            try {
                arrby = p.this.c;
                n2 = this.b;
                this.b = n2 + 1;
            }
            catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                throw new NoSuchElementException(arrayIndexOutOfBoundsException.getMessage());
            }
            byte by2 = arrby[n2];
            return by2;
        }

        @Override
        public boolean hasNext() {
            return this.b < this.c;
        }

        @Override
        public /* synthetic */ Object next() {
            return this.a();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}

