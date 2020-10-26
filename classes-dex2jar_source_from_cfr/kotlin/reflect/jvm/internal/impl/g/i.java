/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.g;

import java.lang.reflect.Field;
import java.util.Set;
import kotlin.a.al;
import kotlin.e.b.k;
import kotlin.e.b.t;
import kotlin.e.b.v;
import kotlin.reflect.e;
import kotlin.reflect.jvm.internal.impl.a.av;
import kotlin.reflect.jvm.internal.impl.g.b;
import kotlin.reflect.jvm.internal.impl.g.c;
import kotlin.reflect.jvm.internal.impl.g.g;
import kotlin.reflect.jvm.internal.impl.g.h;
import kotlin.reflect.jvm.internal.impl.g.j;
import kotlin.reflect.jvm.internal.impl.g.m;
import kotlin.reflect.jvm.internal.impl.g.n;
import kotlin.reflect.jvm.internal.impl.j.w;
import kotlin.reflect.l;
import kotlin.y;

public final class i
implements h {
    static final /* synthetic */ l[] a;
    private final kotlin.f.c A = this.a((T)((Object)m.a));
    private final kotlin.f.c B = this.a((T)false);
    private final kotlin.f.c C = this.a((T)false);
    private final kotlin.f.c D = this.a((T)false);
    private final kotlin.f.c E = this.a((T)false);
    private final kotlin.f.c F = this.a((T)false);
    private final kotlin.f.c G = this.a((T)al.a());
    private final kotlin.f.c H = this.a((T)j.a.a());
    private final kotlin.f.c I = this.a((T)null);
    private final kotlin.f.c J = this.a((T)((Object)kotlin.reflect.jvm.internal.impl.g.a.a));
    private final kotlin.f.c K = this.a((T)false);
    private final kotlin.f.c L = this.a((T)true);
    private final kotlin.f.c M = this.a((T)true);
    private final kotlin.f.c N = this.a((T)true);
    private final kotlin.f.c O = this.a((T)true);
    private final kotlin.f.c P = this.a((T)false);
    private final kotlin.f.c Q = this.a((T)false);
    private final kotlin.f.c R = this.a((T)false);
    private boolean b;
    private final kotlin.f.c c = this.a((T)b.c.a);
    private final kotlin.f.c d = this.a((T)true);
    private final kotlin.f.c e = this.a((T)true);
    private final kotlin.f.c f = this.a((T)g.k);
    private final kotlin.f.c g = this.a((T)false);
    private final kotlin.f.c h = this.a((T)false);
    private final kotlin.f.c i = this.a((T)false);
    private final kotlin.f.c j = this.a((T)false);
    private final kotlin.f.c k = this.a((T)false);
    private final kotlin.f.c l = this.a((T)true);
    private final kotlin.f.c m = this.a((T)false);
    private final kotlin.f.c n = this.a((T)false);
    private final kotlin.f.c o = this.a((T)false);
    private final kotlin.f.c p = this.a((T)true);
    private final kotlin.f.c q = this.a((T)false);
    private final kotlin.f.c r = this.a((T)false);
    private final kotlin.f.c s = this.a((T)false);
    private final kotlin.f.c t = this.a((T)false);
    private final kotlin.f.c u = this.a(c.a);
    private final kotlin.f.c v = this.a(a.a);
    private final kotlin.f.c w = this.a((T)true);
    private final kotlin.f.c x = this.a((T)((Object)kotlin.reflect.jvm.internal.impl.g.l.b));
    private final kotlin.f.c y = this.a(c.k.a.a);
    private final kotlin.f.c z = this.a((T)((Object)n.a));

    static {
        a = new l[]{v.a(new kotlin.e.b.n(v.a(i.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), v.a(new kotlin.e.b.n(v.a(i.class), "withDefinedIn", "getWithDefinedIn()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "modifiers", "getModifiers()Ljava/util/Set;")), v.a(new kotlin.e.b.n(v.a(i.class), "startFromName", "getStartFromName()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "debugMode", "getDebugMode()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "verbose", "getVerbose()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "unitReturnType", "getUnitReturnType()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "withoutReturnType", "getWithoutReturnType()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "enhancedTypes", "getEnhancedTypes()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), v.a(new kotlin.e.b.n(v.a(i.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), v.a(new kotlin.e.b.n(v.a(i.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), v.a(new kotlin.e.b.n(v.a(i.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), v.a(new kotlin.e.b.n(v.a(i.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), v.a(new kotlin.e.b.n(v.a(i.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), v.a(new kotlin.e.b.n(v.a(i.class), "receiverAfterName", "getReceiverAfterName()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "renderAccessors", "getRenderAccessors()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), v.a(new kotlin.e.b.n(v.a(i.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), v.a(new kotlin.e.b.n(v.a(i.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), v.a(new kotlin.e.b.n(v.a(i.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), v.a(new kotlin.e.b.n(v.a(i.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), v.a(new kotlin.e.b.n(v.a(i.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z"))};
    }

    private final <T> kotlin.f.c<i, T> a(final T t2) {
        kotlin.f.a a2 = kotlin.f.a.a;
        return new kotlin.f.b<T>(t2){

            @Override
            protected boolean a(l<?> l2, T t22, T t3) {
                kotlin.e.b.j.b(l2, "property");
                if (!this.a()) {
                    return true;
                }
                throw (Throwable)new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
            }
        };
    }

    public kotlin.reflect.jvm.internal.impl.g.l A() {
        return (kotlin.reflect.jvm.internal.impl.g.l)((Object)this.x.a(this, a[21]));
    }

    public c.k B() {
        return (c.k)this.y.a(this, a[22]);
    }

    public n C() {
        return (n)((Object)this.z.a(this, a[23]));
    }

    public m D() {
        return (m)((Object)this.A.a(this, a[24]));
    }

    public boolean E() {
        return (Boolean)this.B.a(this, a[25]);
    }

    public boolean F() {
        return (Boolean)this.C.a(this, a[26]);
    }

    public boolean G() {
        return (Boolean)this.D.a(this, a[27]);
    }

    public boolean H() {
        return (Boolean)this.E.a(this, a[28]);
    }

    public boolean I() {
        return (Boolean)this.F.a(this, a[29]);
    }

    public Set<kotlin.reflect.jvm.internal.impl.e.b> J() {
        return (Set)this.G.a(this, a[30]);
    }

    public kotlin.e.a.b<kotlin.reflect.jvm.internal.impl.a.a.c, Boolean> K() {
        return (kotlin.e.a.b)this.I.a(this, a[32]);
    }

    public boolean L() {
        return (Boolean)this.K.a(this, a[34]);
    }

    public boolean M() {
        return (Boolean)this.L.a(this, a[35]);
    }

    public boolean N() {
        return (Boolean)this.M.a(this, a[36]);
    }

    public boolean O() {
        return (Boolean)this.N.a(this, a[37]);
    }

    public boolean P() {
        return (Boolean)this.O.a(this, a[38]);
    }

    public boolean Q() {
        return (Boolean)this.Q.a(this, a[40]);
    }

    public boolean R() {
        return (Boolean)this.R.a(this, a[41]);
    }

    public boolean S() {
        return h.a.a(this);
    }

    public boolean T() {
        return h.a.b(this);
    }

    @Override
    public void a(Set<kotlin.reflect.jvm.internal.impl.e.b> set) {
        kotlin.e.b.j.b(set, "<set-?>");
        this.H.a(this, a[31], set);
    }

    @Override
    public void a(kotlin.reflect.jvm.internal.impl.g.a a2) {
        kotlin.e.b.j.b((Object)a2, "<set-?>");
        this.J.a(this, a[33], a2);
    }

    @Override
    public void a(kotlin.reflect.jvm.internal.impl.g.b b2) {
        kotlin.e.b.j.b(b2, "<set-?>");
        this.c.a(this, a[0], b2);
    }

    @Override
    public void a(m m2) {
        kotlin.e.b.j.b((Object)m2, "<set-?>");
        this.A.a(this, a[24], m2);
    }

    @Override
    public void a(n n2) {
        kotlin.e.b.j.b((Object)n2, "<set-?>");
        this.z.a(this, a[23], n2);
    }

    @Override
    public void a(boolean bl2) {
        this.i.a(this, a[6], bl2);
    }

    public final boolean a() {
        return this.b;
    }

    public final void b() {
        boolean bl2 = this.b;
        if (y.a && !(bl2 ^ true)) {
            throw (Throwable)((Object)new AssertionError((Object)"Assertion failed"));
        }
        this.b = true;
    }

    @Override
    public void b(Set<? extends g> set) {
        kotlin.e.b.j.b(set, "<set-?>");
        this.f.a(this, a[3], set);
    }

    @Override
    public void b(boolean bl2) {
        this.B.a(this, a[25], bl2);
    }

    @Override
    public kotlin.reflect.jvm.internal.impl.g.a c() {
        return (kotlin.reflect.jvm.internal.impl.g.a)((Object)this.J.a(this, a[33]));
    }

    @Override
    public void c(boolean bl2) {
        this.C.a(this, a[26], bl2);
    }

    public final i d() {
        i i2 = new i();
        for (Field field : this.getClass().getDeclaredFields()) {
            Object object;
            kotlin.e.b.j.a((Object)field, "field");
            if ((field.getModifiers() & 8) != 0) continue;
            field.setAccessible(true);
            Object object2 = object = field.get(this);
            if (!(object instanceof kotlin.f.b)) {
                object2 = null;
            }
            if ((object2 = (kotlin.f.b)object2) == null) continue;
            object = field.getName();
            kotlin.e.b.j.a(object, "field.name");
            boolean bl2 = kotlin.i.n.a((String)object, "is", false, 2, null);
            if (y.a && !(true ^ bl2)) {
                throw (Throwable)((Object)new AssertionError((Object)"Fields named is* are not supported here yet"));
            }
            object = v.a(i.class);
            String string2 = field.getName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("get");
            String string3 = field.getName();
            kotlin.e.b.j.a((Object)string3, "field.name");
            stringBuilder.append(kotlin.i.n.d(string3));
            field.set(i2, i2.a(((kotlin.f.b)object2).a(this, new t((e)object, string2, stringBuilder.toString()))));
        }
        return i2;
    }

    @Override
    public void d(boolean bl2) {
        this.g.a(this, a[4], bl2);
    }

    public kotlin.reflect.jvm.internal.impl.g.b e() {
        return (kotlin.reflect.jvm.internal.impl.g.b)this.c.a(this, a[0]);
    }

    @Override
    public void e(boolean bl2) {
        this.k.a(this, a[8], bl2);
    }

    @Override
    public void f(boolean bl2) {
        this.d.a(this, a[1], bl2);
    }

    public boolean f() {
        return (Boolean)this.d.a(this, a[1]);
    }

    @Override
    public void g(boolean bl2) {
        this.t.a(this, a[17], bl2);
    }

    public boolean g() {
        return (Boolean)this.e.a(this, a[2]);
    }

    @Override
    public void h(boolean bl2) {
        this.s.a(this, a[16], bl2);
    }

    @Override
    public boolean h() {
        return (Boolean)this.i.a(this, a[6]);
    }

    public Set<g> i() {
        return (Set)this.f.a(this, a[3]);
    }

    public boolean j() {
        return (Boolean)this.g.a(this, a[4]);
    }

    @Override
    public boolean k() {
        return (Boolean)this.n.a(this, a[11]);
    }

    public boolean l() {
        return (Boolean)this.h.a(this, a[5]);
    }

    @Override
    public Set<kotlin.reflect.jvm.internal.impl.e.b> m() {
        return (Set)this.H.a(this, a[31]);
    }

    public boolean n() {
        return (Boolean)this.j.a(this, a[7]);
    }

    public boolean o() {
        return (Boolean)this.k.a(this, a[8]);
    }

    public boolean p() {
        return (Boolean)this.l.a(this, a[9]);
    }

    public boolean q() {
        return (Boolean)this.m.a(this, a[10]);
    }

    public boolean r() {
        return (Boolean)this.o.a(this, a[12]);
    }

    public boolean s() {
        return (Boolean)this.p.a(this, a[13]);
    }

    public boolean t() {
        return (Boolean)this.q.a(this, a[14]);
    }

    public boolean u() {
        return (Boolean)this.r.a(this, a[15]);
    }

    public boolean v() {
        return (Boolean)this.s.a(this, a[16]);
    }

    public boolean w() {
        return (Boolean)this.t.a(this, a[17]);
    }

    public kotlin.e.a.b<w, w> x() {
        return (kotlin.e.a.b)this.u.a(this, a[18]);
    }

    public kotlin.e.a.b<av, String> y() {
        return (kotlin.e.a.b)this.v.a(this, a[19]);
    }

    public boolean z() {
        return (Boolean)this.w.a(this, a[20]);
    }

}

