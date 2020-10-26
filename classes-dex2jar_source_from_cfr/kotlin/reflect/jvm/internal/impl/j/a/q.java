/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.a;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.j.a.p;
import kotlin.reflect.jvm.internal.impl.j.a.r;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.am;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.t;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.y;

public class q {
    static final /* synthetic */ boolean a;
    private final r b;

    static {
        a = q.class.desiredAssertionStatus() ^ true;
    }

    public q(r r2) {
        this.b = r2;
    }

    public static a a(as object, ap object2) {
        object = object.k();
        object2 = object2.b();
        Object object3 = object;
        Object object4 = object2;
        if (object2 == ba.a) {
            object4 = object;
            object3 = object2;
        }
        if (object3 == ba.b && object4 == ba.c) {
            return a.d;
        }
        if (object3 == ba.c && object4 == ba.b) {
            return a.d;
        }
        return a.a((ba)((Object)object4));
    }

    public static w a(w w2, w w3) {
        return q.a(w2, w3, new p());
    }

    public static w a(w w2, w w3, r r2) {
        return kotlin.reflect.jvm.internal.impl.j.a.t.a(w2, w3, r2);
    }

    private boolean a(ap ap2, ap ap3, as as2) {
        if (as2.k() != ba.a) {
            return false;
        }
        if (ap2.b() != ba.a && ap3.b() == ba.a) {
            return this.b.a(ap3.c(), ap2);
        }
        return false;
    }

    private static w b(as as2, ap ap2) {
        boolean bl2 = ap2.b() == ba.b || as2.k() == ba.b;
        if (bl2) {
            return kotlin.reflect.jvm.internal.impl.h.c.a.d(as2).getNullableAnyType();
        }
        return ap2.c();
    }

    private static w c(as as2, ap ap2) {
        boolean bl2 = ap2.b() == ba.c || as2.k() == ba.c;
        if (bl2) {
            return kotlin.reflect.jvm.internal.impl.h.c.a.d(as2).getNothingType();
        }
        return ap2.c();
    }

    private boolean e(w w2, w w3) {
        if (!y.a(w2)) {
            if (y.a(w3)) {
                return true;
            }
            if (!w3.c() && w2.c()) {
                return false;
            }
            if (KotlinBuiltIns.isNothingOrNullableNothing(w2)) {
                return true;
            }
            w w4 = q.a(w2, w3, this.b);
            if (w4 == null) {
                return this.b.a(w2, w3);
            }
            if (!w3.c() && w4.c()) {
                return false;
            }
            return this.f(w4, w3);
        }
        return true;
    }

    private boolean f(w object, w object2) {
        Object object3 = ((w)object).g();
        object = ((w)object).a();
        object2 = ((w)object2).a();
        if (object.size() != object2.size()) {
            return false;
        }
        object3 = object3.b();
        int n2 = 0;
        do {
            int n3 = object3.size();
            int n4 = 1;
            if (n2 >= n3) break;
            kotlin.reflect.jvm.internal.impl.a.a.a a2 = (as)object3.get(n2);
            ap ap2 = (ap)object2.get(n2);
            ap ap3 = (ap)object.get(n2);
            if (!ap2.a() && !this.a(ap3, ap2, (as)a2)) {
                n3 = n4;
                if (!y.a(ap3.c())) {
                    n3 = y.a(ap2.c()) ? n4 : 0;
                }
                if (n3 == 0 && a2.k() == ba.a && ap3.b() == ba.a && ap2.b() == ba.a) {
                    if (!this.b.a(ap3.c(), ap2.c(), this)) {
                        return false;
                    }
                } else {
                    w w2 = q.b(a2, ap2);
                    w w3 = q.b(a2, ap3);
                    if (!this.b.b(w3, w2, this)) {
                        return false;
                    }
                    w2 = q.c(a2, ap2);
                    a2 = q.c(a2, ap3);
                    if (ap2.b() != ba.c) {
                        if (!this.b.b(w2, (w)a2, this)) {
                            return false;
                        }
                    } else if (!a && !KotlinBuiltIns.isNothing(w2)) {
                        throw new AssertionError((Object)"In component must be Nothing for out-projection");
                    }
                }
            }
            ++n2;
        } while (true);
        return true;
    }

    public boolean b(w object, w object2) {
        an an2;
        if (object == object2) {
            return true;
        }
        if (t.a((w)object)) {
            if (t.a((w)object2)) {
                return !y.a((w)object) && !y.a((w)object2) && this.d((w)object, (w)object2) && this.d((w)object2, (w)object);
            }
            return this.c((w)object2, (w)object);
        }
        if (t.a((w)object2)) {
            return this.c((w)object, (w)object2);
        }
        if (((w)object).c() != ((w)object2).c()) {
            return false;
        }
        if (((w)object).c()) {
            return this.b.a(av.d((w)object), av.d((w)object2), this);
        }
        an an3 = ((w)object).g();
        if (!this.b.a(an3, an2 = ((w)object2).g())) {
            return false;
        }
        object = ((w)object).a();
        object2 = ((w)object2).a();
        if (object.size() != object2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < object.size(); ++i2) {
            ap ap2 = (ap)object.get(i2);
            ap ap3 = (ap)object2.get(i2);
            if (ap2.a() && ap3.a()) continue;
            as as2 = an3.b().get(i2);
            as as3 = an2.b().get(i2);
            if (this.a(ap2, ap3, as2)) continue;
            if (q.a(as2, ap2) != q.a(as3, ap3)) {
                return false;
            }
            if (this.b.a(ap2.c(), ap3.c(), this)) continue;
            return false;
        }
        return true;
    }

    protected boolean c(w w2, w object) {
        if (!a && t.a(w2)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Only inflexible types are allowed here: ");
            ((StringBuilder)object).append(w2);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        return this.d(t.b((w)object).f(), w2) && this.d(w2, t.b((w)object).h());
    }

    public boolean d(w w2, w w3) {
        if (am.a(w2, w3)) {
            return !w2.c() || w3.c();
            {
            }
        }
        w w4 = am.c(w2);
        w w5 = am.d(w3);
        if (w4 == w2 && w5 == w3) {
            return this.e(w2, w3);
        }
        return this.d(w4, w5);
    }

    public static enum a {
        a,
        b,
        c,
        d;
        

        public static a a(ba ba2) {
            switch (1.a[ba2.ordinal()]) {
                default: {
                    throw new IllegalStateException("Unknown variance");
                }
                case 3: {
                    return b;
                }
                case 2: {
                    return a;
                }
                case 1: 
            }
            return c;
        }
    }

}

