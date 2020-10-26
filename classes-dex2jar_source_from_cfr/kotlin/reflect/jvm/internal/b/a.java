/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.b;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class a<E>
implements Iterable<E> {
    private static final a<Object> c = new a<E>();
    final E a;
    final a<E> b;
    private final int d;

    private a() {
        this.d = 0;
        this.a = null;
        this.b = null;
    }

    private a(E e2, a<E> a2) {
        this.a = e2;
        this.b = a2;
        this.d = a2.d + 1;
    }

    public static <E> a<E> a() {
        return c;
    }

    private a<E> b(Object a2) {
        if (this.d == 0) {
            return this;
        }
        if (this.a.equals(a2)) {
            return this.b;
        }
        if ((a2 = a.super.b(a2)) == this.b) {
            return this;
        }
        return new a<E>(this.a, a2);
    }

    private Iterator<E> c(int n2) {
        return new a<E>(this.d(n2));
    }

    private a<E> d(int n2) {
        if (n2 >= 0 && n2 <= this.d) {
            if (n2 == 0) {
                return this;
            }
            return a.super.d(n2 - 1);
        }
        throw new IndexOutOfBoundsException();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public E a(int n2) {
        E e2;
        if (n2 < 0) throw new IndexOutOfBoundsException();
        if (n2 > this.d) throw new IndexOutOfBoundsException();
        try {
            e2 = this.c(n2).next();
        }
        catch (NoSuchElementException noSuchElementException) {}
        return e2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index: ");
        stringBuilder.append(n2);
        throw new IndexOutOfBoundsException(stringBuilder.toString());
    }

    public a<E> a(E e2) {
        return new a<E>(e2, this);
    }

    public int b() {
        return this.d;
    }

    public a<E> b(int n2) {
        return this.b(this.a(n2));
    }

    @Override
    public Iterator<E> iterator() {
        return this.c(0);
    }

    private static class a<E>
    implements Iterator<E> {
        private a<E> a;

        public a(a<E> a2) {
            this.a = a2;
        }

        @Override
        public boolean hasNext() {
            return this.a.d > 0;
        }

        @Override
        public E next() {
            Object e2 = this.a.a;
            this.a = this.a.b;
            return e2;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}

