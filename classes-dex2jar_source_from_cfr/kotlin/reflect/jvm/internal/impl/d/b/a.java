/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.d.b;

import java.util.ArrayList;
import java.util.List;
import kotlin.a.g;
import kotlin.a.m;
import kotlin.e.b.j;

public abstract class a {
    public static final a d = new a(null);
    private final int a;
    private final int b;
    private final int c;
    private final List<Integer> e;
    private final int[] f;

    public /* varargs */ a(int ... object) {
        j.b(object, "numbers");
        this.f = object;
        object = g.b(this.f, 0);
        int n2 = -1;
        int n3 = object != null ? (Integer)object : -1;
        this.a = n3;
        object = g.b(this.f, 1);
        n3 = object != null ? (Integer)object : -1;
        this.b = n3;
        object = g.b(this.f, 2);
        n3 = n2;
        if (object != null) {
            n3 = (Integer)object;
        }
        this.c = n3;
        object = this.f.length > 3 ? m.k((Iterable)g.a(this.f).subList(3, this.f.length)) : m.a();
        this.e = object;
    }

    protected final boolean a(a a2) {
        j.b(a2, "ourVersion");
        return this.a == 0 ? a2.a == 0 && this.b == a2.b : this.a == a2.a && this.b <= a2.b;
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public final int[] d() {
        return this.f;
    }

    public boolean equals(Object object) {
        if (object != null && j.a(this.getClass(), object.getClass())) {
            int n2 = this.a;
            object = (a)object;
            if (n2 == ((a)object).a && this.b == ((a)object).b && this.c == ((a)object).c && j.a(this.e, ((a)object).e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int n2 = this.a;
        n2 += n2 * 31 + this.b;
        n2 += n2 * 31 + this.c;
        return n2 + (n2 * 31 + ((Object)this.e).hashCode());
    }

    public String toString() {
        int n2;
        boolean bl2;
        Object object = this.d();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int n3 = ((int[])object).length;
        for (int i2 = 0; i2 < n3 && (bl2 = (n2 = object[i2]) != -1); ++i2) {
            arrayList.add(n2);
        }
        object = arrayList;
        if (object.isEmpty()) {
            return "unknown";
        }
        return m.a((Iterable)object, ".", null, null, 0, null, null, 62, null);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.e.b.g g2) {
            this();
        }
    }

}

