/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.g;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.al;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.reflect.jvm.internal.impl.a.aa;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ae;
import kotlin.reflect.jvm.internal.impl.a.ah;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.aj;
import kotlin.reflect.jvm.internal.impl.a.ak;
import kotlin.reflect.jvm.internal.impl.a.ao;
import kotlin.reflect.jvm.internal.impl.a.ar;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.a.at;
import kotlin.reflect.jvm.internal.impl.a.ax;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.p;
import kotlin.reflect.jvm.internal.impl.a.v;
import kotlin.reflect.jvm.internal.impl.builtins.FunctionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.g.c;
import kotlin.reflect.jvm.internal.impl.g.g;
import kotlin.reflect.jvm.internal.impl.g.h;
import kotlin.reflect.jvm.internal.impl.g.i;
import kotlin.reflect.jvm.internal.impl.g.m;
import kotlin.reflect.jvm.internal.impl.g.n;
import kotlin.reflect.jvm.internal.impl.g.o;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.ag;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.ay;
import kotlin.reflect.jvm.internal.impl.j.az;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.bb;
import kotlin.reflect.jvm.internal.impl.j.p;
import kotlin.reflect.jvm.internal.impl.j.q;
import kotlin.reflect.l;
import kotlin.t;
import kotlin.w;
import kotlin.y;

