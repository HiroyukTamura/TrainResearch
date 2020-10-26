/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.g;

import java.util.Set;
import kotlin.a.al;
import kotlin.reflect.jvm.internal.impl.a.ar;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.g.b;
import kotlin.reflect.jvm.internal.impl.g.m;
import kotlin.reflect.jvm.internal.impl.g.n;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.w;

public abstract class c {
    public static final c a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;
    public static final c h;
    public static final c i;
    public static final a j;

    static {
        j = new a(null);
        a = j.a(d.a);
        b = j.a(b.a);
        c = j.a(c.a);
        d = j.a(e.a);
        e = j.a(i.a);
        f = j.a(g.a);
        g = j.a(j.a);
        h = j.a(f.a);
        i = j.a(h.a);
    }

    public static /* synthetic */ String a(c c2, kotlin.reflect.jvm.internal.impl.a.a.c c3, kotlin.reflect.jvm.internal.impl.a.a.e e2, int n2, Object object) {
        if (object == null) {
            if ((n2 & 2) != 0) {
                e2 = null;
            }
            return c2.a(c3, e2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
    }

    public abstract String a(String var1, String var2, KotlinBuiltIns var3);

    public abstract String a(kotlin.reflect.jvm.internal.impl.a.a.c var1, kotlin.reflect.jvm.internal.impl.a.a.e var2);

    public abstract String a(kotlin.reflect.jvm.internal.impl.a.m var1);

    public abstract String a(kotlin.reflect.jvm.internal.impl.e.c var1);

    public abstract String a(kotlin.reflect.jvm.internal.impl.e.f var1, boolean var2);

    public abstract String a(ap var1);

    public abstract String a(kotlin.reflect.jvm.internal.impl.j.w var1);

    public final c a(kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.g.h, w> b2) {
        kotlin.e.b.j.b(b2, "changeOptions");
        kotlin.reflect.jvm.internal.impl.g.i i2 = ((kotlin.reflect.jvm.internal.impl.g.e)this).a().d();
        b2.a(i2);
        i2.b();
        return new kotlin.reflect.jvm.internal.impl.g.e(i2);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.e.b.g g2) {
            this();
        }

        public final String a(kotlin.reflect.jvm.internal.impl.a.i object) {
            kotlin.e.b.j.b(object, "classifier");
            if (object instanceof ar) {
                return "typealias";
            }
            if (object instanceof kotlin.reflect.jvm.internal.impl.a.e) {
                if ((object = (kotlin.reflect.jvm.internal.impl.a.e)object).q()) {
                    return "companion object";
                }
                object = object.l();
                switch (kotlin.reflect.jvm.internal.impl.g.d.a[((Enum)object).ordinal()]) {
                    default: {
                        throw new kotlin.m();
                    }
                    case 6: {
                        return "enum entry";
                    }
                    case 5: {
                        return "annotation class";
                    }
                    case 4: {
                        return "object";
                    }
                    case 3: {
                        return "enum class";
                    }
                    case 2: {
                        return "interface";
                    }
                    case 1: 
                }
                return "class";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected classifier: ");
            stringBuilder.append(object);
            throw (Throwable)((Object)new AssertionError((Object)stringBuilder.toString()));
        }

        public final c a(kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.g.h, w> b2) {
            kotlin.e.b.j.b(b2, "changeOptions");
            kotlin.reflect.jvm.internal.impl.g.i i2 = new kotlin.reflect.jvm.internal.impl.g.i();
            b2.a(i2);
            i2.b();
            return new kotlin.reflect.jvm.internal.impl.g.e(i2);
        }
    }

    public static interface k {
        public void a(int var1, StringBuilder var2);

        public void a(av var1, int var2, int var3, StringBuilder var4);

        public void b(int var1, StringBuilder var2);

        public void b(av var1, int var2, int var3, StringBuilder var4);

        public static final class a
        implements k {
            public static final a a = new a();

            private a() {
            }

            @Override
            public void a(int n2, StringBuilder stringBuilder) {
                kotlin.e.b.j.b(stringBuilder, "builder");
                stringBuilder.append("(");
            }

            @Override
            public void a(av av2, int n2, int n3, StringBuilder stringBuilder) {
                kotlin.e.b.j.b(av2, "parameter");
                kotlin.e.b.j.b(stringBuilder, "builder");
            }

            @Override
            public void b(int n2, StringBuilder stringBuilder) {
                kotlin.e.b.j.b(stringBuilder, "builder");
                stringBuilder.append(")");
            }

            @Override
            public void b(av av2, int n2, int n3, StringBuilder stringBuilder) {
                kotlin.e.b.j.b(av2, "parameter");
                kotlin.e.b.j.b(stringBuilder, "builder");
                if (n2 != n3 - 1) {
                    stringBuilder.append(", ");
                }
            }
        }

    }

}

