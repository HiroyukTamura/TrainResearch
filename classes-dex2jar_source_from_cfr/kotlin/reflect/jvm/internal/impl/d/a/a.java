/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.a;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ae;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.g.c;

public final class a
extends kotlin.reflect.jvm.internal.impl.d.b.a {
    public static final a a;
    public static final a b;
    public static final a c;

    static {
        c = new a(null);
        a = new a(1, 0, 4);
        b = new a(new int[0]);
    }

    public /* varargs */ a(int ... arrn) {
        j.b(arrn, "numbers");
        super(Arrays.copyOf(arrn, arrn.length));
    }

    public boolean a() {
        return this.a(a);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g g2) {
            this();
        }

        public final a a(InputStream arrn) {
            j.b(arrn, "stream");
            arrn = new DataInputStream((InputStream)arrn);
            Object object = new c(1, arrn.readInt());
            Collection collection = new ArrayList(m.a(object, 10));
            object = object.iterator();
            while (object.hasNext()) {
                ((ae)object).b();
                collection.add(arrn.readInt());
            }
            arrn = m.b((List)collection);
            return new a(Arrays.copyOf(arrn, arrn.length));
        }
    }

}

