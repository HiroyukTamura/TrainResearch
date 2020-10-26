/*
 * Decompiled with CFR 0.139.
 */
package c.a.h;

import c.a.c;
import c.a.g.f;
import d.j;
import d.l;
import d.t;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public final class a {
    private static final byte[] a = new byte[]{42};
    private static final String[] b = new String[0];
    private static final String[] c = new String[]{"*"};
    private static final a d = new a();
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final CountDownLatch f = new CountDownLatch(1);
    private byte[] g;
    private byte[] h;

    public static a a() {
        return d;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static String a(byte[] arrby, byte[][] arrby2, int n2) {
        int n3 = arrby.length;
        int n4 = 0;
        block0 : while (n4 < n3) {
            int n5;
            int n6;
            for (n6 = (n4 + n3) / 2; n6 > -1 && arrby[n6] != 10; --n6) {
            }
            int n7 = n6 + 1;
            n6 = 1;
            while (arrby[n5 = n7 + n6] != 10) {
                ++n6;
            }
            int n8 = n5 - n7;
            int n9 = n2;
            boolean bl2 = false;
            n6 = 0;
            int n10 = 0;
            do {
                int n11;
                block14 : {
                    block16 : {
                        block17 : {
                            block15 : {
                                int n12;
                                block12 : {
                                    int n13;
                                    block13 : {
                                        if (bl2) {
                                            bl2 = false;
                                            n11 = 46;
                                        } else {
                                            n11 = arrby2[n9][n6] & 255;
                                        }
                                        n12 = n11 - (arrby[n7 + n10] & 255);
                                        if (n12 != 0) break block12;
                                        n11 = n10 + 1;
                                        n13 = n6 + 1;
                                        if (n11 != n8) break block13;
                                        n6 = n13;
                                        n10 = n11;
                                        break block12;
                                    }
                                    n6 = n13;
                                    n10 = n11;
                                    if (arrby2[n9].length != n13) continue;
                                    if (n9 != arrby2.length - 1) break block14;
                                    n10 = n11;
                                    n6 = n13;
                                }
                                if (n12 < 0) break block15;
                                if (n12 > 0) break block16;
                                n10 = n8 - n10;
                                n6 = arrby2[n9].length - n6;
                                while (++n9 < arrby2.length) {
                                    n6 += arrby2[n9].length;
                                }
                                if (n6 >= n10) break block17;
                            }
                            n3 = n7 - 1;
                            continue block0;
                        }
                        if (n6 <= n10) {
                            return new String(arrby, n7, n8, c.e);
                        }
                    }
                    n4 = n5 + 1;
                    continue block0;
                }
                ++n9;
                bl2 = true;
                n6 = -1;
                n10 = n11;
            } while (true);
            break;
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String[] a(String[] object) {
        Object object2;
        int n2;
        byte[][] arrarrby;
        Object object3;
        block23 : {
            boolean bl2 = this.e.get();
            int n3 = 0;
            if (!bl2 && this.e.compareAndSet(false, true)) {
                this.b();
            } else {
                try {
                    this.f.await();
                }
                catch (InterruptedException interruptedException) {}
            }
            synchronized (this) {
                if (this.g == null) {
                    throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
                }
            }
            arrarrby = new byte[((String[])object).length][];
            for (n2 = 0; n2 < ((String[])object).length; ++n2) {
                arrarrby[n2] = object[n2].getBytes(c.e);
            }
            for (n2 = 0; n2 < arrarrby.length; ++n2) {
                object = a.a(this.g, arrarrby, n2);
                if (object == null) {
                    continue;
                }
                break block23;
            }
            object = null;
        }
        if (arrarrby.length > 1) {
            object2 = (byte[][])arrarrby.clone();
            for (n2 = 0; n2 < ((byte[][])object2).length - 1; ++n2) {
                object2[n2] = a;
                object3 = a.a(this.g, object2, n2);
                if (object3 == null) {
                    continue;
                }
                break;
            }
        } else {
            object3 = null;
        }
        if (object3 != null) {
            for (n2 = n3; n2 < arrarrby.length - 1; ++n2) {
                object2 = a.a(this.h, arrarrby, n2);
                if (object2 == null) {
                    continue;
                }
                break;
            }
        } else {
            object2 = null;
        }
        if (object2 != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("!");
            ((StringBuilder)object).append((String)object2);
            return ((StringBuilder)object).toString().split("\\.");
        }
        if (object == null && object3 == null) {
            return c;
        }
        if (((Object)(object = object != null ? ((String)object).split("\\.") : b)).length > ((String[])(object3 = object3 != null ? object3.split("\\.") : b)).length) {
            return object;
        }
        return object3;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void b() {
        boolean bl2 = false;
        do {
            Throwable throwable2222;
            try {
                this.c();
                if (!bl2) return;
                Thread.currentThread().interrupt();
                return;
            }
            catch (InterruptedIOException interruptedIOException) {}
            {
                catch (Throwable throwable2222) {
                }
                catch (IOException iOException) {}
                {
                    f.c().a(5, "Failed to read public suffix list", iOException);
                    if (!bl2) return;
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (!bl2) throw throwable2222;
            Thread.currentThread().interrupt();
            throw throwable2222;
            bl2 = true;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c() {
        Closeable closeable = a.class.getResourceAsStream("publicsuffixes.gz");
        if (closeable == null) {
            return;
        }
        closeable = l.a(new j(l.a((InputStream)closeable)));
        byte[] arrby = new byte[closeable.k()];
        closeable.a(arrby);
        byte[] arrby2 = new byte[closeable.k()];
        closeable.a(arrby2);
        synchronized (this) {
            this.g = arrby;
            this.h = arrby2;
        }
        this.f.countDown();
        return;
        finally {
            c.a(closeable);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public String a(String arrstring) {
        String[] arrstring2;
        int n2;
        int n3;
        if (arrstring == null) {
            throw new NullPointerException("domain == null");
        }
        Object object = IDN.toUnicode((String)arrstring).split("\\.");
        if (((String[])object).length == (arrstring2 = this.a((String[])object)).length && arrstring2[0].charAt(0) != '!') {
            return null;
        }
        if (arrstring2[0].charAt(0) == '!') {
            n3 = ((String[])object).length;
            n2 = arrstring2.length;
        } else {
            n3 = ((String[])object).length;
            n2 = arrstring2.length + 1;
        }
        n3 -= n2;
        object = new StringBuilder();
        arrstring = arrstring.split("\\.");
        do {
            if (n3 >= arrstring.length) {
                ((StringBuilder)object).deleteCharAt(((StringBuilder)object).length() - 1);
                return ((StringBuilder)object).toString();
            }
            ((StringBuilder)object).append(arrstring[n3]);
            ((StringBuilder)object).append('.');
            ++n3;
        } while (true);
    }
}

