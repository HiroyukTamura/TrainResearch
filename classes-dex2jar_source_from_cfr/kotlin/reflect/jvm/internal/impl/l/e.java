/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.a.af;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.e.b.v;
import kotlin.g;
import kotlin.h;
import kotlin.reflect.l;
import kotlin.t;

public final class e {
    static final /* synthetic */ l[] a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final a e;
    private final g f;
    private final kotlin.reflect.jvm.internal.impl.l.h g;
    private final kotlin.reflect.jvm.internal.impl.l.h h;
    private final Map<String, kotlin.reflect.jvm.internal.impl.l.h> i;
    private final boolean j;

    static {
        a = new l[]{v.a(new kotlin.e.b.t(v.a(e.class), "description", "getDescription()[Ljava/lang/String;"))};
        e = new a(null);
        b = new e(kotlin.reflect.jvm.internal.impl.l.h.b, null, af.a(), false, 8, null);
        c = new e(kotlin.reflect.jvm.internal.impl.l.h.a, kotlin.reflect.jvm.internal.impl.l.h.a, af.a(), false, 8, null);
        d = new e(kotlin.reflect.jvm.internal.impl.l.h.c, kotlin.reflect.jvm.internal.impl.l.h.c, af.a(), false, 8, null);
    }

    public e(kotlin.reflect.jvm.internal.impl.l.h h2, kotlin.reflect.jvm.internal.impl.l.h h3, Map<String, ? extends kotlin.reflect.jvm.internal.impl.l.h> map, boolean bl2) {
        j.b((Object)h2, "global");
        j.b(map, "user");
        this.g = h2;
        this.h = h3;
        this.i = map;
        this.j = bl2;
        this.f = h.a((kotlin.e.a.a)new kotlin.e.a.a<String[]>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public final String[] b() {
                String[] arrstring = (String[])new ArrayList();
                arrstring.add(this.b().c());
                kotlin.reflect.jvm.internal.impl.l.h h2 = this.c();
                if (h2 != null) {
                    StringBuilder object = new StringBuilder();
                    object.append("under-migration:");
                    object.append(h2.c());
                    arrstring.add(object.toString());
                }
                for (Map.Entry entry : this.d().entrySet()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append('@');
                    stringBuilder.append((String)entry.getKey());
                    stringBuilder.append(':');
                    stringBuilder.append(((kotlin.reflect.jvm.internal.impl.l.h)((Object)entry.getValue())).c());
                    arrstring.add(stringBuilder.toString());
                }
                if ((arrstring = ((Collection)arrstring).toArray(new String[0])) != null) {
                    return arrstring;
                }
                throw new t("null cannot be cast to non-null type kotlin.Array<T>");
            }
        });
    }

    public /* synthetic */ e(kotlin.reflect.jvm.internal.impl.l.h h2, kotlin.reflect.jvm.internal.impl.l.h h3, Map map, boolean bl2, int n2, kotlin.e.b.g g2) {
        if ((n2 & 8) != 0) {
            bl2 = true;
        }
        this(h2, h3, map, bl2);
    }

    public final boolean a() {
        return this == c;
    }

    public final kotlin.reflect.jvm.internal.impl.l.h b() {
        return this.g;
    }

    public final kotlin.reflect.jvm.internal.impl.l.h c() {
        return this.h;
    }

    public final Map<String, kotlin.reflect.jvm.internal.impl.l.h> d() {
        return this.i;
    }

    public final boolean e() {
        return this.j;
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof e) {
                boolean bl2;
                object = (e)object;
                if (j.a((Object)this.g, (Object)((e)object).g) && j.a((Object)this.h, (Object)((e)object).h) && j.a(this.i, ((e)object).i) && (bl2 = this.j == ((e)object).j)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        RuntimeException runtimeException;
        super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        throw runtimeException;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Jsr305State(global=");
        stringBuilder.append((Object)this.g);
        stringBuilder.append(", migration=");
        stringBuilder.append((Object)this.h);
        stringBuilder.append(", user=");
        stringBuilder.append(this.i);
        stringBuilder.append(", enableCompatqualCheckerFrameworkAnnotations=");
        stringBuilder.append(this.j);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.e.b.g g2) {
            this();
        }
    }

}