public final class e
extends kotlin.reflect.jvm.internal.impl.g.c
implements h {
    static final /* synthetic */ l[] k;
    private final kotlin.g l;
    private final kotlin.g m;
    private final i n;

    static {
        k = new l[]{kotlin.e.b.v.a(new kotlin.e.b.t(kotlin.e.b.v.a(e.class), "functionTypeAnnotationsRenderer", "getFunctionTypeAnnotationsRenderer()Lorg/jetbrains/kotlin/renderer/DescriptorRendererImpl;")), kotlin.e.b.v.a(new kotlin.e.b.t(kotlin.e.b.v.a(e.class), "functionTypeParameterTypesRenderer", "getFunctionTypeParameterTypesRenderer()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer;"))};
    }

    public e(i i2) {
        j.b(i2, "options");
        this.n = i2;
        boolean bl2 = this.n.a();
        if (y.a && !bl2) {
            throw (Throwable)((Object)new AssertionError((Object)"Assertion failed"));
        }
        this.l = kotlin.h.a((kotlin.e.a.a)new kotlin.e.a.a<e>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final e b() {
                kotlin.reflect.jvm.internal.impl.g.c c2 = this.a(1.a);
                if (c2 != null) {
                    return (e)c2;
                }
                throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.renderer.DescriptorRendererImpl");
            }

        });
        this.m = kotlin.h.a((kotlin.e.a.a)new kotlin.e.a.a<kotlin.reflect.jvm.internal.impl.g.c>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final kotlin.reflect.jvm.internal.impl.g.c b() {
                return this.a(1.a);
            }

        });
    }

    private final e S() {
        kotlin.g g2 = this.l;
        l l2 = k[0];
        return (e)g2.a();
    }

    private final kotlin.reflect.jvm.internal.impl.g.c T() {
        kotlin.g g2 = this.m;
        l l2 = k[1];
        return (kotlin.reflect.jvm.internal.impl.g.c)g2.a();
    }

    private final String U() {
        return this.d("<");
    }

    private final String V() {
        return this.d(">");
    }

    private final String W() {
        n n2 = this.H();
        switch (kotlin.reflect.jvm.internal.impl.g.f.c[n2.ordinal()]) {
            default: {
                throw new kotlin.m();
            }
            case 2: {
                return "&rarr;";
            }
            case 1: 
        }
        return this.d("->");
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final String a(String charSequence, String string2, String charSequence2, String string3, String string4) {
        if (!kotlin.i.n.a((String)charSequence, string2, false, 2, null) || !kotlin.i.n.a((String)charSequence2, string3, false, 2, null)) return null;
        int n2 = string2.length();
        if (charSequence == null) throw new t("null cannot be cast to non-null type java.lang.String");
        charSequence = ((String)charSequence).substring(n2);
        j.a((Object)charSequence, "(this as java.lang.String).substring(startIndex)");
        n2 = string3.length();
        if (charSequence2 == null) throw new t("null cannot be cast to non-null type java.lang.String");
        string2 = ((String)charSequence2).substring(n2);
        j.a((Object)string2, "(this as java.lang.String).substring(startIndex)");
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append(string4);
        ((StringBuilder)charSequence2).append((String)charSequence);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        if (j.a((Object)charSequence, (Object)string2)) {
            return charSequence2;
        }
        if (!this.a((String)charSequence, string2)) return null;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append("!");
        return ((StringBuilder)charSequence).toString();
    }

    private final String a(kotlin.reflect.jvm.internal.impl.h.b.f<?> f2) {
        if (f2 instanceof kotlin.reflect.jvm.internal.impl.h.b.b) {
            return kotlin.a.m.a((Iterable)((kotlin.reflect.jvm.internal.impl.h.b.b)f2).a(), ", ", "{", "}", 0, null, new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.h.b.f<?>, String>(){

                @Override
                public final String a(kotlin.reflect.jvm.internal.impl.h.b.f<?> f2) {
                    j.b(f2, "it");
                    return this.a(f2);
                }
            }, 24, null);
        }
        if (f2 instanceof kotlin.reflect.jvm.internal.impl.h.b.a) {
            return kotlin.i.n.a(kotlin.reflect.jvm.internal.impl.g.c.a(this, (kotlin.reflect.jvm.internal.impl.a.a.c)((kotlin.reflect.jvm.internal.impl.h.b.a)f2).a(), null, 2, null), "@");
        }
        if (f2 instanceof kotlin.reflect.jvm.internal.impl.h.b.o) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a(((kotlin.reflect.jvm.internal.impl.h.b.o)f2).b()));
            stringBuilder.append("::class");
            return stringBuilder.toString();
        }
        return f2.toString();
    }

    private final List<String> a(kotlin.reflect.jvm.internal.impl.a.a.c object) {
        Object object2;
        Object object3;
        Object object4 = object.c();
        boolean bl2 = this.B();
        Object object5 = null;
        Object object6 = bl2 ? kotlin.reflect.jvm.internal.impl.h.c.a.a((kotlin.reflect.jvm.internal.impl.a.a.c)object) : null;
        object = object5;
        if (object6 != null) {
            object6 = object6.o();
            object = object5;
            if (object6 != null) {
                object6 = object6.i();
                object = object5;
                if (object6 != null) {
                    object6 = (Iterable)object6;
                    object = new ArrayList();
                    object6 = object6.iterator();
                    while (object6.hasNext()) {
                        object5 = object6.next();
                        if (!((kotlin.reflect.jvm.internal.impl.a.av)object5).l()) continue;
                        object.add(object5);
                    }
                    object6 = (List)object;
                    object = new ArrayList(kotlin.a.m.a(object6, 10));
                    object6 = object6.iterator();
                    while (object6.hasNext()) {
                        object5 = (kotlin.reflect.jvm.internal.impl.a.av)object6.next();
                        j.a(object5, "it");
                        object.add(object5.h_());
                    }
                    object = (List)object;
                }
            }
        }
        if (object == null) {
            object = kotlin.a.m.a();
        }
        object5 = (Iterable)object;
        object6 = new ArrayList();
        object5 = object5.iterator();
        while (object5.hasNext()) {
            object3 = object5.next();
            if (!(object4.containsKey((kotlin.reflect.jvm.internal.impl.e.f)object3) ^ true)) continue;
            object6.add(object3);
        }
        object5 = (List)object6;
        object6 = new ArrayList(kotlin.a.m.a(object5, 10));
        object5 = object5.iterator();
        while (object5.hasNext()) {
            object3 = (kotlin.reflect.jvm.internal.impl.e.f)object5.next();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(((kotlin.reflect.jvm.internal.impl.e.f)object3).a());
            ((StringBuilder)object2).append(" = ...");
            object6.add((String)((StringBuilder)object2).toString());
        }
        object5 = (List)object6;
        object6 = object4.entrySet();
        object4 = new ArrayList(kotlin.a.m.a(object6, 10));
        object3 = object6.iterator();
        while (object3.hasNext()) {
            object2 = (Map.Entry)object3.next();
            object6 = (kotlin.reflect.jvm.internal.impl.e.f)object2.getKey();
            kotlin.reflect.jvm.internal.impl.h.b.f f2 = (kotlin.reflect.jvm.internal.impl.h.b.f)object2.getValue();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(((kotlin.reflect.jvm.internal.impl.e.f)object6).a());
            ((StringBuilder)object2).append(" = ");
            object6 = !object.contains(object6) ? this.a(f2) : "...";
            ((StringBuilder)object2).append((String)object6);
            object4.add(((StringBuilder)object2).toString());
        }
        object = (List)object4;
        return kotlin.a.m.j(kotlin.a.m.b((Collection)object5, (Iterable)object));
    }

    private final void a(StringBuilder stringBuilder) {
        int n2 = stringBuilder.length();
        if (n2 == 0 || stringBuilder.charAt(n2 - 1) != ' ') {
            stringBuilder.append(' ');
        }
    }

    private final void a(StringBuilder stringBuilder, List<? extends ap> list) {
        kotlin.a.m.a(list, stringBuilder, ", ", null, null, 0, null, new kotlin.e.a.b<ap, CharSequence>(){

            @Override
            public final CharSequence a(ap object) {
                j.b(object, "it");
                if (object.a()) {
                    return "*";
                }
                Object object2 = this;
                Object object3 = object.c();
                j.a(object3, "it.type");
                object2 = ((e)object2).a((kotlin.reflect.jvm.internal.impl.j.w)object3);
                if (object.b() == ba.a) {
                    object = object2;
                } else {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append((Object)object.b());
                    ((StringBuilder)object3).append(' ');
                    ((StringBuilder)object3).append((String)object2);
                    object = ((StringBuilder)object3).toString();
                }
                return (CharSequence)object;
            }
        }, 60, null);
    }

    private final void a(StringBuilder stringBuilder, kotlin.reflect.jvm.internal.impl.a.a.a object) {
        if (!this.r().contains((Object)g.d)) {
            return;
        }
        Set<kotlin.reflect.jvm.internal.impl.e.b> set = object instanceof kotlin.reflect.jvm.internal.impl.j.w ? this.m() : this.l();
        kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.a.a.c, Boolean> b2 = this.d();
        for (Object object2 : object.x().c()) {
            kotlin.reflect.jvm.internal.impl.a.a.c c2 = object2.c();
            object2 = object2.d();
            if (kotlin.a.m.a((Iterable)set, c2.b()) || b2 != null && !b2.a(c2).booleanValue()) continue;
            stringBuilder.append(this.a(c2, (kotlin.reflect.jvm.internal.impl.a.a.e)((Object)object2)));
            if (this.j()) {
                kotlin.i.n.a(stringBuilder);
                continue;
            }
            stringBuilder.append(" ");
        }
    }

    private final void a(StringBuilder stringBuilder, kotlin.reflect.jvm.internal.impl.a.ag ag2) {
        block3 : {
            Object object;
            block2 : {
                object = ag2.c();
                if (object == null) break block2;
                this.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.a.ag)object);
                stringBuilder.append('.');
                object = ag2.a().h_();
                j.a(object, "possiblyInnerType.classifierDescriptor.name");
                stringBuilder.append(this.a((kotlin.reflect.jvm.internal.impl.e.f)object, false));
                if (stringBuilder != null) break block3;
            }
            object = ag2.a().e();
            j.a(object, "possiblyInnerType.classi\u2026escriptor.typeConstructor");
            stringBuilder.append(this.a((an)object));
        }
        stringBuilder.append(this.a(ag2.b()));
    }

    private final void a(StringBuilder stringBuilder, kotlin.reflect.jvm.internal.impl.a.m object) {
        if (!(object instanceof ab)) {
            if (object instanceof ae) {
                return;
            }
            if (object instanceof kotlin.reflect.jvm.internal.impl.a.y) {
                stringBuilder.append(" is a module");
                return;
            }
            kotlin.reflect.jvm.internal.impl.a.m m2 = object.b();
            if (m2 != null && !(m2 instanceof kotlin.reflect.jvm.internal.impl.a.y)) {
                stringBuilder.append(" ");
                stringBuilder.append(this.a("defined in"));
                stringBuilder.append(" ");
                Object object2 = kotlin.reflect.jvm.internal.impl.h.c.d(m2);
                j.a(object2, "fqName");
                object2 = ((kotlin.reflect.jvm.internal.impl.e.c)object2).d() ? "root package" : this.a((kotlin.reflect.jvm.internal.impl.e.c)object2);
                stringBuilder.append((String)object2);
                if (this.O() && m2 instanceof ab && object instanceof p) {
                    object = ((p)object).y();
                    j.a(object, "descriptor.source");
                    object = object.a();
                    j.a(object, "descriptor.source.containingFile");
                    object = object.a();
                    if (object != null) {
                        stringBuilder.append(" ");
                        stringBuilder.append(this.a("in file"));
                        stringBuilder.append(" ");
                        stringBuilder.append((String)object);
                    }
                }
            }
        }
    }

    private final void a(StringBuilder stringBuilder, kotlin.reflect.jvm.internal.impl.j.a a2) {
        if (this.H() == n.b) {
            stringBuilder.append("<font color=\"808080\"><i>");
        }
        stringBuilder.append(" /* = ");
        this.b(stringBuilder, a2.e());
        stringBuilder.append(" */");
        if (this.H() == n.b) {
            stringBuilder.append("</i></font>");
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final void a(StringBuilder stringBuilder, ad object) {
        kotlin.reflect.jvm.internal.impl.j.w w2;
        if (!j.a(object, (Object)av.b) && !av.b(w2 = (kotlin.reflect.jvm.internal.impl.j.w)object)) {
            if (kotlin.reflect.jvm.internal.impl.j.p.a(w2)) {
                if (this.J()) {
                    if ((object = ((kotlin.reflect.jvm.internal.impl.j.w)object).g()) == null) throw new t("null cannot be cast to non-null type org.jetbrains.kotlin.types.ErrorUtils.UninferredParameterTypeConstructor");
                    object = ((p.d)object).a();
                    j.a(object, "(type.constructor as Uni\u2026).typeParameterDescriptor");
                    object = object.h_().toString();
                    j.a(object, "(type.constructor as Uni\u2026escriptor.name.toString()");
                    object = this.c((String)object);
                } else {
                    object = "???";
                }
                stringBuilder.append((String)object);
                return;
            }
            if (kotlin.reflect.jvm.internal.impl.j.y.a(w2)) {
                this.c(stringBuilder, w2);
                return;
            }
            if (this.b(w2)) {
                this.d(stringBuilder, w2);
                return;
            }
            this.c(stringBuilder, w2);
            return;
        }
        stringBuilder.append("???");
    }

    private final void a(StringBuilder stringBuilder, kotlin.reflect.jvm.internal.impl.j.w w2) {
        az az2;
        az az3 = az2 = w2.l();
        if (!(az2 instanceof kotlin.reflect.jvm.internal.impl.j.a)) {
            az3 = null;
        }
        if ((az3 = (kotlin.reflect.jvm.internal.impl.j.a)az3) != null) {
            this.b(stringBuilder, ((kotlin.reflect.jvm.internal.impl.j.a)az3).f());
            if (this.D()) {
                this.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.j.a)az3);
            }
            return;
        }
        this.b(stringBuilder, w2);
    }

    private final void a(StringBuilder stringBuilder, kotlin.reflect.jvm.internal.impl.j.w w2, an an2) {
        kotlin.reflect.jvm.internal.impl.a.ag ag2 = at.a(w2);
        if (ag2 == null) {
            stringBuilder.append(this.a(an2));
            stringBuilder.append(this.a(w2.a()));
            return;
        }
        this.a(stringBuilder, ag2);
    }

    private final void a(StringBuilder stringBuilder, boolean bl2, String string2) {
        if (bl2) {
            stringBuilder.append(this.b(string2));
            stringBuilder.append(" ");
        }
    }

    private final void a(Collection<? extends kotlin.reflect.jvm.internal.impl.a.av> object, boolean bl2, StringBuilder stringBuilder) {
        bl2 = this.i(bl2);
        int n2 = object.size();
        this.L().a(n2, stringBuilder);
        object = ((Iterable)object).iterator();
        int n3 = 0;
        while (object.hasNext()) {
            kotlin.reflect.jvm.internal.impl.a.av av2 = (kotlin.reflect.jvm.internal.impl.a.av)object.next();
            this.L().a(av2, n3, n2, stringBuilder);
            this.a(av2, bl2, stringBuilder, false);
            this.L().b(av2, n3, n2, stringBuilder);
            ++n3;
        }
        this.L().b(n2, stringBuilder);
    }

    private final void a(List<? extends as> object, StringBuilder stringBuilder) {
        if (this.R()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        object = object.iterator();
        while (object.hasNext()) {
            Object object2 = (as)object.next();
            List<kotlin.reflect.jvm.internal.impl.j.w> list = object2.j();
            j.a(list, "typeParameter.upperBounds");
            for (Object object3 : (Iterable)kotlin.a.m.b((Iterable)list, 1)) {
                Collection collection = arrayList;
                object3 = (kotlin.reflect.jvm.internal.impl.j.w)object3;
                StringBuilder stringBuilder2 = new StringBuilder();
                kotlin.reflect.jvm.internal.impl.e.f f2 = object2.h_();
                j.a((Object)f2, "typeParameter.name");
                stringBuilder2.append(this.a(f2, false));
                stringBuilder2.append(" : ");
                j.a(object3, "it");
                stringBuilder2.append(this.a((kotlin.reflect.jvm.internal.impl.j.w)object3));
                collection.add(stringBuilder2.toString());
            }
            object2 = arrayList;
        }
        if (!arrayList.isEmpty()) {
            stringBuilder.append(" ");
            stringBuilder.append(this.b("where"));
            stringBuilder.append(" ");
            kotlin.a.m.a(arrayList, stringBuilder, ", ", null, null, 0, null, null, 124, null);
        }
    }

    private final void a(List<? extends as> list, StringBuilder stringBuilder, boolean bl2) {
        if (this.R()) {
            return;
        }
        if (!list.isEmpty()) {
            stringBuilder.append(this.U());
            this.b(stringBuilder, list);
            stringBuilder.append(this.V());
            if (bl2) {
                stringBuilder.append(" ");
            }
        }
    }

    private final void a(kotlin.reflect.jvm.internal.impl.a.a a2, StringBuilder stringBuilder) {
        if (!this.x()) {
            return;
        }
        if ((a2 = a2.d()) != null) {
            stringBuilder.append(" on ");
            a2 = a2.r();
            j.a((Object)a2, "receiver.type");
            stringBuilder.append(this.a((kotlin.reflect.jvm.internal.impl.j.w)a2));
        }
    }

    private final void a(ab ab2, StringBuilder stringBuilder) {
        this.a(ab2.f(), "package-fragment", stringBuilder);
        if (this.h()) {
            stringBuilder.append(" in ");
            this.a(ab2.e(), stringBuilder, false);
        }
    }

    private final void a(ae ae2, StringBuilder stringBuilder) {
        this.a(ae2.a(), "package", stringBuilder);
        if (this.h()) {
            stringBuilder.append(" in context of ");
            this.a(ae2.e(), stringBuilder, false);
        }
    }

    private final void a(ah ah2, StringBuilder stringBuilder) {
        this.a((v)ah2, stringBuilder);
    }

    private final void a(ai object, StringBuilder stringBuilder) {
        Object object2;
        if (!this.G()) {
            if (!this.F()) {
                this.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.a.a.a)object);
                object2 = object.p();
                j.a(object2, "property.visibility");
                this.a((kotlin.reflect.jvm.internal.impl.a.ba)object2, stringBuilder);
                this.a(stringBuilder, object.z(), "const");
                this.a((v)object, stringBuilder);
                object2 = (kotlin.reflect.jvm.internal.impl.a.b)object;
                this.a((kotlin.reflect.jvm.internal.impl.a.b)object2, stringBuilder);
                this.b((kotlin.reflect.jvm.internal.impl.a.b)object2, stringBuilder);
                this.a(stringBuilder, object.A(), "lateinit");
                this.c((kotlin.reflect.jvm.internal.impl.a.b)object2, stringBuilder);
            }
            this.a((ax)object, stringBuilder);
            object2 = object.f();
            j.a(object2, "property.typeParameters");
            this.a((List<? extends as>)object2, stringBuilder, true);
            this.b((kotlin.reflect.jvm.internal.impl.a.a)object, stringBuilder);
        }
        this.a((kotlin.reflect.jvm.internal.impl.a.m)object, stringBuilder, true);
        stringBuilder.append(": ");
        object2 = object.r();
        j.a(object2, "property.type");
        stringBuilder.append(this.a((kotlin.reflect.jvm.internal.impl.j.w)object2));
        this.a((kotlin.reflect.jvm.internal.impl.a.a)object, stringBuilder);
        this.b((ax)object, stringBuilder);
        object = object.f();
        j.a(object, "property.typeParameters");
        this.a((List<? extends as>)object, stringBuilder);
    }

    private final void a(ar ar2, StringBuilder stringBuilder) {
        this.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.a.a.a)ar2);
        Object object = ar2.p();
        j.a(object, "typeAlias.visibility");
        this.a((kotlin.reflect.jvm.internal.impl.a.ba)object, stringBuilder);
        this.a((v)ar2, stringBuilder);
        stringBuilder.append(this.b("typealias"));
        stringBuilder.append(" ");
        this.a(ar2, stringBuilder, true);
        object = ar2.z();
        j.a(object, "typeAlias.declaredTypeParameters");
        this.a((List<? extends as>)object, stringBuilder, false);
        this.a((kotlin.reflect.jvm.internal.impl.a.i)ar2, stringBuilder);
        stringBuilder.append(" = ");
        stringBuilder.append(this.a(ar2.a()));
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void a(as object, StringBuilder stringBuilder, boolean bl2) {
        if (bl2) {
            stringBuilder.append(this.U());
        }
        if (this.M()) {
            stringBuilder.append("/*");
            stringBuilder.append(object.g());
            stringBuilder.append("*/ ");
        }
        this.a(stringBuilder, object.l(), "reified");
        String string2 = object.k().a();
        int n2 = ((CharSequence)string2).length();
        boolean bl3 = true;
        boolean bl4 = n2 > 0;
        this.a(stringBuilder, bl4, string2);
        this.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.a.a.a)object);
        this.a((kotlin.reflect.jvm.internal.impl.a.m)object, stringBuilder, bl2);
        n2 = object.j().size();
        if (n2 > 1 && !bl2 || n2 == 1) {
            if (!KotlinBuiltIns.isDefaultBound((kotlin.reflect.jvm.internal.impl.j.w)(object = object.j().iterator().next()))) {
                stringBuilder.append(" : ");
                j.a(object, "upperBound");
                stringBuilder.append(this.a((kotlin.reflect.jvm.internal.impl.j.w)object));
            }
        } else if (bl2) {
            for (kotlin.reflect.jvm.internal.impl.j.w w2 : object.j()) {
                if (KotlinBuiltIns.isDefaultBound(w2)) continue;
                object = bl3 ? " : " : " & ";
                stringBuilder.append((String)object);
                j.a((Object)w2, "upperBound");
                stringBuilder.append(this.a(w2));
                bl3 = false;
            }
        }
        if (bl2) {
            stringBuilder.append(this.V());
        }
    }

    private final void a(kotlin.reflect.jvm.internal.impl.a.av av2, boolean bl2, StringBuilder stringBuilder, boolean bl3) {
        if (bl3) {
            stringBuilder.append(this.b("value-parameter"));
            stringBuilder.append(" ");
        }
        if (this.M()) {
            stringBuilder.append("/*");
            stringBuilder.append(av2.c());
            stringBuilder.append("*/ ");
        }
        this.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.a.a.a)av2);
        this.a(stringBuilder, av2.o(), "crossinline");
        this.a(stringBuilder, av2.q(), "noinline");
        this.a((ax)av2, bl2, stringBuilder, bl3);
        boolean bl4 = this.i() != null && (bl2 = this.h() ? av2.l() : kotlin.reflect.jvm.internal.impl.h.c.a.a(av2));
        if (bl4) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(" = ");
            kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.a.av, String> b2 = this.i();
            if (b2 == null) {
                j.a();
            }
            stringBuilder2.append(b2.a(av2));
            stringBuilder.append(stringBuilder2.toString());
        }
    }

    private final void a(ax object, StringBuilder stringBuilder) {
        if (!(object instanceof kotlin.reflect.jvm.internal.impl.a.av)) {
            object = object.s() ? "var" : "val";
            stringBuilder.append(this.b((String)object));
            stringBuilder.append(" ");
        }
    }

    private final void a(ax ax2, boolean bl2, StringBuilder stringBuilder, boolean bl3) {
        kotlin.reflect.jvm.internal.impl.a.a.a a2;
        kotlin.reflect.jvm.internal.impl.j.w w2 = ax2.r();
        kotlin.reflect.jvm.internal.impl.a.a.a a3 = !(ax2 instanceof kotlin.reflect.jvm.internal.impl.a.av) ? null : ax2;
        a3 = (kotlin.reflect.jvm.internal.impl.a.av)a3;
        if ((a3 = a3 != null ? a3.m() : null) != null) {
            a2 = a3;
        } else {
            j.a((Object)w2, "realType");
            a2 = w2;
        }
        boolean bl4 = a3 != null;
        this.a(stringBuilder, bl4, "vararg");
        if (bl3 && !this.G()) {
            this.a(ax2, stringBuilder);
        }
        if (bl2) {
            this.a(ax2, stringBuilder, bl3);
            stringBuilder.append(": ");
        }
        stringBuilder.append(this.a((kotlin.reflect.jvm.internal.impl.j.w)a2));
        this.b(ax2, stringBuilder);
        if (this.M() && a3 != null) {
            stringBuilder.append(" /*");
            j.a((Object)w2, "realType");
            stringBuilder.append(this.a(w2));
            stringBuilder.append("*/");
        }
    }

    private final void a(kotlin.reflect.jvm.internal.impl.a.b object, StringBuilder stringBuilder) {
        if (!kotlin.reflect.jvm.internal.impl.h.c.f(object) || object.m() != kotlin.reflect.jvm.internal.impl.a.w.a) {
            if (this.t() == kotlin.reflect.jvm.internal.impl.g.l.a && object.m() == kotlin.reflect.jvm.internal.impl.a.w.c && this.a((kotlin.reflect.jvm.internal.impl.a.b)object)) {
                return;
            }
            object = object.m();
            j.a(object, "callable.modality");
            this.a((kotlin.reflect.jvm.internal.impl.a.w)((Object)object), stringBuilder);
        }
    }

    private final void a(kotlin.reflect.jvm.internal.impl.a.ba ba2, StringBuilder stringBuilder) {
        if (!this.r().contains((Object)g.a)) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.a.ba ba3 = ba2;
        if (this.s()) {
            ba3 = ba2.b();
        }
        if (!this.C() && j.a((Object)ba3, (Object)kotlin.reflect.jvm.internal.impl.a.az.k)) {
            return;
        }
        stringBuilder.append(this.b(ba3.a()));
        stringBuilder.append(" ");
    }

    private final void a(kotlin.reflect.jvm.internal.impl.a.e e2, StringBuilder stringBuilder) {
        Object object;
        boolean bl2 = e2.l() == kotlin.reflect.jvm.internal.impl.a.f.d;
        if (!this.G()) {
            this.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.a.a.a)e2);
            if (!bl2) {
                object = e2.p();
                j.a(object, "klass.visibility");
                this.a((kotlin.reflect.jvm.internal.impl.a.ba)object, stringBuilder);
            }
            if (e2.l() != kotlin.reflect.jvm.internal.impl.a.f.b || e2.m() != kotlin.reflect.jvm.internal.impl.a.w.d) {
                object = e2.l();
                j.a(object, "klass.kind");
                if (!((kotlin.reflect.jvm.internal.impl.a.f)((Object)object)).a() || e2.m() != kotlin.reflect.jvm.internal.impl.a.w.a) {
                    object = e2.m();
                    j.a(object, "klass.modality");
                    this.a((kotlin.reflect.jvm.internal.impl.a.w)((Object)object), stringBuilder);
                }
            }
            this.a((v)e2, stringBuilder);
            boolean bl3 = this.r().contains((Object)g.e) && e2.r();
            this.a(stringBuilder, bl3, "inner");
            bl3 = this.r().contains((Object)g.g) && e2.s();
            this.a(stringBuilder, bl3, "data");
            bl3 = this.r().contains((Object)g.h) && e2.t();
            this.a(stringBuilder, bl3, "inline");
            this.c(e2, stringBuilder);
        }
        if (!kotlin.reflect.jvm.internal.impl.h.c.i((kotlin.reflect.jvm.internal.impl.a.m)(object = (kotlin.reflect.jvm.internal.impl.a.m)e2))) {
            if (!this.G()) {
                this.a(stringBuilder);
            }
            this.a((kotlin.reflect.jvm.internal.impl.a.m)object, stringBuilder, true);
        } else {
            this.a((kotlin.reflect.jvm.internal.impl.a.m)object, stringBuilder);
        }
        if (bl2) {
            return;
        }
        object = e2.z();
        j.a(object, "typeParameters");
        this.a((List<? extends as>)object, stringBuilder, false);
        this.a((kotlin.reflect.jvm.internal.impl.a.i)e2, stringBuilder);
        Object object2 = e2.l();
        j.a(object2, "klass.kind");
        if (!((kotlin.reflect.jvm.internal.impl.a.f)((Object)object2)).a() && this.f() && (object2 = e2.o()) != null) {
            stringBuilder.append(" ");
            this.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.a.a.a)object2);
            Object object3 = object2.p();
            j.a(object3, "primaryConstructor.visibility");
            this.a((kotlin.reflect.jvm.internal.impl.a.ba)object3, stringBuilder);
            stringBuilder.append(this.b("constructor"));
            object3 = object2.i();
            j.a(object3, "primaryConstructor.valueParameters");
            this.a((Collection)object3, object2.j(), stringBuilder);
        }
        this.b(e2, stringBuilder);
        this.a((List<? extends as>)object, stringBuilder);
    }

    private final void a(kotlin.reflect.jvm.internal.impl.a.i i2, StringBuilder stringBuilder) {
        List<as> list = i2.z();
        Object object = i2.e();
        j.a(object, "classifier.typeConstructor");
        object = object.b();
        if (this.M() && i2.r() && object.size() > list.size()) {
            stringBuilder.append(" /*captured type parameters: ");
            this.b(stringBuilder, object.subList(list.size(), object.size()));
            stringBuilder.append("*/");
        }
    }

    private final void a(kotlin.reflect.jvm.internal.impl.a.l object, StringBuilder stringBuilder) {
        this.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.a.a.a)object);
        List<kotlin.reflect.jvm.internal.impl.a.n> list = object.p();
        j.a((Object)list, "constructor.visibility");
        this.a((kotlin.reflect.jvm.internal.impl.a.ba)((Object)list), stringBuilder);
        this.c((kotlin.reflect.jvm.internal.impl.a.b)object, stringBuilder);
        if (this.A()) {
            stringBuilder.append(this.b("constructor"));
        }
        if (this.E()) {
            list = object.q();
            if (this.A()) {
                stringBuilder.append(" ");
            }
            j.a(list, "classDescriptor");
            this.a((kotlin.reflect.jvm.internal.impl.a.m)((Object)list), stringBuilder, true);
            list = object.f();
            j.a(list, "constructor.typeParameters");
            this.a(list, stringBuilder, false);
        }
        list = object.i();
        j.a(list, "constructor.valueParameters");
        this.a((Collection<? extends kotlin.reflect.jvm.internal.impl.a.av>)list, object.j(), stringBuilder);
        if (this.E()) {
            object = object.f();
            j.a(object, "constructor.typeParameters");
            this.a((List<? extends as>)object, stringBuilder);
        }
    }

    private final void a(kotlin.reflect.jvm.internal.impl.a.m object, StringBuilder stringBuilder) {
        if (this.z()) {
            if (this.G()) {
                stringBuilder.append("companion object");
            }
            this.a(stringBuilder);
            Object object2 = object.b();
            if (object2 != null) {
                stringBuilder.append("of ");
                object2 = object2.h_();
                j.a(object2, "containingDeclaration.name");
                stringBuilder.append(this.a((kotlin.reflect.jvm.internal.impl.e.f)object2, false));
            }
        }
        if (this.M() || j.a((Object)object.h_(), (Object)kotlin.reflect.jvm.internal.impl.e.h.c) ^ true) {
            if (!this.G()) {
                this.a(stringBuilder);
            }
            object = object.h_();
            j.a(object, "descriptor.name");
            stringBuilder.append(this.a((kotlin.reflect.jvm.internal.impl.e.f)object, true));
        }
    }

    private final void a(kotlin.reflect.jvm.internal.impl.a.m object, StringBuilder stringBuilder, boolean bl2) {
        object = object.h_();
        j.a(object, "descriptor.name");
        stringBuilder.append(this.a((kotlin.reflect.jvm.internal.impl.e.f)object, bl2));
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    private final void a(kotlin.reflect.jvm.internal.impl.a.t var1_1, StringBuilder var2_2) {
        block11 : {
            block12 : {
                var4_3 = var1_1.A();
                var6_4 = false;
                if (!var4_3) ** GOTO lbl-1000
                var7_5 = var1_1.k();
                j.a(var7_5, "functionDescriptor.overriddenDescriptors");
                var7_5 = (Iterable)var7_5;
                if (!(var7_5 instanceof Collection) || !var7_5.isEmpty()) {
                    var7_5 = var7_5.iterator();
                    while (var7_5.hasNext()) {
                        var8_6 = (kotlin.reflect.jvm.internal.impl.a.t)var7_5.next();
                        j.a((Object)var8_6, "it");
                        if (!var8_6.A()) continue;
                        var3_7 = false;
                        break;
                    }
                } else {
                    var3_7 = true;
                }
                if (var3_7 || this.b()) {
                    var4_3 = true;
                } else lbl-1000: // 2 sources:
                {
                    var4_3 = false;
                }
                var5_8 = var6_4;
                if (!var1_1.B()) break block11;
                var7_5 = var1_1.k();
                j.a(var7_5, "functionDescriptor.overriddenDescriptors");
                if (!(var7_5 instanceof Collection) || !((Collection)var7_5).isEmpty()) {
                    var7_5 = var7_5.iterator();
                    while (var7_5.hasNext()) {
                        var8_6 = (kotlin.reflect.jvm.internal.impl.a.t)var7_5.next();
                        j.a((Object)var8_6, "it");
                        if (!var8_6.B()) continue;
                        var3_7 = false;
                        break;
                    }
                } else {
                    var3_7 = true;
                }
                if (var3_7) break block12;
                var5_8 = var6_4;
                if (!this.b()) break block11;
            }
            var5_8 = true;
        }
        this.a(var2_2, var1_1.c(), "tailrec");
        this.b(var1_1, var2_2);
        this.a(var2_2, var1_1.a(), "inline");
        this.a(var2_2, var5_8, "infix");
        this.a(var2_2, var4_3, "operator");
    }

    private final void a(v v2, StringBuilder stringBuilder) {
        this.a(stringBuilder, v2.w(), "external");
        boolean bl2 = this.r().contains((Object)g.i);
        boolean bl3 = true;
        bl2 = bl2 && v2.u();
        this.a(stringBuilder, bl2, "expect");
        bl2 = this.r().contains((Object)g.j) && v2.v() ? bl3 : false;
        this.a(stringBuilder, bl2, "actual");
    }

    private final void a(kotlin.reflect.jvm.internal.impl.a.w object, StringBuilder stringBuilder) {
        boolean bl2 = this.r().contains((Object)g.b);
        if ((object = ((Enum)object).name()) != null) {
            object = ((String)object).toLowerCase();
            j.a(object, "(this as java.lang.String).toLowerCase()");
            this.a(stringBuilder, bl2, (String)object);
            return;
        }
        throw new t("null cannot be cast to non-null type java.lang.String");
    }

    private final void a(kotlin.reflect.jvm.internal.impl.e.b object, String string2, StringBuilder stringBuilder) {
        stringBuilder.append(this.b(string2));
        object = ((kotlin.reflect.jvm.internal.impl.e.b)object).b();
        j.a(object, "fqName.toUnsafe()");
        object = this.a((kotlin.reflect.jvm.internal.impl.e.c)object);
        boolean bl2 = ((CharSequence)object).length() > 0;
        if (bl2) {
            stringBuilder.append(" ");
            stringBuilder.append((String)object);
        }
    }

    static /* synthetic */ void a(e e2, StringBuilder stringBuilder, kotlin.reflect.jvm.internal.impl.j.w w2, an an2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            an2 = w2.g();
        }
        e2.a(stringBuilder, w2, an2);
    }

    private final boolean a(String string2, String string3) {
        boolean bl2;
        block4 : {
            block2 : {
                StringBuilder stringBuilder;
                block3 : {
                    boolean bl3 = j.a((Object)string2, (Object)kotlin.i.n.a(string3, "?", "", false, 4, null));
                    bl2 = false;
                    if (bl3) break block2;
                    if (!kotlin.i.n.b(string3, "?", false, 2, null)) break block3;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(string2);
                    stringBuilder.append('?');
                    if (j.a((Object)stringBuilder.toString(), (Object)string3)) break block2;
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append('(');
                stringBuilder.append(string2);
                stringBuilder.append(")?");
                if (!j.a((Object)stringBuilder.toString(), (Object)string3)) break block4;
            }
            bl2 = true;
        }
        return bl2;
    }

    private final boolean a(kotlin.reflect.jvm.internal.impl.a.b b2) {
        return b2.k().isEmpty() ^ true;
    }

    private final String b(String string2) {
        n n2 = this.H();
        CharSequence charSequence = string2;
        switch (kotlin.reflect.jvm.internal.impl.g.f.a[n2.ordinal()]) {
            default: {
                throw new kotlin.m();
            }
            case 2: {
                if (this.e()) {
                    return string2;
                }
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("<b>");
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append("</b>");
                charSequence = ((StringBuilder)charSequence).toString();
            }
            case 1: 
        }
        return charSequence;
    }

    private final String b(List<kotlin.reflect.jvm.internal.impl.e.f> list) {
        return this.d(o.a(list));
    }

    private final void b(StringBuilder stringBuilder, List<? extends as> object) {
        object = object.iterator();
        while (object.hasNext()) {
            this.a((as)object.next(), stringBuilder, false);
            if (!object.hasNext()) continue;
            stringBuilder.append(", ");
        }
    }

    private final void b(StringBuilder stringBuilder, kotlin.reflect.jvm.internal.impl.j.w w2) {
        if (w2 instanceof bb && this.h() && !((bb)w2).e()) {
            stringBuilder.append("<Not computed yet>");
            return;
        }
        if ((w2 = w2.l()) instanceof q) {
            stringBuilder.append(((q)w2).a(this, this));
            return;
        }
        if (w2 instanceof ad) {
            this.a(stringBuilder, (ad)w2);
        }
    }

    private final void b(kotlin.reflect.jvm.internal.impl.a.a object, StringBuilder stringBuilder) {
        if ((object = object.d()) != null) {
            kotlin.reflect.jvm.internal.impl.j.w w2 = object.r();
            j.a((Object)w2, "type");
            String string2 = this.a(w2);
            object = string2;
            if (this.b(w2)) {
                object = string2;
                if (!av.f(w2)) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append('(');
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(')');
                    object = ((StringBuilder)object).toString();
                }
            }
            stringBuilder.append((String)object);
            stringBuilder.append(".");
        }
    }

    private final void b(ax object, StringBuilder stringBuilder) {
        if (this.q() && (object = object.t()) != null) {
            stringBuilder.append(" = ");
            j.a(object, "constant");
            stringBuilder.append(this.d(this.a((kotlin.reflect.jvm.internal.impl.h.b.f<?>)object)));
        }
    }

    private final void b(kotlin.reflect.jvm.internal.impl.a.b b2, StringBuilder stringBuilder) {
        if (!this.r().contains((Object)g.c)) {
            return;
        }
        if (this.a(b2) && this.t() != kotlin.reflect.jvm.internal.impl.g.l.b) {
            this.a(stringBuilder, true, "override");
            if (this.M()) {
                stringBuilder.append("/*");
                stringBuilder.append(b2.k().size());
                stringBuilder.append("*/ ");
            }
        }
    }

    private final void b(kotlin.reflect.jvm.internal.impl.a.e collection, StringBuilder stringBuilder) {
        if (this.Q()) {
            return;
        }
        if (KotlinBuiltIns.isNothing(collection.i_())) {
            return;
        }
        collection = collection.e();
        j.a((Object)collection, "klass.typeConstructor");
        collection = collection.k_();
        if (!collection.isEmpty()) {
            if (collection.size() == 1 && KotlinBuiltIns.isAnyOrNullableAny(collection.iterator().next())) {
                return;
            }
            this.a(stringBuilder);
            stringBuilder.append(": ");
            j.a(collection, "supertypes");
            kotlin.a.m.a(collection, stringBuilder, ", ", null, null, 0, null, new kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.j.w, String>(){

                @Override
                public final String a(kotlin.reflect.jvm.internal.impl.j.w w2) {
                    e e2 = this;
                    j.a((Object)w2, "it");
                    return e2.a(w2);
                }
            }, 60, null);
        }
    }

    private final void b(kotlin.reflect.jvm.internal.impl.a.t t2, StringBuilder stringBuilder) {
        this.a(stringBuilder, t2.D(), "suspend");
    }

    /*
     * Enabled aggressive block sorting
     */
    private final boolean b(kotlin.reflect.jvm.internal.impl.j.w iterator) {
        boolean bl2;
        boolean bl3;
        boolean bl4 = FunctionTypesKt.isBuiltinFunctionalType(iterator);
        boolean bl5 = bl2 = false;
        if (!bl4) return bl5;
        if (!((iterator = (Iterable)((kotlin.reflect.jvm.internal.impl.j.w)((Object)iterator)).a()) instanceof Collection) || !((Collection)((Object)iterator)).isEmpty()) {
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                if (!((ap)iterator.next()).a()) continue;
                bl3 = false;
                break;
            }
        } else {
            bl3 = true;
        }
        bl5 = bl2;
        if (!bl3) return bl5;
        return true;
    }

    private final String c(String string2) {
        n n2 = this.H();
        CharSequence charSequence = string2;
        switch (kotlin.reflect.jvm.internal.impl.g.f.b[n2.ordinal()]) {
            default: {
                throw new kotlin.m();
            }
            case 2: {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("<font color=red><b>");
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append("</b></font>");
                charSequence = ((StringBuilder)charSequence).toString();
            }
            case 1: 
        }
        return charSequence;
    }

    private final void c(StringBuilder stringBuilder, kotlin.reflect.jvm.internal.impl.j.w w2) {
        this.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.a.a.a)w2);
        if (kotlin.reflect.jvm.internal.impl.j.y.a(w2)) {
            String string2 = w2 instanceof ay && this.w() ? ((ay)w2).d() : w2.g().toString();
            stringBuilder.append(string2);
            stringBuilder.append(this.a(w2.a()));
        } else {
            e.a(this, stringBuilder, w2, null, 2, null);
        }
        if (w2.c()) {
            stringBuilder.append("?");
        }
        if (ag.c(w2)) {
            stringBuilder.append("!!");
        }
    }

    private final void c(kotlin.reflect.jvm.internal.impl.a.b object, StringBuilder stringBuilder) {
        if (!this.r().contains((Object)g.f)) {
            return;
        }
        if (this.M() && object.n() != b.a.a) {
            stringBuilder.append("/*");
            object = object.n().name();
            if (object != null) {
                object = ((String)object).toLowerCase();
                j.a(object, "(this as java.lang.String).toLowerCase()");
                stringBuilder.append((String)object);
                stringBuilder.append("*/ ");
                return;
            }
            throw new t("null cannot be cast to non-null type java.lang.String");
        }
    }

    private final void c(kotlin.reflect.jvm.internal.impl.a.e e2, StringBuilder stringBuilder) {
        stringBuilder.append(this.b(kotlin.reflect.jvm.internal.impl.g.c.j.a(e2)));
    }

    private final void c(kotlin.reflect.jvm.internal.impl.a.t object, StringBuilder stringBuilder) {
        Object object2;
        if (!this.G()) {
            if (!this.F()) {
                this.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.a.a.a)object);
                object2 = object.p();
                j.a(object2, "function.visibility");
                this.a((kotlin.reflect.jvm.internal.impl.a.ba)object2, stringBuilder);
                object2 = (kotlin.reflect.jvm.internal.impl.a.b)object;
                this.a((kotlin.reflect.jvm.internal.impl.a.b)object2, stringBuilder);
                if (this.n()) {
                    this.a((v)object, stringBuilder);
                }
                this.b((kotlin.reflect.jvm.internal.impl.a.b)object2, stringBuilder);
                if (this.n()) {
                    this.a((kotlin.reflect.jvm.internal.impl.a.t)object, stringBuilder);
                } else {
                    this.b((kotlin.reflect.jvm.internal.impl.a.t)object, stringBuilder);
                }
                this.c((kotlin.reflect.jvm.internal.impl.a.b)object2, stringBuilder);
                if (this.M()) {
                    if (object.z()) {
                        stringBuilder.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (object.C()) {
                        stringBuilder.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            stringBuilder.append(this.b("fun"));
            stringBuilder.append(" ");
            object2 = object.f();
            j.a(object2, "function.typeParameters");
            this.a((List<? extends as>)object2, stringBuilder, true);
            this.b((kotlin.reflect.jvm.internal.impl.a.a)object, stringBuilder);
        }
        this.a((kotlin.reflect.jvm.internal.impl.a.m)object, stringBuilder, true);
        object2 = object.i();
        j.a(object2, "function.valueParameters");
        this.a((Collection)object2, object.j(), stringBuilder);
        this.a((kotlin.reflect.jvm.internal.impl.a.a)object, stringBuilder);
        object2 = object.g();
        if (!(this.P() || !this.K() && object2 != null && KotlinBuiltIns.isUnit((kotlin.reflect.jvm.internal.impl.j.w)object2))) {
            stringBuilder.append(": ");
            object2 = object2 == null ? "[NULL]" : this.a((kotlin.reflect.jvm.internal.impl.j.w)object2);
            stringBuilder.append((String)object2);
        }
        object = object.f();
        j.a(object, "function.typeParameters");
        this.a((List<? extends as>)object, stringBuilder);
    }

    private final boolean c(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return FunctionTypesKt.isSuspendFunctionType(w2) || !w2.x().a();
        {
        }
    }

    private final String d(String string2) {
        return this.H().a(string2);
    }

    private final void d(StringBuilder stringBuilder, kotlin.reflect.jvm.internal.impl.j.w w2) {
        boolean bl2;
        Object object;
        int n2;
        int n3;
        Object object2;
        block18 : {
            block20 : {
                int n4;
                block19 : {
                    int n5 = stringBuilder.length();
                    this.S().a(stringBuilder, (kotlin.reflect.jvm.internal.impl.a.a.a)w2);
                    n3 = stringBuilder.length();
                    n4 = 1;
                    n2 = n3 != n5 ? 1 : 0;
                    boolean bl3 = FunctionTypesKt.isSuspendFunctionType(w2);
                    bl2 = w2.c();
                    object2 = FunctionTypesKt.getReceiverTypeFromFunctionType(w2);
                    n3 = !(bl2 || n2 != 0 && object2 != null) ? 0 : 1;
                    if (n3 != 0) {
                        if (bl3) {
                            stringBuilder.insert(n5, '(');
                        } else {
                            if (n2 != 0) {
                                object = stringBuilder;
                                n2 = kotlin.i.n.d((CharSequence)object) == ' ' ? 1 : 0;
                                if (y.a && n2 == 0) {
                                    throw (Throwable)((Object)new AssertionError((Object)"Assertion failed"));
                                }
                                if (stringBuilder.charAt(kotlin.i.n.c((CharSequence)object) - 1) != ')') {
                                    stringBuilder.insert(kotlin.i.n.c((CharSequence)object), "()");
                                }
                            }
                            stringBuilder.append("(");
                        }
                    }
                    this.a(stringBuilder, bl3, "suspend");
                    if (object2 == null) break block18;
                    if (!this.b((kotlin.reflect.jvm.internal.impl.j.w)object2)) break block19;
                    n2 = n4;
                    if (!((kotlin.reflect.jvm.internal.impl.j.w)object2).c()) break block20;
                }
                n2 = this.c((kotlin.reflect.jvm.internal.impl.j.w)object2) ? n4 : 0;
            }
            if (n2 != 0) {
                stringBuilder.append("(");
            }
            this.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.j.w)object2);
            if (n2 != 0) {
                stringBuilder.append(")");
            }
            stringBuilder.append(".");
        }
        stringBuilder.append("(");
        object = ((Iterable)FunctionTypesKt.getValueParameterTypesFromFunctionType(w2)).iterator();
        n2 = 0;
        while (object.hasNext()) {
            ap ap2 = (ap)object.next();
            if (n2 > 0) {
                stringBuilder.append(", ");
            }
            if (this.v()) {
                object2 = ap2.c();
                j.a(object2, "typeProjection.type");
                object2 = FunctionTypesKt.extractParameterNameFromFunctionTypeArgument((kotlin.reflect.jvm.internal.impl.j.w)object2);
            } else {
                object2 = null;
            }
            if (object2 != null) {
                stringBuilder.append(this.a((kotlin.reflect.jvm.internal.impl.e.f)object2, false));
                stringBuilder.append(": ");
            }
            stringBuilder.append(this.T().a(ap2));
            ++n2;
        }
        stringBuilder.append(") ");
        stringBuilder.append(this.W());
        stringBuilder.append(" ");
        this.a(stringBuilder, FunctionTypesKt.getReturnTypeFromFunctionType(w2));
        if (n3 != 0) {
            stringBuilder.append(")");
        }
        if (bl2) {
            stringBuilder.append("?");
        }
    }

    private final boolean i(boolean bl2) {
        m m2 = this.u();
        switch (kotlin.reflect.jvm.internal.impl.g.f.e[m2.ordinal()]) {
            default: {
                throw new kotlin.m();
            }
            case 3: {
                return false;
            }
            case 2: {
                return bl2 ^ true;
            }
            case 1: 
        }
        return true;
    }

    public boolean A() {
        return this.n.M();
    }

    public boolean B() {
        return this.n.H();
    }

    public boolean C() {
        return this.n.s();
    }

    public boolean D() {
        return this.n.N();
    }

    public boolean E() {
        return this.n.z();
    }

    public boolean F() {
        return this.n.l();
    }

    public boolean G() {
        return this.n.j();
    }

    public n H() {
        return this.n.C();
    }

    public kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.j.w, kotlin.reflect.jvm.internal.impl.j.w> I() {
        return this.n.x();
    }

    public boolean J() {
        return this.n.t();
    }

    public boolean K() {
        return this.n.p();
    }

    public c.k L() {
        return this.n.B();
    }

    public boolean M() {
        return this.n.o();
    }

    public boolean N() {
        return this.n.f();
    }

    public boolean O() {
        return this.n.g();
    }

    public boolean P() {
        return this.n.q();
    }

    public boolean Q() {
        return this.n.w();
    }

    public boolean R() {
        return this.n.v();
    }

    public String a(String string2) {
        j.b(string2, "message");
        n n2 = this.H();
        CharSequence charSequence = string2;
        switch (kotlin.reflect.jvm.internal.impl.g.f.d[n2.ordinal()]) {
            default: {
                throw new kotlin.m();
            }
            case 2: {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("<i>");
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append("</i>");
                charSequence = ((StringBuilder)charSequence).toString();
            }
            case 1: 
        }
        return charSequence;
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public String a(String object, String object2, KotlinBuiltIns object3) {
        j.b(object, "lowerRendered");
        j.b(object2, "upperRendered");
        j.b(object3, "builtIns");
        if (this.a((String)object, (String)object2)) {
            if (kotlin.i.n.a((String)object2, "(", false, 2, null)) {
                object3 = new StringBuilder();
                ((StringBuilder)object3).append('(');
                ((StringBuilder)object3).append((String)object);
                object2 = ")!";
                object = object3;
            } else {
                object2 = new StringBuilder();
                ((StringBuilder)object2).append((String)object);
                object3 = "!";
                object = object2;
                object2 = object3;
            }
            ((StringBuilder)object).append((String)object2);
            return ((StringBuilder)object).toString();
        }
        Object object4 = this.g();
        Object object5 = ((KotlinBuiltIns)object3).getCollection();
        j.a(object5, "builtIns.collection");
        Object object6 = (kotlin.reflect.jvm.internal.impl.a.h)object5;
        object5 = this;
        object4 = kotlin.i.n.a(object4.a((kotlin.reflect.jvm.internal.impl.a.h)object6, (kotlin.reflect.jvm.internal.impl.g.c)object5), "Collection", null, 2, null);
        object6 = new StringBuilder();
        ((StringBuilder)object6).append((String)object4);
        ((StringBuilder)object6).append("Mutable");
        object6 = ((StringBuilder)object6).toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object4);
        stringBuilder.append('(');
        stringBuilder.append("Mutable");
        stringBuilder.append(')');
        object6 = this.a((String)object, (String)object6, (String)object2, (String)object4, stringBuilder.toString());
        if (object6 != null) {
            return object6;
        }
        object6 = new StringBuilder();
        ((StringBuilder)object6).append((String)object4);
        ((StringBuilder)object6).append("MutableMap.MutableEntry");
        object6 = ((StringBuilder)object6).toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append((String)object4);
        stringBuilder2.append("Map.Entry");
        String string2 = stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append((String)object4);
        stringBuilder3.append("(Mutable)Map.(Mutable)Entry");
        object4 = this.a((String)object, (String)object6, (String)object2, string2, stringBuilder3.toString());
        if (object4 != null) {
            return object4;
        }
        object4 = this.g();
        object3 = ((KotlinBuiltIns)object3).getArray();
        j.a(object3, "builtIns.array");
        object3 = kotlin.i.n.a(object4.a((kotlin.reflect.jvm.internal.impl.a.h)object3, (kotlin.reflect.jvm.internal.impl.g.c)object5), "Array", null, 2, null);
        object5 = new StringBuilder();
        ((StringBuilder)object5).append((String)object3);
        ((StringBuilder)object5).append(this.d("Array<"));
        object5 = ((StringBuilder)object5).toString();
        object4 = new StringBuilder();
        ((StringBuilder)object4).append((String)object3);
        ((StringBuilder)object4).append(this.d("Array<out "));
        object4 = ((StringBuilder)object4).toString();
        object6 = new StringBuilder();
        ((StringBuilder)object6).append((String)object3);
        ((StringBuilder)object6).append(this.d("Array<(out) "));
        object3 = this.a((String)object, (String)object5, (String)object2, (String)object4, ((StringBuilder)object6).toString());
        if (object3 != null) {
            return object3;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append('(');
        ((StringBuilder)object3).append((String)object);
        ((StringBuilder)object3).append("..");
        ((StringBuilder)object3).append((String)object2);
        ((StringBuilder)object3).append(')');
        object = object3;
        return ((StringBuilder)object).toString();
    }

    public String a(List<? extends ap> object) {
        j.b(object, "typeArguments");
        if (object.isEmpty()) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.U());
        this.a(stringBuilder, (List<? extends ap>)object);
        stringBuilder.append(this.V());
        object = stringBuilder.toString();
        j.a(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    @Override
    public String a(kotlin.reflect.jvm.internal.impl.a.a.c object, kotlin.reflect.jvm.internal.impl.a.a.e object2) {
        j.b(object, "annotation");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('@');
        if (object2 != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(((kotlin.reflect.jvm.internal.impl.a.a.e)((Object)object2)).a());
            stringBuilder2.append(":");
            stringBuilder.append(stringBuilder2.toString());
        }
        object2 = object.a();
        stringBuilder.append(this.a((kotlin.reflect.jvm.internal.impl.j.w)object2));
        if (this.o()) {
            object = this.a((kotlin.reflect.jvm.internal.impl.a.a.c)object);
            if (this.p() || ((Collection)object).isEmpty() ^ true) {
                kotlin.a.m.a((Iterable)object, stringBuilder, ", ", "(", ")", 0, null, null, 112, null);
            }
        }
        if (this.M() && (kotlin.reflect.jvm.internal.impl.j.y.a((kotlin.reflect.jvm.internal.impl.j.w)object2) || ((kotlin.reflect.jvm.internal.impl.j.w)object2).g().d() instanceof aa.b)) {
            stringBuilder.append(" /* annotation class not found */");
        }
        object = stringBuilder.toString();
        j.a(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    public String a(kotlin.reflect.jvm.internal.impl.a.h h2) {
        j.b(h2, "klass");
        if (kotlin.reflect.jvm.internal.impl.j.p.a(h2)) {
            return h2.e().toString();
        }
        return this.g().a(h2, this);
    }

    @Override
    public String a(kotlin.reflect.jvm.internal.impl.a.m object) {
        j.b(object, "declarationDescriptor");
        StringBuilder stringBuilder = new StringBuilder();
        object.a(new a(), stringBuilder);
        if (this.N()) {
            this.a(stringBuilder, (kotlin.reflect.jvm.internal.impl.a.m)object);
        }
        object = stringBuilder.toString();
        j.a(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    @Override
    public String a(kotlin.reflect.jvm.internal.impl.e.c object) {
        j.b(object, "fqName");
        object = ((kotlin.reflect.jvm.internal.impl.e.c)object).h();
        j.a(object, "fqName.pathSegments()");
        return this.b((List<kotlin.reflect.jvm.internal.impl.e.f>)object);
    }

    @Override
    public String a(kotlin.reflect.jvm.internal.impl.e.f object, boolean bl2) {
        j.b(object, "name");
        String string2 = this.d(o.a((kotlin.reflect.jvm.internal.impl.e.f)object));
        object = string2;
        if (this.e()) {
            object = string2;
            if (this.H() == n.b) {
                object = string2;
                if (bl2) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("<b>");
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append("</b>");
                    object = ((StringBuilder)object).toString();
                }
            }
        }
        return object;
    }

    public String a(an object) {
        j.b(object, "typeConstructor");
        kotlin.reflect.jvm.internal.impl.a.h h2 = object.d();
        if (h2 instanceof as || h2 instanceof kotlin.reflect.jvm.internal.impl.a.e || h2 instanceof ar) {
            return this.a(h2);
        }
        if (h2 == null) {
            return object.toString();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Unexpected classifier: ");
        ((StringBuilder)object).append(h2.getClass());
        throw (Throwable)new IllegalStateException(((StringBuilder)object).toString().toString());
    }

    @Override
    public String a(ap object) {
        j.b(object, "typeProjection");
        StringBuilder stringBuilder = new StringBuilder();
        this.a(stringBuilder, kotlin.a.m.a(object));
        object = stringBuilder.toString();
        j.a(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    @Override
    public String a(kotlin.reflect.jvm.internal.impl.j.w object) {
        j.b(object, "type");
        StringBuilder stringBuilder = new StringBuilder();
        this.a(stringBuilder, this.I().a((kotlin.reflect.jvm.internal.impl.j.w)object));
        object = stringBuilder.toString();
        j.a(object, "StringBuilder().apply(builderAction).toString()");
        return object;
    }

    public final i a() {
        return this.n;
    }

    @Override
    public void a(Set<kotlin.reflect.jvm.internal.impl.e.b> set) {
        j.b(set, "<set-?>");
        this.n.a(set);
    }

    @Override
    public void a(kotlin.reflect.jvm.internal.impl.g.a a2) {
        j.b((Object)a2, "<set-?>");
        this.n.a(a2);
    }

    @Override
    public void a(kotlin.reflect.jvm.internal.impl.g.b b2) {
        j.b(b2, "<set-?>");
        this.n.a(b2);
    }

    @Override
    public void a(m m2) {
        j.b((Object)m2, "<set-?>");
        this.n.a(m2);
    }

    @Override
    public void a(n n2) {
        j.b((Object)n2, "<set-?>");
        this.n.a(n2);
    }

    @Override
    public void a(boolean bl2) {
        this.n.a(bl2);
    }

    @Override
    public void b(Set<? extends g> set) {
        j.b(set, "<set-?>");
        this.n.b(set);
    }

    @Override
    public void b(boolean bl2) {
        this.n.b(bl2);
    }

    public boolean b() {
        return this.n.L();
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.g.a c() {
        return this.n.c();
    }

    @Override
    public void c(boolean bl2) {
        this.n.c(bl2);
    }

    public kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.a.a.c, Boolean> d() {
        return this.n.K();
    }

    @Override
    public void d(boolean bl2) {
        this.n.d(bl2);
    }

    @Override
    public void e(boolean bl2) {
        this.n.e(bl2);
    }

    public boolean e() {
        return this.n.R();
    }

    @Override
    public void f(boolean bl2) {
        this.n.f(bl2);
    }

    public boolean f() {
        return this.n.n();
    }

    public kotlin.reflect.jvm.internal.impl.g.b g() {
        return this.n.e();
    }

    @Override
    public void g(boolean bl2) {
        this.n.g(bl2);
    }

    @Override
    public void h(boolean bl2) {
        this.n.h(bl2);
    }

    @Override
    public boolean h() {
        return this.n.h();
    }

    public kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.a.av, String> i() {
        return this.n.y();
    }

    public boolean j() {
        return this.n.I();
    }

    @Override
    public boolean k() {
        return this.n.k();
    }

    public Set<kotlin.reflect.jvm.internal.impl.e.b> l() {
        return this.n.J();
    }

    @Override
    public Set<kotlin.reflect.jvm.internal.impl.e.b> m() {
        return this.n.m();
    }

    public boolean n() {
        return this.n.O();
    }

    public boolean o() {
        return this.n.S();
    }

    public boolean p() {
        return this.n.T();
    }

    public boolean q() {
        return this.n.u();
    }

    public Set<g> r() {
        return this.n.i();
    }

    public boolean s() {
        return this.n.r();
    }

    public kotlin.reflect.jvm.internal.impl.g.l t() {
        return this.n.A();
    }

    public m u() {
        return this.n.D();
    }

    public boolean v() {
        return this.n.P();
    }

    public boolean w() {
        return this.n.Q();
    }

    public boolean x() {
        return this.n.E();
    }

    public boolean y() {
        return this.n.G();
    }

    public boolean z() {
        return this.n.F();
    }

    private final class a
    implements kotlin.reflect.jvm.internal.impl.a.o<w, StringBuilder> {
        @Override
        public void a(ab ab2, StringBuilder stringBuilder) {
            j.b(ab2, "descriptor");
            j.b(stringBuilder, "builder");
            e.this.a(ab2, stringBuilder);
        }

        @Override
        public void a(ae ae2, StringBuilder stringBuilder) {
            j.b(ae2, "descriptor");
            j.b(stringBuilder, "builder");
            e.this.a(ae2, stringBuilder);
        }

        @Override
        public void a(ai ai2, StringBuilder stringBuilder) {
            j.b(ai2, "descriptor");
            j.b(stringBuilder, "builder");
            e.this.a(ai2, stringBuilder);
        }

        @Override
        public void a(aj b2, StringBuilder stringBuilder) {
            j.b(b2, "descriptor");
            j.b(stringBuilder, "builder");
            if (e.this.y()) {
                e.this.a(b2, stringBuilder);
                stringBuilder.append("getter for ");
                e e2 = e.this;
                b2 = b2.q();
                j.a((Object)b2, "descriptor.correspondingProperty");
                e2.a((ai)b2, stringBuilder);
                return;
            }
            this.a((kotlin.reflect.jvm.internal.impl.a.t)b2, stringBuilder);
        }

        @Override
        public void a(ak b2, StringBuilder stringBuilder) {
            j.b(b2, "descriptor");
            j.b(stringBuilder, "builder");
            if (e.this.y()) {
                e.this.a(b2, stringBuilder);
                stringBuilder.append("setter for ");
                e e2 = e.this;
                b2 = b2.q();
                j.a((Object)b2, "descriptor.correspondingProperty");
                e2.a((ai)b2, stringBuilder);
                return;
            }
            this.a((kotlin.reflect.jvm.internal.impl.a.t)b2, stringBuilder);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.a.al al2, StringBuilder stringBuilder) {
            j.b(al2, "descriptor");
            j.b(stringBuilder, "builder");
            stringBuilder.append(al2.h_());
        }

        @Override
        public void a(ar ar2, StringBuilder stringBuilder) {
            j.b(ar2, "descriptor");
            j.b(stringBuilder, "builder");
            e.this.a(ar2, stringBuilder);
        }

        @Override
        public void a(as as2, StringBuilder stringBuilder) {
            j.b(as2, "descriptor");
            j.b(stringBuilder, "builder");
            e.this.a(as2, stringBuilder, true);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.a.av av2, StringBuilder stringBuilder) {
            j.b(av2, "descriptor");
            j.b(stringBuilder, "builder");
            e.this.a(av2, true, stringBuilder, true);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.a.e e2, StringBuilder stringBuilder) {
            j.b(e2, "descriptor");
            j.b(stringBuilder, "builder");
            e.this.a(e2, stringBuilder);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.a.l l2, StringBuilder stringBuilder) {
            j.b(l2, "constructorDescriptor");
            j.b(stringBuilder, "builder");
            e.this.a(l2, stringBuilder);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.a.t t2, StringBuilder stringBuilder) {
            j.b(t2, "descriptor");
            j.b(stringBuilder, "builder");
            e.this.c(t2, stringBuilder);
        }

        @Override
        public void a(kotlin.reflect.jvm.internal.impl.a.y y2, StringBuilder stringBuilder) {
            j.b(y2, "descriptor");
            j.b(stringBuilder, "builder");
            e.this.a(y2, stringBuilder, true);
        }
    }

}

