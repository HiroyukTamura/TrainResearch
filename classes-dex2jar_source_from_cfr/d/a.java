/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package d;

import d.c;
import d.p;
import d.s;
import d.t;
import d.u;
import d.v;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public class a
extends u {
    private static final long a = TimeUnit.SECONDS.toMillis(60L);
    @Nullable
    static a b;
    private static final long d;
    private boolean e;
    @Nullable
    private a f;
    private long g;

    static {
        d = TimeUnit.MILLISECONDS.toNanos(a);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(a a2, long l2, boolean bl2) {
        synchronized (a.class) {
            long l3;
            void var3_2;
            if (b == null) {
                b = new a();
                new a().start();
            }
            long l4 = System.nanoTime();
            void var4_4 = l3 LCMP 0L;
            if (var4_4 != false && var3_2 != false) {
                a2.g = Math.min(l3, a2.d() - l4) + l4;
            } else if (var4_4 != false) {
                a2.g = l3 + l4;
            } else {
                if (var3_2 == false) {
                    throw new AssertionError();
                }
                a2.g = a2.d();
            }
            l3 = a2.b(l4);
            a a3 = b;
            while (a3.f != null && l3 >= a3.f.b(l4)) {
                a3 = a3.f;
            }
            a2.f = a3.f;
            a3.f = a2;
            if (a3 == b) {
                a.class.notify();
            }
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean a(a a2) {
        synchronized (a.class) {
            a a3 = b;
            while (a3 != null) {
                block6 : {
                    if (a3.f != a2) break block6;
                    a3.f = a2.f;
                    a2.f = null;
                    return false;
                }
                a3 = a3.f;
            }
            return true;
        }
    }

    private long b(long l2) {
        return this.g - l2;
    }

    @Nullable
    static a e() {
        a a2 = a.b.f;
        Object var5_1 = null;
        if (a2 == null) {
            long l2 = System.nanoTime();
            a.class.wait(a);
            a2 = var5_1;
            if (a.b.f == null) {
                a2 = var5_1;
                if (System.nanoTime() - l2 >= d) {
                    a2 = b;
                }
            }
            return a2;
        }
        long l3 = a2.b(System.nanoTime());
        if (l3 > 0L) {
            long l4 = l3 / 1000000L;
            a.class.wait(l4, (int)(l3 - 1000000L * l4));
            return null;
        }
        a.b.f = a2.f;
        a2.f = null;
        return a2;
    }

    public final s a(final s s2) {
        return new s(){

            @Override
            public u a() {
                return a.this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            @Override
            public void a_(c c2, long l2) {
                Throwable throwable2222;
                v.a(c2.b, 0L, l2);
                do {
                    long l3;
                    long l4 = 0L;
                    if (l2 <= 0L) return;
                    p p2 = c2.a;
                    do {
                        l3 = l4;
                        if (l4 >= 65536L) break;
                        if ((l4 += (long)(p2.c - p2.b)) >= l2) {
                            l3 = l2;
                            break;
                        }
                        p2 = p2.f;
                    } while (true);
                    a.this.c();
                    s2.a_(c2, l3);
                    l2 -= l3;
                    a.this.a(true);
                    continue;
                    {
                        catch (Throwable throwable2222) {
                            break;
                        }
                        catch (IOException iOException) {}
                        {
                            throw a.this.b(iOException);
                        }
                    }
                } while (true);
                a.this.a(false);
                throw throwable2222;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            @Override
            public void close() {
                Throwable throwable2222;
                a.this.c();
                s2.close();
                a.this.a(true);
                return;
                {
                    catch (Throwable throwable2222) {
                    }
                    catch (IOException iOException) {}
                    {
                        throw a.this.b(iOException);
                    }
                }
                a.this.a(false);
                throw throwable2222;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            @Override
            public void flush() {
                Throwable throwable2222;
                a.this.c();
                s2.flush();
                a.this.a(true);
                return;
                {
                    catch (Throwable throwable2222) {
                    }
                    catch (IOException iOException) {}
                    {
                        throw a.this.b(iOException);
                    }
                }
                a.this.a(false);
                throw throwable2222;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("AsyncTimeout.sink(");
                stringBuilder.append(s2);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
        };
    }

    public final t a(final t t2) {
        return new t(){

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            @Override
            public long a(c c2, long l2) {
                Throwable throwable2222;
                a.this.c();
                l2 = t2.a(c2, l2);
                a.this.a(true);
                return l2;
                {
                    catch (Throwable throwable2222) {
                    }
                    catch (IOException iOException) {}
                    {
                        throw a.this.b(iOException);
                    }
                }
                a.this.a(false);
                throw throwable2222;
            }

            @Override
            public u a() {
                return a.this;
            }

            /*
             * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            @Override
            public void close() {
                Throwable throwable2222;
                a.this.c();
                t2.close();
                a.this.a(true);
                return;
                {
                    catch (Throwable throwable2222) {
                    }
                    catch (IOException iOException) {}
                    {
                        throw a.this.b(iOException);
                    }
                }
                a.this.a(false);
                throw throwable2222;
            }

            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("AsyncTimeout.source(");
                stringBuilder.append(t2);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
        };
    }

    protected IOException a(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    protected void a() {
    }

    final void a(boolean bl2) {
        if (this.t_()) {
            if (!bl2) {
                return;
            }
            throw this.a((IOException)null);
        }
    }

    final IOException b(IOException iOException) {
        if (!this.t_()) {
            return iOException;
        }
        return this.a(iOException);
    }

    public final void c() {
        if (!this.e) {
            long l2 = this.u_();
            boolean bl2 = this.v_();
            if (l2 == 0L && !bl2) {
                return;
            }
            this.e = true;
            a.a(this, l2, bl2);
            return;
        }
        throw new IllegalStateException("Unbalanced enter/exit");
    }

    public final boolean t_() {
        if (!this.e) {
            return false;
        }
        this.e = false;
        return a.a(this);
    }

    private static final class a
    extends Thread {
        a() {
            super("Okio Watchdog");
            this.setDaemon(true);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Converted monitor instructions to comments
         * Lifted jumps to return sites
         */
        @Override
        public void run() {
            do {
                a a2;
                if ((a2 = a.e()) == null) {
                    // MONITOREXIT : d.a.class
                    continue;
                }
                if (a2 == a.b) {
                    a.b = null;
                    // MONITOREXIT : d.a.class
                    return;
                }
                // MONITOREXIT : d.a.class
                try {
                    a2.a();
                }
                catch (InterruptedException interruptedException) {
                }
            } while (true);
        }
    }

}

