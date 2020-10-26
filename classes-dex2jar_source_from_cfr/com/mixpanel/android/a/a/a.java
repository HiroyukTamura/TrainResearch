/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 */
package com.mixpanel.android.a.a;

import android.annotation.SuppressLint;
import com.mixpanel.android.a.b;
import com.mixpanel.android.a.c;
import com.mixpanel.android.a.d;
import com.mixpanel.android.a.d.d;
import com.mixpanel.android.a.e.f;
import com.mixpanel.android.a.e.g;
import com.mixpanel.android.a.e.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

@SuppressLint(value={"Assert"})
public abstract class a
extends b
implements com.mixpanel.android.a.a,
Runnable {
    static final /* synthetic */ boolean b;
    protected URI a = null;
    private c c = null;
    private Socket d = null;
    private InputStream e;
    private OutputStream f;
    private Proxy g = Proxy.NO_PROXY;
    private Thread h;
    private com.mixpanel.android.a.b.a i;
    private Map<String, String> j;
    private CountDownLatch k = new CountDownLatch(1);
    private CountDownLatch l = new CountDownLatch(1);
    private int m = 0;

    static {
        b = a.class.desiredAssertionStatus() ^ true;
    }

    public a(URI uRI, com.mixpanel.android.a.b.a a2, Map<String, String> map, int n2) {
        if (uRI != null) {
            if (a2 != null) {
                this.a = uRI;
                this.i = a2;
                this.j = map;
                this.m = n2;
                this.c = new c(this, a2);
                return;
            }
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
        throw new IllegalArgumentException();
    }

    private int h() {
        int n2 = this.a.getPort();
        if (n2 == -1) {
            String string2 = this.a.getScheme();
            if (string2.equals("wss")) {
                return 443;
            }
            if (string2.equals("ws")) {
                return 80;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unkonow scheme");
            stringBuilder.append(string2);
            throw new RuntimeException(stringBuilder.toString());
        }
        return n2;
    }

    private void i() {
        Object object;
        String object32;
        Object object2;
        block9 : {
            block8 : {
                object2 = this.a.getPath();
                object32 = this.a.getQuery();
                if (object2 == null) break block8;
                object = object2;
                if (((String)object2).length() != 0) break block9;
            }
            object = "/";
        }
        object2 = object;
        if (object32 != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append("?");
            ((StringBuilder)object2).append(object32);
            object2 = ((StringBuilder)object2).toString();
        }
        int n2 = this.h();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.getHost());
        if (n2 != 80) {
            object = new StringBuilder();
            ((StringBuilder)object).append(":");
            ((StringBuilder)object).append(n2);
            object = ((StringBuilder)object).toString();
        } else {
            object = "";
        }
        stringBuilder.append((String)object);
        String string2 = stringBuilder.toString();
        object = new com.mixpanel.android.a.e.d();
        ((com.mixpanel.android.a.e.d)object).a((String)object2);
        ((g)object).a("Host", string2);
        if (this.j != null) {
            for (Map.Entry entry : this.j.entrySet()) {
                ((g)object).a((String)entry.getKey(), (String)entry.getValue());
            }
        }
        this.c.a((com.mixpanel.android.a.e.b)object);
    }

    @Override
    public InetSocketAddress a() {
        return this.c.a();
    }

    public void a(int n2, String string2) {
    }

    public void a(int n2, String string2, boolean bl2) {
    }

    @Override
    public void a(com.mixpanel.android.a.a a2, int n2, String string2) {
        this.a(n2, string2);
    }

    @Override
    public final void a(com.mixpanel.android.a.a a2, int n2, String string2, boolean bl2) {
        this.k.countDown();
        this.l.countDown();
        if (this.h != null) {
            this.h.interrupt();
        }
        try {
            if (this.d != null) {
                this.d.close();
            }
        }
        catch (IOException iOException) {
            this.a((com.mixpanel.android.a.a)this, iOException);
        }
        this.b(n2, string2, bl2);
    }

    @Override
    public void a(com.mixpanel.android.a.a a2, com.mixpanel.android.a.d.d d2) {
        this.b(d2);
    }

    @Override
    public final void a(com.mixpanel.android.a.a a2, f f2) {
        this.k.countDown();
        this.a((h)f2);
    }

    @Override
    public final void a(com.mixpanel.android.a.a a2, Exception exception) {
        this.a(exception);
    }

    @Override
    public final void a(com.mixpanel.android.a.a a2, String string2) {
        this.a(string2);
    }

    @Override
    public final void a(com.mixpanel.android.a.a a2, ByteBuffer byteBuffer) {
        this.a(byteBuffer);
    }

    public void a(d.a a2, ByteBuffer byteBuffer, boolean bl2) {
        this.c.a(a2, byteBuffer, bl2);
    }

    @Override
    public void a(com.mixpanel.android.a.d.d d2) {
        this.c.a(d2);
    }

    public abstract void a(h var1);

    public abstract void a(Exception var1);

    public abstract void a(String var1);

    public void a(Socket socket) {
        if (this.d == null) {
            this.d = socket;
            return;
        }
        throw new IllegalStateException("socket has already been set");
    }

    public void a(ByteBuffer byteBuffer) {
    }

    public void b() {
        if (this.h == null) {
            this.h = new Thread(this);
            this.h.start();
            return;
        }
        throw new IllegalStateException("WebSocketClient objects are not reuseable");
    }

    public abstract void b(int var1, String var2, boolean var3);

    @Override
    public final void b(com.mixpanel.android.a.a a2) {
    }

    @Override
    public void b(com.mixpanel.android.a.a a2, int n2, String string2, boolean bl2) {
        this.a(n2, string2, bl2);
    }

    public void b(com.mixpanel.android.a.d.d d2) {
    }

    @Override
    public InetSocketAddress c(com.mixpanel.android.a.a a2) {
        if (this.d != null) {
            return (InetSocketAddress)this.d.getLocalSocketAddress();
        }
        return null;
    }

    public boolean c() {
        this.b();
        this.k.await();
        return this.c.c();
    }

    public boolean d() {
        return this.c.c();
    }

    public boolean e() {
        return this.c.e();
    }

    public boolean f() {
        return this.c.f();
    }

    public boolean g() {
        return this.c.d();
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    @Override
    public void run() {
        block11 : {
            block10 : {
                if (this.d == null) {
                    this.d = new Socket(this.g);
                } else if (this.d.isClosed()) break block10;
                if (!this.d.isBound()) {
                    this.d.connect(new InetSocketAddress(this.a.getHost(), this.h()), this.m);
                }
                this.e = this.d.getInputStream();
                this.f = this.d.getOutputStream();
                this.i();
                this.h = new Thread(new a());
                this.h.start();
                byte[] arrby = new byte[c.a];
                try {
                    int n2;
                    while (!this.f() && (n2 = this.e.read(arrby)) != -1) {
                        this.c.a(ByteBuffer.wrap(arrby, 0, n2));
                    }
                    this.c.b();
                    break block11;
                }
                catch (RuntimeException runtimeException) {
                    this.a(runtimeException);
                    this.c.b(1006, runtimeException.getMessage());
                    break block11;
                }
            }
            try {
                throw new IOException();
            }
            catch (Exception exception) {
                this.a((com.mixpanel.android.a.a)this.c, exception);
                this.c.b(-1, exception.getMessage());
                return;
            }
            catch (IOException iOException) {}
            this.c.b();
        }
        if (b) return;
        if (!this.d.isClosed()) throw new AssertionError();
    }

    private class a
    implements Runnable {
        private a() {
        }

        /*
         * Loose catch block
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        @Override
        public void run() {
            Thread.currentThread().setName("WebsocketWriteThread");
            try {
                while (!Thread.interrupted()) {
                    ByteBuffer byteBuffer = a.a((a)a.this).f.take();
                    a.this.f.write(byteBuffer.array(), 0, byteBuffer.limit());
                    a.this.f.flush();
                }
                return;
            }
            catch (IOException iOException) {}
            a.this.c.b();
            return;
            catch (InterruptedException interruptedException) {
                return;
            }
        }
    }

}

