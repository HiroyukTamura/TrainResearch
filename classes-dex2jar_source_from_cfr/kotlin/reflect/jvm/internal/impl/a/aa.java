/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ae;
import kotlin.a.al;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.az;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.ag;
import kotlin.reflect.jvm.internal.impl.a.c.g;
import kotlin.reflect.jvm.internal.impl.a.c.m;
import kotlin.reflect.jvm.internal.impl.a.e;
import kotlin.reflect.jvm.internal.impl.a.f;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.h.e.h;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;

public final class aa {
    private final kotlin.reflect.jvm.internal.impl.i.c<kotlin.reflect.jvm.internal.impl.e.b, ab> a;
    private final kotlin.reflect.jvm.internal.impl.i.c<a, e> b;
    private final i c;
    private final y d;

    public aa(i i2, y y2) {
        j.b(i2, "storageManager");
        j.b(y2, "module");
        this.c = i2;
        this.d = y2;
        this.a = this.c.a((kotlin.e.a.b)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.e.b, m>(){

            @Override
            public final m a(kotlin.reflect.jvm.internal.impl.e.b b2) {
                j.b(b2, "fqName");
                return new m(this.d, b2);
            }
        });
        this.b = this.c.a((kotlin.e.a.b)new kotlin.e.a.b<a, b>(){

            @Override
            public final b a(a object) {
                Object object2;
                block2 : {
                    Object object3;
                    Object object4;
                    block4 : {
                        block3 : {
                            j.b(object, "<name for destructuring parameter 0>");
                            object2 = ((a)object).a();
                            object3 = ((a)object).b();
                            if (((kotlin.reflect.jvm.internal.impl.e.a)object2).d()) break block2;
                            object = ((kotlin.reflect.jvm.internal.impl.e.a)object2).e();
                            if (object == null) break block3;
                            object4 = this;
                            j.a(object, "outerClassId");
                            object = ((aa)object4).a((kotlin.reflect.jvm.internal.impl.e.a)object, kotlin.a.m.b((Iterable)object3, 1));
                            if (object != null) break block4;
                        }
                        object = this.a;
                        object4 = ((kotlin.reflect.jvm.internal.impl.e.a)object2).a();
                        j.a(object4, "classId.packageFqName");
                        object = object.a(object4);
                    }
                    object4 = (kotlin.reflect.jvm.internal.impl.a.g)object;
                    boolean bl2 = ((kotlin.reflect.jvm.internal.impl.e.a)object2).f();
                    object = this.c;
                    object4 = (kotlin.reflect.jvm.internal.impl.a.m)object4;
                    object2 = ((kotlin.reflect.jvm.internal.impl.e.a)object2).c();
                    j.a(object2, "classId.shortClassName");
                    object3 = kotlin.a.m.g(object3);
                    int n2 = object3 != null ? (Integer)object3 : 0;
                    return new b((i)object, (kotlin.reflect.jvm.internal.impl.a.m)object4, (kotlin.reflect.jvm.internal.impl.e.f)object2, bl2, n2);
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Unresolved local class: ");
                ((StringBuilder)object).append(object2);
                throw (Throwable)new UnsupportedOperationException(((StringBuilder)object).toString());
            }
        });
    }

    public final e a(kotlin.reflect.jvm.internal.impl.e.a a2, List<Integer> list) {
        j.b(a2, "classId");
        j.b(list, "typeParametersCount");
        return (e)this.b.a(new a(a2, list));
    }

    private static final class a {
        private final kotlin.reflect.jvm.internal.impl.e.a a;
        private final List<Integer> b;

        public a(kotlin.reflect.jvm.internal.impl.e.a a2, List<Integer> list) {
            j.b(a2, "classId");
            j.b(list, "typeParametersCount");
            this.a = a2;
            this.b = list;
        }

        public final kotlin.reflect.jvm.internal.impl.e.a a() {
            return this.a;
        }

        public final List<Integer> b() {
            return this.b;
        }

        public boolean equals(Object object) {
            block2 : {
                block3 : {
                    if (this == object) break block2;
                    if (!(object instanceof a)) break block3;
                    object = (a)object;
                    if (j.a((Object)this.a, (Object)((a)object).a) && j.a(this.b, ((a)object).b)) break block2;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            List<Integer> list = this.a;
            int n2 = 0;
            int n3 = list != null ? ((Object)list).hashCode() : 0;
            list = this.b;
            if (list != null) {
                n2 = ((Object)list).hashCode();
            }
            return n3 * 31 + n2;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ClassRequest(classId=");
            stringBuilder.append(this.a);
            stringBuilder.append(", typeParametersCount=");
            stringBuilder.append(this.b);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    public static final class b
    extends g {
        private final List<as> c;
        private final kotlin.reflect.jvm.internal.impl.j.e d;
        private final boolean e;

        public b(i i2, kotlin.reflect.jvm.internal.impl.a.m object, kotlin.reflect.jvm.internal.impl.e.f iterator, boolean bl2, int n2) {
            j.b(i2, "storageManager");
            j.b(object, "container");
            j.b(iterator, "name");
            super(i2, (kotlin.reflect.jvm.internal.impl.a.m)object, (kotlin.reflect.jvm.internal.impl.e.f)((Object)iterator), an.a, false);
            this.e = bl2;
            iterator = kotlin.g.d.b(0, n2);
            object = new ArrayList(kotlin.a.m.a(iterator, 10));
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                n2 = ((ae)iterator).b();
                kotlin.reflect.jvm.internal.impl.a.m m2 = this;
                h h2 = h.a.a();
                kotlin.reflect.jvm.internal.impl.j.ba ba2 = kotlin.reflect.jvm.internal.impl.j.ba.a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append('T');
                stringBuilder.append(n2);
                object.add(ag.a(m2, h2, false, ba2, kotlin.reflect.jvm.internal.impl.e.f.a(stringBuilder.toString()), n2));
            }
            this.c = (List)object;
            this.d = new kotlin.reflect.jvm.internal.impl.j.e(this, this.c, (Collection<kotlin.reflect.jvm.internal.impl.j.w>)al.a(kotlin.reflect.jvm.internal.impl.h.c.a.c(this).a().getAnyType()), i2);
        }

        public kotlin.reflect.jvm.internal.impl.j.e a() {
            return this.d;
        }

        public h.c c() {
            return h.c.a;
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.j.an e() {
            return this.a();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.h.e.h f_() {
            return this.j();
        }

        @Override
        public /* synthetic */ kotlin.reflect.jvm.internal.impl.h.e.h g() {
            return this.c();
        }

        @Override
        public e i() {
            return null;
        }

        public h.c j() {
            return h.c.a;
        }

        @Override
        public Collection<kotlin.reflect.jvm.internal.impl.a.d> k() {
            return al.a();
        }

        @Override
        public f l() {
            return f.a;
        }

        @Override
        public w m() {
            return w.a;
        }

        @Override
        public kotlin.reflect.jvm.internal.impl.a.d o() {
            return null;
        }

        @Override
        public ba p() {
            return az.e;
        }

        @Override
        public boolean q() {
            return false;
        }

        @Override
        public boolean r() {
            return this.e;
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
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("class ");
            stringBuilder.append(this.h_());
            stringBuilder.append(" (not found)");
            return stringBuilder.toString();
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
        public List<as> z() {
            return this.c;
        }
    }

}

