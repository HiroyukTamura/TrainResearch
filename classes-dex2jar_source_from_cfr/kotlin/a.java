/*
 * Decompiled with CFR 0.139.
 */
package kotlin;

import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lkotlin/DeprecationLevel;", "", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "HIDDEN", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
public final class a
extends Enum<a> {
    public static final /* enum */ a a;
    public static final /* enum */ a b;
    public static final /* enum */ a c;
    private static final /* synthetic */ a[] d;

    static {
        a a2;
        a a3;
        a a4;
        a = a3 = new a();
        b = a4 = new a();
        c = a2 = new a();
        d = new a[]{a3, a4, a2};
    }

    public static a valueOf(String string2) {
        return Enum.valueOf(a.class, string2);
    }

    public static a[] values() {
        return (a[])d.clone();
    }
}

