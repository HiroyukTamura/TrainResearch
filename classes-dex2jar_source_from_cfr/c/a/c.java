/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package c.a;

import c.ab;
import c.ad;
import c.t;
import d.e;
import d.f;
import d.u;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public final class c {
    public static final byte[] a = new byte[0];
    public static final String[] b = new String[0];
    public static final ad c = ad.a(null, a);
    public static final ab d = ab.a(null, a);
    public static final Charset e;
    public static final Charset f;
    public static final TimeZone g;
    public static final Comparator<String> h;
    private static final f i;
    private static final f j;
    private static final f k;
    private static final f l;
    private static final f m;
    private static final Charset n;
    private static final Charset o;
    private static final Charset p;
    private static final Charset q;
    private static final Pattern r;

    static {
        i = f.b("efbbbf");
        j = f.b("feff");
        k = f.b("fffe");
        l = f.b("0000ffff");
        m = f.b("ffff0000");
        e = Charset.forName("UTF-8");
        f = Charset.forName("ISO-8859-1");
        n = Charset.forName("UTF-16BE");
        o = Charset.forName("UTF-16LE");
        p = Charset.forName("UTF-32BE");
        q = Charset.forName("UTF-32LE");
        g = TimeZone.getTimeZone("GMT");
        h = new Comparator<String>(){

            public int a(String string2, String string3) {
                return string2.compareTo(string3);
            }

            @Override
            public /* synthetic */ int compare(Object object, Object object2) {
                return this.a((String)object, (String)object2);
            }
        };
        r = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int a(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - 48;
        }
        int n2 = 97;
        if (c2 >= 'a' && c2 <= 'f') {
            return c2 - n2 + 10;
        }
        n2 = 65;
        if (c2 < 'A') return -1;
        if (c2 > 'F') return -1;
        return c2 - n2 + 10;
    }

    public static int a(String string2, int n2, int n3) {
        while (n2 < n3) {
            switch (string2.charAt(n2)) {
                default: {
                    return n2;
                }
                case '\t': 
                case '\n': 
                case '\f': 
                case '\r': 
                case ' ': 
            }
            ++n2;
        }
        return n3;
    }

    public static int a(String string2, int n2, int n3, char c2) {
        while (n2 < n3) {
            if (string2.charAt(n2) == c2) {
                return n2;
            }
            ++n2;
        }
        return n3;
    }

    public static int a(String string2, int n2, int n3, String string3) {
        while (n2 < n3) {
            if (string3.indexOf(string2.charAt(n2)) != -1) {
                return n2;
            }
            ++n2;
        }
        return n3;
    }

    public static int a(Comparator<String> comparator, String[] arrstring, String string2) {
        int n2 = arrstring.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            if (comparator.compare(arrstring[i2], string2) != 0) continue;
            return i2;
        }
        return -1;
    }

    public static AssertionError a(String object, Exception exception) {
        object = new AssertionError(object);
        try {
            ((Throwable)object).initCause(exception);
            return object;
        }
        catch (IllegalStateException illegalStateException) {
            return object;
        }
    }

    public static String a(t t2, boolean bl2) {
        CharSequence charSequence;
        block6 : {
            CharSequence charSequence2;
            block5 : {
                if (t2.f().contains(":")) {
                    charSequence2 = new StringBuilder();
                    ((StringBuilder)charSequence2).append("[");
                    ((StringBuilder)charSequence2).append(t2.f());
                    ((StringBuilder)charSequence2).append("]");
                    charSequence2 = ((StringBuilder)charSequence2).toString();
                } else {
                    charSequence2 = t2.f();
                }
                if (bl2) break block5;
                charSequence = charSequence2;
                if (t2.g() == t.a(t2.b())) break block6;
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append(":");
            ((StringBuilder)charSequence).append(t2.g());
            charSequence = ((StringBuilder)charSequence).toString();
        }
        return charSequence;
    }

    public static String a(String string2) {
        block7 : {
            if (string2.contains(":")) {
                Object object = string2.startsWith("[") && string2.endsWith("]") ? c.d(string2, 1, string2.length() - 1) : c.d(string2, 0, string2.length());
                if (object == null) {
                    return null;
                }
                if (((byte[])(object = ((InetAddress)object).getAddress())).length == 16) {
                    return c.a((byte[])object);
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Invalid IPv6 address: '");
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append("'");
                throw new AssertionError((Object)((StringBuilder)object).toString());
            }
            try {
                string2 = IDN.toASCII(string2).toLowerCase(Locale.US);
                if (!string2.isEmpty()) break block7;
                return null;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                return null;
            }
        }
        boolean bl2 = c.d(string2);
        if (bl2) {
            return null;
        }
        return string2;
    }

    public static /* varargs */ String a(String string2, Object ... arrobject) {
        return String.format(Locale.US, string2, arrobject);
    }

    private static String a(byte[] arrby) {
        int n2;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = -1;
        while (n4 < arrby.length) {
            for (n2 = n4; n2 < 16 && arrby[n2] == 0 && arrby[n2 + 1] == 0; n2 += 2) {
            }
            int n7 = n2 - n4;
            int n8 = n5;
            int n9 = n6;
            if (n7 > n5) {
                n8 = n5;
                n9 = n6;
                if (n7 >= 4) {
                    n8 = n7;
                    n9 = n4;
                }
            }
            n4 = n2 + 2;
            n5 = n8;
            n6 = n9;
        }
        d.c c2 = new d.c();
        n4 = n3;
        while (n4 < arrby.length) {
            if (n4 == n6) {
                c2.b(58);
                n4 = n2 = n4 + n5;
                if (n2 != 16) continue;
                c2.b(58);
                n4 = n2;
                continue;
            }
            if (n4 > 0) {
                c2.b(58);
            }
            c2.k((arrby[n4] & 255) << 8 | arrby[n4 + 1] & 255);
            n4 += 2;
        }
        return c2.p();
    }

    public static Charset a(e e2, Charset charset) {
        if (e2.a(0L, i)) {
            e2.i(i.g());
            return e;
        }
        if (e2.a(0L, j)) {
            e2.i(j.g());
            return n;
        }
        if (e2.a(0L, k)) {
            e2.i(k.g());
            return o;
        }
        if (e2.a(0L, l)) {
            e2.i(l.g());
            return p;
        }
        if (e2.a(0L, m)) {
            e2.i(m.g());
            return q;
        }
        return charset;
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList<T>(list));
    }

    public static /* varargs */ <T> List<T> a(T ... arrT) {
        return Collections.unmodifiableList(Arrays.asList((Object[])arrT.clone()));
    }

    public static ThreadFactory a(String string2, final boolean bl2) {
        return new ThreadFactory(){

            @Override
            public Thread newThread(Runnable runnable) {
                runnable = new Thread(runnable, String.this);
                ((Thread)runnable).setDaemon(bl2);
                return runnable;
            }
        };
    }

    public static void a(long l2, long l3, long l4) {
        if ((l3 | l4) >= 0L && l3 <= l2 && l2 - l3 >= l4) {
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void a(Closeable closeable) {
        if (closeable == null) return;
        try {
            closeable.close();
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void a(Socket socket) {
        if (socket == null) return;
        try {
            socket.close();
            return;
        }
        catch (RuntimeException runtimeException) {
            throw runtimeException;
        }
        catch (AssertionError assertionError) {
            if (!c.a(assertionError)) throw assertionError;
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean a(d.t t2, int n2, TimeUnit timeUnit) {
        try {
            return c.b(t2, n2, timeUnit);
        }
        catch (IOException iOException) {
            return false;
        }
    }

    public static boolean a(AssertionError assertionError) {
        return ((Throwable)((Object)assertionError)).getCause() != null && ((Throwable)((Object)assertionError)).getMessage() != null && ((Throwable)((Object)assertionError)).getMessage().contains("getsockname failed");
    }

    public static boolean a(Object object, Object object2) {
        return object == object2 || object != null && object.equals(object2);
        {
        }
    }

    private static boolean a(String string2, int n2, int n3, byte[] arrby, int n4) {
        int n5 = n4;
        int n6 = n2;
        while (n6 < n3) {
            char c2;
            if (n5 == arrby.length) {
                return false;
            }
            n2 = n6;
            if (n5 != n4) {
                if (string2.charAt(n6) != '.') {
                    return false;
                }
                n2 = n6 + 1;
            }
            int n7 = 0;
            for (n6 = n2; n6 < n3 && (c2 = string2.charAt(n6)) >= '0' && c2 <= '9'; ++n6) {
                if (n7 == 0 && n2 != n6) {
                    return false;
                }
                if ((n7 = n7 * 10 + c2 - 48) <= 255) continue;
                return false;
            }
            if (n6 - n2 == 0) {
                return false;
            }
            arrby[n5] = (byte)n7;
            ++n5;
        }
        return n5 == n4 + 4;
    }

    public static String[] a(Comparator<? super String> comparator, String[] arrstring, String[] arrstring2) {
        ArrayList<String> arrayList = new ArrayList<String>();
        block0 : for (String string2 : arrstring) {
            int n2 = arrstring2.length;
            for (int i2 = 0; i2 < n2; ++i2) {
                if (comparator.compare(string2, arrstring2[i2]) != 0) continue;
                arrayList.add(string2);
                continue block0;
            }
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] a(String[] arrstring, String string2) {
        String[] arrstring2 = new String[arrstring.length + 1];
        System.arraycopy(arrstring, 0, arrstring2, 0, arrstring.length);
        arrstring2[arrstring2.length - 1] = string2;
        return arrstring2;
    }

    public static int b(String string2) {
        int n2 = string2.length();
        for (int i2 = 0; i2 < n2; ++i2) {
            char c2 = string2.charAt(i2);
            if (c2 > '\u001f') {
                if (c2 < '') continue;
                return i2;
            }
            return i2;
        }
        return -1;
    }

    public static int b(String string2, int n2, int n3) {
        --n3;
        while (n3 >= n2) {
            switch (string2.charAt(n3)) {
                default: {
                    return n3 + 1;
                }
                case '\t': 
                case '\n': 
                case '\f': 
                case '\r': 
                case ' ': 
            }
            --n3;
        }
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean b(d.t t2, int n2, TimeUnit object) {
        long l2 = System.nanoTime();
        long l3 = t2.a().v_() ? t2.a().d() - l2 : Long.MAX_VALUE;
        t2.a().a(Math.min(l3, ((TimeUnit)((Object)object)).toNanos(n2)) + l2);
        try {
            object = new d.c();
            while (t2.a((d.c)object, 8192L) != -1L) {
                ((d.c)object).s();
            }
            if (l3 == Long.MAX_VALUE) {
                t2.a().f();
                return true;
            }
            t2.a().a(l2 + l3);
            return true;
        }
        catch (Throwable throwable) {
            if (l3 == Long.MAX_VALUE) {
                t2.a().f();
                throw throwable;
            }
            t2.a().a(l2 + l3);
            throw throwable;
        }
        catch (InterruptedIOException interruptedIOException) {}
        if (l3 == Long.MAX_VALUE) {
            t2.a().f();
            return false;
        }
        t2.a().a(l2 + l3);
        return false;
    }

    public static boolean b(Comparator<String> comparator, String[] arrstring, String[] arrstring2) {
        if (arrstring != null && arrstring2 != null && arrstring.length != 0) {
            if (arrstring2.length == 0) {
                return false;
            }
            for (String string2 : arrstring) {
                int n2 = arrstring2.length;
                for (int i2 = 0; i2 < n2; ++i2) {
                    if (comparator.compare(string2, arrstring2[i2]) != 0) continue;
                    return true;
                }
            }
        }
        return false;
    }

    public static String c(String string2, int n2, int n3) {
        n2 = c.a(string2, n2, n3);
        return string2.substring(n2, c.b(string2, n2, n3));
    }

    public static boolean c(String string2) {
        return r.matcher(string2).matches();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Nullable
    private static InetAddress d(String object, int n2, int n3) {
        int n4;
        int n5;
        byte[] arrby = new byte[16];
        int n6 = 0;
        int n7 = -1;
        int n8 = -1;
        do {
            n4 = n6;
            n5 = n7;
            if (n2 >= n3) break;
            if (n6 == arrby.length) {
                return null;
            }
            n4 = n2 + 2;
            if (n4 <= n3 && ((String)object).regionMatches(n2, "::", 0, 2)) {
                if (n7 != -1) {
                    return null;
                }
                n2 = n6 + 2;
                if (n4 == n3) {
                    n5 = n2;
                    n4 = n2;
                    break;
                }
                n7 = n2;
                n6 = n2;
                n2 = n4;
            } else {
                n4 = n2;
                if (n6 != 0) {
                    if (((String)object).regionMatches(n2, ":", 0, 1)) {
                        n4 = n2 + 1;
                    } else {
                        if (!((String)object).regionMatches(n2, ".", 0, 1)) return null;
                        if (!c.a((String)object, n8, n3, arrby, n6 - 2)) {
                            return null;
                        }
                        n4 = n6 + 2;
                        n5 = n7;
                        break;
                    }
                }
                n2 = n4;
            }
            n8 = 0;
            for (n4 = n2; n4 < n3 && (n5 = c.a(((String)object).charAt(n4))) != -1; ++n4) {
                n8 = (n8 << 4) + n5;
            }
            n5 = n4 - n2;
            if (n5 == 0) return null;
            if (n5 > 4) {
                return null;
            }
            n5 = n6 + 1;
            arrby[n6] = (byte)(n8 >>> 8 & 255);
            n6 = n5 + 1;
            arrby[n5] = (byte)(n8 & 255);
            n8 = n2;
            n2 = n4;
        } while (true);
        if (n4 != arrby.length) {
            if (n5 == -1) {
                return null;
            }
            n2 = arrby.length;
            n3 = n4 - n5;
            System.arraycopy(arrby, n5, arrby, n2 - n3, n3);
            Arrays.fill(arrby, n5, arrby.length - n4 + n5, (byte)0);
        }
        try {
            return InetAddress.getByAddress(arrby);
        }
        catch (UnknownHostException unknownHostException) {
            throw new AssertionError();
        }
    }

    private static boolean d(String string2) {
        for (int i2 = 0; i2 < string2.length(); ++i2) {
            char c2 = string2.charAt(i2);
            if (c2 > '\u001f') {
                if (c2 >= '') {
                    return true;
                }
                if (" #%/:?@[\\]".indexOf(c2) == -1) continue;
                return true;
            }
            return true;
        }
        return false;
    }

}

