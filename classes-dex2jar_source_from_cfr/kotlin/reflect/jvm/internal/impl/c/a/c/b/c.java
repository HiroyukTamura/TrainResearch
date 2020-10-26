/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ab;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.aa;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.c.a.a.l;
import kotlin.reflect.jvm.internal.impl.c.a.c.b.d;
import kotlin.reflect.jvm.internal.impl.c.a.c.b.g;
import kotlin.reflect.jvm.internal.impl.c.a.c.e;
import kotlin.reflect.jvm.internal.impl.c.a.c.h;
import kotlin.reflect.jvm.internal.impl.c.a.c.j;
import kotlin.reflect.jvm.internal.impl.c.a.c.m;
import kotlin.reflect.jvm.internal.impl.c.a.e.f;
import kotlin.reflect.jvm.internal.impl.c.a.e.i;
import kotlin.reflect.jvm.internal.impl.c.a.e.u;
import kotlin.reflect.jvm.internal.impl.c.a.e.v;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.ar;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;
import kotlin.reflect.jvm.internal.impl.j.z;
import kotlin.y;

public final class c {
    private final h a;
    private final m b;

    public c(h h2, m m2) {
        kotlin.e.b.j.b(h2, "c");
        kotlin.e.b.j.b(m2, "typeParameterResolver");
        this.a = h2;
        this.b = m2;
    }

