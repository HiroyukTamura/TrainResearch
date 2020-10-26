/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.e.b.k;
import kotlin.m;
import kotlin.o;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.al;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.c.x;
import kotlin.reflect.jvm.internal.impl.a.c.z;
import kotlin.reflect.jvm.internal.impl.a.t;
import kotlin.reflect.jvm.internal.impl.c.a.a;
import kotlin.reflect.jvm.internal.impl.c.a.f.d;
import kotlin.reflect.jvm.internal.impl.c.a.f.g;
import kotlin.reflect.jvm.internal.impl.c.a.f.h;
import kotlin.reflect.jvm.internal.impl.c.a.f.i;
import kotlin.reflect.jvm.internal.impl.c.a.f.j;
import kotlin.reflect.jvm.internal.impl.c.a.f.n;
import kotlin.reflect.jvm.internal.impl.c.a.f.r;
import kotlin.reflect.jvm.internal.impl.c.a.f.s;
import kotlin.reflect.jvm.internal.impl.c.a.p;
import kotlin.reflect.jvm.internal.impl.c.a.t;
import kotlin.reflect.jvm.internal.impl.c.b.u;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.ax;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.q;
import kotlin.w;
import kotlin.y;

public final class l {
    private final kotlin.reflect.jvm.internal.impl.c.a.a a;
    private final kotlin.reflect.jvm.internal.impl.l.e b;

    public l(kotlin.reflect.jvm.internal.impl.c.a.a a2, kotlin.reflect.jvm.internal.impl.l.e e2) {
        kotlin.e.b.j.b(a2, "annotationTypeQualifierResolver");
        kotlin.e.b.j.b(e2, "jsr305State");
        this.a = a2;
        this.b = e2;
    }

