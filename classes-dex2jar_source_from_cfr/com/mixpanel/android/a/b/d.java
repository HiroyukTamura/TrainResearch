/*
 * Decompiled with CFR 0.139.
 */
package com.mixpanel.android.a.b;

import com.mixpanel.android.a.b.a;
import com.mixpanel.android.a.d.d;
import com.mixpanel.android.a.d.e;
import com.mixpanel.android.a.e.b;
import com.mixpanel.android.a.e.c;
import com.mixpanel.android.a.e.f;
import com.mixpanel.android.a.e.h;
import com.mixpanel.android.a.e.i;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class d
extends a {
    protected boolean f = false;
    protected List<com.mixpanel.android.a.d.d> g = new LinkedList<com.mixpanel.android.a.d.d>();
    protected ByteBuffer h;
    private final Random i = new Random();

    @Override
    public a.b a(com.mixpanel.android.a.e.a a2) {
        if (a2.c("Origin") && this.a((f)a2)) {
            return a.b.a;
        }
        return a.b.b;
    }

    @Override
    public a.b a(com.mixpanel.android.a.e.a a2, h h2) {
        if (a2.b("WebSocket-Origin").equals(h2.b("Origin")) && this.a(h2)) {
            return a.b.a;
        }
        return a.b.b;
    }

    @Override
    public b a(b b2) {
        b2.a("Upgrade", "WebSocket");
        b2.a("Connection", "Upgrade");
        if (!b2.c("Origin")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("random");
            stringBuilder.append(this.i.nextInt());
            b2.a("Origin", stringBuilder.toString());
        }
        return b2;
    }

    @Override
    public c a(com.mixpanel.android.a.e.a a2, i i2) {
        i2.a("Web Socket Protocol Handshake");
        i2.a("Upgrade", "WebSocket");
        i2.a("Connection", a2.b("Connection"));
        i2.a("WebSocket-Origin", a2.b("Origin"));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ws://");
        stringBuilder.append(a2.b("Host"));
        stringBuilder.append(a2.a());
        i2.a("WebSocket-Location", stringBuilder.toString());
        return i2;
    }

    @Override
    public ByteBuffer a(com.mixpanel.android.a.d.d object) {
        if (object.f() == d.a.b) {
            object = object.c();
            ByteBuffer byteBuffer = ByteBuffer.allocate(((Buffer)object).remaining() + 2);
            byteBuffer.put((byte)0);
            ((Buffer)object).mark();
            byteBuffer.put((ByteBuffer)object);
            ((Buffer)object).reset();
            byteBuffer.put((byte)-1);
            byteBuffer.flip();
            return byteBuffer;
        }
        throw new RuntimeException("only text frames supported");
    }

    @Override
    public void a() {
        this.f = false;
        this.h = null;
    }

    @Override
    public a.a b() {
        return a.a.a;
    }

    @Override
    public a c() {
        return new d();
    }

    @Override
    public List<com.mixpanel.android.a.d.d> c(ByteBuffer object) {
        if ((object = this.e((ByteBuffer)object)) != null) {
            return object;
        }
        throw new com.mixpanel.android.a.c.b(1002);
    }

    public ByteBuffer d() {
        return ByteBuffer.allocate(b);
    }

    /*
     * Enabled aggressive block sorting
     */
    protected List<com.mixpanel.android.a.d.d> e(ByteBuffer list) {
        do {
            byte by2;
            block13 : {
                Object object;
                block12 : {
                    block11 : {
                        if (!((Buffer)((Object)list)).hasRemaining()) {
                            list = this.g;
                            this.g = new LinkedList<com.mixpanel.android.a.d.d>();
                            return list;
                        }
                        by2 = ((ByteBuffer)((Object)list)).get();
                        if (by2 == 0) {
                            if (this.f) {
                                throw new com.mixpanel.android.a.c.c("unexpected START_OF_FRAME");
                            }
                            this.f = true;
                            continue;
                        }
                        if (by2 == -1) {
                            if (!this.f) {
                                throw new com.mixpanel.android.a.c.c("unexpected END_OF_FRAME");
                            }
                            if (this.h != null) {
                                this.h.flip();
                                object = new e();
                                ((e)object).a(this.h);
                                ((e)object).a(true);
                                ((e)object).a(d.a.b);
                                this.g.add((com.mixpanel.android.a.d.d)object);
                                this.h = null;
                                ((Buffer)((Object)list)).mark();
                            }
                            this.f = false;
                            continue;
                        }
                        if (!this.f) {
                            return null;
                        }
                        if (this.h != null) break block11;
                        object = this.d();
                        break block12;
                    }
                    if (this.h.hasRemaining()) break block13;
                    object = this.f(this.h);
                }
                this.h = object;
            }
            this.h.put(by2);
        } while (true);
    }

    public ByteBuffer f(ByteBuffer byteBuffer) {
        byteBuffer.flip();
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(this.a(byteBuffer.capacity() * 2));
        byteBuffer2.put(byteBuffer);
        return byteBuffer2;
    }
}

