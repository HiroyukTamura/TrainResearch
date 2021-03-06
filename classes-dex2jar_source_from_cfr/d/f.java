/*
 * Decompiled with CFR 0.139.
 */
package d;

import d.b;
import d.c;
import d.v;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class f
implements Serializable,
Comparable<f> {
    static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final f b = f.a(new byte[0]);
    final byte[] c;
    transient int d;
    transient String e;

    f(byte[] arrby) {
        this.c = arrby;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - 48;
        }
        int n2 = 97;
        if (c2 >= 'a' && c2 <= 'f') {
            return c2 - n2 + 10;
        }
        n2 = 65;
        if (c2 >= 'A' && c2 <= 'F') {
            return c2 - n2 + 10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected hex digit: ");
        stringBuilder.append(c2);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    static int a(String string2, int n2) {
        int n3;
        int n4 = string2.length();
        int n5 = 0;
        for (int i2 = 0; i2 < n4; i2 += Character.charCount((int)n3)) {
            if (n5 == n2) {
                return i2;
            }
            n3 = string2.codePointAt(i2);
            if (Character.isISOControl(n3) && n3 != 10 && n3 != 13 || n3 == 65533) {
                return -1;
            }
            ++n5;
        }
        return string2.length();
    }

    public static f a(String string2) {
        if (string2 != null) {
            f f2 = new f(string2.getBytes(v.a));
            f2.e = string2;
            return f2;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static /* varargs */ f a(byte ... arrby) {
        if (arrby != null) {
            return new f((byte[])arrby.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public static f b(String string2) {
        if (string2 != null) {
            if (string2.length() % 2 == 0) {
                byte[] arrby = new byte[string2.length() / 2];
                for (int i2 = 0; i2 < arrby.length; ++i2) {
                    int n2 = i2 * 2;
                    arrby[i2] = (byte)((f.a(string2.charAt(n2)) << 4) + f.a(string2.charAt(n2 + 1)));
                }
                return f.a(arrby);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected hex string: ");
            stringBuilder.append(string2);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("hex == null");
    }

    private f c(String object) {
        try {
            object = f.a(MessageDigest.getInstance((String)object).digest(this.c));
            return object;
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new AssertionError(noSuchAlgorithmException);
        }
    }

    public byte a(int n2) {
        return this.c[n2];
    }

    public f a(int n2, int n3) {
        if (n2 >= 0) {
            if (n3 <= this.c.length) {
                int n4 = n3 - n2;
                if (n4 >= 0) {
                    if (n2 == 0 && n3 == this.c.length) {
                        return this;
                    }
                    byte[] arrby = new byte[n4];
                    System.arraycopy(this.c, n2, arrby, 0, n4);
                    return new f(arrby);
                }
                throw new IllegalArgumentException("endIndex < beginIndex");
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("endIndex > length(");
            stringBuilder.append(this.c.length);
            stringBuilder.append(")");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public String a() {
        String string2 = this.e;
        if (string2 != null) {
            return string2;
        }
        this.e = string2 = new String(this.c, v.a);
        return string2;
    }

    void a(c c2) {
        c2.b(this.c, 0, this.c.length);
    }

    public boolean a(int n2, f f2, int n3, int n4) {
        return f2.a(n3, this.c, n2, n4);
    }

    public boolean a(int n2, byte[] arrby, int n3, int n4) {
        return n2 >= 0 && n2 <= this.c.length - n4 && n3 >= 0 && n3 <= arrby.length - n4 && v.a(this.c, n2, arrby, n3, n4);
    }

    public final boolean a(f f2) {
        return this.a(0, f2, 0, f2.g());
    }

    public int b(f f2) {
        int n2 = this.g();
        int n3 = f2.g();
        int n4 = Math.min(n2, n3);
        for (int i2 = 0; i2 < n4; ++i2) {
            int n5;
            int n6 = this.a(i2) & 255;
            if (n6 == (n5 = f2.a(i2) & 255)) {
                continue;
            }
            if (n6 < n5) {
                return -1;
            }
            return 1;
        }
        if (n2 == n3) {
            return 0;
        }
        if (n2 < n3) {
            return -1;
        }
        return 1;
    }

    public String b() {
        return b.a(this.c);
    }

    public f c() {
        return this.c("SHA-1");
    }

    @Override
    public /* synthetic */ int compareTo(Object object) {
        return this.b((f)object);
    }

    public f d() {
        return this.c("SHA-256");
    }

    public String e() {
        char[] arrc = new char[this.c.length * 2];
        byte[] arrby = this.c;
        int n2 = arrby.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            byte by2 = arrby[i2];
            int n4 = n3 + 1;
            arrc[n3] = a[by2 >> 4 & 15];
            n3 = n4 + 1;
            arrc[n4] = a[by2 & 15];
        }
        return new String(arrc);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        return object instanceof f && ((f)(object = (f)object)).g() == this.c.length && ((f)object).a(0, this.c, 0, this.c.length);
    }

    public f f() {
        for (int i2 = 0; i2 < this.c.length; ++i2) {
            byte by2 = this.c[i2];
            if (by2 < 65 || by2 > 90) continue;
            byte[] arrby = (byte[])this.c.clone();
            int n2 = i2 + 1;
            arrby[i2] = (byte)(by2 + 32);
            for (i2 = n2; i2 < arrby.length; ++i2) {
                n2 = arrby[i2];
                if (n2 < 65 || n2 > 90) continue;
                arrby[i2] = (byte)(n2 + 32);
            }
            return new f(arrby);
        }
        return this;
    }

    public int g() {
        return this.c.length;
    }

    public byte[] h() {
        return (byte[])this.c.clone();
    }

    public int hashCode() {
        int n2 = this.d;
        if (n2 != 0) {
            return n2;
        }
        this.d = n2 = Arrays.hashCode(this.c);
        return n2;
    }

    byte[] i() {
        return this.c;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        if (this.c.length == 0) {
            return "[size=0]";
        }
        CharSequence charSequence = this.a();
        int n2 = f.a((String)charSequence, 64);
        if (n2 == -1) {
            String string2;
            if (this.c.length <= 64) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("[hex=");
                ((StringBuilder)charSequence).append(this.e());
                string2 = "]";
            } else {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("[size=");
                ((StringBuilder)charSequence).append(this.c.length);
                ((StringBuilder)charSequence).append(" hex=");
                ((StringBuilder)charSequence).append(this.a(0, 64).e());
                string2 = "\u2026]";
            }
            ((StringBuilder)charSequence).append(string2);
            return ((StringBuilder)charSequence).toString();
        }
        String string3 = ((String)charSequence).substring(0, n2).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (n2 < ((String)charSequence).length()) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("[size=");
            ((StringBuilder)charSequence).append(this.c.length);
            ((StringBuilder)charSequence).append(" text=");
            ((StringBuilder)charSequence).append(string3);
            string3 = "\u2026]";
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("[text=");
            ((StringBuilder)charSequence).append(string3);
            string3 = "]";
        }
        ((StringBuilder)charSequence).append(string3);
        return ((StringBuilder)charSequence).toString();
    }
}

