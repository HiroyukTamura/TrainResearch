/*
 * Decompiled with CFR 0.139.
 */
package com.mixpanel.android.a.b;

import com.mixpanel.android.a.a;
import com.mixpanel.android.a.d.d;
import com.mixpanel.android.a.e.c;
import com.mixpanel.android.a.e.d;
import com.mixpanel.android.a.e.e;
import com.mixpanel.android.a.e.f;
import com.mixpanel.android.a.e.h;
import com.mixpanel.android.a.e.i;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public abstract class a {
    public static int a = 1000;
    public static int b = 64;
    public static final byte[] c = com.mixpanel.android.a.f.b.a("<policy-file-request/>\u0000");
    protected a.b d = null;
    protected d.a e = null;

    public static c a(ByteBuffer byteBuffer, a.b object) {
        Object object2 = a.b(byteBuffer);
        if (object2 != null) {
            if (((String[])(object2 = ((String)object2).split(" ", 3))).length == 3) {
                if (object == a.b.a) {
                    object = new e();
                    i i2 = (i)object;
                    i2.a(Short.parseShort(object2[1]));
                    i2.a((String)object2[2]);
                } else {
                    object = new d();
                    object.a(object2[1]);
                }
                while ((object2 = a.b(byteBuffer)) != null && ((String)object2).length() > 0) {
                    if (((Object)(object2 = ((String)object2).split(":", 2))).length == 2) {
                        object.a((String)object2[0], ((String)object2[1]).replaceFirst("^ +", ""));
                        continue;
                    }
                    throw new com.mixpanel.android.a.c.d("not an http header");
                }
                if (object2 != null) {
                    return object;
                }
                throw new com.mixpanel.android.a.c.a();
            }
            throw new com.mixpanel.android.a.c.d();
        }
        throw new com.mixpanel.android.a.c.a(byteBuffer.capacity() + 128);
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(byteBuffer.remaining());
        int n2 = 48;
        while (byteBuffer.hasRemaining()) {
            byte by2 = byteBuffer.get();
            byteBuffer2.put(by2);
            if (n2 == 13 && by2 == 10) {
                byteBuffer2.limit(byteBuffer2.position() - 2);
                byteBuffer2.position(0);
                return byteBuffer2;
            }
            n2 = by2;
        }
        byteBuffer.position(byteBuffer.position() - byteBuffer2.position());
        return null;
    }

    public static String b(ByteBuffer byteBuffer) {
        if ((byteBuffer = a.a(byteBuffer)) == null) {
            return null;
        }
        return com.mixpanel.android.a.f.b.a(byteBuffer.array(), 0, byteBuffer.limit());
    }

    public int a(int n2) {
        if (n2 >= 0) {
            return n2;
        }
        throw new com.mixpanel.android.a.c.b(1002, "Negative count");
    }

    public abstract b a(com.mixpanel.android.a.e.a var1);

    public abstract b a(com.mixpanel.android.a.e.a var1, h var2);

    public abstract com.mixpanel.android.a.e.b a(com.mixpanel.android.a.e.b var1);

    public abstract c a(com.mixpanel.android.a.e.a var1, i var2);

    public abstract ByteBuffer a(com.mixpanel.android.a.d.d var1);

    public List<com.mixpanel.android.a.d.d> a(d.a a2, ByteBuffer byteBuffer, boolean bl2) {
        if (a2 != d.a.c && a2 != d.a.b && a2 != d.a.b) {
            throw new IllegalArgumentException("Only Opcode.BINARY or  Opcode.TEXT are allowed");
        }
        this.e = this.e != null ? d.a.a : a2;
        com.mixpanel.android.a.d.e e2 = new com.mixpanel.android.a.d.e(this.e);
        try {
            e2.a(byteBuffer);
            e2.a(bl2);
            if (bl2) {
                a2 = null;
            }
            this.e = a2;
        }
        catch (com.mixpanel.android.a.c.b b2) {
            throw new RuntimeException(b2);
        }
        return Collections.singletonList(e2);
    }

    public List<ByteBuffer> a(f f2, a.b b2) {
        return this.a(f2, b2, true);
    }

    /*
     * Enabled aggressive block sorting
     */
    public List<ByteBuffer> a(f object, a.b object2, boolean bl2) {
        void var1_4;
        void var3_6;
        byte[] arrby;
        Object object3 = new StringBuilder(100);
        if (object instanceof com.mixpanel.android.a.e.a) {
            ((StringBuilder)object3).append("GET ");
            ((StringBuilder)object3).append(((com.mixpanel.android.a.e.a)object).a());
            arrby = " HTTP/1.1";
        } else {
            if (!(object instanceof h)) {
                throw new RuntimeException("unknow role");
            }
            arrby = new StringBuilder();
            arrby.append("HTTP/1.1 101 ");
            arrby.append(((h)object).a());
            arrby = arrby.toString();
        }
        ((StringBuilder)object3).append((String)arrby);
        ((StringBuilder)object3).append("\r\n");
        arrby = object.b();
        while (arrby.hasNext()) {
            String string2 = (String)arrby.next();
            String string3 = object.b(string2);
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(": ");
            ((StringBuilder)object3).append(string3);
            ((StringBuilder)object3).append("\r\n");
        }
        ((StringBuilder)object3).append("\r\n");
        arrby = com.mixpanel.android.a.f.b.b(((StringBuilder)object3).toString());
        if (var3_6 != false) {
            byte[] arrby2 = object.c();
        } else {
            Object var1_3 = null;
        }
        int n2 = var1_4 == null ? 0 : ((void)var1_4).length;
        object3 = ByteBuffer.allocate(n2 + arrby.length);
        ((ByteBuffer)object3).put(arrby);
        if (var1_4 != null) {
            ((ByteBuffer)object3).put((byte[])var1_4);
        }
        ((Buffer)object3).flip();
        return Collections.singletonList(object3);
    }

    public abstract void a();

    public void a(a.b b2) {
        this.d = b2;
    }

    protected boolean a(f f2) {
        return f2.b("Upgrade").equalsIgnoreCase("websocket") && f2.b("Connection").toLowerCase(Locale.ENGLISH).contains("upgrade");
    }

    public abstract a b();

    public abstract a c();

    public abstract List<com.mixpanel.android.a.d.d> c(ByteBuffer var1);

    public f d(ByteBuffer byteBuffer) {
        return a.a(byteBuffer, this.d);
    }

    public static enum a {
        a,
        b,
        c;
        
    }

    public static enum b {
        a,
        b;
        
    }

}

