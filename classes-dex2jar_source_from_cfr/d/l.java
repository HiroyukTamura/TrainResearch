/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package d;

import d.a;
import d.c;
import d.d;
import d.e;
import d.n;
import d.o;
import d.p;
import d.q;
import d.s;
import d.t;
import d.u;
import d.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class l {
    static final Logger a = Logger.getLogger(l.class.getName());

    private l() {
    }

    public static d a(s s2) {
        return new n(s2);
    }

    public static e a(t t2) {
        return new o(t2);
    }

    public static s a(OutputStream outputStream) {
        return l.a(outputStream, new u());
    }

    private static s a(final OutputStream outputStream, u u2) {
        if (outputStream != null) {
            if (u2 != null) {
                return new s(){

                    @Override
                    public u a() {
                        return u.this;
                    }

                    @Override
                    public void a_(c c2, long l2) {
                        v.a(c2.b, 0L, l2);
                        while (l2 > 0L) {
                            u.this.g();
                            p p2 = c2.a;
                            int n2 = (int)Math.min(l2, (long)(p2.c - p2.b));
                            outputStream.write(p2.a, p2.b, n2);
                            p2.b += n2;
                            long l3 = n2;
                            long l4 = l2 - l3;
                            c2.b -= l3;
                            l2 = l4;
                            if (p2.b != p2.c) continue;
                            c2.a = p2.b();
                            q.a(p2);
                            l2 = l4;
                        }
                    }

                    @Override
                    public void close() {
                        outputStream.close();
                    }

                    @Override
                    public void flush() {
                        outputStream.flush();
                    }

                    public String toString() {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("sink(");
                        stringBuilder.append(outputStream);
                        stringBuilder.append(")");
                        return stringBuilder.toString();
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("out == null");
    }

    public static s a(Socket socket) {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                a a2 = l.c(socket);
                return a2.a(l.a(socket.getOutputStream(), (u)a2));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static t a(File file) {
        if (file != null) {
            return l.a(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static t a(InputStream inputStream) {
        return l.a(inputStream, new u());
    }

    private static t a(final InputStream inputStream, u u2) {
        if (inputStream != null) {
            if (u2 != null) {
                return new t(){

                    @Override
                    public long a(c object, long l2) {
                        long l3 = l2 LCMP 0L;
                        if (l3 >= 0) {
                            block7 : {
                                if (l3 == false) {
                                    return 0L;
                                }
                                try {
                                    u.this.g();
                                    p p2 = ((c)object).e(1);
                                    l3 = (int)Math.min(l2, (long)(8192 - p2.c));
                                    l3 = inputStream.read(p2.a, p2.c, (int)l3);
                                    if (l3 != -1) break block7;
                                    return -1L;
                                }
                                catch (AssertionError assertionError) {
                                    if (l.a(assertionError)) {
                                        throw new IOException((Throwable)((Object)assertionError));
                                    }
                                    throw assertionError;
                                }
                            }
                            p2.c += l3;
                            l2 = ((c)object).b;
                            long l4 = l3;
                            ((c)object).b = l2 + l4;
                            return l4;
                        }
                        object = new StringBuilder();
                        ((StringBuilder)object).append("byteCount < 0: ");
                        ((StringBuilder)object).append(l2);
                        throw new IllegalArgumentException(((StringBuilder)object).toString());
                    }

                    @Override
                    public u a() {
                        return u.this;
                    }

                    @Override
                    public void close() {
                        inputStream.close();
                    }

                    public String toString() {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("source(");
                        stringBuilder.append(inputStream);
                        stringBuilder.append(")");
                        return stringBuilder.toString();
                    }
                };
            }
            throw new IllegalArgumentException("timeout == null");
        }
        throw new IllegalArgumentException("in == null");
    }

    static boolean a(AssertionError assertionError) {
        return ((Throwable)((Object)assertionError)).getCause() != null && ((Throwable)((Object)assertionError)).getMessage() != null && ((Throwable)((Object)assertionError)).getMessage().contains("getsockname failed");
    }

    public static s b(File file) {
        if (file != null) {
            return l.a(new FileOutputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    public static t b(Socket socket) {
        if (socket != null) {
            if (socket.getInputStream() != null) {
                a a2 = l.c(socket);
                return a2.a(l.a(socket.getInputStream(), (u)a2));
            }
            throw new IOException("socket's input stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    private static a c(Socket socket) {
        return new a(){

            @Override
            protected IOException a(@Nullable IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }

            @Override
            protected void a() {
                StringBuilder stringBuilder;
                void var1_3;
                Logger logger;
                Level level;
                try {
                    Socket.this.close();
                    return;
                }
                catch (AssertionError assertionError) {
                    if (l.a(assertionError)) {
                        logger = l.a;
                        level = Level.WARNING;
                        stringBuilder = new StringBuilder();
                    }
                    throw assertionError;
                }
                catch (Exception exception) {
                    logger = l.a;
                    level = Level.WARNING;
                    stringBuilder = new StringBuilder();
                }
                stringBuilder.append("Failed to close timed out socket ");
                stringBuilder.append(Socket.this);
                logger.log(level, stringBuilder.toString(), (Throwable)var1_3);
            }
        };
    }

}

