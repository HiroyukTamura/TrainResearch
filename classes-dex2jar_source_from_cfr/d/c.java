/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package d;

import d.d;
import d.e;
import d.f;
import d.m;
import d.p;
import d.q;
import d.r;
import d.s;
import d.t;
import d.u;
import d.v;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;

public final class c
implements d,
e,
Cloneable,
ByteChannel {
    private static final byte[] c = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    @Nullable
    p a;
    long b;

    private boolean a(p arrby, int n2, f f2, int n3, int n4) {
        int n5 = arrby.c;
        byte[] arrby2 = arrby.a;
        while (n3 < n4) {
            int n6 = n5;
            byte[] arrby3 = arrby;
            int n7 = n2;
            if (n2 == n5) {
                arrby3 = arrby.f;
                arrby = arrby3.a;
                n7 = arrby3.b;
                n6 = arrby3.c;
                arrby2 = arrby;
            }
            if (arrby2[n7] != f2.a(n3)) {
                return false;
            }
            n2 = n7 + 1;
            ++n3;
            n5 = n6;
            arrby = arrby3;
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public int a(m m2) {
        int n2 = this.a(m2, false);
        if (n2 == -1) {
            return -1;
        }
        long l2 = m2.a[n2].g();
        try {
            this.i(l2);
            return n2;
        }
        catch (EOFException eOFException) {
            throw new AssertionError();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    int a(m var1_1, boolean var2_2) {
        var14_3 = this.a;
        if (var14_3 == null) {
            if (var2_2 == false) return var1_1.indexOf(f.b);
            return -2;
        }
        var12_4 = var14_3.a;
        var3_5 = var14_3.b;
        var4_6 = var14_3.c;
        var15_7 = var1_1.b;
        var6_8 = -1;
        var1_1 = var14_3;
        var5_9 = 0;
        block0 : do {
            block18 : {
                var8_11 = var5_9 + 1;
                var11_14 = var15_7[var5_9];
                var7_10 = var8_11 + 1;
                var5_9 = var15_7[var8_11];
                if (var5_9 != -1) {
                    var6_8 = var5_9;
                }
                if (var1_1 == null) ** GOTO lbl41
                if (var11_14 >= 0) break block18;
                var5_9 = var7_10;
                var8_11 = var4_6;
                var13_15 = var1_1;
                do {
                    block21 : {
                        block19 : {
                            block20 : {
                                var10_13 = var3_5 + 1;
                                var3_5 = var12_4[var3_5];
                                var9_12 = var5_9 + 1;
                                if ((var3_5 & 255) != var15_7[var5_9]) {
                                    return var6_8;
                                }
                                var5_9 = var9_12 == var7_10 + var11_14 * -1 ? 1 : 0;
                                var3_5 = var10_13;
                                var1_1 = var13_15;
                                var4_6 = var8_11;
                                if (var10_13 != var8_11) break block19;
                                var1_1 = var13_15.f;
                                var3_5 = var1_1.b;
                                var12_4 = var1_1.a;
                                var4_6 = var1_1.c;
                                if (var1_1 != var14_3) break block19;
                                if (var5_9 != 0) break block20;
lbl41: // 2 sources:
                                if (var2_2 == false) return var6_8;
                                return -2;
                            }
                            var1_1 = null;
                        }
                        if (var5_9 == 0) break block21;
                        var5_9 = var15_7[var9_12];
                        ** GOTO lbl79
                    }
                    var5_9 = var9_12;
                    var13_15 = var1_1;
                    var8_11 = var4_6;
                } while (true);
            }
            var8_11 = var3_5 + 1;
            var5_9 = var12_4[var3_5];
            var3_5 = var7_10;
            do {
                block22 : {
                    if (var3_5 == var7_10 + var11_14) {
                        return var6_8;
                    }
                    if ((var5_9 & 255) != var15_7[var3_5]) break block22;
                    var5_9 = var15_7[var3_5 + var11_14];
                    if (var8_11 == var4_6) {
                        var1_1 = var1_1.f;
                        var4_6 = var1_1.b;
                        var12_4 = var1_1.a;
                        var3_5 = var1_1.c;
                        if (var1_1 == var14_3) {
                            var7_10 = var3_5;
                            var1_1 = null;
                            var3_5 = var4_6;
                            var4_6 = var7_10;
                        } else {
                            var7_10 = var3_5;
                            var3_5 = var4_6;
                            var4_6 = var7_10;
                        }
                    } else {
                        var3_5 = var8_11;
                    }
lbl79: // 4 sources:
                    if (var5_9 >= 0) {
                        return var5_9;
                    }
                    var5_9 = -var5_9;
                    continue block0;
                }
                ++var3_5;
            } while (true);
            break;
        } while (true);
    }

    public int a(byte[] arrby, int n2, int n3) {
        v.a(arrby.length, n2, n3);
        p p2 = this.a;
        if (p2 == null) {
            return -1;
        }
        n3 = Math.min(n3, p2.c - p2.b);
        System.arraycopy(p2.a, p2.b, arrby, n2, n3);
        p2.b += n3;
        this.b -= (long)n3;
        if (p2.b == p2.c) {
            this.a = p2.b();
            q.a(p2);
        }
        return n3;
    }

    @Override
    public long a(byte by2) {
        return this.a(by2, 0L, Long.MAX_VALUE);
    }

    public long a(byte by2, long l2, long l3) {
        long l4 = 0L;
        if (l2 >= 0L && l3 >= l2) {
            long l5;
            long l6 = l3;
            if (l3 > this.b) {
                l6 = this.b;
            }
            if (l2 == l6) {
                return -1L;
            }
            Object object = this.a;
            if (object == null) {
                return -1L;
            }
            l3 = l4;
            byte[] arrby = object;
            if (this.b - l2 < l2) {
                l4 = this.b;
                arrby = object;
                do {
                    l3 = l4;
                    object = arrby;
                    l5 = l2;
                    if (l4 > l2) {
                        arrby = arrby.g;
                        l4 -= (long)(arrby.c - arrby.b);
                        continue;
                    }
                    break;
                } while (true);
            } else {
                do {
                    l4 = (long)(arrby.c - arrby.b) + l3;
                    object = arrby;
                    l5 = l2;
                    if (l4 >= l2) break;
                    arrby = arrby.f;
                    l3 = l4;
                } while (true);
            }
            while (l3 < l6) {
                arrby = object.a;
                int n2 = (int)Math.min((long)object.c, (long)object.b + l6 - l3);
                for (int i2 = (int)((long)object.b + l5 - l3); i2 < n2; ++i2) {
                    if (arrby[i2] != by2) continue;
                    return (long)(i2 - object.b) + l3;
                }
                l5 = (long)(object.c - object.b) + l3;
                object = object.f;
                l3 = l5;
            }
            return -1L;
        }
        throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", this.b, l2, l3));
    }

    @Override
    public long a(c object, long l2) {
        if (object != null) {
            if (l2 >= 0L) {
                if (this.b == 0L) {
                    return -1L;
                }
                long l3 = l2;
                if (l2 > this.b) {
                    l3 = this.b;
                }
                ((c)object).a_(this, l3);
                return l3;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("byteCount < 0: ");
            ((StringBuilder)object).append(l2);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        throw new IllegalArgumentException("sink == null");
    }

    public long a(f f2, long l2) {
        if (f2.g() != 0) {
            long l3 = 0L;
            if (l2 >= 0L) {
                long l4;
                byte[] arrby = this.a;
                if (arrby == null) {
                    return -1L;
                }
                Object object = arrby;
                if (this.b - l2 < l2) {
                    l4 = this.b;
                    object = arrby;
                    do {
                        l3 = l4;
                        arrby = object;
                        if (l4 > l2) {
                            object = object.g;
                            l4 -= (long)(object.c - object.b);
                            continue;
                        }
                        break;
                    } while (true);
                } else {
                    do {
                        l4 = (long)(object.c - object.b) + l3;
                        arrby = object;
                        if (l4 >= l2) break;
                        object = object.f;
                        l3 = l4;
                    } while (true);
                }
                byte by2 = f2.a(0);
                int n2 = f2.g();
                l4 = this.b - (long)n2 + 1L;
                object = arrby;
                while (l3 < l4) {
                    byte[] arrby2 = object.a;
                    int n3 = (int)Math.min((long)object.c, (long)object.b + l4 - l3);
                    arrby = object;
                    object = arrby2;
                    for (int i2 = (int)((long)object.b + l2 - l3); i2 < n3; ++i2) {
                        if (object[i2] != by2 || !this.a((p)arrby, i2 + 1, f2, 1, n2)) continue;
                        return (long)(i2 - arrby.b) + l3;
                    }
                    l2 = (long)(arrby.c - arrby.b) + l3;
                    object = arrby.f;
                    l3 = l2;
                }
                return -1L;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    @Override
    public long a(s s2) {
        long l2 = this.b;
        if (l2 > 0L) {
            s2.a_(this, l2);
        }
        return l2;
    }

    public long a(t t2) {
        if (t2 != null) {
            long l2;
            long l3 = 0L;
            while ((l2 = t2.a(this, 8192L)) != -1L) {
                l3 += l2;
            }
            return l3;
        }
        throw new IllegalArgumentException("source == null");
    }

    /*
     * Enabled aggressive block sorting
     */
    public c a(int n2) {
        if (n2 >= 128) {
            int n3;
            if (n2 < 2048) {
                n3 = n2 >> 6 | 192;
            } else {
                if (n2 < 65536) {
                    if (n2 >= 55296 && n2 <= 57343) {
                        this.b(63);
                        return this;
                    }
                    n3 = n2 >> 12 | 224;
                } else {
                    if (n2 > 1114111) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unexpected code point: ");
                        stringBuilder.append(Integer.toHexString(n2));
                        throw new IllegalArgumentException(stringBuilder.toString());
                    }
                    this.b(n2 >> 18 | 240);
                    n3 = n2 >> 12 & 63 | 128;
                }
                this.b(n3);
                n3 = n2 >> 6 & 63 | 128;
            }
            this.b(n3);
            n2 = n2 & 63 | 128;
        }
        this.b(n2);
        return this;
    }

    public final c a(c c2, long l2, long l3) {
        if (c2 != null) {
            p p2;
            long l4;
            v.a(this.b, l2, l3);
            if (l3 == 0L) {
                return this;
            }
            c2.b += l3;
            p p3 = this.a;
            do {
                p2 = p3;
                l4 = l2;
                if (l2 < (long)(p3.c - p3.b)) break;
                l2 -= (long)(p3.c - p3.b);
                p3 = p3.f;
            } while (true);
            for (long i2 = l3; i2 > 0L; i2 -= (long)(p3.c - p3.b)) {
                p3 = p2.a();
                p3.b = (int)((long)p3.b + l4);
                p3.c = Math.min(p3.b + (int)i2, p3.c);
                if (c2.a == null) {
                    p3.g = p3;
                    p3.f = p3;
                    c2.a = p3;
                } else {
                    c2.a.g.a(p3);
                }
                p2 = p2.f;
                l4 = 0L;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public c a(f f2) {
        if (f2 != null) {
            f2.a(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    public c a(String string2) {
        return this.a(string2, 0, string2.length());
    }

    /*
     * Enabled aggressive block sorting
     */
    public c a(String charSequence, int n2, int n3) {
        if (charSequence == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (n2 < 0) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("beginIndex < 0: ");
            ((StringBuilder)charSequence).append(n2);
            throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
        }
        if (n3 < n2) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("endIndex < beginIndex: ");
            ((StringBuilder)charSequence).append(n3);
            ((StringBuilder)charSequence).append(" < ");
            ((StringBuilder)charSequence).append(n2);
            throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
        }
        if (n3 > ((String)charSequence).length()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("endIndex > string.length: ");
            stringBuilder.append(n3);
            stringBuilder.append(" > ");
            stringBuilder.append(((String)charSequence).length());
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        while (n2 < n3) {
            int n4;
            p p2;
            int n5;
            int n6;
            char c2 = ((String)charSequence).charAt(n2);
            if (c2 < '') {
                p2 = this.e(1);
                byte[] arrby = p2.a;
                n6 = p2.c - n2;
                n4 = Math.min(n3, 8192 - n6);
                n5 = n2 + 1;
                arrby[n2 + n6] = (byte)c2;
                n2 = n5;
            } else {
                if (c2 < '\u0800') {
                    n5 = c2 >> 6 | 192;
                } else {
                    if (c2 >= '\ud800' && c2 <= '\udfff') {
                        n6 = n2 + 1;
                        n5 = n6 < n3 ? (int)((String)charSequence).charAt(n6) : 0;
                        if (c2 <= '\udbff' && n5 >= 56320 && n5 <= 57343) {
                            n5 = ((c2 & -55297) << 10 | -56321 & n5) + 65536;
                            this.b(n5 >> 18 | 240);
                            this.b(n5 >> 12 & 63 | 128);
                            this.b(n5 >> 6 & 63 | 128);
                            this.b(n5 & 63 | 128);
                            n2 += 2;
                            continue;
                        }
                        this.b(63);
                        n2 = n6;
                        continue;
                    }
                    this.b(c2 >> 12 | 224);
                    n5 = c2 >> 6 & 63 | 128;
                }
                this.b(n5);
                this.b(c2 & 63 | 128);
                ++n2;
                continue;
            }
            while (n2 < n4 && (n5 = (int)((String)charSequence).charAt(n2)) < 128) {
                arrby[n2 + n6] = (byte)n5;
                ++n2;
            }
            n5 = n6 + n2 - p2.c;
            p2.c += n5;
            this.b += (long)n5;
        }
        return this;
    }

    public c a(String charSequence, int n2, int n3, Charset object) {
        if (charSequence != null) {
            if (n2 >= 0) {
                if (n3 >= n2) {
                    if (n3 <= ((String)charSequence).length()) {
                        if (object != null) {
                            if (((Charset)object).equals(v.a)) {
                                return this.a((String)charSequence, n2, n3);
                            }
                            charSequence = ((String)charSequence).substring(n2, n3).getBytes((Charset)object);
                            return this.b((byte[])charSequence, 0, ((CharSequence)charSequence).length);
                        }
                        throw new IllegalArgumentException("charset == null");
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append("endIndex > string.length: ");
                    ((StringBuilder)object).append(n3);
                    ((StringBuilder)object).append(" > ");
                    ((StringBuilder)object).append(((String)charSequence).length());
                    throw new IllegalArgumentException(((StringBuilder)object).toString());
                }
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("endIndex < beginIndex: ");
                ((StringBuilder)charSequence).append(n3);
                ((StringBuilder)charSequence).append(" < ");
                ((StringBuilder)charSequence).append(n2);
                throw new IllegalArgumentException(((StringBuilder)charSequence).toString());
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("beginIndex < 0: ");
            ((StringBuilder)charSequence).append(n2);
            throw new IllegalAccessError(((StringBuilder)charSequence).toString());
        }
        throw new IllegalArgumentException("string == null");
    }

    @Override
    public u a() {
        return u.c;
    }

    public String a(long l2, Charset object) {
        v.a(this.b, 0L, l2);
        if (object != null) {
            if (l2 <= Integer.MAX_VALUE) {
                if (l2 == 0L) {
                    return "";
                }
                p p2 = this.a;
                if ((long)p2.b + l2 > (long)p2.c) {
                    return new String(this.h(l2), (Charset)object);
                }
                object = new String(p2.a, p2.b, (int)l2, (Charset)object);
                p2.b = (int)((long)p2.b + l2);
                this.b -= l2;
                if (p2.b == p2.c) {
                    this.a = p2.b();
                    q.a(p2);
                }
                return object;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("byteCount > Integer.MAX_VALUE: ");
            ((StringBuilder)object).append(l2);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override
    public String a(Charset object) {
        try {
            object = this.a(this.b, (Charset)object);
            return object;
        }
        catch (EOFException eOFException) {
            throw new AssertionError(eOFException);
        }
    }

    @Override
    public void a(long l2) {
        if (this.b >= l2) {
            return;
        }
        throw new EOFException();
    }

    @Override
    public void a(byte[] arrby) {
        int n2;
        for (int i2 = 0; i2 < arrby.length; i2 += n2) {
            n2 = this.a(arrby, i2, arrby.length - i2);
            if (n2 != -1) {
                continue;
            }
            throw new EOFException();
        }
    }

    @Override
    public boolean a(long l2, f f2) {
        return this.a(l2, f2, 0, f2.g());
    }

    public boolean a(long l2, f f2, int n2, int n3) {
        if (l2 >= 0L && n2 >= 0 && n3 >= 0 && this.b - l2 >= (long)n3) {
            if (f2.g() - n2 < n3) {
                return false;
            }
            for (int i2 = 0; i2 < n3; ++i2) {
                if (this.c((long)i2 + l2) == f2.a(n2 + i2)) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public void a_(c c2, long l2) {
        if (c2 != null) {
            if (c2 != this) {
                v.a(c2.b, 0L, l2);
                while (l2 > 0L) {
                    long l3;
                    p p2;
                    if (l2 < (long)(c2.a.c - c2.a.b)) {
                        int n2;
                        p2 = this.a != null ? this.a.g : null;
                        if (p2 != null && p2.e && (l3 = (long)p2.c) + l2 - (long)(n2 = p2.d ? 0 : p2.b) <= 8192L) {
                            c2.a.a(p2, (int)l2);
                            c2.b -= l2;
                            this.b += l2;
                            return;
                        }
                        c2.a = c2.a.a((int)l2);
                    }
                    p2 = c2.a;
                    l3 = p2.c - p2.b;
                    c2.a = p2.b();
                    if (this.a == null) {
                        p p3;
                        p2 = this.a = p2;
                        p p4 = this.a;
                        p4.g = p3 = this.a;
                        p2.f = p3;
                    } else {
                        this.a.g.a(p2).c();
                    }
                    c2.b -= l3;
                    this.b += l3;
                    l2 -= l3;
                }
                return;
            }
            throw new IllegalArgumentException("source == this");
        }
        throw new IllegalArgumentException("source == null");
    }

    public final long b() {
        return this.b;
    }

    @Override
    public long b(f f2) {
        return this.a(f2, 0L);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public long b(f arrby, long l2) {
        long l3;
        int n2;
        long l4 = 0L;
        if (l2 < 0L) throw new IllegalArgumentException("fromIndex < 0");
        byte[] arrby2 = this.a;
        if (arrby2 == null) {
            return -1L;
        }
        byte[] arrby3 = arrby2;
        if (this.b - l2 < l2) {
            l3 = this.b;
            arrby3 = arrby2;
            do {
                l4 = l3;
                byte[] arrby4 = arrby3;
                if (l3 > l2) {
                    arrby3 = arrby3.g;
                    l3 -= (long)(arrby3.c - arrby3.b);
                    continue;
                }
                break;
            } while (true);
        } else {
            do {
                l3 = (long)(arrby3.c - arrby3.b) + l4;
                byte[] arrby5 = arrby3;
                if (l3 >= l2) break;
                arrby3 = arrby3.f;
                l4 = l3;
            } while (true);
        }
        if (arrby.g() == 2) {
            byte by2 = arrby.a(0);
            byte by3 = arrby.a(1);
            while (l4 < this.b) {
                void var14_10;
                arrby3 = var14_10.a;
                int n3 = (int)((long)var14_10.b + l2 - l4);
                int n4 = var14_10.c;
                while (n3 < n4) {
                    byte by4 = arrby3[n3];
                    l2 = l4;
                    arrby = var14_10;
                    n2 = n3++;
                    if (by4 != by2) {
                        if (by4 != by3) continue;
                        l2 = l4;
                        arrby = var14_10;
                        n2 = n3;
                        return (long)(n2 - arrby.b) + l2;
                    }
                    do {
                        return (long)(n2 - arrby.b) + l2;
                        break;
                    } while (true);
                }
                l2 = (long)(var14_10.c - var14_10.b) + l4;
                p p2 = var14_10.f;
                l4 = l2;
            }
            return -1L;
        }
        arrby = arrby.i();
        while (l4 < this.b) {
            void var14_12;
            arrby3 = var14_12.a;
            int n5 = var14_12.c;
            for (int i2 = (int)((long)var14_12.b + l2 - l4); i2 < n5; ++i2) {
                byte by5 = arrby3[i2];
                int n6 = arrby.length;
                for (n2 = 0; n2 < n6; ++n2) {
                    if (by5 != arrby[n2]) continue;
                    l2 = l4;
                    arrby = var14_12;
                    n2 = i2;
                    return (long)(n2 - arrby.b) + l2;
                }
            }
            l2 = (long)(var14_12.c - var14_12.b) + l4;
            p p3 = var14_12.f;
            l4 = l2;
        }
        return -1L;
    }

    public c b(int n2) {
        p p2 = this.e(1);
        byte[] arrby = p2.a;
        int n3 = p2.c;
        p2.c = n3 + 1;
        arrby[n3] = (byte)n2;
        ++this.b;
        return this;
    }

    public c b(byte[] arrby) {
        if (arrby != null) {
            return this.b(arrby, 0, arrby.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public c b(byte[] arrby, int n2, int n3) {
        if (arrby != null) {
            long l2 = arrby.length;
            long l3 = n2;
            long l4 = n3;
            v.a(l2, l3, l4);
            while (n2 < (n3 += n2)) {
                p p2 = this.e(1);
                int n4 = Math.min(n3 - n2, 8192 - p2.c);
                System.arraycopy(arrby, n2, p2.a, p2.c, n4);
                n2 += n4;
                p2.c += n4;
            }
            this.b += l4;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override
    public /* synthetic */ d b(String string2) {
        return this.a(string2);
    }

    @Override
    public /* synthetic */ d b(String string2, int n2, int n3) {
        return this.a(string2, n2, n3);
    }

    @Override
    public boolean b(long l2) {
        return this.b >= l2;
    }

    public final byte c(long l2) {
        p p2;
        long l3;
        v.a(this.b, l2, 1L);
        if (this.b - l2 > l2) {
            p p3 = this.a;
            do {
                long l4;
                if (l2 < (l4 = (long)(p3.c - p3.b))) {
                    return p3.a[p3.b + (int)l2];
                }
                l2 -= l4;
                p3 = p3.f;
            } while (true);
        }
        l2 -= this.b;
        p p4 = this.a;
        do {
            p2 = p4.g;
            l3 = l2 + (long)(p2.c - p2.b);
            p4 = p2;
            l2 = l3;
        } while (l3 < 0L);
        return p2.a[p2.b + (int)l3];
    }

    @Override
    public long c(f f2) {
        return this.b(f2, 0L);
    }

    @Override
    public c c() {
        return this;
    }

    public c c(int n2) {
        p p2 = this.e(2);
        byte[] arrby = p2.a;
        int n3 = p2.c;
        int n4 = n3 + 1;
        arrby[n3] = (byte)(n2 >>> 8 & 255);
        arrby[n4] = (byte)(n2 & 255);
        p2.c = n4 + 1;
        this.b += 2L;
        return this;
    }

    @Override
    public /* synthetic */ d c(byte[] arrby) {
        return this.b(arrby);
    }

    @Override
    public /* synthetic */ d c(byte[] arrby, int n2, int n3) {
        return this.b(arrby, n2, n3);
    }

    public /* synthetic */ Object clone() {
        return this.t();
    }

    @Override
    public void close() {
    }

    @Override
    public c d() {
        return this;
    }

    public c d(int n2) {
        p p2 = this.e(4);
        byte[] arrby = p2.a;
        int n3 = p2.c;
        int n4 = n3 + 1;
        arrby[n3] = (byte)(n2 >>> 24 & 255);
        n3 = n4 + 1;
        arrby[n4] = (byte)(n2 >>> 16 & 255);
        n4 = n3 + 1;
        arrby[n3] = (byte)(n2 >>> 8 & 255);
        arrby[n4] = (byte)(n2 & 255);
        p2.c = n4 + 1;
        this.b += 4L;
        return this;
    }

    @Override
    public /* synthetic */ d d(f f2) {
        return this.a(f2);
    }

    @Override
    public f d(long l2) {
        return new f(this.h(l2));
    }

    public c e() {
        return this;
    }

    p e(int n2) {
        block4 : {
            p p2;
            block6 : {
                p p3;
                block5 : {
                    if (n2 < 1 || n2 > 8192) break block4;
                    if (this.a == null) {
                        p p4;
                        p p5 = this.a = q.a();
                        p p6 = this.a;
                        p6.g = p4 = this.a;
                        p5.f = p4;
                        return p4;
                    }
                    p3 = this.a.g;
                    if (p3.c + n2 > 8192) break block5;
                    p2 = p3;
                    if (p3.e) break block6;
                }
                p2 = p3.a(q.a());
            }
            return p2;
        }
        throw new IllegalArgumentException();
    }

    public String e(long l2) {
        return this.a(l2, v.a);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof c)) {
            return false;
        }
        object = (c)object;
        if (this.b != ((c)object).b) {
            return false;
        }
        long l2 = this.b;
        if (l2 == 0L) {
            return true;
        }
        p p2 = this.a;
        object = ((c)object).a;
        int n2 = p2.b;
        int n3 = ((p)object).b;
        for (long i2 = 0L; i2 < this.b; i2 += l2) {
            l2 = Math.min(p2.c - n2, ((p)object).c - n3);
            int n4 = 0;
            while ((long)n4 < l2) {
                if (p2.a[n2] != ((p)object).a[n3]) {
                    return false;
                }
                ++n4;
                ++n2;
                ++n3;
            }
            if (n2 == p2.c) {
                p2 = p2.f;
                n2 = p2.b;
            }
            if (n3 != ((p)object).c) continue;
            object = ((p)object).f;
            n3 = ((p)object).b;
        }
        return true;
    }

    public final f f(int n2) {
        if (n2 == 0) {
            return f.b;
        }
        return new r(this, n2);
    }

    @Override
    public String f(long l2) {
        if (l2 >= 0L) {
            long l3 = Long.MAX_VALUE;
            if (l2 != Long.MAX_VALUE) {
                l3 = l2 + 1L;
            }
            long l4 = this.a((byte)10, 0L, l3);
            if (l4 != -1L) {
                return this.g(l4);
            }
            if (l3 < this.b() && this.c(l3 - 1L) == 13 && this.c(l3) == 10) {
                return this.g(l3);
            }
            c c2 = new c();
            this.a(c2, 0L, Math.min(32L, this.b()));
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("\\n not found: limit=");
            stringBuilder.append(Math.min(this.b(), l2));
            stringBuilder.append(" content=");
            stringBuilder.append(c2.o().e());
            stringBuilder.append('\u2026');
            throw new EOFException(stringBuilder.toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("limit < 0: ");
        stringBuilder.append(l2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @Override
    public boolean f() {
        return this.b == 0L;
    }

    @Override
    public void flush() {
    }

    @Override
    public /* synthetic */ d g(int n2) {
        return this.d(n2);
    }

    @Override
    public InputStream g() {
        return new InputStream(){

            @Override
            public int available() {
                return (int)Math.min(c.this.b, Integer.MAX_VALUE);
            }

            @Override
            public void close() {
            }

            @Override
            public int read() {
                if (c.this.b > 0L) {
                    return c.this.i() & 255;
                }
                return -1;
            }

            @Override
            public int read(byte[] arrby, int n2, int n3) {
                return c.this.a(arrby, n2, n3);
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c.this);
                stringBuilder.append(".inputStream()");
                return stringBuilder.toString();
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     */
    String g(long l2) {
        String string2;
        long l3;
        long l4 = 1L;
        if (l2 > 0L && this.c(l3 = l2 - 1L) == 13) {
            string2 = this.e(l3);
            l2 = 2L;
        } else {
            string2 = this.e(l2);
            l2 = l4;
        }
        this.i(l2);
        return string2;
    }

    public final long h() {
        long l2 = this.b;
        if (l2 == 0L) {
            return 0L;
        }
        p p2 = this.a.g;
        long l3 = l2;
        if (p2.c < 8192) {
            l3 = l2;
            if (p2.e) {
                l3 = l2 - (long)(p2.c - p2.b);
            }
        }
        return l3;
    }

    @Override
    public /* synthetic */ d h(int n2) {
        return this.c(n2);
    }

    @Override
    public byte[] h(long l2) {
        v.a(this.b, 0L, l2);
        if (l2 <= Integer.MAX_VALUE) {
            byte[] arrby = new byte[(int)l2];
            this.a(arrby);
            return arrby;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("byteCount > Integer.MAX_VALUE: ");
        stringBuilder.append(l2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public int hashCode() {
        p p2;
        int n2;
        p p3 = this.a;
        if (p3 == null) {
            return 0;
        }
        int n3 = 1;
        do {
            int n4 = p3.c;
            n2 = n3;
            for (int i2 = p3.b; i2 < n4; ++i2) {
                n2 = n2 * 31 + p3.a[i2];
            }
            p3 = p2 = p3.f;
            n3 = n2;
        } while (p2 != this.a);
        return n2;
    }

    @Override
    public byte i() {
        if (this.b != 0L) {
            p p2 = this.a;
            int n2 = p2.b;
            int n3 = p2.c;
            byte[] arrby = p2.a;
            int n4 = n2 + 1;
            byte by2 = arrby[n2];
            --this.b;
            if (n4 == n3) {
                this.a = p2.b();
                q.a(p2);
                return by2;
            }
            p2.b = n4;
            return by2;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override
    public /* synthetic */ d i(int n2) {
        return this.b(n2);
    }

    @Override
    public void i(long l2) {
        while (l2 > 0L) {
            if (this.a != null) {
                int n2 = (int)Math.min(l2, (long)(this.a.c - this.a.b));
                long l3 = this.b;
                long l4 = n2;
                this.b = l3 - l4;
                l3 = l2 - l4;
                p p2 = this.a;
                p2.b += n2;
                l2 = l3;
                if (this.a.b != this.a.c) continue;
                p2 = this.a;
                this.a = p2.b();
                q.a(p2);
                l2 = l3;
                continue;
            }
            throw new EOFException();
        }
    }

    @Override
    public boolean isOpen() {
        return true;
    }

    public c j(long l2) {
        long l3 = l2 LCMP 0L;
        if (l3 == false) {
            return this.b(48);
        }
        boolean bl2 = false;
        int n2 = 1;
        long l4 = l2;
        if (l3 < 0) {
            l4 = -l2;
            if (l4 < 0L) {
                return this.a("-9223372036854775808");
            }
            bl2 = true;
        }
        if (l4 < 100000000L) {
            if (l4 < 10000L) {
                if (l4 < 100L) {
                    if (l4 >= 10L) {
                        n2 = 2;
                    }
                } else {
                    n2 = l4 < 1000L ? 3 : 4;
                }
            } else {
                n2 = l4 < 1000000L ? (l4 < 100000L ? 5 : 6) : (l4 < 10000000L ? 7 : 8);
            }
        } else {
            n2 = l4 < 1000000000000L ? (l4 < 10000000000L ? (l4 < 1000000000L ? 9 : 10) : (l4 < 100000000000L ? 11 : 12)) : (l4 < 1000000000000000L ? (l4 < 10000000000000L ? 13 : (l4 < 100000000000000L ? 14 : 15)) : (l4 < 100000000000000000L ? (l4 < 10000000000000000L ? 16 : 17) : (l4 < 1000000000000000000L ? 18 : 19)));
        }
        l3 = n2;
        if (bl2) {
            l3 = n2 + 1;
        }
        p p2 = this.e((int)l3);
        byte[] arrby = p2.a;
        n2 = p2.c + l3;
        while (l4 != 0L) {
            int n3 = (int)(l4 % 10L);
            arrby[--n2] = c[n3];
            l4 /= 10L;
        }
        if (bl2) {
            arrby[n2 - 1] = 45;
        }
        p2.c += l3;
        this.b += (long)l3;
        return this;
    }

    @Override
    public short j() {
        if (this.b >= 2L) {
            p p2 = this.a;
            int n2 = p2.c;
            int n3 = p2.b;
            if (n2 - n3 < 2) {
                return (short)((this.i() & 255) << 8 | this.i() & 255);
            }
            byte[] arrby = p2.a;
            int n4 = n3 + 1;
            n3 = arrby[n3];
            int n5 = n4 + 1;
            n4 = arrby[n4];
            this.b -= 2L;
            if (n5 == n2) {
                this.a = p2.b();
                q.a(p2);
            } else {
                p2.b = n5;
            }
            return (short)((n3 & 255) << 8 | n4 & 255);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size < 2: ");
        stringBuilder.append(this.b);
        throw new IllegalStateException(stringBuilder.toString());
    }

    @Override
    public int k() {
        if (this.b >= 4L) {
            p p2 = this.a;
            int n2 = p2.c;
            int n3 = p2.b;
            if (n2 - n3 < 4) {
                return (this.i() & 255) << 24 | (this.i() & 255) << 16 | (this.i() & 255) << 8 | this.i() & 255;
            }
            byte[] arrby = p2.a;
            int n4 = n3 + 1;
            n3 = arrby[n3];
            int n5 = n4 + 1;
            n4 = arrby[n4];
            int n6 = n5 + 1;
            byte by2 = arrby[n5];
            n5 = n6 + 1;
            n3 = (n3 & 255) << 24 | (n4 & 255) << 16 | (by2 & 255) << 8 | arrby[n6] & 255;
            this.b -= 4L;
            if (n5 == n2) {
                this.a = p2.b();
                q.a(p2);
                return n3;
            }
            p2.b = n5;
            return n3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size < 4: ");
        stringBuilder.append(this.b);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public c k(long l2) {
        if (l2 == 0L) {
            return this.b(48);
        }
        int n2 = Long.numberOfTrailingZeros(Long.highestOneBit(l2)) / 4 + 1;
        p p2 = this.e(n2);
        byte[] arrby = p2.a;
        int n3 = p2.c;
        for (int i2 = p2.c + n2 - 1; i2 >= n3; --i2) {
            arrby[i2] = c[(int)(15L & l2)];
            l2 >>>= 4;
        }
        p2.c += n2;
        this.b += (long)n2;
        return this;
    }

    @Override
    public /* synthetic */ d l(long l2) {
        return this.k(l2);
    }

    @Override
    public short l() {
        return v.a(this.j());
    }

    @Override
    public int m() {
        return v.a(this.k());
    }

    @Override
    public /* synthetic */ d m(long l2) {
        return this.j(l2);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public long n() {
        long l2;
        int n2;
        if (this.b == 0L) {
            throw new IllegalStateException("size == 0");
        }
        int n3 = 0;
        long l3 = 0L;
        byte by2 = 0;
        do {
            byte by3;
            int n4;
            int n5;
            Object object;
            block11 : {
                object = this.a;
                Object object2 = ((p)object).a;
                n5 = ((p)object).b;
                n4 = ((p)object).c;
                l2 = l3;
                n2 = n3;
                do {
                    by3 = by2;
                    if (n5 >= n4) break block11;
                    by3 = object2[n5];
                    if (by3 >= 48 && by3 <= 57) {
                        n3 = by3 - 48;
                    } else {
                        if (by3 >= 97 && by3 <= 102) {
                            n3 = by3 - 97;
                        } else {
                            if (by3 < 65 || by3 > 70) break;
                            n3 = by3 - 65;
                        }
                        n3 += 10;
                    }
                    if ((-1152921504606846976L & l2) != 0L) {
                        object = new c().k(l2).b(by3);
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("Number too large: ");
                        ((StringBuilder)object2).append(((c)object).p());
                        throw new NumberFormatException(((StringBuilder)object2).toString());
                    }
                    l2 = l2 << 4 | (long)n3;
                    ++n5;
                    ++n2;
                } while (true);
                if (n2 == 0) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Expected leading [0-9a-fA-F] character but was 0x");
                    ((StringBuilder)object).append(Integer.toHexString(by3));
                    throw new NumberFormatException(((StringBuilder)object).toString());
                }
                by3 = 1;
            }
            if (n5 == n4) {
                this.a = ((p)object).b();
                q.a((p)object);
            } else {
                ((p)object).b = n5;
            }
            if (by3 != 0) break;
            n3 = n2;
            by2 = by3;
            l3 = l2;
        } while (this.a != null);
        this.b -= (long)n2;
        return l2;
    }

    public f o() {
        return new f(this.r());
    }

    @Override
    public String p() {
        try {
            String string2 = this.a(this.b, v.a);
            return string2;
        }
        catch (EOFException eOFException) {
            throw new AssertionError(eOFException);
        }
    }

    @Override
    public String q() {
        return this.f(Long.MAX_VALUE);
    }

    public byte[] r() {
        try {
            byte[] arrby = this.h(this.b);
            return arrby;
        }
        catch (EOFException eOFException) {
            throw new AssertionError(eOFException);
        }
    }

    @Override
    public int read(ByteBuffer byteBuffer) {
        p p2 = this.a;
        if (p2 == null) {
            return -1;
        }
        int n2 = Math.min(byteBuffer.remaining(), p2.c - p2.b);
        byteBuffer.put(p2.a, p2.b, n2);
        p2.b += n2;
        this.b -= (long)n2;
        if (p2.b == p2.c) {
            this.a = p2.b();
            q.a(p2);
        }
        return n2;
    }

    public final void s() {
        try {
            this.i(this.b);
            return;
        }
        catch (EOFException eOFException) {
            throw new AssertionError(eOFException);
        }
    }

    public c t() {
        p p2;
        c c2 = new c();
        if (this.b == 0L) {
            return c2;
        }
        p p3 = c2.a = this.a.a();
        p p4 = c2.a;
        p4.g = p2 = c2.a;
        p3.f = p2;
        p3 = this.a;
        while ((p3 = p3.f) != this.a) {
            c2.a.g.a(p3.a());
        }
        c2.b = this.b;
        return c2;
    }

    public String toString() {
        return this.u().toString();
    }

    public final f u() {
        if (this.b <= Integer.MAX_VALUE) {
            return this.f((int)this.b);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size > Integer.MAX_VALUE: ");
        stringBuilder.append(this.b);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    @Override
    public /* synthetic */ d v() {
        return this.e();
    }

    @Override
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            int n2;
            int n3 = n2 = byteBuffer.remaining();
            while (n3 > 0) {
                p p2 = this.e(1);
                int n4 = Math.min(n3, 8192 - p2.c);
                byteBuffer.get(p2.a, p2.c, n4);
                n3 -= n4;
                p2.c += n4;
            }
            this.b += (long)n2;
            return n2;
        }
        throw new IllegalArgumentException("source == null");
    }

}

