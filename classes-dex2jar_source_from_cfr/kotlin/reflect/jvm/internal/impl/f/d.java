/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.reflect.jvm.internal.impl.f.e;
import kotlin.reflect.jvm.internal.impl.f.j;
import kotlin.reflect.jvm.internal.impl.f.p;
import kotlin.reflect.jvm.internal.impl.f.u;

public abstract class d
implements Iterable<Byte> {
    public static final d a;
    static final /* synthetic */ boolean b;

    static {
        b = d.class.desiredAssertionStatus() ^ true;
        a = new p(new byte[0]);
    }

    d() {
    }

    public static d a(Iterable<d> arrayList) {
        if (!(arrayList instanceof Collection)) {
            ArrayList<d> arrayList2 = new ArrayList<d>();
            Iterator iterator = arrayList.iterator();
            do {
                arrayList = arrayList2;
                if (iterator.hasNext()) {
                    arrayList2.add((d)iterator.next());
                    continue;
                }
                break;
            } while (true);
        } else {
            arrayList = arrayList;
        }
        if (arrayList.isEmpty()) {
            return a;
        }
        return d.a(arrayList.iterator(), arrayList.size());
    }

    public static d a(String object) {
        try {
            object = new p(((String)object).getBytes("UTF-8"));
            return object;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException("UTF-8 not supported?", unsupportedEncodingException);
        }
    }

    private static d a(Iterator<d> iterator, int n2) {
        if (!b && n2 < 1) {
            throw new AssertionError();
        }
        if (n2 == 1) {
            return iterator.next();
        }
        int n3 = n2 >>> 1;
        return d.a(iterator, n3).a(d.a(iterator, n2 - n3));
    }

    public static d a(byte[] arrby) {
        return d.a(arrby, 0, arrby.length);
    }

    public static d a(byte[] arrby, int n2, int n3) {
        byte[] arrby2 = new byte[n3];
        System.arraycopy(arrby, n2, arrby2, 0, n3);
        return new p(arrby2);
    }

    public static b i() {
        return new b(128);
    }

    public abstract int a();

    protected abstract int a(int var1, int var2, int var3);

    public d a(d object) {
        int n2;
        int n3 = this.a();
        if ((long)n3 + (long)(n2 = ((d)object).a()) < Integer.MAX_VALUE) {
            return u.a(this, (d)object);
        }
        object = new StringBuilder(53);
        ((StringBuilder)object).append("ByteString would be too long: ");
        ((StringBuilder)object).append(n3);
        ((StringBuilder)object).append("+");
        ((StringBuilder)object).append(n2);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    void a(OutputStream object, int n2, int n3) {
        if (n2 >= 0) {
            if (n3 >= 0) {
                int n4 = n2 + n3;
                if (n4 <= this.a()) {
                    if (n3 > 0) {
                        this.b((OutputStream)object, n2, n3);
                    }
                    return;
                }
                object = new StringBuilder(39);
                ((StringBuilder)object).append("Source end offset exceeded: ");
                ((StringBuilder)object).append(n4);
                throw new IndexOutOfBoundsException(((StringBuilder)object).toString());
            }
            object = new StringBuilder(23);
            ((StringBuilder)object).append("Length < 0: ");
            ((StringBuilder)object).append(n3);
            throw new IndexOutOfBoundsException(((StringBuilder)object).toString());
        }
        object = new StringBuilder(30);
        ((StringBuilder)object).append("Source offset < 0: ");
        ((StringBuilder)object).append(n2);
        throw new IndexOutOfBoundsException(((StringBuilder)object).toString());
    }

    protected abstract void a(byte[] var1, int var2, int var3, int var4);

    protected abstract int b(int var1, int var2, int var3);

    public abstract String b(String var1);

    abstract void b(OutputStream var1, int var2, int var3);

    public void b(byte[] object, int n2, int n3, int n4) {
        if (n2 >= 0) {
            if (n3 >= 0) {
                if (n4 >= 0) {
                    int n5 = n2 + n4;
                    if (n5 <= this.a()) {
                        n5 = n3 + n4;
                        if (n5 <= ((Object)object).length) {
                            if (n4 > 0) {
                                this.a((byte[])object, n2, n3, n4);
                            }
                            return;
                        }
                        object = new StringBuilder(34);
                        ((StringBuilder)object).append("Target end offset < 0: ");
                        ((StringBuilder)object).append(n5);
                        throw new IndexOutOfBoundsException(((StringBuilder)object).toString());
                    }
                    object = new StringBuilder(34);
                    ((StringBuilder)object).append("Source end offset < 0: ");
                    ((StringBuilder)object).append(n5);
                    throw new IndexOutOfBoundsException(((StringBuilder)object).toString());
                }
                object = new StringBuilder(23);
                ((StringBuilder)object).append("Length < 0: ");
                ((StringBuilder)object).append(n4);
                throw new IndexOutOfBoundsException(((StringBuilder)object).toString());
            }
            object = new StringBuilder(30);
            ((StringBuilder)object).append("Target offset < 0: ");
            ((StringBuilder)object).append(n3);
            throw new IndexOutOfBoundsException(((StringBuilder)object).toString());
        }
        object = new StringBuilder(30);
        ((StringBuilder)object).append("Source offset < 0: ");
        ((StringBuilder)object).append(n2);
        throw new IndexOutOfBoundsException(((StringBuilder)object).toString());
    }

    public abstract a c();

    public boolean d() {
        return this.a() == 0;
    }

    public byte[] e() {
        int n2 = this.a();
        if (n2 == 0) {
            return j.a;
        }
        byte[] arrby = new byte[n2];
        this.a(arrby, 0, 0, n2);
        return arrby;
    }

    public String f() {
        try {
            String string2 = this.b("UTF-8");
            return string2;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException("UTF-8 not supported?", unsupportedEncodingException);
        }
    }

    public abstract boolean g();

    public abstract e h();

    @Override
    public /* synthetic */ Iterator iterator() {
        return this.c();
    }

    protected abstract int j();

    protected abstract boolean k();

    protected abstract int l();

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), this.a());
    }

    public static interface a
    extends Iterator<Byte> {
        public byte b();
    }

    public static final class b
    extends OutputStream {
        private static final byte[] a = new byte[0];
        private final int b;
        private final ArrayList<d> c;
        private int d;
        private byte[] e;
        private int f;

        b(int n2) {
            if (n2 >= 0) {
                this.b = n2;
                this.c = new ArrayList();
                this.e = new byte[n2];
                return;
            }
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private void a(int n2) {
            this.c.add(new p(this.e));
            this.d += this.e.length;
            this.e = new byte[Math.max(this.b, Math.max(n2, this.d >>> 1))];
            this.f = 0;
        }

        private byte[] a(byte[] arrby, int n2) {
            byte[] arrby2 = new byte[n2];
            System.arraycopy(arrby, 0, arrby2, 0, Math.min(arrby.length, n2));
            return arrby2;
        }

        private void c() {
            if (this.f < this.e.length) {
                if (this.f > 0) {
                    byte[] arrby = this.a(this.e, this.f);
                    this.c.add(new p(arrby));
                }
            } else {
                this.c.add(new p(this.e));
                this.e = a;
            }
            this.d += this.f;
            this.f = 0;
        }

        public d a() {
            synchronized (this) {
                this.c();
                d d2 = d.a(this.c);
                return d2;
            }
        }

        public int b() {
            synchronized (this) {
                int n2 = this.d;
                int n3 = this.f;
                return n2 + n3;
            }
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), this.b());
        }

        @Override
        public void write(int n2) {
            synchronized (this) {
                if (this.f == this.e.length) {
                    this.a(1);
                }
                byte[] arrby = this.e;
                int n3 = this.f;
                this.f = n3 + 1;
                arrby[n3] = (byte)n2;
                return;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        @Override
        public void write(byte[] arrby, int n2, int n3) {
            synchronized (this) {
                void var3_3;
                void var2_2;
                if (var3_3 <= this.e.length - this.f) {
                    System.arraycopy(arrby, (int)var2_2, this.e, this.f, (int)var3_3);
                    this.f += var3_3;
                } else {
                    int n4 = this.e.length - this.f;
                    System.arraycopy(arrby, (int)var2_2, this.e, this.f, n4);
                    this.a((int)(var3_3 -= n4));
                    System.arraycopy(arrby, (int)(var2_2 + n4), this.e, 0, (int)var3_3);
                    this.f = var3_3;
                }
                return;
            }
        }
    }

}

