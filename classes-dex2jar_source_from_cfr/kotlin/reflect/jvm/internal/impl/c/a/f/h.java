/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.f;

import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.c.a.f.g;

public final class h {
    private final g a;
    private final boolean b;

    public h(g g2, boolean bl2) {
        j.b((Object)g2, "qualifier");
        this.a = g2;
        this.b = bl2;
    }

    public /* synthetic */ h(g g2, boolean bl2, int n2, kotlin.e.b.g g3) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        this(g2, bl2);
    }

    public static /* bridge */ /* synthetic */ h a(h h2, g g2, boolean bl2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            g2 = h2.a;
        }
        if ((n2 & 2) != 0) {
            bl2 = h2.b;
        }
        return h2.a(g2, bl2);
    }

    public final g a() {
        return this.a;
    }

    public final h a(g g2, boolean bl2) {
        j.b((Object)g2, "qualifier");
        return new h(g2, bl2);
    }

    public final boolean b() {
        return this.b;
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof h) {
                boolean bl2;
                object = (h)object;
                if (j.a((Object)this.a, (Object)((h)object).a) && (bl2 = this.b == ((h)object).b)) {
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
        stringBuilder.append("NullabilityQualifierWithMigrationStatus(qualifier=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", isForWarningOnly=");
        stringBuilder.append(this.b);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

