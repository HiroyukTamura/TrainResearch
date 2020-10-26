/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.c.a;

import java.util.Arrays;
import kotlin.e.b.j;

public final class g
extends kotlin.reflect.jvm.internal.impl.d.b.a {
    public static final g a;
    public static final g b;
    public static final a c;

    static {
        c = new a(null);
        a = new g(1, 1, 11);
        b = new g(new int[0]);
    }

    public /* varargs */ g(int ... arrn) {
        j.b(arrn, "numbers");
        super(Arrays.copyOf(arrn, arrn.length));
    }

    public boolean a() {
        return this.b() == 1 && this.c() == 1;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.e.b.g g2) {
            this();
        }
    }

}

