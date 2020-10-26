/*
 * Decompiled with CFR 0.139.
 */
package com.mixpanel.android.a.d;

import com.mixpanel.android.a.d.c;
import com.mixpanel.android.a.d.d;
import com.mixpanel.android.a.f.b;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class e
implements c {
    protected static byte[] b = new byte[0];
    private ByteBuffer a;
    protected boolean c;
    protected d.a d;
    protected boolean e;

    public e() {
    }

    public e(d.a a2) {
        this.d = a2;
        this.a = ByteBuffer.wrap(b);
    }

    public e(d d2) {
        this.c = d2.d();
        this.d = d2.f();
        this.a = d2.c();
        this.e = d2.e();
    }

    @Override
    public void a(d.a a2) {
        this.d = a2;
    }

    @Override
    public void a(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override
    public void a(boolean bl2) {
        this.c = bl2;
    }

    @Override
    public ByteBuffer c() {
        return this.a;
    }

    @Override
    public boolean d() {
        return this.c;
    }

    @Override
    public boolean e() {
        return this.e;
    }

    @Override
    public d.a f() {
        return this.d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Framedata{ optcode:");
        stringBuilder.append((Object)this.f());
        stringBuilder.append(", fin:");
        stringBuilder.append(this.d());
        stringBuilder.append(", payloadlength:[pos:");
        stringBuilder.append(this.a.position());
        stringBuilder.append(", len:");
        stringBuilder.append(this.a.remaining());
        stringBuilder.append("], payload:");
        stringBuilder.append(Arrays.toString(b.a(new String(this.a.array()))));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

