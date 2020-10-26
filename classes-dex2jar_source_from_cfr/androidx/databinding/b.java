/*
 * Decompiled with CFR 0.139.
 */
package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

public class b<C, T, A>
implements Cloneable {
    private List<C> a = new ArrayList<C>();
    private long b = 0L;
    private long[] c;
    private int d;
    private final a<C, T, A> e;

    public b(a<C, T, A> a2) {
        this.e = a2;
    }

    private void a(int n2, long l2) {
        long l3 = Long.MIN_VALUE;
        for (int i2 = n2 + 64 - 1; i2 >= n2; --i2) {
            if ((l2 & l3) != 0L) {
                this.a.remove(i2);
            }
            l3 >>>= 1;
        }
    }

    private void a(T t2, int n2, A a2, int n3) {
        if (n3 < 0) {
            this.b(t2, n2, a2);
            return;
        }
        long l2 = this.c[n3];
        int n4 = (n3 + 1) * 64;
        int n5 = Math.min(this.a.size(), n4 + 64);
        this.a(t2, n2, a2, n3 - 1);
        this.a(t2, n2, a2, n4, n5, l2);
    }

    private void a(T t2, int n2, A a2, int n3, int n4, long l2) {
        long l3 = 1L;
        while (n3 < n4) {
            if ((l2 & l3) == 0L) {
                this.e.a(this.a.get(n3), t2, n2, a2);
            }
            l3 <<= 1;
            ++n3;
        }
    }

    private boolean a(int n2) {
        if (n2 < 64) {
            return (1L << n2 & this.b) != 0L;
        }
        if (this.c == null) {
            return false;
        }
        int n3 = n2 / 64 - 1;
        if (n3 >= this.c.length) {
            return false;
        }
        return (1L << n2 % 64 & this.c[n3]) != 0L;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void b(int n2) {
        long[] arrl;
        int n3;
        block6 : {
            block5 : {
                block4 : {
                    if (n2 < 64) {
                        this.b = 1L << n2 | this.b;
                        return;
                    }
                    n3 = n2 / 64 - 1;
                    if (this.c != null) break block4;
                    arrl = new long[this.a.size() / 64];
                    break block5;
                }
                if (this.c.length > n3) break block6;
                arrl = new long[this.a.size() / 64];
                System.arraycopy(this.c, 0, arrl, 0, this.c.length);
            }
            this.c = arrl;
        }
        arrl = this.c;
        arrl[n3] = 1L << n2 % 64 | arrl[n3];
    }

    private void b(T t2, int n2, A a2) {
        this.a(t2, n2, a2, 0, Math.min(64, this.a.size()), this.b);
    }

    private void c(T t2, int n2, A a2) {
        int n3 = this.a.size();
        int n4 = this.c == null ? -1 : this.c.length - 1;
        this.a(t2, n2, a2, n4);
        this.a(t2, n2, a2, (n4 + 2) * 64, n3, 0L);
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public b<C, T, A> a() {
        b b2;
        b b3;
        block10 : {
            // MONITORENTER : this
            b2 = (b)super.clone();
            try {
                b2.b = 0L;
                b2.c = null;
                int n2 = 0;
                b2.d = 0;
                b2.a = new ArrayList<C>();
                int n3 = this.a.size();
                do {
                    b3 = b2;
                    if (n2 >= n3) return b3;
                    {
                        if (!this.a(n2)) {
                            b2.a.add(this.a.get(n2));
                        }
                        ++n2;
                        continue;
                    }
                    break;
                } while (true);
            }
            catch (CloneNotSupportedException cloneNotSupportedException) {
                break block10;
            }
            catch (CloneNotSupportedException cloneNotSupportedException) {
                b2 = null;
            }
        }
        ((Throwable)((Object)b3)).printStackTrace();
        b3 = b2;
        // MONITOREXIT : this
        return b3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(C c2) {
        synchronized (this) {
            if (c2 == null) {
                throw new IllegalArgumentException("callback cannot be null");
            }
            int n2 = this.a.lastIndexOf(c2);
            if (n2 < 0 || this.a(n2)) {
                this.a.add(c2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(T t2, int n2, A a2) {
        synchronized (this) {
            void var3_3;
            int n3;
            ++this.d;
            this.c(t2, n3, var3_3);
            --this.d;
            if (this.d == 0) {
                if (this.c != null) {
                    for (n3 = this.c.length - 1; n3 >= 0; --n3) {
                        long l2 = this.c[n3];
                        if (l2 == 0L) continue;
                        this.a((n3 + 1) * 64, l2);
                        this.c[n3] = 0L;
                    }
                }
                if (this.b != 0L) {
                    this.a(0, this.b);
                    this.b = 0L;
                }
            }
            return;
        }
    }

    public void b(C c2) {
        synchronized (this) {
            if (this.d == 0) {
                this.a.remove(c2);
            } else {
                int n2 = this.a.lastIndexOf(c2);
                if (n2 >= 0) {
                    this.b(n2);
                }
            }
            return;
        }
    }

    public /* synthetic */ Object clone() {
        return this.a();
    }

    public static abstract class a<C, T, A> {
        public abstract void a(C var1, T var2, int var3, A var4);
    }

}

