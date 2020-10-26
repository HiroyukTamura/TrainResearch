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
import com.mixpanel.android.a.b.d;
import com.mixpanel.android.a.d.d;
import com.mixpanel.android.a.e.b;
import com.mixpanel.android.a.e.c;
import com.mixpanel.android.a.e.f;
import com.mixpanel.android.a.e.h;
import com.mixpanel.android.a.e.i;
import java.nio.Buffer;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@SuppressLint(value={"UseValueOf"})
public class e
extends d {
    private static final byte[] j = new byte[]{-1, 0};
    private boolean i = false;
    private final Random k = new Random();

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static byte[] a(String string2) {
        long l2;
        long l3;
        try {
            l3 = Long.parseLong(string2.replaceAll("[^0-9]", ""));
            l2 = string2.split(" ").length - 1;
            if (l2 == 0L) throw new com.mixpanel.android.a.c.d("invalid Sec-WebSocket-Key (/key2/)");
        }
        catch (NumberFormatException numberFormatException) {
            throw new com.mixpanel.android.a.c.d("invalid Sec-WebSocket-Key (/key1/ or /key2/)");
        }
        l3 = new Long(l3 / l2);
        return new byte[]{(byte)(l3 >> 24), (byte)(l3 << 8 >> 24), (byte)(l3 << 16 >> 24), (byte)(l3 << 24 >> 24)};
    }

    public static byte[] a(String object, String arrby, byte[] arrby2) {
        object = e.a((String)object);
        arrby = e.a((String)arrby);
        byte by2 = object[0];
        byte by3 = object[1];
        byte by4 = object[2];
        byte by5 = object[3];
        byte by6 = arrby[0];
        byte by7 = arrby[1];
        byte by8 = arrby[2];
        byte by9 = arrby[3];
        byte by10 = arrby2[0];
        byte by11 = arrby2[1];
        byte by12 = arrby2[2];
        byte by13 = arrby2[3];
        byte by14 = arrby2[4];
        byte by15 = arrby2[5];
        byte by16 = arrby2[6];
        byte by17 = arrby2[7];
        try {
            object = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new RuntimeException(noSuchAlgorithmException);
        }
        return ((MessageDigest)object).digest(new byte[]{by2, by3, by4, by5, by6, by7, by8, by9, by10, by11, by12, by13, by14, by15, by16, by17});
    }

    private static String e() {
        String string2;
        int n2;
        Random random = new Random();
        long l2 = random.nextInt(12) + 1;
        String string3 = Long.toString((long)(random.nextInt(Math.abs(new Long(0xFFFFFFFFL / l2).intValue())) + 1) * l2);
        int n3 = random.nextInt(12);
        int n4 = 0;
        int n5 = 0;
        do {
            char c2;
            n2 = n4;
            string2 = string3;
            if (n5 >= n3 + 1) break;
            n2 = Math.abs(random.nextInt(string3.length()));
            char c3 = c2 = (char)(random.nextInt(95) + 33);
            if (c2 >= '0') {
                c3 = c2;
                if (c2 <= '9') {
                    c3 = (char)(c2 - 15);
                }
            }
            string3 = new StringBuilder(string3).insert(n2, c3).toString();
            ++n5;
        } while (true);
        while ((long)n2 < l2) {
            n5 = Math.abs(random.nextInt(string2.length() - 1) + 1);
            string2 = new StringBuilder(string2).insert(n5, " ").toString();
            ++n2;
        }
        return string2;
    }

    @Override
    public a.b a(com.mixpanel.android.a.e.a a2) {
        if (a2.b("Upgrade").equals("WebSocket") && a2.b("Connection").contains("Upgrade") && a2.b("Sec-WebSocket-Key1").length() > 0 && !a2.b("Sec-WebSocket-Key2").isEmpty() && a2.c("Origin")) {
            return a.b.a;
        }
        return a.b.b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public a.b a(com.mixpanel.android.a.e.a object, h arrby) {
        if (this.i) {
            return a.b.b;
        }
        try {
            if (!arrby.b("Sec-WebSocket-Origin").equals(object.b("Origin"))) return a.b.b;
            if (!this.a((f)arrby)) return a.b.b;
            if ((arrby = arrby.c()) == null) throw new com.mixpanel.android.a.c.a();
        }
        catch (com.mixpanel.android.a.c.d d2) {
            throw new RuntimeException("bad handshakerequest", d2);
        }
        if (arrby.length == 0) throw new com.mixpanel.android.a.c.a();
        if (!Arrays.equals(arrby, e.a(object.b("Sec-WebSocket-Key1"), object.b("Sec-WebSocket-Key2"), object.c()))) return a.b.b;
        return a.b.a;
    }

    @Override
    public b a(b b2) {
        Object object;
        b2.a("Upgrade", "WebSocket");
        b2.a("Connection", "Upgrade");
        b2.a("Sec-WebSocket-Key1", e.e());
        b2.a("Sec-WebSocket-Key2", e.e());
        if (!b2.c("Origin")) {
            object = new StringBuilder();
            ((StringBuilder)object).append("random");
            ((StringBuilder)object).append(this.k.nextInt());
            b2.a("Origin", ((StringBuilder)object).toString());
        }
        object = new byte[8];
        this.k.nextBytes((byte[])object);
        b2.a((byte[])object);
        return b2;
    }

    @Override
    public c a(com.mixpanel.android.a.e.a arrby, i i2) {
        i2.a("WebSocket Protocol Handshake");
        i2.a("Upgrade", "WebSocket");
        i2.a("Connection", arrby.b("Connection"));
        i2.a("Sec-WebSocket-Origin", arrby.b("Origin"));
        CharSequence charSequence = new StringBuilder();
        charSequence.append("ws://");
        charSequence.append(arrby.b("Host"));
        charSequence.append(arrby.a());
        i2.a("Sec-WebSocket-Location", charSequence.toString());
        charSequence = arrby.b("Sec-WebSocket-Key1");
        String string2 = arrby.b("Sec-WebSocket-Key2");
        arrby = arrby.c();
        if (charSequence != null && string2 != null && arrby != null && arrby.length == 8) {
            i2.a(e.a((String)charSequence, string2, arrby));
            return i2;
        }
        throw new com.mixpanel.android.a.c.d("Bad keys");
    }

    @Override
    public ByteBuffer a(com.mixpanel.android.a.d.d d2) {
        if (d2.f() == d.a.f) {
            return ByteBuffer.wrap(j);
        }
        return super.a(d2);
    }

    @Override
    public a.a b() {
        return a.a.b;
    }

    @Override
    public a c() {
        return new e();
    }

    @Override
    public List<com.mixpanel.android.a.d.d> c(ByteBuffer byteBuffer) {
        byteBuffer.mark();
        List list = super.e(byteBuffer);
        if (list == null) {
            byteBuffer.reset();
            list = this.g;
            this.f = true;
            if (this.h == null) {
                this.h = ByteBuffer.allocate(2);
                if (byteBuffer.remaining() <= this.h.remaining()) {
                    this.h.put(byteBuffer);
                    if (!this.h.hasRemaining()) {
                        if (Arrays.equals(this.h.array(), j)) {
                            list.add(new com.mixpanel.android.a.d.b(1000));
                            return list;
                        }
                        throw new com.mixpanel.android.a.c.c();
                    }
                    this.g = new LinkedList();
                    return list;
                }
                throw new com.mixpanel.android.a.c.c();
            }
            throw new com.mixpanel.android.a.c.c();
        }
        return list;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public f d(ByteBuffer byteBuffer) {
        c c2 = e.a(byteBuffer, this.d);
        if (!c2.c("Sec-WebSocket-Key1") && this.d != a.b.a || c2.c("Sec-WebSocket-Version")) return c2;
        int n2 = this.d == a.b.b ? 8 : 16;
        byte[] arrby = new byte[n2];
        try {
            byteBuffer.get(arrby);
        }
        catch (BufferUnderflowException bufferUnderflowException) {
            throw new com.mixpanel.android.a.c.a(byteBuffer.capacity() + 16);
        }
        c2.a(arrby);
        return c2;
    }
}

