/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.a.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.af;
import kotlin.a.g;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.a.e;
import kotlin.s;

public final class o
extends Enum<o> {
    public static final /* enum */ o A;
    public static final /* enum */ o B;
    public static final /* enum */ o C;
    public static final /* enum */ o D;
    public static final /* enum */ o E;
    public static final /* enum */ o F;
    public static final /* enum */ o G;
    public static final /* enum */ o H;
    public static final /* enum */ o I;
    public static final /* enum */ o J;
    public static final /* enum */ o K;
    public static final /* enum */ o L;
    public static final /* enum */ o M;
    public static final /* enum */ o N;
    public static final /* enum */ o O;
    public static final a P;
    private static final /* synthetic */ o[] Q;
    private static final HashMap<String, o> T;
    private static final Set<o> U;
    private static final Set<o> V;
    private static final Map<e, o> W;
    public static final /* enum */ o a;
    public static final /* enum */ o b;
    public static final /* enum */ o c;
    public static final /* enum */ o d;
    public static final /* enum */ o e;
    public static final /* enum */ o f;
    public static final /* enum */ o g;
    public static final /* enum */ o h;
    public static final /* enum */ o i;
    public static final /* enum */ o j;
    public static final /* enum */ o k;
    public static final /* enum */ o l;
    public static final /* enum */ o m;
    public static final /* enum */ o n;
    public static final /* enum */ o o;
    public static final /* enum */ o p;
    public static final /* enum */ o q;
    public static final /* enum */ o r;
    public static final /* enum */ o s;
    public static final /* enum */ o t;
    public static final /* enum */ o u;
    public static final /* enum */ o v;
    public static final /* enum */ o w;
    public static final /* enum */ o x;
    public static final /* enum */ o y;
    public static final /* enum */ o z;
    private final String R;
    private final boolean S;

    static {
        o o2;
        o o3;
        o o4;
        o o5;
        o o6;
        o o7;
        o object2;
        o o8;
        o o9;
        o o10;
        o o11;
        o o12;
        o o13;
        o o14;
        o o15;
        o o16;
        o o17;
        o o18;
        o o19;
        o o20;
        o o21;
        o o22;
        o o23;
        o o24;
        o o25;
        o o26;
        o o27;
        o o282;
        o o29;
        o o30;
        o o31;
        o o32;
        o o33;
        o o34;
        o o35;
        o o36;
        o o37;
        o o38;
        o o39;
        o o40;
        o[] arro = new o[]("CLASS", 0, "class", false, 2, null);
        a = arro;
        b = object2 = new o("ANNOTATION_CLASS", 1, "annotation class", false, 2, null);
        c = o282 = new o("type parameter", false);
        d = o17 = new o("PROPERTY", 3, "property", false, 2, null);
        e = o33 = new o("FIELD", 4, "field", false, 2, null);
        f = o23 = new o("LOCAL_VARIABLE", 5, "local variable", false, 2, null);
        g = o18 = new o("VALUE_PARAMETER", 6, "value parameter", false, 2, null);
        h = o10 = new o("CONSTRUCTOR", 7, "constructor", false, 2, null);
        i = o6 = new o("FUNCTION", 8, "function", false, 2, null);
        j = o32 = new o("PROPERTY_GETTER", 9, "getter", false, 2, null);
        k = o13 = new o("PROPERTY_SETTER", 10, "setter", false, 2, null);
        l = o37 = new o("type usage", false);
        m = o21 = new o("expression", false);
        n = o35 = new o("file", false);
        o = o14 = new o("typealias", false);
        p = o29 = new o("type projection", false);
        q = o2 = new o("star projection", false);
        r = o3 = new o("property constructor parameter", false);
        s = o31 = new o("class", false);
        t = o4 = new o("object", false);
        u = o15 = new o("companion object", false);
        v = o40 = new o("interface", false);
        w = o5 = new o("enum class", false);
        x = o26 = new o("enum entry", false);
        y = o9 = new o("local class", false);
        z = o16 = new o("local function", false);
        A = o36 = new o("member function", false);
        B = o20 = new o("top level function", false);
        C = o7 = new o("member property", false);
        D = o25 = new o("member property with backing field", false);
        E = o22 = new o("member property with delegate", false);
        F = o34 = new o("member property without backing field or delegate", false);
        G = o30 = new o("top level property", false);
        H = o8 = new o("top level property with backing field", false);
        I = o27 = new o("top level property with delegate", false);
        J = o19 = new o("top level property without backing field or delegate", false);
        K = o38 = new o("initializer", false);
        L = o11 = new o("destructuring declaration", false);
        M = o12 = new o("lambda expression", false);
        N = o39 = new o("anonymous function", false);
        O = o24 = new o("object literal", false);
        Q = new o[]{arro, object2, o282, o17, o33, o23, o18, o10, o6, o32, o13, o37, o21, o35, o14, o29, o2, o3, o31, o4, o15, o40, o5, o26, o9, o16, o36, o20, o7, o25, o22, o34, o30, o8, o27, o19, o38, o11, o12, o39, o24};
        P = new a(null);
        T = new HashMap();
        for (o o41 : o.values()) {
            ((Map)T).put(o41.name(), o41);
        }
        arro = o.values();
        Collection collection = new ArrayList();
        for (o o282 : arro) {
            if (!o282.S) continue;
            collection.add(o282);
        }
        U = m.m((List)collection);
        V = g.j(o.values());
        W = af.a(s.a(e.g, g), s.a(e.a, e), s.a(e.c, d), s.a(e.b, n), s.a(e.d, j), s.a(e.e, k), s.a(e.f, g), s.a(e.h, g), s.a(e.i, e));
    }

    protected o(String string3, boolean bl2) {
        j.b(string3, "description");
        this.R = string3;
        this.S = bl2;
    }

    /* synthetic */ o(String string2, int n2, String string3, boolean bl2, int n3, kotlin.e.b.g g2) {
        if ((n3 & 2) != 0) {
            bl2 = true;
        }
        this(string3, bl2);
    }

    public static o valueOf(String string2) {
        return Enum.valueOf(o.class, string2);
    }

    public static o[] values() {
        return (o[])Q.clone();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.e.b.g g2) {
            this();
        }
    }

}

