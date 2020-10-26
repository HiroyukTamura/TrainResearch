/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.c.a;

import java.util.Arrays;
import kotlin.e.b.g;
import kotlin.e.b.j;

public final class d
extends kotlin.reflect.jvm.internal.impl.d.b.a {
    public static final d a;
    public static final d b;
    public static final a c;

    static {
        c = new a(null);
        a = new d(1, 0, 2);
        b = new d(new int[0]);
    }

    public /* varargs */ d(int ... arrn) {
        j.b(arrn, "numbers");
        super(Arrays.copyOf(arrn, arrn.length));
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }
    }

}

