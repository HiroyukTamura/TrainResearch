/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.b;

import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.am;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.ac;
import kotlin.reflect.jvm.internal.impl.a.c.o;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.c.a.b.b;
import kotlin.reflect.jvm.internal.impl.c.a.b.i;
import kotlin.reflect.jvm.internal.impl.c.a.b.j;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.k.c;

public class e
extends ac
implements b {
    public static final t.b<av> a;
    static final /* synthetic */ boolean b;
    private a d = null;

    static {
        b = e.class.desiredAssertionStatus() ^ true;
        a = new t.b<av>(){};
    }

    protected e(m m2, am am2, h h2, f f2, b.a a2, an an2) {
        super(m2, am2, h2, f2, a2, an2);
    }

    public static e a(m m2, h h2, f f2, an an2) {
        return new e(m2, null, h2, f2, b.a.a, an2);
    }

    @Override
    public boolean H() {
        if (!b && this.d == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Parameter names status was not set: ");
            stringBuilder.append(this);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        return this.d.e;
    }

    @Override
    public ac a(kotlin.reflect.jvm.internal.impl.j.w a2, al al2, List<? extends as> list, List<av> list2, kotlin.reflect.jvm.internal.impl.j.w w2, w w3, ba ba2, Map<? extends t.b<?>, ?> map) {
        a2 = super.a((kotlin.reflect.jvm.internal.impl.j.w)a2, al2, list, list2, w2, w3, ba2, map);
        this.a(kotlin.reflect.jvm.internal.impl.k.i.a.a((t)a2).a());
        return a2;
    }

    @Override
    protected /* synthetic */ o a(m m2, t t2, b.a a2, f f2, h h2, an an2) {
        return this.b(m2, t2, a2, f2, h2, an2);
    }

    public /* synthetic */ b a(kotlin.reflect.jvm.internal.impl.j.w w2, List list, kotlin.reflect.jvm.internal.impl.j.w w3) {
        return this.b(w2, list, w3);
    }

    public void a(boolean bl2, boolean bl3) {
        this.d = a.a(bl2, bl3);
    }

    protected e b(m m2, t t2, b.a a2, f f2, h h2, an an2) {
        t2 = (am)t2;
        if (f2 == null) {
            f2 = this.h_();
        }
        m2 = new e(m2, (am)t2, h2, f2, a2, an2);
        ((e)m2).a(this.H(), this.j());
        return m2;
    }

    public e b(kotlin.reflect.jvm.internal.impl.j.w object, List<j> list, kotlin.reflect.jvm.internal.impl.j.w w2) {
        list = i.a(list, this.i(), this);
        object = (e)this.E().a(list).a(w2).b((kotlin.reflect.jvm.internal.impl.j.w)object).c().b().f();
        if (!b) {
            if (object != null) {
                return object;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("null after substitution while enhancing ");
            ((StringBuilder)object).append(this.toString());
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        return object;
    }

    @Override
    public boolean j() {
        if (!b && this.d == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Parameter names status was not set: ");
            stringBuilder.append(this);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        return this.d.f;
    }

    private static enum a {
        a(false, false),
        b(true, false),
        c(false, true),
        d(true, true);
        
        public final boolean e;
        public final boolean f;

        private a(boolean bl2, boolean bl3) {
            this.e = bl2;
            this.f = bl3;
        }

        public static a a(boolean bl2, boolean bl3) {
            if (bl2) {
                if (bl3) {
                    return d;
                }
                return b;
            }
            if (bl3) {
                return c;
            }
            return a;
        }
    }

}

