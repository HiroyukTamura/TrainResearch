/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;
import kotlin.reflect.jvm.internal.impl.f.d;
import kotlin.reflect.jvm.internal.impl.f.e;
import kotlin.reflect.jvm.internal.impl.f.p;

class u
extends kotlin.reflect.jvm.internal.impl.f.d {
    private static final int[] c;
    private final int d;
    private final kotlin.reflect.jvm.internal.impl.f.d e;
    private final kotlin.reflect.jvm.internal.impl.f.d f;
    private final int g;
    private final int h;
    private int i = 0;

    static {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n2 = 1;
        int n3 = 1;
        do {
            int n4 = n3;
            if (n2 <= 0) break;
            arrayList.add(n2);
            n3 = n2;
            n2 = n4 + n2;
        } while (true);
        arrayList.add(Integer.MAX_VALUE);
        c = new int[arrayList.size()];
        for (n2 = 0; n2 < c.length; ++n2) {
            u.c[n2] = (Integer)arrayList.get(n2);
        }
    }

    private u(kotlin.reflect.jvm.internal.impl.f.d d2, kotlin.reflect.jvm.internal.impl.f.d d3) {
        this.e = d2;
        this.f = d3;
        this.g = d2.a();
        this.d = this.g + d3.a();
        this.h = Math.max(d2.j(), d3.j()) + 1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static kotlin.reflect.jvm.internal.impl.f.d a(kotlin.reflect.jvm.internal.impl.f.d d2, kotlin.reflect.jvm.internal.impl.f.d d3) {
        u u2 = d2 instanceof u ? (u)d2 : null;
        if (d3.a() == 0) {
            return d2;
        }
        if (d2.a() == 0) {
            return d3;
        }
        int n2 = d2.a() + d3.a();
        if (n2 < 128) {
            return u.b(d2, d3);
        }
        if (u2 != null && u2.f.a() + d3.a() < 128) {
            d2 = u.b(u2.f, d3);
            return new u(u2.e, d2);
        }
        if (u2 != null && u2.e.j() > u2.f.j() && u2.j() > d3.j()) {
            d2 = new u(u2.f, d3);
            return new u(u2.e, d2);
        }
        int n3 = Math.max(d2.j(), d3.j());
        if (n2 < c[n3 + 1]) return new a().a(d2, d3);
        return new u(d2, d3);
    }

    private static p b(kotlin.reflect.jvm.internal.impl.f.d d2, kotlin.reflect.jvm.internal.impl.f.d d3) {
        int n2 = d2.a();
        int n3 = d3.a();
        byte[] arrby = new byte[n2 + n3];
        d2.b(arrby, 0, 0, n2);
        d3.b(arrby, 0, n2, n3);
        return new p(arrby);
    }

    private boolean b(kotlin.reflect.jvm.internal.impl.f.d d2) {
        b b2 = new b(this);
        p p2 = (p)b2.next();
        b b3 = new b(d2);
        d2 = (p)b3.next();
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        do {
            int n5 = p2.a() - n2;
            int n6 = ((p)d2).a() - n3;
            int n7 = Math.min(n5, n6);
            boolean bl2 = n2 == 0 ? p2.a((p)d2, n3, n7) : ((p)d2).a(p2, n2, n7);
            if (!bl2) {
                return false;
            }
            if ((n4 += n7) >= this.d) {
                if (n4 == this.d) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (n7 == n5) {
                p2 = (p)b2.next();
                n2 = 0;
            } else {
                n2 += n7;
            }
            if (n7 == n6) {
                d2 = (p)b3.next();
                n3 = 0;
                continue;
            }
            n3 += n7;
        } while (true);
    }

    @Override
    public int a() {
        return this.d;
    }

    @Override
    protected int a(int n2, int n3, int n4) {
        if (n3 + n4 <= this.g) {
            return this.e.a(n2, n3, n4);
        }
        if (n3 >= this.g) {
            return this.f.a(n2, n3 - this.g, n4);
        }
        int n5 = this.g - n3;
        n2 = this.e.a(n2, n3, n5);
        return this.f.a(n2, 0, n4 - n5);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    protected void a(byte[] arrby, int n2, int n3, int n4) {
        kotlin.reflect.jvm.internal.impl.f.d d2;
        if (n2 + n4 <= this.g) {
            d2 = this.e;
        } else {
            if (n2 < this.g) {
                int n5 = this.g - n2;
                this.e.a(arrby, n2, n3, n5);
                this.f.a(arrby, 0, n3 + n5, n4 - n5);
                return;
            }
            d2 = this.f;
            n2 -= this.g;
        }
        d2.a(arrby, n2, n3, n4);
    }

    @Override
    protected int b(int n2, int n3, int n4) {
        if (n3 + n4 <= this.g) {
            return this.e.b(n2, n3, n4);
        }
        if (n3 >= this.g) {
            return this.f.b(n2, n3 - this.g, n4);
        }
        int n5 = this.g - n3;
        n2 = this.e.b(n2, n3, n5);
        return this.f.b(n2, 0, n4 - n5);
    }

    @Override
    public String b(String string2) {
        return new String(this.e(), string2);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    void b(OutputStream outputStream, int n2, int n3) {
        kotlin.reflect.jvm.internal.impl.f.d d2;
        if (n2 + n3 <= this.g) {
            d2 = this.e;
        } else {
            if (n2 < this.g) {
                int n4 = this.g - n2;
                this.e.b(outputStream, n2, n4);
                this.f.b(outputStream, 0, n3 - n4);
                return;
            }
            d2 = this.f;
            n2 -= this.g;
        }
        d2.b(outputStream, n2, n3);
    }

    @Override
    public d.a c() {
        return new c();
    }

    public boolean equals(Object object) {
        int n2;
        if (object == this) {
            return true;
        }
        if (!(object instanceof kotlin.reflect.jvm.internal.impl.f.d)) {
            return false;
        }
        if (this.d != ((kotlin.reflect.jvm.internal.impl.f.d)(object = (kotlin.reflect.jvm.internal.impl.f.d)object)).a()) {
            return false;
        }
        if (this.d == 0) {
            return true;
        }
        if (this.i != 0 && (n2 = ((kotlin.reflect.jvm.internal.impl.f.d)object).l()) != 0 && this.i != n2) {
            return false;
        }
        return this.b((kotlin.reflect.jvm.internal.impl.f.d)object);
    }

    @Override
    public boolean g() {
        kotlin.reflect.jvm.internal.impl.f.d d2 = this.e;
        int n2 = this.g;
        boolean bl2 = false;
        if (this.f.a(n2 = d2.a(0, 0, n2), 0, this.f.a()) == 0) {
            bl2 = true;
        }
        return bl2;
    }

    @Override
    public e h() {
        return e.a(new d());
    }

    public int hashCode() {
        int n2;
        int n3 = n2 = this.i;
        if (n2 == 0) {
            n3 = n2 = this.b(this.d, 0, this.d);
            if (n2 == 0) {
                n3 = 1;
            }
            this.i = n3;
        }
        return n3;
    }

    @Override
    public /* synthetic */ Iterator iterator() {
        return this.c();
    }

    @Override
    protected int j() {
        return this.h;
    }

    @Override
    protected boolean k() {
        return this.d >= c[this.h];
    }

    @Override
    protected int l() {
        return this.i;
    }

    private static class a {
        private final Stack<kotlin.reflect.jvm.internal.impl.f.d> a = new Stack();

        private a() {
        }

        private int a(int n2) {
            int n3;
            n2 = n3 = Arrays.binarySearch(c, n2);
            if (n3 < 0) {
                n2 = -(n3 + 1) - 1;
            }
            return n2;
        }

        private kotlin.reflect.jvm.internal.impl.f.d a(kotlin.reflect.jvm.internal.impl.f.d d2, kotlin.reflect.jvm.internal.impl.f.d d3) {
            this.a(d2);
            this.a(d3);
            d2 = this.a.pop();
            while (!this.a.isEmpty()) {
                d2 = new u(this.a.pop(), d2);
            }
            return d2;
        }

        private void a(kotlin.reflect.jvm.internal.impl.f.d object) {
            if (((kotlin.reflect.jvm.internal.impl.f.d)object).k()) {
                this.b((kotlin.reflect.jvm.internal.impl.f.d)object);
                return;
            }
            if (object instanceof u) {
                object = (u)object;
                this.a(((u)object).e);
                this.a(((u)object).f);
                return;
            }
            object = String.valueOf(String.valueOf(object.getClass()));
            StringBuilder stringBuilder = new StringBuilder(((String)object).length() + 49);
            stringBuilder.append("Has a new type of ByteString been created? Found ");
            stringBuilder.append((String)object);
            throw new IllegalArgumentException(stringBuilder.toString());
        }

        private void b(kotlin.reflect.jvm.internal.impl.f.d d2) {
            int n2 = this.a(d2.a());
            int n3 = c[n2 + 1];
            if (!this.a.isEmpty() && this.a.peek().a() < n3) {
                n2 = c[n2];
                kotlin.reflect.jvm.internal.impl.f.d d3 = this.a.pop();
                while (!this.a.isEmpty() && this.a.peek().a() < n2) {
                    d3 = new u(this.a.pop(), d3);
                }
                d2 = new u(d3, d2);
                while (!this.a.isEmpty()) {
                    n2 = this.a(d2.a());
                    n2 = c[n2 + 1];
                    if (this.a.peek().a() >= n2) break;
                    d2 = new u(this.a.pop(), d2);
                }
                this.a.push(d2);
                return;
            }
            this.a.push(d2);
        }
    }

    private static class b
    implements Iterator<p> {
        private final Stack<u> a = new Stack();
        private p b;

        private b(kotlin.reflect.jvm.internal.impl.f.d d2) {
            this.b = this.a(d2);
        }

        private p a(kotlin.reflect.jvm.internal.impl.f.d d2) {
            while (d2 instanceof u) {
                d2 = (u)d2;
                this.a.push((u)d2);
                d2 = ((u)d2).e;
            }
            return (p)d2;
        }

        private p b() {
            p p2;
            do {
                if (!this.a.isEmpty()) continue;
                return null;
            } while ((p2 = this.a(this.a.pop().f)).d());
            return p2;
        }

        public p a() {
            if (this.b != null) {
                p p2 = this.b;
                this.b = this.b();
                return p2;
            }
            throw new NoSuchElementException();
        }

        @Override
        public boolean hasNext() {
            return this.b != null;
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

    private class c
    implements d.a {
        int a;
        private final b c;
        private d.a d;

        private c() {
            this.c = new b(u.this);
            this.d = this.c.a().c();
            this.a = u.this.a();
        }

        public Byte a() {
            return this.b();
        }

        @Override
        public byte b() {
            if (!this.d.hasNext()) {
                this.d = this.c.a().c();
            }
            --this.a;
            return this.d.b();
        }

        @Override
        public boolean hasNext() {
            return this.a > 0;
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

    private class d
    extends InputStream {
        private b b;
        private p c;
        private int d;
        private int e;
        private int f;
        private int g;

        public d() {
            this.a();
        }

        private int a(byte[] arrby, int n2, int n3) {
            int n4;
            int n5 = n2;
            for (n2 = n3; n2 > 0; n2 -= n4) {
                this.b();
                if (this.c == null) {
                    if (n2 != n3) break;
                    return -1;
                }
                n4 = Math.min(this.d - this.e, n2);
                int n6 = n5;
                if (arrby != null) {
                    this.c.b(arrby, this.e, n5, n4);
                    n6 = n5 + n4;
                }
                this.e += n4;
                n5 = n6;
            }
            return n3 - n2;
        }

        private void a() {
            this.b = new b(u.this);
            this.c = this.b.a();
            this.d = this.c.a();
            this.e = 0;
            this.f = 0;
        }

        /*
         * Enabled aggressive block sorting
         */
        private void b() {
            if (this.c != null && this.e == this.d) {
                this.f += this.d;
                int n2 = 0;
                this.e = 0;
                if (this.b.hasNext()) {
                    this.c = this.b.a();
                    n2 = this.c.a();
                } else {
                    this.c = null;
                }
                this.d = n2;
                return;
            }
        }

        @Override
        public int available() {
            int n2 = this.f;
            int n3 = this.e;
            return u.this.a() - (n2 + n3);
        }

        @Override
        public void mark(int n2) {
            this.g = this.f + this.e;
        }

        @Override
        public boolean markSupported() {
            return true;
        }

        @Override
        public int read() {
            this.b();
            if (this.c == null) {
                return -1;
            }
            p p2 = this.c;
            int n2 = this.e;
            this.e = n2 + 1;
            return p2.a(n2) & 255;
        }

        @Override
        public int read(byte[] arrby, int n2, int n3) {
            if (arrby != null) {
                if (n2 >= 0 && n3 >= 0 && n3 <= arrby.length - n2) {
                    return this.a(arrby, n2, n3);
                }
                throw new IndexOutOfBoundsException();
            }
            throw new NullPointerException();
        }

        @Override
        public void reset() {
            synchronized (this) {
                this.a();
                this.a(null, 0, this.g);
                return;
            }
        }

        @Override
        public long skip(long l2) {
            if (l2 >= 0L) {
                long l3 = l2;
                if (l2 > Integer.MAX_VALUE) {
                    l3 = Integer.MAX_VALUE;
                }
                return this.a(null, 0, (int)l3);
            }
            throw new IndexOutOfBoundsException();
        }
    }

}

