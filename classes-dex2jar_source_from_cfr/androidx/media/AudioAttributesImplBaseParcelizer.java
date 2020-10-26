/*
 * Decompiled with CFR 0.139.
 */
package androidx.media;

import androidx.media.c;
import androidx.versionedparcelable.a;

public final class AudioAttributesImplBaseParcelizer {
    public static c read(a a2) {
        c c2 = new c();
        c2.a = a2.b(c2.a, 1);
        c2.b = a2.b(c2.b, 2);
        c2.c = a2.b(c2.c, 3);
        c2.d = a2.b(c2.d, 4);
        return c2;
    }

    public static void write(c c2, a a2) {
        a2.a(false, false);
        a2.a(c2.a, 1);
        a2.a(c2.b, 2);
        a2.a(c2.c, 3);
        a2.a(c2.d, 4);
    }
}

