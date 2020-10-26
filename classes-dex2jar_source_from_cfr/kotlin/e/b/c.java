/*
 * Decompiled with CFR 0.139.
 */
package kotlin.e.b;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.e.b;
import kotlin.reflect.e;
import kotlin.reflect.k;
import kotlin.reflect.p;

public abstract class c
implements Serializable,
kotlin.reflect.b {
    public static final Object b = a.a();
    protected final Object a;
    private transient kotlin.reflect.b c;

    public c() {
        this(b);
    }

    protected c(Object object) {
        this.a = object;
    }

    public Object a(Map map) {
        return this.e().a(map);
    }

    public /* varargs */ Object a(Object ... arrobject) {
        return this.e().a(arrobject);
    }

    protected abstract kotlin.reflect.b b();

    public Object c() {
        return this.a;
    }

    public kotlin.reflect.b d() {
        kotlin.reflect.b b2;
        kotlin.reflect.b b3 = b2 = this.c;
        if (b2 == null) {
            this.c = b3 = this.b();
        }
        return b3;
    }

    protected kotlin.reflect.b e() {
        kotlin.reflect.b b2 = this.d();
        if (b2 != this) {
            return b2;
        }
        throw new b();
    }

    public e f() {
        throw new AbstractMethodError();
    }

    @Override
    public String g() {
        throw new AbstractMethodError();
    }

    public String h() {
        throw new AbstractMethodError();
    }

    @Override
    public List<k> i() {
        return this.e().i();
    }

    @Override
    public p j() {
        return this.e().j();
    }

    @Override
    public List<Annotation> k() {
        return this.e().k();
    }

    private static class a
    implements Serializable {
        private static final a a = new a();

        private a() {
        }

        static /* synthetic */ a a() {
            return a;
        }
    }

}

