/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 */
package com.mixpanel.android.a.b;

import android.annotation.SuppressLint;
import com.mixpanel.android.a.a;
import com.mixpanel.android.a.b.a;
import com.mixpanel.android.a.d.d;
import com.mixpanel.android.a.d.e;
import com.mixpanel.android.a.e.c;
import com.mixpanel.android.a.e.f;
import com.mixpanel.android.a.e.h;
import com.mixpanel.android.a.e.i;
import java.math.BigInteger;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SuppressLint(value={"Assert", "UseValueOf"})
public class b
extends com.mixpanel.android.a.b.a {
    static final /* synthetic */ boolean f;
    private ByteBuffer g;
    private d h = null;
    private final Random i = new Random();

    static {
        f = b.class.desiredAssertionStatus() ^ true;
    }

    private byte a(d.a a2) {
        if (a2 == d.a.a) {
            return 0;
        }
        if (a2 == d.a.b) {
            return 1;
        }
        if (a2 == d.a.c) {
            return 2;
        }
        if (a2 == d.a.f) {
            return 8;
        }
        if (a2 == d.a.d) {
            return 9;
        }
        if (a2 == d.a.e) {
            return 10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Don't know how to handle ");
        stringBuilder.append(a2.toString());
        throw new RuntimeException(stringBuilder.toString());
    }

    private d.a a(byte by2) {
        switch (by2) {
            default: {
                switch (by2) {
                    default: {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("unknow optcode ");
                        stringBuilder.append(by2);
                        throw new com.mixpanel.android.a.c.c(stringBuilder.toString());
                    }
                    case 10: {
                        return d.a.e;
                    }
                    case 9: {
                        return d.a.d;
                    }
                    case 8: 
                }
                return d.a.f;
            }
            case 2: {
                return d.a.c;
            }
            case 1: {
                return d.a.b;
            }
            case 0: 
        }
        return d.a.a;
    }

    private String a(String string2) {
        string2 = string2.trim();
        Object object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
        string2 = ((StringBuilder)object).toString();
        try {
            object = MessageDigest.getInstance("SHA1");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException(noSuchAlgorithmException);
        }
        return com.mixpanel.android.a.f.a.a(((MessageDigest)object).digest(string2.getBytes()));
    }

    private byte[] a(long l2, int n2) {
        byte[] arrby = new byte[n2];
        for (int i2 = 0; i2 < n2; ++i2) {
            arrby[i2] = (byte)(l2 >>> n2 * 8 - 8 - i2 * 8);
        }
        return arrby;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int b(f object) {
        if (((String)(object = object.b("Sec-WebSocket-Version"))).length() <= 0) return -1;
        try {
            return new Integer(((String)object).trim());
        }
        catch (NumberFormatException numberFormatException) {
            return -1;
        }
    }

    @Override
    public a.b a(com.mixpanel.android.a.e.a a2) {
        int n2 = b.b(a2);
        if (n2 != 7 && n2 != 8) {
            return a.b.b;
        }
        if (this.a((f)a2)) {
            return a.b.a;
        }
        return a.b.b;
    }

    @Override
    public a.b a(com.mixpanel.android.a.e.a a2, h object) {
        if (a2.c("Sec-WebSocket-Key") && object.c("Sec-WebSocket-Accept")) {
            object = object.b("Sec-WebSocket-Accept");
            if (this.a(a2.b("Sec-WebSocket-Key")).equals(object)) {
                return a.b.a;
            }
            return a.b.b;
        }
        return a.b.b;
    }

    @Override
    public com.mixpanel.android.a.e.b a(com.mixpanel.android.a.e.b b2) {
        b2.a("Upgrade", "websocket");
        b2.a("Connection", "Upgrade");
        b2.a("Sec-WebSocket-Version", "8");
        byte[] arrby = new byte[16];
        this.i.nextBytes(arrby);
        b2.a("Sec-WebSocket-Key", com.mixpanel.android.a.f.a.a(arrby));
        return b2;
    }

    @Override
    public c a(com.mixpanel.android.a.e.a object, i i2) {
        i2.a("Upgrade", "websocket");
        i2.a("Connection", object.b("Connection"));
        i2.a("Switching Protocols");
        object = object.b("Sec-WebSocket-Key");
        if (object != null) {
            i2.a("Sec-WebSocket-Accept", this.a((String)object));
            return i2;
        }
        throw new com.mixpanel.android.a.c.d("missing Sec-WebSocket-Key");
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public ByteBuffer a(d object) {
        ByteBuffer byteBuffer = object.c();
        Object object2 = this.d;
        a.b b2 = a.b.a;
        Object object3 = 0;
        boolean bl2 = object2 == b2;
        Object object4 = byteBuffer.remaining() <= 125 ? 1 : (byteBuffer.remaining() <= 65535 ? 2 : 8);
        int n2 = object4 > 1 ? object4 + 1 : object4;
        int n3 = bl2 ? 4 : 0;
        object2 = ByteBuffer.allocate(n2 + 1 + n3 + byteBuffer.remaining());
        byte by2 = this.a(object.f());
        boolean bl3 = object.d();
        n2 = -128;
        n3 = bl3 ? -128 : 0;
        ((ByteBuffer)object2).put((byte)((byte)n3 | by2));
        object = this.a(byteBuffer.remaining(), (int)object4);
        if (!f && ((Object)object).length != object4) {
            throw new AssertionError();
        }
        if (object4 == 1) {
            object4 = object[0];
            if (!bl2) {
                n2 = 0;
            }
            ((ByteBuffer)object2).put((byte)(object4 | n2));
        } else {
            if (object4 == 2) {
                if (!bl2) {
                    n2 = 0;
                }
                object4 = n2 | 126;
            } else {
                if (object4 != 8) {
                    throw new RuntimeException("Size representation not supported/specified");
                }
                if (!bl2) {
                    n2 = 0;
                }
                object4 = n2 | 127;
            }
            ((ByteBuffer)object2).put((byte)object4);
            ((ByteBuffer)object2).put((byte[])object);
        }
        if (bl2) {
            object = ByteBuffer.allocate(4);
            ((ByteBuffer)object).putInt(this.i.nextInt());
            ((ByteBuffer)object2).put(((ByteBuffer)object).array());
            object4 = object3;
            while (byteBuffer.hasRemaining()) {
                ((ByteBuffer)object2).put((byte)(byteBuffer.get() ^ ((ByteBuffer)object).get(object4 % 4)));
                ++object4;
            }
        } else {
            ((ByteBuffer)object2).put(byteBuffer);
        }
        if (!f && ((Buffer)object2).remaining() != 0) {
            throw new AssertionError(((Buffer)object2).remaining());
        }
        ((Buffer)object2).flip();
        return object2;
    }

    @Override
    public void a() {
        this.g = null;
    }

    @Override
    public a.a b() {
        return a.a.c;
    }

    @Override
    public com.mixpanel.android.a.b.a c() {
        return new b();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public List<d> c(ByteBuffer byteBuffer) {
        LinkedList<d> linkedList = new LinkedList<d>();
        if (this.g != null) {
            try {
                byteBuffer.mark();
                int n2 = byteBuffer.remaining();
                int n3 = this.g.remaining();
                if (n3 > n2) {
                    this.g.put(byteBuffer.array(), byteBuffer.position(), n2);
                    byteBuffer.position(byteBuffer.position() + n2);
                    return Collections.emptyList();
                }
                this.g.put(byteBuffer.array(), byteBuffer.position(), n3);
                byteBuffer.position(byteBuffer.position() + n3);
                linkedList.add(this.e((ByteBuffer)this.g.duplicate().position(0)));
                this.g = null;
            }
            catch (a a2) {
                this.g.limit();
                ByteBuffer byteBuffer2 = ByteBuffer.allocate(this.a(a2.a()));
                if (!f && byteBuffer2.limit() <= this.g.limit()) {
                    throw new AssertionError();
                }
                this.g.rewind();
                byteBuffer2.put(this.g);
                this.g = byteBuffer2;
                return this.c(byteBuffer);
            }
        }
        while (byteBuffer.hasRemaining()) {
            byteBuffer.mark();
            try {
                linkedList.add(this.e(byteBuffer));
            }
            catch (a a3) {
                byteBuffer.reset();
                this.g = ByteBuffer.allocate(this.a(a3.a()));
                this.g.put(byteBuffer);
                return linkedList;
            }
        }
        return linkedList;
    }

    public d e(ByteBuffer object) {
        block11 : {
            int n2;
            block12 : {
                block14 : {
                    block17 : {
                        block18 : {
                            Object object2;
                            int n3;
                            int n4;
                            boolean bl2;
                            d.a a2;
                            boolean bl3;
                            int n5;
                            block13 : {
                                block15 : {
                                    block16 : {
                                        n5 = ((Buffer)object).remaining();
                                        n3 = 2;
                                        if (n5 < 2) break block11;
                                        n4 = ((ByteBuffer)object).get();
                                        int n6 = 0;
                                        bl3 = n4 >> 8 != 0;
                                        n2 = (n4 & 127) >> 4;
                                        if (n2 != 0) break block12;
                                        n2 = ((ByteBuffer)object).get();
                                        bl2 = (n2 & -128) != 0;
                                        n2 = (byte)(n2 & 127);
                                        a2 = this.a((byte)(n4 & 15));
                                        if (!(bl3 || a2 != d.a.d && a2 != d.a.e && a2 != d.a.f)) {
                                            throw new com.mixpanel.android.a.c.c("control frames may no be fragmented");
                                        }
                                        if (n2 >= 0 && n2 <= 125) break block13;
                                        if (a2 == d.a.d || a2 == d.a.e || a2 == d.a.f) break block14;
                                        if (n2 != 126) break block15;
                                        if (n5 < 4) break block16;
                                        object2 = new byte[3];
                                        object2[1] = ((ByteBuffer)object).get();
                                        object2[2] = ((ByteBuffer)object).get();
                                        n2 = new BigInteger((byte[])object2).intValue();
                                        n3 = 4;
                                        break block13;
                                    }
                                    throw new a(4);
                                }
                                n3 = 10;
                                if (n5 < 10) break block17;
                                object2 = new byte[8];
                                for (n2 = 0; n2 < 8; ++n2) {
                                    object2[n2] = ((ByteBuffer)object).get();
                                }
                                long l2 = new BigInteger((byte[])object2).longValue();
                                if (l2 > Integer.MAX_VALUE) break block18;
                                n2 = (int)l2;
                            }
                            if (n5 >= (n3 = n3 + (n4 = bl2 ? 4 : 0) + n2)) {
                                object2 = ByteBuffer.allocate(this.a(n2));
                                if (bl2) {
                                    byte[] arrby = new byte[4];
                                    ((ByteBuffer)object).get(arrby);
                                    for (n3 = n6; n3 < n2; ++n3) {
                                        ((ByteBuffer)object2).put((byte)(((ByteBuffer)object).get() ^ arrby[n3 % 4]));
                                    }
                                } else {
                                    ((ByteBuffer)object2).put(((ByteBuffer)object).array(), ((Buffer)object).position(), ((Buffer)object2).limit());
                                    ((Buffer)object).position(((Buffer)object).position() + ((Buffer)object2).limit());
                                }
                                if (a2 == d.a.f) {
                                    object = new com.mixpanel.android.a.d.b();
                                } else {
                                    object = new e();
                                    object.a(bl3);
                                    object.a(a2);
                                }
                                ((Buffer)object2).flip();
                                object.a((ByteBuffer)object2);
                                return object;
                            }
                            throw new a(n3);
                        }
                        throw new com.mixpanel.android.a.c.e("Payloadsize is to big...");
                    }
                    throw new a(10);
                }
                throw new com.mixpanel.android.a.c.c("more than 125 octets");
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("bad rsv ");
            ((StringBuilder)object).append(n2);
            throw new com.mixpanel.android.a.c.c(((StringBuilder)object).toString());
        }
        throw new a(2);
    }

    private class a
    extends Throwable {
        private int b;

        public a(int n2) {
            this.b = n2;
        }

        public int a() {
            return this.b;
        }
    }

}

