/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.j.a;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.h.a.a.b;
import kotlin.reflect.jvm.internal.impl.j.a.a;
import kotlin.reflect.jvm.internal.impl.j.a.c;
import kotlin.reflect.jvm.internal.impl.j.a.e;
import kotlin.reflect.jvm.internal.impl.j.a.f;
import kotlin.reflect.jvm.internal.impl.j.a.g;
import kotlin.reflect.jvm.internal.impl.j.a.i;
import kotlin.reflect.jvm.internal.impl.j.a.j;
import kotlin.reflect.jvm.internal.impl.j.a.m;
import kotlin.reflect.jvm.internal.impl.j.a.o;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ag;
import kotlin.reflect.jvm.internal.impl.j.aj;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ao;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.as;
import kotlin.reflect.jvm.internal.impl.j.au;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.ax;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.n;
import kotlin.reflect.jvm.internal.impl.j.q;
import kotlin.reflect.jvm.internal.impl.j.t;
import kotlin.reflect.jvm.internal.impl.j.v;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.jvm.internal.impl.j.x;
import kotlin.reflect.jvm.internal.impl.j.y;

public final class h
implements c {
    public static final h b = new h();

    private h() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final Boolean a(o object, ad ad2, ad iterator) {
        boolean bl2 = y.a(ad2);
        boolean bl3 = true;
        if (!bl2 && !y.a((w)((Object)iterator))) {
            Object object2;
            Object object3;
            if (ad2 instanceof aj || iterator instanceof aj) return true;
            if (iterator instanceof e && ((e)(object3 = (e)((Object)iterator))).e() != null) {
                object2 = ((o)object).a(ad2, (e)object3);
                switch (i.a[((Enum)object2).ordinal()]) {
                    default: {
                        break;
                    }
                    case 2: {
                        if (!this.b((o)object, (az)ad2, ((e)object3).e())) break;
                        return true;
                    }
                    case 1: {
                        bl2 = this.b((o)object, (az)ad2, ((e)object3).e());
                        do {
                            return bl2;
                            break;
                        } while (true);
                    }
                }
            }
            object3 = object2 = ((w)((Object)iterator)).g();
            if (!(object2 instanceof v)) {
                object3 = null;
            }
            if ((object3 = (v)object3) == null) return null;
            bl2 = ((w)((Object)iterator)).c();
            if (kotlin.y.a && !(bl2 ^ true)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Intersection type should not be marked nullable!: ");
                ((StringBuilder)object).append(iterator);
                throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
            }
            iterator = ((v)object3).k_();
            kotlin.e.b.j.a((Object)iterator, "it.supertypes");
            iterator = (Iterable)((Object)iterator);
            if (iterator instanceof Collection && ((Collection)((Object)iterator)).isEmpty()) {
                bl2 = bl3;
                return bl2;
            } else {
                iterator = iterator.iterator();
                do {
                    bl2 = bl3;
                    if (!iterator.hasNext()) return bl2;
                } while (b.b((o)object, (az)ad2, ((w)(object3 = (w)iterator.next())).l()));
                bl2 = false;
            }
            return bl2;
        }
        if (((o)object).b()) {
            return true;
        }
        if (ad2.c() && !((w)((Object)iterator)).c()) {
            return false;
        }
        bl2 = m.a.a(ad2.a(false), ((ad)((Object)iterator)).a(false));
        return bl2;
    }

    private final List<ad> a(List<? extends ad> collection) {
        if (collection.size() < 2) {
            return collection;
        }
        Object object = collection;
        Collection collection2 = new ArrayList();
        object = object.iterator();
        do {
            boolean bl2;
            Object e2;
            block6 : {
                boolean bl3 = object.hasNext();
                boolean bl4 = true;
                if (!bl3) break;
                e2 = object.next();
                Object object2 = ((ad)e2).a();
                if (object2 instanceof Collection && ((Collection)object2).isEmpty()) {
                    bl2 = bl4;
                } else {
                    w w2;
                    object2 = object2.iterator();
                    do {
                        bl2 = bl4;
                        if (!object2.hasNext()) break block6;
                        w2 = ((ap)object2.next()).c();
                        kotlin.e.b.j.a((Object)w2, "it.type");
                    } while (t.a(w2) ^ true);
                    bl2 = false;
                }
            }
            if (!bl2) continue;
            collection2.add(e2);
        } while (true);
        if ((collection2 = (List)collection2).isEmpty() ^ true) {
            collection = collection2;
        }
        return collection;
    }

    private final boolean a(kotlin.reflect.jvm.internal.impl.a.e e2) {
        return kotlin.reflect.jvm.internal.impl.a.x.a(e2) && e2.l() != kotlin.reflect.jvm.internal.impl.a.f.d && e2.l() != kotlin.reflect.jvm.internal.impl.a.f.e;
    }

    private final boolean a(o object, List<? extends ap> list, ad ad2) {
        if (list == ad2.a()) {
            return true;
        }
        List<kotlin.reflect.jvm.internal.impl.a.as> list2 = ad2.g().b();
        kotlin.e.b.j.a(list2, "parameters");
        int n2 = ((Collection)list2).size();
        for (int i2 = 0; i2 < n2; ++i2) {
            Object object2 = ad2.a().get(i2);
            if (object2.a()) continue;
            az az2 = object2.c().l();
            Object object3 = list.get(i2);
            boolean bl2 = object3.b() == ba.a;
            if (kotlin.y.a && !bl2) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Incorrect sub argument: ");
                ((StringBuilder)object).append(object3);
                throw (Throwable)((Object)new AssertionError((Object)((StringBuilder)object).toString()));
            }
            object3 = object3.c().l();
            Object object4 = list2.get(i2);
            kotlin.e.b.j.a(object4, "parameters[index]");
            object4 = object4.k();
            kotlin.e.b.j.a(object4, "parameters[index].variance");
            object2 = object2.b();
            kotlin.e.b.j.a(object2, "superProjection.projectionKind");
            object2 = this.a((ba)((Object)object4), (ba)((Object)object2));
            if (object2 != null) {
                if (o.a((o)object) <= 100) {
                    boolean bl3;
                    o.a((o)object, o.a((o)object) + 1);
                    switch (i.c[((Enum)object2).ordinal()]) {
                        default: {
                            throw new kotlin.m();
                        }
                        case 3: {
                            bl3 = b.b((o)object, az2, (az)object3);
                            break;
                        }
                        case 2: {
                            bl3 = b.b((o)object, (az)object3, az2);
                            break;
                        }
                        case 1: {
                            bl3 = b.a((o)object, (az)object3, az2);
                        }
                    }
                    o.a((o)object, o.a((o)object) - 1);
                    if (bl3) continue;
                    return false;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Arguments depth is too high. Some related argument: ");
                ((StringBuilder)object).append(object3);
                throw (Throwable)new IllegalStateException(((StringBuilder)object).toString().toString());
            }
            return ((o)object).b();
        }
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private final boolean a(o var1_1, ad var2_2) {
        if (KotlinBuiltIns.isNothingOrNullableNothing(var2_2)) {
            return true;
        }
        o.b((o)var1_1);
        var5_3 = o.c((o)var1_1);
        if (var5_3 == null) {
            kotlin.e.b.j.a();
        }
        if ((var4_4 = o.d((o)var1_1)) == null) {
            kotlin.e.b.j.a();
        }
        var5_3.push(var2_2);
        block0 : do lbl-1000: // 4 sources:
        {
            if (!(((Collection)var5_3).isEmpty() ^ true)) {
                o.e((o)var1_1);
                return false;
            }
            if (var4_4.size() > 1000) {
                var1_1 = new StringBuilder();
                var1_1.append("Too many supertypes for type: ");
                var1_1.append(var2_2);
                var1_1.append(". Supertypes = ");
                var1_1.append(kotlin.a.m.a(var4_4, null, null, null, 0, null, null, 63, null));
                throw (Throwable)new IllegalStateException(var1_1.toString().toString());
            }
            var6_6 = (ad)var5_3.pop();
            kotlin.e.b.j.a(var6_6, "current");
            if (!var4_4.add(var6_6)) ** GOTO lbl-1000
            var3_5 = j.a((ad)var6_6) != false ? o.c.c.a : o.c.a.a;
            if (!(kotlin.e.b.j.a((Object)(var3_5 = (o.c)var3_5), (Object)o.c.c.a) ^ true)) {
                var3_5 = null;
            }
            if (var3_5 == null) ** GOTO lbl-1000
            var6_6 = var6_6.g().k_().iterator();
            do {
                if (!var6_6.hasNext()) continue block0;
                var7_7 = (w)var6_6.next();
                kotlin.e.b.j.a((Object)var7_7, "supertype");
                var7_7 = var3_5.a(var7_7);
                if (KotlinBuiltIns.isNothingOrNullableNothing(var7_7)) {
                    o.e((o)var1_1);
                    return true;
                }
                var5_3.add(var7_7);
            } while (true);
            break;
        } while (true);
    }

    private final boolean a(w w2) {
        return t.c(w2).c() != t.d(w2).c();
    }

    private final List<ad> b(o o2, ad ad2, an an2) {
        return this.a(this.c(o2, ad2, an2));
    }

    /*
     * Exception decompiling
     */
    private final boolean b(o var1_1, ad var2_2, ad var3_3) {
        // This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
        // org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [1[CASE]], but top level block is 4[SWITCH]
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:432)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
        // org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:607)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:692)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:182)
        // org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:127)
        // org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:96)
        // org.benf.cfr.reader.entities.Method.analyse(Method.java:396)
        // org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:890)
        // org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:792)
        // org.benf.cfr.reader.Driver.doJar(Driver.java:128)
        // org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:63)
        // org.benf.cfr.reader.Main.main(Main.java:48)
        throw new IllegalStateException("Decompilation failed");
    }

    private final boolean b(w w2) {
        return w2.g().f() && !n.a(w2) && !ag.c(w2) && kotlin.e.b.j.a((Object)t.c(w2).g(), (Object)t.d(w2).g());
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private final List<ad> c(o var1_1, ad var2_2, an var3_3) {
        var4_5 = var5_4 = var3_3.d();
        if (!(var5_4 instanceof kotlin.reflect.jvm.internal.impl.a.e)) {
            var4_5 = null;
        }
        if ((var4_5 = (kotlin.reflect.jvm.internal.impl.a.e)var4_5) != null && this.a((kotlin.reflect.jvm.internal.impl.a.e)var4_5)) {
            if (var1_1.a(var2_2.g(), var3_3) == false) return kotlin.a.m.a();
            var1_1 = g.a((ad)var2_2, a.a, null, 4, null);
            if (var1_1 == null) return kotlin.a.m.a(var2_2);
            var2_2 = var1_1;
            return kotlin.a.m.a(var2_2);
        }
        var7_6 = new kotlin.reflect.jvm.internal.impl.l.i();
        o.b((o)var1_1);
        var8_7 = o.c((o)var1_1);
        if (var8_7 == null) {
            kotlin.e.b.j.a();
        }
        if ((var6_8 = o.d((o)var1_1)) == null) {
            kotlin.e.b.j.a();
        }
        var8_7.push(var2_2);
        block0 : do lbl-1000: // 4 sources:
        {
            block12 : {
                if (!(((Collection)var8_7).isEmpty() ^ true)) {
                    o.e((o)var1_1);
                    return var7_6;
                }
                if (var6_8.size() > 1000) {
                    var1_1 = new StringBuilder();
                    var1_1.append("Too many supertypes for type: ");
                    var1_1.append(var2_2);
                    var1_1.append(". Supertypes = ");
                    var1_1.append(kotlin.a.m.a(var6_8, null, null, null, 0, null, null, 63, null));
                    throw (Throwable)new IllegalStateException(var1_1.toString().toString());
                }
                var5_4 = (ad)var8_7.pop();
                kotlin.e.b.j.a(var5_4, "current");
                if (!var6_8.add(var5_4)) ** GOTO lbl-1000
                var4_5 = g.a((ad)var5_4, a.a, null, 4, null);
                if (var4_5 == null) {
                    var4_5 = var5_4;
                }
                if (!var1_1.a(var4_5.g(), var3_3)) break block12;
                var7_6.add(var4_5);
                var4_5 = o.c.c.a;
                ** GOTO lbl42
            }
            if (var4_5.a().isEmpty()) {
                var4_5 = o.c.a.a;
lbl42: // 2 sources:
                var4_5 = (o.c)var4_5;
            } else {
                var4_5 = new o.c.b(ao.b.a((w)var4_5).f());
            }
            if (!(kotlin.e.b.j.a(var4_5, (Object)o.c.c.a) ^ true)) {
                var4_5 = null;
            }
            if (var4_5 == null) ** GOTO lbl-1000
            var5_4 = var5_4.g().k_().iterator();
            do {
                if (!var5_4.hasNext()) continue block0;
                var9_9 = (w)var5_4.next();
                kotlin.e.b.j.a((Object)var9_9, "supertype");
                var8_7.add(var4_5.a(var9_9));
            } while (true);
            break;
        } while (true);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final List<ad> a(o object, ad object2, an an2) {
        Object object3;
        Object object4;
        kotlin.e.b.j.b(object, "$receiver");
        kotlin.e.b.j.b(object2, "baseType");
        kotlin.e.b.j.b(an2, "constructor");
        if (j.a((ad)object2)) {
            return this.b((o)object, (ad)object2, an2);
        }
        if (!(an2.d() instanceof kotlin.reflect.jvm.internal.impl.a.e)) {
            return this.c((o)object, (ad)object2, an2);
        }
        Object object5 = new kotlin.reflect.jvm.internal.impl.l.i();
        o.b((o)object);
        ArrayDeque arrayDeque = o.c((o)object);
        if (arrayDeque == null) {
            kotlin.e.b.j.a();
        }
        if ((object4 = o.d((o)object)) == null) {
            kotlin.e.b.j.a();
        }
        arrayDeque.push(object2);
        while (((Collection)arrayDeque).isEmpty() ^ true) {
            if (object4.size() > 1000) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Too many supertypes for type: ");
                ((StringBuilder)object).append(object2);
                ((StringBuilder)object).append(". Supertypes = ");
                ((StringBuilder)object).append(kotlin.a.m.a((Iterable)object4, null, null, null, 0, null, null, 63, null));
                throw (Throwable)new IllegalStateException(((StringBuilder)object).toString().toString());
            }
            ad ad2 = (ad)arrayDeque.pop();
            kotlin.e.b.j.a((Object)ad2, "current");
            if (!object4.add(ad2)) continue;
            if (j.a(ad2)) {
                ((kotlin.reflect.jvm.internal.impl.l.i)object5).add(ad2);
                object3 = o.c.c.a;
            } else {
                object3 = o.c.a.a;
            }
            object3 = (o.c)object3;
            if (!(kotlin.e.b.j.a(object3, (Object)o.c.c.a) ^ true)) {
                object3 = null;
            }
            if (object3 == null) continue;
            for (w w2 : ad2.g().k_()) {
                kotlin.e.b.j.a((Object)w2, "supertype");
                arrayDeque.add(((o.c)object3).a(w2));
            }
        }
        o.e((o)object);
        object3 = (Iterable)object5;
        object2 = new ArrayList();
        object3 = object3.iterator();
        while (object3.hasNext()) {
            object4 = (ad)object3.next();
            object5 = b;
            kotlin.e.b.j.a(object4, "it");
            kotlin.a.m.a(object2, (Iterable)h.super.b((o)object, (ad)object4, an2));
        }
        return (List)object2;
    }

    public final ad a(ad object) {
        kotlin.e.b.j.b(object, "type");
        Object object2 = ((w)object).g();
        boolean bl2 = object2 instanceof b;
        boolean bl3 = false;
        if (bl2) {
            b b2 = (b)object2;
            object2 = b2.h();
            if (object2.b() == ba.b) {
                bl3 = true;
            }
            Object object3 = null;
            if (!bl3) {
                object2 = null;
            }
            Object object4 = object3;
            if (object2 != null) {
                object2 = object2.c();
                object4 = object3;
                if (object2 != null) {
                    object4 = ((w)object2).l();
                }
            }
            if (b2.a() == null) {
                object2 = b2.h();
                Object object5 = b2.k_();
                object3 = new ArrayList(kotlin.a.m.a(object5, 10));
                object5 = object5.iterator();
                while (object5.hasNext()) {
                    object3.add(((w)object5.next()).l());
                }
                b2.a(new f((ap)object2, (List)object3));
            }
            object2 = a.a;
            object3 = b2.a();
            if (object3 == null) {
                kotlin.e.b.j.a();
            }
            return new e((a)((Object)object2), (f)object3, (az)object4, object.x(), ((w)object).c());
        }
        if (object2 instanceof kotlin.reflect.jvm.internal.impl.h.b.n) {
            object2 = ((kotlin.reflect.jvm.internal.impl.h.b.n)object2).k_();
            Object object6 = new ArrayList(kotlin.a.m.a(object2, 10));
            object2 = object2.iterator();
            while (object2.hasNext()) {
                object6.add(av.a((w)object2.next(), ((w)object).c()));
            }
            object6 = new v((List)object6);
            return x.a(object.x(), (an)object6, kotlin.a.m.a(), false, ((w)object).b());
        }
        Object object7 = object;
        if (object2 instanceof v) {
            object7 = object;
            if (((w)object).c()) {
                Object object8;
                object7 = ((v)object2).k_();
                kotlin.e.b.j.a(object7, "constructor.supertypes");
                object2 = (Iterable)object7;
                object7 = new ArrayList(kotlin.a.m.a(object2, 10));
                object2 = object2.iterator();
                while (object2.hasNext()) {
                    object8 = (w)object2.next();
                    kotlin.e.b.j.a(object8, "it");
                    object7.add(kotlin.reflect.jvm.internal.impl.j.c.a.b((w)object8));
                }
                object7 = new v((List)object7);
                object = object.x();
                object2 = (an)object7;
                object8 = kotlin.a.m.a();
                object7 = ((v)object7).a();
                kotlin.e.b.j.a(object7, "newConstructor.createScopeForKotlinType()");
                object7 = x.a((kotlin.reflect.jvm.internal.impl.a.a.h)object, (an)object2, (List<? extends ap>)object8, false, (kotlin.reflect.jvm.internal.impl.h.e.h)object7);
            }
        }
        return object7;
    }

    public final az a(az az2) {
        block3 : {
            az az3;
            block2 : {
                block1 : {
                    kotlin.e.b.j.b(az2, "type");
                    if (!(az2 instanceof ad)) break block1;
                    az3 = this.a((ad)az2);
                    break block2;
                }
                if (az2 instanceof q) {
                    az3 = (q)az2;
                    ad ad2 = this.a(((q)az3).f());
                    ad ad3 = this.a(((q)az3).h());
                    az3 = ad2 == ((q)az3).f() && ad3 == ((q)az3).h() ? az2 : x.a(ad2, ad3);
                }
                break block3;
            }
            return ax.a(az3, az2);
        }
        throw new kotlin.m();
    }

    public final ba a(ba ba2, ba ba3) {
        kotlin.e.b.j.b((Object)ba2, "declared");
        kotlin.e.b.j.b((Object)ba3, "useSite");
        if (ba2 == ba.a) {
            return ba3;
        }
        if (ba3 == ba.a) {
            return ba2;
        }
        if (ba2 == ba3) {
            return ba2;
        }
        return null;
    }

    public final boolean a(o o2, az az2, az az3) {
        w w2;
        kotlin.e.b.j.b(o2, "$receiver");
        kotlin.e.b.j.b(az2, "a");
        kotlin.e.b.j.b(az3, "b");
        boolean bl2 = true;
        if (az2 == az3) {
            return true;
        }
        w w3 = az2;
        if (this.b(w3) && this.b(w2 = (w)az3)) {
            if (!o2.a(az2.g(), az3.g())) {
                return false;
            }
            if (az2.a().isEmpty()) {
                if (!this.a(w3)) {
                    if (this.a(w2)) {
                        return true;
                    }
                    if (az2.c() == az3.c()) {
                        return true;
                    }
                    bl2 = false;
                }
                return bl2;
            }
        }
        return this.b(o2, az2, az3) && this.b(o2, az3, az2);
    }

    @Override
    public boolean a(w w2, w w3) {
        kotlin.e.b.j.b(w2, "subtype");
        kotlin.e.b.j.b(w3, "supertype");
        return this.b(new o(true, false, 2, null), w2.l(), w3.l());
    }

    public final boolean b(o o2, az object, az w2) {
        kotlin.e.b.j.b(o2, "$receiver");
        kotlin.e.b.j.b(object, "subType");
        kotlin.e.b.j.b(w2, "superType");
        if (object == w2) {
            return true;
        }
        object = this.a((az)object);
        az az2 = this.a((az)w2);
        w2 = (w)object;
        Object object2 = t.c(w2);
        w w3 = az2;
        if ((object2 = this.a(o2, (ad)object2, t.d(w3))) != null) {
            boolean bl2 = (Boolean)object2;
            o2.a((az)object, az2);
            return bl2;
        }
        if ((object = o2.a((az)object, az2)) != null) {
            return (Boolean)object;
        }
        return this.b(o2, t.c(w2), t.d(w3));
    }

    @Override
    public boolean b(w w2, w w3) {
        kotlin.e.b.j.b(w2, "a");
        kotlin.e.b.j.b(w3, "b");
        return this.a(new o(false, false, 2, null), w2.l(), w3.l());
    }
}

