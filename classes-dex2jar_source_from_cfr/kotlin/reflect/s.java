/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect;

import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2={"Lkotlin/reflect/KVariance;", "", "(Ljava/lang/String;I)V", "INVARIANT", "IN", "OUT", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
public final class s
extends Enum<s> {
    public static final /* enum */ s a;
    public static final /* enum */ s b;
    public static final /* enum */ s c;
    private static final /* synthetic */ s[] d;

    static {
        s s2;
        s s3;
        s s4;
        a = s4 = new s();
        b = s3 = new s();
        c = s2 = new s();
        d = new s[]{s4, s3, s2};
    }

    public static s valueOf(String string2) {
        return Enum.valueOf(s.class, string2);
    }

    public static s[] values() {
        return (s[])d.clone();
    }
}

