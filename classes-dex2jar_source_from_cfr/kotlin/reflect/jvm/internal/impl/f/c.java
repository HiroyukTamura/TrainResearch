/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.f.d;
import kotlin.reflect.jvm.internal.impl.f.p;

class c
extends p {
    private final int d;
    private final int e;

    c(byte[] object, int n2, int n3) {
        super((byte[])object);
        if (n2 >= 0) {
            if (n3 >= 0) {
                if ((long)n2 + (long)n3 <= (long)((byte[])object).length) {
                    this.d = n2;
                    this.e = n3;
                    return;
                }
                object = new StringBuilder(48);
                ((StringBuilder)object).append("Offset+Length too large: ");
                ((StringBuilder)object).append(n2);
                ((StringBuilder)object).append("+");
                ((StringBuilder)object).append(n3);
                throw new IllegalArgumentException(((StringBuilder)object).toString());
            }
            object = new StringBuilder(29);
            ((StringBuilder)object).append("Length too small: ");
            ((StringBuilder)object).append(n2);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        object = new StringBuilder(29);
        ((StringBuilder)object).append("Offset too small: ");
        ((StringBuilder)object).append(n2);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    @Override
    public byte a(int n2) {
        if (n2 >= 0) {
            if (n2 < this.a()) {
                return this.c[this.d + n2];
            }
            int n3 = this.a();
            StringBuilder stringBuilder = new StringBuilder(41);
            stringBuilder.append("Index too large: ");
            stringBuilder.append(n2);
            stringBuilder.append(", ");
            stringBuilder.append(n3);
            throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder(28);
        stringBuilder.append("Index too small: ");
        stringBuilder.append(n2);
        throw new ArrayIndexOutOfBoundsException(stringBuilder.toString());
    }

    @Override
    public int a() {
        return this.e;
    }

    @Override
    protected void a(byte[] arrby, int n2, int n3, int n4) {
        System.arraycopy(this.c, this.b() + n2, arrby, n3, n4);
    }

    @Override
    protected int b() {
        return this.d;
    }

    @Override
    public d.a c() {
        return new a();
    }

    @Override
    public /* synthetic */ Iterator iterator() {
        return this.c();
    }

    private class a
    implements d.a {
        private int b;
        private final int c;

        private a() {
            this.b = c.this.b();
            this.c = this.b + c.this.a();
        }

        public Byte a() {
            return this.b();
        }

        @Override
        public byte b() {
            if (this.b < this.c) {
                byte[] arrby = c.this.c;
                int n2 = this.b;
                this.b = n2 + 1;
                return arrby[n2];
            }
            throw new NoSuchElementException();
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

