/*
 * Decompiled with CFR 0.139.
 */
package c.a.e;

import c.a.e.b;
import java.io.IOException;

public final class n
extends IOException {
    public final b a;

    public n(b b2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("stream was reset: ");
        stringBuilder.append((Object)b2);
        super(stringBuilder.toString());
        this.a = b2;
    }
}

