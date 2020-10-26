/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.m;
import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.i.n;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ae;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.aq;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.c.ag;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.a.c;
import kotlin.reflect.jvm.internal.impl.builtins.a.d;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.e.h;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.ar;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.x;
import kotlin.w;

public final class b
extends kotlin.reflect.jvm.internal.impl.a.c.a {
    private final a c;
    private final d d;
    private final List<as> e;
    private final i f;
    private final ab g;
    private final b h;
    private final int i;

    public b(i object, ab object2, b object3, int n2) {
        j.b(object, "storageManager");
        j.b(object2, "containingDeclaration");
        j.b(object3, "functionKind");
        super((i)object, ((b)((Object)object3)).a(n2));
        this.f = object;
        this.g = object2;
        this.h = object3;
        this.i = n2;
        this.c = new a();
        this.d = new d(this.f, this);
        object = new ArrayList();
        object2 = new kotlin.e.a.m<ba, String, w>((ArrayList)object){
            final /* synthetic */ ArrayList b;
            {
                this.b = arrayList;
                super(2);
            }

            @Override
            public final void a(ba ba2, String string2) {
                j.b((Object)ba2, "variance");
                j.b(string2, "name");
                this.b.add(ag.a(this, h.a.a(), false, ba2, f.a(string2), this.b.size()));
            }
        };
        Object object4 = new kotlin.g.c(1, this.i);
        object3 = new ArrayList(m.a(object4, 10));
        object4 = object4.iterator();
        while (object4.hasNext()) {
            n2 = ((kotlin.a.ae)object4).b();
            ba ba2 = ba.b;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('P');
            stringBuilder.append(n2);
            object2.a(ba2, stringBuilder.toString());
            object3.add(w.a);
        }
        object3 = (List)object3;
        object2.a(ba.c, "R");
        this.e = m.k((Iterable)object);
    }

    public static final /* synthetic */ ab a(b b2) {
        return b2.g;
    }

    public final b A() {
        return this.h;
    }

    public final int B() {
        return this.i;
    }

    public ab a() {
        return this.g;
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.m b() {
        return this.a();
    }

    public h.c c() {
        return h.c.a;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.j.an e() {
        return this.c;
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.h.e.h f_() {
        return this.c();
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.h.e.h g() {
        return this.g_();
    }

    public d g_() {
        return this.d;
    }

    public Void h() {
        return null;
    }

    @Override
    public /* synthetic */ e i() {
        return (e)((Object)this.h());
    }

    public List<kotlin.reflect.jvm.internal.impl.a.d> j() {
        return m.a();
    }

    public /* synthetic */ Collection k() {
        return this.j();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.f l() {
        return kotlin.reflect.jvm.internal.impl.a.f.b;
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.w m() {
        return kotlin.reflect.jvm.internal.impl.a.w.d;
    }

    public Void n() {
        return null;
    }

    @Override
    public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.d o() {
        return (kotlin.reflect.jvm.internal.impl.a.d)((Object)this.n());
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.a.ba p() {
        return az.e;
    }

    @Override
    public boolean q() {
        return false;
    }

    @Override
    public boolean r() {
        return false;
    }

    @Override
    public boolean s() {
        return false;
    }

    @Override
    public boolean t() {
        return false;
    }

    public String toString() {
        return this.h_().a();
    }

    @Override
    public boolean u() {
        return false;
    }

    @Override
    public boolean v() {
        return false;
    }

    @Override
    public boolean w() {
        return false;
    }

    @Override
    public h x() {
        return h.a.a();
    }

    @Override
    public an y() {
        an an2 = an.a;
        j.a((Object)an2, "SourceElement.NO_SOURCE");
        return an2;
    }

    @Override
    public List<as> z() {
        return this.e;
    }

    private final class kotlin.reflect.jvm.internal.impl.builtins.a.b$a
    extends kotlin.reflect.jvm.internal.impl.j.b {
        public kotlin.reflect.jvm.internal.impl.builtins.a.b$a() {
            super(b.this.f);
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        @Override
        protected Collection<kotlin.reflect.jvm.internal.impl.j.w> a() {
            var4_1 = new ArrayList<E>(2);
            var5_2 = new kotlin.e.a.m<ab, f, w>(){

                @Override
                public final void a(ab object, f iterator) {
                    j.b(object, "packageFragment");
                    j.b(iterator, "name");
                    kotlin.reflect.jvm.internal.impl.a.h h2 = object.a().c((f)((Object)iterator), kotlin.reflect.jvm.internal.impl.b.a.d.d);
                    Object object2 = h2;
                    if (!(h2 instanceof e)) {
                        object2 = null;
                    }
                    if ((object2 = (e)object2) != null) {
                        object = object2.e();
                        iterator = this.b();
                        j.a(object, "typeConstructor");
                        iterator = m.e(iterator, object.b().size());
                        object = new ArrayList(m.a(iterator, 10));
                        iterator = iterator.iterator();
                        while (iterator.hasNext()) {
                            object.add(new ar(((as)iterator.next()).i_()));
                        }
                        object = (List)object;
                        var4_1.add(x.a(h.a.a(), (e)object2, (List<? extends ap>)object));
                        return;
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Class ");
                    ((StringBuilder)object2).append(iterator);
                    ((StringBuilder)object2).append(" not found in ");
                    ((StringBuilder)object2).append(object);
                    throw (Throwable)new IllegalStateException(((StringBuilder)object2).toString().toString());
                }
            };
            var1_3 = b.this.A();
            switch (c.a[var1_3.ordinal()]) {
                default: {
                    var1_3 = b.a(b.this);
                    var2_4 = f.a(b.this.A().b());
                    var3_5 = "Name.identifier(functionKind.classNamePrefix)";
                    break;
                }
                case 2: {
                    var1_3 = b.a(b.this);
                    var2_4 = f.a("KFunction");
                    var3_5 = "Name.identifier(\"KFunction\")";
                    break;
                }
                case 1: {
                    var1_3 = b.a(b.this);
                    var2_4 = f.a("Function");
                    var3_5 = "Name.identifier(\"Function\")";
                }
            }
            j.a(var2_4, (String)var3_5);
            var5_2.a((ab)var1_3, (f)var2_4);
            ** break;
lbl22: // 1 sources:
            var1_3 = b.this.A();
            switch (c.b[var1_3.ordinal()]) {
                default: {
                    var1_3 = null;
                    ** break;
                }
                case 2: {
                    var1_3 = b.b;
                    ** break;
                }
                case 1: 
            }
            var1_3 = b.a;
lbl32: // 3 sources:
            if (var1_3 == null) return m.k((Iterable)var4_1);
            var2_4 = b.a(b.this).e();
            var3_5 = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME;
            j.a((Object)var3_5, "BUILT_INS_PACKAGE_FQ_NAME");
            var3_5 = var2_4.a((kotlin.reflect.jvm.internal.impl.e.b)var3_5).f();
            var2_4 = new ArrayList<E>();
            var3_5 = var3_5.iterator();
            do {
                if (!var3_5.hasNext()) {
                    var2_4 = (BuiltInsPackageFragment)m.f((List)var2_4);
                    var1_3 = var1_3.a(b.this.B());
                    j.a(var1_3, "numberedSupertypeKind.numberedClassName(arity)");
                    var5_2.a((ab)var2_4, (f)var1_3);
                    return m.k((Iterable)var4_1);
                }
                var6_6 = var3_5.next();
                if (!(var6_6 instanceof BuiltInsPackageFragment)) continue;
                var2_4.add(var6_6);
            } while (true);
        }

        @Override
        public List<as> b() {
            return b.this.e;
        }

        public b c() {
            return b.this;
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.a.h d() {
            return this.c();
        }

        @Override
        public boolean f() {
            return true;
        }

        @Override
        protected aq g() {
            return aq.a.a;
        }

        @Override
        public /* synthetic */ e j_() {
            return this.c();
        }

        public String toString() {
            return this.c().toString();
        }

    }

    public static final class b
    extends Enum<b> {
        public static final /* enum */ b a;
        public static final /* enum */ b b;
        public static final /* enum */ b c;
        public static final /* enum */ b d;
        public static final a e;
        private static final /* synthetic */ b[] f;
        private final kotlin.reflect.jvm.internal.impl.e.b g;
        private final String h;

        static {
            b b2;
            b b3;
            Object object = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME;
            j.a(object, "BUILT_INS_PACKAGE_FQ_NAME");
            object = new b((kotlin.reflect.jvm.internal.impl.e.b)object, "Function");
            a = object;
            Object object2 = KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME;
            j.a(object2, "BUILT_INS_PACKAGE_FQ_NAME");
            object2 = new b((kotlin.reflect.jvm.internal.impl.e.b)object2, "SuspendFunction");
            b = object2;
            c = b3 = new b(ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), "KFunction");
            d = b2 = new b(ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), "KSuspendFunction");
            f = new b[]{object, object2, b3, b2};
            e = new a(null);
        }

        protected b(kotlin.reflect.jvm.internal.impl.e.b b2, String string3) {
            j.b(b2, "packageFqName");
            j.b(string3, "classNamePrefix");
            this.g = b2;
            this.h = string3;
        }

        public static b valueOf(String string2) {
            return Enum.valueOf(b.class, string2);
        }

        public static b[] values() {
            return (b[])f.clone();
        }

        public final kotlin.reflect.jvm.internal.impl.e.b a() {
            return this.g;
        }

        public final f a(int n2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.h);
            stringBuilder.append(n2);
            return f.a(stringBuilder.toString());
        }

        public final String b() {
            return this.h;
        }

        public static final class a {
            private a() {
            }

            public /* synthetic */ a(g g2) {
                this();
            }

            public final b a(kotlin.reflect.jvm.internal.impl.e.b b2, String string2) {
                j.b(b2, "packageFqName");
                j.b(string2, "className");
                for (b b3 : b.values()) {
                    boolean bl2 = j.a((Object)b3.a(), (Object)b2) && n.a(string2, b3.b(), false, 2, null);
                    if (!bl2) continue;
                    return b3;
                }
                return null;
            }
        }

    }

}