    private final <D extends kotlin.reflect.jvm.internal.impl.a.b> D a(D object, kotlin.reflect.jvm.internal.impl.c.a.c.h object2) {
        Object object3;
        Object object4;
        Object object5;
        boolean bl2;
        Object object6;
        kotlin.reflect.jvm.internal.impl.c.a.b.b b2;
        Object object7;
        boolean bl3;
        block23 : {
            block21 : {
                block22 : {
                    if (!(object instanceof kotlin.reflect.jvm.internal.impl.c.a.b.b)) {
                        return object;
                    }
                    b2 = (kotlin.reflect.jvm.internal.impl.c.a.b.b)object;
                    if (b2.n() == b.a.b) {
                        object7 = b2.l();
                        kotlin.e.b.j.a(object7, "original");
                        if (object7.k().size() == 1) {
                            return object;
                        }
                    }
                    object3 = kotlin.reflect.jvm.internal.impl.c.a.c.a.b((kotlin.reflect.jvm.internal.impl.c.a.c.h)object2, object.x());
                    if (object instanceof kotlin.reflect.jvm.internal.impl.c.a.b.f && (object7 = ((kotlin.reflect.jvm.internal.impl.a.c.y)(object2 = (kotlin.reflect.jvm.internal.impl.c.a.b.f)object)).C()) != null && !((x)object7).o()) {
                        if ((object2 = ((kotlin.reflect.jvm.internal.impl.a.c.y)object2).C()) == null) {
                            kotlin.e.b.j.a();
                        }
                        kotlin.e.b.j.a(object2, "getter!!");
                        object2 = (kotlin.reflect.jvm.internal.impl.a.b)object2;
                    } else {
                        object2 = object;
                    }
                    if (b2.d() != null) {
                        object7 = !(object2 instanceof kotlin.reflect.jvm.internal.impl.a.t) ? null : object2;
                        object7 = (kotlin.reflect.jvm.internal.impl.a.t)object7;
                        object7 = object7 != null ? object7.a(kotlin.reflect.jvm.internal.impl.c.a.b.e.a) : null;
                        object7 = b.a(this.a((kotlin.reflect.jvm.internal.impl.a.b)object, (kotlin.reflect.jvm.internal.impl.a.av)object7, (kotlin.reflect.jvm.internal.impl.c.a.c.h)object3, d.a), null, 1, null);
                    } else {
                        object7 = null;
                    }
                    object4 = !(object instanceof kotlin.reflect.jvm.internal.impl.c.a.b.e) ? null : (Object)object;
                    object4 = (kotlin.reflect.jvm.internal.impl.c.a.b.e)object4;
                    bl2 = false;
                    if (object4 == null) break block21;
                    object5 = u.a;
                    object6 = ((kotlin.reflect.jvm.internal.impl.a.c.k)object4).b();
                    if (object6 == null) break block22;
                    if ((object4 = ((u)object5).a((kotlin.reflect.jvm.internal.impl.a.e)object6, kotlin.reflect.jvm.internal.impl.c.b.r.a((kotlin.reflect.jvm.internal.impl.a.t)object4, false, false, 3, null))) == null) break block21;
                    object4 = i.a().get(object4);
                    break block23;
                }
                throw new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
            }
            object4 = null;
        }
        if (object4 != null) {
            bl3 = ((j)object4).b().size() == b2.i().size();
            if (y.a && !bl3) {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Predefined enhancement info for ");
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(" has ");
                ((StringBuilder)object2).append(((j)object4).b().size());
                ((StringBuilder)object2).append(", but ");
                ((StringBuilder)object2).append(b2.i().size());
                ((StringBuilder)object2).append(" expected");
                throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object2).toString()));
            }
        }
        object5 = object2.i();
        kotlin.e.b.j.a(object5, "annotationOwnerForMember.valueParameters");
        object5 = (Iterable)object5;
        object6 = new ArrayList(kotlin.a.m.a(object5, 10));
        Iterator iterator = object5.iterator();
        while (iterator.hasNext()) {
            final kotlin.reflect.jvm.internal.impl.a.av av2 = (kotlin.reflect.jvm.internal.impl.a.av)iterator.next();
            Object object8 = this.a((kotlin.reflect.jvm.internal.impl.a.b)object, av2, (kotlin.reflect.jvm.internal.impl.c.a.c.h)object3, (kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.a.b, ? extends kotlin.reflect.jvm.internal.impl.j.w>)new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.a.b, kotlin.reflect.jvm.internal.impl.j.w>(){

                @Override
                public final kotlin.reflect.jvm.internal.impl.j.w a(kotlin.reflect.jvm.internal.impl.a.b a2) {
                    kotlin.e.b.j.b(a2, "it");
                    a2 = a2.i().get(av2.c());
                    kotlin.e.b.j.a((Object)a2, "it.valueParameters[p.index]");
                    a2 = ((kotlin.reflect.jvm.internal.impl.a.av)a2).r();
                    kotlin.e.b.j.a((Object)a2, "it.valueParameters[p.index].type");
                    return a2;
                }
            });
            object5 = object4 != null && (object5 = ((j)object4).b()) != null ? kotlin.a.m.c(object5, av2.c()) : null;
            if (((a)(object8 = ((b)object8).a((r)object5))).b()) {
                object5 = ((a)object8).a();
            } else {
                kotlin.e.b.j.a((Object)av2, "p");
                object5 = av2.r();
                kotlin.e.b.j.a(object5, "p.type");
            }
            kotlin.e.b.j.a((Object)av2, "p");
            boolean bl4 = this.a(av2, (kotlin.reflect.jvm.internal.impl.j.w)object5);
            boolean bl5 = ((a)object8).b() || bl4 != av2.l();
            object6.add(new c(((a)object8).a(), bl4, bl5));
        }
        object5 = (List)object6;
        object6 = (kotlin.reflect.jvm.internal.impl.a.a.a)object2;
        object2 = !(object instanceof ai) ? null : object;
        object2 = (ai)object2;
        object2 = object2 != null && kotlin.reflect.jvm.internal.impl.c.a.c.a.c.a((ai)object2) ? a.a.c : a.a.a;
        object3 = this.a((kotlin.reflect.jvm.internal.impl.a.b)object, (kotlin.reflect.jvm.internal.impl.a.a.a)object6, true, (kotlin.reflect.jvm.internal.impl.c.a.c.h)object3, (a.a)((Object)object2), e.a);
        object2 = object4 != null ? ((j)object4).a() : null;
        object2 = ((b)object3).a((r)object2);
        if (!(object7 != null && ((a)object7).b() || ((a)object2).b())) {
            block20 : {
                object4 = (Iterable)object5;
                if (object4 instanceof Collection && ((Collection)object4).isEmpty()) {
                    bl3 = bl2;
                } else {
                    object4 = object4.iterator();
                    do {
                        bl3 = bl2;
                        if (!object4.hasNext()) break block20;
                    } while (!((c)object4.next()).b());
                    bl3 = true;
                }
            }
            if (!bl3) {
                return object;
            }
        }
        object = object7 != null ? ((a)object7).a() : null;
        object4 = (Iterable)object5;
        object7 = new ArrayList(kotlin.a.m.a(object4, 10));
        object4 = object4.iterator();
        while (object4.hasNext()) {
            object5 = (c)object4.next();
            object7.add(new kotlin.reflect.jvm.internal.impl.c.a.b.j(((a)object5).a(), ((c)object5).c()));
        }
        if ((object = b2.a((kotlin.reflect.jvm.internal.impl.j.w)object, (List)object7, ((a)object2).a())) != null) {
            return (D)object;
        }
        throw new kotlin.t("null cannot be cast to non-null type D");
    }

    private final b a(kotlin.reflect.jvm.internal.impl.a.b b2, kotlin.reflect.jvm.internal.impl.a.a.a a2, boolean bl2, kotlin.reflect.jvm.internal.impl.c.a.c.h h2, a.a a3, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.a.b, ? extends kotlin.reflect.jvm.internal.impl.j.w> b3) {
        kotlin.reflect.jvm.internal.impl.j.w w2 = b3.a(b2);
        Collection collection = b2.k();
        kotlin.e.b.j.a(collection, "this.overriddenDescriptors");
        Object object = collection;
        collection = new ArrayList(kotlin.a.m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            kotlin.reflect.jvm.internal.impl.a.b b4 = (kotlin.reflect.jvm.internal.impl.a.b)object.next();
            kotlin.e.b.j.a((Object)b4, "it");
            collection.add(b3.a(b4));
        }
        return new b(a2, w2, (List)collection, bl2, kotlin.reflect.jvm.internal.impl.c.a.c.a.b(h2, b3.a(b2).x()), a3);
    }

    private final b a(kotlin.reflect.jvm.internal.impl.a.b b2, kotlin.reflect.jvm.internal.impl.a.av object, kotlin.reflect.jvm.internal.impl.c.a.c.h h2, kotlin.e.a.b<? super kotlin.reflect.jvm.internal.impl.a.b, ? extends kotlin.reflect.jvm.internal.impl.j.w> b3) {
        kotlin.reflect.jvm.internal.impl.a.a.a a2 = (kotlin.reflect.jvm.internal.impl.a.a.a)object;
        if (object == null || (object = kotlin.reflect.jvm.internal.impl.c.a.c.a.b(h2, object.x())) == null) {
            object = h2;
        }
        return this.a(b2, a2, false, (kotlin.reflect.jvm.internal.impl.c.a.c.h)object, a.a.b, b3);
    }

    private final boolean a(kotlin.reflect.jvm.internal.impl.a.av av2, kotlin.reflect.jvm.internal.impl.j.w w2) {
        block8 : {
            boolean bl2;
            boolean bl3;
            block6 : {
                kotlin.reflect.jvm.internal.impl.c.a.b.a a2;
                block7 : {
                    block5 : {
                        a2 = kotlin.reflect.jvm.internal.impl.c.a.b.i.a(av2);
                        bl2 = a2 instanceof kotlin.reflect.jvm.internal.impl.c.a.b.h;
                        bl3 = false;
                        if (!bl2) break block5;
                        bl2 = t.a(w2, ((kotlin.reflect.jvm.internal.impl.c.a.b.h)a2).a()) != null;
                        break block6;
                    }
                    if (!kotlin.e.b.j.a((Object)a2, (Object)kotlin.reflect.jvm.internal.impl.c.a.b.g.a)) break block7;
                    bl2 = av.g(w2);
                    break block6;
                }
                if (a2 != null) break block8;
                bl2 = av2.l();
            }
            boolean bl4 = bl3;
            if (bl2) {
                bl4 = bl3;
                if (av2.k().isEmpty()) {
                    bl4 = true;
                }
            }
            return bl4;
        }
        throw new m();
    }

    private final h b(kotlin.reflect.jvm.internal.impl.a.a.c object) {
        block9 : {
            block12 : {
                block13 : {
                    block10 : {
                        block11 : {
                            kotlin.reflect.jvm.internal.impl.h.b.f<?> f2 = kotlin.reflect.jvm.internal.impl.h.c.a.b((kotlin.reflect.jvm.internal.impl.a.a.c)object);
                            object = f2;
                            if (!(f2 instanceof kotlin.reflect.jvm.internal.impl.h.b.i)) {
                                object = null;
                            }
                            if ((object = (kotlin.reflect.jvm.internal.impl.h.b.i)object) == null) break block9;
                            int n2 = ((String)(object = ((kotlin.reflect.jvm.internal.impl.h.b.i)object).b().a())).hashCode();
                            if (n2 == 73135176) break block10;
                            if (n2 == 74175084) break block11;
                            if (n2 != 433141802) {
                                if (n2 == 1933739535 && ((String)object).equals("ALWAYS")) {
                                    return new h(g.b, false, 2, null);
                                }
                            } else if (((String)object).equals("UNKNOWN")) {
                                return new h(g.c, false, 2, null);
                            }
                            break block12;
                        }
                        if (!((String)object).equals("NEVER")) break block12;
                        break block13;
                    }
                    if (!((String)object).equals("MAYBE")) break block12;
                }
                return new h(g.a, false, 2, null);
            }
            return null;
        }
        return new h(g.b, false, 2, null);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final h c(kotlin.reflect.jvm.internal.impl.a.a.c object) {
        kotlin.reflect.jvm.internal.impl.e.b b2 = object.b();
        Object var2_3 = null;
        if (b2 == null) return null;
        if (p.a().contains(b2)) {
            return new h(g.a, false, 2, null);
        }
        if (p.d().contains(b2)) {
            return new h(g.b, false, 2, null);
        }
        if (kotlin.e.b.j.a((Object)b2, (Object)p.b())) {
            return this.b((kotlin.reflect.jvm.internal.impl.a.a.c)object);
        }
        if (kotlin.e.b.j.a((Object)b2, (Object)p.e()) && this.b.e()) {
            return new h(g.a, false, 2, null);
        }
        if (kotlin.e.b.j.a((Object)b2, (Object)p.f()) && this.b.e()) {
            return new h(g.b, false, 2, null);
        }
        if (kotlin.e.b.j.a((Object)b2, (Object)p.h())) {
            return new h(g.b, true);
        }
        object = var2_3;
        if (!kotlin.e.b.j.a((Object)b2, (Object)p.g())) return object;
        return new h(g.a, true);
    }

    public final <D extends kotlin.reflect.jvm.internal.impl.a.b> Collection<D> a(kotlin.reflect.jvm.internal.impl.c.a.c.h h2, Collection<? extends D> collection) {
        kotlin.e.b.j.b(h2, "c");
        kotlin.e.b.j.b(collection, "platformSignatures");
        Object object = collection;
        collection = new ArrayList(kotlin.a.m.a(object, 10));
        object = object.iterator();
        while (object.hasNext()) {
            collection.add(this.a((kotlin.reflect.jvm.internal.impl.a.b)object.next(), h2));
        }
        return (List)collection;
    }

    public final h a(kotlin.reflect.jvm.internal.impl.a.a.c object) {
        kotlin.e.b.j.b(object, "annotationDescriptor");
        h h2 = this.c((kotlin.reflect.jvm.internal.impl.a.a.c)object);
        if (h2 != null) {
            return h2;
        }
        Object object2 = this.a.a((kotlin.reflect.jvm.internal.impl.a.a.c)object);
        Object var3_4 = null;
        h2 = var3_4;
        if (object2 != null) {
            if (((kotlin.reflect.jvm.internal.impl.l.h)((Object)(object = this.a.d((kotlin.reflect.jvm.internal.impl.a.a.c)object)))).b()) {
                return null;
            }
            object2 = this.c((kotlin.reflect.jvm.internal.impl.a.a.c)object2);
            h2 = var3_4;
            if (object2 != null) {
                h2 = h.a((h)object2, null, ((kotlin.reflect.jvm.internal.impl.l.h)((Object)object)).a(), 1, null);
            }
        }
        return h2;
    }

    private static class a {
        private final kotlin.reflect.jvm.internal.impl.j.w a;
        private final boolean b;

        public a(kotlin.reflect.jvm.internal.impl.j.w w2, boolean bl2) {
            kotlin.e.b.j.b(w2, "type");
            this.a = w2;
            this.b = bl2;
        }

        public final kotlin.reflect.jvm.internal.impl.j.w a() {
            return this.a;
        }

        public final boolean b() {
            return this.b;
        }
    }

    private final class kotlin.reflect.jvm.internal.impl.c.a.f.l$b {
        private final kotlin.reflect.jvm.internal.impl.a.a.a b;
        private final kotlin.reflect.jvm.internal.impl.j.w c;
        private final Collection<kotlin.reflect.jvm.internal.impl.j.w> d;
        private final boolean e;
        private final kotlin.reflect.jvm.internal.impl.c.a.c.h f;
        private final a.a g;

        public kotlin.reflect.jvm.internal.impl.c.a.f.l$b(kotlin.reflect.jvm.internal.impl.a.a.a a2, kotlin.reflect.jvm.internal.impl.j.w w2, Collection<? extends kotlin.reflect.jvm.internal.impl.j.w> collection, boolean bl2, kotlin.reflect.jvm.internal.impl.c.a.c.h h2, a.a a3) {
            kotlin.e.b.j.b(w2, "fromOverride");
            kotlin.e.b.j.b(collection, "fromOverridden");
            kotlin.e.b.j.b(h2, "containerContext");
            kotlin.e.b.j.b((Object)a3, "containerApplicabilityType");
            this.b = a2;
            this.c = w2;
            this.d = collection;
            this.e = bl2;
            this.f = h2;
            this.g = a3;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private final kotlin.reflect.jvm.internal.impl.c.a.f.d a(kotlin.reflect.jvm.internal.impl.j.w var1_1) {
            block5 : {
                if (kotlin.reflect.jvm.internal.impl.j.t.a(var1_1)) {
                    var2_2 = kotlin.reflect.jvm.internal.impl.j.t.b(var1_1);
                    var2_3 = new o<ad, ad>(var2_2.f(), var2_2.h());
                } else {
                    var2_4 = new o<kotlin.reflect.jvm.internal.impl.j.w, kotlin.reflect.jvm.internal.impl.j.w>(var1_1, var1_1);
                }
                var4_14 = (kotlin.reflect.jvm.internal.impl.j.w)var2_5.c();
                var5_15 = (kotlin.reflect.jvm.internal.impl.j.w)var2_5.d();
                var6_16 = kotlin.reflect.jvm.internal.impl.builtins.b.c.a;
                if (!var4_14.c()) break block5;
                var2_6 = g.a;
                ** GOTO lbl15
            }
            if (!var5_15.c()) {
                var2_8 = g.b;
lbl15: // 2 sources:
                var3_17 = var2_7;
            } else {
                var3_18 = null;
            }
            if (var6_16.b(var4_14)) {
                var2_10 = kotlin.reflect.jvm.internal.impl.c.a.f.e.a;
                return new kotlin.reflect.jvm.internal.impl.c.a.f.d((g)var3_19, (kotlin.reflect.jvm.internal.impl.c.a.f.e)var2_13, var1_1.l() instanceof kotlin.reflect.jvm.internal.impl.c.a.f.f, false, 8, null);
            }
            if (var6_16.a(var5_15) == false) return new kotlin.reflect.jvm.internal.impl.c.a.f.d((g)var3_19, (kotlin.reflect.jvm.internal.impl.c.a.f.e)var2_13, var1_1.l() instanceof kotlin.reflect.jvm.internal.impl.c.a.f.f, false, 8, null);
            var2_11 = kotlin.reflect.jvm.internal.impl.c.a.f.e.b;
            return new kotlin.reflect.jvm.internal.impl.c.a.f.d((g)var3_19, (kotlin.reflect.jvm.internal.impl.c.a.f.e)var2_13, var1_1.l() instanceof kotlin.reflect.jvm.internal.impl.c.a.f.f, false, 8, null);
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private final kotlin.reflect.jvm.internal.impl.c.a.f.d a(kotlin.reflect.jvm.internal.impl.j.w var1_1, Collection<? extends kotlin.reflect.jvm.internal.impl.j.w> var2_2, kotlin.reflect.jvm.internal.impl.c.a.f.d var3_3, boolean var4_4) {
            var2_10 = (Iterable)var2_9;
            var9_18 = new ArrayList<E>(kotlin.a.m.a(var2_10, 10));
            var10_24 = var2_10.iterator();
            while (var10_24.hasNext()) {
                var9_18.add(this.a((kotlin.reflect.jvm.internal.impl.j.w)var10_24.next()));
            }
            var11_30 = (List)var9_18;
            var9_19 = new ArrayList<E>();
            var10_25 = var11_30.iterator();
            while (var10_25.hasNext()) {
                var12_31 = ((kotlin.reflect.jvm.internal.impl.c.a.f.d)var10_25.next()).b();
                if (var12_31 == null) continue;
                var9_19.add(var12_31);
            }
            var12_32 = kotlin.a.m.m((List)var9_19);
            var9_20 = new ArrayList<E>();
            var10_26 = var11_30.iterator();
            while (var10_26.hasNext()) {
                var13_33 = ((kotlin.reflect.jvm.internal.impl.c.a.f.d)var10_26.next()).a();
                if (var13_33 == null) continue;
                var9_20.add(var13_33);
            }
            var13_34 = kotlin.a.m.m((List)var9_20);
            var9_21 = new ArrayList<E>();
            var2_11 = var2_10.iterator();
            while (var2_11.hasNext()) {
                var10_28 = this.a(ax.b((kotlin.reflect.jvm.internal.impl.j.w)var2_11.next())).a();
                if (var10_28 == null) continue;
                var9_21.add(var10_28);
            }
            var14_35 = kotlin.a.m.m((List)var9_21);
            var3_16 = this.a((kotlin.reflect.jvm.internal.impl.j.w)var1_1 /* !! */ , var4_17, var3_16);
            var7_36 = var3_16.d();
            var8_37 = true;
            var9_22 = null;
            if (var7_36 ^ true) {
                var1_2 = var3_16;
            } else {
                var1_3 = null;
            }
            if (var1_4 != null) {
                var1_5 = var1_4.a();
            } else {
                var1_6 = null;
            }
            var15_38 = var3_16.a();
            var7_36 = this.e != false && var4_17 != false;
            var10_29 = n.a(var13_34, (g)var1_7, var7_36);
            var2_12 = var9_22;
            if (var10_29 != null) {
                var5_39 = this.a() != false && var4_17 != false && var10_29 == g.a;
                var2_13 = var9_22;
                if (!var5_39) {
                    var2_14 = var10_29;
                }
            }
            var9_23 = (kotlin.reflect.jvm.internal.impl.c.a.f.e)n.a(var12_32, (Object)kotlin.reflect.jvm.internal.impl.c.a.f.e.b, (Object)kotlin.reflect.jvm.internal.impl.c.a.f.e.a, (Object)var3_16.b(), var7_36);
            var5_39 = var15_38 != var1_7 || kotlin.e.b.j.a(var14_35, var13_34) ^ true;
            if (var3_16.c()) ** GOTO lbl-1000
            if (!(var11_30 instanceof Collection) || !((Collection)var11_30).isEmpty()) {
                var1_8 = var11_30.iterator();
                while (var1_8.hasNext()) {
                    if (!((kotlin.reflect.jvm.internal.impl.c.a.f.d)var1_8.next()).c()) continue;
                    var6_40 = true;
                    break;
                }
            } else {
                var6_40 = false;
            }
            if (!var6_40) {
                var4_17 = false;
            } else lbl-1000: // 2 sources:
            {
                var4_17 = true;
            }
            if (var2_15 == null && var5_39) {
                return n.a(n.a(var14_35, var15_38, var7_36), var9_23, true, var4_17);
            }
            if (var2_15 == null) {
                var7_36 = var8_37;
                return n.a((g)var2_15, var9_23, var7_36, var4_17);
            }
            var7_36 = false;
            return n.a((g)var2_15, var9_23, var7_36, var4_17);
        }

        private final kotlin.reflect.jvm.internal.impl.c.a.f.d a(kotlin.reflect.jvm.internal.impl.j.w w2, boolean bl2, kotlin.reflect.jvm.internal.impl.c.a.f.d object) {
            Object object2 = bl2 && this.b != null ? kotlin.reflect.jvm.internal.impl.a.a.j.a(this.b.x(), w2.x()) : w2.x();
            Object object3 = new kotlin.e.a.m<List<? extends kotlin.reflect.jvm.internal.impl.e.b>, T, T>((kotlin.reflect.jvm.internal.impl.a.a.h)object2){
                final /* synthetic */ kotlin.reflect.jvm.internal.impl.a.a.h a;
                {
                    this.a = h2;
                    super(2);
                }

                @Override
                public final <T> T a(List<kotlin.reflect.jvm.internal.impl.e.b> object, T t2) {
                    boolean bl2;
                    block4 : {
                        kotlin.e.b.j.b(object, "$receiver");
                        kotlin.e.b.j.b(t2, "qualifier");
                        object = (Iterable)object;
                        boolean bl3 = object instanceof Collection;
                        boolean bl4 = false;
                        if (bl3 && ((Collection)object).isEmpty()) {
                            bl2 = bl4;
                        } else {
                            kotlin.reflect.jvm.internal.impl.e.b b2;
                            object = object.iterator();
                            do {
                                bl2 = bl4;
                                if (!object.hasNext()) break block4;
                            } while (!(bl2 = this.a.a(b2 = (kotlin.reflect.jvm.internal.impl.e.b)object.next()) != null));
                            bl2 = true;
                        }
                    }
                    if (bl2) {
                        return t2;
                    }
                    return null;
                }
            };
            Object object4 = d.a;
            g g2 = null;
            if (bl2) {
                object = this.f.a();
                object = object != null ? ((kotlin.reflect.jvm.internal.impl.c.a.c.d)object).a(this.g) : null;
            }
            object = (object2 = this.a((kotlin.reflect.jvm.internal.impl.a.a.h)object2)) != null ? object2 : (object != null && ((kotlin.reflect.jvm.internal.impl.c.a.f.d)object).a() != null ? new h(((kotlin.reflect.jvm.internal.impl.c.a.f.d)object).a(), ((kotlin.reflect.jvm.internal.impl.c.a.f.d)object).d()) : null);
            object2 = object != null ? ((h)object).a() : null;
            object3 = object4.a(object3.a(p.i(), kotlin.reflect.jvm.internal.impl.c.a.f.e.a), object3.a(p.j(), kotlin.reflect.jvm.internal.impl.c.a.f.e.b));
            if (object != null) {
                g2 = ((h)object).a();
            }
            object4 = g.b;
            boolean bl3 = false;
            bl2 = g2 == object4 && kotlin.reflect.jvm.internal.impl.j.c.a.e(w2);
            boolean bl4 = bl3;
            if (object != null) {
                bl4 = bl3;
                if (((h)object).b()) {
                    bl4 = true;
                }
            }
            return new kotlin.reflect.jvm.internal.impl.c.a.f.d((g)((Object)object2), (kotlin.reflect.jvm.internal.impl.c.a.f.e)((Object)object3), bl2, bl4);
        }

        private final h a(kotlin.reflect.jvm.internal.impl.a.a.h object) {
            Object object2 = (Iterable)object;
            object = l.this;
            object2 = object2.iterator();
            while (object2.hasNext()) {
                h h2 = ((l)object).a((kotlin.reflect.jvm.internal.impl.a.a.c)object2.next());
                if (h2 == null) continue;
                return h2;
            }
            return null;
        }

        public static /* bridge */ /* synthetic */ kotlin.reflect.jvm.internal.impl.c.a.f.l$a a(kotlin.reflect.jvm.internal.impl.c.a.f.l$b b2, r r2, int n2, Object object) {
            if ((n2 & 1) != 0) {
                r2 = null;
            }
            return b2.a(r2);
        }

        private final boolean a() {
            kotlin.reflect.jvm.internal.impl.a.a.a a2 = this.b;
            boolean bl2 = a2 instanceof kotlin.reflect.jvm.internal.impl.a.av;
            Object var3_3 = null;
            if (!bl2) {
                a2 = null;
            }
            kotlin.reflect.jvm.internal.impl.a.av av2 = (kotlin.reflect.jvm.internal.impl.a.av)a2;
            a2 = var3_3;
            if (av2 != null) {
                a2 = av2.m();
            }
            return a2 != null;
        }

        private final List<kotlin.reflect.jvm.internal.impl.c.a.f.p> b(kotlin.reflect.jvm.internal.impl.j.w w2) {
            final ArrayList arrayList = new ArrayList(1);
            new kotlin.e.a.m<kotlin.reflect.jvm.internal.impl.j.w, kotlin.reflect.jvm.internal.impl.c.a.c.h, w>(){

                @Override
                public final void a(kotlin.reflect.jvm.internal.impl.j.w object, kotlin.reflect.jvm.internal.impl.c.a.c.h object22) {
                    void var2_6;
                    kotlin.e.b.j.b(object, "type");
                    kotlin.e.b.j.b(object22, "ownerContext");
                    kotlin.reflect.jvm.internal.impl.c.a.c.h h2 = kotlin.reflect.jvm.internal.impl.c.a.c.a.b((kotlin.reflect.jvm.internal.impl.c.a.c.h)object22, object.x());
                    Serializable serializable = arrayList;
                    kotlin.reflect.jvm.internal.impl.c.a.c.d d2 = h2.a();
                    if (d2 != null) {
                        kotlin.reflect.jvm.internal.impl.c.a.f.d d3 = d2.a(a.a.d);
                    } else {
                        Object var2_5 = null;
                    }
                    ((ArrayList)serializable).add(new kotlin.reflect.jvm.internal.impl.c.a.f.p((kotlin.reflect.jvm.internal.impl.j.w)((Object)object), (kotlin.reflect.jvm.internal.impl.c.a.f.d)var2_6));
                    for (ap ap2 : ((kotlin.reflect.jvm.internal.impl.j.w)((Object)object)).a()) {
                        if (ap2.a()) {
                            serializable = arrayList;
                            kotlin.reflect.jvm.internal.impl.j.w w2 = ap2.c();
                            kotlin.e.b.j.a((Object)w2, "arg.type");
                            ((ArrayList)serializable).add(new kotlin.reflect.jvm.internal.impl.c.a.f.p(w2, null));
                            continue;
                        }
                        serializable = this;
                        kotlin.reflect.jvm.internal.impl.j.w w3 = ap2.c();
                        kotlin.e.b.j.a((Object)w3, "arg.type");
                        serializable.a(w3, h2);
                    }
                }
            }.a(w2, this.f);
            return arrayList;
        }

        /*
         * Unable to fully structure code
         * Enabled aggressive block sorting
         * Lifted jumps to return sites
         */
        private final kotlin.e.a.b<Integer, kotlin.reflect.jvm.internal.impl.c.a.f.d> b() {
            var7_1 = this.d;
            var6_2 = new ArrayList<E>(kotlin.a.m.a(var7_1, 10));
            var7_1 = var7_1.iterator();
            while (var7_1.hasNext()) {
                var6_2.add(this.b((kotlin.reflect.jvm.internal.impl.j.w)var7_1.next()));
            }
            var7_1 = (List)var6_2;
            var8_3 = this.b(this.c);
            if (!this.e) ** GOTO lbl-1000
            var6_2 = this.d;
            if (!(var6_2 instanceof Collection) || !var6_2.isEmpty()) {
                var6_2 = var6_2.iterator();
                while (var6_2.hasNext()) {
                    var9_4 /* !! */  = (kotlin.reflect.jvm.internal.impl.j.w)var6_2.next();
                    if (!(kotlin.reflect.jvm.internal.impl.j.a.c.a.b((kotlin.reflect.jvm.internal.impl.j.w)var9_4 /* !! */ , this.c) ^ true)) continue;
                    var1_5 = true;
                    break;
                }
            } else {
                var1_5 = false;
            }
            if (var1_5) {
                var1_5 = true;
            } else lbl-1000: // 2 sources:
            {
                var1_5 = false;
            }
            var2_6 = var1_5 != false ? 1 : var8_3.size();
            var9_4 /* !! */  = new kotlin.reflect.jvm.internal.impl.c.a.f.d[var2_6];
            var4_7 = var9_4 /* !! */ .length;
            var2_6 = 0;
            while (var2_6 < var4_7) {
                var5_9 = var2_6 == 0;
                var3_8 = var5_9 || !var1_5;
                if (y.a) {
                    if (var3_8 == false) throw (Throwable)new AssertionError((Object)"Only head type constructors should be computed");
                }
                var6_2 = var8_3.get(var2_6);
                var10_10 = var6_2.b();
                var11_11 = var6_2.c();
                var6_2 = (Iterable)var7_1;
                var12_12 = new ArrayList<E>();
                var13_13 = var6_2.iterator();
                while (var13_13.hasNext()) {
                    var6_2 = (kotlin.reflect.jvm.internal.impl.c.a.f.p)kotlin.a.m.c((List)var13_13.next(), var2_6);
                    var6_2 = var6_2 != null ? var6_2.a() : null;
                    if (var6_2 == null) continue;
                    var12_12.add(var6_2);
                }
                var9_4 /* !! */ [var2_6] = this.a(var10_10, (List)var12_12, var11_11, var5_9);
                ++var2_6;
            }
            return new kotlin.e.a.b<Integer, kotlin.reflect.jvm.internal.impl.c.a.f.d>(){

                @Override
                public /* synthetic */ Object a(Object object) {
                    return this.a(((Number)object).intValue());
                }

                @Override
                public final kotlin.reflect.jvm.internal.impl.c.a.f.d a(int n2) {
                    kotlin.reflect.jvm.internal.impl.c.a.f.d[] arrd = var9_4;
                    if (n2 >= 0 && n2 <= kotlin.a.g.g(arrd)) {
                        return arrd[n2];
                    }
                    return kotlin.reflect.jvm.internal.impl.c.a.f.d.a.a();
                }
            };
        }

        public final kotlin.reflect.jvm.internal.impl.c.a.f.l$a a(r b2) {
            kotlin.e.a.b<Integer, kotlin.reflect.jvm.internal.impl.c.a.f.d> b3 = this.b();
            b2 = b2 != null ? (kotlin.e.a.b)new kotlin.e.a.b<Integer, kotlin.reflect.jvm.internal.impl.c.a.f.d>((r)((Object)b2), b3){
                final /* synthetic */ r a;
                final /* synthetic */ kotlin.e.a.b b;
                {
                    this.a = r2;
                    this.b = b2;
                    super(1);
                }

                @Override
                public /* synthetic */ Object a(Object object) {
                    return this.a(((Number)object).intValue());
                }

                @Override
                public final kotlin.reflect.jvm.internal.impl.c.a.f.d a(int n2) {
                    kotlin.reflect.jvm.internal.impl.c.a.f.d d2 = this.a.a().get(n2);
                    if (d2 != null) {
                        return d2;
                    }
                    return (kotlin.reflect.jvm.internal.impl.c.a.f.d)this.b.a(n2);
                }
            } : null;
            kotlin.reflect.jvm.internal.impl.j.w w2 = this.c;
            if (b2 == null) {
                b2 = b3;
            }
            b2 = s.a(w2, b2);
            if (b2 != null) {
                return new kotlin.reflect.jvm.internal.impl.c.a.f.l$a((kotlin.reflect.jvm.internal.impl.j.w)((Object)b2), true);
            }
            return new kotlin.reflect.jvm.internal.impl.c.a.f.l$a(this.c, false);
        }

    }

    private static final class c
    extends a {
        private final boolean a;

        public c(kotlin.reflect.jvm.internal.impl.j.w w2, boolean bl2, boolean bl3) {
            kotlin.e.b.j.b(w2, "type");
            super(w2, bl3);
            this.a = bl2;
        }

        public final boolean c() {
            return this.a;
        }
    }

}

