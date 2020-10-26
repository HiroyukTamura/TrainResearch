/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.c.b;

import kotlin.e.b.g;
import kotlin.e.b.j;
import kotlin.reflect.jvm.internal.impl.a.as;
import kotlin.reflect.jvm.internal.impl.c.a.a.l;
import kotlin.reflect.jvm.internal.impl.c.a.c.b.b;

public final class a {
    private final l a;
    private final b b;
    private final boolean c;
    private final as d;

    public a(l l2, b b2, boolean bl2, as as2) {
        j.b((Object)l2, "howThisTypeIsUsed");
        j.b((Object)b2, "flexibility");
        this.a = l2;
        this.b = b2;
        this.c = bl2;
        this.d = as2;
    }

    public /* synthetic */ a(l l2, b b2, boolean bl2, as as2, int n2, g g2) {
        if ((n2 & 2) != 0) {
            b2 = b.a;
        }
        if ((n2 & 4) != 0) {
            bl2 = false;
        }
        if ((n2 & 8) != 0) {
            as2 = null;
        }
        this(l2, b2, bl2, as2);
    }

    public static /* bridge */ /* synthetic */ a a(a a2, l l2, b b2, boolean bl2, as as2, int n2, Object object) {
        if ((n2 & 1) != 0) {
            l2 = a2.a;
        }
        if ((n2 & 2) != 0) {
            b2 = a2.b;
        }
        if ((n2 & 4) != 0) {
            bl2 = a2.c;
        }
        if ((n2 & 8) != 0) {
            as2 = a2.d;
        }
        return a2.a(l2, b2, bl2, as2);
    }

    public final l a() {
        return this.a;
    }

    public final a a(l l2, b b2, boolean bl2, as as2) {
        j.b((Object)l2, "howThisTypeIsUsed");
        j.b((Object)b2, "flexibility");
        return new a(l2, b2, bl2, as2);
    }

    public final a a(b b2) {
        j.b((Object)b2, "flexibility");
        return a.a(this, null, b2, false, null, 13, null);
    }

    public final b b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public final as d() {
        return this.d;
    }

    public boolean equals(Object object) {
        if (this != object) {
            if (object instanceof a) {
                boolean bl2;
                object = (a)object;
                if (j.a((Object)this.a, (Object)((a)object).a) && j.a((Object)this.b, (Object)((a)object).b) && (bl2 = this.c == ((a)object).c) && j.a((Object)this.d, (Object)((a)object).d)) {
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
        stringBuilder.append("JavaTypeAttributes(howThisTypeIsUsed=");
        stringBuilder.append((Object)this.a);
        stringBuilder.append(", flexibility=");
        stringBuilder.append((Object)this.b);
        stringBuilder.append(", isForAnnotationParameter=");
        stringBuilder.append(this.c);
        stringBuilder.append(", upperBoundOfTypeParameter=");
        stringBuilder.append(this.d);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