    private final List<ap> a(kotlin.reflect.jvm.internal.impl.c.a.e.j object, final kotlin.reflect.jvm.internal.impl.c.a.c.b.a iterator, an object2) {
        boolean bl2 = object.e();
        boolean bl3 = bl2 || object.d().isEmpty() && !object2.b().isEmpty();
        Collection<as> collection = object2.b();
        if (bl3) {
            kotlin.e.b.j.a(collection, "typeParameters");
            object = collection;
            collection = new ArrayList(kotlin.a.m.a(object, 10));
            Iterator iterator2 = object.iterator();
            while (iterator2.hasNext()) {
                final as as2 = (as)iterator2.next();
                z z2 = new z(this.a.c(), (kotlin.e.a.a<? extends w>)new kotlin.e.a.a<w>((an)object2, bl2){
                    final /* synthetic */ an d;
                    final /* synthetic */ boolean e;
                    {
                        this.d = an2;
                        this.e = bl2;
                        super(0);
                    }

                    @Override
                    public /* synthetic */ Object a() {
                        return this.b();
                    }

                    public final w b() {
                        as as22 = as2;
                        kotlin.e.b.j.a((Object)as22, "parameter");
                        return d.a(as22, iterator.d(), (kotlin.e.a.a<? extends w>)new kotlin.e.a.a<w>(){

                            @Override
                            public /* synthetic */ Object a() {
                                return this.b();
                            }

                            public final w b() {
                                kotlin.reflect.jvm.internal.impl.a.a.a a2 = this.d.d();
                                if (a2 == null) {
                                    kotlin.e.b.j.a();
                                }
                                kotlin.e.b.j.a((Object)a2, "constructor.declarationDescriptor!!");
                                a2 = a2.i_();
                                kotlin.e.b.j.a((Object)a2, "constructor.declarationDescriptor!!.defaultType");
                                return kotlin.reflect.jvm.internal.impl.j.c.a.g((w)a2);
                            }
                        });
                    }

                });
                kotlin.reflect.jvm.internal.impl.c.a.c.b.e e2 = kotlin.reflect.jvm.internal.impl.c.a.c.b.e.a;
                kotlin.e.b.j.a((Object)as2, "parameter");
                object = bl2 ? iterator : ((kotlin.reflect.jvm.internal.impl.c.a.c.b.a)((Object)iterator)).a(kotlin.reflect.jvm.internal.impl.c.a.c.b.b.a);
                collection.add((as)((Object)e2.a(as2, (kotlin.reflect.jvm.internal.impl.c.a.c.b.a)object, z2)));
            }
            return kotlin.a.m.k((Iterable)collection);
        }
        if (collection.size() != object.d().size()) {
            kotlin.e.b.j.a(collection, "typeParameters");
            iterator = collection;
            object = new ArrayList(kotlin.a.m.a(iterator, 10));
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                object2 = (as)iterator.next();
                kotlin.e.b.j.a(object2, "p");
                object.add(new ar(p.c(object2.h_().a())));
            }
            return kotlin.a.m.k((List)object);
        }
        iterator = kotlin.a.m.n((Iterable)object.d());
        object = new ArrayList(kotlin.a.m.a(iterator, 10));
        iterator = iterator.iterator();
        while (iterator.hasNext()) {
            object2 = (ab)iterator.next();
            int n2 = ((ab)object2).c();
            object2 = (v)((ab)object2).d();
            bl3 = n2 < collection.size();
            if (y.a && !bl3) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Argument index should be less then type parameters count, but ");
                ((StringBuilder)object).append(n2);
                ((StringBuilder)object).append(" > ");
                ((StringBuilder)object).append(collection.size());
                throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
            }
            as as3 = (as)collection.get(n2);
            kotlin.reflect.jvm.internal.impl.c.a.c.b.a a2 = d.a(l.b, false, null, 3, null);
            kotlin.e.b.j.a((Object)as3, "parameter");
            object.add(this.a((v)object2, a2, as3));
        }
        return kotlin.a.m.k((List)object);
    }

    private final kotlin.reflect.jvm.internal.impl.a.e a(kotlin.reflect.jvm.internal.impl.c.a.e.j j2, kotlin.reflect.jvm.internal.impl.c.a.c.b.a a2, kotlin.reflect.jvm.internal.impl.e.b object) {
        if (a2.c() && kotlin.e.b.j.a(object, (Object)d.a())) {
            return this.a.e().o().getKClass();
        }
        kotlin.reflect.jvm.internal.impl.builtins.b.c c2 = kotlin.reflect.jvm.internal.impl.builtins.b.c.a;
        if ((object = kotlin.reflect.jvm.internal.impl.builtins.b.c.a(c2, (kotlin.reflect.jvm.internal.impl.e.b)object, this.a.d().a(), null, 4, null)) != null) {
            if (c2.b((kotlin.reflect.jvm.internal.impl.a.e)object) && (a2.b() == kotlin.reflect.jvm.internal.impl.c.a.c.b.b.c || a2.a() == l.a || this.a(j2, (kotlin.reflect.jvm.internal.impl.a.e)object))) {
                return c2.d((kotlin.reflect.jvm.internal.impl.a.e)object);
            }
            return object;
        }
        return null;
    }

    private final ad a(kotlin.reflect.jvm.internal.impl.c.a.e.j j2, kotlin.reflect.jvm.internal.impl.c.a.c.b.a a2, ad ad2) {
        kotlin.reflect.jvm.internal.impl.a.a.h h2;
        if (ad2 == null || (h2 = ad2.x()) == null) {
            h2 = new e(this.a, j2);
        }
        an an2 = this.b(j2, a2);
        an an3 = null;
        if (an2 != null) {
            boolean bl2 = this.a(a2);
            if (ad2 != null) {
                an3 = ad2.g();
            }
            if (kotlin.e.b.j.a((Object)an3, (Object)an2) && !j2.e() && bl2) {
                return ad2.a(true);
            }
            return x.a(h2, an2, this.a(j2, a2, an2), bl2);
        }
        return null;
    }

    private final an a(kotlin.reflect.jvm.internal.impl.c.a.e.j object) {
        object = kotlin.reflect.jvm.internal.impl.e.a.a(new kotlin.reflect.jvm.internal.impl.e.b(object.f()));
        aa aa2 = this.a.e().d().a().m();
        kotlin.e.b.j.a(object, "classId");
        object = aa2.a((kotlin.reflect.jvm.internal.impl.e.a)object, kotlin.a.m.a(0)).e();
        kotlin.e.b.j.a(object, "c.components.deserialize\u2026istOf(0)).typeConstructor");
        return object;
    }

    private final ap a(v object, kotlin.reflect.jvm.internal.impl.c.a.c.b.a a2, as as2) {
        if (object instanceof kotlin.reflect.jvm.internal.impl.c.a.e.z) {
            object = (kotlin.reflect.jvm.internal.impl.c.a.e.z)object;
            v v2 = object.a();
            object = object.b() ? ba.c : ba.b;
            if (v2 != null && !this.a((ba)((Object)object), as2)) {
                return kotlin.reflect.jvm.internal.impl.j.c.a.a(this.a(v2, d.a(l.b, false, null, 3, null)), (ba)((Object)object), as2);
            }
            return d.a(as2, a2);
        }
        return new ar(ba.a, this.a((v)object, a2));
    }

    public static /* bridge */ /* synthetic */ w a(c c2, f f2, kotlin.reflect.jvm.internal.impl.c.a.c.b.a a2, boolean bl2, int n2, Object object) {
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        return c2.a(f2, a2, bl2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final w a(kotlin.reflect.jvm.internal.impl.c.a.e.j object, kotlin.reflect.jvm.internal.impl.c.a.c.b.a a2) {
        kotlin.e.a.a<ad> a3 = new kotlin.e.a.a<ad>((kotlin.reflect.jvm.internal.impl.c.a.e.j)object){
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.c.a.e.j a;
            {
                this.a = j2;
                super(0);
            }

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final ad b() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unresolved java class ");
                stringBuilder.append(this.a.g());
                return p.c(stringBuilder.toString());
            }
        };
        boolean bl2 = !a2.c() && a2.a() != l.a;
        boolean bl3 = object.e();
        if (!bl3 && !bl2) {
            if ((object = this.a((kotlin.reflect.jvm.internal.impl.c.a.e.j)object, a2, (ad)null)) != null) {
                do {
                    return (w)object;
                    break;
                } while (true);
            }
            object = a3.b();
            kotlin.e.b.j.a(object, "errorType()");
            return (w)object;
        }
        ad ad2 = this.a((kotlin.reflect.jvm.internal.impl.c.a.e.j)object, a2.a(kotlin.reflect.jvm.internal.impl.c.a.c.b.b.c), (ad)null);
        if (ad2 != null && (object = this.a((kotlin.reflect.jvm.internal.impl.c.a.e.j)object, a2.a(kotlin.reflect.jvm.internal.impl.c.a.c.b.b.b), ad2)) != null) {
            if (!bl3) return x.a(ad2, (ad)object);
            return new g(ad2, (ad)object);
        }
        object = a3.b();
        kotlin.e.b.j.a(object, "errorType()");
        return (w)object;
    }

    private final boolean a(kotlin.reflect.jvm.internal.impl.c.a.c.b.a a2) {
        kotlin.reflect.jvm.internal.impl.c.a.c.b.b b2 = a2.b();
        kotlin.reflect.jvm.internal.impl.c.a.c.b.b b3 = kotlin.reflect.jvm.internal.impl.c.a.c.b.b.c;
        boolean bl2 = false;
        if (b2 == b3) {
            return false;
        }
        boolean bl3 = bl2;
        if (!a2.c()) {
            bl3 = bl2;
            if (a2.a() != l.a) {
                bl3 = true;
            }
        }
        return bl3;
    }

    private final boolean a(kotlin.reflect.jvm.internal.impl.c.a.e.j object, kotlin.reflect.jvm.internal.impl.a.e e2) {
        boolean bl2 = a.a.a(kotlin.a.m.i(object.d()));
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        object = kotlin.reflect.jvm.internal.impl.builtins.b.c.a.d(e2).e();
        kotlin.e.b.j.a(object, "JavaToKotlinClassMap.con\u2026         .typeConstructor");
        object = object.b();
        kotlin.e.b.j.a(object, "JavaToKotlinClassMap.con\u2026ypeConstructor.parameters");
        object = kotlin.a.m.i(object);
        bl2 = bl3;
        if (object != null) {
            object = object.k();
            bl2 = bl3;
            if (object != null) {
                bl2 = bl3;
                if (object != ba.c) {
                    bl2 = true;
                }
            }
        }
        return bl2;
    }

    private final boolean a(ba ba2, as as2) {
        ba ba3 = as2.k();
        ba ba4 = ba.a;
        boolean bl2 = false;
        if (ba3 == ba4) {
            return false;
        }
        if (ba2 != as2.k()) {
            bl2 = true;
        }
        return bl2;
    }

    private final an b(kotlin.reflect.jvm.internal.impl.c.a.e.j object, kotlin.reflect.jvm.internal.impl.c.a.c.b.a object2) {
        i i2 = object.c();
        if (i2 != null) {
            if (i2 instanceof kotlin.reflect.jvm.internal.impl.c.a.e.g) {
                kotlin.reflect.jvm.internal.impl.c.a.e.g g2 = (kotlin.reflect.jvm.internal.impl.c.a.e.g)i2;
                kotlin.reflect.jvm.internal.impl.e.b b2 = g2.c();
                if (b2 != null) {
                    if ((object2 = this.a((kotlin.reflect.jvm.internal.impl.c.a.e.j)object, (kotlin.reflect.jvm.internal.impl.c.a.c.b.a)object2, b2)) == null) {
                        object2 = this.a.e().j().a(g2);
                    }
                    if (object2 != null && (object2 = object2.e()) != null) {
                        return object2;
                    }
                    return this.a((kotlin.reflect.jvm.internal.impl.c.a.e.j)object);
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Class type should have a FQ name: ");
                ((StringBuilder)object).append(i2);
                throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
            }
            if (i2 instanceof kotlin.reflect.jvm.internal.impl.c.a.e.w) {
                object = this.b.a((kotlin.reflect.jvm.internal.impl.c.a.e.w)i2);
                if (object != null) {
                    return object.e();
                }
                return null;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Unknown classifier kind: ");
            ((StringBuilder)object).append(i2);
            throw (Throwable)new IllegalStateException(((StringBuilder)object).toString());
        }
        return this.a((kotlin.reflect.jvm.internal.impl.c.a.e.j)object);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final w a(f object, kotlin.reflect.jvm.internal.impl.c.a.c.b.a a2, boolean bl2) {
        void var1_4;
        void var1_16;
        void var2_19;
        void var1_8;
        kotlin.e.b.j.b(object, "arrayType");
        kotlin.e.b.j.b(var2_19, "attr");
        Object object2 = object.a();
        if (!(object2 instanceof u)) {
            Object var1_2 = null;
        } else {
            v v2 = object2;
        }
        u u2 = (u)var1_4;
        if (u2 != null) {
            PrimitiveType primitiveType = u2.a();
        } else {
            Object var1_7 = null;
        }
        if (var1_8 != null) {
            void var1_10;
            ad ad2 = this.a.d().a().getPrimitiveArrayKotlinType((PrimitiveType)var1_8);
            if (var2_19.c()) {
                kotlin.e.b.j.a((Object)ad2, "jetType");
                do {
                    return (w)var1_10;
                    break;
                } while (true);
            }
            kotlin.e.b.j.a((Object)ad2, "jetType");
            az az2 = x.a(ad2, ad2.a(true));
            return (w)var1_10;
        }
        object2 = this.a((v)object2, d.a(l.b, var2_19.c(), null, 2, null));
        if (var2_19.c()) {
            void var1_14;
            void var3_20;
            if (var3_20 != false) {
                ba ba2 = ba.c;
            } else {
                ba ba3 = ba.a;
            }
            ad ad3 = this.a.d().a().getArrayType((ba)var1_14, (w)object2);
            kotlin.e.b.j.a((Object)ad3, "c.module.builtIns.getArr\u2026ctionKind, componentType)");
            do {
                return (w)var1_16;
                break;
            } while (true);
        }
        ad ad4 = this.a.d().a().getArrayType(ba.a, (w)object2);
        kotlin.e.b.j.a((Object)ad4, "c.module.builtIns.getArr\u2026INVARIANT, componentType)");
        az az3 = x.a(ad4, this.a.d().a().getArrayType(ba.c, (w)object2).a(true));
        return (w)var1_16;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final w a(v object, kotlin.reflect.jvm.internal.impl.c.a.c.b.a object2) {
        void var1_6;
        CharSequence charSequence;
        kotlin.e.b.j.b(object, "javaType");
        kotlin.e.b.j.b(charSequence, "attr");
        if (object instanceof u) {
            PrimitiveType primitiveType = ((u)object).a();
            if (primitiveType != null) {
                ad ad2 = this.a.d().a().getPrimitiveKotlinType(primitiveType);
            } else {
                ad ad3 = this.a.d().a().getUnitType();
            }
            charSequence = "if (primitiveType != nul\u2026.module.builtIns.unitType";
        } else {
            w w2;
            if (object instanceof kotlin.reflect.jvm.internal.impl.c.a.e.j) {
                return this.a((kotlin.reflect.jvm.internal.impl.c.a.e.j)object, (kotlin.reflect.jvm.internal.impl.c.a.c.b.a)((Object)charSequence));
            }
            if (object instanceof f) {
                return c.a(this, (f)object, (kotlin.reflect.jvm.internal.impl.c.a.c.b.a)((Object)charSequence), false, 4, null);
            }
            if (!(object instanceof kotlin.reflect.jvm.internal.impl.c.a.e.z)) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Unsupported type: ");
                ((StringBuilder)charSequence).append(object);
                throw (Throwable)new UnsupportedOperationException(((StringBuilder)charSequence).toString());
            }
            v v2 = ((kotlin.reflect.jvm.internal.impl.c.a.e.z)object).a();
            if (v2 != null && (w2 = this.a(v2, (kotlin.reflect.jvm.internal.impl.c.a.c.b.a)((Object)charSequence))) != null) {
                return w2;
            }
            ad ad4 = this.a.d().a().getDefaultBound();
            charSequence = "c.module.builtIns.defaultBound";
        }
        kotlin.e.b.j.a((Object)var1_6, (String)charSequence);
        return (w)var1_6;
    }

}

