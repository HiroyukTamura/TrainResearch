/*
 * Decompiled with CFR 0.139.
 */
package b.a.e.f;

import b.a.e.h.c;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class a<T>
implements b.a.e.c.c<T> {
    static final int a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final Object j = new Object();
    final AtomicLong b = new AtomicLong();
    int c;
    long d;
    final int e;
    AtomicReferenceArray<Object> f;
    final int g;
    AtomicReferenceArray<Object> h;
    final AtomicLong i = new AtomicLong();

    public a(int n2) {
        n2 = c.a(Math.max(8, n2));
        int n3 = n2 - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(n2 + 1);
        this.f = atomicReferenceArray;
        this.e = n3;
        this.a(n2);
        this.h = atomicReferenceArray;
        this.g = n3;
        this.d = n3 - 1;
        this.a(0L);
    }

    private static int a(long l2, int n2) {
        return a.b((int)l2 & n2);
    }

    private long a() {
        return this.b.get();
    }

    private T a(AtomicReferenceArray<Object> atomicReferenceArray, long l2, int n2) {
        this.h = atomicReferenceArray;
        Object object = a.b(atomicReferenceArray, n2 = a.a(l2, n2));
        if (object != null) {
            a.a(atomicReferenceArray, n2, null);
            this.b(l2 + 1L);
        }
        return (T)object;
    }

    private AtomicReferenceArray<Object> a(AtomicReferenceArray<Object> atomicReferenceArray, int n2) {
        n2 = a.b(n2);
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray)a.b(atomicReferenceArray, n2);
        a.a(atomicReferenceArray, n2, null);
        return atomicReferenceArray2;
    }

    private void a(int n2) {
        this.c = Math.min(n2 / 4, a);
    }

    private void a(long l2) {
        this.b.lazySet(l2);
    }

    private static void a(AtomicReferenceArray<Object> atomicReferenceArray, int n2, Object object) {
        atomicReferenceArray.lazySet(n2, object);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, long l2, int n2, T t2, long l3) {
        AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<Object>(atomicReferenceArray.length());
        this.f = atomicReferenceArray2;
        this.d = l3 + l2 - 1L;
        a.a(atomicReferenceArray2, n2, t2);
        this.a(atomicReferenceArray, atomicReferenceArray2);
        a.a(atomicReferenceArray, n2, j);
        this.a(l2 + 1L);
    }

    private void a(AtomicReferenceArray<Object> atomicReferenceArray, AtomicReferenceArray<Object> atomicReferenceArray2) {
        a.a(atomicReferenceArray, a.b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    private boolean a(AtomicReferenceArray<Object> atomicReferenceArray, T t2, long l2, int n2) {
        a.a(atomicReferenceArray, n2, t2);
        this.a(l2 + 1L);
        return true;
    }

    private static int b(int n2) {
        return n2;
    }

    private static <E> Object b(AtomicReferenceArray<Object> atomicReferenceArray, int n2) {
        return atomicReferenceArray.get(n2);
    }

    private void b(long l2) {
        this.i.lazySet(l2);
    }

    private long e() {
        return this.i.get();
    }

    private long f() {
        return this.b.get();
    }

    private long g() {
        return this.i.get();
    }

    @Override
    public boolean a(T t2) {
        if (t2 != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.f;
            long l2 = this.f();
            int n2 = this.e;
            int n3 = a.a(l2, n2);
            if (l2 < this.d) {
                return this.a(atomicReferenceArray, t2, l2, n3);
            }
            long l3 = (long)this.c + l2;
            if (a.b(atomicReferenceArray, a.a(l3, n2)) == null) {
                this.d = l3 - 1L;
                return this.a(atomicReferenceArray, t2, l2, n3);
            }
            if (a.b(atomicReferenceArray, a.a(1L + l2, n2)) == null) {
                return this.a(atomicReferenceArray, t2, l2, n3);
            }
            this.a(atomicReferenceArray, l2, n3, t2, n2);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override
    public T b() {
        int n2;
        AtomicReferenceArray<Object> atomicReferenceArray = this.h;
        long l2 = this.g();
        int n3 = a.a(l2, n2 = this.g);
        Object object = a.b(atomicReferenceArray, n3);
        boolean bl2 = object == j;
        if (object != null && !bl2) {
            a.a(atomicReferenceArray, n3, null);
            this.b(l2 + 1L);
            return (T)object;
        }
        if (bl2) {
            return this.a(this.a(atomicReferenceArray, n2 + 1), l2, n2);
        }
        return null;
    }

    @Override
    public boolean c() {
        return this.a() == this.e();
    }

    @Override
    public void d() {
        while (this.b() != null || !this.c()) {
        }
    }
}

