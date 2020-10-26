/*
 * Decompiled with CFR 0.139.
 */
package com.mixpanel.android.a.d;

import com.mixpanel.android.a.c.c;
import com.mixpanel.android.a.d.a;
import com.mixpanel.android.a.d.d;
import com.mixpanel.android.a.d.e;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class b
extends e
implements a {
    static final ByteBuffer a = ByteBuffer.allocate(0);
    private int f;
    private String g;

    public b() {
        super(d.a.f);
        this.a(true);
    }

    public b(int n2) {
        super(d.a.f);
        this.a(true);
        this.a(n2, "");
    }

    public b(int n2, String string2) {
        super(d.a.f);
        this.a(true);
        this.a(n2, string2);
    }

    private void a(int n2, String arrby) {
        Object object = arrby;
        if (arrby == null) {
            object = "";
        }
        int n3 = n2;
        if (n2 == 1015) {
            object = "";
            n3 = 1005;
        }
        if (n3 == 1005) {
            if (((String)object).length() <= 0) {
                return;
            }
            throw new com.mixpanel.android.a.c.b(1002, "A close frame must have a closecode if it has a reason");
        }
        arrby = com.mixpanel.android.a.f.b.a((String)object);
        object = ByteBuffer.allocate(4);
        ((ByteBuffer)object).putInt(n3);
        ((Buffer)object).position(2);
        ByteBuffer byteBuffer = ByteBuffer.allocate(arrby.length + 2);
        byteBuffer.put((ByteBuffer)object);
        byteBuffer.put(arrby);
        byteBuffer.rewind();
        this.a(byteBuffer);
    }

    private void g() {
        this.f = 1005;
        Object object = super.c();
        ((Buffer)object).mark();
        if (((Buffer)object).remaining() >= 2) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(4);
            byteBuffer.position(2);
            byteBuffer.putShort(((ByteBuffer)object).getShort());
            byteBuffer.position(0);
            this.f = byteBuffer.getInt();
            if (this.f == 1006 || this.f == 1015 || this.f == 1005 || this.f > 4999 || this.f < 1000 || this.f == 1004) {
                object = new StringBuilder();
                ((StringBuilder)object).append("closecode must not be sent over the wire: ");
                ((StringBuilder)object).append(this.f);
                throw new c(((StringBuilder)object).toString());
            }
        }
        ((Buffer)object).reset();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private void h() {
        Throwable throwable2222;
        if (this.f == 1005) {
            this.g = com.mixpanel.android.a.f.b.a(super.c());
            return;
        }
        ByteBuffer byteBuffer = super.c();
        int n2 = byteBuffer.position();
        byteBuffer.position(byteBuffer.position() + 2);
        this.g = com.mixpanel.android.a.f.b.a(byteBuffer);
        byteBuffer.position(n2);
        return;
        {
            catch (Throwable throwable2222) {
            }
            catch (IllegalArgumentException illegalArgumentException) {}
            {
                throw new c(illegalArgumentException);
            }
        }
        byteBuffer.position(n2);
        throw throwable2222;
    }

    @Override
    public int a() {
        return this.f;
    }

    @Override
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        this.g();
        this.h();
    }

    @Override
    public String b() {
        return this.g;
    }

    @Override
    public ByteBuffer c() {
        if (this.f == 1005) {
            return a;
        }
        return super.c();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("code: ");
        stringBuilder.append(this.f);
        return stringBuilder.toString();
    }
}

